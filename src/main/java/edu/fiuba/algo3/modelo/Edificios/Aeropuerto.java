package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public class Aeropuerto extends Edificio {


    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, String laPista) {
        pista = "Vi que tenia una bandera del estilo " + unaCiudad.obtenerDato("Flag")+ "."+ laPista;
    }
}