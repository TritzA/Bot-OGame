package actions;

import pack.Utilitaire;

public class Flotte {	

	public final int POS_EXPE = 17;
	public final int NB_MIN_GT_EXPE = 60;
	public final int NB_MAX_GT_EXPE = 200;
	public final int NB_MIN_GT_ATT = 10;
	public final int NB_MAX_GT_ATT = 50;

	public Flotte() {

	}

	public static void clicVaisseau(String nomVaisseau, int nombre) {// 60 GT
		Utilitaire.executer("Flotte", nomVaisseau);
		General.taperNum(nombre + "");
	}

	public static void coordonnes() {
		Utilitaire.executer("Flotte", "coordonnes");
	}

	public void expedition() {
		Utilitaire.executer("Flotte", "expedition");
	}

	public void transporter() {
		Utilitaire.executer("Flotte", "transporter");
	}

	public static void attaquer() {
		Utilitaire.executer("Flotte", "attaquer");
	}
}
