package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.EstadoGanado;
import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.EstadoPerdido;

public class OrdenDeArresto {
    String nombre;

    public OrdenDeArresto(){
        this.nombre = "";
    }

    public void setNombre(String unNombre){
        this.nombre = unNombre;
    }

    public boolean coincideConOrden(String unNombre){
        return nombre.equals(unNombre);
    }

    public EstadoJuegoInterfaz realizarArresto(String nombreSospechoso){
        if(nombre.equals(nombreSospechoso))
            return new EstadoGanado();

        return new EstadoPerdido();
    }



}
