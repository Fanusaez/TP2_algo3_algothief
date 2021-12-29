package edu.fiuba.algo3.Model;

//import edu.fiuba.algo3.modelo.CosasDelincuente.CreadorDelincuentes;

import edu.fiuba.algo3.Model.ciudad.Ciudad;

import java.util.ArrayList;

public interface AlgoThiefInterfaz {
    public String desplegarTextoInicial();

    public String obtenerHorario();

    //public String entrarAEdificio(int indice) ;

    public EstadoJuegoInterfaz realizarArresto();

    public ArrayList<Ciudad> verOpcionesDeViaje();

    public void viajar(Ciudad destinoSeleccionado);

    String tiempoTranscurrido();


    //String estadoJuegoComoString();
}
