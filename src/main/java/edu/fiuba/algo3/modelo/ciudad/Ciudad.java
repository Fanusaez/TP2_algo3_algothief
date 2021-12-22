package edu.fiuba.algo3.modelo.ciudad;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.Edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Biblioteca;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.Excepciones.ExceptionDatoNoExistente;
import edu.fiuba.algo3.modelo.computadora.Computadora;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Ciudad{
    public String nombre; // <--- borrar después
    private ArrayList<Edificio> edificios;
    public static final int CANTIDAD_DE_EDIFICIOS = 3;
    private HashMap <String,String> hash;
    private ArrayList<Ciudad> opcionesDeViaje;
    private EstadoCiudad estado;



    public Ciudad() {
        this.edificios = new ArrayList<Edificio>(CANTIDAD_DE_EDIFICIOS);
        this.edificios.add(new Banco());
        this.edificios.add(new Biblioteca());
        this.edificios.add(new Aeropuerto());
        this.hash = new HashMap<String,String>();
        this.opcionesDeViaje = new ArrayList<>();
        this.estado= new Segura();
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

        String dato = this.hash.get(claveCorregida);
        if (dato == null){
            throw new ExceptionDatoNoExistente();
        }

        return dato;
    }

    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora){
        return estado.modificarEstadoDeJuego(computadora);
    }

    public String entrarAEdificio(int indice){
        return this.estado.entrarAEdificio(edificios.get(indice)); //?
    }

    public void generarPista(Ciudad ciudadsiguiente, Delincuente delincuente) {
        edificios.get(0).generarPistaEdificio(ciudadsiguiente,delincuente);
        edificios.get(1).generarPistaEdificio(ciudadsiguiente,delincuente);
        edificios.get(2).generarPistaEdificio(ciudadsiguiente,delincuente);
    }

    public void agregarComoOpcion(Ciudad destino) {
        if(!opcionesDeViaje.contains(destino)){this.opcionesDeViaje.add(destino);}
    }

    public ArrayList<Ciudad> mostrarOpcionesViaje() {
        return this.opcionesDeViaje;
    }

    public int getDemoraTiempoVisitar(int indice) {
        return edificios.get(indice).visitar() + estado.atacar();
    }

    public void setEstado(EstadoCiudad unEstado) {
        this.estado = unEstado;
    }

    public String obtenerInformacionCiudad() {
        return obtenerDato("Description");
    }
}

