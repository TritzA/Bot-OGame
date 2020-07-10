package pack;

import java.awt.event.KeyEvent;

import actions.General;

public class Utilitaire {

	public static void executer(String menu, String sousMenu) {
		String commande = "rundll32 url.dll,FileProtocolHandler "
				+ "C:\\Users\\client\\Desktop\\Bot\\Bot\\ClassesActions\\" + menu + "\\" + sousMenu + ".mcr";

		Runtime runtime = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process process = null;
		try {
			process = runtime.exec(commande);
		}

		catch (Exception err)

		{
			System.out.println("err = " + err);
		}
		Utilitaire.pauseSec(1);// ou plus
		General.clic();
	}

	public static void lancer(int nombreTab) {
		for (int i = 0; i < nombreTab; i++) {
			General.tape(KeyEvent.VK_TAB);
		}
		General.tape(KeyEvent.VK_ENTER);
		Utilitaire.pauseSec(1);

	}

	public static void executerVite(String menu, String sousMenu) {
		String commande = "rundll32 url.dll,FileProtocolHandler "
				+ "C:\\Users\\client\\Desktop\\Bot\\Bot\\ClassesActions\\" + menu + "\\" + sousMenu + ".mcr";

		Runtime runtime = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process process = null;
		try {
			process = runtime.exec(commande);
		}

		catch (Exception err)

		{
			System.out.println("err = " + err);
		}
		pauseSec(1);
	}

	public static void pauseMin(double nombreMinute) {
		try {
			for (int i = 1; i <= nombreMinute; i++) {
				Thread.sleep((long) (1 * 60 * 1000));
				System.out.println("Temps: " + i + "/" + nombreMinute + " minutes");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----FIN première pause-----");
	}
	
	public static void pauseMin(double nombreMinute, double erreur) {
		double min = nombreMinute * (1.-(erreur/100.));
		double max = nombreMinute * (1.+(erreur/100.));
		double nombreAleatoire = (int) ((Math.random() * (max - min)) + min);

		try {
			for (int i = 1; i <= nombreAleatoire; i++) {
				Thread.sleep((long) (1 * 60 * 1000));
				System.out.println("Temps: " + i + "/" + nombreAleatoire + " minutes");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----FIN première pause-----");
	}

	public static void pauseSec(double nombreSeconde) {
		try {
			Thread.sleep((long) (nombreSeconde * 1000.));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int aleatoire(int nbMax, int nbMin) {
		return (int) ((Math.random() * ((nbMax - nbMin) + 1)) + nbMin);
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}

		try {
			@SuppressWarnings("unused")
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
