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

/**
 * Clase de pruebas unitarias para validar los metodos de lectura y escritura de archivos
 * en la clase FileHandler.
 * 
 * <p> 
 * Se realizaron pruebas sobre los archivos de texto (CSV) y archivos serializados,
 * verificando que se creen correctamente, contengan datos validos y puedan ser leidos sin errores.
 * </p>
 * 
 * <p>
 * Las pruebas se ejecutan en un entorno controlado, con limpieza de archivos antes y despues de cada prueba que se realiza.
 * </p>
 * 
 * Autor: Carlos Eduardo Cobaleda Moreno
 */

public class FileHandlerTest {
	
	/**
	 * Nombre del archivo CSV utilizado en las pruebas.
	 */
	private static final String CSV_FILE_NAME = "test_data.csv";
	/**
	 * Nombre del archivo serializado utilizado en las pruebas.
	 */
	private final String SERIAL_FILE_NAME = "test_data.ser";
	/**
	 * Contenido simulado para el archivo CSV.
	 */
	private static String contenidoCSV;
	/**
	 * Contenido simulado para el archivo serializado.
	 */
	private static String contenidoSerializado;
	
	
	/**
	 * Inicializa los contenidos de pruebas antes de ejecutar cualquier prueba.
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
	 * Prepara el entorno de cada prueba.
	 * Elimina los archivos si existen para asegurar que la prueba se ejecute en condiciones limpias.
	 * 
	 * @pre Los archivos pueden existir de pruebas anteriores.
	 * @post Los archivos han sido eliminados si estan presentes.
	 * @throws AssertionError si los archivos no se han eliminado correctamente.
	 */
	@Before
	
	public void antesDeCadaPrueba() {
		assertFalse("El archivo csv debe estar limpio antes de la prueba", new File(CSV_FILE_NAME).exists());
		assertFalse("El archivo serializado debe estar limpio antes de la prueba", new File(SERIAL_FILE_NAME).exists());
		
		new File(CSV_FILE_NAME).delete();
		new File(SERIAL_FILE_NAME).delete();
	}
	
	/**
	 * Prueba la lectura y escritura de un archivo CSV.
	 * 
	 * @pre El archivo CSV no debe existir.
	 * @post El archiivo CSV se crea, contiene datos y se puede leer correctamente.
	 * @throws AssertionError si el archivo no se crea, esta vacio o no contiene los datos esperados.
	 */
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
	
	/**
	 * Prueba la escritura y lectura de un archivo serializado.
	 * 
	 * @pre El archivo serializado no debe existir.
	 * @post El archivo se crea, contiene el objeto serializado y se puede deserializar.
	 * @throws AssertionError si el archivo no se crea, esta vacio o el objeto deserealizado no coincide.
	 */
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
	
	/**
	 * Elimina los archivos creados durante la prueba
	 * 
	 * @pre Los archivos deben existir despues de la prueba.
	 * @post Los archivos han sido eliminados correctamente.
	 * @throws AssertionError si los archivos no se eliminan correctamente.
	 */
	
	@After
	public void despuesDeCadaPrueba() {
		assertTrue("El archivo csv debe eliminarse", new File(CSV_FILE_NAME).delete());
		assertTrue("El archivo serializable debe eliminarse", new File(SERIAL_FILE_NAME).delete());
	}
	
	/**
	 * Finaliza el conjunto de pruebas
	 * 
	 * @pre Todas las pruebas han sido ejecutadas.
	 * @post Se imprime un mensaje indicando el fin de las pruebas.
	 */
	
	@AfterClass
	
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas de archivos.");
	}
	

}
