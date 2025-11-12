package co.edu.unbosque.view;

import java.awt.Color;

import java.awt.Font;
import javax.swing.*;

import java.util.Properties;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5700920981964266645L;
	private JLabel lblProfilePicture;
	private JLabel lblNameAge;
	private JLabel lblTitulo;
	private JLabel lBosTinder;

	private JTextArea txtDescription;

	private JButton btnLike;
	private JButton btnNope;
	private JButton btnProfile;
	private JButton btnLogOff;
	private JButton btnVerMeGusta;
	private JButton btnModoIncognito;
	private JButton darkMode;
	private boolean isDarkMode = false;

	private JPanel panelMenu;
	private JPanel panelLogo;

	public MainWindow() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("Inicio - BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));
		getContentPane().setLayout(null);

		// ---------IMAGEN SUPERIOR----------

		panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 980, 150);
		panelLogo.setBackground(Color.decode("#FFFFFF"));
		panelLogo.setLayout(null);
		this.add(panelLogo);

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconBosTinder.png"));
		JLabel lIcon = new JLabel(imageLogo);
		lIcon.setBounds(250, 10, 120, 120);
		panelLogo.add(lIcon);
		// add(lIcon);

		lBosTinder = new JLabel("BosTinder");
		lBosTinder.setBounds(380, 35, 400, 72);
		lBosTinder.setForeground(Color.decode("#303080D"));
		lBosTinder.setFont(new Font("Georgia", Font.BOLD, 70));
		panelLogo.add(lBosTinder);
		// add(lBosTinder);

		lblTitulo = new JLabel("隆Bienvenido a BosTinder!");
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

		// --- DESCRIPCI脫N A LA DERECHA ---
		txtDescription = new JTextArea();
		txtDescription.setBounds(422, 290, 390, 280);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setBorder(BorderFactory.createTitledBorder("Descripci贸n"));
		getContentPane().add(txtDescription);

		// --- BOTONES DE ACCI脫N ---
		btnNope = new JButton("  鉁栵笍");
		btnNope.setBounds(344, 583, 60, 40);
		btnNope.setBackground(Color.decode("#EB5F5B"));
		btnNope.setForeground(Color.decode("#F9CFCE"));
		btnNope.setFocusPainted(false);
		btnNope.setBorderPainted(false);
		getContentPane().add(btnNope);

		btnLike = new JButton("馃挅");
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
		// getContentPane().add(btnVerMeGusta);
		panelMenu.add(btnVerMeGusta);

		btnModoIncognito = new JButton("Modo Incognito");
		btnModoIncognito.setBounds(126, 18, 122, 25);
		btnModoIncognito.setBackground(Color.decode("#F9CFCE"));
		btnModoIncognito.setForeground(Color.decode("#EB5F5B"));
		btnModoIncognito.setFocusPainted(false);
		btnModoIncognito.setBorderPainted(false);
		// getContentPane().add(btnModoIncognito);
		panelMenu.add(btnModoIncognito);

		btnProfile = new JButton("Mi Perfil");
		btnProfile.setBounds(253, 18, 105, 25);
		btnProfile.setBackground(Color.decode("#F9CFCE"));
		btnProfile.setForeground(Color.decode("#EB5F5B"));
		btnProfile.setFocusPainted(false);
		btnProfile.setBorderPainted(false);
		// getContentPane().add(btnProfile);
		panelMenu.add(btnProfile);

		btnLogOff = new JButton("Cerrar sesi贸n");
		btnLogOff.setBounds(363, 18, 113, 25);
		btnLogOff.setBackground(Color.decode("#F9CFCE"));
		btnLogOff.setForeground(Color.decode("#EB5F5B"));
		btnLogOff.setFocusPainted(false);
		btnLogOff.setBorderPainted(false);
		// getContentPane().add(btnLogOff);
		panelMenu.add(btnLogOff);

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(800, 10, 150, 30);
		darkMode.addActionListener(e -> cambiarAModoOscuroMW());
		add(darkMode);

		// ------IMAGEN-------
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
		 * JOptionPane.showMessageDialog(null, "Sesi贸n cerrada correctamente.");
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
		 * Actualiza los datos del perfil mostrado (foto, nombre, edad, descripci贸n)
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

	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
	public void cambiarAModoOscuroMW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelMenu.setBackground(Color.decode("#FFFFFF"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));
			lblTitulo.setForeground(Color.decode("#000000"));
			lblNameAge.setForeground(Color.decode("#000000"));

			// 脕rea de texto
			txtDescription.setBackground(Color.decode("#FFFFFF"));
			txtDescription.setForeground(Color.decode("#000000"));

			// Botones principales
			btnLike.setForeground(Color.decode("#F9CFCE"));
			btnLike.setBackground(Color.decode("#EB5F5B"));
			btnNope.setForeground(Color.decode("#F9CFCE"));
			btnNope.setBackground(Color.decode("#EB5F5B"));

			// Botones del panelMenu
			btnVerMeGusta.setForeground(Color.decode("#EB5F5B"));
			btnVerMeGusta.setBackground(Color.decode("#F9CFCE"));
			btnModoIncognito.setForeground(Color.decode("#EB5F5B"));
			btnModoIncognito.setBackground(Color.decode("#F9CFCE"));
			btnProfile.setForeground(Color.decode("#EB5F5B"));
			btnProfile.setBackground(Color.decode("#F9CFCE"));
			btnLogOff.setForeground(Color.decode("#EB5F5B"));
			btnLogOff.setBackground(Color.decode("#F9CFCE"));

			// Borde de la foto de perfil
			lblProfilePicture.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

			// Bot贸n darkMode
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelMenu.setBackground(Color.decode("#1E1724"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));
			lblTitulo.setForeground(Color.decode("#FF7171"));
			lblNameAge.setForeground(Color.decode("#DCC8EF"));

			// 脕rea de texto
			txtDescription.setBackground(Color.decode("#2A1F3A"));
			txtDescription.setForeground(Color.decode("#DCC8EF"));

			// Botones principales
			btnLike.setForeground(Color.decode("#DCC8EF"));
			btnLike.setBackground(Color.decode("#52247C"));
			btnNope.setForeground(Color.decode("#DCC8EF"));
			btnNope.setBackground(Color.decode("#52247C"));

			// Botones del panelMenu
			btnVerMeGusta.setForeground(Color.decode("#DCC8EF"));
			btnVerMeGusta.setBackground(Color.decode("#52247C"));
			btnModoIncognito.setForeground(Color.decode("#DCC8EF"));
			btnModoIncognito.setBackground(Color.decode("#52247C"));
			btnProfile.setForeground(Color.decode("#DCC8EF"));
			btnProfile.setBackground(Color.decode("#52247C"));
			btnLogOff.setForeground(Color.decode("#DCC8EF"));
			btnLogOff.setBackground(Color.decode("#52247C"));

			// Borde de la foto de perfil
			lblProfilePicture.setBorder(BorderFactory.createLineBorder(Color.decode("#DCC8EF"), 2));

			// Bot贸n darkMode
			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}

	}

	public void aplicarInternacionalizacion(Properties prop) {
		// T铆tulo de la ventana
		setTitle(prop.getProperty("bostinder.view.mainwindow.title"));

		lblTitulo.setText(prop.getProperty("bostinder.view.mainwindow.header"));

		// Bordes y t铆tulo de descripci贸n
		txtDescription.setBorder(
				BorderFactory.createTitledBorder(prop.getProperty("bostinder.view.mainwindow.label.description")));

		// Botones principales
		btnLike.setText(prop.getProperty("bostinder.view.mainwindow.button.like"));
		btnNope.setText(prop.getProperty("bostinder.view.mainwindow.button.nope"));
		btnProfile.setText(prop.getProperty("bostinder.view.mainwindow.button.profile"));
		btnLogOff.setText(prop.getProperty("bostinder.view.mainwindow.button.logout"));
		btnModoIncognito.setText(prop.getProperty("bostinder.view.mainwindow.button.incognito"));
		btnVerMeGusta.setText(prop.getProperty("bostinder.view.mainwindow.button.seelikes"));

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

	public JLabel getlBosTinder() {
		return lBosTinder;
	}

	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}

	public JButton getDarkMode() {
		return darkMode;
	}

	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}

	public boolean isDarkMode() {
		return isDarkMode;
	}

	public void setDarkMode(boolean isDarkMode) {
		this.isDarkMode = isDarkMode;
	}

	public JPanel getPanelLogo() {
		return panelLogo;
	}

	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
	}

}