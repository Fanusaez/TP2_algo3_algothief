import edu.fiuba.algo3.modelo.policia.RangoDetective;
import edu.fiuba.algo3.modelo.fakes.AlgoThiefFake;
import edu.fiuba.algo3.modelo.Ciudad;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestEntregaDos {

    private final String directorioCiudades = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Ciudades.txt";
    private final String directorioDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";

    @Test
    public void policiaEntraUnEdificioEnLaUltimaCiudadadEsAtacadoYDuerme() {
        AlgoThiefFake algoThief = new AlgoThiefFake(directorioCiudades, directorioDelincuentes);
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
        AlgoThiefFake algoThief = new AlgoThiefFake(directorioCiudades,directorioDelincuentes);
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
