package edu.fiuba.algo3.Model.CosasDelincuente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Delincuente{
    private ArrayList<String> atributos;
    private Arma arma;
    private int largoRecorrido;
    enum INDICES {
        NOMBRE,
        SEXO,
        HOBBY,
        HAIR,
        FEATURE,
        AUTO
    }

    public Delincuente() {
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

    public String generarPista() {

        ArrayList<String> posiblesPistas = new ArrayList<String>();

        posiblesPistas.add("The thief has " + atributos.get(INDICES.HAIR.ordinal()) + " hair");
        posiblesPistas.add("The thief mention that likes " + atributos.get(INDICES.HOBBY.ordinal()));
        posiblesPistas.add("Thief's sex is " + atributos.get(INDICES.SEXO.ordinal()));
        posiblesPistas.add("run away with a " + atributos.get(INDICES.AUTO.ordinal()));
        posiblesPistas.add("The thief has a " + atributos.get(INDICES.FEATURE.ordinal()));
        posiblesPistas.add("");
        posiblesPistas.add("");
        posiblesPistas.add("");
        posiblesPistas.add("");
        posiblesPistas.add("");

        int randIdx = new Random().nextInt(posiblesPistas.size()-1);
        return posiblesPistas.get(randIdx);


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
        return atributos.get(INDICES.NOMBRE.ordinal());
    }

    public void agregarDato(String dato) {
        atributos.add(dato);
    }

    public String getSexo() {
        return  atributos.get(INDICES.SEXO.ordinal());
    }
}