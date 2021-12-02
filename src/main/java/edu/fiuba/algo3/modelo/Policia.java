package edu.fiuba.algo3.modelo;

public class Policia {
    private String pista;
    private Ciudad ciudadActual;

    public Policia(){
        this.ciudadActual = new Ciudad();
        this.pista = "No estuvo aquí";
    }

    public String entrarAEdificio(int indice) {
        return this.ciudadActual.entrarAEdificio(indice);
    }

    public int cantidadDeEntradas() {
        return this.ciudadActual.getCantidadEntradas();
    }
}