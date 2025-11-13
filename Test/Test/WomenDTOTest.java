package Test;

import static org.junit.Assert.*;
import java.util.Properties;
import org.junit.*;

import co.edu.unbosque.model.WomenDTO;

public class WomenDTOTest {

    private WomenDTO mujer;
    private Properties properties;

    @BeforeClass
    public static void antesDeTodo() {
        System.out.println("Empezando pruebas unitarias de WomenDTO");
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
        assertTrue("El valor de divorcio debe ser verdadero", mujer.isHadDivorces());
    }

    @Test
    public void pruebaInternacionalizacion() {
        mujer.internacionalizacion(properties);
        assertNotNull("La instancia no debe ser nula después de internacionalización", mujer);
    }

    @Test
    public void pruebaConstructorCompleto() {
        WomenDTO w = new WomenDTO(
            "Ana", "Gómez", "anita", "15/08/1995", "165",
            "anagomez@gmail.com", "Femenino", "Heterosexual",
            "ruta/foto.png", "Colombia", "anaGomez1428", true, properties
        );

        assertEquals("Ana", w.getName());
        assertEquals("Gómez", w.getLastName());
        assertEquals("anita", w.getAlias());
        assertEquals("15/08/1995", w.getBornDate());
        assertEquals("165", w.getStature());
        assertEquals("anagomez@gmail.com", w.getEmail());
        assertEquals("Femenino", w.getGender());
        assertEquals("Heterosexual", w.getSexualOrientation());
        assertEquals("ruta/foto.png", w.getProfilePictureRoute());
        assertEquals("Colombia", w.getCountry());
        assertEquals("anaGomez1428", w.getPassword());
        assertTrue("Debe indicar que ha tenido divorcios", w.isHadDivorces());
    }


    @Test
    public void pruebaToStringContieneDivorcio() {
    mujer.setHadDivorces(true);
    String texto = mujer.toString();
    assertNotNull("El texto generado no debe ser nulo", texto);
    assertTrue("El texto debe contener información sobre divorcios",
    texto.contains("Had divorces: true"));

    }


    @After
    public void despuesDeCadaPrueba() {
        assertNotNull("La instancia de WomenDTO no debe ser nula", mujer);
    }

    @AfterClass
    public static void despuesDeTodo() {
        System.out.println("Finalizando pruebas de WomenDTO");
    }
}