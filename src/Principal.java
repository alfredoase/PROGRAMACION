import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Juego.Jugador;

public class Principal extends JFrame {
	private JPanel contentPane;
	
	public static void main(String[] args) {
		Jugador jugador1 = new Jugador();
		jugador1.setNick("Alf");
		jugador1.setNombre("Alfredo");
		jugador1.setApellidos("Santos Espert");
		jugador1.setEdad(21);
		jugador1.setId(0);
		
		System.out.println(jugador1.toString());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
