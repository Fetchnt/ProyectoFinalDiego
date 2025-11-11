package co.edu.unbosque.view;

import java.awt.*;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PreferencesWindow extends JFrame {

	// Componentes comunes (para ambos géneros)
	private JLabel lblTitulo;
	private JLabel lblSubtitulo;
	private JLabel lblEdadMin;
	private JLabel lblEdadMax;
	private JTextField txtEdadMin;
	private JTextField txtEdadMax;

	// Componentes específicos para hombres
	private JLabel lblDivorcios;
	private JComboBox<String> cmbDivorcios;

	// Componentes específicos para mujeres
	private JLabel lblEstatura;
	private JTextField txtEstatura;
	private JLabel lblIngresos;
	private JTextField txtIngresos;

	// Botones
	private JButton btnAceptar;
	private JButton btnCancelar;

	// Panel principal
	private JPanel panelPrincipal;
	private JPanel panelCampos;
	private JPanel panelBotones;
	private JPanel panelTitulo;

	// Variable para saber si se aceptó o canceló
	private boolean aceptado = false;
	private JButton darkMode;
	private boolean isDarkMode = false;

	public PreferencesWindow() {
		setTitle("Preferencias de Búsqueda");
		setSize(500, 450);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		inicializarComponentes();
	}

	private void inicializarComponentes() {
		panelPrincipal = new JPanel(new BorderLayout(10, 10));
		panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelPrincipal.setBackground(new Color(255, 240, 245));

		// Panel superior con título
		panelTitulo = new JPanel(new BorderLayout(5, 5));
		panelTitulo.setBackground(new Color(255, 240, 245));

		lblTitulo = new JLabel("Configura tus Preferencias", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setForeground(new Color(220, 20, 60));

		lblSubtitulo = new JLabel("Encuentra a tu match ideal", SwingConstants.CENTER);
		lblSubtitulo.setFont(new Font("Arial", Font.ITALIC, 14));
		lblSubtitulo.setForeground(new Color(100, 100, 100));

		panelTitulo.add(lblTitulo, BorderLayout.CENTER);
		panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);

		// Panel de campos (se configurará según el género)
		panelCampos = new JPanel();
		panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
		panelCampos.setBackground(Color.WHITE);
		panelCampos.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(220, 20, 60), 2), new EmptyBorder(20, 20, 20, 20)));

		// Inicializar componentes comunes
		lblEdadMin = new JLabel("Edad mínima:");
		lblEdadMin.setFont(new Font("Arial", Font.BOLD, 14));
		txtEdadMin = new JTextField("18");
		txtEdadMin.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEdadMin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		lblEdadMax = new JLabel("Edad máxima:");
		lblEdadMax.setFont(new Font("Arial", Font.BOLD, 14));
		txtEdadMax = new JTextField("50");
		txtEdadMax.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEdadMax.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		// Componentes para hombres
		lblDivorcios = new JLabel("¿Ha tenido divorcios?");
		lblDivorcios.setFont(new Font("Arial", Font.BOLD, 14));
		String[] opcionesDivorcios = { "No importa", "Sí", "No" };
		cmbDivorcios = new JComboBox<>(opcionesDivorcios);
		cmbDivorcios.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbDivorcios.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		// Componentes para mujeres
		lblEstatura = new JLabel("Estatura mínima (m):");
		lblEstatura.setFont(new Font("Arial", Font.BOLD, 14));
		txtEstatura = new JTextField("1.60");
		txtEstatura.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEstatura.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		lblIngresos = new JLabel("Ingresos mínimos (USD):");
		lblIngresos.setFont(new Font("Arial", Font.BOLD, 14));
		txtIngresos = new JTextField("1000");
		txtIngresos.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIngresos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		// Panel de botones
		panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotones.setBackground(new Color(255, 240, 245));

		btnAceptar = new JButton("Aplicar Preferencias");
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAceptar.setBackground(new Color(220, 20, 60));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCancelar = new JButton("Ver Todos");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(150, 150, 150));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(10, 10, 150, 30);
		darkMode.addActionListener(e -> cambiarAModoOscuroSW());
		panelPrincipal.add(darkMode);

		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);

		// Agregar paneles al principal
		panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
		panelPrincipal.add(panelCampos, BorderLayout.CENTER);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

		add(panelPrincipal);
	}
	
	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
	public void cambiarAModoOscuroSW() {
	    if (isDarkMode) {
	        // Mantiene el modo claro
	        this.getContentPane().setBackground(Color.decode("#F9CFCE"));
	        panelPrincipal.setBackground(new Color(255, 240, 245));
	        panelTitulo.setBackground(new Color(255, 240, 245));
	        panelCampos.setBackground(Color.WHITE);
	        panelBotones.setBackground(new Color(255, 240, 245));
	        
	        // Labels
	        lblTitulo.setForeground(new Color(220, 20, 60));
	        lblSubtitulo.setForeground(new Color(100, 100, 100));
	        lblEdadMin.setForeground(Color.BLACK);
	        lblEdadMax.setForeground(Color.BLACK);
	        lblDivorcios.setForeground(Color.BLACK);
	        lblEstatura.setForeground(Color.BLACK);
	        lblIngresos.setForeground(Color.BLACK);
	        
	        // Campos de texto
	        txtEdadMin.setBackground(Color.WHITE);
	        txtEdadMin.setForeground(Color.BLACK);
	        txtEdadMax.setBackground(Color.WHITE);
	        txtEdadMax.setForeground(Color.BLACK);
	        txtEstatura.setBackground(Color.WHITE);
	        txtEstatura.setForeground(Color.BLACK);
	        txtIngresos.setBackground(Color.WHITE);
	        txtIngresos.setForeground(Color.BLACK);
	        
	        // ComboBox
	        cmbDivorcios.setBackground(Color.WHITE);
	        cmbDivorcios.setForeground(Color.BLACK);
	        
	        // Bordes
	        panelCampos.setBorder(BorderFactory.createCompoundBorder(
	                BorderFactory.createLineBorder(new Color(220, 20, 60), 2), 
	                new EmptyBorder(20, 20, 20, 20)));
	        
	        // Botones
	        btnAceptar.setBackground(new Color(220, 20, 60));
	        btnAceptar.setForeground(Color.WHITE);
	        btnCancelar.setBackground(new Color(150, 150, 150));
	        btnCancelar.setForeground(Color.WHITE);
	        
	        // Botón darkMode
	        darkMode.setBackground(Color.decode("#EB5F5B"));
	        darkMode.setForeground(Color.decode("#F9CFCE"));
	        darkMode.setText("MODO OSCURO");
	        isDarkMode = false;

	    } else {
	        // Cambia a modo oscuro
	        this.getContentPane().setBackground(Color.decode("#11021E"));
	        panelPrincipal.setBackground(Color.decode("#1E1724"));
	        panelTitulo.setBackground(Color.decode("#1E1724"));
	        panelCampos.setBackground(Color.decode("#1E1724"));
	        panelBotones.setBackground(Color.decode("#1E1724"));
	        
	        // Labels
	        lblTitulo.setForeground(Color.decode("#FF2B91"));
	        lblSubtitulo.setForeground(Color.decode("#FF7171"));
	        lblEdadMin.setForeground(Color.decode("#DCC8EF"));
	        lblEdadMax.setForeground(Color.decode("#DCC8EF"));
	        lblDivorcios.setForeground(Color.decode("#DCC8EF"));
	        lblEstatura.setForeground(Color.decode("#DCC8EF"));
	        lblIngresos.setForeground(Color.decode("#DCC8EF"));
	        
	        // Campos de texto
	        txtEdadMin.setBackground(Color.decode("#2A1F3A"));
	        txtEdadMin.setForeground(Color.decode("#DCC8EF"));
	        txtEdadMax.setBackground(Color.decode("#2A1F3A"));
	        txtEdadMax.setForeground(Color.decode("#DCC8EF"));
	        txtEstatura.setBackground(Color.decode("#2A1F3A"));
	        txtEstatura.setForeground(Color.decode("#DCC8EF"));
	        txtIngresos.setBackground(Color.decode("#2A1F3A"));
	        txtIngresos.setForeground(Color.decode("#DCC8EF"));
	        
	        // ComboBox
	        cmbDivorcios.setBackground(Color.decode("#2A1F3A"));
	        cmbDivorcios.setForeground(Color.decode("#DCC8EF"));
	        
	        // Bordes
	        panelCampos.setBorder(BorderFactory.createCompoundBorder(
	                BorderFactory.createLineBorder(Color.decode("#DCC8EF"), 2), 
	                new EmptyBorder(20, 20, 20, 20)));
	        
	        // Botones
	        btnAceptar.setBackground(Color.decode("#52247C"));
	        btnAceptar.setForeground(Color.decode("#DCC8EF"));
	        btnCancelar.setBackground(Color.decode("#52247C"));
	        btnCancelar.setForeground(Color.decode("#DCC8EF"));
	        
	        // Botón darkMode
	        darkMode.setBackground(Color.decode("#52247C"));
	        darkMode.setForeground(Color.decode("#DCC8EF"));
	        darkMode.setText("MODO CLARO");
	        isDarkMode = true;
	    }
	}

	/**
	 * Configura la ventana para mostrar preferencias de hombres
	 */
	public void configurarParaHombres() {
		panelCampos.removeAll();

		// Edad mínima
		panelCampos.add(lblEdadMin);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtEdadMin);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

		// Edad máxima
		panelCampos.add(lblEdadMax);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtEdadMax);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

		// Divorcios
		panelCampos.add(lblDivorcios);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(cmbDivorcios);

		panelCampos.revalidate();
		panelCampos.repaint();
	}

	/**
	 * Configura la ventana para mostrar preferencias de mujeres
	 */
	public void configurarParaMujeres() {
		panelCampos.removeAll();

		// Edad mínima
		panelCampos.add(lblEdadMin);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtEdadMin);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

		// Edad máxima
		panelCampos.add(lblEdadMax);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtEdadMax);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

		// Estatura
		panelCampos.add(lblEstatura);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtEstatura);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

		// Ingresos
		panelCampos.add(lblIngresos);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtIngresos);

		panelCampos.revalidate();
		panelCampos.repaint();
	}

	public void aplicarInternacionalizacion(Properties prop) {
		// Título de la ventana
		setTitle(prop.getProperty("bostinder.view.loginwindow.title"));
	}

	// Getters y setters
	public JTextField getTxtEdadMin() {
		return txtEdadMin;
	}

	public JTextField getTxtEdadMax() {
		return txtEdadMax;
	}

	public JComboBox<String> getCmbDivorcios() {
		return cmbDivorcios;
	}

	public JTextField getTxtEstatura() {
		return txtEstatura;
	}

	public JTextField getTxtIngresos() {
		return txtIngresos;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
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

	public void limpiarCampos() {
		txtEdadMin.setText("18");
		txtEdadMax.setText("50");
		txtEstatura.setText("1.60");
		txtIngresos.setText("1000");
		cmbDivorcios.setSelectedIndex(0);
		aceptado = false;
	}
}