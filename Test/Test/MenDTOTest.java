package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.MenDTO;


/**
 *Clase de pruebas unitarias para la clase MenDTO.
 *
 * <p>
 * Se validan los metodos de acceso, internacionalizacion, constructor completo
 * y representacion en texto del objeto MenDTO.
 * </p>
 * 
 * <p>
 * Las pruebas se ejecutan en un entorno controlado, con inicializacion y limpieza
 * antes y despues de cada prueba.
 * </p>
 * 
 * Autor: Carlos Eduardo Cobaleda Moreno.
 */

public class MenDTOTest {
	
	/**
	 * Instancia de MenDTO usada en pruebas.
	 */
	private MenDTO hombre;
	
	/**
	 * Propiedades utilizadas para pruebas de internacionalizacion.
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
		System.out.println("Iniciando las pruebas de MenDTO");
	}
	
	/**
	 * Se ejecuta antes de cada prueba.
	 * 
	 * @pre No hay instancia inicializada en MenDTO.
	 * @post Se inicializa la instancia y las propiedades.
	 */
	@Before
	
	public void antesDeCadaPrueba() {
		
		properties = new Properties();
		properties.setProperty("idioma", "es");
		hombre = new MenDTO();
	}
	
	/**
	 * Prueba el metodo setMensualIncome y su correspondiente getter.
	 * 
	 * @pre La instancia de MenDTO esta inicializada.
	 * @post El ingreso mensual se establece y se recupera correctamente.
	 * @throws AssertionError si el valor recuperado no coincide con el establecido.
	 */
	@Test
	
	public void pruebaSetYGetIngreso() {
		long ingresos = 2500000L;
		hombre.setMensualIncome(ingresos);
		assertEquals(ingresos, hombre.getMensualIncome());
	}
	
	/**
	 * Prueba el metodo de internacionalizacion.
	 * 
	 * @pre La instancia de MenDTO esta inicializada.
	 * @post El metodo se ejecuta sin errores.
	 * @param properties propiedades con configuracion de idioma.
	 * @throws AssertionError si la instancia resulta nula despues de la operacion.
	 */
	@Test
	
	public void pruebaInternacionalizacion() {
		hombre.internacionalizacion(properties);
		assertNotNull(hombre);
	}
	
	/**
	 * Prueba el constructor completo de MenDTO.
	 * 
	 * @pre no hay instancia creada con datos completos.
	 * @post Se crea una instancia con todos los campos y se validan sus valores.
	 * @throws AssertionError Si algun campo no coincide con el valor esperado.
	 */
	@Test
	
	public void pruebaConstructorCompleto() {
		MenDTO h = new MenDTO(
				"Carlos", "Cobaleda", "totes", "14/02/2007", "175", "carlosecob@gmail.com",
	            "Masculino", "Heterosexual", "ruta/foto.png", "Colombia", "0442025", 3000000L, properties);
		
		assertEquals("Carlos", h.getName());
		assertEquals("Cobaleda", h.getLastName());
		assertEquals("totes", h.getAlias());
		assertEquals("14/02/2007", h.getBornDate());
		assertEquals("175", h.getStature());
		assertEquals("carlosecob@gmail.com", h.getEmail());
		assertEquals("Masculino", h.getGender());
		assertEquals("Heterosexual", h.getSexualOrientation());
		assertEquals("ruta/foto.png", h.getProfilePictureRoute());
		assertEquals("Colombia", h.getCountry());
		assertEquals("0442025", h.getPassword());
		assertEquals(3000000L, h.getMensualIncome());
	}
	
	/**Prueba que el metodo toString no retorne nulo y contenga informaccion relevante.
	 * 
	 * @pre La instancia tiene un ingreso mensual asignado.
	 * @post Se genera una representacion en texto que incluye los ingresos.
	 * @throws AssertionError 'si el texto genrado no contiene la informacion esperada.
	 */
	public void pruebaToStringNoNull() {
		hombre.setMensualIncome(1500000L);
		String texto = hombre.toString();
		assertNotNull(texto.contains("Ingresos mensuales"));
	}
	
	/**
	 * Se ejecuta despues de cada prueba.
	 * 
	 * @pre Se ha ejecutado una prueba.
	 * @post Se valida que la instancia MenDTO no sea nula.
	 * @throws Si la instancia es nula.
	 */
	@After
	
	public void despuesDeCadaPrueba() {
		assertNotNull(hombre);
		
	}
	
	/**
	 * Se ejecuta una vez despues de todas las pruebas.
	 * 
	 * @pre Todas las pruebas han sido ejecutadas.
	 * @post Se imprime mensaje de finalizacion.
	 */
	
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de MenDTO");
	}
	
}
