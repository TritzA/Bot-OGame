package pack;

import java.io.IOException;

import actions.Recherche;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		System.out.println("");
		
		
		Utilitaire.pauseMin(45);
		for (int n = 0; n < 100; n++) {
			Macro macro = new Macro();
			
			macro.ouvrirJeu();
			
			macro.attaquer(Recherche.NB_FLOTTE_MAX+7, 30,"");

			macro.fermerFenetre();
			Utilitaire.pauseMin(50);
			
		}
//		Fichier fichier = new Fichier();
//
//		fichier.traiterTempo();
//		fichier.lireBanque();

	}
}

/*
 * a faire priorité d
 * 
 * ans une plus grande banque de frigo 4 wenlever sortie console faire
 * fonctuinner expe cst planete
 * 366 et plus
 */


