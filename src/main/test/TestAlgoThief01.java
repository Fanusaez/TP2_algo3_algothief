import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Delincuente;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAlgoThief01 {

    private final String directorio = "src\\main\\java\\edu\\fiuba\\algo3\\modelo\\data.txt";

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

    @Test
    public void PruebaEntrarAEdificioSinDelincuenteDespliegaUnaPistaDefault(){

        AlgoThief algoThief = new AlgoThief(directorio);
        assertEquals("El delincuente no visito este edificio", algoThief.entrarAEdificio(1));

    }

    //@Test
    //public void PruebaEntrarAEdificioQueVisitoDelincuenteDespliegaPistaEspecifica(){
//
    //    AlgoThief algoThief = new AlgoThief();
    //    String pista = algoThief.entrarAEdificio(0);
//
//
    //    assertNotSame("El delincuente no visito este edificio", pista);
    //    System.out.println(pista);
//
    //}

    @Test
    public void PruebaEntrarAEdificioConDelincuenteAtacarPoliciaAumentaHorario(){
        AlgoThief algoThief = new AlgoThief(directorio);

        String pista = algoThief.entrarAEdificio(0);
    }



    @Test
    public void CreoUnAlgoThiefYMiroAlDelincuente(){
        AlgoThief algoThief = new AlgoThief(directorio);
        Delincuente delincuente=algoThief.obtenerDelincuente();
        ArrayList<String> pelos = new ArrayList<String>();
        pelos.add("Red");
        pelos.add("Blond");
        pelos.add("Brown");
        pelos.add("Black");

        assertTrue(pelos.contains(delincuente.obtenerDato("hair")) );
    }
}