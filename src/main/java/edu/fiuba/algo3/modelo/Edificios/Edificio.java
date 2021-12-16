package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public abstract class Edificio {

    int cantidadEntradas;
    String pista;

    {
        pista = "El delincuente no visito este edificio";
        cantidadEntradas = 0;
    }

    public String mostrarPista() {
        return pista;
    }

    public abstract void generarPistaEdificio(Ciudad unaCiudad, String laPista);

    public int visitar(){
        if (cantidadEntradas < 3){
            this.cantidadEntradas += 1;
        }
        return this.cantidadEntradas;
    }
}
