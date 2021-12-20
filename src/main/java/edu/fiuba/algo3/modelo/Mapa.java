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

        establecerCaminoDelincuente(cantCiudadesNoRecorridas, cantCiudadesRecorridas);
        rellenarPrimeraYUltimaCiudadConOpciones(cantCiudadesNoRecorridas, cantCiudadesRecorridas);

        for (int i = 0; i < cantCiudadesNoRecorridas ; i++){
            Ciudad ciudadIteradaNoRecorrida = ciudadesNoRecorridasPorDelincuente.get(i);
            int cantidadOpcionesViaje = ciudadIteradaNoRecorrida.mostrarOpcionesViaje().size();
            while(cantidadOpcionesViaje < 2){
                int random = new Random().nextInt(cantCiudadesNoRecorridas-1);
                Ciudad ciudadRandom = ciudadesNoRecorridasPorDelincuente.get(random);
                ciudadIteradaNoRecorrida.agregarComoOpcion(ciudadRandom);
                cantidadOpcionesViaje = ciudadIteradaNoRecorrida.mostrarOpcionesViaje().size();
            }
        }

    }
}



