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

public class MyProfileWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6565373921781216469L;
	private JPanel panelOpcion;
	private JPanel panelLike;
	private JPanel panelInformacion;
	private JPanel panelLogo;

	private JButton back;
	private JButton close;
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


		ImageIcon image = new ImageIcon(getClass().getResource("partnerFive.JPG"));
		partner = new JLabel(image);
		partner.setBounds(20, 195, 300, 450);
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

		back = new JButton("VOLVER");
		back.setBounds(80, 45, 94, 40);
		back.setFont(new Font("Arial", Font.BOLD, 12));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOpcion.add(back);

		back = new JButton("CERRAR SESIÓN");
		back.setBounds(64, 95, 130, 40);
		back.setFont(new Font("Arial", Font.BOLD, 12));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOpcion.add(back);

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(800, 10, 150, 30);
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
	
	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
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
	        back.setForeground(Color.decode("#EB5F5B"));
	        back.setBackground(Color.decode("#F9CFCE"));
	        close.setForeground(Color.decode("#EB5F5B"));
	        close.setBackground(Color.decode("#F9CFCE"));

	        // Botón darkMode
	        darkMode.setBackground(Color.decode("#EB5F5B"));
	        darkMode.setForeground(Color.decode("#F9CFCE"));
	        darkMode.setText("MODO OSCURO");
	        isDarkMode = false;

	    } else {
	        // Cambia a modo oscuro
	    	 panelLogo.setBackground(Color.decode("#2D2D2D"));
	         panelInformacion.setBackground(Color.decode("#2D2D2D"));
	         panelOpcion.setBackground(Color.decode("#2D2D2D"));
	         panelLike.setBackground(Color.decode("#2D2D2D"));
	         
	         lBosTinder.setForeground(Color.decode("#F9CFCE"));
	         option.setForeground(Color.decode("#F9CFCE"));
	         lblLike.setForeground(Color.decode("#F9CFCE"));

	         // Labels del panelInformacion
	         lblAlias.setForeground(Color.decode("#F9CFCE"));
	         lblNombre.setForeground(Color.decode("#F9CFCE"));
	         lblApellido.setForeground(Color.decode("#F9CFCE"));
	         lblEdad.setForeground(Color.decode("#F9CFCE"));
	         lblCorreo.setForeground(Color.decode("#F9CFCE"));
	         lblIngresos.setForeground(Color.decode("#F9CFCE"));

	         // Campos de texto
	         txtAlias.setBackground(Color.decode("#1E1E1E"));
	         txtAlias.setForeground(Color.decode("#FFFFFF"));
	         txtNombre.setBackground(Color.decode("#1E1E1E"));
	         txtNombre.setForeground(Color.decode("#FFFFFF"));
	         txtApellido.setBackground(Color.decode("#1E1E1E"));
	         txtApellido.setForeground(Color.decode("#FFFFFF"));
	         txtEdad.setBackground(Color.decode("#1E1E1E"));
	         txtEdad.setForeground(Color.decode("#FFFFFF"));
	         txtCorreo.setBackground(Color.decode("#1E1E1E"));
	         txtCorreo.setForeground(Color.decode("#FFFFFF"));
	         txtIngresos.setBackground(Color.decode("#1E1E1E"));
	         txtIngresos.setForeground(Color.decode("#FFFFFF"));
	         txtLikes.setBackground(Color.decode("#1E1E1E"));
	         txtLikes.setForeground(Color.decode("#FFFFFF"));

	         // Bordes
	         panelInformacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
	                 "MI PERFIL", TitledBorder.CENTER, TitledBorder.TOP, new Font("Cooper Black", Font.ITALIC, 15)));
	         lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.WHITE));

	         // Botones
	         back.setForeground(Color.decode("#F9CFCE"));
	         back.setBackground(Color.decode("#BA1750"));
	         close.setForeground(Color.decode("#F9CFCE"));
	         close.setBackground(Color.decode("#BA1750"));

	         // Botón darkMode
	         darkMode.setBackground(Color.decode("#BA1750"));
	         darkMode.setForeground(Color.decode("#FFFFFF"));
	         darkMode.setText("MODO CLARO");
	         isDarkMode = true;
	    }
	}

	public void aplicarInternacionalizacion(Properties prop) {
		// Título de la ventana
		setTitle(prop.getProperty("bostinder.view.myprofilewindow.title"));

		((TitledBorder) panelInformacion.getBorder())
				.setTitle(prop.getProperty("bostinder.view.myprofilewindow.panel.perfil"));

		// Labels dentro del panel de información
		lblAlias.setText(prop.getProperty("bostinder.view.myprofilewindow.label.alias"));
		lblNombre.setText(prop.getProperty("bostinder.view.myprofilewindow.label.nombre"));
		lblApellido.setText(prop.getProperty("bostinder.view.myprofilewindow.label.apellido"));
		lblEdad.setText(prop.getProperty("bostinder.view.myprofilewindow.label.edad"));
		lblCorreo.setText(prop.getProperty("bostinder.view.myprofilewindow.label.correo"));
		lblIngresos.setText(prop.getProperty("bostinder.view.myprofilewindow.label.ingresos"));

		// Panel de opciones
		option.setText(prop.getProperty("bostinder.view.myprofilewindow.label.opciones"));
		back.setText(prop.getProperty("bostinder.view.myprofilewindow.button.volver"));
		//close.setText(prop.getProperty("bostinder.view.myprofilewindow.button.cerrarsesion"));

		// Panel de likes
		lblLike.setText(prop.getProperty("bostinder.view.myprofilewindow.label.likesperfil"));
	}

	public JPanel getPanelOpcion() {
		return panelOpcion;
	}

	public void setPanelOpcion(JPanel panelOpcion) {
		this.panelOpcion = panelOpcion;
	}

	public JPanel getPanelLike() {
		return panelLike;
	}

	public void setPanelLike(JPanel panelLike) {
		this.panelLike = panelLike;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JButton getClose() {
		return close;
	}

	public void setClose(JButton close) {
		this.close = close;
	}

	public JLabel getIcon() {
		return icon;
	}

	public void setIcon(JLabel icon) {
		this.icon = icon;
	}

	public JLabel getLblLike() {
		return lblLike;
	}

	public void setLblLike(JLabel lblLike) {
		this.lblLike = lblLike;
	}

	public JLabel getOption() {
		return option;
	}

	public void setOption(JLabel option) {
		this.option = option;
	}

	public JLabel getLblHeart() {
		return lblHeart;
	}

	public void setLblHeart(JLabel lblHeart) {
		this.lblHeart = lblHeart;
	}

	public JLabel getPartner() {
		return partner;
	}

	public void setPartner(JLabel partner) {
		this.partner = partner;
	}

	public JLabel getLblFotoPreview() {
		return lblFotoPreview;
	}

	public void setLblFotoPreview(JLabel lblFotoPreview) {
		this.lblFotoPreview = lblFotoPreview;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtAlias() {
		return txtAlias;
	}

	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	public JTextField getTxtLikes() {
		return txtLikes;
	}

	public void setTxtLikes(JTextField txtLikes) {
		this.txtLikes = txtLikes;
	}

	public JTextField getTxtIngresos() {
		return txtIngresos;
	}

	public void setTxtIngresos(JTextField txtIngresos) {
		this.txtIngresos = txtIngresos;
	}

	public JPanel getPanelInformacion() {
		return panelInformacion;
	}

	public void setPanelInformacion(JPanel panelInformacion) {
		this.panelInformacion = panelInformacion;
	}

	public JPanel getPanelLogo() {
		return panelLogo;
	}

	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
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

	public JLabel getlBosTinder() {
		return lBosTinder;
	}

	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}

	public JLabel getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	
}
