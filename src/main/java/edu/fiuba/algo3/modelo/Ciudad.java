package edu.fiuba.algo3.modelo;

public class Ciudad {
    private Integer cantidadEntradas;
    private ArrayList<Edificio> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    String nombre;
    String poblacion; //biblioteca
    String bandera; //aeropuerto/puerto
    String moneda; //banco
    String idioma; //¿?
    String presidente; //biblioteca
    String religion; //iglesia
    String industrias; //biblioteca
    String animales; //biblitoeca/zoologico
    String arte; // biblioteca/museo
    String misc; //¿?
    String geografia; //biblioteca
    String lugaresEmblematicos;


    public Ciudad(String nombre, String poblacion, String bandera, String moneda, String idioma, String presidente, String religion, String industrias, String animales, String arte, String misc, String geografia, String lugaresEmblematicos) {
        this.cantidadEntradas = 0;
        this.edificios = new ArrayList<Edificio>(CANTIDAD_DE_EDIFICIOS);
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.bandera = bandera;
        this.moneda = moneda;
        this.idioma = idioma;
        this.presidente = presidente;
        this.religion = religion;
        this.industrias = industrias;
        this.animales = animales;
        this.arte = arte;
        this.misc = misc;
        this.geografia = geografia;
        this.lugaresEmblematicos = lugaresEmblematicos;
        this.edificios.add(new Banco());
        this.edificios.add(new Banco());
        this.edificios.add(new Banco());
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
}