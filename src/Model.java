import java.util.ArrayList;

/**
 * Gestiona los coches almacenados en memoria.
 */
public class Model {

    /** Lista de coches registrados */
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un nuevo coche y lo añade al parking.
     *
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     * @return El coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche por su matrícula.
     *
     * @param matricula Matrícula del coche
     * @return El coche encontrado o null si no existe
     */
    public Coche getCoche(String matricula){
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche.
     *
     * @param matricula Matrícula del coche
     * @param v Nueva velocidad
     * @return La velocidad actualizada o -1 si no existe
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = v;
            return c.velocidad;
        }
        return -1;
    }

    /**
     * Obtiene la velocidad de un coche.
     *
     * @param matricula Matrícula del coche
     * @return Velocidad o -1 si no existe
     */
    public int getVelocidad(String matricula) {
        Coche c = getCoche(matricula);
        return c != null ? c.velocidad : -1;
    }

    /**
     * Hace avanzar un coche una cantidad de metros.
     *
     * @param matricula Matrícula del coche
     * @param metros Metros a avanzar
     * @return Kilómetros totales recorridos o -1 si no existe
     */
    public double avanzar(String matricula, double metros) {
        Coche c = getCoche(matricula);
        if (c != null) {
            double km = metros / 1000.0;
            c.kmRecorridos += km;
            return c.kmRecorridos;
        }
        return -1;
    }

    /**
     * Obtiene los kilómetros recorridos por un coche.
     *
     * @param matricula Matrícula del coche
     * @return Kilómetros o -1 si no existe
     */
    public double getKmRecorridos(String matricula) {
        Coche c = getCoche(matricula);
        return c != null ? c.kmRecorridos : -1;
    }

    /**
     * Devuelve la lista completa de coches registrados.
     *
     * @return Lista de coches
     */
    public ArrayList<Coche> getAllCoches() {
        return parking;
    }
}
