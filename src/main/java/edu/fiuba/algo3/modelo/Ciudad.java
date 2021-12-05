package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Ciudad {
    private Integer cantidadEntradas;
    private ArrayList<Edificio> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    private HashMap <String,String> hash;

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
}
