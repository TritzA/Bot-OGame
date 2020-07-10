package actions;

import pack.Utilitaire;

public class Ressource {
	public static void tentativesMines() {
		Utilitaire.executer("Ressource", "mineCri");
		Utilitaire.executer("Ressource", "mineMet");
		Utilitaire.executer("Ressource", "mineDeut");
	}
}
