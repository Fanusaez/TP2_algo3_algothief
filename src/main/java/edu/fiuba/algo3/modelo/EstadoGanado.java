package edu.fiuba.algo3.modelo;

public class EstadoGanado implements EstadoJuegoInterfaz {

    public EstadoJuegoInterfaz cambiarA(EstadoJuegoInterfaz estado){
        if(estado.devolverComoString().equals("ganado")){
            return this;
        }
        if(estado.devolverComoString().equals("Jugando")){
            return new EstadoGanado();
        }
        return new EstadoPerdido();

    }




    public String devolverComoString(){
        return "ganado";
    }
}
