package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Segura implements EstadoCiudad {

    public int atacar(){
        return 0;
    }

    public String entrarAEdificio(Edificio edificio) {
        return edificio.mostrarPista();
    }
}
