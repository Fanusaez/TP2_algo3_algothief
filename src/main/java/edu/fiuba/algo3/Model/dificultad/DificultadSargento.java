package edu.fiuba.algo3.Model.dificultad;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;

public class DificultadSargento implements DificultadJuego{
    @Override
    public Delincuente crearDelincuente() {
        return Delincuente.crearDelincuenteParaSargento();
    }
    public  DificultadJuego aumentarDificultad(Boolean booleano){
        return  new DificultadSargento();
    }
}
