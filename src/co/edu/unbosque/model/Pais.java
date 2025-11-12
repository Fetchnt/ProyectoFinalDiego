package co.edu.unbosque.model;

import java.awt.Rectangle;

/**
 * Clase que representa un país dentro del sistema. <b>pre:</b> Debe existir un
 * nombre y un área geográfica definida. <br>
 * <b>post:</b> Se crea un país con su respectiva área delimitada en
 * coordenadas.
 * 
 */
public class Pais {

	/** Nombre del país. */
	private String nombre;

	/** Área geográfica del país representada como un rectángulo. */
	private Rectangle area;

	/**
	 * Constructor que inicializa el país con su nombre y su área geográfica.
	 * 
	 * @param nombre Nombre del país.
	 * @param area   Área del país representada como un objeto {@link Rectangle}.
	 */
	public Pais(String nombre, Rectangle area) {
		this.nombre = nombre;
		this.area = area;
	}

	/**
	 * Verifica si un punto específico (x, y) se encuentra dentro del área del país.
	 * 
	 * @param x Coordenada X del punto a verificar.
	 * @param y Coordenada Y del punto a verificar.
	 * @return {@code true} si el punto está dentro del área del país, {@code false}
	 *         en caso contrario.
	 */
	public boolean contiene(int x, int y) {
		return area.contains(x, y);
	}

	/**
	 * Obtiene el nombre del país.
	 * 
	 * @return Nombre del país.
	 */
	public String getNombre() {
		return nombre;
	}
}
