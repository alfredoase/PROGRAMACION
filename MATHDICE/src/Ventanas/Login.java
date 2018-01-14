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
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

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
	
	//ESTOS CHECKBOX ESTAN POR DEFECTO SIN SELECCIONAR, CUANDO SE COMPLETA UN DATO, SE SELECCIONAN
	private JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
	
	//LABEL CUANDO HAY UN ERROR EN EL CAMPO
	private JLabel error1, error2, error3, error4, error5;
	
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
	public Login(Juego vJ){
		setResizable(false);
		setTitle("REGISTRO MATHDICE");
		Juego = vJ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
		lblDatosDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelJugador.setFont(new Font("Arial", Font.BOLD, 14));
		lblDatosDelJugador.setBounds(81, 21, 162, 17);
		contentPane.add(lblDatosDelJugador);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 93, 52, 15);
		contentPane.add(lblNombre);
		NOMBRE = new JTextField();
		NOMBRE.addActionListener(new ActionListener() {
			//CUANDO PULSAMOS INTRO SE GUARDAN LOS DATOS, SE SELECCIONAN LOS CHECKBOX Y SE DESACTIVAN LOS TEXTFIELD
			public void actionPerformed(ActionEvent e) {
				jugador1.setNombre(NOMBRE.getText());
				checkBox1.setSelected(true);
				lblNombre.setEnabled(false);
				NOMBRE.setEnabled(false);
				error1.setIcon(null);
			}
		});
		NOMBRE.setBounds(84, 91, 218, 20);
		contentPane.add(NOMBRE);
		NOMBRE.setColumns(10);
		
		checkBox1 = new JCheckBox("");
		checkBox1.setEnabled(false);
		checkBox1.setBounds(308, 90, 21, 21);
		contentPane.add(checkBox1);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidos.setBounds(10, 119, 66, 15);
		contentPane.add(lblApellidos);
		APELLIDOS = new JTextField();
		APELLIDOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setApellidos(APELLIDOS.getText());
				checkBox2.setSelected(true);
				lblApellidos.setEnabled(false);
				APELLIDOS.setEnabled(false);
				error2.setIcon(null);
			}
		});
		APELLIDOS.setBounds(84, 117, 218, 20);
		contentPane.add(APELLIDOS);
		APELLIDOS.setColumns(10);
		
		checkBox2 = new JCheckBox("");
		checkBox2.setEnabled(false);
		checkBox2.setBounds(308, 114, 21, 21);
		contentPane.add(checkBox2);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEdad.setBounds(10, 145, 33, 15);
		contentPane.add(lblEdad);
		EDAD = new JTextField();
		EDAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBox3.setSelected(true);
				lblEdad.setEnabled(false);
				EDAD.setEnabled(false);
				error3.setIcon(null);
				if(esNumero(EDAD.getText())==true) {
					jugador1.setEdad(Integer.parseInt(EDAD.getText()));
					}else {
						jugador1.setEdad(999);
					}
			}
		});
		EDAD.setBounds(84, 143, 218, 20);
		contentPane.add(EDAD);
		EDAD.setColumns(10);
		
		checkBox3 = new JCheckBox("");
		checkBox3.setEnabled(false);
		checkBox3.setBounds(308, 142, 21, 21);
		contentPane.add(checkBox3);
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 171, 53, 15);
		contentPane.add(lblCorreo);
		CORREO = new JTextField();
		CORREO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setCorreo(CORREO.getText());
				checkBox4.setSelected(true);
				lblCorreo.setEnabled(false);
				CORREO.setEnabled(false);
				error4.setIcon(null);
			}
		});
		CORREO.setBounds(84, 169, 218, 20);
		contentPane.add(CORREO);
		CORREO.setColumns(10);
		
		checkBox4 = new JCheckBox("");
		checkBox4.setEnabled(false);
		checkBox4.setBounds(308, 168, 21, 21);
		contentPane.add(checkBox4);
		
		JLabel lblNickname = new JLabel("NICKNAME");
		lblNickname.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNickname.setBounds(10, 197, 62, 15);
		contentPane.add(lblNickname);
		NICKNAME = new JTextField();
		NICKNAME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setNick(NICKNAME.getText());
				checkBox5.setSelected(true);
				lblNickname.setEnabled(false);
				NICKNAME.setEnabled(false);
				error5.setIcon(null);
			}
		});
		NICKNAME.setToolTipText("Nombre del jugador dentro del juego.");
		NICKNAME.setBounds(84, 195, 218, 20);
		contentPane.add(NICKNAME);
		NICKNAME.setColumns(10);
		
		checkBox5 = new JCheckBox("");
		checkBox5.setEnabled(false);
		checkBox5.setBounds(308, 194, 21, 21);
		contentPane.add(checkBox5);
		
		//EN LA ULTIMA VERSION, EL TEXT AREA NO HACE FALTA
//		cuadro_muestra = new JTextArea();
//		cuadro_muestra.setEditable(false);
//		cuadro_muestra.setFont(new Font("Arial", Font.BOLD, 12));
//		cuadro_muestra.setBackground(new Color(0, 51, 51));
//		cuadro_muestra.setForeground(Color.WHITE);
//		cuadro_muestra.setBounds(356, 46, 308, 121);
//		contentPane.add(cuadro_muestra);

		JButton btnCrearJugador = new JButton("CREAR JUGADOR");
		btnCrearJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((NOMBRE.getText().isEmpty()) && (APELLIDOS.getText().isEmpty()) && (NICKNAME.getText().isEmpty()) && (CORREO.getText().isEmpty()) ) {
					error1.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					error2.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					error3.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					error4.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					error5.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
			        JOptionPane.showMessageDialog(contentPane, "¡RELLENA TODOS LOS CAMPOS!");
				}else if (NOMBRE.getText().isEmpty()) {
					//NOMBRE
					NOMBRE.setEnabled(true);
					error1.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
				}else if (APELLIDOS.getText().isEmpty()) {
					//APELLIDOS
					APELLIDOS.setEnabled(true);
					error2.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
				}else if (((esNumero(EDAD.getText()))==false) || (EDAD.getText().isEmpty())) {
					//EDAD
					EDAD.setEnabled(true);
					error3.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
				}else if (CORREO.getText().isEmpty() || (esEmail(CORREO.getText()))==false) {
					//CORREO
					error4.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					CORREO.setEnabled(true);
				}else if (NICKNAME.getText().isEmpty()) { 
					//NICK
					error5.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/fallo.png")));
					NICKNAME.setEnabled(true);
				}else {
					Juego.setVisible(true); //ABRIR LA VENTANA DEL JUEGO
					jugador1 = new Jugador(); //CREAMOS EL JUGADOR
					jugador1.setNombre(NOMBRE.getText());
					jugador1.setNick(NICKNAME.getText());
					Juego.setJugador(jugador1); 
					setVisible(false); //CERRAMOS LA VENTANA DE LOGIN
					
					//MENSAJE DE AVISO ANTES DE EMPEZAR EL JUEGO
			        JOptionPane.showMessageDialog(contentPane, "¡BIENVENIDO A MATHDICE!"
			        		+ "\nIMPORTANTE LEER ANTES DE JUGAR"
			        		+ "\nEL FUNCIONAMIENTO DEL JUEGO ES "
			        		+ "\nEL SIGUIENTE: OBTENER EL NUMERO "
			        		+ "\nDEL DADO DE 12 CARAS (AZUL CLARO)"
			        		+ "\nCON LOS DADOS DE ARRIBA (MINIMO 2)"
			        		+ "\nREALIZANDO LAS OPERACIONES NECESARIAS."
			        		+ "\nCUANDO LA PUNTUACION ALCANZA 50, GANAS.");
				}
			}


		});
		btnCrearJugador.setBounds(119, 226, 145, 46);
		contentPane.add(btnCrearJugador);
		
		//ADVERTENCIA DE PULSAR INTRO CADA VEZ QUE INTRODUCIMOS UN DATO
		JLabel lblpulsarIntroCada = new JLabel("(PULSAR INTRO CADA VEZ QUE INTRODUZCAMOS UN DATO)");
		lblpulsarIntroCada.setIcon(new ImageIcon(Login.class.getResource("/Ventanas/ImagenesDados/avatar.png")));
		lblpulsarIntroCada.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lblpulsarIntroCada.setBackground(Color.WHITE);
		lblpulsarIntroCada.setBounds(9, 7, 379, 75);
		contentPane.add(lblpulsarIntroCada);
		
		error1 = new JLabel("");
		error1.setBounds(335, 89, 20, 20);
		contentPane.add(error1);
		
		error2 = new JLabel("");
		error2.setBounds(335, 117, 20, 20);
		contentPane.add(error2);
		
		error3 = new JLabel("");
		error3.setBounds(335, 143, 20, 20);
		contentPane.add(error3);
		
		error4 = new JLabel("");
		error4.setBounds(335, 169, 20, 20);
		contentPane.add(error4);
		
		error5 = new JLabel("");
		error5.setBounds(335, 195, 20, 20);
		contentPane.add(error5);

		
	}
}