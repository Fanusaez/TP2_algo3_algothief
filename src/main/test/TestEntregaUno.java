import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.fakes.AlgoThiefFake;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestEntregaUno {
    private final String directorio = "src/main/java/edu/fiuba/algo3/modelo/data.txt";

    @Test
    public void TestCasoUsoUnoRobaronElTesoroNacionaldeMontreal() {
        AlgoThief algoThief = new AlgoThief(directorio);
    }

    @Test
    public void TestCasoUsoDosEntrarAEdificioEnCiudadInicialDespliegaUnaNoPistaDefault(){
        AlgoThief algoThief = new AlgoThief(directorio);
        assertNotSame("El delincuente no visito este edificio", algoThief.entrarAEdificio(1));
    }

    @Test
    public void casoUsoTresDetectiveViajaDeUnaCiudadAOtraYPoliciaCambiaDeCiudad(){
        AlgoThief algoThief = new AlgoThief(directorio);
        Ciudad ciudadPoliciaInicial = algoThief.policia.ciudadActual;
        ArrayList<Ciudad> destinosPosibles = algoThief.policia.mostrarOpcionesViaje();
        algoThief.viajar(destinosPosibles.get(0));
        assertEquals(destinosPosibles.get(0),algoThief.policia.ciudadActual);
    }
    @Test

    public void TestCasoUsoCuatro(){}

    // Caso de uso 5
    // Detective sufre una herida de cuchillo.
    // Detective duerme.

    //@Test
    //public void TestCasoUsoCincodelincuenteAtacaAPolicia(){
    //    AlgoThiefFake algoThief = new AlgoThiefFake(directorio);
    //    Ciudad ciudadUltima = algoThief.obtenerUltimaCiudad();
    //    algoThief.setearCiudad(ciudadUltima);
    //    algoThief.entrarAEdificio(0);
    //    assertEquals("Monday 09:00", algoThief.obtenerHorario());
//
    //}


}
