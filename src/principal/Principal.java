package principal;

import Ventanas.Juego;
import Ventanas.Login;

public class Principal{
	public static void main(String[] args) {
		Juego vJ = new Juego();
		
		Login registro = new Login(vJ);
		registro.setVisible(true);
	}
}
