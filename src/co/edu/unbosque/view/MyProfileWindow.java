package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa la ventana de perfil del usuario en la aplicación
 * BosTinder.
 * 
 * <p>
 * Esta ventana muestra la información personal del usuario registrado,
 * incluyendo foto de perfil, nombre, apellido, edad, correo, ingresos, y el
 * número de likes recibidos. Incluye opciones para volver o cerrar sesión,
 * además de soporte para internacionalización y cambio de tema visual (modo
 * claro/oscuro).
 * </p>
 * 
 * <p>
 * Incluye elementos gráficos como paneles, etiquetas, campos de texto, botones
 * e imágenes, y permite aplicar configuraciones de internacionalización y tema
 * visual.
 * </p>
 * 
 * Autor: Maria Alejandra Carvajal Nepta
 */
public class MyProfileWindow extends JFrame {

	/**
	 * Identificador de versión para la serialización.
	 */
	private static final long serialVersionUID = -6565373921781216469L;
	// Componentes gráficos.
	private JPanel panelOpcion;
	private JPanel panelLike;
	private JPanel panelInformacion;
	private JPanel panelLogo;

	private JButton btnback;
	private JButton btnclose;
	private JButton darkMode;
	private boolean isDarkMode = false;

	private JLabel lBosTinder;
	private JLabel icon;
	private JLabel lblLike;
	private JLabel option;
	private JLabel lblHeart;
	private JLabel partner;
	private JLabel lblFotoPreview;
	private JLabel lblAlias;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEdad;
	private JLabel lblCorreo;
	private JLabel lblIngresos;

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtCorreo;
	private JTextField txtAlias;
	private JTextField txtLikes;
	private JTextField txtIngresos;

	/**
	 * Constructor por defecto.
	 * 
	 * @pre No se ha inicializado la ventana.
	 * @post Se inicializan los componentes y se configura la ventana.
	 */
	public MyProfileWindow() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("Mi perfil - BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE")); // -> falta agregarle color

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

		ImageIcon image = new ImageIcon(getClass().getResource("partnerFive.png"));
		partner = new JLabel(image);
		partner.setBounds(20, 190, 300, 450);
		add(partner);

		// --INFORMACION DEL USUARIO---
		panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBounds(330, 190, 330, 460);
		panelInformacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),
				"MI PERFIL", TitledBorder.CENTER, TitledBorder.TOP, new Font("Cooper Black", Font.ITALIC, 15)));
		panelInformacion.setBackground(Color.WHITE);
		getContentPane().add(panelInformacion);

		lblFotoPreview = new JLabel();
		lblFotoPreview.setBounds(100, 50, 140, 140);
		lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelInformacion.add(lblFotoPreview);

		lblAlias = new JLabel("Username:");
		lblAlias.setBounds(20, 240, 100, 20);
		panelInformacion.add(lblAlias);

		txtAlias = new JTextField();
		txtAlias.setBounds(120, 240, 180, 20);
		txtAlias.setEditable(false);
		panelInformacion.add(txtAlias);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 270, 100, 20);
		panelInformacion.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(120, 270, 180, 20);
		txtNombre.setEditable(false);
		panelInformacion.add(txtNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 300, 100, 20);
		panelInformacion.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(120, 300, 180, 20);
		txtApellido.setEditable(false);
		panelInformacion.add(txtApellido);

		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 330, 100, 20);
		panelInformacion.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(120, 330, 180, 20);
		txtEdad.setEditable(false);
		panelInformacion.add(txtEdad);

		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(20, 360, 100, 20);
		panelInformacion.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(120, 360, 180, 20);
		txtCorreo.setEditable(false);
		panelInformacion.add(txtCorreo);

		lblIngresos = new JLabel("Ingresos (USD):");
		lblIngresos.setBounds(20, 390, 100, 20);
		panelInformacion.add(lblIngresos);

		txtIngresos = new JTextField();
		txtIngresos.setBounds(120, 390, 180, 20);
		txtIngresos.setEditable(false);
		panelInformacion.add(txtIngresos);

		// ----- panel para las opciones -----
		panelOpcion = new JPanel();
		panelOpcion.setLayout(null);
		panelOpcion.setBounds(695, 440, 250, 170);
		panelOpcion.setBackground(Color.WHITE);
		add(panelOpcion);

		option = new JLabel("OPCIONES");
		option.setBounds(80, 6, 100, 20);
		option.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		option.setBackground(Color.WHITE);
		panelOpcion.add(option);

		btnback = new JButton("VOLVER");
		btnback.setBounds(80, 45, 94, 40);
		btnback.setFont(new Font("Arial", Font.BOLD, 12));
		btnback.setBackground(Color.decode("#F9CFCE"));
		btnback.setFocusPainted(false);
		btnback.setBorderPainted(false);
		panelOpcion.add(btnback);

		btnclose = new JButton("CERRAR SESIÓN");
		btnclose.setBounds(64, 95, 130, 40);
		btnclose.setFont(new Font("Arial", Font.BOLD, 12));
		btnclose.setBackground(Color.decode("#F9CFCE"));
		btnclose.setFocusPainted(false);
		btnclose.setBorderPainted(false);
		panelOpcion.add(btnclose);

		ImageIcon changeMode = new ImageIcon(getClass().getResource("changeMode.png"));
		JLabel lChangeMode = new JLabel(changeMode);
		darkMode = new JButton(changeMode);
		darkMode.setBounds(8, 160, 66, 60);
		darkMode.setOpaque(false);
		darkMode.setOpaque(false);
		darkMode.setContentAreaFilled(false);
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuroMPW());
		getContentPane().add(darkMode);

		// ------ panel para los likes ---
		panelLike = new JPanel();
		panelLike.setLayout(null);
		panelLike.setBounds(695, 200, 250, 200);
		panelLike.setBackground(Color.WHITE);
		add(panelLike);

		lblLike = new JLabel("LIKES A TU PERFIL");
		lblLike.setBounds(55, 6, 180, 20);
		lblLike.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		lblLike.setBackground(Color.WHITE);
		panelLike.add(lblLike);

		ImageIcon imageHeart = new ImageIcon(getClass().getResource("heartThree.JPG"));
		lblHeart = new JLabel(imageHeart);
		lblHeart.setBounds(30, 55, 95, 95);
		panelLike.add(lblHeart);

		txtLikes = new JTextField();
		txtLikes.setBounds(130, 55, 95, 95);
		txtLikes.setFont(new Font("Arial", Font.BOLD, 30));
		txtLikes.setBorder(null);
		txtLikes.setEditable(false);
		panelLike.add(txtLikes);
	}

	/**
	 * Cambia el tema visual de la ventana entre modo claro y modo oscuro.
	 * 
	 * @pre La ventana debe estar inicializada.
	 * @post Se actualiza el color de fondo y estilo de los componentes según el
	 *       modo.
	 */
	public void cambiarAModoOscuroMPW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			panelInformacion.setBackground(Color.decode("#FFFFFF"));
			panelOpcion.setBackground(Color.decode("#FFFFFF"));
			panelLike.setBackground(Color.decode("#FFFFFF"));

			lBosTinder.setForeground(Color.decode("#303080D"));
			option.setForeground(Color.decode("#000000"));
			lblLike.setForeground(Color.decode("#000000"));

			// Labels del panelInformacion
			lblAlias.setForeground(Color.decode("#000000"));
			lblNombre.setForeground(Color.decode("#000000"));
			lblApellido.setForeground(Color.decode("#000000"));
			lblEdad.setForeground(Color.decode("#000000"));
			lblCorreo.setForeground(Color.decode("#000000"));
			lblIngresos.setForeground(Color.decode("#000000"));

			// Campos de texto
			txtAlias.setBackground(Color.decode("#FFFFFF"));
			txtAlias.setForeground(Color.decode("#000000"));
			txtNombre.setBackground(Color.decode("#FFFFFF"));
			txtNombre.setForeground(Color.decode("#000000"));
			txtApellido.setBackground(Color.decode("#FFFFFF"));
			txtApellido.setForeground(Color.decode("#000000"));
			txtEdad.setBackground(Color.decode("#FFFFFF"));
			txtEdad.setForeground(Color.decode("#000000"));
			txtCorreo.setBackground(Color.decode("#FFFFFF"));
			txtCorreo.setForeground(Color.decode("#000000"));
			txtIngresos.setBackground(Color.decode("#FFFFFF"));
			txtIngresos.setForeground(Color.decode("#000000"));
			txtLikes.setBackground(Color.decode("#FFFFFF"));
			txtLikes.setForeground(Color.decode("#000000"));

			// Bordes
			panelInformacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),
					"MI PERFIL", TitledBorder.CENTER, TitledBorder.TOP, new Font("Cooper Black", Font.ITALIC, 15)));
			lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			// Botones
			btnback.setForeground(Color.decode("#EB5F5B"));
			btnback.setBackground(Color.decode("#F9CFCE"));
			btnclose.setForeground(Color.decode("#EB5F5B"));
			btnclose.setBackground(Color.decode("#F9CFCE"));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			panelInformacion.setBackground(Color.decode("#1E1724"));
			panelOpcion.setBackground(Color.decode("#1E1724"));
			panelLike.setBackground(Color.decode("#1E1724"));

			lBosTinder.setForeground(Color.decode("#FF2B91"));
			option.setForeground(Color.decode("#FF7171"));
			lblLike.setForeground(Color.decode("#FF7171"));

			// Labels del panelInformacion
			lblAlias.setForeground(Color.decode("#DCC8EF"));
			lblNombre.setForeground(Color.decode("#DCC8EF"));
			lblApellido.setForeground(Color.decode("#DCC8EF"));
			lblEdad.setForeground(Color.decode("#DCC8EF"));
			lblCorreo.setForeground(Color.decode("#DCC8EF"));
			lblIngresos.setForeground(Color.decode("#DCC8EF"));

			// Campos de texto
			txtAlias.setBackground(Color.decode("#2A1F3A"));
			txtAlias.setForeground(Color.decode("#DCC8EF"));
			txtNombre.setBackground(Color.decode("#2A1F3A"));
			txtNombre.setForeground(Color.decode("#DCC8EF"));
			txtApellido.setBackground(Color.decode("#2A1F3A"));
			txtApellido.setForeground(Color.decode("#DCC8EF"));
			txtEdad.setBackground(Color.decode("#2A1F3A"));
			txtEdad.setForeground(Color.decode("#DCC8EF"));
			txtCorreo.setBackground(Color.decode("#2A1F3A"));
			txtCorreo.setForeground(Color.decode("#DCC8EF"));
			txtIngresos.setBackground(Color.decode("#2A1F3A"));
			txtIngresos.setForeground(Color.decode("#DCC8EF"));
			txtLikes.setBackground(Color.decode("#2A1F3A"));
			txtLikes.setForeground(Color.decode("#DCC8EF"));

			// Bordes
			panelInformacion.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.decode("#DCC8EF")), "MI PERFIL", TitledBorder.CENTER,
					TitledBorder.TOP, new Font("Cooper Black", Font.ITALIC, 15)));
			lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.decode("#DCC8EF")));

			// Botones
			btnback.setForeground(Color.decode("#DCC8EF"));
			btnback.setBackground(Color.decode("#52247C"));
			btnclose.setForeground(Color.decode("#DCC8EF"));
			btnclose.setBackground(Color.decode("#52247C"));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}
	}

	/**
	 * Aplica los textos traducidos a los componentes de la ventana según las
	 * propiedades dadas.
	 * 
	 * @param prop Propiedades que contienen los textos traducidos por el idioma.
	 * @pre Las propiedades deben estar correctamente cargadas.
	 * @post Los textos de los botones y etiquetas se actualizan con los valores
	 *       traducidos.
	 */
	public void aplicarInternacionalizacion(Properties prop) {

		setTitle(prop.getProperty("bostinder.view.myprofilewindow.title"));
		((TitledBorder) panelInformacion.getBorder())
				.setTitle(prop.getProperty("bostinder.view.myprofilewindow.panel.perfil"));

		lblAlias.setText(prop.getProperty("bostinder.view.myprofilewindow.label.alias"));
		lblNombre.setText(prop.getProperty("bostinder.view.myprofilewindow.label.nombre"));
		lblApellido.setText(prop.getProperty("bostinder.view.myprofilewindow.label.apellido"));
		lblEdad.setText(prop.getProperty("bostinder.view.myprofilewindow.label.edad"));
		lblCorreo.setText(prop.getProperty("bostinder.view.myprofilewindow.label.correo"));
		lblIngresos.setText(prop.getProperty("bostinder.view.myprofilewindow.label.ingresos"));

		option.setText(prop.getProperty("bostinder.view.myprofilewindow.label.opciones"));
		btnback.setText(prop.getProperty("bostinder.view.myprofilewindow.button.volver"));
		btnclose.setText(prop.getProperty("bostinder.view.myprofilewindow.button.cerrarsesion"));
		darkMode.setText(prop.getProperty("bostinder.view.myprofilewindow.button.modooscuro"));

		lblLike.setText(prop.getProperty("bostinder.view.myprofilewindow.label.likesperfil"));
	}

	/**
	 * @return Panel de opciones.
	 */

	public JPanel getPanelOpcion() {
		return panelOpcion;
	}

	/**
	 * @param panelOpcion Panel de opciones.
	 */
	public void setPanelOpcion(JPanel panelOpcion) {
		this.panelOpcion = panelOpcion;
	}

	/**
	 * @return Panel de likes.
	 */
	public JPanel getPanelLike() {
		return panelLike;
	}

	/**
	 * @param panelLike Panel de likes.
	 */
	public void setPanelLike(JPanel panelLike) {
		this.panelLike = panelLike;
	}

	/**
	 * @return Etiqueta del icono.
	 */
	public JLabel getIcon() {
		return icon;
	}

	/**
	 * @param icon Etiqueta del icono.
	 */
	public void setIcon(JLabel icon) {
		this.icon = icon;
	}

	/**
	 * @return Etiqueta de likes.
	 */
	public JLabel getLblLike() {
		return lblLike;
	}

	/**
	 * @param lblLike Etiqueta de likes.
	 */
	public void setLblLike(JLabel lblLike) {
		this.lblLike = lblLike;
	}

	/**
	 * @return Etiqueta de opciones.
	 */
	public JLabel getOption() {
		return option;
	}

	/**
	 * @param option Etiqueta de opciones.
	 */
	public void setOption(JLabel option) {
		this.option = option;
	}

	/**
	 * @return Etiqueta del corazón.
	 */
	public JLabel getLblHeart() {
		return lblHeart;
	}

	/**
	 * @param lblHeart Etiqueta del corazón.
	 */
	public void setLblHeart(JLabel lblHeart) {
		this.lblHeart = lblHeart;
	}

	/**
	 * @return Etiqueta de la imagen de pareja.
	 */
	public JLabel getPartner() {
		return partner;
	}

	/**
	 * @param partner Etiqueta de la imagen de pareja.
	 */
	public void setPartner(JLabel partner) {
		this.partner = partner;
	}

	/**
	 * 
	 * @return Eriqueta de la foto de perfil.
	 */
	public JLabel getLblFotoPreview() {
		return lblFotoPreview;
	}

	/**
	 * @param lblFotoPreview Etiqueta de la foto de perfil.
	 */
	public void setLblFotoPreview(JLabel lblFotoPreview) {
		this.lblFotoPreview = lblFotoPreview;
	}

	/**
	 * @return Campo de texto para el nombre.
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @param txtNombre Campo de texto para el nombre.
	 */
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * @return Campo de texto para el apellido.
	 */
	public JTextField getTxtApellido() {
		return txtApellido;
	}

	/**
	 * @param txtApellido Campo de texto para el apellido.
	 */
	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	/**
	 * @return Campo de texto para la edad.
	 */
	public JTextField getTxtEdad() {
		return txtEdad;
	}

	/**
	 * @param txtEdad Campo de texto para la edad.
	 */
	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	/**
	 * @return Campo de texto para el correo.
	 */
	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	/**
	 * @param txtCorreo Campo de texto para el correo.
	 */
	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	/**
	 * @return Campo de texto para el alias.
	 */
	public JTextField getTxtAlias() {
		return txtAlias;
	}

	/**
	 * @param txtAlias Campo de texto para el alias.
	 */
	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	/**
	 * @return Campo de texto para los likes.
	 */
	public JTextField getTxtLikes() {
		return txtLikes;
	}

	/**
	 * @param txtLikes Campo de texto para los likes.
	 */
	public void setTxtLikes(JTextField txtLikes) {
		this.txtLikes = txtLikes;
	}

	/**
	 * @return Campo de texto para los ingresos.
	 */
	public JTextField getTxtIngresos() {
		return txtIngresos;
	}

	/*
	 * @param txtIngresos Campo de texto para los ingresos.
	 */
	public void setTxtIngresos(JTextField txtIngresos) {
		this.txtIngresos = txtIngresos;
	}

	/**
	 * @return Panel de información del perfil.
	 */
	public JPanel getPanelInformacion() {
		return panelInformacion;
	}

	/**
	 * @param panelInformacion Panel de información del perfil.
	 */
	public void setPanelInformacion(JPanel panelInformacion) {
		this.panelInformacion = panelInformacion;
	}

	/**
	 * @return Panel del logo.
	 */
	public JPanel getPanelLogo() {
		return panelLogo;
	}

	/**
	 * @param panelLogo Panel del logo.
	 */
	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
	}

	/**
	 * @return Botón para cambiar el aspecto.
	 */
	public JButton getDarkMode() {
		return darkMode;
	}

	/**
	 * @param darkMode Botón para cambiar el aspecto.
	 */
	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}

	/**
	 * @return Estado actual del modo oscuro.
	 */
	public boolean isDarkMode() {
		return isDarkMode;
	}

	/**
	 * @param isDarkMode Estado del modo oscuro a establecer.
	 */
	public void setDarkMode(boolean isDarkMode) {
		this.isDarkMode = isDarkMode;
	}
	/**
	 * @return Etiqueta del título BosTinder.
	 */
	public JLabel getlBosTinder() {
		return lBosTinder;
	}
	/**
	 * @param lBosTinder Etiqueta del título BosTinder.
	 */
	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}
	/**
	 * @param lBosTinder Etiqueta del título BosTinder.
	 */
	public JLabel getLblAlias() {
		return lblAlias;
	}
	/**
	 * @return Etiqueta del alias.
	 */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}
	/**
	 * @param lblAlias Etiqueta del alias.
	 */
	public JLabel getLblNombre() {
		return lblNombre;
	}
	/**
	 * @return Etiqueta del nombre.
	 */
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}
	/**
	 * @param lblNombre Etiqueta del nombre.
	 */
	public JLabel getLblApellido() {
		return lblApellido;
	}
	/**
	 * @return Etiqueta del apellido.
	 */
	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}
	/**
	 * @return Etiqueta de la edad.
	 */
	public JLabel getLblEdad() {
		return lblEdad;
	}
	/**
	 * @param lblEdad Etiqueta de la edad.
	 */
	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}
	/**
	 * @return Etiqueta del correo.
	 */
	public JLabel getLblCorreo() {
		return lblCorreo;
	}
	/**
	 * @param lblCorreo Etiqueta del correo.
	 */
	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}
	/**
	 * @return Etiqueta de los ingresos.
	 */
	public JLabel getLblIngresos() {
		return lblIngresos;
	}
	/**
	 * @param lblIngresos Etiqueta de los ingresos.
	 */
	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}
	/**
	 * @return Botón para volver.
	 */
	public JButton getBtnback() {
		return btnback;
	}
	/**
	 * @param btnback Botón para volver.
	 */
	public void setBtnback(JButton btnback) {
		this.btnback = btnback;
	}
	/**
	 * @return Botón para cerrar sesión.
	 */
	public JButton getBtnclose() {
		return btnclose;
	}
	/**
	 * @param btnclose Botón para cerrar sesión.
	 */
	public void setBtnclose(JButton btnclose) {
		this.btnclose = btnclose;
	}

}