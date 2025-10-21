package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	// interfaz

	private ModelFacade model;
	private ViewFacade vf;

	public Controller() {
		model = new ModelFacade();
		vf = new ViewFacade(model);
		asignarOyentes();
	}

	public void asignarOyentes() {// Acá se agregan los lectores a los componentes
		vf.getMaw().getStart().addActionListener(this);
		vf.getMaw().getStart().setActionCommand("boton_start");
		
		vf.getMaw().getMapButton().addActionListener(this);
		vf.getMaw().getMapButton().setActionCommand("abrir_mapa");

	}

	/*
	 * @Override public void actionPerfomed(ActionEvent e) { String alias =
	 * e.getActionCommand(); switch (alias) {
	 * 
	 * } }
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_start": {
			vf.getMaw().dispose();
			vf.getSw().setVisible(true);
			break;
		}
		case "abrir_mapa": { 
			vf.getSw().dispose();
			vf.getMw().setVisible(true);
			break;
		}
		}

	}

	public void runGUI() {
		vf.getMaw().setVisible(true);
	}

}
