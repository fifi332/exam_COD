/**
 * Representa un coche con matrícula, modelo, velocidad y kilómetros recorridos.
 */
public class Coche {

    /** Matrícula del coche */
    String matricula;

    /** Modelo del coche */
    String modelo;

    /** Velocidad actual del coche en km/h */
    Integer velocidad;

    /** Kilómetros totales recorridos por el coche */
    double kmRecorridos;

    /**
     * Constructor de la clase Coche.
     *
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kmRecorridos = 0;
    }
}
