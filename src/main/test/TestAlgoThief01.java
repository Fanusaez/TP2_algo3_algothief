import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.fakes.AlgoThiefFake;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAlgoThief01 {

    private final String directorioCiudades = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Ciudades.txt";
    private final String directorioDelincuentes = "src/main/java/edu/fiuba/algo3/modelo/ArchivosDeTexto/Delincuentes.txt";

    @Test
    public void Test01EntrarAEdificioPrimeraVezAumentaEnUnoHorario(){

        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        algoThief.entrarAEdificio(0);

        assertEquals("Monday 08:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test02EntrarAEdificioDosVecesAumentaHorarioTresHoras(){
        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);


        assertEquals( "Monday 10:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test03EntrarAEdificioDosVecesAumentaHorarioSeisHoras(){
        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 13:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test04EntrarAEdificioDespuesDeEntrarTresVecesAumentaTresHoras(){

        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 13:00", algoThief.obtenerHorario());

        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 16:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test05EntrarAEdificioEnHorarioDeDormirAumentaOchoHoras(){

        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);

        for(int i = 0; i < 6; i++){
            algoThief.entrarAEdificio(0);
        }
        assertEquals( "Tuesday 06:00", algoThief.obtenerHorario());
    }



    @Test
    public void Test07PoliciaViajaTiempoAvanza(){
        AlgoThief algothief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        String horaSalida =  algothief.obtenerHorario();
        ArrayList<Ciudad> listaOpcionesViaje = algothief.verOpcionesDeViaje();
        Ciudad ciudadSeleccionada = listaOpcionesViaje.get(1);
        algothief.viajar(ciudadSeleccionada);
        ArrayList<Ciudad> listaOpcionesViaje2 = algothief.verOpcionesDeViaje();
        algothief.viajar(listaOpcionesViaje2.get(0));
        ArrayList<Ciudad> listaOpcionesViaje3 = algothief.verOpcionesDeViaje();
        String horaLlegada =  algothief.obtenerHorario();
        assertNotSame(horaSalida, horaLlegada);
    }

    @Test
    public void Test08MostrarOpcionesViajeEnCiudadDestinoContieneACiudadOrigen(){

        AlgoThief algothief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        Ciudad ciudadOrigen= algothief.policia.ciudadActual;
        ArrayList<Ciudad> listaOpcionesViajeOrigen = algothief.verOpcionesDeViaje();
        Ciudad ciudadDestino = listaOpcionesViajeOrigen.get(0);
        algothief.viajar(ciudadDestino);
        ArrayList<Ciudad> listaOpcionesViajeDestino = algothief.verOpcionesDeViaje();

        assertTrue(listaOpcionesViajeDestino.contains(ciudadOrigen));
    }

    @Test
    public void Test09MostrarOpcionesViajeEnCiudadNoRecorridaYContieneACiudadOrigen(){
        AlgoThief algothief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        Ciudad ciudadOrigen= algothief.policia.ciudadActual;
        ArrayList<Ciudad> listaOpcionesViajeOrigen = algothief.verOpcionesDeViaje();
        Ciudad ciudadDestino = listaOpcionesViajeOrigen.get(1);
        algothief.viajar(ciudadDestino);
        ArrayList<Ciudad> listaOpcionesViajeDestino = algothief.verOpcionesDeViaje();

        assertTrue(listaOpcionesViajeDestino.contains(ciudadOrigen));
    }


    @Test
    public void Test10(){
        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);
    }

    @Test
    public void Test11Presentacion(){
        AlgoThiefFake algoThief = new AlgoThiefFake(directorioCiudades,directorioDelincuentes);
        algoThief.ingresarUsuario("juan");
        Ciudad ciudad = algoThief.obtenerCiudad("Port Moresby");
        algoThief.setearCiudadInicial(ciudad);
        Delincuente delincuente = new Delincuente();
        delincuente.agregarDato("Sex", "Female");
        ciudad.agregarDato("Treasure", "ancient tribal totem");
        algoThief.setearDelincuente(delincuente);

        assertEquals(algoThief.desplegarTextoInicial(),"***FLASH***\n" +
                "National treasure stolen from Port Moresby.\n" +
                "The treasure has been identified as an ancient" +
                " tribal totem.\n" +
                "Female suspect reported at the scene of the crime.\n" +
                "Your assignment:\n" +
                "Track the thief from Port Moresby to her" +
                " hideout and arrest her !\n" +
                "You must apprehend the thief by Sunday, 5pm.\n" +
                "Good luck,"+ "juan"+"\n" +
                "\n");
    }

    @Test
    public void PruebaEntrarAEdificioQueVisitoDelincuenteDespliegaPistaEspecifica(){
        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);
        String pista = algoThief.entrarAEdificio(0);
        assertNotSame("El delincuente no visito este edificio", pista);
    }

    @Test
    public void PruebaEntrarAEdificioConDelincuenteAtacarPoliciaAumentaHorario(){
        AlgoThief algoThief = new AlgoThief(directorioCiudades,directorioDelincuentes);

        String pista = algoThief.entrarAEdificio(0);
    }



 /*   @Test
    public void CreoUnAlgoThiefYMiroAlDelincuente(){
        AlgoThief algoThief = new AlgoThief(directorio);
        Delincuente delincuente=algoThief.obtenerDelincuente();
        ArrayList<String> pelos = new ArrayList<String>();
        pelos.add("Red");
        pelos.add("Blond");
        pelos.add("Brown");
        pelos.add("Black");

        assertTrue(pelos.contains(delincuente.obtenerDato("hair")) );
    }*/
}