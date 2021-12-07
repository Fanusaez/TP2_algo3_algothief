import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestEntregaUno {
    private final String directorio = "src/main/java/edu/fiuba/algo3/modelo/data.txt";

    @Test
    public void TestCasoUsoUnoRobaronElTesoroNacionaldeMontreal() {
        //assertEquals(1==1);
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
        ArrayList<Ciudad> destinosPosibles = algoThief.mapa.mostrarOpcionesViaje(algoThief.policia.ciudadActual);
        algoThief.viajar(destinosPosibles.get(0));
        assertEquals(destinosPosibles.get(0),algoThief.policia.ciudadActual);
    }
    @Test

    public void TestCasoUsoCuatro(){}


    @Test
    public void TestCasoUsoCincodelincuenteAtacaAPolicia(){
        AlgoThief algoThief = new AlgoThief(directorio);
        Ciudad ciudadUltima = algoThief.obtenerUltimaCiudad();
        algoThief.policia.setearCiudad(ciudadUltima);
        algoThief.entrarAEdificio(0);
        assertEquals("Monday 09:00", algoThief.obtenerHorario());

    }


}
