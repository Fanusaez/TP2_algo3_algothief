package edu.fiuba.algo3.Model.CosasDelincuente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Delincuente{
    private HashMap<String,String> hashDeAtributos;  //esto se va a tener que ir
    private ArrayList<String> atributos;
    private Arma arma;
    private int largoRecorrido;
    //aca iria un enum con los indices de cada atributo

    public Delincuente() {
        this.hashDeAtributos= new HashMap<String,String>();
        this.arma = new Cuchillo();
        this.atributos = new ArrayList<String>();
    }

    public static  Delincuente crearDelincuenteParaNovato(){
        Delincuente delincuenteNuevo= new Delincuente();
        delincuenteNuevo.setLargoRecorrido(4);
        return delincuenteNuevo;
    }


    public static  Delincuente crearDelincuenteParaDetective(){
        Delincuente delincuenteNuevo= new Delincuente();
        delincuenteNuevo.setLargoRecorrido(5);
        return delincuenteNuevo;
    }

    public static  Delincuente crearDelincuenteParaInvestigador(){
        Delincuente delincuenteNuevo= new Delincuente();
        delincuenteNuevo.setArma(new Pistola());
        delincuenteNuevo.setLargoRecorrido(6);
        return delincuenteNuevo;
    }

    public static  Delincuente crearDelincuenteParaSargento(){
        Delincuente delincuenteNuevo= new Delincuente();
        delincuenteNuevo.setArma(new Pistola());
        delincuenteNuevo.setLargoRecorrido(7);
        return delincuenteNuevo;
    }

    private void setLargoRecorrido(int largo) {
        this.largoRecorrido=largo;
    }

    private void setArma(Arma arma) {
        this.arma=arma;
    }

    public void agregarDato(String clave,String valor) {    //este se va a tener que borrar porque ya se usa el agregardato2
        this.hashDeAtributos.put(clave,valor);
    }

    public String generarPista() {

        ArrayList<String> atributosLista = new ArrayList<String>();
        int randIdx = new Random().nextInt(hashDeAtributos.size()-1);

        //atributosLista.add("Thief  was " + atributosLista.get(2) + " haired");   //arreglar aca
        atributosLista.add("The thief has " + hashDeAtributos.get("Hair") + " hair");

        atributosLista.add("Thief's sex is " + hashDeAtributos.get("Sex"));
        atributosLista.add("run away with a " + hashDeAtributos.get("Auto"));
        atributosLista.add("The thief has a " + hashDeAtributos.get("Feature"));
        atributosLista.add("");

        return atributosLista.get(randIdx);

    }

    public int cantidadDeCiudadesRecorridas(){
        return largoRecorrido;
    }

    public int atacar(){
        return this.arma.atacar();
    }


    public boolean cumpleLasCaracteristicas2(ArrayList<String> listaCaracteristicas) {
        for (String valor: listaCaracteristicas){
            if(valor == ""){continue;}
            if(!atributos.contains(valor)){
                return false;
            }
        }
        return true;
    }

    public String getNombre() {
        return atributos.get(0);
    }

    public void agregarDato2(String dato) {
        atributos.add(dato);
    }

    public String getSexo() {
        return  atributos.get(1);
    }
}