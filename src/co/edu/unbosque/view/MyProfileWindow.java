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

	private JPanel panelOpcion;
	private JPanel panelLike;
	private JPanel panelInformacion;

	private JButton back;
	private JButton close;

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

		JLabel icon = new JLabel("");
		icon.setForeground(Color.decode("#F9CFCE"));
		icon.setBackground(Color.decode("#F9CFCE"));
		icon.setIcon(new ImageIcon(MainWindow.class.getResource("/co/edu/unbosque/view/iconStart.JPG")));
		icon.setBounds(0, 0, 980, 150);
		getContentPane().add(icon);

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

}
