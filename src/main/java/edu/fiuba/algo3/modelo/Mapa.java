package edu.fiuba.algo3.modelo;
import java.io.*;
import java.util.ArrayList;

public class Mapa {
    private ArrayList<Ciudad> ciudadesNoRecorridasPorDelincuente;
    private ArrayList<Ciudad> ciudadesRecorridasPorDelincuente;

    public Mapa(String rutaArchivoCiudades){
        this.ciudadesNoRecorridasPorDelincuente = parsearArchivo(rutaArchivoCiudades);
    }
    
    public static ArrayList<Ciudad> parsearArchivo(String rutaArchivoCiudades){

        // The name of the file to open.
        String fileName = rutaArchivoCiudades;

        // This will reference one line at a time
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                if (line.equals("...............................................................................") ){
                    continue;
                }

                System.out.println(line.split(":")[1]);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        return new ArrayList<Ciudad>();
    }

    public void mostrarOpcionesViaje(){

    }

    /*public ArrayList<Ciudad> crearCiudades(String nombreArchivo){

    }*/

    public void  distribuirCiudadesRecorridasNoRecorridas(int cantidadCiudades){

    }

    public void crearPistasCiudades(ArrayList<ArrayList<String>> listaDePistasDelincuente ){

    }
}
