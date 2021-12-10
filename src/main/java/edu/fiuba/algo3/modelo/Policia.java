package edu.fiuba.algo3.modelo;

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
        return this.ciudadActual.entrarAEdificio(indice);
    }

    // Metodos de testeos ********************************************************************************

    public Ciudad getCiudadActual(){
        return ciudadActual;
    }

    public int viajar(Ciudad destinoSeleccionado) {
        ciudadActual=destinoSeleccionado;
        return brujula.calcularDistanciaEntre(ciudadActual,destinoSeleccionado) / this.rango.getVelocidad();
    }

    public int getDemoraTiempoVisitar(int indice) {
        return ciudadActual.getDemoraTiempoVisitar(indice);
    }
}