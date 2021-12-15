package edu.fiuba.algo3.modelo.ciudad;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.AlgoThiefInterfaz;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public interface EstadoCiudad {
    public int atacar();
    String entrarAEdificio(Edificio edificio);

    public void atraparLadron(AlgoThiefInterfaz algoThief);
}
