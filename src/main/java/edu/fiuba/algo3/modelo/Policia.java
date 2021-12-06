package edu.fiuba.algo3.modelo;

public class Policia {
    private String pista;
    public Ciudad ciudadActual;

    public Policia(Ciudad unaCiudad){
        this.ciudadActual = unaCiudad;
        this.pista = "No estuvo aquí";
        //ciudadActual.CANTIDAD_DE_EDIFICIOS
    }

    public String entrarAEdificio(int indice) {
        return this.ciudadActual.entrarAEdificio(indice);
    }

    public int cantidadDeEntradas() {
        return this.ciudadActual.getCantidadEntradas();
    }
}