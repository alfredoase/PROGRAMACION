package Ventanas;

import Juego.Jugador;
import Principal.Principal;
import Ventanas.Login;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import javax.swing.JToolBar;

public class Juego extends JFrame {

	private JPanel contentPane;
	private JTextField cuadroOperaciones;
	
	private ImageIcon[] dados3 = new ImageIcon[3];
	private ImageIcon[] dados6 = new ImageIcon[6];
	private ImageIcon[] dados12 = new ImageIcon[12];
	private ImageIcon dadoGris;
	private Random dado = new Random();
	
	private int[] numerosAlmacenadosDados3 = new int[3];
	private int[] numerosAlmacenadosDados6 = new int[2];
	private int numerosAlmacenadosDados12;
	
	private boolean sepuedeNumero = true;
	private int operacion = 0;
	private int contadorNumeros = 0;
	private boolean esSuma = true;
	private int contadorOperaciones = 0;
	private int botonesActivos = 0;
	
	//DATOS JUGADOR
	private int puntuacion = 45;
	JLabel lblNewLabel;
	Jugador jugador1;
	Jugador nick;
	private Jugador j;
	
	private JLabel dado1, dado2, dado3;
	private JLabel dado4, dado5;
	private JLabel dado6;
	private JLabel btnSumar, btnRestar, lblPuntuacion;
	private JTextField cuadroResultado;
	private JButton btnRepetir, btnComprobar;
	private JLabel lblNuevoJuego;
	private JLabel nombreJugador, jugadorNick;
	private JLabel label;
	private JLabel label_1, label_2;

	/**
	 * Create the frame.
	 */
	public Juego() {
		setResizable(false);
		setTitle("MATHDICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		dado1 = new JLabel("");
		dado1.setBounds(10, 103, 75, 75);
		contentPane.add(dado1);
		
		dado2 = new JLabel("");
		dado2.setBounds(96, 103, 75, 75);
		contentPane.add(dado2);
		
		dado3 = new JLabel("");
		dado3.setBounds(181, 103, 75, 75);
		contentPane.add(dado3);
		
		dado4 = new JLabel("");
		dado4.setBounds(266, 103, 75, 75);
		contentPane.add(dado4);
		
		dado5 = new JLabel("");
		dado5.setBounds(351, 103, 75, 75);
		contentPane.add(dado5);
		
		dado6 = new JLabel("");
		dado6.setBounds(174, 189, 87, 87);
		contentPane.add(dado6);

		
		nombreJugador = new JLabel("BIENVENIDO: ASE");
		nombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombreJugador.setBounds(85, 0, 282, 19);
		contentPane.add(nombreJugador);
		
		cuadroOperaciones = new JTextField();
		cuadroOperaciones.setEditable(false);
		cuadroOperaciones.setEnabled(true);
		cuadroOperaciones.setForeground(Color.BLACK);
		cuadroOperaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cuadroOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		cuadroOperaciones.setBounds(69, 275, 298, 47);
		contentPane.add(cuadroOperaciones);
		cuadroOperaciones.setColumns(10);
		
		//LABEL SUMAR
		btnSumar = new JLabel("");
		btnSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botonesActivos == 1) {
					if (contadorOperaciones == 0){
						cuadroOperaciones.setText(cuadroOperaciones.getText()+"+");
						sepuedeNumero = true;
						esSuma = true;
						contadorOperaciones += 1;
					}
				}
			}
		});
		btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
		btnSumar.setBounds(10, 189, 75, 75);
		contentPane.add(btnSumar);
		
		//LABEL RESTAR
		btnRestar = new JLabel("");
		btnRestar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botonesActivos == 1) {
					if (contadorOperaciones == 0){
						cuadroOperaciones.setText(cuadroOperaciones.getText()+"-");
						sepuedeNumero = true;
						esSuma = false;
						contadorOperaciones += 1;
					}
				}
			}
		});
		btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
		btnRestar.setBounds(351, 189, 75, 75);
		contentPane.add(btnRestar);
		
		//COMPROBAR
		btnComprobar = new JButton("COMPRUEBA");
		btnComprobar.setEnabled(true); //ACTIVAR O DESACTIVAR LOS BOTONES
		btnComprobar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (contadorNumeros > 1) {
					btnRepetir.setEnabled(true);
					if ((numerosAlmacenadosDados12 + 1) == operacion){
						cuadroResultado.setText("CORRECTO");
						btnComprobar.setEnabled(false);
						puntuacion += 5;
						lblPuntuacion.setText("PUNTUACION: "+puntuacion);
						label_1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_d_c.png")));
						label_2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_i_c.png")));
					}else {
						cuadroResultado.setText("INTENTALO DE NUEVO");
						btnComprobar.setEnabled(true);
						label_1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_i_e.png")));
						label_2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_d_e.png")));
					}
				}
				//SI LA PUNTUACION ES IGUAL A 50, TE PASAS EL JUEGO.
				if (puntuacion == 50) {
			        JOptionPane.showMessageDialog(contentPane, "¡ENHORABUENA HAS COMPLETADO EL JUEGO!");
			        btnRepetir.setEnabled(false);
			        btnComprobar.setEnabled(false);
					btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					botonesActivos = 0;
					cuadroResultado.setText("CERRAR VENTANA");
					label_1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					label_2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					dado1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado3.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado4.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado5.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
				}
			}
		});
		btnComprobar.setBounds(69, 333, 145, 33);
		contentPane.add(btnComprobar);
		
		//REPETIR
		btnRepetir = new JButton("REPETIR");
		btnRepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Botones();
				btnComprobar.setEnabled(true);
				btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
				btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
				botonesActivos = 0;
				btnRepetir.setEnabled(false);
				cuadroResultado.setText(null);
				label_1.setIcon(null);
				label_2.setIcon(null);
			}
		});
		btnRepetir.setEnabled(true); //ACTIVAR O DESACTIVAR LOS BOTONES
		btnRepetir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRepetir.setBounds(253, 333, 114, 33);
		contentPane.add(btnRepetir);
		
		cuadroResultado = new JTextField();
		cuadroResultado.setEditable(false);
		cuadroResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cuadroResultado.setHorizontalAlignment(SwingConstants.CENTER);
		cuadroResultado.setBounds(69, 377, 298, 33);
		contentPane.add(cuadroResultado);
		cuadroResultado.setColumns(10);
		
		btnRepetir.setEnabled(false);
		
		
		lblPuntuacion = new JLabel("PUNTUACION: "+ puntuacion);
		lblPuntuacion.setBounds(85, 56, 282, 19);
		lblPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPuntuacion);
		
		lblNuevoJuego = new JLabel("");
		lblNuevoJuego.setToolTipText("HACER CLICK AQUI PARA VOLVER A LA PAGINA PRINCIPAL");
		lblNuevoJuego.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/juegonuevo.png")));
		lblNuevoJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JuegoNuevo();
			}
		});
		lblNuevoJuego.setBounds(406, 11, 20, 20);
		contentPane.add(lblNuevoJuego);
		
		jugadorNick = new JLabel("NICK");
		jugadorNick.setHorizontalAlignment(SwingConstants.CENTER);
		jugadorNick.setFont(jugadorNick.getFont().deriveFont(jugadorNick.getFont().getStyle() | Font.BOLD));
		jugadorNick.setBounds(0, 73, 75, 19);
		contentPane.add(jugadorNick);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/perfil.png")));
		label.setBounds(0, 0, 75, 75);
		contentPane.add(label);
		
		//ESTOS DOS LABELS, SE LES PONE UNA IMAGEN DE DOS PULGARES CADA VEZ QUE ACIERTES O FALLES
		label_1 = new JLabel("");
		label_1.setBounds(377, 377, 30, 30);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(29, 377, 30, 30);
		contentPane.add(label_2);
		
		Botones();
		
	}

	//BOTON PARA ABRIR EL MENU PRINCIPAL Y CERRAR EL JUEGO
	private void JuegoNuevo() {
		Juego frame = new Juego();
		frame.setVisible(true);
		System.exit(0);
	}
	
	private void Botones() {
		//IMAGENES DADOS ALEATORIAS
		for (int i = 0; i < dados3.length; i++) {
			dados3[i] = new ImageIcon(getClass().getResource("ImagenesDados/dado"+String.valueOf(i+1)+"_3.png"));
		}
		for (int i = 0; i < dados6.length; i++) {
			dados6[i] = new ImageIcon(getClass().getResource("ImagenesDados/dado"+String.valueOf(i+1)+"_6.png"));
		}
		for (int i = 0; i < dados12.length; i++) {
			dados12[i] = new ImageIcon(getClass().getResource("ImagenesDados/dadodoce_"+String.valueOf(i+1)+".png"));
		}
		dadoGris = new ImageIcon(getClass().getResource("ImagenesDados/dadogris.png"));
		
		//DADOS
		// 3
		for (int i = 0; i < numerosAlmacenadosDados3.length; i++) {
		numerosAlmacenadosDados3[i] = dado.nextInt(3);
		}
		dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
		dado1.setName("1");
		dado1.addMouseListener(new Dados());
		
		dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
		dado2.setName("2");
		dado2.addMouseListener(new Dados());
		
		dado3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
		dado3.setName("3");
		dado3.addMouseListener(new Dados());
		
		// 6
		for (int i = 0; i < numerosAlmacenadosDados6.length; i++) {
		numerosAlmacenadosDados6[i] = dado.nextInt(6);
		}
		dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
		dado4.setName("4");
		dado4.addMouseListener(new Dados());
		
		dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
		dado5.setName("5");
		dado5.addMouseListener(new Dados());
		
		// 12
		numerosAlmacenadosDados12 = dado.nextInt(12);
		dado6.setIcon(dados12[numerosAlmacenadosDados12]);
		
		cuadroOperaciones.setText(" ");
		
		sepuedeNumero = true;
		operacion = 0;
		contadorNumeros = 0;
		esSuma = true;
	}
	
	private class Dados implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel dado = (JLabel) e.getSource();
			int numeroDado = Integer.valueOf(dado.getName());
			if (sepuedeNumero) {
				if (numeroDado < 4) {
					cuadroOperaciones.setText(cuadroOperaciones.getText()+String.valueOf(numerosAlmacenadosDados3[numeroDado-1]+1));
				}else {
					cuadroOperaciones.setText(cuadroOperaciones.getText()+String.valueOf(numerosAlmacenadosDados6[numeroDado-4]+1));
				}
				dado.removeMouseListener(this);
				dado.setIcon(dadoGris);
				sepuedeNumero = false;
				btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/suma.png")));
				btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/resta.png")));
				contadorOperaciones = 0;
				botonesActivos = 1;
				if (numeroDado < 4) {
					setOperacion(numerosAlmacenadosDados3[numeroDado-1]+1);
				}else {
					setOperacion(numerosAlmacenadosDados6[numeroDado-4]+1);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	private void setOperacion(int num) {
		contadorNumeros++;
		if (contadorNumeros > 1) {
			if(esSuma) {
				operacion += num;
			}else {
				operacion -=num;
			}
		}else {
			operacion = num;
		}
	}
	
	public void setJugador(Jugador jugador1) {
		this.jugador1 = jugador1;
		nombreJugador.setText("BIENVENIDO AL JUEGO: "+ jugador1.getNombre());
		jugadorNick.setText(jugador1.getNick());
	}
}
