package edu.fiuba.algo3.modelo;

public class EstadoJugando implements EstadoJuegoInterfaz {
    public EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado){
        if(estado.devolverComoString().equals("ganado")){
        return new EstadoGanado();
    }
        if(estado.devolverComoString().equals("Jugando")){
            return this;
        }
        return new EstadoPerdido();

    }



    public String devolverComoString(){
        return "Jugando";
    }
}
