package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.fakes.CiudadFake;

public interface Edificio {
    void mostrarPista();
    void generarPistaEdificio(CiudadFake unaCiudad, String laPista);
}
