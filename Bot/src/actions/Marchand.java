package actions;

import pack.Utilitaire;

public class Marchand {

	public static void commissaire() {
		Utilitaire.executer("Marchand", "commissaire");
	}

	public static void impExp() {
		Utilitaire.executer("Marchand", "impExp");
	}

	public static void ferrailleur() {
		Utilitaire.executer("Marchand", "ferrailleur");
	}

	public static void marche() {
		Utilitaire.executer("Marchand", "marche");
	}

	public static void impExpAchat() {
		Utilitaire.executer("Marchand", "impExpAchat");
		Utilitaire.pauseSec(4);
	}

	public static void commissaireAchat() {
		Utilitaire.executerVite("Marchand", "commissaireAchat");
		Utilitaire.pauseSec(2);// car deux actions en une
	}
}
