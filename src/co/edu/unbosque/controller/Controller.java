package co.edu.unbosque.controller;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {
	
	//interfaz
	private VentanaPrincipal vp;
	
	public Controller() {
		vp = new VentanaPrincipal(this);
		asignarOyentes();	
		}
	
	
	public void asignarOyentes() {// Acá se agregan los lectores a los componentes
		
	}
	
	public void runGUI() {
		vp.setVisible(true);
	}

}
