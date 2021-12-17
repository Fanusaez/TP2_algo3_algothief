package edu.fiuba.algo3;

import com.sun.jdi.event.ExceptionEvent;
import edu.fiuba.algo3.gui.View;
import edu.fiuba.algo3.gui.layouts.EdificioLayout;
import edu.fiuba.algo3.gui.layouts.PerdisteLayout;
import edu.fiuba.algo3.gui.layouts.ViajeLayout;
import edu.fiuba.algo3.gui.scenes.EdificioScene;
import edu.fiuba.algo3.gui.scenes.PerdisteScene;
import edu.fiuba.algo3.gui.scenes.ViajeScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App extends Application {
    private Stage window;
    private AlgoThief algoThief;
    private View view;

    public static void main(String[] args) {
        launch();
        System.out.println("El main se está llamando luego de cerrar el window! q onda?");
    }

    @Override
    public void start(Stage stage){
        String rutaArchivoCiudades = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Ciudades.txt";
        String rutaArchivoDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";
        System.out.println("Inicializacion");
        window = stage;
        window.setTitle("AlgoThief");
        algoThief = new AlgoThief(rutaArchivoCiudades, rutaArchivoDelincuentes);
        System.out.println("antes");
        view = new View(window);
        view.initView(window,this, algoThief);
        System.out.println("despues");
    }

    public void abrirEscenaEdificio(String ubicacionArchivo){
        EdificioLayout viajeLayout = new EdificioLayout(window, this, algoThief, ubicacionArchivo, algoThief.entrarAEdificio(1));
        EdificioScene viajeScene = new EdificioScene(window, viajeLayout, algoThief);
        window.setScene(viajeScene);

        if(algoThief.estadoJuego.devolverComoString().equals("perdido")){
            abrirEscenaPerdiste();
        }
    }

    public void abrirEscenaPerdiste(){
        PerdisteLayout perdisteLayout = new PerdisteLayout(window, this, algoThief);
        PerdisteScene perdisteScene = new PerdisteScene(window, perdisteLayout, algoThief);
        window.setScene(perdisteScene);
    }

    public void viajarACiudad(int indice) {
        ViajeLayout viajeLayout = new ViajeLayout(window, this, algoThief);
        ViajeScene viajeScene = new ViajeScene(window, viajeLayout, algoThief);
        window.setScene(viajeScene);
        algoThief.viajar(algoThief.verOpcionesDeViaje().get(indice));
    }


}



    /*public void abrirEscenaJuegoFinalizado(JuegoGanado Juegoganado){
        window.setScene(EscenaGanaste);
    }
    public void abrirEscenaJuegoFinalizado(JuegoPerdido Juegoperdido){
        window.setScene(EscenaPerdiste);
    }
    public void abrirEscenaJuegoFinalizado(JuegoContinuando Juegoperdido){
        return;
    }*/

