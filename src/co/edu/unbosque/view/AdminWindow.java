package co.edu.unbosque.view;

import java.awt.*;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AdminWindow extends JFrame {

	/**
		 * 
		 */
	private static final long serialVersionUID = -2832789673331679513L;
	private JTable tablaUsuarios;
	private JTextField txtBuscar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtCorreo;
	private JTextField txtAlias;
	private JTextField txtLikes;
	private JTextField txtIngresos;
	private JLabel lblFotoPreview;
	private JPanel pnlDetalles;
	private JLabel lblBuscar;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblAlias;
	private JLabel lblEdad;
	private JLabel lblCorreo;
	private JLabel lblLikes;
	private JLabel lblIngresos;
	private JLabel lblFoto;
	private JLabel lblOrdenar;
	private JLabel lblFiltros;
	private JLabel lBosTinder;

	private JButton btnBuscar;
	private JButton btnMostrarTodos;
	private JButton btnOrdenAsc;
	private JButton btnOrdenDesc;
	private JButton btnDarBaja;
	private JButton btnGenerarPDF;
	private JButton btnSalirModoAdmin;
	private JButton btnFiltroTop10;
	private JButton btnFiltroIngresos;
	private JButton btnFiltroGenero;
	private JButton darkMode;
	private boolean isDarkMode = false;

	private JComboBox<String> cmbOrden, cmbGeneroFiltro;
	private JTextArea txtEstadisticas;

	private JPanel panelLogo;
	private JLabel icon;

	public AdminWindow() {
		initializeComponents();
		setVisible(false);
	}

	public void initializeComponents() {
		// CONFIGURACION DE LA VENTANA
		setTitle("Panel de Administración - BosTinder");
		setBounds(230, 5, 1100, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(Color.decode("#F5E6E8"));
		getContentPane().setLayout(null);

		// --- ENCABEZADO ---
		panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 1100, 103);
		panelLogo.setBackground(Color.decode("#FFFFFF"));
		panelLogo.setLayout(null);
		add(panelLogo);

		lBosTinder = new JLabel("BosTinder");
		lBosTinder.setBounds(380, 25, 400, 72);
		lBosTinder.setForeground(Color.decode("#303080D"));
		lBosTinder.setFont(new Font("Georgia", Font.BOLD, 70));
		panelLogo.add(lBosTinder);
		// add(lBosTinder);

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconBosTinderAdmin.png"));
		icon = new JLabel(imageLogo);
		icon.setBounds(280, 13, 90, 90);
		panelLogo.add(icon);

		lblBuscar = new JLabel("Buscar usuario (alias o correo):");
		lblBuscar.setBounds(30, 120, 250, 25);
		lblBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(250, 120, 200, 25);
		getContentPane().add(txtBuscar);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(470, 120, 100, 25);
		btnBuscar.setForeground(Color.decode("#F9CFCE"));
		btnBuscar.setBackground(Color.decode("#EB5F5B"));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBorderPainted(false);
		getContentPane().add(btnBuscar);

		btnMostrarTodos = new JButton("MOSTRAR TODOS");
		btnMostrarTodos.setBounds(580, 120, 140, 25);
		btnMostrarTodos.setForeground(Color.decode("#F9CFCE"));
		btnMostrarTodos.setBackground(Color.decode("#EB5F5B"));
		btnMostrarTodos.setFocusPainted(false);
		btnMostrarTodos.setBorderPainted(false);
		getContentPane().add(btnMostrarTodos);

		String[] columnas = { "Username", "Nombre", "Apellido", "Edad", "Likes", "Ingresos (USD)", "Género" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		tablaUsuarios = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tablaUsuarios);
		scroll.setBounds(30, 160, 690, 300);
		scroll.setBackground(Color.WHITE);
		getContentPane().add(scroll);

		pnlDetalles = new JPanel();
		pnlDetalles.setLayout(null);
		pnlDetalles.setBounds(740, 121, 330, 360);
		pnlDetalles.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),
				"Detalle de Usuario", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12)));
		pnlDetalles.setBackground(Color.WHITE);
		getContentPane().add(pnlDetalles);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 30, 100, 20);
		pnlDetalles.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(120, 30, 180, 20);
		txtNombre.setEditable(false);
		pnlDetalles.add(txtNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 60, 100, 20);
		pnlDetalles.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(120, 60, 180, 20);
		txtApellido.setEditable(false);
		pnlDetalles.add(txtApellido);

		lblAlias = new JLabel("Username:");
		lblAlias.setBounds(20, 90, 100, 20);
		pnlDetalles.add(lblAlias);

		txtAlias = new JTextField();
		txtAlias.setBounds(120, 90, 180, 20);
		txtAlias.setEditable(false);
		pnlDetalles.add(txtAlias);

		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 120, 100, 20);
		pnlDetalles.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(120, 120, 180, 20);
		txtEdad.setEditable(false);
		pnlDetalles.add(txtEdad);

		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(20, 150, 100, 20);
		pnlDetalles.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(120, 150, 180, 20);
		txtCorreo.setEditable(false);
		pnlDetalles.add(txtCorreo);

		lblLikes = new JLabel("Likes:");
		lblLikes.setBounds(20, 180, 100, 20);
		pnlDetalles.add(lblLikes);

		txtLikes = new JTextField();
		txtLikes.setBounds(120, 180, 180, 20);
		txtLikes.setEditable(false);
		pnlDetalles.add(txtLikes);

		lblIngresos = new JLabel("Ingresos (USD):");
		lblIngresos.setBounds(20, 210, 100, 20);
		pnlDetalles.add(lblIngresos);

		txtIngresos = new JTextField();
		txtIngresos.setBounds(120, 210, 180, 20);
		txtIngresos.setEditable(false);
		pnlDetalles.add(txtIngresos);

		lblFoto = new JLabel("Foto de perfil:");
		lblFoto.setBounds(20, 240, 100, 20);
		pnlDetalles.add(lblFoto);

		lblFotoPreview = new JLabel();
		lblFotoPreview.setBounds(120, 240, 100, 100);
		lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		pnlDetalles.add(lblFotoPreview);

		lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(30, 480, 100, 25);
		lblOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(lblOrdenar);

		String[] criterios = { "Likes", "Apellido", "Nombre", "Edad", "Alias" };
		cmbOrden = new JComboBox<>(criterios);
		cmbOrden.setBounds(130, 480, 120, 25);
		cmbOrden.setBackground(Color.WHITE);
		getContentPane().add(cmbOrden);

		btnOrdenAsc = new JButton("ASCENDENTE ↑");
		btnOrdenAsc.setBounds(270, 480, 140, 25);
		btnOrdenAsc.setForeground(Color.decode("#F9CFCE"));
		btnOrdenAsc.setBackground(Color.decode("#EB5F5B"));
		btnOrdenAsc.setFocusPainted(false);
		btnOrdenAsc.setBorderPainted(false);
		getContentPane().add(btnOrdenAsc);

		btnOrdenDesc = new JButton("DESCENDENTE ↓");
		btnOrdenDesc.setBounds(420, 480, 150, 25);
		btnOrdenDesc.setForeground(Color.decode("#F9CFCE"));
		btnOrdenDesc.setBackground(Color.decode("#EB5F5B"));
		btnOrdenDesc.setFocusPainted(false);
		btnOrdenDesc.setBorderPainted(false);
		getContentPane().add(btnOrdenDesc);

		btnDarBaja = new JButton("DAR DE BAJA");
		btnDarBaja.setBounds(600, 480, 120, 25);
		btnDarBaja.setForeground(Color.WHITE);
		btnDarBaja.setBackground(Color.RED);
		btnDarBaja.setFocusPainted(false);
		btnDarBaja.setBorderPainted(false);
		getContentPane().add(btnDarBaja);

		btnGenerarPDF = new JButton("GENERAR INFORME PDF");
		btnGenerarPDF.setBounds(807, 490, 200, 35);
		btnGenerarPDF.setForeground(Color.decode("#033800"));
		btnGenerarPDF.setBackground(Color.decode("#59D46E"));
		btnGenerarPDF.setFocusPainted(false);
		btnGenerarPDF.setBorderPainted(false);
		getContentPane().add(btnGenerarPDF);

		lblFiltros = new JLabel("Filtros rápidos:");
		lblFiltros.setBounds(30, 520, 100, 25);
		lblFiltros.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(lblFiltros);

		btnFiltroTop10 = new JButton("TOP 10 LIKES");
		btnFiltroTop10.setBounds(130, 520, 130, 25);
		btnFiltroTop10.setForeground(Color.decode("#F9CFCE"));
		btnFiltroTop10.setBackground(Color.decode("#EB5F5B"));
		btnFiltroTop10.setFocusPainted(false);
		btnFiltroTop10.setBorderPainted(false);
		getContentPane().add(btnFiltroTop10);

		btnFiltroIngresos = new JButton("INGRESOS ≥ 244.85 USD");
		btnFiltroIngresos.setBounds(270, 520, 200, 25);
		btnFiltroIngresos.setForeground(Color.decode("#F9CFCE"));
		btnFiltroIngresos.setBackground(Color.decode("#EB5F5B"));
		btnFiltroIngresos.setFocusPainted(false);
		btnFiltroIngresos.setBorderPainted(false);
		getContentPane().add(btnFiltroIngresos);

		btnFiltroGenero = new JButton("FILTRAR POR GÉNERO");
		btnFiltroGenero.setBounds(480, 520, 160, 25);
		btnFiltroGenero.setForeground(Color.decode("#F9CFCE"));
		btnFiltroGenero.setBackground(Color.decode("#EB5F5B"));
		btnFiltroGenero.setFocusPainted(false);
		btnFiltroGenero.setBorderPainted(false);
		getContentPane().add(btnFiltroGenero);

		cmbGeneroFiltro = new JComboBox<>(new String[] { "Todos", "Masculino", "Femenino", "Otro" });
		cmbGeneroFiltro.setBounds(650, 520, 120, 25);
		cmbGeneroFiltro.setBackground(Color.WHITE);
		getContentPane().add(cmbGeneroFiltro);

		txtEstadisticas = new JTextArea(
				"¡! Al generar el PDF, se calcularán las estadísticas de los usuarios actuales.");
		txtEstadisticas.setBounds(30, 560, 1010, 60);
		txtEstadisticas.setEditable(false);
		txtEstadisticas.setBackground(Color.WHITE);
		txtEstadisticas.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		getContentPane().add(txtEstadisticas);

		btnSalirModoAdmin = new JButton("SALIR DE MODO ADMIN.");
		btnSalirModoAdmin.setBounds(870, 640, 180, 35);
		btnSalirModoAdmin.setForeground(Color.decode("#F9CFCE"));
		btnSalirModoAdmin.setBackground(Color.decode("#EB5F5B"));
		btnSalirModoAdmin.setFocusPainted(false);
		btnSalirModoAdmin.setBorderPainted(false);
		getContentPane().add(btnSalirModoAdmin);

		ImageIcon changeMode = new ImageIcon(getClass().getResource("changeMode.png"));
		JLabel lChangeMode = new JLabel(changeMode);
		darkMode = new JButton(changeMode);
		darkMode.setBounds(5, 620, 66, 60);
		darkMode.setOpaque(false);
		darkMode.setOpaque(false);
		darkMode.setContentAreaFilled(false);
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuroSW());
		this.add(darkMode);
	}

	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
	public void cambiarAModoOscuroSW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F5E6E8"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));

			// Labels
			lblBuscar.setForeground(Color.decode("#000000"));
			lblOrdenar.setForeground(Color.decode("#000000"));
			lblFiltros.setForeground(Color.decode("#000000"));

			// Campos de texto
			txtBuscar.setBackground(Color.decode("#FFFFFF"));
			txtBuscar.setForeground(Color.decode("#000000"));
			txtEstadisticas.setBackground(Color.decode("#FFFFFF"));
			txtEstadisticas.setForeground(Color.decode("#000000"));

			// Botones principales
			btnBuscar.setForeground(Color.decode("#F9CFCE"));
			btnBuscar.setBackground(Color.decode("#EB5F5B"));
			btnMostrarTodos.setForeground(Color.decode("#F9CFCE"));
			btnMostrarTodos.setBackground(Color.decode("#EB5F5B"));
			btnOrdenAsc.setForeground(Color.decode("#F9CFCE"));
			btnOrdenAsc.setBackground(Color.decode("#EB5F5B"));
			btnOrdenDesc.setForeground(Color.decode("#F9CFCE"));
			btnOrdenDesc.setBackground(Color.decode("#EB5F5B"));
			btnDarBaja.setForeground(Color.decode("#FFFFFF"));
			btnDarBaja.setBackground(Color.decode("#FF0000"));
			btnGenerarPDF.setForeground(Color.decode("#033800"));
			btnGenerarPDF.setBackground(Color.decode("#59D46E"));
			btnFiltroTop10.setForeground(Color.decode("#F9CFCE"));
			btnFiltroTop10.setBackground(Color.decode("#EB5F5B"));
			btnFiltroIngresos.setForeground(Color.decode("#F9CFCE"));
			btnFiltroIngresos.setBackground(Color.decode("#EB5F5B"));
			btnFiltroGenero.setForeground(Color.decode("#F9CFCE"));
			btnFiltroGenero.setBackground(Color.decode("#EB5F5B"));
			btnSalirModoAdmin.setForeground(Color.decode("#F9CFCE"));
			btnSalirModoAdmin.setBackground(Color.decode("#EB5F5B"));

			// Panel de detalles
			pnlDetalles.setBackground(Color.decode("#FFFFFF"));
			pnlDetalles.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),
					"Detalle de Usuario", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12)));

			// Labels del panel de detalles
			lblNombre.setForeground(Color.decode("#000000"));
			lblApellido.setForeground(Color.decode("#000000"));
			lblAlias.setForeground(Color.decode("#000000"));
			lblEdad.setForeground(Color.decode("#000000"));
			lblCorreo.setForeground(Color.decode("#000000"));
			lblLikes.setForeground(Color.decode("#000000"));
			lblIngresos.setForeground(Color.decode("#000000"));
			lblFoto.setForeground(Color.decode("#000000"));

			// Campos de texto del panel de detalles
			txtNombre.setBackground(Color.decode("#FFFFFF"));
			txtNombre.setForeground(Color.decode("#000000"));
			txtApellido.setBackground(Color.decode("#FFFFFF"));
			txtApellido.setForeground(Color.decode("#000000"));
			txtAlias.setBackground(Color.decode("#FFFFFF"));
			txtAlias.setForeground(Color.decode("#000000"));
			txtEdad.setBackground(Color.decode("#FFFFFF"));
			txtEdad.setForeground(Color.decode("#000000"));
			txtCorreo.setBackground(Color.decode("#FFFFFF"));
			txtCorreo.setForeground(Color.decode("#000000"));
			txtLikes.setBackground(Color.decode("#FFFFFF"));
			txtLikes.setForeground(Color.decode("#000000"));
			txtIngresos.setBackground(Color.decode("#FFFFFF"));
			txtIngresos.setForeground(Color.decode("#000000"));

			// Borde de la foto preview
			lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			// Tabla
			tablaUsuarios.setBackground(Color.decode("#FFFFFF"));
			tablaUsuarios.setForeground(Color.decode("#000000"));
			tablaUsuarios.getTableHeader().setBackground(Color.decode("#EB5F5B"));
			tablaUsuarios.getTableHeader().setForeground(Color.decode("#FFFFFF"));

			// ComboBox
			cmbOrden.setBackground(Color.decode("#FFFFFF"));
			cmbOrden.setForeground(Color.decode("#000000"));
			cmbGeneroFiltro.setBackground(Color.decode("#FFFFFF"));
			cmbGeneroFiltro.setForeground(Color.decode("#000000"));

			// Scroll pane
			JScrollPane scroll = (JScrollPane) getContentPane().getComponent(5);
			scroll.setBackground(Color.WHITE);

			// Botón darkMode
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));

			// Labels
			lblBuscar.setForeground(Color.decode("#DCC8EF"));
			lblOrdenar.setForeground(Color.decode("#DCC8EF"));
			lblFiltros.setForeground(Color.decode("#DCC8EF"));

			// Campos de texto
			txtBuscar.setBackground(Color.decode("#2A1F3A"));
			txtBuscar.setForeground(Color.decode("#DCC8EF"));
			txtEstadisticas.setBackground(Color.decode("#2A1F3A"));
			txtEstadisticas.setForeground(Color.decode("#DCC8EF"));

			// Botones principales
			btnBuscar.setForeground(Color.decode("#DCC8EF"));
			btnBuscar.setBackground(Color.decode("#52247C"));
			btnMostrarTodos.setForeground(Color.decode("#DCC8EF"));
			btnMostrarTodos.setBackground(Color.decode("#52247C"));
			btnOrdenAsc.setForeground(Color.decode("#DCC8EF"));
			btnOrdenAsc.setBackground(Color.decode("#52247C"));
			btnOrdenDesc.setForeground(Color.decode("#DCC8EF"));
			btnOrdenDesc.setBackground(Color.decode("#52247C"));
			btnDarBaja.setForeground(Color.decode("#FFFFFF"));
			btnDarBaja.setBackground(Color.decode("#FF2B91"));
			btnGenerarPDF.setForeground(Color.decode("#DCC8EF"));
			btnGenerarPDF.setBackground(Color.decode("#2D7A47"));
			btnFiltroTop10.setForeground(Color.decode("#DCC8EF"));
			btnFiltroTop10.setBackground(Color.decode("#52247C"));
			btnFiltroIngresos.setForeground(Color.decode("#DCC8EF"));
			btnFiltroIngresos.setBackground(Color.decode("#52247C"));
			btnFiltroGenero.setForeground(Color.decode("#DCC8EF"));
			btnFiltroGenero.setBackground(Color.decode("#52247C"));
			btnSalirModoAdmin.setForeground(Color.decode("#DCC8EF"));
			btnSalirModoAdmin.setBackground(Color.decode("#52247C"));

			// Panel de detalles
			pnlDetalles.setBackground(Color.decode("#1E1724"));
			pnlDetalles.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.decode("#DCC8EF")), "Detalle de Usuario", TitledBorder.LEFT,
					TitledBorder.TOP, new Font("Arial", Font.BOLD, 12)));

			// Labels del panel de detalles
			lblNombre.setForeground(Color.decode("#DCC8EF"));
			lblApellido.setForeground(Color.decode("#DCC8EF"));
			lblAlias.setForeground(Color.decode("#DCC8EF"));
			lblEdad.setForeground(Color.decode("#DCC8EF"));
			lblCorreo.setForeground(Color.decode("#DCC8EF"));
			lblLikes.setForeground(Color.decode("#DCC8EF"));
			lblIngresos.setForeground(Color.decode("#DCC8EF"));
			lblFoto.setForeground(Color.decode("#DCC8EF"));

			// Campos de texto del panel de detalles
			txtNombre.setBackground(Color.decode("#2A1F3A"));
			txtNombre.setForeground(Color.decode("#DCC8EF"));
			txtApellido.setBackground(Color.decode("#2A1F3A"));
			txtApellido.setForeground(Color.decode("#DCC8EF"));
			txtAlias.setBackground(Color.decode("#2A1F3A"));
			txtAlias.setForeground(Color.decode("#DCC8EF"));
			txtEdad.setBackground(Color.decode("#2A1F3A"));
			txtEdad.setForeground(Color.decode("#DCC8EF"));
			txtCorreo.setBackground(Color.decode("#2A1F3A"));
			txtCorreo.setForeground(Color.decode("#DCC8EF"));
			txtLikes.setBackground(Color.decode("#2A1F3A"));
			txtLikes.setForeground(Color.decode("#DCC8EF"));
			txtIngresos.setBackground(Color.decode("#2A1F3A"));
			txtIngresos.setForeground(Color.decode("#DCC8EF"));

			// Borde de la foto preview
			lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.decode("#DCC8EF")));

			// Tabla
			tablaUsuarios.setBackground(Color.decode("#2A1F3A"));
			tablaUsuarios.setForeground(Color.decode("#DCC8EF"));
			tablaUsuarios.getTableHeader().setBackground(Color.decode("#52247C"));
			tablaUsuarios.getTableHeader().setForeground(Color.decode("#DCC8EF"));

			// ComboBox
			cmbOrden.setBackground(Color.decode("#2A1F3A"));
			cmbOrden.setForeground(Color.decode("#DCC8EF"));
			cmbGeneroFiltro.setBackground(Color.decode("#2A1F3A"));
			cmbGeneroFiltro.setForeground(Color.decode("#DCC8EF"));

			// Scroll pane
			JScrollPane scroll = (JScrollPane) getContentPane().getComponent(5);
			scroll.setBackground(Color.decode("#1E1724"));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}
	}

	public void aplicarInternacionalizacion(Properties prop) {
		// Título de la ventana
		setTitle(prop.getProperty("bostinder.view.adminwindow.title"));

		// Panel de detalles
		TitledBorder border = (TitledBorder) pnlDetalles.getBorder();
		border.setTitle(prop.getProperty("bostinder.view.adminwindow.panel.detalleusuario"));
		pnlDetalles.repaint();

		// Labels dentro del panel de detalles
		lblNombre.setText(prop.getProperty("bostinder.view.adminwindow.label.nombre"));
		lblApellido.setText(prop.getProperty("bostinder.view.adminwindow.label.apellido"));
		lblAlias.setText(prop.getProperty("bostinder.view.adminwindow.label.alias"));
		lblEdad.setText(prop.getProperty("bostinder.view.adminwindow.label.edad"));
		lblCorreo.setText(prop.getProperty("bostinder.view.adminwindow.label.correo"));
		lblLikes.setText(prop.getProperty("bostinder.view.adminwindow.label.likes"));
		lblIngresos.setText(prop.getProperty("bostinder.view.adminwindow.label.ingresos"));
		lblFoto.setText(prop.getProperty("bostinder.view.adminwindow.label.foto"));

		// Labels externos
		lblBuscar.setText(prop.getProperty("bostinder.view.adminwindow.label.buscar"));
		lblOrdenar.setText(prop.getProperty("bostinder.view.adminwindow.label.ordenar"));
		lblFiltros.setText(prop.getProperty("bostinder.view.adminwindow.label.filtros"));

		// Botones
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

		// ComboBoxes
		cmbOrden.removeAllItems();
		cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.likes", "Likes"));
		cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.apellido", "Apellido"));
		cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.nombre", "Nombre"));
		cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.edad", "Edad"));
		cmbOrden.addItem(prop.getProperty("bostinder.view.adminwindow.combo.alias", "Alias"));

		cmbGeneroFiltro.removeAllItems();
		cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.todos", "Todos"));
		cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.masculino", "Masculino"));
		cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.femenino", "Femenino"));
		cmbGeneroFiltro.addItem(prop.getProperty("bostinder.view.adminwindow.combo.otro", "Otro"));

		// 🔹 Texto informativo
		txtEstadisticas.setText(prop.getProperty("bostinder.view.adminwindow.text.estadisticas",
				"¡Al generar el PDF, se calcularán las estadísticas de los usuarios actuales!"));
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