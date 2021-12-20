import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.policia.Policia;
import edu.fiuba.algo3.modelo.fakes.PoliciaFake;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPolicia {

    @Test
    public void policiaRealiza5ArrestosYAumentaVelocidad(){
        PoliciaFake policia = new PoliciaFake(new Ciudad()); // Dependencia con Ciudad
        int velocidad1= policia.obtenerVelocidad();
        policia.realizarArresto();
        policia.realizarArresto();
        policia.realizarArresto();
        policia.realizarArresto();
        policia.realizarArresto();
        int velocidad2 = policia.obtenerVelocidad();
        assertTrue(velocidad1 != velocidad2);

    }

    @Test
    public void policiaRealiza4ArrestosYNoAumentaVelocidad(){
        PoliciaFake policia = new PoliciaFake(new Ciudad()); // Dependencia con Ciudad
        int velocidad1= policia.obtenerVelocidad();
        policia.realizarArresto();
        policia.realizarArresto();
        policia.realizarArresto();
        policia.realizarArresto();
        int velocidad2 = policia.obtenerVelocidad();
        assertTrue(velocidad1 == velocidad2);

    }



}
