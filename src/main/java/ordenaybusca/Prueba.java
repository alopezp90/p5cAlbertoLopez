package ordenaybusca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class Prueba {

    private static ArrayList<Casilla> listaCasillas;

    public static void main(String[] args) {

        listaCasillas = new ArrayList<>();

        aniadeCasilla(new Casilla("normal"));
        aniadeCasilla(new Casilla("oca"));
        aniadeCasilla(new Casilla("puente"));
        aniadeCasilla(new Casilla("posada"));
        aniadeCasilla(new Casilla("pozo"));
        aniadeCasilla(new Casilla("laberinto"));
        aniadeCasilla(new Casilla("carcel"));
        aniadeCasilla(new Casilla("dados"));
        aniadeCasilla(new Casilla("calavera"));
        
        System.out.println("Por orden añadido:");
        imprimeLista();
        System.out.println("------------");
        
        System.out.println("Por orden alfabetico:");
        ordenarNombre();
        imprimeLista();
        System.out.println("------------");
        
        Casilla buscada = new Casilla("carcel");
        System.out.println("Posicion por nombre de 'carcel': " + 
                buscarPorNombre(buscada));
        buscada = new Casilla("inventada");
        System.out.println("Posicion por nombre de 'inventada': "+
                buscarPorNombre(buscada));
    }

    public static void imprimeLista() {
        for (Casilla elemento : listaCasillas) {
            System.out.println(elemento.getNombre());
        }
    }

    public static void aniadeCasilla(Casilla casilla) {
        listaCasillas.add(casilla);
    }

    public static void modificaCasilla(int posicion, Casilla casilla) {
        listaCasillas.set(posicion, casilla);
    }

    public static void borraPosicion(int posicion) {
        if (posicion >= 0 && posicion < listaCasillas.size()) {
            listaCasillas.remove(posicion);
        }
    }

    public static void borraCasilla(Casilla casilla) {
        listaCasillas.remove(casilla);
    }

    public static void ordenarNombre() {
        Comparator<Casilla> criterio = (c1, c2) -> c1.getNombre().compareTo(c2.getNombre());
        Collections.sort(listaCasillas, criterio);
    }

    public static int buscarPorNombre(Casilla c) {
        Comparator<Casilla> criterio = (c1, c2) -> c1.getNombre().compareTo(c2.getNombre());

        int posicion = Collections.binarySearch(listaCasillas, c, criterio);

        return posicion;
    }

}
