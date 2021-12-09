package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface AlgoThiefInterfaz {
    public String desplegarTextoInicial();

    public String obtenerHorario();

    public void chequearAtaque();

    public String entrarAEdificio(int indice) ;
    public void entrarAEdificio(int indice) ;

    public ArrayList<CiudadProductiva> verOpcionesDeViaje();

    public void viajar(CiudadProductiva destinoSeleccionado);


}
