package co.edu.unbosque.model;

import java.awt.Rectangle;

public class Pais {

	private String nombre;
	private Rectangle area;

	public Pais(String nombre, Rectangle area) {
		this.nombre = nombre;
		this.area = area;
	}

	public boolean contiene(int x, int y) {
		return area.contains(x, y);
	}

	public String getNombre() {
		return nombre;
	}
}
