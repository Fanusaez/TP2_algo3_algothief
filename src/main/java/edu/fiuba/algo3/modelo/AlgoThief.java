package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.gui.scenes.MainMenuScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class AlgoThief{
    private Policia policia;
    private Reloj reloj;

    public AlgoThief()
    {
        this.policia = new Policia();
        this.reloj = new Reloj();
    }

    public String obtenerHorario(){
        return this.reloj.obtenerHorario();
    }

    public String entrarAEdificio() {
        reloj.aumentarHoras(policia.cantidadDeEntradas());
        return consultarPista();
    }

    private String consultarPista() {
        return "Una pista";
    }


}