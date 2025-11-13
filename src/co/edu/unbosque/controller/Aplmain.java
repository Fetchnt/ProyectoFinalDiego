package co.edu.unbosque.controller;

/**
 * Clase principal de la aplicación que inicia la ejecución del programa.
 * <p>
 * Esta clase contiene el método <code>main</code>, que crea una instancia
 * del controlador {@link Controller} y llama a su método <code>run</code>
 * para iniciar la lógica principal de la aplicación.
 * </p>
 * 
 * @author Juan Cabarcas
 * @version 1.0
 */
public class Aplmain {

    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     * <p>
     * Este método instancia la clase {@link Controller} y llama a su método
     * <code>run</code> para iniciar la ejecución del programa.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Controller c = new Controller();
        c.run();
    }

}

