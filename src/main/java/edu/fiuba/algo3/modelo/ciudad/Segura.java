package edu.fiuba.algo3.modelo.ciudad;

import edu.fiuba.algo3.modelo.AlgoThiefInterfaz;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.EstadoJugando;
import edu.fiuba.algo3.modelo.computadora.Computadora;

public class Segura implements EstadoCiudad {

    public int atacar(){
        return 0;
    }

    public String entrarAEdificio(Edificio edificio) {
        return edificio.mostrarPista();
    }


    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora){return new EstadoJugando();}


}
