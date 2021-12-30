package edu.fiuba.algo3.Model.Edificios;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.Model.ciudad.Ciudad;

public class Biblioteca extends Edificio {

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, Delincuente delincuente) {
        pista = "I saw the thief taking photos of " + unaCiudad.obtenerDato("Landmarks") + "\n" +   delincuente.generarPista();
    }
}
