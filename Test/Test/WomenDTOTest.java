package Test;

import static org.junit.Assert.*;
import java.util.Properties;
import org.junit.*;

import co.edu.unbosque.model.WomenDTO;

/**
 * Clase de pruebas unitarias para la clase {@code WomenDTO}.
 * 
 * <p>Se validan los métodos de acceso, internacionalización, constructor completo
 * y representación textual del objeto {@code WomenDTO}.</p>
 * 
 * <p>Las pruebas se ejecutan en un entorno controlado, con inicialización
 * y verificación antes y después de cada prueba.</p>
 * 
 * Autor: Carlos Eduardo Cobaleda Moreno.
 */
public class WomenDTOTest {

    /** Instancia de prueba de {@code WomenDTO}. */
    private WomenDTO mujer;

    /** Propiedades utilizadas para pruebas de internacionalización. */
    private Properties properties;

    /**
     * Se ejecuta una vez antes de todas las pruebas.
     * 
     * @pre No se han ejecutado pruebas.
     * @post Se imprime mensaje de inicio de pruebas.
     */
    @BeforeClass
    public static void antesDeTodo() {
        System.out.println("Empezando pruebas unitarias de WomenDTO");
    }

    /**
     * Se ejecuta antes de cada prueba.
     * 
     * @pre No hay instancia inicializada de {@code WomenDTO}.
     * @post Se inicializa la instancia y las propiedades.
     */
    @Before
    public void antesDeCadaPrueba() {
        properties = new Properties();
        properties.setProperty("idioma", "es");
        mujer = new WomenDTO();
    }

    /**
     * Prueba el método {@code setHadDivorces} y su correspondiente {@code isHadDivorces}.
     * 
     * @pre La instancia de {@code WomenDTO} está inicializada.
     * @post El valor de divorcio se establece y se recupera correctamente.
     * @throws AssertionError si el valor recuperado no coincide con el establecido.
     */
    @Test
    public void pruebaSetYGetDivorcio() {
        mujer.setHadDivorces(true);
        assertTrue("El valor de divorcio debe ser verdadero", mujer.isHadDivorces());
    }

    /**
     * Prueba el método {@code internacionalizacion}.
     * 
     * @pre La instancia de {@code WomenDTO} está inicializada.
     * @post El método se ejecuta sin errores.
     * @param properties Propiedades con configuración de idioma.
     * @throws AssertionError si la instancia resulta nula después de la operación.
     */
    @Test
    public void pruebaInternacionalizacion() {
        mujer.internacionalizacion(properties);
        assertNotNull("La instancia no debe ser nula después de internacionalización", mujer);
    }

    /**
     * Prueba el constructor completo de {@code WomenDTO}.
     * 
     * @pre No hay instancia creada con datos completos.
     * @post Se crea una instancia con todos los campos y se validan sus valores.
     * @throws AssertionError si algún campo no coincide con el valor esperado.
     */
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

    /**
     * Prueba que el método {@code toString} no retorne nulo y contenga información sobre divorcios.
     * 
     * @pre La instancia tiene el valor de divorcio asignado.
     * @post Se genera una representación en texto que incluye el estado de divorcio.
     * @throws AssertionError si el texto generado no contiene la información esperada.
     */
    @Test
    public void pruebaToStringContieneDivorcio() {
        mujer.setHadDivorces(true);
        String texto = mujer.toString();
        assertNotNull("El texto generado no debe ser nulo", texto);
        assertTrue("El texto debe contener información sobre divorcios", texto.contains("Had divorces: true"));
    }

    /**
     * Se ejecuta después de cada prueba.
     * 
     * @pre Se ha ejecutado una prueba.
     * @post Se valida que la instancia de {@code WomenDTO} no sea nula.
     * @throws AssertionError si la instancia es nula.
     */
    @After
    public void despuesDeCadaPrueba() {
        assertNotNull("La instancia de WomenDTO no debe ser nula", mujer);
    }

    /**
     * Se ejecuta una vez después de todas las pruebas.
     * 
     * @pre Todas las pruebas han sido ejecutadas.
     * @post Se imprime mensaje de finalización.
     */
    @AfterClass
    public static void despuesDeTodo() {
        System.out.println("Finalizando pruebas de WomenDTO");
    }
}