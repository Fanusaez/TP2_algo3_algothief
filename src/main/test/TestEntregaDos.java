import edu.fiuba.algo3.modelo.Brujula;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.RangoDetective;
import edu.fiuba.algo3.modelo.fakes.AlgoThiefFake;
import edu.fiuba.algo3.modelo.fakes.PoliciaFake;
import edu.fiuba.algo3.modelo.Ciudad;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestEntregaDos {

    private final String directorio = "src/main/java/edu/fiuba/algo3/modelo/data.txt";


    @Test
    public void policiaEntraUnEdificioEnLaUltimaCiudadadEsAtacadoYDuerme() {
        AlgoThiefFake algoThief = new AlgoThiefFake(directorio);
        algoThief.setearCiudad(algoThief.obtenerUltimaCiudad()); //domingo 7 am
        algoThief.entrarAEdificio(0); // domingo 7am + 1 hora cuchillo + 1 hora edificio
        algoThief.entrarAEdificio(0); // domingo 9am + 1 hora cuchillo + 2 hora edificio
        algoThief.entrarAEdificio(0); // domingo 12am + 1 hora cuchillo + 3 hora edificio
        algoThief.entrarAEdificio(0); // domingo 16pm + 1 hora cuchillo + 3 hora edificio
        algoThief.entrarAEdificio(0); // domingo 20pm + 1 hora cuchillo + 3 hora edificio
        assertEquals("Tuesday 08:00",algoThief.obtenerHorario());
    }
    @Test
    public void policiaInvestigadorViajeDeMontrealAMexico(){
        AlgoThiefFake algoThief = new AlgoThiefFake(directorio);
        Ciudad mexico = algoThief.obtenerCiudad("Mexico");
        Ciudad montreal = algoThief.obtenerCiudad("Montreal");
        algoThief.ascenederPolicia(new RangoDetective());
        algoThief.setearCiudad(mexico);
        algoThief.viajar(montreal);
        assertEquals("Monday 08:00", algoThief.obtenerHorario());
    }

    @Test
    public void SeCarganLosDatosDelSospechosoEnLaComputadoraYSeBuscanLosSospechosos(){

    }

}
