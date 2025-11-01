package co.edu.unbosque.view;

import java.awt.*;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AdminWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTable tablaUsuarios;
	private JTextField txtBuscar;
	private JTextField txtNombre, txtApellido, txtEdad, txtCorreo, txtAlias, txtLikes, txtIngresos;
	private JLabel lblFotoPreview;

	private JButton btnBuscar, btnMostrarTodos, btnOrdenAsc, btnOrdenDesc, btnDarBaja, 
			btnGenerarPDF, btnSalirModoAdmin, 
			btnFiltroTop10, btnFiltroIngresos, btnFiltroGenero;
	private JComboBox<String> cmbOrden, cmbGeneroFiltro;
	private JTextArea txtEstadisticas;

	public AdminWindow() {
		initializeComponents();
		setVisible(false);
	}
	public void initializeComponents() {
		setTitle("Panel de Administración - BosTinder");
		setBounds(230, 5, 1100, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(Color.decode("#F5E6E8"));
		getContentPane().setLayout(null);

		JLabel lblHeader = new JLabel(new ImageIcon(getClass().getResource("/co/edu/unbosque/view/iconAdmin.JPG")));
		lblHeader.setBounds(10, 10, 1060, 100);
		getContentPane().add(lblHeader);

		JLabel lblBuscar = new JLabel("Buscar usuario (alias o correo):");
		lblBuscar.setBounds(30, 120, 250, 25);
		lblBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(250, 120, 200, 25);
		getContentPane().add(txtBuscar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(470, 120, 100, 25);
		getContentPane().add(btnBuscar);

		btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.setBounds(580, 120, 140, 25);
		getContentPane().add(btnMostrarTodos);

		String[] columnas = { "Alias", "Nombre", "Apellido", "Edad", "Likes", "Ingresos (USD)", "Género" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		tablaUsuarios = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tablaUsuarios);
		scroll.setBounds(30, 160, 690, 300);
		getContentPane().add(scroll);

		JPanel pnlDetalles = new JPanel();
		pnlDetalles.setLayout(null);
		pnlDetalles.setBounds(740, 121, 330, 360);
		pnlDetalles.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),
				"Detalle de Usuario", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12)));
		pnlDetalles.setBackground(Color.WHITE);
		getContentPane().add(pnlDetalles);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 30, 100, 20);
		pnlDetalles.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(120, 30, 180, 20);
		txtNombre.setEditable(false);
		pnlDetalles.add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 60, 100, 20);
		pnlDetalles.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(120, 60, 180, 20);
		txtApellido.setEditable(false);
		pnlDetalles.add(txtApellido);

		JLabel lblAlias = new JLabel("Alias:");
		lblAlias.setBounds(20, 90, 100, 20);
		pnlDetalles.add(lblAlias);

		txtAlias = new JTextField();
		txtAlias.setBounds(120, 90, 180, 20);
		txtAlias.setEditable(false);
		pnlDetalles.add(txtAlias);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 120, 100, 20);
		pnlDetalles.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(120, 120, 180, 20);
		txtEdad.setEditable(false);
		pnlDetalles.add(txtEdad);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(20, 150, 100, 20);
		pnlDetalles.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(120, 150, 180, 20);
		txtCorreo.setEditable(false);
		pnlDetalles.add(txtCorreo);

		JLabel lblLikes = new JLabel("Likes:");
		lblLikes.setBounds(20, 180, 100, 20);
		pnlDetalles.add(lblLikes);

		txtLikes = new JTextField();
		txtLikes.setBounds(120, 180, 180, 20);
		txtLikes.setEditable(false);
		pnlDetalles.add(txtLikes);

		JLabel lblIngresos = new JLabel("Ingresos (USD):");
		lblIngresos.setBounds(20, 210, 100, 20);
		pnlDetalles.add(lblIngresos);

		txtIngresos = new JTextField();
		txtIngresos.setBounds(120, 210, 180, 20);
		txtIngresos.setEditable(false);
		pnlDetalles.add(txtIngresos);

		JLabel lblFoto = new JLabel("Foto:");
		lblFoto.setBounds(20, 240, 100, 20);
		pnlDetalles.add(lblFoto);

		lblFotoPreview = new JLabel();
		lblFotoPreview.setBounds(120, 240, 100, 100);
		lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		pnlDetalles.add(lblFotoPreview);

		JLabel lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(30, 480, 100, 25);
		lblOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(lblOrdenar);

		String[] criterios = { "Likes", "Apellido", "Nombre", "Edad", "Alias" };
		cmbOrden = new JComboBox<>(criterios);
		cmbOrden.setBounds(130, 480, 120, 25);
		getContentPane().add(cmbOrden);

		btnOrdenAsc = new JButton("Ascendente ↑");
		btnOrdenAsc.setBounds(270, 480, 140, 25);
		getContentPane().add(btnOrdenAsc);

		btnOrdenDesc = new JButton("Descendente ↓");
		btnOrdenDesc.setBounds(420, 480, 150, 25);
		getContentPane().add(btnOrdenDesc);

		btnDarBaja = new JButton("Dar de baja");
		btnDarBaja.setBounds(600, 480, 120, 25);
		btnDarBaja.setForeground(Color.RED);
		getContentPane().add(btnDarBaja);

		btnGenerarPDF = new JButton("Generar Informe PDF");
		btnGenerarPDF.setBounds(740, 480, 200, 25);
		btnGenerarPDF.setBackground(Color.decode("#D5E8D4"));
		getContentPane().add(btnGenerarPDF);

		JLabel lblFiltros = new JLabel("Filtros rápidos:");
		lblFiltros.setBounds(30, 520, 100, 25);
		lblFiltros.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(lblFiltros);

		btnFiltroTop10 = new JButton("Top 10 Likes");
		btnFiltroTop10.setBounds(130, 520, 130, 25);
		getContentPane().add(btnFiltroTop10);

		btnFiltroIngresos = new JButton("Ingresos ≥ 244.85 USD");
		btnFiltroIngresos.setBounds(270, 520, 200, 25);
		getContentPane().add(btnFiltroIngresos);

		btnFiltroGenero = new JButton("Filtrar por género");
		btnFiltroGenero.setBounds(480, 520, 150, 25);
		getContentPane().add(btnFiltroGenero);

		cmbGeneroFiltro = new JComboBox<>(new String[] {"Todos", "Masculino", "Femenino", "Otro"});
		cmbGeneroFiltro.setBounds(640, 520, 120, 25);
		getContentPane().add(cmbGeneroFiltro);

		txtEstadisticas = new JTextArea("Al generar el PDF, se calcularán las estadísticas de los usuarios actuales.");
		txtEstadisticas.setBounds(30, 560, 1010, 60);
		txtEstadisticas.setEditable(false);
		txtEstadisticas.setBackground(Color.WHITE);
		txtEstadisticas.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		getContentPane().add(txtEstadisticas);

		btnSalirModoAdmin = new JButton("Salir de modo administrador");
		btnSalirModoAdmin.setBounds(890, 640, 180, 35);
		btnSalirModoAdmin.setBackground(Color.decode("#F9CFCE"));
		getContentPane().add(btnSalirModoAdmin);
	}
	
	
	public void aplicarInternacionalizacion (Properties prop) {
		// 🔹 Título de la ventana
	    setTitle(prop.getProperty("bostinder.view.adminwindow.title"));

	    // 🔹 Labels principales
	    // Se asume que en el archivo .properties están definidas las claves correspondientes.
	    ((TitledBorder)((JPanel)getContentPane().getComponent(4)).getBorder())
	        .setTitle(prop.getProperty("bostinder.view.adminwindow.panel.detalleusuario"));

	    // 🔹 Etiquetas del panel de detalles
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(0))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.nombre"));
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(2))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.apellido"));
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(4))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.alias"));
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(6))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.edad"));
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(8))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.correo"));
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(10))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.likes"));
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(12))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.ingresos"));
	    ((JLabel)((JPanel)getContentPane().getComponent(4)).getComponent(14))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.foto"));

	    // 🔹 Botones principales
	    btnBuscar.setText(prop.getProperty("bostinder.view.adminwindow.button.buscar"));
	    btnMostrarTodos.setText(prop.getProperty("bostinder.view.adminwindow.button.mostrartodos"));
	    btnOrdenAsc.setText(prop.getProperty("bostinder.view.adminwindow.button.ascendente"));
	    btnOrdenDesc.setText(prop.getProperty("bostinder.view.adminwindow.button.descendente"));
	    btnDarBaja.setText(prop.getProperty("bostinder.view.adminwindow.button.darbaja"));
	    btnGenerarPDF.setText(prop.getProperty("bostinder.view.adminwindow.button.generarpdf"));
	    btnSalirModoAdmin.setText(prop.getProperty("bostinder.view.adminwindow.button.salirmodoadmin"));
	    btnFiltroTop10.setText(prop.getProperty("bostinder.view.adminwindow.button.filtrotop10"));
	    btnFiltroIngresos.setText(prop.getProperty("bostinder.view.adminwindow.button.filtroingresos"));
	    btnFiltroGenero.setText(prop.getProperty("bostinder.view.adminwindow.button.filtrogenero"));

	    // 🔹 Labels externos
	    ((JLabel)getContentPane().getComponent(2))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.buscar"));
	    ((JLabel)getContentPane().getComponent(15))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.ordenar"));
	    ((JLabel)getContentPane().getComponent(21))
	        .setText(prop.getProperty("bostinder.view.adminwindow.label.filtros"));

	    // 🔹 ComboBoxes
	    cmbOrden.removeAllItems();
	    cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.likes"));
	    cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.apellido"));
	    cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.nombre"));
	    cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.edad"));
	    cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.alias"));

	    cmbGeneroFiltro.removeAllItems();
	    cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.todos"));
	    cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.masculino"));
	    cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.femenino"));
	    cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.otro"));

	    // 🔹 Texto de estadísticas
	    txtEstadisticas.setText(prop.getProperty("bostinder.view.adminwindow.text.estadisticas"));
	}
	
	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	public void setTablaUsuarios(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}

	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
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

	public JLabel getLblFotoPreview() {
		return lblFotoPreview;
	}

	public void setLblFotoPreview(JLabel lblFotoPreview) {
		this.lblFotoPreview = lblFotoPreview;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnMostrarTodos() {
		return btnMostrarTodos;
	}

	public void setBtnMostrarTodos(JButton btnMostrarTodos) {
		this.btnMostrarTodos = btnMostrarTodos;
	}

	public JButton getBtnOrdenAsc() {
		return btnOrdenAsc;
	}

	public void setBtnOrdenAsc(JButton btnOrdenAsc) {
		this.btnOrdenAsc = btnOrdenAsc;
	}

	public JButton getBtnOrdenDesc() {
		return btnOrdenDesc;
	}

	public void setBtnOrdenDesc(JButton btnOrdenDesc) {
		this.btnOrdenDesc = btnOrdenDesc;
	}

	public JButton getBtnDarBaja() {
		return btnDarBaja;
	}

	public void setBtnDarBaja(JButton btnDarBaja) {
		this.btnDarBaja = btnDarBaja;
	}

	public JButton getBtnGenerarPDF() {
		return btnGenerarPDF;
	}

	public void setBtnGenerarPDF(JButton btnGenerarPDF) {
		this.btnGenerarPDF = btnGenerarPDF;
	}

	public JButton getBtnSalirModoAdmin() {
		return btnSalirModoAdmin;
	}

	public void setBtnSalirModoAdmin(JButton btnSalirModoAdmin) {
		this.btnSalirModoAdmin = btnSalirModoAdmin;
	}

	public JButton getBtnFiltroTop10() {
		return btnFiltroTop10;
	}

	public void setBtnFiltroTop10(JButton btnFiltroTop10) {
		this.btnFiltroTop10 = btnFiltroTop10;
	}

	public JButton getBtnFiltroIngresos() {
		return btnFiltroIngresos;
	}

	public void setBtnFiltroIngresos(JButton btnFiltroIngresos) {
		this.btnFiltroIngresos = btnFiltroIngresos;
	}

	public JButton getBtnFiltroGenero() {
		return btnFiltroGenero;
	}

	public void setBtnFiltroGenero(JButton btnFiltroGenero) {
		this.btnFiltroGenero = btnFiltroGenero;
	}

	public JComboBox<String> getCmbOrden() {
		return cmbOrden;
	}

	public void setCmbOrden(JComboBox<String> cmbOrden) {
		this.cmbOrden = cmbOrden;
	}

	public JComboBox<String> getCmbGeneroFiltro() {
		return cmbGeneroFiltro;
	}

	public void setCmbGeneroFiltro(JComboBox<String> cmbGeneroFiltro) {
		this.cmbGeneroFiltro = cmbGeneroFiltro;
	}

	public JTextArea getTxtEstadisticas() {
		return txtEstadisticas;
	}

	public void setTxtEstadisticas(JTextArea txtEstadisticas) {
		this.txtEstadisticas = txtEstadisticas;
	}
	
	
}
