import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.EstadoGanado;
import edu.fiuba.algo3.modelo.EstadoPerdido;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.dificultad.DificultadNovato;
import edu.fiuba.algo3.modelo.policia.RangoDetective;
import edu.fiuba.algo3.modelo.fakes.AlgoThiefFake;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestEntregaDos {

    private final String directorioCiudades = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Ciudades.txt";
    private final String directorioDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";

    @Test
    public void policiaEntraUnEdificioEnLaUltimaCiudadadEsAtacadoYDuerme() {
        AlgoThiefFake algoThief = new AlgoThiefFake(directorioCiudades, directorioDelincuentes);
        algoThief.setearCiudad(algoThief.obtenerUltimaCiudad()); //domingo 7 am
        algoThief.aumentarHorario(15);
        algoThief.entrarABanco(); // domingo 21pm + 1 hora cuchillo + 1 hora edificio + 8 dormir
        assertEquals("Tuesday 09:00",algoThief.obtenerHorario());
    }
    @Test
    public void policiaInvestigadorViajeDeMontrealAMexico(){
        AlgoThiefFake algoThief = new AlgoThiefFake(directorioCiudades, directorioDelincuentes);
        Ciudad mexico = algoThief.obtenerCiudad("Mexico City");
        mexico.obtenerDato("Currency");
        Ciudad montreal = algoThief.obtenerCiudad("Montreal");
        algoThief.ascenederPolicia(new RangoDetective());
        algoThief.setearCiudad(mexico);
        algoThief.viajar(montreal);
        assertEquals("Monday 08:00", algoThief.obtenerHorario());

    }

   @Test
    public void filtrarSinCargarDatosDevuelveTodosLosSospechosos(){
        Computadora computadora = new Computadora(directorioDelincuentes, new DificultadNovato());
        ArrayList<String> posiblesDelincuentes = computadora.filtrar(); // filtro nulo aparecen todos los delincuentes
        assertEquals(posiblesDelincuentes.size(), 10); // ver "actual"
    }

    @Test
    public void filtrarConDatosCargadosBuscoADelincuente(){

        Computadora computadora = new Computadora(directorioDelincuentes, new DificultadNovato());
        computadora.siguienteSex();
        computadora.siguienteSex(); //female
        computadora.siguienteHobby();
        computadora.siguienteHobby();
        computadora.siguienteHobby(); //mountain climbing
        computadora.siguientePelo(); // brown
        computadora.siguienteFeature();
        computadora.siguienteFeature();
        computadora.siguienteFeature();
        computadora.siguienteFeature();
        computadora.siguienteFeature(); // jewerly
        computadora.siguienteCar();
        computadora.siguienteCar(); //limousine
        ArrayList<String> nombresDeSospechosos = computadora.filtrar(); // filtro nulo aparecen todos los delincuentes
        assertEquals("Merey Laroc",nombresDeSospechosos.get(0)); // ver "actual"

    }

    @Test
    public void intentarAtraparAlDelincuenteSinOrdenDeArresto(){
        AlgoThiefFake algoThief = new AlgoThiefFake(directorioCiudades, directorioDelincuentes);
        algoThief.setearCiudad(algoThief.obtenerUltimaCiudad());
        algoThief.entrarAAeropuerto();
        algoThief.entrarAAeropuerto();
        algoThief.entrarAAeropuerto();
        //entro una vez mas y debe intentar capturar al delincuente
        assertTrue( algoThief.getEstadoJuego() instanceof EstadoPerdido);
    }

    @Test
    public void arrestarDelincuenteConOrdenDeArrestoGanaPartida(){
        AlgoThiefFake algoThief = new AlgoThiefFake(directorioCiudades,directorioDelincuentes);
        algoThief.setearCiudad(algoThief.obtenerUltimaCiudad());
        algoThief.entrarAAeropuerto();
        algoThief.entrarAAeropuerto();

        String nombreDelincuente = algoThief.getDelincuenteNombre();

        algoThief.crearOrdenDeArrestoPara(nombreDelincuente);

        algoThief.entrarAAeropuerto();

        assertTrue(algoThief.getEstadoJuego() instanceof EstadoGanado);
    }

}
