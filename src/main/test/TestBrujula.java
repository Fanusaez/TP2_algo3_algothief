import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.fakes.AlgoThiefFake;
import edu.fiuba.algo3.modelo.policia.Brujula;
import org.junit.Assert;
import org.junit.Test;

public class TestBrujula {

    @Test
    public void TestCalcularDistanciaDesdeAmericaAAmerica(){
        Brujula brujula = new Brujula();
        Ciudad lima = new Ciudad();
        Ciudad buenosAires = new Ciudad();
        lima.agregarDato("Continent", "America");
        buenosAires.agregarDato("Continent", "America");
        int distancia =brujula.calcularDistanciaEntre(lima, buenosAires);
        Assert.assertEquals(1800, distancia);
    }

    @Test
    public void TestCalcularDistanciaDesdeAfricaAAmerica(){
        Brujula brujula = new Brujula();
        Ciudad moroni = new Ciudad();
        Ciudad buenosAires = new Ciudad();
        moroni.agregarDato("Continent", "Africa");
        buenosAires.agregarDato("Continent", "America");
        int distancia = brujula.calcularDistanciaEntre(moroni, buenosAires);
        Assert.assertEquals(3500, distancia);
    }


}
