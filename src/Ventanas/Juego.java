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
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import javax.swing.JToolBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private boolean esSuma = false;
	private boolean esResta = false;
	private int contadorOperaciones = 0;
	private int botonesActivos = 0;
	private int temporizadorOn = 0;
	private boolean esMultiplicacion = false;
	private boolean esDivision = false;
	private boolean sePuedenOtras = false;
	
	//DATOS JUGADOR
	private int puntuacion = 0;
	JLabel lblNewLabel;
	Jugador jugador1;
	Jugador nick;
	Jugador dificultad;
		
	private JLabel dado1, dado2, dado3;
	private JLabel dado4, dado5;
	private JLabel dado6;
	private JLabel btnSumar, btnRestar, lblPuntuacion, btnMultiplicar, btnDividir;
	private JTextField cuadroResultado;
	private JButton btnRepetir, btnComprobar;
	private JLabel lblNuevoJuego;
	private JLabel nombreJugador, jugadorNick;
	private JLabel label;
	private JLabel label_1, label_2;
	private Timer temporizador;
	private JLabel reloj;
	private int seg, min;
	private JLabel dif;
	
	
	//VARIABLE DIFICULTAD
	public int numDificultad;
	
	//LIMITE TIEMPO SEGUN DIFICULTAD
	private int limiteTemp = 0;
	private JLabel label_3;
	
	//ANIMACION DADOS
	Timer temporizador_dados;
	private int segD;
	Jugador temporizadorDadosON;
	public int numTemporizador;
	
	//VARIABLE DE RONDAS GANADAS
	private int rondasGanadas = 0;
	
	//TEMPORIZADOR SI NO SE HACE CLICK EN 10 SEGUNDOS, SE HACE UNA TIRADA SOLA
	Timer temporizador_inicio;
	private int segI = 0;
	private int temporizadorOn2 = 0;
	
	//REPRODUCIR 1 SOLA VEZ
	private int start = 0;
	
	private int num = 0;
	
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
		
		//CREAMOS LOS LABELS DE LOS DADOS PARA DARLE USO POSTERIORMENTE
		dado1 = new JLabel("");
		dado1.setBounds(10, 103, 75, 75);
		dado1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_r.gif")));
		contentPane.add(dado1);
		
		dado2 = new JLabel("");
		dado2.setBounds(96, 103, 75, 75);
		dado2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_r.gif")));
		contentPane.add(dado2);
		
		dado3 = new JLabel("");
		dado3.setBounds(181, 103, 75, 75);
		dado3.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_r.gif")));
		contentPane.add(dado3);
		
		dado4 = new JLabel("");
		dado4.setBounds(266, 103, 75, 75);
		dado4.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_a.gif")));
		contentPane.add(dado4);
		
		dado5 = new JLabel("");
		dado5.setBounds(351, 103, 75, 75);
		dado5.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_a.gif")));
		contentPane.add(dado5);
		
		dado6 = new JLabel("");
		dado6.setBounds(174, 189, 87, 87);
		dado6.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_a.gif")));
		contentPane.add(dado6);

		//LABEL DEL JUGADOR
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
		btnSumar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_A) {
					System.out.println("Presionó Enter");
				}
			}
		});
		btnSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botonesActivos == 1) {
					if (contadorOperaciones == 0){
						cuadroOperaciones.setText(cuadroOperaciones.getText()+"+");
						sepuedeNumero = true;
						esSuma = true;
						sePuedenOtras = true;
						contadorOperaciones += 1;
						btnMultiplicar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/mult.png")));
						btnDividir.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/div.png")));
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
						esResta = true;
						sePuedenOtras = true;
						contadorOperaciones += 1;
						btnMultiplicar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/mult.png")));
						btnDividir.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/div.png")));
					}
				}
			}
		});
		btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
		btnRestar.setBounds(351, 189, 75, 75);
		contentPane.add(btnRestar);
		
		//BOTON MULTIPLICAR (SOLO SE VE SI LA DIFICULTAD ES DIFICIL)
		btnMultiplicar = new JLabel("");
		btnMultiplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botonesActivos == 1) {
					if ((contadorOperaciones == 0)&&(sePuedenOtras)){
						cuadroOperaciones.setText(cuadroOperaciones.getText()+"x");
						sepuedeNumero = true;
						esMultiplicacion = true;
						contadorOperaciones += 1;
					}
				}
			}
		});
		btnMultiplicar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
		contentPane.add(btnMultiplicar);
		
		//BOTON DIVIDIR (SOLO SE VE SI LA DIFICULTAD ES DIFICIL)
		btnDividir = new JLabel("");
		btnDividir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botonesActivos == 1) {
					if ((contadorOperaciones == 0)&&(sePuedenOtras)){
						cuadroOperaciones.setText(cuadroOperaciones.getText()+"/");
						sepuedeNumero = true;
						esDivision = true;
						contadorOperaciones += 1;
					}
				}
			}
		});
		btnDividir.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
		contentPane.add(btnDividir);
		
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
						temporizador.stop();
						rondasGanadas += 1;
						ReproducirSonido("src/Sonidos/acierto.wav");
						if (puntuacion == 30) {
							ReproducirSonido("src/Sonidos/completado.wav");
						}
					}else {
						cuadroResultado.setText("INTENTALO DE NUEVO");
						btnComprobar.setEnabled(true);
						label_1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_i_e.png")));
						label_2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_d_e.png")));
						temporizador.stop();
						ReproducirSonido("src/Sonidos/fallo.wav");
					}
				}
				//SI LA PUNTUACION ES IGUAL A 50, TE PASAS EL JUEGO.
				if (puntuacion == 50) {
			        btnRepetir.setEnabled(false);
			        btnComprobar.setEnabled(false);
					btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					btnMultiplicar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					btnDividir.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					botonesActivos = 0;
					cuadroResultado.setText("CERRAR VENTANA");
					label_1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					label_2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					dado1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado3.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado4.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
					dado5.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
			        JOptionPane.showMessageDialog(contentPane, "¡ENHORABUENA HAS COMPLETADO EL JUEGO!");
				}
			}
		});
		btnComprobar.setBounds(69, 333, 174, 33);
		contentPane.add(btnComprobar);
		
		//REPETIR
		btnRepetir = new JButton("REPETIR");
		btnRepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (numTemporizador == 0){
					temporizador_dados.restart();
					temporizador_dados.start();
					temporizador_dados.setInitialDelay(400);
					AnimacionDados();
					segD = 0;
					segI = 0;
					dado1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_r.gif")));
					dado2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_r.gif")));
					dado3.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_r.gif")));
					dado4.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_a.gif")));
					dado5.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_a.gif")));
					dado6.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dado_a.gif")));
				}

				btnComprobar.setEnabled(true);
				btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
				btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
				btnMultiplicar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
				btnDividir.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/dadogris.png")));
				botonesActivos = 0;
				btnRepetir.setEnabled(false);
				cuadroResultado.setText(null);
				label_1.setIcon(null);
				label_2.setIcon(null);
				
				temporizadorOn = 0;
				reloj.setText("TIEMPO: 00:00");
				
				//SONIDOS DE DADOS
				ReproducirSonido("src/Sonidos/dados_1.wav");
				
				//SI RONDAS GANADAS ES MAYOR O IGUAL QUE 2 BAJAMOS EL TIEMPO PARA AUMENTAR A DIFICULTAD
				//Y EL TIEMPO DEPENDE DE LA DIFICULTAD ESCOGIDA
				if (rondasGanadas >= 2) {
					if (numDificultad == 0) {
						limiteTemp = 40;
					}
					if (numDificultad >= 1) {
						limiteTemp = 30;
					}
				}
			}
		});
		btnRepetir.setEnabled(true); //ACTIVAR O DESACTIVAR LOS BOTONES
		btnRepetir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRepetir.setBounds(253, 333, 114, 33);
		contentPane.add(btnRepetir);
		
		cuadroResultado = new JTextField();
		cuadroResultado.setForeground(Color.BLACK);
		cuadroResultado.setEditable(false);
		cuadroResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cuadroResultado.setHorizontalAlignment(SwingConstants.CENTER);
		cuadroResultado.setBounds(69, 377, 298, 33);
		contentPane.add(cuadroResultado);
		cuadroResultado.setColumns(10);
		
		//POR DEFECTO EL BOTON REPETIR ESTA DESACTIVADO
		btnRepetir.setEnabled(false);
		
		
		lblPuntuacion = new JLabel("PUNTUACION: "+ puntuacion);
		lblPuntuacion.setBounds(85, 56, 171, 19);
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
		
		reloj = new JLabel("TIEMPO: 00:00");
		reloj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reloj.setBounds(315, 55, 111, 20);
		contentPane.add(reloj);
		
		dif = new JLabel("DIFICULTAD");
		dif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dif.setBounds(89, 24, 221, 26);
		contentPane.add(dif);
		
		//INVOCAMOS AL METODO ANIMACIONDADOS QUE LLEVA LOS DADOS
		AnimacionDados();
		
	}
	
	//BOTON PARA ABRIR EL MENU PRINCIPAL Y CERRAR EL JUEGO
	private void JuegoNuevo() {
		Juego frame = new Juego();
		frame.setVisible(true);
		System.exit(0);
	}
	
	public void setJugador(Jugador jugador1) {
		this.jugador1 = jugador1;
		nombreJugador.setText("BIENVENIDO AL JUEGO: "+ jugador1.getNombre());
		jugadorNick.setText(jugador1.getNick());
		numDificultad = Integer.valueOf(jugador1.getDificultad());
		numTemporizador = Integer.valueOf(jugador1.getActivarTemporizador());
		Dificultad();
		ActivarTemporizador();
	}
	
	public void temporizadorInicio() {
		temporizador_inicio = new Timer (1000, new ActionListener (){ 
			public void actionPerformed(ActionEvent e){ 
				segI++;
				if (segI == 10) {
					if (temporizadorOn == 0) {
						Temporizador();
						temporizador.restart();
						temporizador.start();
						temporizadorOn = 1;
						btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/suma.png")));
						btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/resta.png")));
						
						temporizador_inicio.stop();
					}
				}
		    }
		});
	}
	
	public void ActivarTemporizador() {
		if (numTemporizador == 0){
			temporizador_dados.restart();
			temporizador_dados.start();
			temporizador_dados.setInitialDelay(400);
		}
	}
	

	
	//CAMBIAMOS DIFERENTES VARIABLES PARA TENER DIFERENTES OPCIONES
	//DE JUEGO SEGUN LA DIFICULTAD ELEGIDA EN LA PANTALLA DE LOGIN
	public void Dificultad(){
		//DIFICULTAD FACIL
		if (numDificultad == 0) {
			dif.setText("MODO: SENCILLO");
			limiteTemp = 59;
		}
		//DIFICULTAD DIFICIL
		if (numDificultad == 1) {
			dif.setText("MODO: AVANZADO");
			limiteTemp = 40;
			
			//AÑADIMOS BOTONES DE MULTIPLICAR Y DIVIDIR
			btnMultiplicar.setBounds(85, 189, 75, 75);
			btnDividir.setBounds(276, 189, 75, 75);
		}
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
		
		for (int i = 0; i < numerosAlmacenadosDados3.length; i++) {
		numerosAlmacenadosDados3[i] = dado.nextInt(3);
		}
		
		for (int i = 0; i < numerosAlmacenadosDados6.length; i++) {
		numerosAlmacenadosDados6[i] = dado.nextInt(6);
		}
		
		cuadroOperaciones.setText(" ");
		
		sepuedeNumero = true;
		operacion = 0;
		contadorNumeros = 0;
		esSuma = true;
	}
	
	public void AnimacionDados() {
		Botones();
		temporizador_dados = new Timer (1000, new ActionListener (){ 
			public void actionPerformed(ActionEvent e){ 
				segD++;
				if (segD == 4){
					//DADOS
					// 1
					dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
					dado1.setName("1");
				}
				if (segD == 4){
					//DADOS
					// 2
					dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
					dado2.setName("2");
				}
				if (segD == 4){
					//DADOS
					// 3
					dado3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
					dado3.setName("3");
				}
				if (segD == 4){
					// 4
					dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
					dado4.setName("4");
				}
				if (segD == 4){
					// 5
					dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
					dado5.setName("5");
				}
				if (segD == 4) {
					// 12
					numerosAlmacenadosDados12 = dado.nextInt(12);
					dado6.setIcon(dados12[numerosAlmacenadosDados12]);
					temporizador_dados.stop();
					numTemporizador = 0;
					
					//AÑADIMOS LOS LISTENER AL FINAL PARA EVITAR QUE SE EMPIECE ANTES DE QUE ACABE LA ANIMACION
					dado1.addMouseListener(new Dados());
					dado2.addMouseListener(new Dados());
					dado3.addMouseListener(new Dados());
					dado4.addMouseListener(new Dados());
					dado5.addMouseListener(new Dados());
					
					//SI EN 10 SEGUNDOS NO SE DA CLICK A UN DADO SE INICIA LA PARTIDA
					temporizadorInicio();
					temporizador_inicio.start();
				}
		    }
		});
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
				//SE PONEN LOS ICONOS CUANDO SE HACE CLICK EN UN DADO
				btnSumar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/suma.png")));
				btnRestar.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/resta.png")));
				contadorOperaciones = 0;
				botonesActivos = 1;
				ReiniciarTemporizador();
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
		//SE ACTIVA EL TEMPORIZADOR CUANDO LE DAMOS AL BOTON ACEPTAR DEL AVISO DE INICIO
		public void ReiniciarTemporizador(){
			if (temporizadorOn == 0) {
				Temporizador();
				temporizador.restart();
				temporizador.start();
				temporizadorOn = 1;
			}
		}
	}
	
	
	public void Temporizador() {
		temporizador = new Timer (1000, new ActionListener (){
		int seg = 0;
		int min = 0;
		int son1 = 0;
		int son2 = 0;
			public void actionPerformed(ActionEvent arg0){ 
				seg++;
				ReproducirSonido("src/Sonidos/tick_1.wav");
				if (seg < 10){
					reloj.setText("TIEMPO: 00:0"+seg);
				}
				if (seg >= 10){
					reloj.setText("TIEMPO: 00:"+seg);
				}
				if (seg == (limiteTemp / 2)) {
					cuadroResultado.setText("TE QUEDAN "+(limiteTemp - seg)+" SEGUNDOS");
					cuadroResultado.setForeground(Color.RED);
					label_1.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_i_e.png")));
					label_2.setIcon(new ImageIcon(Juego.class.getResource("/Ventanas/ImagenesDados/pulgar_d_e.png")));
					Reproducir("src/Sonidos/camp.wav");
					start = 1;
				}
				if ((seg == 21)||(seg == 31)) {
					label_1.setIcon(null);
					label_2.setIcon(null);
					cuadroResultado.setText(null);
					cuadroResultado.setForeground(Color.BLACK);
					cuadroResultado.setFont(new Font("Tahoma", Font.BOLD, 20));
				}
				if (seg == limiteTemp) {
					min = 1;
					reloj.setText("TIEMPO: 0"+min+":00");
					
					ReproducirSonido("src/Sonidos/camp.wav");
					ReproducirSonido("src/Sonidos/fallo.wav");
					
					temporizador.stop();
					//MENSAJE DE TIEMPO ACABADO
			        JOptionPane.showMessageDialog(contentPane, "¡¡SE ACABO EL TIEMPO!!");
			        btnRepetir.setEnabled(true);
			        btnComprobar.setEnabled(false);
				}
			}
		});
	}
	
    public void ReproducirSonido(String nombreSonido){
        try {
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.start();
        }
        catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
          System.out.println("Error al reproducir el sonido.");
        }
    }
	public void Reproducir(String sonido) {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sonido).getAbsoluteFile());
	        Clip clip1 = AudioSystem.getClip();
	        clip1.open(audioInputStream);
	        if (start == 0) {
	        	clip1.start();
	        	start = 1;
	        }
	    }catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	    	System.out.println("Error al reproducir el sonido.");
	    }
	}
    
	private void setOperacion(int num) {
		contadorNumeros++;
		if (contadorNumeros > 1) {
			if (esSuma) {
				operacion += num;
				esSuma = false;
			}
			if (esResta){
				operacion -=num;
				esResta = false;
			}
			if ((esMultiplicacion)&&(sePuedenOtras)) {
				operacion *=num;
				esMultiplicacion = false;
			}
			if ((esDivision)&&(sePuedenOtras)) {
				operacion /= num;
				esDivision = false;
			}
		}else {
			operacion = num;
		}
	}
}
