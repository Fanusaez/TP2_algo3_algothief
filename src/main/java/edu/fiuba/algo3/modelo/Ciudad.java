package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.ExceptionDatoNoExistente;

import java.util.ArrayList;
import java.util.HashMap;

public class Ciudad {
    private Integer cantidadEntradas;
    private ArrayList<Edificio> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    private HashMap <String,String> hash;
    private ArrayList<Ciudad> opcionesDeViaje;
    private double latitud;
    private double longitud;

    /*

    Map<String, String> map = new HashMap<String, String>();
    map.put("dog", "type of animal");

    */

    public Ciudad() {
        this.cantidadEntradas = 0;
        this.edificios = new ArrayList<Edificio>(CANTIDAD_DE_EDIFICIOS);
        this.edificios.add(new Aeropuerto());
        this.edificios.add(new Aeropuerto());
        this.edificios.add(new Aeropuerto());
        this.hash = new HashMap<String,String>();
        this.latitud = 0;
        this.longitud = 0;

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

    public String entrarAEdificio(int indice) {
        return edificios.get(indice).mostrarPista();
        //return "El delincuente no visito este edificio";
    }

    public Integer getCantidadEntradas() {
        if (cantidadEntradas < 3){
            this.cantidadEntradas += 1;
        }
        return this.cantidadEntradas;
    }

    public void generarPista(Ciudad ciudadsiguiente, String pistaDelincuente) {
        edificios.get(0).generarPistaEdificio(ciudadsiguiente,pistaDelincuente);
        edificios.get(1).generarPistaEdificio(ciudadsiguiente,pistaDelincuente);
        edificios.get(2).generarPistaEdificio(ciudadsiguiente,pistaDelincuente);
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void agregarComoOpcion( Ciudad destino) {
       //if (opcionesDeViaje.contains(destino) || opcionesDeViaje.contains(this) || this == destino){
       //    return;
       //}
        this.opcionesDeViaje.add(destino);
        destino.agregarComoOpcion(this); //aca seteas en destino
    }


    public ArrayList<Ciudad> mostrarOpcionesViaje() {
        return this.opcionesDeViaje;
    }
}
