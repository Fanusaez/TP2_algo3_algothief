package edu.fiuba.algo3.modelo.fakes;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.CiudadProductiva;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.ExceptionDatoNoExistente;

import java.util.ArrayList;
import java.util.HashMap;

public class CiudadFake implements Ciudad {
    public String nombre; // <--- borrar después
    private Integer cantidadEntradas;
    private ArrayList<EdificioFake> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    private HashMap <String,String> hash;
    private ArrayList<CiudadFake> opcionesDeViaje;
    private double latitud;
    private double longitud;
    //private ArrayList<Ciudad> opcionesDeViaje;
    /*

    Map<String, String> map = new HashMap<String, String>();
    map.put("dog", "type of animal");

    */

    public CiudadFake() {
        this.cantidadEntradas = 0;
        this.edificios = new ArrayList<EdificioFake>(CANTIDAD_DE_EDIFICIOS);
        this.edificios.add(new BancoFake());
        this.edificios.add(new BibliotecaFake());
        this.edificios.add(new AeropuertoFake());
        this.hash = new HashMap<String,String>();
        this.latitud = 0;
        this.longitud = 0;
        this.opcionesDeViaje = new ArrayList<>();

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

    //Getter de atributo
    public Integer obtenerHorasDemoraAlEntrarEdificio() {
        if (cantidadEntradas < 3){
            this.cantidadEntradas += 1;
        }
        return this.cantidadEntradas;
    }


    public void generarPista(CiudadFake ciudadsiguiente, String pistaDelincuente) {
        edificios.get(0).generarPistaEdificio(ciudadsiguiente,pistaDelincuente);
        edificios.get(1).generarPistaEdificio(ciudadsiguiente,pistaDelincuente);
        edificios.get(2).generarPistaEdificio(ciudadsiguiente,pistaDelincuente);
    }

    //Getter de atributo
    public double getLatitud() {
        return latitud;
    }

    //Getter de atributo
    public double getLongitud() {
        return longitud;
    }

    @Override
    public void agregarComoOpcion(CiudadProductiva destino) {

    }

    public void agregarComoOpcion(CiudadFake destino) {
        if (this.opcionesDeViaje.contains(destino) || this == destino){
            return;
        }
        this.opcionesDeViaje.add(destino);
        //System.out.println(this.obtenerDato("City"));
        destino.agregarComoOpcion(this);
        //System.out.println(destino.obtenerDato("City"));
    }

    //Este es un getter de un atributo
    public ArrayList<Ciudad> mostrarOpcionesViaje() {
        return this.opcionesDeViaje;
    }
    public int ataques(){
        return 0;
    }
}

