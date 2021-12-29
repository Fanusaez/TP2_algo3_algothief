package edu.fiuba.algo3.Model.ciudad;

import edu.fiuba.algo3.Model.Edificios.Edificio;
import edu.fiuba.algo3.Model.EstadoJuegoInterfaz;
import edu.fiuba.algo3.Model.EstadoJugando;
import edu.fiuba.algo3.Model.computadora.Computadora;

public class Segura implements EstadoCiudad {

    public int atacar(){
        return 0;
    }

    public String entrarAEdificio(Edificio edificio) {
        return edificio.mostrarPista();
    }


    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora){return new EstadoJugando();}


}
