package edu.fiuba.algo3.Model;

public class EstadoPerdido implements EstadoJuegoInterfaz {
    public EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado){
        return this;
    }


    public String devolverComoString(){
        return "perdido";
    }

}
