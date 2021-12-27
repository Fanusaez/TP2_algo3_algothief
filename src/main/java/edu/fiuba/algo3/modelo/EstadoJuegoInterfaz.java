package edu.fiuba.algo3.modelo;

public interface EstadoJuegoInterfaz {
    EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado);


    public String devolverComoString();
}
