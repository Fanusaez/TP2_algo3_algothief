package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.CiudadProductiva;

public interface EdificioFake {
    String mostrarPista();
    void generarPistaEdificio(CiudadProductiva unaCiudad, String laPista);
}
