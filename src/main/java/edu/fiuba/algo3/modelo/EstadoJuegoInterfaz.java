package edu.fiuba.algo3.modelo;

public interface EstadoJuegoInterfaz {
    public EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado);

    public String devolverComoString();
}
