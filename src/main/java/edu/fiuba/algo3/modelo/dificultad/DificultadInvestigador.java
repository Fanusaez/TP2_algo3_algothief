package edu.fiuba.algo3.modelo.dificultad;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

public class DificultadInvestigador implements DificultadJuego{
    @Override
    public Delincuente crearDelincuente() {
        return Delincuente.crearDelincuenteParaInvestigador();
    }
}
