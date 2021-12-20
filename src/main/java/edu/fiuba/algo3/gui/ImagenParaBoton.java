package edu.fiuba.algo3.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImagenParaBoton extends ImageView {

    public ImagenParaBoton(String rutaImagen, int alto, int ancho){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(rutaImagen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img = new Image(fileInputStream);
        this.setImage(img);
        this.setFitHeight(alto);
        this.setFitWidth(ancho);
    }
}

