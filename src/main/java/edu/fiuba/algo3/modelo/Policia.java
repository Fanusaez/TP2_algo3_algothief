package edu.fiuba.algo3.modelo;

public class Policia {

    public int velocidad;
    public Ciudad ciudadActual;
    public Viaje viaje;
    public Policia(Ciudad unaCiudad){

        this.ciudadActual = unaCiudad;
        this.viaje = new Viaje();
        this.velocidad=900;
    }

    public String entrarAEdificio(int indice) {
        return this.ciudadActual.entrarAEdificio(indice);
    }

    public int cantidadDeEntradas() {
        return this.ciudadActual.getCantidadEntradas();
    }

    // Metodos de testeos ********************************************************************************

    public Ciudad getCiudadActual(){
        return ciudadActual;
    }

    public int viajar(Ciudad destinoSeleccionado) {
        ciudadActual=destinoSeleccionado;
        return viaje.calcularDistanciaDeViaje(ciudadActual,destinoSeleccionado)/velocidad;
    }
}