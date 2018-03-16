package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import Principal.Principal;
import Ventanas.Juego;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JDialog;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField NOMBRE;
	private JTextField APELLIDOS;
	private JTextField EDAD;
	private JTextField CORREO;
	private JTextField NICKNAME;
	Jugador nick;
	Jugador jugador1 = new Jugador();
	Juego juego = new Juego();
	private Juego Juego;
	private JOptionPane advertencia;
	private VentanaPrincipal VentanaPrincipal = new VentanaPrincipal();
	
	//ESTOS CHECKBOX ESTAN POR DEFECTO SIN SELECCIONAR, CUANDO SE COMPLETA UN DATO, SE SELECCIONAN
	private JCheckBox checkBox_N, checkBox_A, checkBox_E, checkBox_C, checkBox_NICK, checkBox_M;
	
	//LABEL CUANDO HAY UN ERROR EN EL CAMPO
	private JLabel error_N, error_A, error_E, error_C, error_NICK, error_M;
	
	//VARIABLES DIFICULTAD
	private String dificultad;
	private JCheckBox checkFacil, checkDificil;
	private boolean checkActivo = false;
	private JTextField FACIL;
	private JLabel lblReiniciar;
	private JTextField txtFacil;
	private String espacioCentrar = "\u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020";
	private String espacioCentrar2 = "\u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020 \u0020";
	
	//VARIABLE TEMPORIZADOR DADO ON
	private String temporizadorDadosON;
	private JTextField txtTemporizador;
	
	private boolean esEmail(String email) {
		Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
	    Matcher m = p.matcher(email);
	    return m.matches();
	}
	private boolean esNumero(String cad) {
		try {
			Integer.parseInt(cad);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Create the frame.
	 */
	/**
	 * @param vJ
	 */
	public Login(Juego vJ){
		setResizable(false);
		setTitle("REGISTRO MATHDICE");
		Juego = vJ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		Principal();
	}
	
	public void Principal() {
		//INICIALIZAMOS LABELS Y CAMPOS DE TEXTO
				JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
				lblDatosDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
				lblDatosDelJugador.setFont(new Font("Arial", Font.BOLD, 14));
				lblDatosDelJugador.setBounds(81, 21, 162, 17);
				contentPane.add(lblDatosDelJugador);
				
				JLabel lblNombre = new JLabel("NOMBRE");
				lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
				lblNombre.setBounds(10, 143, 52, 15);
				contentPane.add(lblNombre);
				NOMBRE = new JTextField();
				NOMBRE.addActionListener(new ActionListener() {
					//CUANDO PULSAMOS INTRO SE GUARDAN LOS DATOS, SE SELECCIONAN LOS CHECKBOX Y SE DESACTIVAN LOS TEXTFIELD
					public void actionPerformed(ActionEvent e) {
						if (NOMBRE.getText().isEmpty()) {
							//NOMBRE
							NOMBRE.setEnabled(true);
							error_N.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
						}else {
							jugador1.setNombre(NOMBRE.getText());
							checkBox_N.setSelected(true);
							lblNombre.setEnabled(false);
							NOMBRE.setEnabled(false);
							error_N.setIcon(null);
						}
					}
				});
				NOMBRE.setBounds(84, 141, 218, 20);
				contentPane.add(NOMBRE);
				NOMBRE.setColumns(10);
				
				checkBox_N = new JCheckBox("");
				checkBox_N.setEnabled(false);
				checkBox_N.setBounds(308, 140, 21, 21);
				contentPane.add(checkBox_N);
				
				JLabel lblApellidos = new JLabel("APELLIDOS");
				lblApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
				lblApellidos.setBounds(10, 169, 66, 15);
				contentPane.add(lblApellidos);
				APELLIDOS = new JTextField();
				APELLIDOS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (APELLIDOS.getText().isEmpty()) {
							//APELLIDOS
							APELLIDOS.setEnabled(true);
							error_A.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
						}else {
							jugador1.setApellidos(APELLIDOS.getText());
							checkBox_A.setSelected(true);
							lblApellidos.setEnabled(false);
							APELLIDOS.setEnabled(false);
							error_A.setIcon(null);
						}
					}
				});
				APELLIDOS.setBounds(84, 167, 218, 20);
				contentPane.add(APELLIDOS);
				APELLIDOS.setColumns(10);
				
				checkBox_A = new JCheckBox("");
				checkBox_A.setEnabled(false);
				checkBox_A.setBounds(308, 166, 21, 21);
				contentPane.add(checkBox_A);
				
				JLabel lblEdad = new JLabel("EDAD");
				lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
				lblEdad.setBounds(10, 195, 33, 15);
				contentPane.add(lblEdad);
				EDAD = new JTextField();
				EDAD.addActionListener(new ActionListener() {
					//LISTENER QUE COMPRUEBA LA TECLA INTRO
					public void actionPerformed(ActionEvent e) {
						if (((esNumero(EDAD.getText()))==false) || (EDAD.getText().isEmpty())) {
							//EDAD
							EDAD.setEnabled(true);
							error_E.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
						}else {
							checkBox_E.setSelected(true);
							lblEdad.setEnabled(false);
							EDAD.setEnabled(false);
							error_E.setIcon(null);
							if(esNumero(EDAD.getText())==true) {
								jugador1.setEdad(Integer.parseInt(EDAD.getText()));
								}else {
									jugador1.setEdad(999);
								}
						}
					}
				});
				EDAD.setBounds(84, 193, 218, 20);
				contentPane.add(EDAD);
				EDAD.setColumns(10);
				
				checkBox_E = new JCheckBox("");
				checkBox_E.setEnabled(false);
				checkBox_E.setBounds(308, 192, 21, 21);
				contentPane.add(checkBox_E);
				
				JLabel lblCorreo = new JLabel("CORREO");
				lblCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
				lblCorreo.setBounds(10, 221, 53, 15);
				contentPane.add(lblCorreo);
				CORREO = new JTextField();
				CORREO.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (CORREO.getText().isEmpty() || (esEmail(CORREO.getText()))==false) {
							//CORREO
							error_C.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
							CORREO.setEnabled(true);
						}else {
							jugador1.setCorreo(CORREO.getText());
							checkBox_C.setSelected(true);
							lblCorreo.setEnabled(false);
							CORREO.setEnabled(false);
							error_C.setIcon(null);
						}
					}
				});
				CORREO.setBounds(84, 219, 218, 20);
				contentPane.add(CORREO);
				CORREO.setColumns(10);
				
				checkBox_C = new JCheckBox("");
				checkBox_C.setEnabled(false);
				checkBox_C.setBounds(308, 218, 21, 21);
				contentPane.add(checkBox_C);
				
				JLabel lblNickname = new JLabel("NICKNAME");
				lblNickname.setFont(new Font("Arial", Font.PLAIN, 12));
				lblNickname.setBounds(10, 247, 62, 15);
				contentPane.add(lblNickname);
				NICKNAME = new JTextField();
				NICKNAME.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (NICKNAME.getText().isEmpty()) { 
							//NICK
							error_NICK.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
							NICKNAME.setEnabled(true);
						}else {
							jugador1.setNick(NICKNAME.getText());
							checkBox_NICK.setSelected(true);
							lblNickname.setEnabled(false);
							NICKNAME.setEnabled(false);
							error_NICK.setIcon(null);
						}
					}
				});
				NICKNAME.setToolTipText("Nombre del jugador dentro del juego.");
				NICKNAME.setBounds(84, 245, 218, 20);
				contentPane.add(NICKNAME);
				NICKNAME.setColumns(10);
				
				checkBox_NICK = new JCheckBox("");
				checkBox_NICK.setEnabled(false);
				checkBox_NICK.setBounds(308, 244, 21, 21);
				contentPane.add(checkBox_NICK);
				
				//CAMPO DE TEXTO INVISIBLE PARA OBTENER LA VARIABLE DIFICULTAD
				txtFacil = new JTextField();
				txtFacil.setName("0");
				contentPane.add(txtFacil);
				txtFacil.setColumns(10);
				
				JLabel lblmodo = new JLabel("MODO");
				lblmodo.setFont(new Font("Arial", Font.PLAIN, 12));
				lblmodo.setBounds(11, 104, 52, 15);
				contentPane.add(lblmodo);
				
				checkFacil = new JCheckBox("FÁCIL (1 MINUTO)");
				checkFacil.setName(null);
				checkFacil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (checkActivo == false) {
							checkFacil.setEnabled(false);
							checkDificil.setEnabled(false);
							checkActivo = true;
							txtFacil.setName("0");
							jugador1.setDificultad(txtFacil.getName()); //ENVIAR DATOS
							checkBox_M.setSelected(true);
							checkDificil.setSelected(true);
							lblmodo.setEnabled(false);
						}
					}
				});
				checkFacil.setBounds(84, 86, 218, 23);
				contentPane.add(checkFacil);
				
				checkDificil = new JCheckBox("DIFICIL (40 SEGUNDOS)");
				checkDificil.setName(null);
				checkDificil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (checkActivo == false) {
							checkFacil.setEnabled(false);
							checkDificil.setEnabled(false);
							checkActivo = true;
							txtFacil.setName("1");
							jugador1.setDificultad(txtFacil.getName()); //ENVIAR DATOS
							checkBox_M.setSelected(true);
							checkFacil.setSelected(true);
							lblmodo.setEnabled(false);
						}
					}
				});
				checkDificil.setBounds(84, 111, 218, 23);
				contentPane.add(checkDificil);
				
				//CAMPO DE TEXTO INVISIBLE PARA OBTENER LA VARIABLE DE ACTIVACION DEL TEMPORIZADOR
				txtTemporizador = new JTextField();
				txtTemporizador.setName("1");
				contentPane.add(txtTemporizador);
				txtTemporizador.setColumns(10);

				JButton btnCrearJugador = new JButton("CREAR JUGADOR");
				btnCrearJugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if ((NOMBRE.getText().isEmpty()) || (APELLIDOS.getText().isEmpty()) || (NICKNAME.getText().isEmpty()) || (CORREO.getText().isEmpty()) || (!checkDificil.isSelected()) || (!checkFacil.isSelected()) ) {
							error_N.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
							error_A.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
							error_E.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
							error_C.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
							error_NICK.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
							error_M.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					        JOptionPane.showMessageDialog(contentPane, "¡RELLENA TODOS LOS CAMPOS!");
						}else{
							VentanaPrincipal.setVisible(true); //ABRIR LA VENTANA DEL JUEGO
							jugador1 = new Jugador(); //CREAMOS EL JUGADOR
							jugador1.setNombre(NOMBRE.getText());
							jugador1.setNick(NICKNAME.getText());
							jugador1.setApellidos(APELLIDOS.getText());
							jugador1.setCorreo(CORREO.getText());
							jugador1.setEdad(Integer.parseInt(EDAD.getText()));
							jugador1.setDificultad(txtFacil.getName());
							setVisible(false); //CERRAMOS LA VENTANA DE LOGIN
							
							//MENSAJE DE AVISO ANTES DE EMPEZAR EL JUEGO
					        JOptionPane.showMessageDialog(contentPane, espacioCentrar + "¡BIENVENIDO A MATHDICE! \n"
					        		+ espacioCentrar2 +"¡¡IMPORTANTE LEER ANTES DE JUGAR!!"
					        		+ "\n"
					        		+ "\nOBTENER EL NUMERO DEL DADO DE 12 CARAS (AZUL CLARO)"
					        		+ "\nREALIZANDO LAS OPERACIONES NECESARIAS. CUANDO LA "
					        		+ "\nPUNTUACION ALCANZA 30, GANAS. DEBES EMPEZAR CON LAS "
					        		+ "\nOPERACIONES SIMPLES (+) O (-)."
					        		+ "\n"
					        		+ "\n¡¡EN 10 SEGUNDOS SE INICIA LA PARTIDA AUTOMATICAMENTE!!");
					        
					        //AL DARLE ACEPTAR AL MENSAJE DE AVISO ACTIVAMOS EL TEMPORIZADOR
					        int opcion = JOptionPane.OK_OPTION;
							if (opcion==JOptionPane.OK_OPTION){
								txtTemporizador.setName("0");
								jugador1.setActivarTemporizador(txtTemporizador.getName());
								VentanaPrincipal.setJugador(jugador1);
								
								//SONIDOS DE DADOS
								ReproducirSonido("src/Sonidos/dados_1.wav");
							}	
						}
					}


				});
				btnCrearJugador.setBounds(119, 276, 145, 46);
				contentPane.add(btnCrearJugador);
				
				//ADVERTENCIA DE PULSAR INTRO CADA VEZ QUE INTRODUCIMOS UN DATO
				JLabel lblpulsarIntroCada = new JLabel("(PULSAR INTRO CADA VEZ QUE INTRODUZCAMOS UN DATO)");
				lblpulsarIntroCada.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/avatar.png")));
				lblpulsarIntroCada.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
				lblpulsarIntroCada.setBackground(Color.WHITE);
				lblpulsarIntroCada.setBounds(9, 7, 379, 75);
				contentPane.add(lblpulsarIntroCada);
				
				//LABELS EN LOS QUE SE PONE LA IMAGEN DE UNA CRUZ ROJA DE ERROR CADA VEZ QUE HAY UN ERROR EN EL CAMPO CORRESPONDIENTE
				error_N = new JLabel("");
				error_N.setBounds(335, 138, 20, 20);
				contentPane.add(error_N);
				
				error_A = new JLabel("");
				error_A.setBounds(335, 166, 20, 20);
				contentPane.add(error_A);
				
				error_E = new JLabel("");
				error_E.setBounds(335, 192, 20, 20);
				contentPane.add(error_E);
				
				error_C = new JLabel("");
				error_C.setBounds(335, 218, 20, 20);
				contentPane.add(error_C);
				
				error_NICK = new JLabel("");
				error_NICK.setBounds(335, 244, 20, 20);
				contentPane.add(error_NICK);
				
				checkBox_M = new JCheckBox("");
				checkBox_M.setEnabled(false);
				checkBox_M.setBounds(308, 101, 21, 21);
				contentPane.add(checkBox_M);
				
				error_M = new JLabel("");
				error_M.setBounds(335, 101, 20, 20);
				contentPane.add(error_M);
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
}