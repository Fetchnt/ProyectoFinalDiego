package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import co.edu.unbosque.model.ModelFacade;

public class MapWindow extends JFrame {

	private BufferedImage mapaImg;
	private Map<String, Point> puntosPaises;
	private ModelFacade model;
	private JButton btnBackMap;
	private JPanel panelMapa;
	private JLabel icon;
	private JPanel panelOption;
	
	public MapWindow(ModelFacade model) {
		this.model = model;
		initializeComponents();
	}

	public void initializeComponents() {
		//--------CONFIGURACIÓN VENTANA--------
		setTitle("BosTinder - Mapa de usuarios");
		setBounds(230, 5, 980, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.decode("#F9CFCE"));

		//-------IMAGEN SUPERIOR------------
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconStart.JPG"));
		icon = new JLabel(imageLogo);
		icon.setBounds(0, 0, 980, 150);
		add(icon);
		
		//--------PANEL OPCIONES---------
		panelOption = new JPanel();
		panelOption.setBounds(750, 592, 190, 70);
		panelOption.setLayout(null);
		panelOption.setBackground(Color.WHITE);
		add(panelOption);
		
		
		//------
		cargarMapa();
		definirPuntosPaises();

		//------PANEL MAPA--------
		panelMapa = new PanelMapa();
		panelMapa.setBounds(5, 155, 730, 520);
		panelMapa.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// listeners
		panelMapa.addMouseMotionListener(new MoverMouseListener());
		panelMapa.addMouseListener(new ClickMouseListener());

		//-------BOTON-------------
		btnBackMap = new JButton("Volver");
		btnBackMap.setBounds(40, 20, 120, 30);
		btnBackMap.setBackground(Color.decode("#F4716D"));
		btnBackMap.setForeground(Color.WHITE);
		btnBackMap.setFont(new Font("Arial", Font.BOLD, 14));
		btnBackMap.setFocusPainted(false);
		btnBackMap.setBorderPainted(false);
		panelOption.add(btnBackMap);
		
		
		add(panelMapa);
	}

	private void cargarMapa() {
		try {
			mapaImg = javax.imageio.ImageIO.read(new java.io.File("src/co/edu/unbosque/view/mapWorld.jpg"));
		} catch (Exception e) {
			System.out.println("Error al cargar el mapa: " + e.getMessage());
		}
	}

	private void definirPuntosPaises() {
		puntosPaises = new HashMap<>();
		puntosPaises.put("España", new Point(454, 263));
		puntosPaises.put("Portugal", new Point(433, 270));
		puntosPaises.put("Israel", new Point(531, 292));
		puntosPaises.put("Rusia", new Point(663, 166));
		puntosPaises.put("Taiwan", new Point(729, 340));
		puntosPaises.put("Singapur", new Point(629, 360));
		puntosPaises.put("Brasil", new Point(325, 416));
		puntosPaises.put("Macao", new Point(714, 326));
		puntosPaises.put("Angola", new Point(480, 410));
		puntosPaises.put("Kazajistan", new Point(595, 227));
		puntosPaises.put("Mexico", new Point(213, 314));
		puntosPaises.put("Argentina", new Point(295, 476));
		puntosPaises.put("Colombia", new Point(281, 378));

	}

	private String getPaisEnPunto(Point p) {
		for (Map.Entry<String, Point> entry : puntosPaises.entrySet()) {
			Point paisPoint = entry.getValue();
			double distancia = p.distance(paisPoint);
			if (distancia < 10) {
				return entry.getKey();
			}
		}
		return null;
	}

	private void mostrarUsuariosPorPais(String pais) {
		List<String> usuarios = model.getUsuariosPorPais(pais);

		if (usuarios.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay usuarios registrados en " + pais);
			return;
		}

		JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));
		for (String alias : usuarios) {
			JLabel lbl = new JLabel(alias, SwingConstants.CENTER);
			lbl.setFont(new Font("Arial", Font.PLAIN, 14));
			lbl.setOpaque(true);
			lbl.setBackground(Color.WHITE);
			lbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			panel.add(lbl);
		}

		JScrollPane scroll = new JScrollPane(panel);
		scroll.setPreferredSize(new Dimension(500, 300));
		JOptionPane.showMessageDialog(this, scroll, "Usuarios en " + pais, JOptionPane.PLAIN_MESSAGE);
	}

	public JButton getBtnBackMap() {
		return btnBackMap;
	}

	public void setBtnBackMap(JButton btnVolverMap) {
		this.btnBackMap = btnVolverMap;
	}

	private class PanelMapa extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (mapaImg != null) {
				g.drawImage(mapaImg, 0, 0, getWidth(), getHeight(), null);
				g.setColor(Color.RED);
				for (Point p : puntosPaises.values()) {
					g.fillOval(p.x - 5, p.y - 5, 10, 10);
				}
			}
		}
	}

	private class MoverMouseListener implements MouseMotionListener {
		@Override
		public void mouseMoved(MouseEvent e) {
			String pais = getPaisEnPunto(e.getPoint());
			setTitle(pais != null ? "BosTinder - " + pais : "BosTinder - Mapa");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// Este no se usa pero se debe dejar prque es del mousemotionlistener
		}
	}

	private class ClickMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			String pais = getPaisEnPunto(e.getPoint());
			if (pais != null) {
				mostrarUsuariosPorPais(pais);
			}
		}
	}
}