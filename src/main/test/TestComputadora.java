import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.dificultad.DificultadInvestigador;
import edu.fiuba.algo3.modelo.dificultad.DificultadNovato;
import edu.fiuba.algo3.modelo.policia.Policia;
import org.junit.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestComputadora {

    private final String directorioDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";

    @Test
    public void testDevolverListadoSinFiltrosYDevuelveTodosLosDelincuentes() {



        Computadora computadora = new Computadora(directorioDelincuentes, new DificultadNovato());
        ArrayList<Delincuente> listaDelincuentesFiltrados = computadora.filtrar();
        assertEquals(10,listaDelincuentesFiltrados.size());
    }

    @Test
    public void TestFiltrarSospechosasMujeres() {

        Computadora computadora = new Computadora(directorioDelincuentes,new DificultadNovato());
        computadora.siguienteSexo(); //Selecciona opción Male
        computadora.siguienteSexo(); //Selecciona opción Female

        //Va a filtrar por el atributo Female
        ArrayList<Delincuente> listaDelincuentesFiltrados = computadora.filtrar();
        for (Delincuente unDelincuente : listaDelincuentesFiltrados) {
            assertEquals(unDelincuente.obtenerDato("Sex"), "Female");
        }
    }
}