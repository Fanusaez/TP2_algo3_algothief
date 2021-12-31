package edu.fiuba.algo3.View.scenes;
import edu.fiuba.algo3.View.layouts.SiguienteNivelLayout;
import javafx.scene.Scene;

public class SiguienteNivelScene  extends Scene{

        SiguienteNivelLayout siguienteNivelLayout;

        public SiguienteNivelScene(SiguienteNivelLayout siguienteNivelLayout) {
            super(siguienteNivelLayout, 640, 480);

            this.siguienteNivelLayout = siguienteNivelLayout;
        }
}
