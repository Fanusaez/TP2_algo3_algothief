package edu.fiuba.algo3.Model;
import edu.fiuba.algo3.Model.Parser.ParserArchivo;
import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.Model.ciudad.Ciudad;
import edu.fiuba.algo3.Model.ciudad.Peligrosa;

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

    public void establecerCaminoDelincuente(int cantCiudadesNoRecorridas, int cantCiudadesRecorridas){
        for (int i = 0; i < cantCiudadesRecorridas - 1; i++){
            //Agrego como opcion a la próxima ciudad
            Ciudad ciudadIterada = ciudadesRecorridasPorDelincuente.get(i);
            Ciudad proximaCiudad = ciudadesRecorridasPorDelincuente.get(i+1);
            ciudadIterada.agregarComoOpcion(proximaCiudad);

            int cantidadOpcionesViaje = ciudadIterada.mostrarOpcionesViaje().size();

            while(cantidadOpcionesViaje < 2) {
                int random = new Random().nextInt(cantCiudadesNoRecorridas-1);
                Ciudad ciudadRandom = ciudadesNoRecorridasPorDelincuente.get(random);
                ciudadIterada.agregarComoOpcion(ciudadRandom);
                cantidadOpcionesViaje = ciudadIterada.mostrarOpcionesViaje().size();
            }
        }
    }

    public void rellenarPrimeraYUltimaCiudadConOpciones(int cantCiudadesNoRecorridas, int cantCiudadesRecorridas){
        Ciudad primeraCiudadDelincuente = ciudadesRecorridasPorDelincuente.get(0);
        int cantOpcionesViajePrimeraCiudad = primeraCiudadDelincuente.mostrarOpcionesViaje().size();
        while(cantOpcionesViajePrimeraCiudad < 3){
            int random = new Random().nextInt(cantCiudadesNoRecorridas-1);
            Ciudad ciudadRandom = ciudadesNoRecorridasPorDelincuente.get(random);
            primeraCiudadDelincuente.agregarComoOpcion(ciudadRandom);
            cantOpcionesViajePrimeraCiudad = primeraCiudadDelincuente.mostrarOpcionesViaje().size();
        }

        //####################################################
        //Agrego opciones viaje para última ciudad delincuente
        //Reminder: Cuando se viaja a una ciudad, esta ciudad va a tener como opcion de viaje agregado a la ciudad
        //anterior.
        //####################################################
        Ciudad ultimaCiudad = ciudadesRecorridasPorDelincuente.get(cantCiudadesRecorridas - 1);
        int cantOpcionesViajeUltimaCiudad = ultimaCiudad.mostrarOpcionesViaje().size();
        while(cantOpcionesViajeUltimaCiudad < 2){
            int random1 = new Random().nextInt(cantCiudadesNoRecorridas-1);
            Ciudad ciudadRandom = ciudadesNoRecorridasPorDelincuente.get(random1);
            ultimaCiudad.agregarComoOpcion(ciudadRandom);
            cantOpcionesViajeUltimaCiudad = ultimaCiudad.mostrarOpcionesViaje().size();
        }

    }

}


