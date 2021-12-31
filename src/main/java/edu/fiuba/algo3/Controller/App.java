package edu.fiuba.algo3.Controller;

import edu.fiuba.algo3.View.View;
import edu.fiuba.algo3.View.layouts.*;
import edu.fiuba.algo3.View.scenes.*;
import edu.fiuba.algo3.Model.AlgoThief;
import edu.fiuba.algo3.Model.EstadoJugando;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private Stage window;
    private AlgoThief algoThief;
    private View view;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){
        String rutaArchivoCiudades = "src/main/java/edu/fiuba/algo3/Model/ArchivosDeTexto/Ciudades.txt";
        String rutaArchivoDelincuentes = "src/main/java/edu/fiuba/algo3/Model/ArchivosDeTexto/Delincuentes.txt";
        window = stage;
        window.setMinWidth(640);
        window.setMinHeight(480);
        window.setTitle("AlgoThief");
        algoThief = new AlgoThief(rutaArchivoCiudades, rutaArchivoDelincuentes);
        view = new View(window);
        view.initView(window,this, algoThief);
    }

    public void abrirEscenaEdificioAeropuerto(String ubicacionArchivo){
        EdificioLayout viajeLayout = new EdificioLayout(window, this, algoThief, ubicacionArchivo, algoThief.entrarAAeropuerto());
        EdificioScene viajeScene = new EdificioScene(window, viajeLayout, algoThief);
        window.setScene(viajeScene);

        chequearEstadoJuegoPerdido();


        if(!(algoThief.getEstadoDeJuego() instanceof EstadoJugando)){
            abrirEscenaFinDeJuego();
        }

    }

    public void abrirEscenaEdificioBanco(String ubicacionArchivo){
        EdificioLayout viajeLayout = new EdificioLayout(window, this, algoThief, ubicacionArchivo, algoThief.entrarABanco());
        EdificioScene viajeScene = new EdificioScene(window, viajeLayout, algoThief);
        window.setScene(viajeScene);


        chequearEstadoJuegoPerdido();

        if(!(algoThief.getEstadoDeJuego() instanceof EstadoJugando)){
            abrirEscenaFinDeJuego();
        }

    }

    public void abrirEscenaEdificioBiblioteca(String ubicacionArchivo){
        EdificioLayout viajeLayout = new EdificioLayout(window, this, algoThief, ubicacionArchivo, algoThief.entrarABiblioteca());
        EdificioScene viajeScene = new EdificioScene(window, viajeLayout, algoThief);
        window.setScene(viajeScene);


        chequearEstadoJuegoPerdido();

        if(!(algoThief.getEstadoDeJuego() instanceof EstadoJugando)){
            abrirEscenaFinDeJuego();
        }

    }


    public void abrirEscenaFinDeJuego(){
        FinDeJuegoLayout finDeJuegoLayout = new FinDeJuegoLayout(window, this, algoThief);
        FinDeJuegoScene finDeJuegoScene = new FinDeJuegoScene(window, finDeJuegoLayout, algoThief);
        window.setScene(finDeJuegoScene);
    }

    public void viajarACiudad(int indice) {
        ViajeLayout viajeLayout = new ViajeLayout(window, this, algoThief);
        ViajeScene viajeScene = new ViajeScene(window, viajeLayout, algoThief);
        window.setScene(viajeScene);
        algoThief.viajar(algoThief.verOpcionesDeViaje().get(indice));

        chequearEstadoJuegoPerdido();

        if(!(algoThief.getEstadoDeJuego() instanceof EstadoJugando)){
            abrirEscenaFinDeJuego();
        }

    }


    public void abrirLaComputadora() {

        ComputadoraLayout ComputadoraLayout = new ComputadoraLayout(window, this, algoThief);
        ComputadoraScene ComputadoraScene = new ComputadoraScene(window, ComputadoraLayout, algoThief);
        window.setScene(ComputadoraScene);
        chequearEstadoJuegoPerdido();
    }

    public void chequearEstadoJuegoPerdido(){
        if(!(algoThief.getEstadoDeJuego() instanceof EstadoJugando)){
            abrirEscenaFinDeJuego();
        }
    }

    public void siguienteNivel() {
        algoThief.siguienteNivel();
        //CiudadLayout ciudadLayout = new CiudadLayout(window, this, algoThief);
        //CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);

        //StartGameLayout startGameLayout = new StartGameLayout(window,this, algoThief);
        //StartGameScene startGameScene = new StartGameScene(window,startGameLayout, algoThief);
        SiguienteNivelLayout siguienteNivelLayout = new SiguienteNivelLayout(window, this, algoThief);
        SiguienteNivelScene siguienteNivelScene = new SiguienteNivelScene(siguienteNivelLayout);
        window.setScene(siguienteNivelScene);
    }
}


