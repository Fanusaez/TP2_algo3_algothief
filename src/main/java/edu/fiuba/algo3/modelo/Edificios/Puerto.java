package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Puerto extends Edificio {

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, String laPista) {
        pistaPropia = "Cambio la moneda a " + unaCiudad.obtenerDato("Currency");
    }
}
