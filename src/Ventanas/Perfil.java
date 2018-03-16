package Ventanas;

import javax.swing.JPanel;

import Juego.Jugador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Perfil extends JPanel {
	private Jugador jugador1;
	private JLabel lblNombre, lblNick;
	private JTextField txtNombre, txtApellidos, txtNick, txtEdad, txtCorreo;
	private int edad;
	private JLabel nuevoNombre, nuevoNick, nuevoEdad, nuevoCorreo, nuevoApellidos;
	private JLabel lblNewLabel;

	public Perfil() {
		
		JPanel panel = new JPanel();
		
		JLabel fotoPerfil = new JLabel("");
		fotoPerfil.setIcon(new ImageIcon(Perfil.class.getResource("/Ventanas/ImagenesDados/perfil.png")));
		
		JLabel lblNombre_1 = new JLabel("NOMBRE:");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNick_1 = new JLabel("NICK:");
		lblNick_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEdad = new JLabel("EDAD:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCorreo = new JLabel("CORREO:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		nuevoNombre = new JLabel("New label");
		
		nuevoApellidos = new JLabel("New label");
		
		nuevoNick = new JLabel("New label");
		
		nuevoEdad = new JLabel("New label");
		
		nuevoCorreo = new JLabel("New label");
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setEnabled(false);
				jugador1.setNombre(txtNombre.getText());
				nuevoNombre.setText(txtNombre.getText());
			}
		});
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtApellidos.setEnabled(false);
				jugador1.setApellidos(txtApellidos.getText());
				nuevoApellidos.setText(txtApellidos.getText());
			}
		});
		txtApellidos.setColumns(10);
		
		txtNick = new JTextField();
		txtNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNick.setEnabled(false);
				jugador1.setNick(txtNick.getText());
				nuevoNick.setText(txtNick.getText());
			}
		});
		txtNick.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEdad.setEnabled(false);
				jugador1.setEdad(Integer.parseInt(txtEdad.getText()));
				nuevoEdad.setText(txtEdad.getText());
			}
		});
		txtEdad.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCorreo.setEnabled(false);
				jugador1.setCorreo(txtCorreo.getText());
				nuevoCorreo.setText(txtCorreo.getText());
			}
		});
		txtCorreo.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.setNombre(txtNombre.getText());
				jugador1.setApellidos(txtApellidos.getText());
				jugador1.setNick(txtNick.getText());
				jugador1.setEdad(Integer.parseInt(txtEdad.getText()));
				jugador1.setCorreo(txtCorreo.getText());
				jugador1.sethayCambios(1);
				lblNewLabel.setText("ACTUALIZACION CORRECTA");
				
				txtNombre.setEnabled(true);
				txtNick.setEnabled(true);
				txtApellidos.setEnabled(true);
				txtEdad.setEnabled(true);
				txtCorreo.setEnabled(true);
			}
		});
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblCorreo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblEdad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNick_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblApellidos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNombre_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(fotoPerfil, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
								.addComponent(txtApellidos)
								.addComponent(txtNick)
								.addComponent(txtEdad)
								.addComponent(txtCorreo))
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(nuevoApellidos)
								.addComponent(nuevoNombre)
								.addComponent(nuevoNick)
								.addComponent(nuevoEdad)
								.addComponent(nuevoCorreo))
							.addGap(57))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(95)
							.addComponent(lblPerfil, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(180))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(167)
					.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(166))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(fotoPerfil))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(lblPerfil)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_1)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nuevoNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nuevoApellidos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNick_1)
						.addComponent(txtNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nuevoNick))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nuevoEdad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreo)
						.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nuevoCorreo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}

	public void setJugador(Jugador jugador1) {
		this.jugador1 = jugador1;
		
		txtNombre.setText(jugador1.getNombre());
		txtApellidos.setText(jugador1.getApellidos());
		txtNick.setText(jugador1.getNick());
		edad = jugador1.getEdad();
		txtEdad.setText(""+edad);
		txtCorreo.setText(jugador1.getCorreo());
		
		//lblPuntuacion.setText("PUNTUACION: " + jugador1.getPuntuacion() );
		
		nuevoNombre.setText(jugador1.getNombre());
		nuevoApellidos.setText(jugador1.getApellidos());
		nuevoNick.setText(jugador1.getNick());
		nuevoEdad.setText(""+edad);
		nuevoCorreo.setText(jugador1.getCorreo());
	}
}
