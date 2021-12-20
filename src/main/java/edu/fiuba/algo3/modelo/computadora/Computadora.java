package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.Parser.ParserArchivo;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.dificultad.DificultadJuego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Computadora {
    private ArrayList<Delincuente> sospechosos;
    private Delincuente delincuente;
    private Filtrador filtrador;
    ArrayList<String> posiblesColoresPelo;
    ArrayList<String> posiblesAutomoviles;
    ArrayList<String> posiblesSexos;
    ArrayList<String> posiblesHobbys;
    ArrayList<String> posiblesSenias;
    OrdenDeArresto ordenArresto;
    ArrayList<String> filtrados;

    public Computadora(String rutaArchivoDelincuentes, DificultadJuego dificultad){
        this.sospechosos = ParserArchivo.parsearDelincuentes(rutaArchivoDelincuentes, dificultad);
        this.filtrador = new Filtrador();
        this.delincuente = sospechosos.get(new Random().nextInt(sospechosos.size()));
        this.posiblesColoresPelo = new ArrayList<>(Arrays.asList("???","Brown", "Blond", "Red", "Black"));
        this.posiblesAutomoviles = new ArrayList<>(Arrays.asList("???","Convertible", "Limousine", "Race car", "Motorcycle"));
        this.posiblesHobbys = new ArrayList<>(Arrays.asList("???","Tennis", "Music", "Mountain Climbing", "Skydiving","Swimming","Croquet"));
        this.posiblesSenias = new ArrayList<>(Arrays.asList("???", "Limps","Ring","Tattoo","Scar","Jewelry"));
        this.posiblesSexos = new ArrayList<>(Arrays.asList("???", "Male", "Female"));
        this.ordenArresto = new OrdenDeArresto();
        filtrados = new ArrayList<String>();
    }
    public ArrayList<ArrayList<String>> siguientePelo(){
        posiblesColoresPelo.add(posiblesColoresPelo.remove(0));
        return mostrarOpcionesSeleccionadas();
    }

    public ArrayList<ArrayList<String>> siguienteSex(){
        posiblesSexos.add(posiblesSexos.remove(0));
        return mostrarOpcionesSeleccionadas();
    }

    public ArrayList<ArrayList<String>> siguienteCar(){
        posiblesAutomoviles.add(posiblesAutomoviles.remove(0));
        return mostrarOpcionesSeleccionadas();
    }

    public ArrayList<ArrayList<String>> siguienteFeature(){
        posiblesSenias.add(posiblesSenias.remove(0));
        return mostrarOpcionesSeleccionadas();
    }

    public ArrayList<ArrayList<String>> siguienteHobby(){
        posiblesHobbys.add(posiblesHobbys.remove(0));
        return mostrarOpcionesSeleccionadas();
    }


    public ArrayList<ArrayList<String>> mostrarOpcionesSeleccionadas(){
        ArrayList<ArrayList<String>> listaDeSeleccionados= new ArrayList<ArrayList<String>>();
        ArrayList<String> listaSex= new ArrayList<String>();
        listaSex.add("sex"); //1era posicion es la clave de la lista
        listaSex.add(posiblesSexos.get(0)); //Obtenes el valor del atributo que elegiste
        listaDeSeleccionados.add(listaSex);

        ArrayList<String> listaHobby= new ArrayList<String>();
        listaHobby.add("hobby");
        listaHobby.add(posiblesHobbys.get(0));
        listaDeSeleccionados.add(listaHobby);

        ArrayList<String> listaHair= new ArrayList<String>();
        listaHair.add("hair");
        listaHair.add(posiblesColoresPelo.get(0));
        listaDeSeleccionados.add(listaHair);

        ArrayList<String> listaFeature = new ArrayList<String>();
        listaFeature.add("feature");
        listaFeature.add(posiblesSenias.get(0));
        listaDeSeleccionados.add(listaFeature);

        ArrayList<String> listaAuto= new ArrayList<String>();
        listaAuto.add("auto");
        listaAuto.add(posiblesAutomoviles.get(0));
        listaDeSeleccionados.add(listaAuto);

        return listaDeSeleccionados;
    }

    public Delincuente ObtenerDelincuenteRandom(){
        return delincuente;
    }

    public void crearOrdenDeArrestoPara(String unNombreDelincuente){
        ordenArresto.setNombre(unNombreDelincuente);
    }

    public ArrayList<String> filtrar(){
        ArrayList<String> listadoSospechososFiltrados = filtrador.filtrar(mostrarOpcionesSeleccionadas(),sospechosos);
        if(listadoSospechososFiltrados.size() == 1){
            crearOrdenDeArrestoPara(listadoSospechososFiltrados.get(0));
        }
        return listadoSospechososFiltrados;
    }

    public EstadoJuegoInterfaz realizarArresto() {
        return ordenArresto.realizarArresto(delincuente.getNombre());
    }
}
