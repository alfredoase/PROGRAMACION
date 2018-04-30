import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PRUEBA_FRAMEBD extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	
	private int id = 0;
	private String nomb, apellidos, edad, puntuacion;
	
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtPuntuacion;
	
	private static ConexionDB pruebaConexion;
	private static boolean conectado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRUEBA_FRAMEBD frame = new PRUEBA_FRAMEBD();
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
	public PRUEBA_FRAMEBD() {
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 230, 414, 20);
		contentPane.add(comboBox);

        try{
        	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tablausuariosprueba","root","");
            
            //INSTRUCCIONES SQL
            Statement consulta = conexion.createStatement();
            PreparedStatement insertar = conexion.prepareStatement("INSERT INTO usuariosprue VALUES (?,?,?,?,?)");
            
            ResultSet resultado = consulta.executeQuery("select * from usuariosprue");
            
            
            
            //SE RECORRE EL RESULTADO MIENTRAS HAYA NUEVOS
            
    		txtNombre = new JTextField();
    		txtNombre.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				try {

						insertar.setString(2,txtNombre.getText());	
			            //conexion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
    			}
    		});
    		txtNombre.setText("");
    		txtNombre.setBounds(10, 11, 231, 20);
    		contentPane.add(txtNombre);
    		txtNombre.setColumns(10);
    		
    		txtApellidos = new JTextField();
    		txtApellidos.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				try {
    					insertar.setString(3,txtApellidos.getText());
			            //conexion.close();
					} catch (SQLException e1) {
						System.out.println("NO SE HA PODIDO INSERTAR, LOS APELLIDOS");
					}
    			}
    		});
    		txtApellidos.setText("");
    		txtApellidos.setColumns(10);
    		txtApellidos.setBounds(10, 42, 231, 20);
    		contentPane.add(txtApellidos);
    		
    		txtEdad = new JTextField();
    		txtEdad.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				try {
    					int edadInt = Integer.parseInt(txtEdad.getText());
    					
						insertar.setInt(4, edadInt);			             
			            //conexion.close();
					} catch (SQLException e2) {
						System.out.println("NO SE HA PODIDO INSERTAR, LA EDAD");
					}
    			}
    		});
    		txtEdad.setText("");
    		txtEdad.setColumns(10);
    		txtEdad.setBounds(10, 73, 231, 20);
    		contentPane.add(txtEdad);
    		
    		txtPuntuacion = new JTextField();
    		txtPuntuacion.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				try {
    					int puntuacionInt = Integer.parseInt(txtPuntuacion.getText());
    					
						insertar.setInt(5, puntuacionInt);	
					} catch (SQLException e3) {
						System.out.println("NO SE HA PODIDO INSERTAR, LA PUNTUACION");
					}
    			}
    		});
    		txtPuntuacion.setText("");
    		txtPuntuacion.setColumns(10);
    		txtPuntuacion.setBounds(10, 104, 231, 20);
    		contentPane.add(txtPuntuacion);
    		
    		JButton boton = new JButton("ENVIAR");
    		boton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				try {
    					insertar.setInt(1, id++);
    					
						insertar.executeUpdate();
						//conexion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
    			}
    		});
    		boton.setBounds(172, 174, 89, 23);
    		contentPane.add(boton);

    		while (resultado.next()){
            	int id = resultado.getInt("id");
                String nomb = resultado.getString("nom");
                String apellidos = resultado.getString("apellidos");
                int edad = resultado.getInt("edad");
                int puntuacion = resultado.getInt("puntuacion");
            	
                System.out.print("ID: "+ id);
                System.out.print("| NOMBRE: "+ nomb);
                System.out.print("| APELLIDOS: "+ apellidos);
                System.out.print("| EDAD: "+ edad);
                System.out.print("| PUNTUACION: "+ puntuacion);
                System.out.println("----------");
                //comboBox.addItem(cadena);
            }
    		
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
}
