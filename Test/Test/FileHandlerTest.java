package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.FileHandler;

public class FileHandlerTest {
	
	private static final String CSV_FILE_NAME = "test_data.csv";
	private final String SERIAL_FILE_NAME = "test_data.ser";
	private static String contenidoCSV;
	private static String contenidoSerializado;
	
	@BeforeClass
	
	public static void antesDeTodo() {
		
		System.out.println("Iniciando pruebas de archivos csv y serializados");
		contenidoCSV = "nombre,edad\nCarlos,22\nAna,21";
		contenidoSerializado = "Este es un objeto serializado de prueba";
	}
	
	@Before
	
	public void setUp() {
		new File(CSV_FILE_NAME).delete();
		new File(SERIAL_FILE_NAME).delete();
	}
	
	@Test
	
	public void testEscribirYLeerArchivosCSV() {
		FileHandler.escribirEnArchivoSerializado(CSV_FILE_NAME, contenidoCSV);
		String resultado = FileHandler.leerDesdeArchivoTexto(CSV_FILE_NAME);
		assertNotNull("El contenido csv no debe ser nulo", resultado);
		assertTrue("Debe contener el nombre Carlos", resultado.contains("Carlos"));
		assertTrue("Debe contener el nombre de Ana", resultado.contains("Ana"));
	}
	
	@Test
	
	public void testEscribirYLeerArchivoSerealizado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, contenidoSerializado);
		Object resultado = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		assertNotNull("El objeto deserealizado no debe ser nulo", resultado);
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
