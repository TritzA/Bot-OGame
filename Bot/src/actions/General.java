package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import pack.Utilitaire;

public class General {

	public static void clic() {
		Robot robot = null;
		Utilitaire.pauseSec(3);
		General.tape(KeyEvent.VK_CONTROL);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.setAutoDelay(10);

		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}

	public static void taperNum(String textNumerique) {
		
		int keyCode;

		if (!Utilitaire.isNumeric(textNumerique)) {
			System.out.println("Erreur : Text de tape non numerique");
		}

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < textNumerique.length(); i++) {
			keyCode = textNumerique.charAt(i);
			System.out.println(textNumerique.charAt(i));

			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);
		}
	}


	public static void tape(int keyCode1) {

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.keyPress(keyCode1);
		robot.keyRelease(keyCode1);

		if (keyCode1 == KeyEvent.VK_ENTER) {
			Utilitaire.pauseSec(1);
		}
	}
	
	public static void tape(int keyCode1, int keyCode2) {

		Robot robot = null;
		
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.keyPress(keyCode1);
		robot.keyPress(keyCode2);
		robot.keyRelease(keyCode2);
		robot.keyRelease(keyCode1);

		Utilitaire.pauseSec(0.5);
	}

	public static void tape(int keyCode1, int keyCode2, int keyCode3) {

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.keyPress(keyCode1);
		robot.keyPress(keyCode2);
		robot.keyPress(keyCode3);
		robot.keyRelease(keyCode3);
		robot.keyRelease(keyCode2);
		robot.keyRelease(keyCode1);

		Utilitaire.pauseSec(0.5);
	}

	public static void rouletteHaut() {// peut etre pause apres monte ou descend
		
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(100);

			Thread.sleep(2000);
			robot.mouseWheel(-10);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Utilitaire.pauseSec(0.5);
	}

	public static void rouletteBas() {
	
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(100);

			Thread.sleep(2000);
			robot.mouseWheel(10);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Utilitaire.pauseSec(0.5);
	}
}
