package co.edu.unbosque.view;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.MenDTO;
import co.edu.unbosque.model.WomenDTO;

public class MapWindow extends JFrame {

	private BufferedImage mapaImg;
	private Map<String, Point> puntosPaises;
	private ModelFacade model;

	public MapWindow(ModelFacade model) {
		this.model = model;
		initializeComponents();
	}

	public void initializeComponents() {
		setTitle("BosTinder - Mapa de usuarios");
		setBounds(230, 5, 980, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.decode("#FFFFFF"));

		cargarMapa();
		definirPuntosPaises();

		JPanel panelMapa = new JPanel() {
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
		};

		panelMapa.setBounds(10, 10, 950, 650);
		panelMapa.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelMapa.addMouseMotionListener((MouseMotionListener) new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				String pais = getPaisEnPunto(e.getPoint());
				setTitle(pais != null ? "BosTinder - " + pais : "BosTinder - Mapa");
			}
		});

		panelMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pais = getPaisEnPunto(e.getPoint());
				if (pais != null) {
					mostrarUsuariosPorPais(pais);
				}
			}
		});

		add(panelMapa);
	}

	private void cargarMapa() {
		try {
			mapaImg = javax.imageio.ImageIO.read(new java.io.File("src/co/edu/unbosque/view/mapWorld.jpg"));
		} catch (Exception ex) {
			System.err.println("❌ Error al cargar mapa: " + ex.getMessage());
		}
	}

	private void definirPuntosPaises() {
		puntosPaises = new HashMap<>();
		puntosPaises.put("España", new Point(470, 180));
		puntosPaises.put("Portugal", new Point(450, 190));
		puntosPaises.put("Israel", new Point(540, 220));
		puntosPaises.put("Rusia", new Point(620, 120));
		puntosPaises.put("China", new Point(720, 200));
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
}