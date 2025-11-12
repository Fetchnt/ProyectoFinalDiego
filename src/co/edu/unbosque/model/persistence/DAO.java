package co.edu.unbosque.model.persistence;

import java.util.Properties;

/**
 * Interfaz genérica que define las operaciones básicas de persistencia (CRUD) y
 * utilidades asociadas a la gestión de datos. <br>
 * <b>pre:</b> El tipo genérico {@code A} debe estar correctamente definido e
 * implementado. <br>
 * <b>post:</b> Permite la creación, lectura, actualización, eliminación y
 * ordenamiento de datos, además de manejo de internacionalización y generación
 * de reportes.
 *
 * @param <A> Tipo de objeto que manejará la implementación del DAO.
 */
public interface DAO<A> {

	/**
	 * Crea y agrega un nuevo dato al almacenamiento.
	 * 
	 * @param nuevoDato Objeto de tipo {@code A} a agregar. No debe ser
	 *                  {@code null}.
	 */
	public void create(A nuevoDato);

	/**
	 * Muestra todos los datos almacenados en forma de cadena.
	 * 
	 * @return Cadena con la información de todos los elementos almacenados.
	 */
	public String showAll();

	/**
	 * Elimina un elemento del almacenamiento con base en su índice.
	 * 
	 * @param indice Posición del elemento a eliminar.
	 * @return {@code true} si la eliminación fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	public boolean delete(int indice);

	/**
	 * Elimina un objeto específico del almacenamiento.
	 * 
	 * @param objetoAEliminar Objeto de tipo {@code A} que se desea eliminar.
	 * @return {@code true} si la eliminación fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	public boolean delete(A objetoAEliminar);

	/**
	 * Actualiza un elemento en una posición específica.
	 * 
	 * @param indice          Índice del elemento a actualizar.
	 * @param datoActualizado Objeto con los nuevos datos.
	 * @return {@code true} si la actualización fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	public boolean update(int indice, A datoActualizado);

	/**
	 * Cuenta la cantidad de elementos almacenados.
	 * 
	 * @return Número total de registros en el almacenamiento.
	 */
	public int count();

	/**
	 * Lee y carga información desde un archivo de texto.
	 * 
	 * @param url Ruta del archivo desde el cual se leerán los datos.
	 */
	public void readFromTextFile(String url);

	/**
	 * Escribe la información actual en un archivo de texto.
	 */
	public void writeTextFile();

	/**
	 * Carga información desde un archivo serializado.
	 */
	public void loadFromSerializedFile();

	/**
	 * Guarda la información actual en un archivo serializado.
	 */
	public void writeSerializedFile();

	/**
	 * Actualiza el número de "likes" de un usuario específico identificado por su
	 * alias.
	 * 
	 * @param alias       Alias del usuario a actualizar.
	 * @param nuevosLikes Nuevo valor de "likes" a asignar.
	 * @return {@code true} si la actualización fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	public boolean actualizarLikes(String alias, int nuevosLikes);

	/**
	 * Establece las propiedades de internacionalización (idioma, mensajes, etc.).
	 * 
	 * @param prop Propiedades de configuración o idioma.
	 */
	public void internacionalizacion(Properties prop);

	/**
	 * Ordena los elementos almacenados en orden ascendente utilizando el algoritmo
	 * de ordenamiento por selección (Selection Sort).
	 */
	public void selectionSortAsc();

	/**
	 * Ordena los elementos almacenados en orden descendente utilizando el algoritmo
	 * de inserción (Insertion Sort).
	 */
	public void insertionSortDes();

	/**
	 * Genera un informe en formato PDF con base en el alias de un usuario.
	 * 
	 * @param alias Alias del usuario del cual se generará el informe.
	 */
	void generarInformePDF(String alias);
}
