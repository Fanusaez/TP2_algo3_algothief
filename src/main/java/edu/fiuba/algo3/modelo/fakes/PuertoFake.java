package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.CiudadProductiva;
import edu.fiuba.algo3.modelo.Pista;

public class PuertoFake implements EdificioFake {
    Pista pista = new Pista("El delincuente no visito este edificio");

    @Override
    public String mostrarPista() {
        pista.mostrarPista();
    }

    @Override
    public void generarPistaEdificio(CiudadProductiva unaCiudad, String laPista) {
        pista = new Pista("Cambio la moneda a " + unaCiudad.obtenerDato("Currency"));
    }
}
