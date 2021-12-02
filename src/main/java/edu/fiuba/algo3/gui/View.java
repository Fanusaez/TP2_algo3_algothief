package edu.fiuba.algo3.gui;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.layouts.StartGameLayout;
import edu.fiuba.algo3.gui.scenes.MainMenuScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.stage.Stage;

import java.lang.reflect.Method;

public class View {

    private StartGameLayout startGameLayout;
    private Stage stage;

    public View(Stage stage) {
        this.stage=stage;
    }

    public void initView(Stage window, App app){
        // Comienza el juego
        startGameLayout = new StartGameLayout(window,app);
        StartGameScene startGameScene = new StartGameScene(window,startGameLayout);
        MainMenuScene mainMenu = new MainMenuScene(window,startGameScene);
        window.setScene(mainMenu);
        window.show();
    }

    public StartGameLayout getStartGameLayout() {
        return startGameLayout;
    }
}
