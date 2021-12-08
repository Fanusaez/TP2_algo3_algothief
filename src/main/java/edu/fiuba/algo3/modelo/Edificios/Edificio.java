package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public interface Edificio {
    String mostrarPista();
    void generarPistaEdificio(Ciudad unaCiudad, String laPista);
}
