import edu.fiuba.algo3.modelo.Reloj;
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

        for(int i = 0; i < 18; i++){
            reloj.aumentarHoras(1);
        }

        assertEquals("Tuesday 09:00",reloj.obtenerHorario() );
    }

}
