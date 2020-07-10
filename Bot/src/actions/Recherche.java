package actions;

import pack.Utilitaire;

public class Recherche {

	public static final int NB_FLOTTE_MAX = 14;
	public static final int NB_EXPE_MAX = 3;

	public static void lancer(String nomRecherche) {
		Utilitaire.executer("Recherche", nomRecherche);
	}
}
