package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblProfilePicture;
	private JLabel lblNameAge;
	private JLabel lblTitulo;
	
	private JTextArea txtDescription;
	
	private JButton btnLike;
	private JButton btnNope;
	private JButton btnFavorite; 
	private JButton btnProfile; 
	private JButton btnLogOff;
	private JButton btnVerMeGusta;
	private JButton btnModoIncognito;

	private JPanel panelMenu;

	public MainWindow() {
		//CONFIGURACION DE LA VENTANA
		this.setTitle("Inicio - BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));
		getContentPane().setLayout(null);

		// --- ENCABEZADO ---
		JLabel lblIcon = new JLabel("");
		lblIcon.setForeground(Color.decode("#F9CFCE"));
		lblIcon.setBackground(Color.decode("#F9CFCE"));
		lblIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/co/edu/unbosque/view/iconStart.JPG")));
		lblIcon.setBounds(0, 0, 980, 150);
		getContentPane().add(lblIcon);

		lblTitulo = new JLabel("¡Bienvenido a BosTinder!");
		lblTitulo.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblTitulo.setBounds(110, 166, 361, 58);
		getContentPane().add(lblTitulo);

		// --- FOTO GRANDE DEL PERFIL ---
		lblProfilePicture = new JLabel();
		lblProfilePicture.setBounds(57, 222, 350, 350);
		lblProfilePicture.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		getContentPane().add(lblProfilePicture);

		// --- NOMBRE Y EDAD DEBAJO DE LA FOTO ---
		lblNameAge = new JLabel("", SwingConstants.CENTER);
		lblNameAge.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		lblNameAge.setBounds(57, 571, 350, 25);
		getContentPane().add(lblNameAge);

		// --- DESCRIPCIÓN A LA DERECHA ---
		txtDescription = new JTextArea();
		txtDescription.setBounds(422, 290, 390, 280);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setBorder(BorderFactory.createTitledBorder("Descripción"));
		getContentPane().add(txtDescription);

		// --- BOTONES DE ACCIÓN ---
		btnNope = new JButton("  ✖️");
		btnNope.setBounds(344, 583, 60, 40);
		btnNope.setBackground(Color.decode("#EB5F5B"));
		btnNope.setForeground(Color.decode("#F9CFCE"));
		btnNope.setFocusPainted(false);
		btnNope.setBorderPainted(false);
		getContentPane().add(btnNope);

		btnFavorite = new JButton("⭐ Favorito");
		btnFavorite.setBounds(568, 583, 97, 40);
		btnFavorite.setForeground(Color.decode("#F9CFCE"));
		btnFavorite.setBackground(Color.decode("#EB5F5B"));
		btnFavorite.setFocusPainted(false);
		btnFavorite.setBorderPainted(false);
		getContentPane().add(btnFavorite);

		btnLike = new JButton("💖");
		btnLike.setBounds(57, 583, 60, 40);
		btnLike.setBackground(Color.decode("#EB5F5B"));
		btnLike.setForeground(Color.decode("#F9CFCE"));
		btnLike.setFocusPainted(false);
		btnLike.setBorderPainted(false);
		getContentPane().add(btnLike);

		// --- BOTONES LATERALES ---
		panelMenu = new JPanel();
		panelMenu.setBounds(422, 222, 485, 60);
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setLayout(null);
		add(panelMenu);
		
		btnVerMeGusta = new JButton("Ver me gusta");
		btnVerMeGusta.setBounds(10, 18, 110, 25);
		btnVerMeGusta.setBackground(Color.decode("#F9CFCE"));
		btnVerMeGusta.setForeground(Color.decode("#EB5F5B"));
		btnVerMeGusta.setFocusPainted(false);
		btnVerMeGusta.setBorderPainted(false);
		//getContentPane().add(btnVerMeGusta);
		panelMenu.add(btnVerMeGusta);
		
		btnModoIncognito = new JButton("Modo Incognito");
		btnModoIncognito.setBounds(126, 18, 122, 25);
		btnModoIncognito.setBackground(Color.decode("#F9CFCE"));
		btnModoIncognito.setForeground(Color.decode("#EB5F5B"));
		btnModoIncognito.setFocusPainted(false);
		btnModoIncognito.setBorderPainted(false);
		//getContentPane().add(btnModoIncognito);
		panelMenu.add(btnModoIncognito);
		
		btnProfile = new JButton("Mi Perfil");
		btnProfile.setBounds(253, 18, 105, 25);
		btnProfile.setBackground(Color.decode("#F9CFCE"));
		btnProfile.setForeground(Color.decode("#EB5F5B"));
		btnProfile.setFocusPainted(false);
		btnProfile.setBorderPainted(false);
		//getContentPane().add(btnProfile);
		panelMenu.add(btnProfile);
		
		btnLogOff = new JButton("Cerrar sesión");
		btnLogOff.setBounds(363, 18, 113, 25);
		btnLogOff.setBackground(Color.decode("#F9CFCE"));
		btnLogOff.setForeground(Color.decode("#EB5F5B"));
		btnLogOff.setFocusPainted(false);
		btnLogOff.setBorderPainted(false);
		//getContentPane().add(btnLogOff);
		panelMenu.add(btnLogOff);
		
		//------IMAGEN-------
		ImageIcon imageHeartTwo = new ImageIcon(getClass().getResource("heartTwo.JPG"));
		JLabel imageHeart = new JLabel(imageHeartTwo);
		imageHeart.setBounds(790, 300, 160, 300);
		this.add(imageHeart);
		
		
		// --- CARGAR EL PRIMER PERFIL ---
		/*
		 * actualizarPerfil();
		 * 
		 * // --- EVENTOS --- btnCerrarSesion.addActionListener(new ActionListener() {
		 * public void actionPerformed(ActionEvent e) {
		 * JOptionPane.showMessageDialog(null, "Sesión cerrada correctamente.");
		 * dispose(); } });
		 * 
		 * ActionListener siguientePerfil = new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { indiceActual++; if
		 * (indiceActual >= perfiles.length) { indiceActual = 0; // reinicia cuando se
		 * acaba la lista } actualizarPerfil(); } };
		 * 
		 * btnLike.addActionListener(siguientePerfil);
		 * btnNope.addActionListener(siguientePerfil);
		 * btnFavorito.addActionListener(siguientePerfil); }
		 */

		/**
		 * Actualiza los datos del perfil mostrado (foto, nombre, edad, descripción)
		 * 
		 * private void actualizarPerfil() { String nombre = perfiles[indiceActual][0];
		 * String edad = perfiles[indiceActual][1]; String descripcion =
		 * perfiles[indiceActual][2]; String rutaImagen = perfiles[indiceActual][3];
		 * 
		 * lblNombreEdad.setText(nombre + ", " + edad);
		 * txtDescripcion.setText(descripcion);
		 * 
		 * ImageIcon image = new ImageIcon(BTMainWindow.class.getResource(rutaImagen));
		 * ImageIcon scaled = new ImageIcon(image.getImage().getScaledInstance(350, 350,
		 * java.awt.Image.SCALE_SMOOTH)); lblFotoPerfil.setIcon(scaled); }
		 */

	}

	public void aplicarInternacionalizacion(Properties prop) {
		// Título de la ventana
		setTitle(prop.getProperty("bostinder.view.mainwindow.title"));

		lblTitulo.setText(prop.getProperty("bostinder.view.mainwindow.header"));

		// Bordes y título de descripción
		txtDescription.setBorder(
				BorderFactory.createTitledBorder(prop.getProperty("bostinder.view.mainwindow.label.description")));

		// Botones principales
		btnLike.setText(prop.getProperty("bostinder.view.mainwindow.button.like"));
		btnNope.setText(prop.getProperty("bostinder.view.mainwindow.button.nope"));
		btnFavorite.setText(prop.getProperty("bostinder.view.mainwindow.button.favorite"));
		btnProfile.setText(prop.getProperty("bostinder.view.mainwindow.button.profile"));
		btnLogOff.setText(prop.getProperty("bostinder.view.mainwindow.button.logout"));

	}

	public JLabel getLblProfilePicture() {
		return lblProfilePicture;
	}

	public void setLblProfilePicture(JLabel lblProfilePicture) {
		this.lblProfilePicture = lblProfilePicture;
	}

	public JLabel getLblNameAge() {
		return lblNameAge;
	}

	public void setLblNameAge(JLabel lblNameAge) {
		this.lblNameAge = lblNameAge;
	}

	public JTextArea getTxtDescription() {
		return txtDescription;
	}

	public void setTxtDescription(JTextArea txtDescription) {
		this.txtDescription = txtDescription;
	}

	public JButton getBtnLike() {
		return btnLike;
	}

	public void setBtnLike(JButton btnLike) {
		this.btnLike = btnLike;
	}

	public JButton getBtnNope() {
		return btnNope;
	}

	public void setBtnNope(JButton btnNope) {
		this.btnNope = btnNope;
	}

	public JButton getBtnFavorite() {
		return btnFavorite;
	}

	public void setBtnFavorite(JButton btnFavorite) {
		this.btnFavorite = btnFavorite;
	}

	public JButton getBtnProfile() {
		return btnProfile;
	}

	public void setBtnProfile(JButton btnProfile) {
		this.btnProfile = btnProfile;
	}

	public JButton getBtnLogOff() {
		return btnLogOff;
	}

	public void setBtnLogOff(JButton btnLogOff) {
		this.btnLogOff = btnLogOff;
	}

	public JButton getBtnVerMeGusta() {
		return btnVerMeGusta;
	}

	public void setBtnVerMeGusta(JButton btnVerMeGusta) {
		this.btnVerMeGusta = btnVerMeGusta;
	}

	public JButton getBtnModoIncognito() {
		return btnModoIncognito;
	}

	public void setBtnModoIncognito(JButton btnModoIncognito) {
		this.btnModoIncognito = btnModoIncognito;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}
	
	

}