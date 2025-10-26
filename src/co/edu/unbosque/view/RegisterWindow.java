package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegisterWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lIcon;
	private JLabel lImage;
	private JLabel lFotoPreview;
	private JLabel lAreaDeRegistro;
	private JLabel lNombres;
	private JLabel lApellidos;
	private JLabel lApodo;
	private JLabel lCorreo;
	private JLabel lGenero;
	private JLabel lOrientacion;
	private JLabel lEstatura;
	private JLabel lIngresos;
	private JLabel lDivorcios;
	private JLabel lFechaNacimiento;
	private JLabel lPais;
	private JLabel lPassword;

	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtApodo;
	private JTextField txtCorreo;
	private JTextField txtEstatura;
	private JTextField txtIngresos;
	private JTextField txtFechaNacimiento;
	private JTextField txtPassword;

	private JComboBox<String> cmbGenero;
	private JComboBox<String> cmbOrientacion;
	private JComboBox<String> cmbDivorcios;
	private JComboBox<String> cmbPais;

	private JButton btnSubirFoto;
	private JButton btnVerificarCorreo;
	private JButton btnRegistrar;
	private JButton btnVolver;

	public RegisterWindow() {
		initializeComponents();
		setVisible(false);
	}

	public void initializeComponents() {

		// CONFIGURACIÓN GENERAL DE LA VENTANA
		this.setTitle("Registro de usuario");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));

		// ---------- IMAGEN SUPERIOR ----------
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconStart.JPG"));
		lIcon = new JLabel(imageLogo);
		lIcon.setBounds(0, 0, 980, 150);
		add(lIcon);

		// ----------IMAGEN ADICIONAL -----------
		ImageIcon imagePenguin = new ImageIcon(getClass().getResource("penguin.JPG"));
		lImage = new JLabel(imagePenguin);
		lImage.setBounds(650, 247, 300, 300);
		add(lImage);

		// ---------- TÍTULO ----------
		lAreaDeRegistro = new JLabel("¡Regístrate y encuentra el amor!");
		lAreaDeRegistro.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lAreaDeRegistro.setBounds(350, 174, 549, 58);
		add(lAreaDeRegistro);

		// ---------- PANEL DE FORMULARIO ----------
		JPanel panelForm = new JPanel();
		panelForm.setLayout(null);
		panelForm.setBounds(20, 250, 920, 400);
		panelForm.setBackground(Color.decode("#FFFFFF"));
		add(panelForm);

		// ---------- CAMPOS DE TEXTO ----------
		lNombres = new JLabel("Nombre/s");
		lNombres.setBounds(30, 20, 150, 20);
		panelForm.add(lNombres);

		txtNombres = new JTextField();
		txtNombres.setBounds(30, 45, 164, 20);
		panelForm.add(txtNombres);

		lApellidos = new JLabel("Apellidos");
		lApellidos.setBounds(30, 75, 150, 20);
		panelForm.add(lApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(30, 100, 164, 20);
		panelForm.add(txtApellidos);

		lApodo = new JLabel("Apodo");
		lApodo.setBounds(30, 130, 150, 20);
		panelForm.add(lApodo);

		txtApodo = new JTextField();
		txtApodo.setBounds(30, 155, 164, 20);
		panelForm.add(txtApodo);

		lFechaNacimiento = new JLabel("Fecha de nacimiento (DD/MM/AAAA)");
		lFechaNacimiento.setBounds(30, 185, 250, 20);
		panelForm.add(lFechaNacimiento);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(30, 210, 164, 20);
		panelForm.add(txtFechaNacimiento);

		lCorreo = new JLabel("Correo electrónico:");
		lCorreo.setBounds(30, 240, 150, 20);
		panelForm.add(lCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(30, 265, 164, 20);
		panelForm.add(txtCorreo);

		btnVerificarCorreo = new JButton("Verificar correo");
		btnVerificarCorreo.setBounds(30, 295, 150, 30);
		btnVerificarCorreo.setBackground(Color.decode("#F9CFCE"));
		btnVerificarCorreo.setFocusPainted(false);
		btnVerificarCorreo.setBorderPainted(false);
		panelForm.add(btnVerificarCorreo);

		lPassword = new JLabel("Contraseña");
		lPassword.setBounds(250, 20, 164, 20);
		panelForm.add(lPassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(250, 45, 164, 20);
		panelForm.add(txtPassword);

		// ---------- CAMPOS DE SELECCIÓN ----------
		lPais = new JLabel("Pais de residencia:");
		lPais.setBounds(250, 75, 150, 20);
		panelForm.add(lPais);

		cmbPais = new JComboBox<>(new String[] { "...", "Angola", "Argentina", "Brasil", "Colombia", "España", "Irael",
				"Kazajistan", "Macao", "Mexico", "Portugal", "Rusia", "Singapur", "Taiwan" });
		cmbPais.setBounds(250, 100, 150, 20);
		panelForm.add(cmbPais);

		lGenero = new JLabel("Selecciona tu género:");
		lGenero.setBounds(250, 130, 150, 20);
		panelForm.add(lGenero);

		cmbGenero = new JComboBox<>(new String[] { "...", "Masculino", "Femenino" });
		cmbGenero.setBounds(250, 155, 150, 22);
		panelForm.add(cmbGenero);

		lEstatura = new JLabel("Estatura (cm):");
		lEstatura.setBounds(250, 185, 150, 20);
		lEstatura.setVisible(false);
		panelForm.add(lEstatura);

		txtEstatura = new JTextField();
		txtEstatura.setBounds(250, 210, 150, 20);
		txtEstatura.setVisible(false);
		panelForm.add(txtEstatura);

		lOrientacion = new JLabel("Orientación sexual:");
		lOrientacion.setBounds(250, 240, 150, 20);
		lOrientacion.setVisible(false);
		panelForm.add(lOrientacion);

		cmbOrientacion = new JComboBox<>(new String[] { "...", "Heterosexual", "Homosexual", "Bisexual", "Asexual" });
		cmbOrientacion.setBounds(250, 265, 150, 20);
		cmbOrientacion.setVisible(false);
		panelForm.add(cmbOrientacion);

		lIngresos = new JLabel("Ingresos mensuales:");
		lIngresos.setBounds(250, 295, 150, 20);
		lIngresos.setVisible(false);
		panelForm.add(lIngresos);

		txtIngresos = new JTextField();
		txtIngresos.setBounds(250, 330, 150, 20);
		txtIngresos.setVisible(false);
		panelForm.add(txtIngresos);

		lDivorcios = new JLabel("¿Ha tenido divorcios?");
		lDivorcios.setBounds(250, 295, 340, 20);
		lDivorcios.setVisible(false);
		panelForm.add(lDivorcios);

		cmbDivorcios = new JComboBox<>(new String[] { "...", "Sí", "No" });
		cmbDivorcios.setBounds(250, 330, 150, 20);
		cmbDivorcios.setVisible(false);
		panelForm.add(cmbDivorcios);

		// ---------- SUBIR FOTO ----------
		JLabel lFoto = new JLabel("Foto de perfil (.png):");
		lFoto.setBounds(470, 20, 176, 20);
		panelForm.add(lFoto);

		btnSubirFoto = new JButton("Subir foto");
		btnSubirFoto.setBounds(470, 45, 124, 30);
		btnSubirFoto.setBackground(Color.decode("#F9CFCE"));
		btnSubirFoto.setFocusPainted(false);
		btnSubirFoto.setBorderPainted(false);
		panelForm.add(btnSubirFoto);

		lFotoPreview = new JLabel();
		lFotoPreview.setBounds(470, 90, 150, 150);
		lFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelForm.add(lFotoPreview);

		// ---------- BOTONES ----------
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(755, 320, 120, 40);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBackground(Color.decode("#F9CFCE"));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBorderPainted(false);
		panelForm.add(btnRegistrar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(660, 320, 90, 40);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
		btnVolver.setBackground(Color.decode("#F9CFCE"));
		btnVolver.setFocusPainted(false);
		btnVolver.setBorderPainted(false);
		panelForm.add(btnVolver);

	}

	// ---------- GETTERS Y SETTERSS ----------

	public JLabel getlIcon() {
		return lIcon;
	}

	public void setlIcon(JLabel lIcon) {
		this.lIcon = lIcon;
	}

	public JLabel getlFotoPreview() {
		return lFotoPreview;
	}

	public void setlFotoPreview(JLabel lFotoPreview) {
		this.lFotoPreview = lFotoPreview;
	}

	public JLabel getlAreaDeRegistro() {
		return lAreaDeRegistro;
	}

	public void setlAreaDeRegistro(JLabel lAreaDeRegistro) {
		this.lAreaDeRegistro = lAreaDeRegistro;
	}

	public JLabel getlNombres() {
		return lNombres;
	}

	public void setlNombres(JLabel lNombres) {
		this.lNombres = lNombres;
	}

	public JLabel getlApellidos() {
		return lApellidos;
	}

	public void setlApellidos(JLabel lApellidos) {
		this.lApellidos = lApellidos;
	}

	public JLabel getlApodo() {
		return lApodo;
	}

	public void setlApodo(JLabel lApodo) {
		this.lApodo = lApodo;
	}

	public JLabel getlCorreo() {
		return lCorreo;
	}

	public void setlCorreo(JLabel lCorreo) {
		this.lCorreo = lCorreo;
	}

	public JLabel getlGenero() {
		return lGenero;
	}

	public void setlGenero(JLabel lGenero) {
		this.lGenero = lGenero;
	}

	public JLabel getlOrientacion() {
		return lOrientacion;
	}

	public void setlOrientacion(JLabel lOrientacion) {
		this.lOrientacion = lOrientacion;
	}

	public JLabel getlEstatura() {
		return lEstatura;
	}

	public void setlEstatura(JLabel lEstatura) {
		this.lEstatura = lEstatura;
	}

	public JLabel getlIngresos() {
		return lIngresos;
	}

	public void setlIngresos(JLabel lIngresos) {
		this.lIngresos = lIngresos;
	}

	public JLabel getlDivorcios() {
		return lDivorcios;
	}

	public void setlDivorcios(JLabel lDivorcios) {
		this.lDivorcios = lDivorcios;
	}

	public JLabel getlFechaNacimiento() {
		return lFechaNacimiento;
	}

	public void setlFechaNacimiento(JLabel lFechaNacimiento) {
		this.lFechaNacimiento = lFechaNacimiento;
	}

	public JTextField getTxtNombres() {
		return txtNombres;
	}

	public void setTxtNombres(JTextField txtNombres) {
		this.txtNombres = txtNombres;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public JTextField getTxtApodo() {
		return txtApodo;
	}

	public void setTxtApodo(JTextField txtApodo) {
		this.txtApodo = txtApodo;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtEstatura() {
		return txtEstatura;
	}

	public void setTxtEstatura(JTextField txtEstatura) {
		this.txtEstatura = txtEstatura;
	}

	public JTextField getTxtIngresos() {
		return txtIngresos;
	}

	public void setTxtIngresos(JTextField txtIngresos) {
		this.txtIngresos = txtIngresos;
	}

	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}

	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	public JComboBox<String> getCmbOrientacion() {
		return cmbOrientacion;
	}

	public void setCmbOrientacion(JComboBox<String> cmbOrientacion) {
		this.cmbOrientacion = cmbOrientacion;
	}

	public JComboBox<String> getCmbDivorcios() {
		return cmbDivorcios;
	}

	public void setCmbDivorcios(JComboBox<String> cmbDivorcios) {
		this.cmbDivorcios = cmbDivorcios;
	}

	public JButton getBtnSubirFoto() {
		return btnSubirFoto;
	}

	public void setBtnSubirFoto(JButton btnSubirFoto) {
		this.btnSubirFoto = btnSubirFoto;
	}

	public JButton getBtnVerificarCorreo() {
		return btnVerificarCorreo;
	}

	public void setBtnVerificarCorreo(JButton btnVerificarCorreo) {
		this.btnVerificarCorreo = btnVerificarCorreo;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JLabel getlImage() {
		return lImage;
	}

	public void setlImage(JLabel lImage) {
		this.lImage = lImage;
	}

	public JLabel getlPais() {
		return lPais;
	}

	public void setlPais(JLabel lPais) {
		this.lPais = lPais;
	}

	public JLabel getlPassword() {
		return lPassword;
	}

	public void setlPassword(JLabel lPassword) {
		this.lPassword = lPassword;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JComboBox<String> getCmbPais() {
		return cmbPais;
	}

	public void setCmbPais(JComboBox<String> cmbPais) {
		this.cmbPais = cmbPais;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}
