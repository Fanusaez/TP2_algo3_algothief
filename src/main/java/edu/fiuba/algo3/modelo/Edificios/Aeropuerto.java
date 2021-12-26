package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public class Aeropuerto extends Edificio {


    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, Delincuente delincuente) {
        pista = " I saw the thief taking off in a plane with a " + unaCiudad.obtenerDato("Flag") + " flag on it's wing. " + delincuente.generarPista();

    }
}