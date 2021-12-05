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
    private Delincuente delincuente;
    private CreadorDelincuentes creadorDeDelincuentes;

    public AlgoThief(String rutaArchivoCiudades) {

        this.creadorDeDelincuentes = new CreadorDelincuentes(rutaArchivoCiudades);
        this.delincuente =  this.creadorDeDelincuentes.seleccionarDelincuenteAleatorio();
        this.mapa = new Mapa(rutaArchivoCiudades);
        this.mapa.EstablecerPistasEnElRecorrido(this.delincuente);
        Ciudad ciudadInicial = mapa.obtenerCiudadInicial();//new Ciudad("city","Buenos Aires");
        this.policia = new Policia(ciudadInicial);
        this.reloj = new Reloj();


    }

    public String desplegarTextoInicial(){
        String texto = "***FLASH***\n" +
                "National treasure stolen from Port Moresby.\n" +
                "The treasure has been identified as an ancient\n" +
                "tribal totem." +
                "Female suspect reported at the scene of the crime.\n" +
                "Your assignment:\n" +
                "Track the thief from Port Moresby to her\n" +
                "hideout and arrest her!\n" +
                "You must apprehend the thief by Sunday, 5pm.\n" +
                "Good luck, Rookie <nombreUsuario>.\n" +
                "\n";
        return texto;
    }

    public String obtenerHorario(){

        return this.reloj.obtenerHorario();
    }

    public String entrarAEdificio(int indice) {
        reloj.aumentarHoras(policia.cantidadDeEntradas());
        return policia.entrarAEdificio(indice);
    }

    private String consultarPista() {
        return policia.entrarAEdificio(1);
    }


    /*public Delincuente obtenerDelincuente() {
        return creadorDeDelincuentes.ObtenerDelincuente();
    }*/
}