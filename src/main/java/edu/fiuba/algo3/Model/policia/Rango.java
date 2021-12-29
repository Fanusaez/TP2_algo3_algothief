package edu.fiuba.algo3.Model.policia;

public abstract class Rango {

    
    int velocidad;
    int cantidadNecesariaAscenso;
    
    public int getVelocidad(){
        return velocidad;
    }

    public abstract Rango ascender(int cantidadArrestos);

    public abstract Boolean categoriaGanada(int cantidadArrestos);

}
