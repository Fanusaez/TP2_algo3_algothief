import edu.fiuba.algo3.modelo.Computadora;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import org.junit.Test;

import java.util.ArrayList;
import static org.testng.AssertJUnit.assertTrue;

public class TestComputadora {
    @Test
    public void testDevolverCarmenSanDiego(){

        ArrayList<Delincuente> listaDelincuentes = new ArrayList<Delincuente>();

        Delincuente carmenSanDiego = new Delincuente();
        carmenSanDiego.agregarDato("Name", "Carmen SanDiego");
        carmenSanDiego.agregarDato("Sex", "female");
        carmenSanDiego.agregarDato("Hobby", "tennis");
        carmenSanDiego.agregarDato("Hair", "brown");
        carmenSanDiego.agregarDato("Feature", "jewelry");
        carmenSanDiego.agregarDato("Auto", "convertible");

        listaDelincuentes.add(carmenSanDiego);
        Computadora computadora = new Computadora(listaDelincuentes);

/*
       //Refiere a los clicks para cambiar de opción de atributo
        computadora.siguienteSexo(); //Esta parado en Male
        computadora.siguienteSexo(); //Esta parado en Female
        computadora.siguienteHobby(); //Esta parado en Tennis
        computadora.siguienteHair(); //Esta parado en Brown
        computadora.siguienteFeature();
        computadora.siguienteFeature();
        computadora.siguienteFeature();
        computadora.siguienteFeature();
        computadora.siguienteFeature();*/

       // computadora.siguienteAuto();

        ArrayList<Delincuente> listaDelincuentesFiltrados = computadora.filtrar();

        //ordenArresto = listaDelincuentes.get(0);
         assertTrue(carmenSanDiego.comparar(listaDelincuentesFiltrados.get(0)));
    }
}
