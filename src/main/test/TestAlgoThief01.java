import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAlgoThief01 {

    private final String directorio = "src/main/java/edu/fiuba/algo3/modelo/data.txt";

    @Test
    public void Test01EntrarAEdificioPrimeraVezAumentaEnUnoHorario(){

        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief.entrarAEdificio(0);

        assertEquals("Monday 08:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test02EntrarAEdificioDosVecesAumentaHorarioTresHoras(){
        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);


        assertEquals( "Monday 10:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test03EntrarAEdificioDosVecesAumentaHorarioSeisHoras(){
        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 13:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test04EntrarAEdificioDespuesDeEntrarTresVecesAumentaTresHoras(){

        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 13:00", algoThief.obtenerHorario());

        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 16:00", algoThief.obtenerHorario());
    }

    @Test
    public void Test05EntrarAEdificioEnHorarioDeDormirAumentaOchoHoras(){

        AlgoThief algoThief = new AlgoThief(directorio);

        for(int i = 0; i < 6; i++){
            algoThief.entrarAEdificio(0);
        }
        assertEquals( "Tuesday 06:00", algoThief.obtenerHorario());
    }



    @Test
    public void Test07PoliciaViajaTiempoAvanza(){

        AlgoThief algothief = new AlgoThief(directorio);

        String horaSalida =  algothief.obtenerHorario();
        ArrayList<Ciudad> listaOpcionesViaje = algothief.verOpcionesDeViaje();
        Ciudad ciudadSeleccionada = listaOpcionesViaje.get(0);
        algothief.viajar(ciudadSeleccionada);

        System.out.println(listaOpcionesViaje.get(0).obtenerDato("city"));
        System.out.println(listaOpcionesViaje.get(1).obtenerDato("city"));
        System.out.println(listaOpcionesViaje.get(2).obtenerDato("city"));
        ArrayList<Ciudad> listaOpcionesViaje2 = algothief.verOpcionesDeViaje();
        System.out.println(listaOpcionesViaje2.size());
        System.out.println(listaOpcionesViaje2.get(0).obtenerDato("city"));
        System.out.println(listaOpcionesViaje2.get(1).obtenerDato("city"));
        System.out.println(listaOpcionesViaje2.get(2).obtenerDato("city"));
        algothief.viajar(listaOpcionesViaje2.get(0));
        ArrayList<Ciudad> listaOpcionesViaje3 = algothief.verOpcionesDeViaje();
        System.out.println(listaOpcionesViaje3.get(0).obtenerDato("city"));
        System.out.println(listaOpcionesViaje3.get(1).obtenerDato("city"));
        System.out.println(listaOpcionesViaje3.get(2).obtenerDato("city"));

        String horaLlegada =  algothief.obtenerHorario();

        assertNotSame(horaSalida, horaLlegada);
    }

    @Test
    public void Test08MostrarOpcionesViajeEnCiudadDestinoContieneACiudadOrigen(){

        AlgoThief algothief = new AlgoThief(directorio);
        Ciudad ciudadOrigen= algothief.policia.ciudadActual;
        ArrayList<Ciudad> listaOpcionesViajeOrigen = algothief.verOpcionesDeViaje();
        Ciudad ciudadDestino = listaOpcionesViajeOrigen.get(0);
        algothief.viajar(ciudadDestino);
        ArrayList<Ciudad> listaOpcionesViajeDestino = algothief.verOpcionesDeViaje();

        assertTrue(listaOpcionesViajeDestino.contains(ciudadOrigen));
    }

    @Test
    public void Test09MostrarOpcionesViajeEnCiudadNoRecorridaYContieneACiudadOrigen(){
        AlgoThief algothief = new AlgoThief(directorio);
        Ciudad ciudadOrigen= algothief.policia.ciudadActual;
        ArrayList<Ciudad> listaOpcionesViajeOrigen = algothief.verOpcionesDeViaje();
        Ciudad ciudadDestino = listaOpcionesViajeOrigen.get(1);
        algothief.viajar(ciudadDestino);
        ArrayList<Ciudad> listaOpcionesViajeDestino = algothief.verOpcionesDeViaje();

        assertTrue(listaOpcionesViajeDestino.contains(ciudadOrigen));
    }

//############################################################################################################
//############################################################################################################
//#########################|| CASOS DE USO PARA LA ENTREGA 1 ||###############################################
//############################################################################################################
//############################################################################################################

    /*Caso de uso 1
        Robaron el tesoro Nacional de Montreal.
        Sospechoso femenino.
        Detective novato comienza en Montreal.
        Vista un Banco:
        Se despliega una pista.
    */

    /*
    Caso de uso 2
        Detective novato comienza en Montreal.
        Vista un Banco (nuevamente):
        Se despliega una pista
        Vista una Biblioteca:
        Se despliega una pista.
    */

    /*
    Caso de uso 3
        Detective viaja de Montreal a México
    */

    /*
    Caso de uso 4
        Vista un Aeropuerto (3 veces):
        Se despliega una pista.
        Vista un Puerto (55 veces):
        Se despliega una pista.
    */
    @Test
    public void PoliciaVisita3VecesAeropuertoYVisita55VecesUnPuertoYDesplieganPistas(){


    }

    /*
    Caso de uso 5
        Detective sufre una herida de cuchillo.
        Detective duerme.
    */


//############################################################################################################
//############################################################################################################
//############################################################################################################
//############################################################################################################
//############################################################################################################


    @Test
    public void PruebaEntrarAEdificioQueVisitoDelincuenteDespliegaPistaEspecifica(){
        AlgoThief algoThief = new AlgoThief(directorio);
        String pista = algoThief.entrarAEdificio(0);
        System.out.println(pista);
        assertNotSame("El delincuente no visito este edificio", pista);
    }

    @Test
    public void PruebaEntrarAEdificioConDelincuenteAtacarPoliciaAumentaHorario(){
        AlgoThief algoThief = new AlgoThief(directorio);

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