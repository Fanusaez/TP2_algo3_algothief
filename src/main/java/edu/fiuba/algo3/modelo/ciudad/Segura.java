package edu.fiuba.algo3.modelo.ciudad;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.AlgoThiefInterfaz;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Segura implements EstadoCiudad {

    public int atacar(){
        return 0;
    }

    public String entrarAEdificio(Edificio edificio) {
        return edificio.mostrarPista();
    }

    public void atraparLadron(AlgoThiefInterfaz algoThief){
        System.out.println("hola");
    }
}
