package edu.fiuba.algo3;

import edu.fiuba.algo3.gui.View;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Application;
import javafx.stage.Stage;

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
        view = new View(window);
        view.initView(window,this, algoThief);
    }

    public void gameLogic(){
        System.out.println("El juego !!!");
        view.getStartGameLayout().setTextoVariable(algoThief.entrarAEdificio(0));
    }
}
