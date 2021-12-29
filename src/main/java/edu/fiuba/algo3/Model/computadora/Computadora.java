package edu.fiuba.algo3.Model.computadora;

import edu.fiuba.algo3.Model.EstadoJuegoInterfaz;
import edu.fiuba.algo3.Model.Parser.ParserArchivo;
import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.Model.dificultad.DificultadJuego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Computadora {
    private ArrayList<Delincuente> sospechosos;
    private Delincuente delincuente;
    ArrayList<ArrayList<String>> caracteristicasGenerales;
    OrdenDeArresto ordenArresto;

    public Computadora(String rutaArchivoDelincuentes, DificultadJuego dificultad){
        this.caracteristicasGenerales = new ArrayList<ArrayList<String>>();
        for(int i=0; i<=5; i++){
            caracteristicasGenerales.add(new ArrayList<>(Arrays.asList("")));
        }
        this.sospechosos = ParserArchivo.parsearDelincuentes(rutaArchivoDelincuentes, dificultad, caracteristicasGenerales);
        this.delincuente = sospechosos.get(new Random().nextInt(sospechosos.size()));
        this.ordenArresto = new OrdenDeArresto();
    }

    public String getSexoSeleccionado() {
        return caracteristicasGenerales.get(1).get(0);
    }

    public void siguientePelo(){
        ArrayList<String> aux = caracteristicasGenerales.get(3);
        aux.add(aux.remove(0));
    }

    public void siguienteSex(){
        ArrayList<String> aux = caracteristicasGenerales.get(1);
        aux.add(aux.remove(0));

    }

    public void siguienteCar(){
        ArrayList<String> aux = caracteristicasGenerales.get(5);
        aux.add(aux.remove(0));

    }

    public void siguienteFeature(){
        ArrayList<String> aux = caracteristicasGenerales.get(4);
        aux.add(aux.remove(0));

    }

    public void siguienteHobby(){
        ArrayList<String> aux = caracteristicasGenerales.get(2);
        aux.add(aux.remove(0));

    }


    public ArrayList<String> mostrarOpcionesSeleccionadas(){
        ArrayList<String> result = new ArrayList<>();
        result.add(caracteristicasGenerales.get(1).get(0));
        result.add(caracteristicasGenerales.get(2).get(0));
        result.add(caracteristicasGenerales.get(3).get(0));
        result.add(caracteristicasGenerales.get(4).get(0));
        result.add(caracteristicasGenerales.get(5).get(0));
        return result;
    }

    public Delincuente ObtenerDelincuenteRandom(){
        return delincuente;
       // return sospechosos.get(new Random().nextInt(sospechosos.size()));
    }

    public void crearOrdenDeArrestoPara(String unNombreDelincuente){
        ordenArresto.setNombre(unNombreDelincuente);
    }

    public ArrayList<String> filtrar(){
        System.out.println(mostrarOpcionesSeleccionadas());
        ArrayList<String> listadoSospechososFiltrados = Filtrador.filtrar(mostrarOpcionesSeleccionadas(),sospechosos);
        if(listadoSospechososFiltrados.size() == 1){
            crearOrdenDeArrestoPara(listadoSospechososFiltrados.get(0));
        }
        return listadoSospechososFiltrados;
    }

    /*public EstadoJuegoInterfaz realizarArresto(String nombreDelincuente){
        return ordenArresto.realizarArresto(nombreDelincuente);
    }*/

    public EstadoJuegoInterfaz realizarArresto() {
        return ordenArresto.realizarArresto(delincuente.getNombre());
    }

    public String getHobbySeleccionado() {
        return caracteristicasGenerales.get(2).get(0);
    }

    public String getHairSeleccionado() {
        return caracteristicasGenerales.get(3).get(0);
    }

    public String getFeatureSeleccionado() {
        return caracteristicasGenerales.get(4).get(0);
    }

    public String getCarSeleccionado() {
        return caracteristicasGenerales.get(5).get(0);
    }
}
