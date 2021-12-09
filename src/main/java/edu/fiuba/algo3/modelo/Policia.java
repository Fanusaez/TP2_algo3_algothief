package edu.fiuba.algo3.modelo;

public class Policia {

    public int velocidad;
    public CiudadProductiva ciudadActual;
    public Viaje viaje;
    public Policia(CiudadProductiva unaCiudad){

        this.ciudadActual = unaCiudad;
        this.viaje = new Viaje();
        this.velocidad=900;
    }

    public void entrarAEdificio(int indice) {
        this.ciudadActual.entrarAEdificio(indice);
    }

    public int obtenerHorasDemoraAlEntrarEdificio() {
        return this.ciudadActual.obtenerHorasDemoraAlEntrarEdificio();
    }

    // Metodos de testeos ********************************************************************************

    public CiudadProductiva getCiudadActual(){
        return ciudadActual;
    }

    public int viajar(CiudadProductiva destinoSeleccionado) {
        ciudadActual=destinoSeleccionado;
        return viaje.calcularDistanciaDeViaje(ciudadActual,destinoSeleccionado)/velocidad;
    }
}