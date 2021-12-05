package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Delincuente {
    private Integer cantidadEntradas;
    private ArrayList<Edificio> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    private HashMap<String,String> hashDeAtributos;

    /*
    Map<String, String> map = new HashMap<String, String>();
    map.put("dog", "type of animal");
    */

    public Delincuente() {
        this.hashDeAtributos= new HashMap<String,String>();
    }


    //{Clave:valor} ---> {Pelo: Rubio}
    public void agregarDato(String clave,String valor) {
        this.hashDeAtributos.put(clave,valor);
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

    public String generarPista() {
        //se obtiene un atributo random
        //tenes que hacer 5 if's para ver que tipo de texto mostrar
        /*
            if tipoDeAtributoRandom.equals("hair"){
                return "Tiene pelo de color" + hashMap.get(tipoDeAtributoRandom);

           String atributoRandom = hashDeAtributos.Random();
           if(atributoRandom == " "){

           }elseif(atributoRandom =={
           }
        */

        String pista = "Tenia un auto convertible";
        return pista;
    }

    public int cantidadDeCiudadesRecorridas(){
        return 4;
    }
}