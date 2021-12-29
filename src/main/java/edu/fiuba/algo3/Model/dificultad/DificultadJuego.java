package edu.fiuba.algo3.Model.dificultad;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;

public interface DificultadJuego {
    public abstract Delincuente crearDelincuente();
    public abstract DificultadJuego aumentarDificultad();

}
