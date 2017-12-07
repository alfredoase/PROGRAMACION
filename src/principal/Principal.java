package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego1.Jugador;

import javax.swing.JLabel;
import java.awt.Font;
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

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField NOMBRE;
	private JTextField APELLIDOS;
	private JTextField EDAD;
	private JTextField CORREO;
	private JTextField NICKNAME;
	Jugador jugador1 = new Jugador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
		lblDatosDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelJugador.setFont(new Font("Arial", Font.BOLD, 14));
		lblDatosDelJugador.setBounds(234, 11, 162, 17);
		contentPane.add(lblDatosDelJugador);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 48, 52, 15);
		contentPane.add(lblNombre);
		NOMBRE = new JTextField();
		NOMBRE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setNombre(NOMBRE.getText());
			}
		});
		NOMBRE.setBounds(84, 46, 218, 20);
		contentPane.add(NOMBRE);
		NOMBRE.setColumns(10);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidos.setBounds(10, 74, 66, 15);
		contentPane.add(lblApellidos);
		APELLIDOS = new JTextField();
		APELLIDOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setApellidos(APELLIDOS.getText());
			}
		});
		APELLIDOS.setBounds(84, 72, 218, 20);
		contentPane.add(APELLIDOS);
		APELLIDOS.setColumns(10);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEdad.setBounds(10, 100, 33, 15);
		contentPane.add(lblEdad);
		EDAD = new JTextField();
		EDAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(esNumero(EDAD.getText())==true) {
					jugador1.setEdad(Integer.parseInt(EDAD.getText()));
					}else {
						jugador1.setEdad(999);
					}
			}
		});
		EDAD.setBounds(84, 98, 218, 20);
		contentPane.add(EDAD);
		EDAD.setColumns(10);
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 126, 53, 15);
		contentPane.add(lblCorreo);
		CORREO = new JTextField();
		CORREO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setCorreo(CORREO.getText());
			}
		});
		CORREO.setBounds(84, 124, 218, 20);
		contentPane.add(CORREO);
		CORREO.setColumns(10);
		
		JLabel lblNickname = new JLabel("NICKNAME");
		lblNickname.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNickname.setBounds(10, 152, 62, 15);
		contentPane.add(lblNickname);
		NICKNAME = new JTextField();
		NICKNAME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setNick(NICKNAME.getText());
			}
		});
		NICKNAME.setToolTipText("Nombre del jugador dentro del juego.");
		NICKNAME.setBounds(84, 150, 218, 20);
		contentPane.add(NICKNAME);
		NICKNAME.setColumns(10);
		
		JTextArea cuadro_muestra = new JTextArea();
		cuadro_muestra.setFont(new Font("Arial", Font.BOLD, 12));
		cuadro_muestra.setBackground(new Color(0, 51, 51));
		cuadro_muestra.setForeground(Color.WHITE);
		cuadro_muestra.setBounds(312, 46, 308, 121);
		contentPane.add(cuadro_muestra);

		
		JButton btnCrearJugador = new JButton("CREAR JUGADOR");
		btnCrearJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((NOMBRE.getText().isEmpty()) && (APELLIDOS.getText().isEmpty()) && (NICKNAME.getText().isEmpty()) && (CORREO.getText().isEmpty()) ) {
					cuadro_muestra.setText(" ¡¡ERROR AL CREAR JUGADOR!! \n TODOS LOS CAMPOS ESTAN VACIOS");
				}else if (((esNumero(EDAD.getText()))==false) || (EDAD.getText().isEmpty())) {
					cuadro_muestra.setText(" ¡¡ERROR AL CREAR JUGADOR!! \n Error en el campo 'Edad' o campo vacio.");
				}else if (NOMBRE.getText().isEmpty()) {
					cuadro_muestra.setText(" ¡¡ERROR AL CREAR JUGADOR!! \n Error en el campo 'Nombre' o campo vacio.");
				}else if (APELLIDOS.getText().isEmpty()) {
					cuadro_muestra.setText(" ¡¡ERROR AL CREAR JUGADOR!! \n Error en el campo 'Apellidos' o campo vacio.");
				}else if (NICKNAME.getText().isEmpty()) {  
					cuadro_muestra.setText(" ¡¡ERROR AL CREAR JUGADOR!! \n Error en el campo 'Nickname' o campo vacio.");
				}else if (CORREO.getText().isEmpty() || (esEmail(CORREO.getText()))==false) {  
					cuadro_muestra.setText(" ¡¡ERROR AL CREAR JUGADOR!! \n Error en el campo 'Correo' o campo vacio.");
				}else {
					cuadro_muestra.setText(" ¡¡JUGADOR CREADO CON EXITO!! \n Nombre: " + jugador1.getNombre() + jugador1.getApellidos() + "\n Edad: " + jugador1.getEdad() + "\n Nick: " + jugador1.getNick() + "\n Correo: " + jugador1.getCorreo() );
				}
			}


		});
		btnCrearJugador.setBounds(242, 200, 145, 46);
		contentPane.add(btnCrearJugador);
		
		JLabel lblpulsarIntroCada = new JLabel("(PULSAR INTRO CADA VEZ QUE INTRODUZCAMOS UN DATO)");
		lblpulsarIntroCada.setIcon(new ImageIcon(Principal.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		lblpulsarIntroCada.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		lblpulsarIntroCada.setBackground(Color.WHITE);
		lblpulsarIntroCada.setBounds(147, 13, 336, 32);
		contentPane.add(lblpulsarIntroCada);
		

		

	}
}
