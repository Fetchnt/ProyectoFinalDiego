package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.WomenDTO;


/**
 * Clase de pruebas unitarias para la clase WomenDTO
 * 
 * <p>
 * Se verifican los metodos de acceso, internacionalizacion, contructor completo y
 * la representacion textual del objeto
 * </p>
 * 
 * <p>
 * Las pruebas se ejecutan en un entorno controlado, con inicializacion y limpieza
 * antes y despuesde cada prueba.
 * </p>
 * 
 * Autor: Carlos Eduardo Cobaleda Moreno
 */
public class WomenDTOTest {
	
	/**
	 * Instancia de WomenDTO utilizada en las pruebas.
	 */
	
	private WomenDTO mujer;
	
	/**
	 * Propiedades utilizadas para pueba de internacionalizacion.
	 */
	private Properties properties;
	
	/**
	 * Se ejecuta una vez antes de todas las pruebas.
	 * 
	 * @pre No se han ejecutado pruebas.
	 * @post Se imprime mensaje de inicio de pruebas.
	 */
	@BeforeClass
	
	public static void antesDeTodo() {
		
		System.out.println("Empezando pruebas unitarias de womenDTO");
	}
	
	/**
	 * Se ejecuta antes de cada prueba.
	 * 
	 * @pre No hay instancia inicializada en WomenDTO.
	 * @post Se inicializa la instancia y las propiedades.
	 */
	@Before
	
	public void antesDeCadaPrueba() {
		
		properties = new Properties();
		properties.setProperty("idioma", "es");
		mujer = new WomenDTO();
		
	}
	
	/**
	 * Prueba el metodo setHadDivorces y sus correspondiente getter.
	 * 
	 * @pre La instancia de WomenDTO esta inicializada.
	 * @post El valor de divorcio se establece y se recupera correctamente.
	 * @throws AssertionError Si el valor recuperado no coincide con el establecido.
	 */
	@Test
	
	public void pruebaSetYGetDivorcio() {
		
		mujer.setHadDivorces(true);
		assertTrue(mujer.isHadDivorces());
		
	}
	
	/**
	 * Prueba el metodo de internacionalizacion.
	 * 
	 * @pre La instancia de WomenDTO esta inicializada
	 * @post El metodo se ejecuta sin errores.
	 * @param properties Propiedades con configuracion de idioma
	 * @throws AssertionError Si la instancia resulta nula despues de la operacion.
	 */
	
	@Test
	
	public void pruebaInternacionalizacion() {
		
		mujer.internacionalizacion(properties);
		assertNotNull(mujer);
	}
	
	/**
	 * Prueba el constructor completo de WomenDTO.
	 * 
	 * @pre No hay instancia creada con datos completos.
	 * @post Se crea una instancia con todos los campos y se validan sus valores.
	 * @throws AssistionError Si algun campo no coincide con el valor esperado.
	 */
	
	@Test
	
	public void pruebaConstructorCompleto() {
		WomenDTO w = new WomenDTO(
				"Ana", "Gómez", "anita", "15/08/1995", "165", "anagomez@gmail.com",
	            "Femenino", "Heterosexual", "ruta/foto.png", "Colombia", "anaGomez1428", true, properties);
		
		assertEquals("Ana", w.getName());
		assertEquals("Gomez", w.getLastName());
		assertEquals("anita", w.getAlias());
		assertEquals("15/08/1995", w.getBornDate());
		assertEquals("165", w.getStature());
		assertEquals("anagomez@gmail.com", w.getEmail());
		assertEquals("Femenino", w.getGender());
		assertEquals("Heterosexual", w.getSexualOrientation());
		assertEquals("ruta/foto.png", w.getProfilePictureRoute());
		assertEquals("Colombia", w.getCountry());
		assertEquals("anaGomez1428", w.getPassword());
		assertTrue(w.isHadDivorces());
	}
	
	/**
	 * Prueba que el metodo toString incluya la informacion sobre divorcios.
	 * 
	 * @pre La instancia tiene el valor de divorcio asignado.
	 * @post Se genera una representacion en texto que incluye el estado de divorcio.
	 * @throws AssertionError si el texto generado no contiene la informacion esperada.
	 */
	
	@Test
	
	public void pruebaToStringContieneDivorcio() {
		mujer.setHadDivorces(true);
		String texto = mujer.toString();
		assertNotNull(texto);
		assertTrue(texto.contains("Contiene divorcios: verdadero"));
	}
	
	/**
	 * Se ejecuta despues de cada prueba.
	 * 
	 * @pre Se ha ejecutado una prueba.
	 * @post Se valida que la instancia de WomenDTO no sea nula.
	 * @throws AssertionError si la instancia es nula.
	 */
	
	@After
	
	public void despuesDeCadaPrueba() {
		assertNotNull(mujer);
		
	}
	
	/**
	 * Se ejecuta una vez despues de todas las pruebas.
	 * 
	 * @pre Todas las pruebas han sido ejecutadas.
	 * @post Se imprime mensaje de finalizacion.
	 */
	
	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas de WomenDTO");
	}
	
	

}
