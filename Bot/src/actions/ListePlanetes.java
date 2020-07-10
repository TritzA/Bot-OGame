package actions;

import objets.Planete;
import pack.Utilitaire;

public class ListePlanetes {
	
	public static final int NB_PLANETE = 7;
	
	public final static Planete zero = new Planete("zero",4,22,9);
	public final static Planete un = new Planete("un",4,67,6);
	public final static Planete deux = new Planete("deux",4,118,5);
	public final static Planete trois = new Planete("trois",4,166,4);
	public final static Planete quatre = new Planete("quatre",4,215,7);
	public final static Planete cinq = new Planete("cinq",4,264,6);
	public final static Planete six = new Planete("six",4,320,6);
	public final static Planete sept = new Planete("six",4,365,10);
//	public final static Planete huit = new Planete("six",4,320,6);
//	public final static Planete neuf = new Planete("six",4,320,6);
//	public final static Planete dix = new Planete("six",4,320,6);
	
	public static void clic(String noPlanete) {
		Utilitaire.executer("Planete", noPlanete);
	}
	
	public static Planete getPlanete(String noPlanete) {
		Planete planete = new Planete();
		switch (noPlanete) {
		case "0":
			planete = zero;
			break;
		case "1":
			planete = un;
			break;
		case "2":
			planete = deux;
			break;
		case "3":
			planete = trois;
			break;
		case "4":
			planete = quatre;
			break;
		case "5":
			planete = cinq;
			break;
		case "6":
			planete = six;
			break;
		default:
			return (Planete) null;
		}
		return planete;
	}

}
