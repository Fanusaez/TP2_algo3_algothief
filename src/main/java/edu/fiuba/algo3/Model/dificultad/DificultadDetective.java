package edu.fiuba.algo3.Model.dificultad;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;

public class DificultadDetective implements DificultadJuego{

    public Delincuente crearDelincuente(){
        return Delincuente.crearDelincuenteParaDetective();
    }
    public  DificultadJuego aumentarDificultad(Boolean booleano){
        return  new DificultadInvestigador();
    }
}
