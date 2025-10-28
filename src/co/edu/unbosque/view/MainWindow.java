package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblFotoPerfil;
	private JLabel lblNombreEdad;
	private JTextArea txtDescripcion;
	private JButton btnLike, btnNope, btnFavorito, btnPerfil, btnCerrarSesion;

	public MainWindow() {
        this.setTitle("BosTinder - Inicio");
        this.setBounds(230, 5, 980, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#F9CFCE"));
        getContentPane().setLayout(null);

        // --- Encabezado ---
        JLabel lblIcon = new JLabel("");
        lblIcon.setForeground(Color.decode("#F9CFCE"));
        lblIcon.setBackground(Color.decode("#F9CFCE"));
        lblIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/co/edu/unbosque/view/iconStart.JPG")));
        lblIcon.setBounds(10, 11, 938, 144);
        getContentPane().add(lblIcon);

        JLabel lblTitulo = new JLabel("¡Bienvenido a BosTinder!");
        lblTitulo.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        lblTitulo.setBounds(20, 166, 361, 58);
        getContentPane().add(lblTitulo);

        // --- FOTO GRANDE DEL PERFIL ---
        lblFotoPerfil = new JLabel();
        lblFotoPerfil.setBounds(57, 222, 350, 350);
        lblFotoPerfil.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        getContentPane().add(lblFotoPerfil);

        // --- NOMBRE Y EDAD DEBAJO DE LA FOTO ---
        lblNombreEdad = new JLabel("", SwingConstants.CENTER);
        lblNombreEdad.setFont(new Font("Cooper Black", Font.PLAIN, 18));
        lblNombreEdad.setBounds(57, 571, 350, 25);
        getContentPane().add(lblNombreEdad);

        // --- DESCRIPCIÓN A LA DERECHA ---
        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(480, 250, 420, 280);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        txtDescripcion.setBackground(Color.WHITE);
        txtDescripcion.setBorder(BorderFactory.createTitledBorder("Descripción"));
        getContentPane().add(txtDescripcion);

        // --- BOTONES DE ACCIÓN ---
        btnNope = new JButton("✖️");
        btnNope.setBounds(264, 603, 100, 40);
        getContentPane().add(btnNope);

        btnFavorito = new JButton("⭐ Favorito");
        btnFavorito.setBounds(780, 565, 120, 40);
        getContentPane().add(btnFavorito);

        btnLike = new JButton("💖");
        btnLike.setBounds(91, 603, 100, 40);
        getContentPane().add(btnLike);

        // --- BOTONES LATERALES ---
        btnPerfil = new JButton("Mi Perfil");
        btnPerfil.setBounds(801, 182, 100, 32);
        getContentPane().add(btnPerfil);

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBounds(458, 182, 100, 32);
        getContentPane().add(btnCerrarSesion);
        
        JButton btnVerMeGusta = new JButton("Ver me gusta");
        btnVerMeGusta.setBounds(691, 182, 100, 32);
        getContentPane().add(btnVerMeGusta);
        
        JButton btnModoIncognito = new JButton("Modo Incognito");
        btnModoIncognito.setBounds(568, 182, 113, 32);
        getContentPane().add(btnModoIncognito);

        // --- CARGAR EL PRIMER PERFIL ---
        /*actualizarPerfil();

        // --- EVENTOS ---
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sesión cerrada correctamente.");
                dispose();
            }
        });

        ActionListener siguientePerfil = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indiceActual++;
                if (indiceActual >= perfiles.length) {
                    indiceActual = 0; // reinicia cuando se acaba la lista
                }
                actualizarPerfil();
            }
        };

        btnLike.addActionListener(siguientePerfil);
        btnNope.addActionListener(siguientePerfil);
        btnFavorito.addActionListener(siguientePerfil);
    }*/

    /**
     * Actualiza los datos del perfil mostrado (foto, nombre, edad, descripción)
     
    private void actualizarPerfil() {
        String nombre = perfiles[indiceActual][0];
        String edad = perfiles[indiceActual][1];
        String descripcion = perfiles[indiceActual][2];
        String rutaImagen = perfiles[indiceActual][3];

        lblNombreEdad.setText(nombre + ", " + edad);
        txtDescripcion.setText(descripcion);

        ImageIcon image = new ImageIcon(BTMainWindow.class.getResource(rutaImagen));
        ImageIcon scaled = new ImageIcon(image.getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
        lblFotoPerfil.setIcon(scaled);
    }*/
        
    
}

	public JLabel getLblFotoPerfil() {
		return lblFotoPerfil;
	}

	public void setLblFotoPerfil(JLabel lblFotoPerfil) {
		this.lblFotoPerfil = lblFotoPerfil;
	}

	public JLabel getLblNombreEdad() {
		return lblNombreEdad;
	}

	public void setLblNombreEdad(JLabel lblNombreEdad) {
		this.lblNombreEdad = lblNombreEdad;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextArea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JButton getBtnLike() {
		return btnLike;
	}

	public void setBtnLike(JButton btnLike) {
		this.btnLike = btnLike;
	}

	public JButton getBtnNope() {
		return btnNope;
	}

	public void setBtnNope(JButton btnNope) {
		this.btnNope = btnNope;
	}

	public JButton getBtnFavorito() {
		return btnFavorito;
	}

	public void setBtnFavorito(JButton btnFavorito) {
		this.btnFavorito = btnFavorito;
	}

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}
}
