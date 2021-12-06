package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    private ArrayList<Ciudad> ciudadesNoRecorridasPorDelincuente;
    private ArrayList<Ciudad> ciudadesRecorridasPorDelincuente;
    private int contador;

    public Mapa(String rutaArchivoCiudades) {
        ciudadesNoRecorridasPorDelincuente = new ArrayList<Ciudad>();
        ciudadesRecorridasPorDelincuente = new ArrayList<Ciudad>();
        parsearArchivo(rutaArchivoCiudades);
        EstablecerOpcionesDeViaje();
        //inicializarCoordenadasDesdeArchivo(rutaArchivoCoordenadas);
        //EstablecerPistasEnElRecorrido(Delincuente delincuente);
    }

    public Ciudad obtenerCiudadInicial()
    {
        return ciudadesRecorridasPorDelincuente.get(0);
    }
/*
    public Ciudad obtenerCiudadEspecifica(String nombre) {
        for (Ciudad ciudad : ciudadesRecorridasPorDelincuente) {
            if (ciudad.obtenerDato("City").equals(nombre)) {
                return ciudad;
            }
        }

        for (Ciudad ciudadNoRecorrida : ciudadesNoRecorridasPorDelincuente) {
            if (ciudadNoRecorrida.obtenerDato("city").equals(nombre)) {
                return ciudadNoRecorrida;
            }
        }
        throw new ExceptionCiudadNoExistente();
    }
*/
    public void parsearArchivo(String rutaArchivoCiudades) {
        // The name of the file to open.
        String fileName = rutaArchivoCiudades;

        // This will reference one line at a time
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            Ciudad ciudad = new Ciudad();
            while ((line = bufferedReader.readLine()) != null && !line.equals(""))
            {
                if (line.equals("...............................................................................")) {
                    this.ciudadesNoRecorridasPorDelincuente.add(ciudad);
                    ciudad = new Ciudad(); //?
                    continue;
                }

                if (line.equals("*******************************************************************************")) {
                    break;

                }

                String[] lineaSpliteada = line.split(":");
                String clave= lineaSpliteada[0];
                String dato = lineaSpliteada[1].trim();
                ciudad.agregarDato(clave, dato);
            }
            bufferedReader.close();
        }
            catch(FileNotFoundException ex){
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            }
            catch(IOException ex){
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }


    }
    public void EstablecerPistasEnElRecorrido (Delincuente delincuente) {
        int largoRecorrido = delincuente.cantidadDeCiudadesRecorridas();
        Random rand = new Random();
        int randomIndex = rand.nextInt(largoRecorrido);
        for (int i = 0; i < largoRecorrido; i++){
            ciudadesRecorridasPorDelincuente.add(ciudadesNoRecorridasPorDelincuente.get(randomIndex));
        }

        //por cada ciudad[i], acceder a edificio[j]

        for (int i = 0; i < largoRecorrido-1; i++){
            Ciudad ciudadanterior = ciudadesRecorridasPorDelincuente.get(i);
            Ciudad ciudadsiguiente = ciudadesRecorridasPorDelincuente.get(i+1);
            ciudadanterior.generarPista(ciudadsiguiente,delincuente.generarPista()); //esto le delega a edificio
        }
    }


    public ArrayList<Ciudad> mostrarOpcionesViaje (Ciudad ciudad) {
        return ciudad.mostrarOpcionesViaje();
    }

    public void EstablecerOpcionesDeViaje(){
        for (int i=0;i<ciudadesNoRecorridasPorDelincuente.size()-1;i++){
            int random = new Random().nextInt(ciudadesNoRecorridasPorDelincuente.size()-1);
            int otroRandom = new Random().nextInt(ciudadesNoRecorridasPorDelincuente.size()-1);
            ciudadesNoRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(i+1));
            ciudadesNoRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(random));
            ciudadesNoRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(otroRandom));
        }
    }

    public void distribuirCiudadesRecorridasNoRecorridas ( int cantidadCiudades){

    }

    public void crearPistasCiudades (ArrayList < ArrayList < String >> listaDePistasDelincuente) {


    }

    public void inicializarCoordenadasDesdeArchivo(String pathfile){

    }
}
