package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.util.ArrayList;
import java.util.HashMap;

public class Computadora {
    private ArrayList<Delincuente> delincuentes;
    private HashMap<String, String> datosPosibleDelincuente;

    public Computadora(ArrayList<Delincuente> delincuentes){
        this.delincuentes = delincuentes;

    }
    public void ingresarDatoDelincuente(String caracteristica, String tipo){

    }

    public ArrayList<Delincuente> buscarSospechoso(){ //descarta sospechosos en base a los datos que se ingresaron

    }
}
