package edu.fiuba.algo3;

import com.sun.jdi.event.ExceptionEvent;
import edu.fiuba.algo3.gui.View;
import edu.fiuba.algo3.gui.layouts.ComputadoraLayout;
import edu.fiuba.algo3.gui.layouts.EdificioLayout;
import edu.fiuba.algo3.gui.layouts.PerdisteLayout;
import edu.fiuba.algo3.gui.layouts.ViajeLayout;
import edu.fiuba.algo3.gui.scenes.ComputadoraScene;
import edu.fiuba.algo3.gui.scenes.EdificioScene;
import edu.fiuba.algo3.gui.scenes.PerdisteScene;
import edu.fiuba.algo3.gui.scenes.ViajeScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

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
        window = stage;
        window.setTitle("AlgoThief");
        algoThief = new AlgoThief(rutaArchivoCiudades, rutaArchivoDelincuentes);
        view = new View(window);
        view.initView(window,this, algoThief);
    }

    public void abrirEscenaEdificio(String ubicacionArchivo,int indice){
        EdificioLayout viajeLayout = new EdificioLayout(window, this, algoThief, ubicacionArchivo, algoThief.entrarAEdificio(indice));
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
        if(algoThief.estadoJuego.devolverComoString().equals("perdido")){
            abrirEscenaPerdiste();
        }
    }


    public void abrirLaComputadora() {
        System.out.println("entre");
        ComputadoraLayout ComputadoraLayout = new ComputadoraLayout(window, this, algoThief);
        ComputadoraScene ComputadoraScene = new ComputadoraScene(window, ComputadoraLayout, algoThief);
        window.setScene(ComputadoraScene);

    }

    public ListView CrearListadoDeLaComputadora() {

        ArrayList<ArrayList<String>>listaDeCaracteristicas = algoThief.mostrarAtriutosDelincuenteSeleccionados();

        ArrayList<String> sex = listaDeCaracteristicas.get(0);
        Button botonSiguienteSex = new Button("Siguiente");
        Text textosex = new Text(sex.get(0)+": " + sex.get(1));
        BorderPane cajaHorizontalsex= new BorderPane();
        cajaHorizontalsex.setLeft(textosex);
        cajaHorizontalsex.setRight(botonSiguienteSex);

        ArrayList<String> hobby = listaDeCaracteristicas.get(1);
        Button botonSiguienteHobby = new Button("Siguiente");
        Text textohobby = new Text(hobby.get(0)+": " + hobby.get(1));

        BorderPane cajaHorizontalHobby= new BorderPane();
        cajaHorizontalHobby.setLeft(textohobby);
        cajaHorizontalHobby.setRight(botonSiguienteHobby);

        ArrayList<String> pelo = listaDeCaracteristicas.get(2);
        Button botonSiguientePelo = new Button("SiguientePelo");
        botonSiguientePelo.setOnAction(e->{
            algoThief.siguientePelo();
            abrirLaComputadora();
        });
        Text textpelo = new Text(pelo.get(0)+": " + hobby.get(1));
        BorderPane cajaHorizontalPelo= new BorderPane();
        cajaHorizontalPelo.setLeft(textpelo);
        cajaHorizontalPelo.setRight(botonSiguientePelo);

        ArrayList<String> feature = listaDeCaracteristicas.get(3);
        Button botonSiguienteFeature = new Button("Siguiente");
        Text textfeature = new Text(feature.get(0)+": " + hobby.get(1));
        BorderPane cajaHorizontalFeature= new BorderPane();
        cajaHorizontalFeature.setLeft(textfeature);
        cajaHorizontalFeature.setRight(botonSiguienteFeature);

        ArrayList<String> auto = listaDeCaracteristicas.get(4);
        Button botonSiguienteAuto= new Button("Siguiente");
        Text textauto = new Text(auto.get(0)+": " + hobby.get(1));
        BorderPane cajaHorizontalAuto= new BorderPane();
        cajaHorizontalAuto.setLeft(textauto);
        cajaHorizontalAuto.setRight(botonSiguienteAuto);



        ListView listadoView = new ListView();
        listadoView.setMaxSize(300,300);
        listadoView.getItems().addAll(cajaHorizontalsex,cajaHorizontalHobby,cajaHorizontalPelo,cajaHorizontalFeature,cajaHorizontalAuto);
        return listadoView;
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

