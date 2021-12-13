package edu.fiuba.algo3.modelo.CosasAImplementar;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ParserArchivo {

    public static ArrayList<Delincuente> parsearDelincuentes(String rutaArchivoDelincuentes){
        ArrayList<Delincuente> sospechosos = new ArrayList<Delincuente>();
        String fileName = rutaArchivoDelincuentes;

        // This will reference one line at a time
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Delincuente delincuente = new Delincuente();

            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                if (line.equals("...............................................................................")) {
                    sospechosos.add(delincuente);
                    delincuente = new Delincuente();
                    continue;
                }

                String[] lineaSpliteada = line.split(":");
                String clave= lineaSpliteada[0];
                String dato = lineaSpliteada[1].trim();
                delincuente.agregarDato(clave, dato);
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
        return sospechosos;
    }

    public static ArrayList<Ciudad> parsearArchivoCiudades(String rutaArchivoCiudades){
         ArrayList<Ciudad> ciudadesNoRecorridasPorDelincuente = new ArrayList<Ciudad>();
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
                    ciudadesNoRecorridasPorDelincuente.add(ciudad);
                    ciudad = new Ciudad(); //?
                    continue;
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
        return ciudadesNoRecorridasPorDelincuente;
    }


}

