package edu.fiuba.algo3.modelo.ciudad;

import edu.fiuba.algo3.modelo.AlgoThiefInterfaz;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.EstadoJugando;
import edu.fiuba.algo3.modelo.computadora.Computadora;

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
        return "Estas cerca de atraparlo, ten cuidado!";
    }

    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora){
        if (ContadorEntradasEdificios == 3){
            return computadora.realizarArresto();
        }
        return new EstadoJugando();
    }

}
