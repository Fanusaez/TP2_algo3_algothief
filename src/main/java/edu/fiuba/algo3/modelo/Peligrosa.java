package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Peligrosa implements EstadoCiudad {

    Delincuente delincuente;

    public Peligrosa(Delincuente unDelincuente){
        this.delincuente = unDelincuente;
    }

    public int atacar() {
        return this.delincuente.atacar();
    }

    public String entrarAEdificio(Edificio edificio) {
        return "Estas cerca de atraparlo, ten cuidado!";
    }
}
