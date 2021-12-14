package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

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

    public String entrarAEdificio(int indice) {
        return this.ciudadActual.entrarAEdificio(indice);}

    public Ciudad getCiudadActual(){
        return ciudadActual;
    }

    public int viajar(Ciudad destinoSeleccionado) {
        destinoSeleccionado.agregarComoOpcion(ciudadActual);
        ciudadActual=destinoSeleccionado;
        return brujula.calcularDistanciaEntre(ciudadActual,destinoSeleccionado) / this.rango.getVelocidad();
    }

    public int getDemoraTiempoVisitar(int indice) {
        return ciudadActual.getDemoraTiempoVisitar(indice);
    }

    public ArrayList<Ciudad> mostrarOpcionesViaje() {
        return ciudadActual.mostrarOpcionesViaje();
    }

    public void realizarArresto() {
        cantidadArrestos += 1;
        this.rango = rango.ascender(cantidadArrestos);
    }


}