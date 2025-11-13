package Test;

import static org.junit.Assert.*;
import java.util.Properties;
import org.junit.*;

import co.edu.unbosque.model.MenDTO;

public class MenDTOTest {

    private MenDTO hombre;
    private Properties properties;

    @BeforeClass
    public static void antesDeTodo() {
        System.out.println("Iniciando las pruebas de MenDTO");
    }

    @Before
    public void antesDeCadaPrueba() {
        properties = new Properties();
        properties.setProperty("idioma", "es");
        hombre = new MenDTO();
    }

    @Test
    public void pruebaSetYGetIngreso() {
        long ingresos = 2500000L;
        hombre.setMensualIncome(ingresos);
        assertEquals(ingresos, hombre.getMensualIncome());
    }

    @Test
    public void pruebaInternacionalizacion() {
        hombre.internacionalizacion(properties);
        assertNotNull(hombre);
    }

    @Test
    public void pruebaConstructorCompleto() {
        MenDTO h = new MenDTO(
            "Carlos", "Cobaleda", "totes", "14/02/2007", "175",
            "carlosecob@gmail.com", "Masculino", "Heterosexual",
            "ruta/foto.png", "Colombia", "0442025", 3000000L, properties
        );

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


    @Test
    public void pruebaToStringNoNull() {
    hombre.setMensualIncome(1500000L);
    String texto = hombre.toString();
    assertNotNull("El texto generado no debe ser nulo", texto);
    assertTrue("El texto debe contener Mensual Income", texto.contains("Mensual Income"));
}


    @After
    public void despuesDeCadaPrueba() {
        assertNotNull(hombre);
    }

    @AfterClass
    public static void despuesDeTodo() {
        System.out.println("Finalizando las pruebas de MenDTO");
    }
}
