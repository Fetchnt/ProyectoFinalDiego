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
		// BOTONES
		vf.getPw().getStart().addActionListener(this);
		vf.getPw().getStart().setActionCommand("boton_start");
		
		vf.getSw().getSignIn().addActionListener(this);
		vf.getSw().getSignIn().setActionCommand("boton_signIn");
		
		vf.getSw().getLogin().addActionListener(this);
		vf.getSw().getLogin().setActionCommand("boton_login");
		
		vf.getSw().getExit().addActionListener(this);
		vf.getSw().getExit().setActionCommand("boton_exit");
		
		vf.getSw().getBack().addActionListener(this);
		vf.getSw().getBack().setActionCommand("boton_back");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_start": {
			vf.getPw().dispose();
			vf.getSw().setVisible(true);
		}
	/*
		case "boton_signIn": {
			vf.getSiw().setVisible(true);
			vf.getSw().setVisible(true);
		}
		case "boton_login": {
			vf.getSw().dispose();
			vf.getLw().setVisible(true);
		}
		case "boton_exit": {
			vf.getSw().dispose();
		}
		case "boton_back": {
			vf.getSw().dispose();
			vf.getPw().setVisible(true);
		}
	 */
		}

	}

	public void runGUI() {
		vf.getPw().setVisible(true);
	}

}
