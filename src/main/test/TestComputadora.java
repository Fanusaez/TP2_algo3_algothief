import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import org.junit.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestComputadora {

    private final String directorioDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";

    @Test
    public void testDevolverListadoSinFiltrosYDevuelveElUnicoDelincuenteQueEsCarmenSanDiego() {

        ArrayList<Delincuente> listaDelincuentes = new ArrayList<Delincuente>();

        Delincuente carmenSanDiego = new Delincuente();
        carmenSanDiego.agregarDato("Name", "Carmen Sandiego");
        carmenSanDiego.agregarDato("Sex", "female");
        carmenSanDiego.agregarDato("Hobby", "tennis");
        carmenSanDiego.agregarDato("Hair", "brown");
        carmenSanDiego.agregarDato("Feature", "jewelry");
        carmenSanDiego.agregarDato("Auto", "convertible");

        listaDelincuentes.add(carmenSanDiego);
        Computadora computadora = new Computadora(directorioDelincuentes);

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
        assertTrue(carmenSanDiego.comparar(listaDelincuentesFiltrados.get(9)));
    }

    @Test
    public void TestFiltrarSospechosasMujeres() {
        Computadora computadora = new Computadora(directorioDelincuentes);
        computadora.siguienteSexo(); //Selecciona opción Male
        computadora.siguienteSexo(); //Selecciona opción Female

        //Va a filtrar por el atributo Female
        ArrayList<Delincuente> listaDelincuentesFiltrados = computadora.filtrar();
        for (Delincuente unDelincuente : listaDelincuentesFiltrados) {
            assertEquals(unDelincuente.obtenerDato("Sex"), "Female");
        }
    }
}