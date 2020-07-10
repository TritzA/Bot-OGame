package actions;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ExtraJeu {

	public static void ouvrirPage(String monLien) {
		try {
			Desktop.getDesktop().browse(new URL(monLien).toURI());
		} catch (URISyntaxException | IOException e) {

		}
	}

	public static void pleinEcran() {
		General.tape(KeyEvent.VK_WINDOWS, KeyEvent.VK_UP);
		General.tape(KeyEvent.VK_WINDOWS, KeyEvent.VK_DOWN);
		General.tape(KeyEvent.VK_WINDOWS, KeyEvent.VK_UP);
	}

	public static void fermerFenetre() {
		General.tape(KeyEvent.VK_CONTROL, KeyEvent.VK_W);
		General.tape(KeyEvent.VK_CONTROL, KeyEvent.VK_W);
		General.tape(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_W);
		General.tape(KeyEvent.VK_ENTER);
	}

	public static void zoomParDefaut() {
		General.tape(KeyEvent.VK_CONTROL, KeyEvent.VK_0);
	}

}
//https://www.clubic.com/tutoriels/article-859226-1-raccourcis-clavier-indispensables-opera.html
