package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public class Aeropuerto extends Edificio {


    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, Delincuente delincuente) {
        pista = "Vi que tenia una bandera del estilo" + unaCiudad.obtenerDato("Flag") + "." + delincuente.generarPista();

    }
}