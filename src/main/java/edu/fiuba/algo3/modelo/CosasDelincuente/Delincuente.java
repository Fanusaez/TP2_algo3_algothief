package edu.fiuba.algo3.modelo.CosasDelincuente;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.ExceptionDatoNoExistente;
import edu.fiuba.algo3.modelo.Parseable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Delincuente{
    private Integer cantidadEntradas;
    private ArrayList<Edificio> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    private HashMap<String,String> hashDeAtributos;
    private Arma arma;

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
        else{
            claveCorregida=clave.toUpperCase();
        }

        String dato = this.hashDeAtributos.get(claveCorregida);

        if (dato == null){
            throw new ExceptionDatoNoExistente();
        }
        return dato;
    }

    public String generarPista() {

        ArrayList<String> atributosLista = new ArrayList<String>();
        int randIdx = new Random().nextInt(hashDeAtributos.size()-1);

        atributosLista.add("Tiene pelo de color " + hashDeAtributos.get("Hair"));
        atributosLista.add("El delincuente era " + hashDeAtributos.get("Sex"));
        atributosLista.add("Y vi a ese delincuente irse con un auto " + hashDeAtributos.get("Auto"));
        atributosLista.add("Tenia un " + hashDeAtributos.get("Feature"));
        atributosLista.add("");

        return atributosLista.get(randIdx);

    }

    public int cantidadDeCiudadesRecorridas(){
        return 4;
    }

    public int atacar(){
        return this.arma.atacar();
    }

}