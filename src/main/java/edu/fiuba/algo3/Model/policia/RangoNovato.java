package edu.fiuba.algo3.Model.policia;

public class RangoNovato extends Rango {

    public RangoNovato(){
        cantidadNecesariaAscenso = 5;
        velocidad = 900;
    }

    @Override
    public Rango ascender(int cantidadArrestos) {
        if (cantidadArrestos == cantidadNecesariaAscenso){
            return new RangoDetective();
        }
        return this;
    }
    public Boolean categoriaGanada(int cantidadArrestos) {
        return (cantidadArrestos == cantidadNecesariaAscenso) ;

    }

}
