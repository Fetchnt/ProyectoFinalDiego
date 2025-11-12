package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	
	public void antesDeCadaPrueba() {
		assertFalse("El archivo csv debe estar limpio antes de la prueba", new File(CSV_FILE_NAME).exists());
		assertFalse("El archivo serializado debe estar limpio antes de la prueba", new File(SERIAL_FILE_NAME).exists());
		
		new File(CSV_FILE_NAME).delete();
		new File(SERIAL_FILE_NAME).delete();
	}
	
	@Test
	
	public void testEscribirYLeerArchivosCSV() {
		FileHandler.escribirEnArchivoSerializado(CSV_FILE_NAME, contenidoCSV);
		File archivoCSV = new File(CSV_FILE_NAME);
		assertTrue("El archivo csv debe existir despues de escribir", archivoCSV.exists());
		assertTrue("El archivo csv no debe estar vacio", archivoCSV.length() > 0);
		
		String resultado = FileHandler.leerDesdeArchivoTexto(CSV_FILE_NAME);
		assertNotNull("El contenido csv no debe ser nulo", resultado);
		assertTrue("Debe contener el nombre Carlos", resultado.contains("Carlos"));
		assertTrue("Debe contener el nombre de Ana", resultado.contains("Ana"));
	}
	
	@Test
	
	public void testEscribirYLeerArchivoSerealizado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, contenidoSerializado);
		File archivoSer = new File(SERIAL_FILE_NAME);
		assertTrue("El archivo serializado debe existir despues de escribir", archivoSer.exists());
		assertTrue("El archivo serializado no debe estar vacio", archivoSer.length() > 0);
		
		Object resultado = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		assertNotNull("El objeto deserealizado no debe ser nulo", resultado);
		assertEquals("El objeto debe coincidir con el original", contenidoSerializado, resultado);
	}
	
	@After
	
	public void despuesDeCadaPrueba() {
		assertTrue("El archivo csv debe eliminarse", new File(CSV_FILE_NAME).delete());
		assertTrue("El archivo serializable debe eliminarse", new File(SERIAL_FILE_NAME).delete());
	}
	
	@AfterClass
	
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas de archivos.");
	}
	

}
