package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public class Biblioteca implements Edificio {
    String pista = "El delincuente no visito este edificio";

    @Override
    public String mostrarPista() {
        return pista;
    }

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, String laPista) {


        //pista = "Cambio la moneda a " + unaCiudad.obtenerDato("Currency");
    }
}
