package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Delincuente {
    private Integer cantidadEntradas;
    private ArrayList<Edificio> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    private HashMap<String,String> hash;

    /*

    Map<String, String> map = new HashMap<String, String>();
    map.put("dog", "type of animal");

    */

    public Delincuente() {
        this.hash= new HashMap<String,String>();
    }


    public void agregarDato(String clave,String valor) {
        this.hash.put(clave,valor);
    }

    public String obtenerDato(String clave){
        String claveCorregida;
        if (clave.length() >= 2 ) {
            claveCorregida = clave.substring(0, 1).toUpperCase() + clave.substring(1);
        }
        else{claveCorregida=clave.toUpperCase();}

        String ciudad = this.hash.get(claveCorregida);
        if (ciudad == null){
            throw new ExceptionDatoNoExistente();
        }

        return ciudad;
    }





    public void generarPista() {
    }
}