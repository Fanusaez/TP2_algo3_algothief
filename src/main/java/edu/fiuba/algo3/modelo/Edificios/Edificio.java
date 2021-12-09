package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public abstract class Edificio {

    int cantidadEntradas;
    String pistaDefault;
    String pistaPropia;

    {
        pistaDefault = "El delincuente no visito este edificio";
        cantidadEntradas = 0;
    }

    public String mostrarPista() {
        return pistaPropia;
    }

    public abstract void generarPistaEdificio(Ciudad unaCiudad, String laPista);

    public int getDemoraTiempoVisitar(){
        if (cantidadEntradas < 3){
            this.cantidadEntradas += 1;
        }
        return this.cantidadEntradas;
    }
}
