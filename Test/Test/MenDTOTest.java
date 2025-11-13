package Test;

import static org.junit.Assert.*;
import java.util.Properties;
import org.junit.*;

import co.edu.unbosque.model.MenDTO;

/**
 * Clase de pruebas unitarias para la clase {@code MenDTO}.
 * 
 * <p>Se validan los métodos de acceso, internacionalización, constructor completo
 * y representación textual del objeto {@code MenDTO}.</p>
 * 
 * <p>Las pruebas se ejecutan en un entorno controlado, con inicialización
 * y verificación antes y después de cada prueba.</p>
 * 
 * Autor: Carlos Eduardo Cobaleda Moreno 
 */
public class MenDTOTest {

    /** Instancia de prueba de {@code MenDTO}. */
    private MenDTO hombre;

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
        System.out.println("Iniciando las pruebas de MenDTO");
    }

    /**
     * Se ejecuta antes de cada prueba.
     * 
     * @pre No hay instancia inicializada de {@code MenDTO}.
     * @post Se inicializa la instancia y las propiedades.
     */
    @Before
    public void antesDeCadaPrueba() {
        properties = new Properties();
        properties.setProperty("idioma", "es");
        hombre = new MenDTO();
    }

    /**
     * Prueba el método {@code setMensualIncome} y su correspondiente {@code getMensualIncome}.
     * 
     * @pre La instancia de {@code MenDTO} está inicializada.
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
     * Prueba el método {@code internacionalizacion}.
     * 
     * @pre La instancia de {@code MenDTO} está inicializada.
     * @post El método se ejecuta sin errores.
     * @param properties Propiedades con configuración de idioma.
     * @throws AssertionError si la instancia resulta nula después de la operación.
     */
    @Test
    public void pruebaInternacionalizacion() {
        hombre.internacionalizacion(properties);
        assertNotNull(hombre);
    }

    /**
     * Prueba el constructor completo de {@code MenDTO}.
     * 
     * @pre No hay instancia creada con datos completos.
     * @post Se crea una instancia con todos los campos y se validan sus valores.
     * @throws AssertionError si algún campo no coincide con el valor esperado.
     */
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

    /**
     * Prueba que el método {@code toString} no retorne nulo y contenga información relevante.
     * 
     * @pre La instancia tiene un ingreso mensual asignado.
     * @post Se genera una representación en texto que incluye los ingresos.
     * @throws AssertionError si el texto generado no contiene la información esperada.
     */
    @Test
    public void pruebaToStringNoNull() {
        hombre.setMensualIncome(1500000L);
        String texto = hombre.toString();
        assertNotNull("El texto generado no debe ser nulo", texto);
        assertTrue("El texto debe contener Mensual Income", texto.contains("Mensual Income"));
    }

    /**
     * Se ejecuta después de cada prueba.
     * 
     * @pre Se ha ejecutado una prueba.
     * @post Se valida que la instancia de {@code MenDTO} no sea nula.
     * @throws AssertionError si la instancia es nula.
     */
    @After
    public void despuesDeCadaPrueba() {
        assertNotNull(hombre);
    }

    /**
     * Se ejecuta una vez después de todas las pruebas.
     * 
     * @pre Todas las pruebas han sido ejecutadas.
     * @post Se imprime mensaje de finalización.
     */
    @AfterClass
    public static void despuesDeTodo() {
        System.out.println("Finalizando las pruebas de MenDTO");
    }
}

