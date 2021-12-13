package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public class Biblioteca extends Edificio {

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, String laPista) {

        pista = "Vi al delicuente llevarse fotos de  " + unaCiudad.obtenerDato("Landmarks");
    }
}
