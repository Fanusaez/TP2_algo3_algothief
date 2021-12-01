import edu.fiuba.algo3.modelo.AlgoThief;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAlgoThief01 {

    @Test
    public void PruebaEntrarAEdificioPrimeraVezAumentaEnUnoHorario(){
        AlgoThief algoThief = new AlgoThief();
        algoThief.entrarAEdificio();

        assertEquals("Monday 08:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioDosVecesAumentaHorarioTresHoras(){
        AlgoThief algoThief = new AlgoThief();
        algoThief.entrarAEdificio();
        algoThief.entrarAEdificio();


        assertEquals( "Monday 10:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioDosVecesAumentaHorarioSeisHoras(){
        AlgoThief algoThief = new AlgoThief();
        algoThief.entrarAEdificio();
        algoThief.entrarAEdificio();
        algoThief.entrarAEdificio();

        assertEquals( "Monday 13:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioDespuesDeEntrarTresVecesAumentaTresHoras(){

        AlgoThief algoThief = new AlgoThief();
        algoThief.entrarAEdificio();
        algoThief.entrarAEdificio();
        algoThief.entrarAEdificio();
        assertEquals( "Monday 13:00", algoThief.obtenerHorario());

        algoThief.entrarAEdificio();
        assertEquals( "Monday 16:00", algoThief.obtenerHorario());
    }

    @Test
    public void PruebaEntrarAEdificioEnHorarioDeDormirAumentaOchoHoras(){

        AlgoThief algoThief = new AlgoThief();

        for(int i = 0; i < 6; i++){
            algoThief.entrarAEdificio();
        }
        assertEquals( "Tuesday 06:00", algoThief.obtenerHorario());
    }

//    @Test
//    public void PruebaEntrarAEdificioSinDelincuenteDespliegaUnaPista(){
//
//        AlgoThief algoThief = new AlgoThief();
//
//        assertEquals("El delincuente no visito este edificio", algoThief.entrarAEdificio());
//
//    }



}