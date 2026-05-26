import java.util.ArrayList;
import java.util.Scanner;

/**
 * Vista del programa. Gestiona la interacción con el usuario.
 */
public class View {

    /**
     * Muestra el menú principal y gestiona las opciones.
     */
    public void menu() {
        Controller c = new Controller();
        int opcion = 0;

        do {
            System.out.println("\n--- XESTOR COCHES ---");
            System.out.println("1. Engadir Coche");
            System.out.println("2. Cambiar velocidad");
            System.out.println("3. Salir");
            System.out.println("4. Avanzar (metros)");
            System.out.println("5. Ver coches");
            System.out.println("6. Poner gasolina");
            System.out.print("Selecciona unha opción: ");

            opcion = new Scanner(System.in).nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Modelo: ");
                    String modelo = new Scanner(System.in).next();
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    boolean a = c.añadirCoche(modelo, matricula);
                    System.out.println(a ? "Se ha añadido correctamente" : "Algo ha fallado");
                }

                case 2 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Nueva velocidad: ");
                    int velocidad = new Scanner(System.in).nextInt();
                    boolean a = c.newVelocidad(matricula, velocidad);
                    System.out.println(a ? "Se ha cambiado correctamente" : "Algo ha fallado");
                }

                case 4 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Metros a avanzar: ");
                    double metros = new Scanner(System.in).nextDouble();
                    int resultado = c.avanzarCoche(matricula, metros);
                    if (resultado == 1) System.out.println("El coche ha avanzado");
                    else if (resultado == 0) System.out.println("Sin gasolina, reposta primero");
                    else System.out.println("Error: coche no encontrado");
                }

                case 6 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Litros a añadir: ");
                    double litros = new Scanner(System.in).nextDouble();
                    boolean ok = c.repostarCoche(matricula, litros);
                    System.out.println(ok ? "Depósito actualizado" : "Error: coche no encontrado");
                }

                case 5 -> {
                    ArrayList<Coche> lista = c.verCoches();
                    mostrarCoches(lista);
                }

                case 3 -> System.out.println("Chao hasta luego....");
            }

        } while (opcion != 3);
    }

    /**
     * Muestra la velocidad de un coche.
     *
     * @param matricula Matrícula del coche
     * @param v Velocidad
     * @return true siempre
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + " km/h");
        return true;
    }

    /**
     * Muestra los kilómetros recorridos por un coche.
     *
     * @param matricula Matrícula del coche
     * @param km Kilómetros recorridos
     */
    public void muestraKm(String matricula, double km){
        System.out.println(matricula + " ha recorrido " + km + " km");
    }

    /**
     * Muestra la lista de coches registrados.
     *
     * @param lista Lista de coches
     */
    public void mostrarCoches(ArrayList<Coche> lista){
        System.out.println("\n--- COCHES REGISTRADOS ---");

        if (lista.isEmpty()) {
            System.out.println("No hay coches registrados.");
            return;
        }

        for (Coche c : lista) {
            System.out.println("Modelo: " + c.modelo +
                    " | Matrícula: " + c.matricula +
                    " | Velocidad: " + c.velocidad + " km/h" +
                    " | Km recorridos: " + c.kmRecorridos +
                    " | Gasolina: " + String.format("%.2f", c.gasolina) + "L");
        }
    }
}