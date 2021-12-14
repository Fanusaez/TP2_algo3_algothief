package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.Parser.ParserArchivo;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.dificultad.DificultadJuego;

import java.util.ArrayList;
import java.util.Random;

public class Computadora {
    private ArrayList<Delincuente> sospechosos;
    private Delincuente delincuente;
    private OrdenDeArresto ordenDeArresto;
    private Filtrador filtrador;

    public Computadora(String rutaArchivoDelincuentes, DificultadJuego dificultad){
        this.sospechosos = ParserArchivo.parsearDelincuentes(rutaArchivoDelincuentes, dificultad);
        this.ordenDeArresto = new OrdenDeArresto();
        this.filtrador = new Filtrador();

    }

    public Delincuente ObtenerDelincuenteRandom(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(sospechosos.size());
        Delincuente delincuenteRandom = sospechosos.get(randomIndex );
        //sospechosos.remove(delincuenteRandom);
        return delincuenteRandom;
    }

    public ArrayList<ArrayList<String>> mostrarOpciones(){
        return ordenDeArresto.mostrarOpcionesSeleccionadas();
    }

    //descarta sospechosos en base a los datos que se ingresaron
    public ArrayList<Delincuente> filtrar(){
        return filtrador.filtrar(ordenDeArresto.mostrarOpcionesSeleccionadas(),sospechosos);
    }


    public ArrayList<ArrayList<String>> siguienteSexo() {
        return ordenDeArresto.siguienteSex();
    }

    public ArrayList<ArrayList<String>> siguienteHobby() {
        return ordenDeArresto.siguienteHobby();
    }

    public ArrayList<ArrayList<String>> siguienteHair() {
        return ordenDeArresto.siguientePelo(); //despues arreglamos bien los nombres
    }

    public ArrayList<ArrayList<String>> siguienteFeature() {
        return ordenDeArresto.siguienteFeature();
    }

    public ArrayList<ArrayList<String>> siguienteAuto() {
        return ordenDeArresto.siguienteCar();
    }
}
