package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public class Banco extends Edificio {

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, Delincuente delincuente) {
        pista = "The thief changed his money to " + unaCiudad.obtenerDato("Currency")+ ". "+ delincuente.generarPista();
    }
}
