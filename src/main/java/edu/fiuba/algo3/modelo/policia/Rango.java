package edu.fiuba.algo3.modelo.policia;

public abstract class Rango {

    
    int velocidad;
    int cantidadNecesariaAscenso;
    
    public int getVelocidad(){
        return velocidad;
    }

    public abstract Rango ascender(int cantidadArrestos);
}
