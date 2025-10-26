package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ModelFacade model;
	private ViewFacade vf;

	public Controller() {
		model = new ModelFacade();
		vf = new ViewFacade(model);
		asignarOyentes();
	}

	public void asignarOyentes() {
		// BOTONES Start en PrincipalWindow
		vf.getPw().getStart().addActionListener(this);
		vf.getPw().getStart().setActionCommand("boton_start");

		// BOTONES en SignInWindow
		vf.getSw().getSignIn().addActionListener(this);
		vf.getSw().getSignIn().setActionCommand("boton_signIn");

		vf.getSw().getLogin().addActionListener(this);
		vf.getSw().getLogin().setActionCommand("boton_login");

		vf.getSw().getExit().addActionListener(this);
		vf.getSw().getExit().setActionCommand("boton_exit");

		vf.getSw().getBack().addActionListener(this);
		vf.getSw().getBack().setActionCommand("boton_back");

		// ---------- BOTONES en BTRegisterWindow ----------
		vf.getRw().getBtnRegistrar().addActionListener(this);
		vf.getRw().getBtnRegistrar().setActionCommand("boton_registrar");

		vf.getRw().getBtnSubirFoto().addActionListener(this);
		vf.getRw().getBtnSubirFoto().setActionCommand("boton_subir_foto");

		vf.getRw().getCmbGenero().addActionListener(this);
		vf.getRw().getCmbGenero().setActionCommand("seleccionar_genero");

		// Mapa
		vf.getSw().getMapButton().addActionListener(this);
		vf.getSw().getMapButton().setActionCommand("abrir_mapa");

		vf.getMw().getBtnBackMap().addActionListener(this);
		vf.getMw().getBtnBackMap().setActionCommand("back_mapa");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_start":
			vf.getPw().dispose();
			vf.getSw().setVisible(true);
			break;

		case "abrir_mapa":
			vf.getSw().dispose();
			vf.getMw().setVisible(true);
			break;

		case "boton_signIn":
			vf.getSw().setVisible(false);
			vf.getRw().setVisible(true);
			break;

		case "boton_login":
			vf.getSw().dispose();
			vf.getLw().setVisible(true);
			break;

		case "boton_exit":
			vf.getSw().dispose();
			break;

		case "boton_back":
			vf.getSw().dispose();
			vf.getPw().setVisible(true);
			break;

		// ---------- ACCIONES DEL REGISTRO ----------
		case "boton_subir_foto":
			JOptionPane.showMessageDialog(null, "Sube tu foto desde la ventana de registro.");
			break;

		case "seleccionar_genero":
			// LOGICA DE SELECCIONAR GENERO (ESTA EN REGISTER WINDOW)
			break;

		case "boton_registrar":
			JOptionPane.showMessageDialog(null, "Registro exitoso.\n¡Bienvenido al sistema!");
			vf.getRw().setVisible(false);
			vf.getSw().setVisible(true);
			break;

		case "back_mapa":
			vf.getMw().dispose();
			vf.getSw().setVisible(true);
			break;

		default:
			System.out.println("Acción no definida: " + alias);
			break;
		}
	}

	public void runGUI() {
		vf.getPw().setVisible(true);
	}
}
