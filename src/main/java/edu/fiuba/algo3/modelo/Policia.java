package edu.fiuba.algo3.modelo;

public class Policia {
    private String pista;
    private Ciudad ciudadActual;

    public Policia(){
        this.ciudadActual = new Ciudad();
        this.pista = "No estuvo aquí";
    }

    public int entrarAEdificio() {
        //System.out.println(this.pista);

        return this.ciudadActual.entrarAEdificio();
    }

    public int cantidadDeEntradas() {
        return this.ciudadActual.getCantidadEntradas();
    }
}