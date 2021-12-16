import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.dificultad.DificultadNovato;
import org.junit.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestComputadora {

    private final String directorioDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";

    @Test
    public void testDevolverListadoSinFiltrosYDevuelveTodosLosDelincuentes() {

        Computadora computadora = new Computadora(directorioDelincuentes, new DificultadNovato());
        ArrayList<String> listaDelincuentesFiltrados = computadora.filtrar();
        assertEquals(10,listaDelincuentesFiltrados.size());
    }

 /*   @Test
    public void TestFiltrarSospechosasMujeres() {

        Computadora computadora = new Computadora(directorioDelincuentes,new DificultadNovato());
        computadora.siguienteSex(); //Selecciona opción Male
        computadora.siguienteSex(); //Selecciona opción Female

        //Va a filtrar por el atributo Female
        ArrayList<String> listaDelincuentesFiltrados = computadora.filtrar();
        for (String unDelincuente : listaDelincuentesFiltrados) {
            assertEquals(unDelincuente.obtenerDato("Sex"), "Female");
        }
    }*/
}