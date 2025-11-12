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

	// Componentes específicos para hombres (buscan mujeres)
	private JLabel lblDivorcios;
	private JComboBox<String> cmbDivorcios;

	// Componentes específicos para mujeres (buscan hombres)
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
		setSize(500, 550); // Aumentado para acomodar más campos
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

		// Componentes para buscar mujeres
		lblDivorcios = new JLabel("¿Ha tenido divorcios?");
		lblDivorcios.setFont(new Font("Arial", Font.BOLD, 14));
		String[] opcionesDivorcios = { "No importa", "Sí", "No" };
		cmbDivorcios = new JComboBox<>(opcionesDivorcios);
		cmbDivorcios.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbDivorcios.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		// Componentes para buscar hombres
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

	/**
	 * Configura la ventana según el género y orientación sexual del usuario
	 * 
	 * @param genero      El género del usuario ("Masculino" o "Femenino")
	 * @param orientacion La orientación sexual ("Heterosexual", "Homosexual",
	 *                    "Bisexual", "Asexual")
	 */
	public void configurarSegunOrientacion(String genero, String orientacion) {
		panelCampos.removeAll();

		// Normalizar orientación
		orientacion = orientacion.toLowerCase().trim();

		// Siempre mostrar edad
		panelCampos.add(lblEdadMin);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtEdadMin);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

		panelCampos.add(lblEdadMax);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCampos.add(txtEdadMax);
		panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

		// Determinar qué campos mostrar según género y orientación
		boolean mostrarCamposMujeres = false; // Divorcios
		boolean mostrarCamposHombres = false; // Estatura e Ingresos

		if (orientacion.contains("bisexual") || orientacion.contains("asexual")) {
			// Bisexual/Asexual: mostrar AMBOS conjuntos de campos
			mostrarCamposMujeres = true;
			mostrarCamposHombres = true;
		} else if (orientacion.contains("heterosexual") || orientacion.equals("heterosexual")) {
			// Heterosexual: mostrar campos del género opuesto
			if (genero.equalsIgnoreCase("Masculino")) {
				mostrarCamposMujeres = true; // Hombre heterosexual busca mujeres
			} else {
				mostrarCamposHombres = true; // Mujer heterosexual busca hombres
			}
		} else if (orientacion.contains("homosexual") || orientacion.equals("gay") || orientacion.equals("lésbica")) {
			// Homosexual: mostrar campos del mismo género
			if (genero.equalsIgnoreCase("Masculino")) {
				mostrarCamposHombres = true; // Hombre homosexual busca hombres
			} else {
				mostrarCamposMujeres = true; // Mujer homosexual busca mujeres
			}
		}

		// Agregar campos según lo determinado
		if (mostrarCamposMujeres) {
			JLabel lblSeccionMujeres = new JLabel("━━━━━━ Preferencias para Mujeres ━━━━━━");
			lblSeccionMujeres.setFont(new Font("Arial", Font.BOLD, 12));
			lblSeccionMujeres.setForeground(new Color(220, 20, 60));
			lblSeccionMujeres.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelCampos.add(lblSeccionMujeres);
			panelCampos.add(Box.createRigidArea(new Dimension(0, 10)));

			panelCampos.add(lblDivorcios);
			panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
			panelCampos.add(cmbDivorcios);
			panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));
		}

		if (mostrarCamposHombres) {
			JLabel lblSeccionHombres = new JLabel("━━━━━━ Preferencias para Hombres ━━━━━━");
			lblSeccionHombres.setFont(new Font("Arial", Font.BOLD, 12));
			lblSeccionHombres.setForeground(new Color(220, 20, 60));
			lblSeccionHombres.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelCampos.add(lblSeccionHombres);
			panelCampos.add(Box.createRigidArea(new Dimension(0, 10)));

			panelCampos.add(lblEstatura);
			panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
			panelCampos.add(txtEstatura);
			panelCampos.add(Box.createRigidArea(new Dimension(0, 15)));

			panelCampos.add(lblIngresos);
			panelCampos.add(Box.createRigidArea(new Dimension(0, 5)));
			panelCampos.add(txtIngresos);
		}

		panelCampos.revalidate();
		panelCampos.repaint();
	}

	/**
	 * @deprecated Usar configurarSegunOrientacion() en su lugar
	 */
	@Deprecated
	public void configurarParaHombres() {
		configurarSegunOrientacion("Masculino", "Heterosexual");
	}

	/**
	 * @deprecated Usar configurarSegunOrientacion() en su lugar
	 */
	@Deprecated
	public void configurarParaMujeres() {
		configurarSegunOrientacion("Femenino", "Heterosexual");
	}

	public void cambiarAModoOscuroSW() {
		if (isDarkMode) {
			// Modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelPrincipal.setBackground(new Color(255, 240, 245));
			panelTitulo.setBackground(new Color(255, 240, 245));
			panelCampos.setBackground(Color.WHITE);
			panelBotones.setBackground(new Color(255, 240, 245));

			lblTitulo.setForeground(new Color(220, 20, 60));
			lblSubtitulo.setForeground(new Color(100, 100, 100));
			lblEdadMin.setForeground(Color.BLACK);
			lblEdadMax.setForeground(Color.BLACK);
			lblDivorcios.setForeground(Color.BLACK);
			lblEstatura.setForeground(Color.BLACK);
			lblIngresos.setForeground(Color.BLACK);

			txtEdadMin.setBackground(Color.WHITE);
			txtEdadMin.setForeground(Color.BLACK);
			txtEdadMax.setBackground(Color.WHITE);
			txtEdadMax.setForeground(Color.BLACK);
			txtEstatura.setBackground(Color.WHITE);
			txtEstatura.setForeground(Color.BLACK);
			txtIngresos.setBackground(Color.WHITE);
			txtIngresos.setForeground(Color.BLACK);

			cmbDivorcios.setBackground(Color.WHITE);
			cmbDivorcios.setForeground(Color.BLACK);

			panelCampos.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(new Color(220, 20, 60), 2), new EmptyBorder(20, 20, 20, 20)));

			btnAceptar.setBackground(new Color(220, 20, 60));
			btnAceptar.setForeground(Color.WHITE);
			btnCancelar.setBackground(new Color(150, 150, 150));
			btnCancelar.setForeground(Color.WHITE);

			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelPrincipal.setBackground(Color.decode("#1E1724"));
			panelTitulo.setBackground(Color.decode("#1E1724"));
			panelCampos.setBackground(Color.decode("#1E1724"));
			panelBotones.setBackground(Color.decode("#1E1724"));

			lblTitulo.setForeground(Color.decode("#FF2B91"));
			lblSubtitulo.setForeground(Color.decode("#FF7171"));
			lblEdadMin.setForeground(Color.decode("#DCC8EF"));
			lblEdadMax.setForeground(Color.decode("#DCC8EF"));
			lblDivorcios.setForeground(Color.decode("#DCC8EF"));
			lblEstatura.setForeground(Color.decode("#DCC8EF"));
			lblIngresos.setForeground(Color.decode("#DCC8EF"));

			txtEdadMin.setBackground(Color.decode("#2A1F3A"));
			txtEdadMin.setForeground(Color.decode("#DCC8EF"));
			txtEdadMax.setBackground(Color.decode("#2A1F3A"));
			txtEdadMax.setForeground(Color.decode("#DCC8EF"));
			txtEstatura.setBackground(Color.decode("#2A1F3A"));
			txtEstatura.setForeground(Color.decode("#DCC8EF"));
			txtIngresos.setBackground(Color.decode("#2A1F3A"));
			txtIngresos.setForeground(Color.decode("#DCC8EF"));

			cmbDivorcios.setBackground(Color.decode("#2A1F3A"));
			cmbDivorcios.setForeground(Color.decode("#DCC8EF"));

			panelCampos.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.decode("#DCC8EF"), 2), new EmptyBorder(20, 20, 20, 20)));

			btnAceptar.setBackground(Color.decode("#52247C"));
			btnAceptar.setForeground(Color.decode("#DCC8EF"));
			btnCancelar.setBackground(Color.decode("#52247C"));
			btnCancelar.setForeground(Color.decode("#DCC8EF"));

			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}
	}

	public void aplicarInternacionalizacion(Properties prop) {
		// Título de la ventana
		setTitle(prop.getProperty("bostinder.view.preferenceswindow.title"));

		// Títulos y subtítulos
		lblTitulo.setText(prop.getProperty("bostinder.view.preferenceswindow.label.titulo"));
		lblSubtitulo.setText(prop.getProperty("bostinder.view.preferenceswindow.label.subtitulo"));

		// Campos comunes
		lblEdadMin.setText(prop.getProperty("bostinder.view.preferenceswindow.label.edadmin"));
		lblEdadMax.setText(prop.getProperty("bostinder.view.preferenceswindow.label.edadmax"));

		// Campos para hombres
		lblDivorcios.setText(prop.getProperty("bostinder.view.preferenceswindow.label.divorcios"));
		cmbDivorcios.removeAllItems();
		cmbDivorcios.addItem(prop.getProperty("bostinder.view.preferenceswindow.combo.divorcios.opcion1"));
		cmbDivorcios.addItem(prop.getProperty("bostinder.view.preferenceswindow.combo.divorcios.opcion2"));
		cmbDivorcios.addItem(prop.getProperty("bostinder.view.preferenceswindow.combo.divorcios.opcion3"));

		// Campos para mujeres
		lblEstatura.setText(prop.getProperty("bostinder.view.preferenceswindow.label.estatura"));
		lblIngresos.setText(prop.getProperty("bostinder.view.preferenceswindow.label.ingresos"));

		// Botones
		btnAceptar.setText(prop.getProperty("bostinder.view.preferenceswindow.button.aceptar"));
		btnCancelar.setText(prop.getProperty("bostinder.view.preferenceswindow.button.cancelar"));
		darkMode.setText(prop.getProperty("bostinder.view.preferenceswindow.button.modooscuro"));
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