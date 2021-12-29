package edu.fiuba.algo3.View.scenes;


import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImagenPortada {

    public static Background crearFondo(String rutaArchivo){
        Image image = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(rutaArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        image = new Image(fileInputStream);

        BackgroundImage backgroundImage =
                new BackgroundImage(
                        image,
                        BackgroundRepeat.NO_REPEAT,  // repeat X
                        BackgroundRepeat.NO_REPEAT,  // repeat Y
                        BackgroundPosition.CENTER,   // position
                        new BackgroundSize(
                                100,   // width  = 100%
                                100,   // height = 100%
                                true,  // width is percentage
                                true,  // height is percentage
                                true,  // contain image within bounds
                                true   // cover all of Region content area
                        )
                );
        return new Background(backgroundImage);
    }
}
