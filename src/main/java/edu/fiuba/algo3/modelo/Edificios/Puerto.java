package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public class Puerto extends Edificio {

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, String laPista) {
        pista = "Cambio la moneda a " + unaCiudad.obtenerDato("Currency");
    }
}
