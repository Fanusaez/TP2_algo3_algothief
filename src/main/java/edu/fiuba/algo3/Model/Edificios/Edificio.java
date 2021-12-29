package edu.fiuba.algo3.Model.Edificios;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.Model.ciudad.Ciudad;

public abstract class Edificio {

    int cantidadEntradas;
    String pista;

    {
        pista = "The thief has NOT been seen in this building";
        cantidadEntradas = 0;
    }

    public String mostrarPista() {
        return pista;
    }

    public abstract void generarPistaEdificio(Ciudad unaCiudad, Delincuente delincuente);

    public int visitar(){
        if (cantidadEntradas < 3){
            this.cantidadEntradas += 1;
        }
        return this.cantidadEntradas;
    }
}
