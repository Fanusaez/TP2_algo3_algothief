package edu.fiuba.algo3.modelo;

public class Banco implements Edificio{

    String pista = "El delincuente no visito este edificio";

    @Override
    public String mostrarPista() {
        return pista;
    }

    @Override
    public void generarPistaEdificio(Ciudad unaCiudad, String laPista) {
 /*       pista = "Cambio la moneda a " + unaCiudad.obtenerClave("Currency");*/
    }
}
