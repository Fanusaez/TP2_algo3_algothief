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

//public class ParserArchivo {
//
//    public static void parsearArchivo(String rutaArchivo, ArrayList<Object> listado, Method objectConstructor) {
//        String fileName = rutaArchivo;
//
//        // This will reference one line at a time
//        String line = null;
//
//        try {
//            FileReader fileReader = new FileReader(fileName);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            ObjetoParseable object = new ObjetoParseable();
//            try {
//                objectConstructor.invoke(object, null);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            while (!bufferedReader.readLine().equals("*******************************************************************************")) {
//                continue;
//            }
//
//            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
//                if (line.equals("...............................................................................")) {
//                    listado.add(object);
//                    object = new ObjetoParseable();
//                    try {
//                        objectConstructor.invoke(object, null);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                    continue;
//                }
//
//                if (line.equals("*******************************************************************************")) {
//                    break;
//                }
//
//                String[] lineaSpliteada = line.split(":");
//                String clave = lineaSpliteada[0];
//                String dato = lineaSpliteada[1].trim();
//                object.agregarDato(clave, dato);
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Unable to open file '" + fileName + "'");
//        } catch (IOException ex) {
//            System.out.println("Error reading file '" + fileName + "'");
//        }
//
//    }
//}

