package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	
	private JPanel contentPane;
	private Jugador jugador1;
	private Juego ventanaJuego = new Juego();
	private Perfil ventanaPerfil = new Perfil();
	
	private Juego seg;
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 648);
		setLocationRelativeTo(null);

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVentanas = new JMenu("Ventanas");
		menuBar.add(mnVentanas);
		
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "JUEGO");
				
				//CUANDO SE PARA EL TEMPORIZADOR SE VUELVE A INICIAR
				if (jugador1.getTemp() == 0){
					Juego.temporizador.start();
					//jugador1.setTemp(1);
				}
			}
		});
		mnVentanas.add(mntmJuego);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "PERFIL");
				
				//SI EL TEMPORIZADOR ESTA INICIADO SE PARA PARA PODER EDITAR E
				if (jugador1.getTemp() == 1){
					Juego.temporizador.stop();
					jugador1.setTemp(0);
				}
			}
		});
		mnVentanas.add(mntmPerfil);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		contentPane.add(ventanaJuego, "JUEGO");
		contentPane.add(ventanaPerfil, "PERFIL");
	}
	
	public void setJugador(Jugador jugador1) {
		this.jugador1 = jugador1;
		ventanaJuego.setJugador(jugador1);
		ventanaPerfil.setJugador(jugador1);
	}

}