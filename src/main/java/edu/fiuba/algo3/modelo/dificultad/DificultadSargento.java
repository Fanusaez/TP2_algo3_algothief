package edu.fiuba.algo3.modelo.dificultad;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

public class DificultadSargento implements DificultadJuego{
    @Override
    public Delincuente crearDelincuente() {
        return Delincuente.crearDelincuenteParaSargento();
    }
}
