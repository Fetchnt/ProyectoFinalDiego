package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.PrincipalWindow;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	// interfaz
	private ViewFacade vf;

	public Controller() {
		vf = new ViewFacade();
		asignarOyentes();
	}

	public void asignarOyentes() {// Acá se agregan los lectores a los componentes
		vf.getMaw().getStart().addActionListener(this);
		vf.getMaw().getStart().setActionCommand("boton_start");

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
			}
		}

	}

	public void runGUI() {
		vf.getMaw().setVisible(true);
	}

}
