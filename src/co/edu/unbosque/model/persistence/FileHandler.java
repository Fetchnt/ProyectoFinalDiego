package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import co.edu.unbosque.model.*;

public class FileHandler {

	// Archivos de texto

	// Localizar el archivp
	public static File archivo;
	// Syso de archivos
	public static PrintWriter escritor;
	// Lector de archivos
	public static Scanner lector;

	// Serializado: capacidad de confertir un objeto a material binario para poder
	// ser enviado

	// Crear o localizar el archivo de entrada de datos
	public static FileInputStream fis;

	//
	public static ObjectInputStream ois;

	public static FileOutputStream fos;

	public static ObjectOutputStream oos;

	// Es obligatorio que exista el archivo serializado antes de leer

	public static void escribirEnArchivoTexto(String url, String contenido) {
		// Verificar url del archivo
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			// solo un aplicativo al tiempo puede tener un archivo abierto al tiempo
			escritor.close();
		} catch (IOException e) {
			System.err.println("Error al crear y escribir el archivo de texto.");
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	public static String leerDesdeArchivoTexto(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lector = new Scanner(archivo);
			String contenido = "";
			while (lector.hasNext()) { // Verifica que la siguiente linea tenga contenido y lo continua leyendo
				contenido += lector.nextLine() + "\n";
			}
			lector.close();
			return contenido;

		} catch (IOException e) {
			System.err.println("Error al leer el archivo de texto.");
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return null;
	}

	public static void escribirEnArchivoSerializado(String url, Object contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			// primero cerrar object y despues file
			oos.close();
			fos.close();

		} catch (IOException e) {
			System.err.println("Error al escribir el archivo serializado.");
			e.printStackTrace();

			// Se indica a las clases padres e hijas que tienen la capacidad de
			// serializacion, y todo se hace en el modelo
		}
	}

}
