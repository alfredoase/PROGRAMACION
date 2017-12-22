package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import Juego1.Jugador;
import Ventanas.Login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Juego extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	Jugador jugador1;
	private Jugador j;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoAMathdice = new JLabel("BIENVENIDO A MATHDICE");
		lblBienvenidoAMathdice.setIcon(new ImageIcon(Juego.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		lblBienvenidoAMathdice.setFont(new Font("Arial", Font.BOLD, 16));
		lblBienvenidoAMathdice.setBounds(106, 11, 241, 32);
		contentPane.add(lblBienvenidoAMathdice);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Juego.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		lblNewLabel.setBounds(10, 62, 82, 32);
		contentPane.add(lblNewLabel);
	}
	public void setJugador(Jugador j){
        this.j=j;
        lblNewLabel.setText("Hola "+j.getNombre()+" bienvenido al juego.");
    }
}
