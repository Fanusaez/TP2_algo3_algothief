package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CosasDelincuente.CreadorDelincuentes;

import java.util.ArrayList;

public interface AlgoThiefInterfaz {
    public String desplegarTextoInicial();

    public String obtenerHorario();

    public String entrarAEdificio(int indice) ;


    public ArrayList<Ciudad> verOpcionesDeViaje();

    public void viajar(Ciudad destinoSeleccionado);


}
