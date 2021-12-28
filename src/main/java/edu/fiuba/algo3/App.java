package edu.fiuba.algo3;

import edu.fiuba.algo3.gui.View;
import edu.fiuba.algo3.gui.layouts.ComputadoraLayout;
import edu.fiuba.algo3.gui.layouts.EdificioLayout;
import edu.fiuba.algo3.gui.layouts.FinDeJuegoLayout;
import edu.fiuba.algo3.gui.layouts.ViajeLayout;
import edu.fiuba.algo3.gui.scenes.ComputadoraScene;
import edu.fiuba.algo3.gui.scenes.EdificioScene;
import edu.fiuba.algo3.gui.scenes.FinDeJuegoScene;
import edu.fiuba.algo3.gui.scenes.ViajeScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.EstadoJugando;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class App extends Application {
    private Stage window;
    private AlgoThief algoThief;
    private View view;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){
        String rutaArchivoCiudades = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Ciudades.txt";
        String rutaArchivoDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";
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

    public ListView CrearListadoDeLaComputadora() {


        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(2)
                );
        Border border = new Border(borderStroke);
        Font fuente = Font.font("OCR A Extended", FontWeight.EXTRA_BOLD, 12);
        Background fondoTransparente = new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY));

        //Sex
        Button botonSiguienteSex = new Button("➜");
        botonSiguienteSex.setBorder(border);
        botonSiguienteSex.setFont(fuente);
        botonSiguienteSex.setBackground(fondoTransparente);
        botonSiguienteSex.setOnAction(e->{
            algoThief.siguienteSex();
            abrirLaComputadora();
        });
        Text textosex = new Text("Sex" + " : " + algoThief.getSexoSeleccionado());
        textosex.setFont(fuente);
        BorderPane cajaHorizontalsex= new BorderPane();
        cajaHorizontalsex.setLeft(textosex);
        cajaHorizontalsex.setRight(botonSiguienteSex);

        //Hobby
        Button botonSiguienteHobby = new Button("➜");
        botonSiguienteHobby.setBorder(border);
        botonSiguienteHobby.setFont(fuente);
        botonSiguienteHobby.setBackground(fondoTransparente);
        botonSiguienteHobby.setOnAction(e->{
            algoThief.siguienteHobby();
            abrirLaComputadora();
        });
        Text textohobby = new Text("Hobby"+" : " + algoThief.getHobbySeleccionado());
        textohobby.setFont(fuente);
        BorderPane cajaHorizontalHobby= new BorderPane();
        cajaHorizontalHobby.setLeft(textohobby);
        cajaHorizontalHobby.setRight(botonSiguienteHobby);

        //Pelo
        Button botonSiguientePelo = new Button("➜");
        botonSiguientePelo.setBorder(border);
        botonSiguientePelo.setFont(fuente);
        botonSiguientePelo.setBackground(fondoTransparente);
        botonSiguientePelo.setOnAction(e->{
            algoThief.siguientePelo();
            abrirLaComputadora();
        });
        Text textopelo = new Text("Hair" + " : " + algoThief.getHairSeleccionado());
        textopelo.setFont(fuente);
        BorderPane cajaHorizontalPelo= new BorderPane();
        cajaHorizontalPelo.setLeft(textopelo);
        cajaHorizontalPelo.setRight(botonSiguientePelo);

        //feature
        Button botonSiguienteFeature = new Button("➜");
        botonSiguienteFeature.setBorder(border);
        botonSiguienteFeature.setBackground(fondoTransparente);
        botonSiguienteFeature.setOnAction(e->{
            algoThief.siguienteFeature();
            abrirLaComputadora();
        });
        Text textfeature = new Text("Feature" + " : " + algoThief.getFeatureSeleccionado());
        textfeature.setFont(fuente);
        BorderPane cajaHorizontalFeature= new BorderPane();
        cajaHorizontalFeature.setLeft(textfeature);
        cajaHorizontalFeature.setRight(botonSiguienteFeature);

        //auto
        Button botonSiguienteAuto= new Button("➜");
        botonSiguienteAuto.setBorder(border);
        botonSiguienteAuto.setBackground(fondoTransparente);
        Text textauto = new Text("Vehicule" + " : " + algoThief.getCarSeleccionado());
        textauto.setFont(fuente);
        botonSiguienteAuto.setOnAction(e->{
            algoThief.siguienteCar();
            abrirLaComputadora();
        });
        BorderPane cajaHorizontalAuto= new BorderPane();
        cajaHorizontalAuto.setLeft(textauto);
        cajaHorizontalAuto.setRight(botonSiguienteAuto);
        cajaHorizontalAuto.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

        ListView listadoView = new ListView();
        listadoView.getItems().addAll(cajaHorizontalsex,cajaHorizontalHobby,cajaHorizontalPelo,cajaHorizontalFeature,cajaHorizontalAuto);
        return listadoView;
    }

    public void chequearEstadoJuegoPerdido(){
        if(!(algoThief.getEstadoDeJuego() instanceof EstadoJugando)){ //arreglar esto!!!!
            abrirEscenaFinDeJuego();
        }
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

