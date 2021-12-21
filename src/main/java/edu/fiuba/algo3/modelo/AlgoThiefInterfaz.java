package edu.fiuba.algo3.modelo;

//import edu.fiuba.algo3.modelo.CosasDelincuente.CreadorDelincuentes;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.computadora.Computadora;

import java.util.ArrayList;

public interface AlgoThiefInterfaz {
    public String desplegarTextoInicial();

    public String obtenerHorario();

    public String entrarAEdificio(int indice) ;

    public EstadoJuegoInterfaz realizarArresto(Computadora computadora);

    public ArrayList<Ciudad> verOpcionesDeViaje();

    public void viajar(Ciudad destinoSeleccionado);


    public void realizarArresto();

    String estadoJuegoComoString();
}
