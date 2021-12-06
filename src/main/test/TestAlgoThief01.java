import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAlgoThief01 {

    private final String directorio = "src/main/java/edu/fiuba/algo3/modelo/data.txt";

    @Test
    public void PruebaEntrarAEdificioPrimeraVezAumentaEnUnoHorario(){
        System.out.println("El directorio es:  " + directorio);
        System.out.println(new File("data.txt").getAbsolutePath());

        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief .entrarAEdificio(0);

        assertEquals("Monday 08:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioDosVecesAumentaHorarioTresHoras(){
        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);


        assertEquals( "Monday 10:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioDosVecesAumentaHorarioSeisHoras(){
        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);

        assertEquals( "Monday 13:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioDespuesDeEntrarTresVecesAumentaTresHoras(){

        AlgoThief algoThief = new AlgoThief(directorio);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 13:00", algoThief.obtenerHorario());

        algoThief.entrarAEdificio(0);
        assertEquals( "Monday 16:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioEnHorarioDeDormirAumentaOchoHoras(){

        AlgoThief algoThief = new AlgoThief(directorio);

        for(int i = 0; i < 6; i++){
            algoThief.entrarAEdificio(0);
        }
        assertEquals( "Tuesday 06:00", algoThief.obtenerHorario());
    }

   /* @Test
    public void PruebaEntrarAEdificioSinDelincuenteDespliegaUnaPistaDefault(){
        AlgoThief algoThief = new AlgoThief(directorio);
        assertEquals("El delincuente no visito este edificio", algoThief.entrarAEdificio(1));
    }*/
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
    @Test
    public void DesplegarTextoInicialConNombreObjetoAtributoSospechosoYAdemasVisitarUnBancoYDesplegarPista(){
        AlgoThief algothief = new AlgoThief(directorio);
        String texto = algothief.desplegarTextoInicial();
        System.out.println(texto);


        //algothief.mapa.ciudadesRecorridasPorDelincuente[1].obteneMoneda();
        //assertSame("Cambio la moneda a" + ciudadInicial.Moneda, pista);


        String pista = algothief.entrarAEdificio(0);
        //assertSame("Cambio la moneda a ... ", pista);


    }

    /*
    Caso de uso 2
        Detective novato comienza en Montreal.
        Vista un Banco (nuevamente):
        Se despliega una pista
        Vista una Biblioteca:
        Se despliega una pista.
    */
    @Test
    public void PoliciaVisitaBancoYBibliotecaYDesplieganPistas(){
     /*         AlgoThief algothief = new AlgoThief(directorio);
        algothief.entrarAEdificio(0);*/
    }

    /*
    Caso de uso 3
        Detective viaja de Montreal a México
    */
    @Test
    public void PoliciaViajaTiempoAvanza(){
        AlgoThief algothief = new AlgoThief(directorio);
        String horaSalida = algothief.obtenerHorario();

        ArrayList<Ciudad> lista = algothief.verOpcionesDeViaje();
        //algothief.viajarA(lista.get(0));
        System.out.println(lista.size());
        //System.out.println(lista.get(0).obtenerDato("City"));
        //System.out.println(lista.get(1).obtenerDato("City"));
        //System.out.println(lista.get(2).obtenerDato("City"));

        //String horaLlegada = algothief.obtenerHorario();
        //assertNotSame(horaSalida, horaLlegada);
    }

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
    @Test
    public void delincuenteAtacaAPoliciaYDespuesElPoliciaDuerme8hs(){

    }
//############################################################################################################
//############################################################################################################
//############################################################################################################
//############################################################################################################
//############################################################################################################


    @Test
    public void PruebaEntrarAEdificioQueVisitoDelincuenteDespliegaPistaEspecifica(){
        AlgoThief algoThief = new AlgoThief(directorio);
        String pista = algoThief.entrarAEdificio(0);

        //Está fallando porque la ciudad actual del policia, no coincide con una ciudad donde estuvo el delincuente
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