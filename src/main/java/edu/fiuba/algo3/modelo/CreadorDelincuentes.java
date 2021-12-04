package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CreadorDelincuentes {
    private Delincuente delincuenteSeleccionado;
    private ArrayList<Delincuente> sospechosos;

    public CreadorDelincuentes (String rutaArchivoDelincuentes) {
        sospechosos = new ArrayList<Delincuente>();
        parsearArchivo(rutaArchivoDelincuentes);
        seleccionarDelincuenteAleatorio();
    }

    public void parsearArchivo(String rutaArchivoCiudadesDelincuentes){
        String fileName = rutaArchivoCiudadesDelincuentes;

        // This will reference one line at a time
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Delincuente delincuente = new Delincuente();
            while (!bufferedReader.readLine().equals("*******************************************************************************")) {
                continue;}

            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                if (line.equals("...............................................................................")) {
                    this.sospechosos.add(delincuente);
                    delincuente = new Delincuente();
                    continue;
                }

                if (line.equals("*******************************************************************************")) {
                    break;
                }

                //System.out.println(line.split(":")[1].trim());
                String clave = line.split(":")[0];
                String dato = line.split(":")[1].trim();
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


    }

    public Delincuente ObtenerDelincuente(){
        return delincuenteSeleccionado;
    }


    public void seleccionarDelincuenteAleatorio(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(sospechosos.size());
        Delincuente delincuenteRandom = sospechosos.get(randomIndex);
        delincuenteSeleccionado=delincuenteRandom;
        sospechosos.remove(delincuenteRandom);

    }





}