package edu.fiuba.algo3.modelo.dificultad;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.dificultad.DificultadJuego;

public class DificultadNovato implements DificultadJuego {
    @Override
    public Delincuente crearDelincuente() {
        return Delincuente.crearDelincuenteParaNovato();
    }

    public  DificultadJuego aumentarDificultad(Boolean booleano){
        return new DificultadDetective();
    }
}
