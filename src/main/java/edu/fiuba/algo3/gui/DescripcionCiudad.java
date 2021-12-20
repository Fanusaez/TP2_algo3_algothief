package edu.fiuba.algo3.gui;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

import java.util.List;

public class DescripcionCiudad extends VBox{

    public DescripcionCiudad(Text descripcion){
        StrokeType strokeType     = StrokeType.INSIDE;
        StrokeLineJoin strokeLineJoin = StrokeLineJoin.MITER;
        StrokeLineCap strokeLineCap  = StrokeLineCap.BUTT;
        double         miterLimit     = 10;
        double         dashOffset     = 0;
        List<Double> dashArray      = null;

        BorderStrokeStyle borderStrokeStyle =
                new BorderStrokeStyle(
                        strokeType,
                        strokeLineJoin,
                        strokeLineCap,
                        miterLimit,
                        dashOffset,
                        dashArray
                );
        VBox layout = new VBox(10);
        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(0),
                        new BorderWidths(2)
                );
        Border border = new Border(borderStroke);
        descripcion.setWrappingWidth(300);
        this.getChildren().add(descripcion);
        this.setBorder(border);
        //this.setBackground();
    }
}
