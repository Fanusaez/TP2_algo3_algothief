package edu.fiuba.algo3.modelo.ciudad;

import edu.fiuba.algo3.modelo.AlgoThiefInterfaz;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.computadora.Computadora;

public interface EstadoCiudad {
    public int atacar();
    String entrarAEdificio(Edificio edificio);

    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora);
}
