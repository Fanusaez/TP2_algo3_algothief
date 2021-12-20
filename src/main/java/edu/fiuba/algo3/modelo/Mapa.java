package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Parser.ParserArchivo;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Peligrosa;

import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    protected ArrayList<Ciudad> ciudadesNoRecorridasPorDelincuente;
    protected ArrayList<Ciudad> ciudadesRecorridasPorDelincuente;


    public Mapa(String rutaArchivoCiudades) {
        ciudadesNoRecorridasPorDelincuente = ParserArchivo.parsearArchivoCiudades(rutaArchivoCiudades);
        ciudadesRecorridasPorDelincuente = new ArrayList<Ciudad>();

    }

    public Ciudad obtenerCiudadInicial()
    {
        return ciudadesRecorridasPorDelincuente.get(0);
    }


    public void establecerPistasEnElRecorrido(Delincuente delincuente) {
        int largoRecorrido = delincuente.cantidadDeCiudadesRecorridas();
        Random rand = new Random();

        while ( ciudadesRecorridasPorDelincuente.size() < largoRecorrido){
            int randomIndex = rand.nextInt(ciudadesNoRecorridasPorDelincuente.size() - 1);
            Ciudad ciudad = ciudadesNoRecorridasPorDelincuente.get(randomIndex);
            if(!ciudadesRecorridasPorDelincuente.contains(ciudad)) {
                ciudadesRecorridasPorDelincuente.add(ciudad);
                ciudadesNoRecorridasPorDelincuente.remove(ciudad);
            }
        }

        Ciudad ultimaCiudadDelincuente = ciudadesRecorridasPorDelincuente.get(delincuente.cantidadDeCiudadesRecorridas()-1);
        ultimaCiudadDelincuente.setEstado(new Peligrosa(delincuente));

        for (int i = 0; i < largoRecorrido-1; i++){
            Ciudad ciudadanterior = ciudadesRecorridasPorDelincuente.get(i);
            Ciudad ciudadsiguiente = ciudadesRecorridasPorDelincuente.get(i+1);
            ciudadanterior.generarPista(ciudadsiguiente,delincuente); //esto le delega a edificio
        }
    }

    public void establecerOpcionesDeViaje(){
        int cantCiudadesNoRecorridas = ciudadesNoRecorridasPorDelincuente.size();
        int cantCiudadesRecorridas = ciudadesRecorridasPorDelincuente.size();


        for (int i = 0; i < cantCiudadesRecorridas - 1; i++){
            //Agrego como opcion a la próxima ciudad
            ciudadesRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesRecorridasPorDelincuente.get(i+1));
            //Agrego como c
            while(ciudadesRecorridasPorDelincuente.get(i).mostrarOpcionesViaje().size() < 2) {
                int random = new Random().nextInt(cantCiudadesNoRecorridas-1);
                ciudadesRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(random));
            }

        }
        while (ciudadesRecorridasPorDelincuente.get(0).mostrarOpcionesViaje().size() <3) {
            ciudadesRecorridasPorDelincuente.get(0).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(new Random().nextInt(cantCiudadesNoRecorridas - 1)));
        }

        ciudadesRecorridasPorDelincuente.get(cantCiudadesRecorridas - 1).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(new Random().nextInt(cantCiudadesNoRecorridas - 1)));
        ciudadesRecorridasPorDelincuente.get(cantCiudadesRecorridas - 1).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(new Random().nextInt(cantCiudadesNoRecorridas - 1)));

        for (int i = 0; i < cantCiudadesNoRecorridas ; i++){
            while (ciudadesNoRecorridasPorDelincuente.get(i).mostrarOpcionesViaje().size() < 2){
                int random = new Random().nextInt(cantCiudadesNoRecorridas-1);
                ciudadesNoRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(random));
            }

        }

    }
}



