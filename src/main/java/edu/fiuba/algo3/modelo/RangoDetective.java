package edu.fiuba.algo3.modelo;

public class RangoDetective extends Rango {

    public RangoDetective(){
        cantidadNecesariaAscenso = 10;
        velocidad = 1100;
    }

    @Override
    public Rango ascender(int cantidadArrestos) {
        if (cantidadArrestos == cantidadNecesariaAscenso){
            return new RangoDetective(); //RETURN INVESTIGADOR
        }
        return this;
    }
}
