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

public class WomenDTOTest {
	
	private WomenDTO mujer;
	private Properties properties;
	
	@BeforeClass
	
	public static void antesDeTodo() {
		
		System.out.println("Empezando pruebas unitarias de womenDTO");
	}
	
	@Before
	
	public void antesDeCadaPrueba() {
		
		properties = new Properties();
		properties.setProperty("idioma", "es");
		mujer = new WomenDTO();
		
	}
	
	@Test
	
	public void pruebaSetYGetDivorcio() {
		
		mujer.setHadDivorces(true);
		assertTrue(mujer.isHadDivorces());
		
	}
	
	@Test
	
	public void pruebaInternacionalizacion() {
		
		mujer.internacionalizacion(properties);
		assertNotNull(mujer);
	}
	
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
	
	@Test
	
	public void pruebaToStringContieneDivorcio() {
		mujer.setHadDivorces(true);
		String texto = mujer.toString();
		assertNotNull(texto);
		assertTrue(texto.contains("Contiene divorcios: verdadero"));
	}
	
	@After
	
	public void despuesDeCadaPrueba() {
		assertNotNull(mujer);
		
	}
	
	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas de WomenDTO");
	}
	
	

}
