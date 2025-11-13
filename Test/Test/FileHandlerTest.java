package Test;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.*;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Clase de pruebas unitarias para validar los métodos de lectura y escritura
 * de archivos en la clase {@code FileHandler}.
 * 
 * <p>Se realizan pruebas sobre archivos de texto (CSV) y archivos serializados,
 * verificando que se creen correctamente, contengan datos válidos y puedan
 * ser leídos sin errores.</p>
 * 
 * <p>Las pruebas se ejecutan en un entorno controlado, con limpieza de archivos
 * antes y después de cada prueba.</p>
 * 
 * Autor: Carlos Eduardo Cobaleda Moreno
 */
public class FileHandlerTest {

    /** Nombre del archivo CSV utilizado en las pruebas. */
    private static final String CSV_FILE_NAME = "test_data.csv";

    /** Nombre del archivo serializado utilizado en las pruebas. */
    private static final String SERIAL_FILE_NAME = "test_data.ser";

    /** Contenido simulado para el archivo CSV. */
    private static String contenidoCSV;

    /** Contenido simulado para el archivo serializado. */
    private static String contenidoSerializado;

    /**
     * Se ejecuta una vez antes de todas las pruebas.
     * 
     * @pre No se han ejecutado pruebas.
     * @post Se inicializan las variables de contenido para los archivos.
     */
    @BeforeClass
    public static void antesDeTodo() {
        System.out.println("Iniciando pruebas de archivos csv y serializados");
        contenidoCSV = "nombre,edad\nCarlos,22\nAna,21";
        contenidoSerializado = "Este es un objeto serializado de prueba";
    }

    /**
     * Se ejecuta antes de cada prueba.
     * Elimina los archivos si existen para asegurar que la prueba se ejecute
     * en condiciones limpias.
     * 
     * @pre Los archivos pueden existir de pruebas anteriores.
     * @post Los archivos han sido eliminados si estaban presentes.
     */
    @Before
    public void antesDeCadaPrueba() {
        File csv = new File(CSV_FILE_NAME);
        File ser = new File(SERIAL_FILE_NAME);
        if (csv.exists()) csv.delete();
        if (ser.exists()) ser.delete();
    }

    /**
     * Prueba la escritura y lectura de un archivo CSV.
     * 
     * @pre El archivo CSV no debe existir.
     * @post El archivo CSV se crea, contiene datos y se puede leer correctamente.
     * @throws AssertionError si el archivo no se crea, está vacío o no contiene los datos esperados.
     */
    @Test
    public void testEscribirYLeerArchivosCSV() {
        FileHandler.escribirEnArchivoTexto(CSV_FILE_NAME, contenidoCSV);
        File archivoCSV = new File(CSV_FILE_NAME);
        assertTrue("El archivo csv debe existir después de escribir", archivoCSV.exists());
        assertTrue("El archivo csv no debe estar vacío", archivoCSV.length() > 0);
        String resultado = FileHandler.leerDesdeArchivoTexto(CSV_FILE_NAME);
        assertNotNull("El contenido csv no debe ser nulo", resultado);
        assertTrue("Debe contener el nombre Carlos", resultado.contains("Carlos"));
        assertTrue("Debe contener el nombre Ana", resultado.contains("Ana"));
    }

    /**
     * Prueba la escritura y lectura de un archivo serializado.
     * 
     * @pre El archivo serializado no debe existir.
     * @post El archivo se crea, contiene el objeto serializado y se puede deserializar correctamente.
     * @throws AssertionError si el archivo no se crea, está vacío o el objeto deserializado no coincide.
     */
    @Test
    public void testEscribirYLeerArchivoSerializado() {
        FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, contenidoSerializado);
        File archivoSer = new File(SERIAL_FILE_NAME);
        assertTrue("El archivo serializado debe existir después de escribir", archivoSer.exists());
        assertTrue("El archivo serializado no debe estar vacío", archivoSer.length() > 0);
        Object resultado = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
        assertNotNull("El objeto deserializado no debe ser nulo", resultado);
        assertEquals("El objeto debe coincidir con el original", contenidoSerializado, resultado);
    }

    /**
     * Se ejecuta después de cada prueba.
     * Elimina los archivos creados durante la prueba.
     * 
     * @pre Se ha ejecutado una prueba.
     * @post Los archivos temporales han sido eliminados.
     */
    @After
    public void despuesDeCadaPrueba() {
        new File(CSV_FILE_NAME).delete();
        new File(SERIAL_FILE_NAME).delete();
    }

    /**
     * Se ejecuta una vez después de todas las pruebas.
     * 
     * @pre Todas las pruebas han sido ejecutadas.
     * @post Se imprime un mensaje indicando el fin de las pruebas.
     */
    @AfterClass
    public static void despuesDeTodo() {
        System.out.println("Finalizando pruebas de archivos.");
    }
}