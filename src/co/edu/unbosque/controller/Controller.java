package co.edu.unbosque.controller;

import co.edu.unbosque.view.MainWindow;

public class Controller {
	
	//interfaz
	private MainWindow mw;
	
	public Controller() {
		mw = new MainWindow(this);
		asignarOyentes();	
		}
	
	
	public void asignarOyentes() {// Acá se agregan los lectores a los componentes
		
	}
	
	public void runGUI() {
		mw.setVisible(true);
	}

}
