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
     * @return 1 si avanzó, 0 si no hay gasolina, -1 si no existe
     */
    public int avanzarCoche(String matricula, double metros){
        double totalKm = miModel.avanzar(matricula, metros);
        if (totalKm == -2) return 0;
        if (totalKm < 0) return -1;
        miView.muestraKm(matricula, totalKm);
        return 1;
    }

    /**
     * Reposta gasolina en un coche.
     *
     * @param matricula Matrícula del coche
     * @param litros Litros a añadir
     * @return true si se repostó correctamente
     */
    public boolean repostarCoche(String matricula, double litros) {
        double total = miModel.repostar(matricula, litros);
        return total >= 0;
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