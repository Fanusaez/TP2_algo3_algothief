import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad; // este import no esta bueno, no deberiamos depender de otra clase para probarla
import edu.fiuba.algo3.modelo.Edificios.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestEdificio {

    @Test
    public void distintosEdificiosQueNoGeneraronPistaMuestranMismaPista(){
        Edificio banco = new Banco();
        Edificio aeropuerto = new Aeropuerto();

        String pistaBanco = banco.mostrarPista();
        String pistaAeropuerto = aeropuerto.mostrarPista();

        assertEquals(pistaAeropuerto, pistaBanco);
    }

    @Test
    public void distintosEdificiosQueGeneraronPistaNoMuestranMismaPista(){
        Edificio banco = new Banco();
        Edificio aeropuerto = new Aeropuerto();
        Ciudad ciudad = new Ciudad();
        Delincuente delincuente = new Delincuente();
        delincuente.agregarDato("Sex","male");
        delincuente.agregarDato("Hobby","Tennis");
        delincuente.agregarDato("Auto","male");
        delincuente.agregarDato("Hair","Black");
        delincuente.agregarDato("Feature","Jewelry");

        ciudad.agregarDato("Currency", "platita");
        ciudad.agregarDato("Flag", "banderita");
        banco.generarPistaEdificio(ciudad, delincuente);
       // banco.generarPistaEdificio(ciudad,"El delincuente cambio");
        aeropuerto.generarPistaEdificio(ciudad, delincuente);
        String pistaBanco = banco.mostrarPista();
        String pistaAeropuerto = aeropuerto.mostrarPista();

        assertNotEquals(pistaAeropuerto, pistaBanco);
    }

    @Test
    public void mismosEdifiosQueGeneraronPistaConDistintaCiudadMuestranDistintaPista(){
        Edificio banco1 = new Banco();
        Edificio banco2 = new Banco();
        Ciudad ciudad1 = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        Delincuente delincuente = new Delincuente();
        delincuente.agregarDato("Sex","male");
        delincuente.agregarDato("Hobby","Tennis");
        delincuente.agregarDato("Auto","male");
        delincuente.agregarDato("Hair","Black");
        delincuente.agregarDato("Feature","Jewelry");

        ciudad1.agregarDato("Currency", "platita1");
        ciudad1.agregarDato("Flag", "banderita1");
        ciudad2.agregarDato("Currency", "platita2");
        ciudad2.agregarDato("Flag", "banderita2");
        banco1.generarPistaEdificio(ciudad1, delincuente);
        banco2.generarPistaEdificio(ciudad2, delincuente);
        String pistaBanco1 = banco1.mostrarPista();
        String pistaBanco2 = banco2.mostrarPista();

        assertNotEquals(pistaBanco1, pistaBanco2);
    }

    @Test
    public void visitarEdificioUnaVezDemoraUno(){
        Edificio banco = new Banco();

        int demora = banco.visitar();
        assertTrue(demora == 1);
    }

    @Test
    public void visitarEdificioDosVecesDemoraDos(){
        Edificio banco = new Banco();

        int demora = banco.visitar();
        demora = banco.visitar();

        assertTrue(demora == 2);
    }

    @Test
    public void visitarEdificioTresVecesDemoraTres(){
        Edificio banco = new Banco();

        int demora = banco.visitar();
        demora = banco.visitar();
        demora = banco.visitar();

        assertTrue(demora == 3);
    }

    @Test
    public void visitarEdificioCuatroVecesDemoraTres(){
        Edificio banco = new Banco();

        int demora = banco.visitar();
        demora = banco.visitar();
        demora = banco.visitar();
        demora = banco.visitar();

        assertTrue(demora == 3);
    }
}
