package edu.fiuba.algo3.Model.dificultad;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;

public class DificultadNovato implements DificultadJuego {
    @Override
    public Delincuente crearDelincuente() {
        return Delincuente.crearDelincuenteParaNovato();
    }

    public  DificultadJuego aumentarDificultad(){
        return new DificultadDetective();
    }
}
