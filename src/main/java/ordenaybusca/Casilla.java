package ordenaybusca;

/**
 * Esta clase define los tipos de casilla posibles en La Oca. Cada tipo de
 * casilla queda definido únicamente mediante su nombre.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
import java.awt.Point;
import java.util.Objects;

public class Casilla {

    //Instancia variables de Casilla
    private String nombre;          //Nombre del tipo de casilla
    private int movimientoOrden;    //Movimiento al que fuerza al jugador la casilla
    private int turnosPenalizacion; //Numero de turnos sin lanzar dados por el jugador que cae en la casilla
    private boolean tiradaExtra;    //True si la casilla permite volver a tirar tras caer en ella
    private int posicion;           //Numero de la casilla
    private Point point;            //Punto de la esquina superior izquierda de la casilla en la GUI.

    /**
     * Constructor por defecto de Casilla. No necesita parametros, genera una
     * casilla con:
     * <ul>
     * <li>nombre en blanco.</li>
     * <li>movimientoOrden cero.</li>
     * <li>turnosPenalizacion cero.</li>
     * <li>tiradaExtra false.</li>
     * <li>posicion cero.</li>
     * <li>point null.</li>
     * </ul>
     */
    public Casilla() {
        this.nombre = "normal";
    }

    /**
     * Constructor parametrizado de Casilla.
     *
     * @param nombre Tipo de casilla, puede ser:
     * <ul>
     * <li>"oca" ordenan movimiento hasta la siguiente del mismo tipo y dan
     * tirada extra.</li>
     * <li>"puente" ordena avanzar hasta la posada, pierdes 1 turno.</li>
     * <li>"posada" pierdes 1 turno.</li>
     * <li>"pozo" asigna -1 turnos de penalizacion, solo se resuelve si otro
     * jugador cruza la casilla.</li>
     * <li>"laberinto" hace retroceder 12 casillas</li>
     * <li>"carcel" pierdes 2 turnos.</li>
     * <li>"dados" avanza tantas casillas como la posicion del dado.</li>
     * <li>"calavera" retrocede hasta la casilla 1.</li>
     * </ul>
     */
    public Casilla(String nombre) {
        this.nombre = nombre;

        switch (nombre) {
            case "oca":
                this.turnosPenalizacion = 0;
                this.tiradaExtra = true;
                break;
            case "puente":
                this.turnosPenalizacion = 1;
                break;
            case "posada":
                this.turnosPenalizacion = 1;
                break;
            case "pozo":
                this.turnosPenalizacion = -1;
                break;
            case "laberinto":
                this.movimientoOrden = -12;
                break;
            case "carcel":
                this.turnosPenalizacion = 2;
                break;
            case "dados":
                this.tiradaExtra = true;
                break;
            case "calavera":
                this.movimientoOrden = -57;
                break;
        }
    }

    //Metodos setter
    public void setMovimientoOrden(int movimientoOrden) {
        this.movimientoOrden = movimientoOrden;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    //Metodos getter
    public String getNombre() {
        return nombre;
    }

    public int getMovimientoOrden() {
        return movimientoOrden;
    }

    public int getTurnosPenalizacion() {
        return turnosPenalizacion;
    }

    public boolean isTiradaExtra() {
        return tiradaExtra;
    }

    public int getPosicion() {
        return posicion;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + this.movimientoOrden;
        hash = 29 * hash + this.turnosPenalizacion;
        hash = 29 * hash + (this.tiradaExtra ? 1 : 0);
        hash = 29 * hash + this.posicion;
        hash = 29 * hash + Objects.hashCode(this.point);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Casilla other = (Casilla) obj;
        if (this.movimientoOrden != other.movimientoOrden) {
            return false;
        }
        if (this.turnosPenalizacion != other.turnosPenalizacion) {
            return false;
        }
        if (this.tiradaExtra != other.tiradaExtra) {
            return false;
        }
        if (this.posicion != other.posicion) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.point, other.point)) {
            return false;
        }
        return true;
    }
    
    
}
