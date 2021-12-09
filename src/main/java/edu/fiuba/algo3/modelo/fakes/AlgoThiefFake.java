package edu.fiuba.algo3.modelo.fakes;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.CosasDelincuente.CreadorDelincuentes;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.util.ArrayList;

public class AlgoThiefFake  implements AlgoThiefInterfaz {
    public PoliciaFake policia;
    private Reloj reloj;

    public MapaFake mapa;
    private Delincuente delincuente;
    private CreadorDelincuentes creadorDeDelincuentes;

    public AlgoThiefFake(String rutaArchivoCiudades) {

        this.creadorDeDelincuentes = new CreadorDelincuentes(rutaArchivoCiudades);
        this.delincuente =  this.creadorDeDelincuentes.seleccionarDelincuenteAleatorio();
        this.mapa = new MapaFake(rutaArchivoCiudades);
        this.mapa.EstablecerPistasEnElRecorrido(this.delincuente);
        mapa.establecerOpcionesDeViaje();
        Ciudad ciudadInicial = mapa.obtenerCiudadInicial();
        this.policia = new PoliciaFake(ciudadInicial);
        this.reloj = new Reloj();
    }
    public String desplegarTextoInicial(){
        String texto = "***FLASH***\n" +
                "National treasure stolen from Port Moresby.\n" +
                "The treasure has been identified as an ancient\n" +
                "tribal totem." +
                "Female suspect reported at the scene of the crime.\n" +
                "Your assignment:\n" +
                "Track the thief from Port Moresby to her\n" +
                "hideout and arrest her!\n" +
                "You must apprehend the thief by Sunday, 5pm.\n" +
                "Good luck, Rookie <nombreUsuario>.\n" +
                "\n";
        return texto;
    }

    public String obtenerHorario(){

        return reloj.obtenerHorario();
    }

    public void chequearAtaque(){
        if (mapa.estaEnUltimaCiudad(policia.ciudadActual)) {
            reloj.aumentarHoras(delincuente.atacar());
        }
    }

    public String entrarAEdificio(int indice) {
        this.chequearAtaque();
        return policia.entrarAEdificio(indice);
    }


    public ArrayList<Ciudad> verOpcionesDeViaje() {
        return mapa.mostrarOpcionesViaje(policia.ciudadActual);
    }

    public void viajar(Ciudad destinoSeleccionado) {
        reloj.aumentarHoras(policia.viajar(destinoSeleccionado));

    }



    public Ciudad getCiudadPolicia(){
        return policia.getCiudadActual();
    }

    public void setearCiudad(Ciudad ciudadSeleccionada){policia.setearCiudad(ciudadSeleccionada);}

    public Ciudad obtenerUltimaCiudad(){
        return this.mapa.obtenerUltimaCiudadDelincuente();
    }

}
