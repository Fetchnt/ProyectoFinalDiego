package Test;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.*;

import co.edu.unbosque.model.persistence.FileHandler;

public class FileHandlerTest {

    private static final String CSV_FILE_NAME = "test_data.csv";
    private static final String SERIAL_FILE_NAME = "test_data.ser";

    private static String contenidoCSV;
    private static String contenidoSerializado;

    @BeforeClass
    public static void antesDeTodo() {
        System.out.println("Iniciando pruebas de archivos csv y serializados");
        contenidoCSV = "nombre,edad\nCarlos,22\nAna,21";
        contenidoSerializado = "Este es un objeto serializado de prueba";
    }

    @Before
    public void antesDeCadaPrueba() {
        File csv = new File(CSV_FILE_NAME);
        File ser = new File(SERIAL_FILE_NAME);
        if (csv.exists()) csv.delete();
        if (ser.exists()) ser.delete();
    }

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

    @After
    public void despuesDeCadaPrueba() {
        new File(CSV_FILE_NAME).delete();
        new File(SERIAL_FILE_NAME).delete();
    }

    @AfterClass
    public static void despuesDeTodo() {
        System.out.println("Finalizando pruebas de archivos.");
    }
}