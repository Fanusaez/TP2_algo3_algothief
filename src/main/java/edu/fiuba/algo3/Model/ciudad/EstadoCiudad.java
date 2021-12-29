package edu.fiuba.algo3.Model.ciudad;

import edu.fiuba.algo3.Model.Edificios.Edificio;
import edu.fiuba.algo3.Model.EstadoJuegoInterfaz;
import edu.fiuba.algo3.Model.computadora.Computadora;

public interface EstadoCiudad {
    public int atacar();
    String entrarAEdificio(Edificio edificio);

    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora);
}
