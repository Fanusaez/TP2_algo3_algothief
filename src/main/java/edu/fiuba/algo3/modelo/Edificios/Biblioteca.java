package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public class Biblioteca extends Edificio {

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, Delincuente delincuente) {
        pista = "I saw the thief taking photos of " + unaCiudad.obtenerDato("Landmarks") + ". " +   delincuente.generarPista();
    }
}
