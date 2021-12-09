package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.fakes.CiudadFake;

public class Banco implements Edificio {

    Pista pista = new Pista("El delincuente no visito este edificio");

    @Override
    public void mostrarPista() {
        pista.mostrarPista();
    }

    @Override
    public void generarPistaEdificio(CiudadFake unaCiudad, String laPista) {
        pista = new Pista("Cambio la moneda a " + unaCiudad.obtenerDato("Currency")+ ". "+ laPista);
    }
}
