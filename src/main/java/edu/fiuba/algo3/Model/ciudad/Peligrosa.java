package edu.fiuba.algo3.Model.ciudad;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.Model.Edificios.Edificio;
import edu.fiuba.algo3.Model.EstadoJuegoInterfaz;
import edu.fiuba.algo3.Model.EstadoJugando;
import edu.fiuba.algo3.Model.computadora.Computadora;

public class Peligrosa implements EstadoCiudad {

    Delincuente delincuente;
    int ContadorEntradasEdificios;

    public Peligrosa(Delincuente unDelincuente){
        this.delincuente = unDelincuente;
        this.ContadorEntradasEdificios = 0;
    }

    public int atacar() {
        return this.delincuente.atacar();
    }

    public String entrarAEdificio(Edificio edificio) {
        ContadorEntradasEdificios++;
        return "You are close to catch the thief, be careful";
    }

    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora){
        if (ContadorEntradasEdificios == 3){
            return computadora.realizarArresto();
        }
        return new EstadoJugando();
    }

}
