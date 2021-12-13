package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Peligrosa;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    protected ArrayList<Ciudad> ciudadesNoRecorridasPorDelincuente;
    protected ArrayList<Ciudad> ciudadesRecorridasPorDelincuente;

    public Mapa(String rutaArchivoCiudades) {
        ciudadesNoRecorridasPorDelincuente = new ArrayList<Ciudad>();
        ciudadesRecorridasPorDelincuente = new ArrayList<Ciudad>();
        parsearArchivo(rutaArchivoCiudades);
    }

    public Ciudad obtenerCiudadInicial()
    {
        return ciudadesRecorridasPorDelincuente.get(0);
    }


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

        while ( ciudadesRecorridasPorDelincuente.size() < largoRecorrido){
            int randomIndex = rand.nextInt(ciudadesNoRecorridasPorDelincuente.size() - 1);
            Ciudad ciudad = ciudadesNoRecorridasPorDelincuente.get(randomIndex);
            if(!ciudadesRecorridasPorDelincuente.contains(ciudad)) {
                ciudadesRecorridasPorDelincuente.add(ciudad);
                ciudadesNoRecorridasPorDelincuente.remove(ciudad);
            }
        }
        ciudadesRecorridasPorDelincuente.get(delincuente.cantidadDeCiudadesRecorridas()-1).setEstado(new Peligrosa(delincuente));

        for (int i = 0; i < largoRecorrido-1; i++){
            Ciudad ciudadanterior = ciudadesRecorridasPorDelincuente.get(i);
            Ciudad ciudadsiguiente = ciudadesRecorridasPorDelincuente.get(i+1);
            ciudadanterior.generarPista(ciudadsiguiente,delincuente.generarPista()); //esto le delega a edificio
        }
    }



    public void establecerOpcionesDeViaje(){
        int cantCiudadesNoRecorridas = ciudadesNoRecorridasPorDelincuente.size();
        int cantCiudadesRecorridas = ciudadesRecorridasPorDelincuente.size();

        for (int i = 0; i < cantCiudadesRecorridas - 1; i++){
            ciudadesRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesRecorridasPorDelincuente.get(i+1));
            while(ciudadesRecorridasPorDelincuente.get(i).mostrarOpcionesViaje().size() < 3) {
                int random = new Random().nextInt(cantCiudadesNoRecorridas-1);
                ciudadesRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(random));
            }
            System.out.println(ciudadesRecorridasPorDelincuente.get(i).mostrarOpcionesViaje().size());
        }

        for (int i = 0; i < cantCiudadesNoRecorridas - 1; i++){
            while (ciudadesNoRecorridasPorDelincuente.get(i).mostrarOpcionesViaje().size() < 3){
                int random = new Random().nextInt(cantCiudadesNoRecorridas-1);
                ciudadesNoRecorridasPorDelincuente.get(i).agregarComoOpcion(ciudadesNoRecorridasPorDelincuente.get(random));
            }
            System.out.println(ciudadesNoRecorridasPorDelincuente.get(i).mostrarOpcionesViaje().size());
        }
    }

    public void distribuirCiudadesRecorridasNoRecorridas ( int cantidadCiudades){

    }

    public void crearPistasCiudades (ArrayList < ArrayList < String >> listaDePistasDelincuente) {

    }

    public void inicializarCoordenadasDesdeArchivo(String pathfile){

    }

    //Metodos para tests **************************************************************************

    //solo lo usamos para test


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
}
