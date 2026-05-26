/**
 * Controlador principal que conecta la vista con el modelo.
 */
public class Controller {

    static View miView = new View();
    Model miModel = new Model();

    /**
     * Método principal del programa.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        miView.menu();
    }

    /**
     * Añade un coche al sistema.
     *
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     * @return true si se añadió correctamente
     */
    public boolean añadirCoche(String modelo, String matricula){
        Coche creado = miModel.crearCoche(modelo, matricula);
        return creado == miModel.getCoche(matricula);
    }

    /**
     * Cambia la velocidad de un coche.
     *
     * @param matricula Matrícula del coche
     * @param velocidad Nueva velocidad
     * @return true si se cambió correctamente
     */
    public boolean newVelocidad(String matricula, int velocidad){
        int nuevaVelocidad = miModel.cambiarVelocidad(matricula, velocidad);
        return nuevaVelocidad >= 0;
    }

    /**
     * Hace avanzar un coche.
     *
     * @param matricula Matrícula del coche
     * @param metros Metros a avanzar
     * @return true si el coche existe
     */
    public boolean avanzarCoche(String matricula, double metros){
        double totalKm = miModel.avanzar(matricula, metros);
        if (totalKm >= 0) {
            miView.muestraKm(matricula, totalKm);
            return true;
        }
        return false;
    }

    /**
     * Obtiene la lista de coches registrados.
     *
     * @return Lista de coches
     */
    public java.util.ArrayList<Coche> verCoches() {
        return miModel.getAllCoches();
    }
}
