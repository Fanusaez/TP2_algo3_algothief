package edu.fiuba.algo3.modelo;

public class Ciudad {
    private Integer cantidadEntradas;

    public Ciudad(){
        this.cantidadEntradas = 0;
    }

    public int entrarAEdificio() {
        // Se consulta la pista
        return 0;
    }

    public Integer getCantidadEntradas() {
        if (cantidadEntradas < 3){
            this.cantidadEntradas += 1;
        }
        return this.cantidadEntradas;
    }
}