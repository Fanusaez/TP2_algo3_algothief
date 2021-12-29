import edu.fiuba.algo3.Model.Reloj;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestReloj {

    @Test
    public void TestInicial()
    {
        Reloj reloj = new Reloj();
        assertEquals("Monday 07:00",reloj.obtenerHorario() );
    }

    @Test
    public void TestAumentarHorario(){

        Reloj reloj = new Reloj();
        reloj.aumentarHoras(1);

        assertEquals("Monday 08:00",reloj.obtenerHorario());
    }

    @Test
    public void TestAumentarHorarioSobrepasandoVenticuatroHorasAumentaDia(){

        Reloj reloj = new Reloj();

        reloj.aumentarHoras(18);

        assertEquals("Tuesday 09:00",reloj.obtenerHorario() );
    }


    @Test
    public void TestDiferenciadetiempo(){
        Reloj reloj= new Reloj();
        reloj.aumentarHoras(75);
        assertEquals("You work it with 3 days and 3 hours, congratulations.",reloj.tiempoTranscurrido());

    }

    @Test
    public void TestAumentarHorarioDespuesDomingo17HorasLanzaError(){

    }

}
