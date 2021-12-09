import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.CiudadProductiva;
import edu.fiuba.algo3.modelo.fakes.AlgoThiefFake;
import org.junit.Test;

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
        CiudadProductiva ciudadPoliciaInicial = algoThief.policia.ciudadActual;
        ArrayList<CiudadProductiva> destinosPosibles = algoThief.mapa.mostrarOpcionesViaje(algoThief.policia.ciudadActual);
        algoThief.viajar(destinosPosibles.get(0));
        assertEquals(destinosPosibles.get(0),algoThief.policia.ciudadActual);
    }
    @Test

    public void TestCasoUsoCuatro(){}

    // Caso de uso 5
    // Detective sufre una herida de cuchillo.
    // Detective duerme.

    @Test
    public void TestCasoUsoCincodelincuenteAtacaAPolicia(){
        AlgoThiefFake algoThief = new AlgoThiefFake(directorio);
        CiudadProductiva ciudadUltima = algoThief.obtenerUltimaCiudad();
        algoThief.setearCiudad(ciudadUltima);
        algoThief.entrarAEdificio(0);
        assertEquals("Monday 09:00", algoThief.obtenerHorario());

    }


}
