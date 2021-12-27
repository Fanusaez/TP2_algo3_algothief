package edu.fiuba.algo3.modelo;

public class EstadoJugando implements EstadoJuegoInterfaz {
    public EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado){
        if(estado instanceof EstadoGanado){
        return new EstadoGanado();
    }
        if(estado instanceof EstadoJugando){
            return this;
        }
        return new EstadoPerdido();

    }


}
