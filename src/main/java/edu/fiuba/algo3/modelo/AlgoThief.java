package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.gui.scenes.MainMenuScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgoThief{
    private Policia policia;
    private Reloj reloj;
    private ArrayList<Ciudad> ciudades;
    private Mapa mapa;

    public AlgoThief(String rutaArchivoCiudades) {

        this.mapa = new Mapa(rutaArchivoCiudades);
        Ciudad ciudadInicial = mapa.obtenerCiudad("Buenos Aires");//new Ciudad("city","Buenos Aires");
        this.policia = new Policia(ciudadInicial);
        this.reloj = new Reloj();

    }

    public String obtenerHorario(){

        return this.reloj.obtenerHorario();
    }

    public String entrarAEdificio(int indice) {
        reloj.aumentarHoras(policia.cantidadDeEntradas());
        return policia.entrarAEdificio(indice);
    }

    private String consultarPista() {
        return "Una pista";
    }



}