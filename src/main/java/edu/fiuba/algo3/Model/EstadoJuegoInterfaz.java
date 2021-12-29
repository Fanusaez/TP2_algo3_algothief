package edu.fiuba.algo3.Model;

public interface EstadoJuegoInterfaz {
    EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado);


    public String devolverComoString();
}
