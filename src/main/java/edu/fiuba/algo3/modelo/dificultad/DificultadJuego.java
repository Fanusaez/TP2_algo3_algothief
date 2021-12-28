package edu.fiuba.algo3.modelo.dificultad;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

public interface DificultadJuego {
    public abstract Delincuente crearDelincuente();
    public abstract DificultadJuego aumentarDificultad(Boolean booleano);

}
