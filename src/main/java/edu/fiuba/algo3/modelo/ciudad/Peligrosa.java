package edu.fiuba.algo3.modelo.ciudad;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.AlgoThiefInterfaz;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

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

        return "Estas cerca de atraparlo, ten cuidado!";
    }
    public void atraparLadron(AlgoThiefInterfaz algoThief){
        ContadorEntradasEdificios++;
        if (ContadorEntradasEdificios >= 3){
            algoThief.realizarArresto();}

    }
}
