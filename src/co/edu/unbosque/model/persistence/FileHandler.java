package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;
import co.edu.unbosque.model.*;

/**
 * Clase encargada de gestionar la lectura y escritura de archivos de texto,
 * archivos serializados y archivos de propiedades. <b>pre:</b> Deben existir
 * rutas de archivos válidas y objetos serializables. <br>
 * <b>post:</b> Permite guardar, leer y manipular datos persistentes en formato
 * de texto, binario o propiedades.
 * 
 */
public class FileHandler {

	/** Archivo genérico utilizado en las operaciones de lectura y escritura. */
	public static File archivo;

	/** Escritor de texto usado para la escritura de archivos planos. */
	public static PrintWriter escritor;

	/** Lector de texto utilizado para leer archivos planos. */
	public static Scanner lector;

	/** Flujo de entrada de datos para archivos serializados. */
	public static FileInputStream fis;

	/** Flujo de lectura de objetos serializados. */
	public static ObjectInputStream ois;

	/** Flujo de salida de datos para archivos serializados. */
	public static FileOutputStream fos;

	/** Flujo de escritura de objetos serializados. */
	public static ObjectOutputStream oos;

	/** Archivo de propiedades cargado desde un recurso externo. */
	public static Properties prop;

	/**
	 * Escribe un contenido en un archivo de texto. Si el archivo no existe, lo
	 * crea.
	 * 
	 * @param url       Ruta del archivo a escribir.
	 * @param contenido Texto que se desea almacenar dentro del archivo.
	 */
	public static void escribirEnArchivoTexto(String url, String contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();
		} catch (IOException e) {
			System.err.println("Error al crear y escribir el archivo de texto.");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lee el contenido completo de un archivo de texto.
	 * 
	 * @param url Ruta del archivo que se desea leer.
	 * @return Cadena con el contenido del archivo o {@code null} si ocurre un
	 *         error.
	 */
	public static String leerDesdeArchivoTexto(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lector = new Scanner(archivo);
			String contenido = "";
			while (lector.hasNext()) {
				contenido += lector.nextLine() + "\n";
			}
			lector.close();
			return contenido;
		} catch (IOException e) {
			System.err.println("Error al leer el archivo de texto.");
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Escribe un objeto serializable en un archivo binario. Si el archivo no
	 * existe, lo crea.
	 * 
	 * @param url       Ruta del archivo donde se guardará el objeto.
	 * @param contenido Objeto que se desea serializar y guardar.
	 */
	public static void escribirEnArchivoSerializado(String url, Object contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.err.println("Error al escribir el archivo serializado.");
			e.printStackTrace();
		}
	}

	/**
	 * Lee un objeto serializado desde un archivo binario.
	 * 
	 * @param url Ruta del archivo desde el cual se desea leer el objeto.
	 * @return Objeto deserializado o {@code null} si ocurre un error.
	 */
	public static Object leerDesdeArchivoSerializado(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object contenido = ois.readObject();
			ois.close();
			fis.close();
			return contenido;
		} catch (IOException e) {
			System.err.println("Error al leer el archivo serializado.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Error al deserializar los datos del usuario.");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Carga un archivo de propiedades (.properties) desde una ruta específica.
	 * 
	 * @param url Ruta del archivo de propiedades.
	 * @return Objeto {@link Properties} con las configuraciones cargadas o
	 *         {@code null} si ocurre un error.
	 */
	public static Properties cargarArchivoPropiedades(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			prop = new Properties();
			prop.load(new FileInputStream(archivo));
			return prop;
		} catch (IOException e) {
			System.err.println("Error al cargar el archivo de propiedades.");
			e.printStackTrace();
		}
		return null;
	}
}
