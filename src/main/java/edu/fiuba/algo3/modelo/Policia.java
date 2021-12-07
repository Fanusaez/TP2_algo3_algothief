package edu.fiuba.algo3.modelo;

public class Policia {

    public Ciudad ciudadActual;

    public Policia(Ciudad unaCiudad){
        this.ciudadActual = unaCiudad;
    }

    public String entrarAEdificio(int indice) {
        return this.ciudadActual.entrarAEdificio(indice);
    }

    public int cantidadDeEntradas() {
        return this.ciudadActual.getCantidadEntradas();
    }

    public void actualizarCiudadActual(Ciudad nuevaCiudadActual){
        this.ciudadActual = nuevaCiudadActual;
    }



    // Metodos de testeos ********************************************************************************

    public void setearCiudad(Ciudad ciudad){
        this.ciudadActual = ciudad;
    }

    public Ciudad getCiudadActual(){
        return ciudadActual;
    }

}