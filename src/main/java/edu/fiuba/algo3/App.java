package edu.fiuba.algo3;

import edu.fiuba.algo3.gui.layouts.StartGameLayout;
import edu.fiuba.algo3.gui.scenes.MainMenuScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private Stage window;
    private AlgoThief algoThief;
    private StartGameLayout startGameLayout;

    public static void main(String[] args) {
        launch();
        System.out.println("El main se está llamando luego de cerrar el window! q onda?");
    }

    @Override
    public void start(Stage stage) {
        System.out.println("Inicializacion");
        window = stage;
        algoThief = new AlgoThief("fdsfsd");

        // Comienza el juego
        startGameLayout = new StartGameLayout(window);
        // Logica del juego
        System.out.println("Entramos a un edificio");
        startGameLayout.setTextoVariable(this.algoThief.entrarAEdificio());


        StartGameScene startGameScene = new StartGameScene(window,startGameLayout);

        // Se muestra la pantalla de inicio
        MainMenuScene mainMenu = new MainMenuScene(window,startGameScene);
        window.setScene(mainMenu);
        window.show();
    }
}
