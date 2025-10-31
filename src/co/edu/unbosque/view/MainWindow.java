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
	private JTextArea txtDescription;
	private JButton btnLike, btnNope, btnFavorite, btnProfile, btnLogOff;

	public MainWindow() {
		this.setTitle("BosTinder - Inicio");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));
		getContentPane().setLayout(null);

		// --- Encabezado ---
		JLabel lblIcon = new JLabel("");
		lblIcon.setForeground(Color.decode("#F9CFCE"));
		lblIcon.setBackground(Color.decode("#F9CFCE"));
		lblIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/co/edu/unbosque/view/iconStart.JPG")));
		lblIcon.setBounds(10, 11, 938, 144);
		getContentPane().add(lblIcon);

		JLabel lblTitulo = new JLabel("¡Bienvenido a BosTinder!");
		lblTitulo.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblTitulo.setBounds(20, 166, 361, 58);
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
		txtDescription.setBounds(480, 250, 420, 280);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setBorder(BorderFactory.createTitledBorder("Descripción"));
		getContentPane().add(txtDescription);

		// --- BOTONES DE ACCIÓN ---
		btnNope = new JButton("✖️");
		btnNope.setBounds(264, 603, 100, 40);
		getContentPane().add(btnNope);

		btnFavorite = new JButton("⭐ Favorito");
		btnFavorite.setBounds(780, 565, 120, 40);
		getContentPane().add(btnFavorite);

		btnLike = new JButton("💖");
		btnLike.setBounds(91, 603, 100, 40);
		getContentPane().add(btnLike);

		// --- BOTONES LATERALES ---
		btnProfile = new JButton("Mi Perfil");
		btnProfile.setBounds(801, 182, 100, 32);
		getContentPane().add(btnProfile);

		btnLogOff = new JButton("Cerrar sesión");
		btnLogOff.setBounds(458, 182, 100, 32);
		getContentPane().add(btnLogOff);

		JButton btnVerMeGusta = new JButton("Ver me gusta");
		btnVerMeGusta.setBounds(691, 182, 100, 32);
		getContentPane().add(btnVerMeGusta);

		JButton btnModoIncognito = new JButton("Modo Incognito");
		btnModoIncognito.setBounds(568, 182, 113, 32);
		getContentPane().add(btnModoIncognito);

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

		// Texto del encabezado
		// Busca el JLabel que contiene "¡Bienvenido a BosTinder!"
		for (java.awt.Component comp : getContentPane().getComponents()) {
			if (comp instanceof JLabel lbl && "¡Bienvenido a BosTinder!".equals(lbl.getText())) {
				lbl.setText(prop.getProperty("bostinder.view.mainwindow.header"));
			}
		}

		// 🔹 Bordes y título de descripción
		txtDescription.setBorder(
				BorderFactory.createTitledBorder(prop.getProperty("bostinder.view.mainwindow.label.description")));

		// 🔹 Botones principales
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

}