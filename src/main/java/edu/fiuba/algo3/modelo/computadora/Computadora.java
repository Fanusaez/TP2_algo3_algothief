package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.computadora.Filtrador;
import edu.fiuba.algo3.modelo.computadora.OrdenDeArresto;

import java.util.ArrayList;
import java.util.HashMap;

public class Computadora {
    private ArrayList<Delincuente> sospechosos;
    private Delincuente delincuente;
    private HashMap<String, String> datosPosibleDelincuente;
    private OrdenDeArresto ordenDeArresto;
    private Filtrador filtrador;

    public Computadora(ArrayList<Delincuente> delincuentes){
        this.sospechosos = delincuentes;
        this.ordenDeArresto = new OrdenDeArresto();
        this.filtrador = new Filtrador();

    }
    public void ingresarDatoDelincuente(String caracteristica, String tipo){

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
