package edu.fiuba.algo3.modelo;

public class EstadoGanado implements EstadoJuegoInterfaz {

    public EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado){
        if(estado instanceof EstadoGanado){
            return this;
        }
        if(estado instanceof EstadoJugando){
            return new EstadoGanado();
        }
        return new EstadoPerdido();
    }
}
