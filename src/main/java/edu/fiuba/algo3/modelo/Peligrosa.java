package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

public class Peligrosa implements EstadoCiudad {

    int atacar(Delincuente delincuente){
        return delincuente.atacar();
    }
}