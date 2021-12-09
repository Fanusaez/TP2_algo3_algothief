package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Pista {

    private String pista;

    public Pista(String pista) {
        this.pista = pista;
    }

    public Pista(HashMap<String,String> hashDeAtributos){
        ArrayList<String> atributosLista = new ArrayList<String>();
        int randIdx = new Random().nextInt(hashDeAtributos.size()-1);

        atributosLista.add("Tiene pelo de color " + hashDeAtributos.get("Hair"));
        atributosLista.add("El delincuente era " + hashDeAtributos.get("Sex"));
        atributosLista.add("Y vi a ese delincuente irse con un auto " + hashDeAtributos.get("Auto"));
        atributosLista.add("Tenia un " + hashDeAtributos.get("Feature"));
        atributosLista.add("");
        this.pista = atributosLista.get(randIdx);
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public void mostrarPista(){
        System.out.println(pista);
    }


}
