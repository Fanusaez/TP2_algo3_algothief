package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.computadora.Computadora;

import java.util.ArrayList;

public class Policia {

    public Rango rango;
    public int cantidadArrestos;
    public Ciudad ciudadActual;
    public Brujula brujula;


    public Policia(Ciudad unaCiudad){

        this.rango = new RangoNovato();
        this.cantidadArrestos = 0;
        this.ciudadActual = unaCiudad;
        this.brujula = new Brujula();
    }

    public String entrarABanco() {return this.ciudadActual.entrarABanco();}
    public String entrarAAeropuerto() {
        return this.ciudadActual.entrarAAeropuerto();
    }
    public String entrarABiblioteca() {
        return this.ciudadActual.entrarABiblioteca();
    }

    public Ciudad getCiudadActual(){
        return ciudadActual;
    }

    public int viajar(Ciudad destinoSeleccionado) {
        destinoSeleccionado.agregarComoOpcion(ciudadActual);
        ciudadActual=destinoSeleccionado;
        return brujula.calcularDistanciaEntre(ciudadActual,destinoSeleccionado) / this.rango.getVelocidad();
    }

    public int getDemoraTiempoVisitarBanco() {
        return ciudadActual.getDemoraTiempoVisitarBanco();
    }

    public int getDemoraTiempoVisitarAeropuerto() {
        return ciudadActual.getDemoraTiempoVisitarAeropuerto();
    }

    public int getDemoraTiempoVisitarBiblioteca() {
        return ciudadActual.getDemoraTiempoVisitarBiblioteca();
    }

    public ArrayList<Ciudad> mostrarOpcionesViaje() {
        return ciudadActual.mostrarOpcionesViaje();
    }

    public void realizarArresto() {
        cantidadArrestos += 1;
        this.rango = rango.ascender(cantidadArrestos);
    }

    public String ciudadActual() {
        return ciudadActual.obtenerDato("city");
    }

    public String obtenerInformacionCiudad() {
       return ciudadActual.obtenerInformacionCiudad();
    }

    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora) {
        return ciudadActual.modificarEstadoDeJuego(computadora);
    }
}