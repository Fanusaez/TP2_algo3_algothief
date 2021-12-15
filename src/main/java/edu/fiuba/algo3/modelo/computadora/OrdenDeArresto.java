package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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

    public String realizarArresto(ArrayList<String> listadoNombresSospechosos,Delincuente delincuente){
        if (listadoNombresSospechosos.size() == 1){
            if (listadoNombresSospechosos.get(0).equals(delincuente.getNombre())){
                return "ganado";
            }
        }
        return "perdido";
    }

}
