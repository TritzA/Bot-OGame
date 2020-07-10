package pack;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import actions.ExtraJeu;
import actions.Flotte;
import actions.General;
import actions.ListePlanetes;
import actions.Marchand;
import actions.Menu;
import actions.Recherche;
import actions.Ressource;
import objets.Frigo;
import objets.Planete;

public class Macro {

	public void ouvrirJeu() {
		Utilitaire.pauseSec(2);

		ExtraJeu.ouvrirPage("https://lobby.ogame.gameforge.com/fr_FR/hub");
		Utilitaire.pauseSec(10);

		ExtraJeu.pleinEcran();
		Utilitaire.pauseSec(2);

		ExtraJeu.zoomParDefaut();
		Utilitaire.pauseSec(2);

		Utilitaire.lancer(2);
		Utilitaire.pauseSec(5);

		Utilitaire.lancer(1);
		Utilitaire.pauseSec(10);
	}

	public void fermerFenetre() {
		ExtraJeu.fermerFenetre();
	}

	public void lancerMine(String noPlanete) {
		ListePlanetes.clic(noPlanete);
		Menu.clic("ressource");
		Ressource.tentativesMines();
	}

	public void attaquer(int nbAttaque, int nbGT, String planeteVisee) throws ClassNotFoundException, IOException {
		Fichier fichier = new Fichier();
		fichier.lireBanque();
		ArrayList<Frigo> banqueTempo = fichier.getBanque();

		for (int i = 0; i < nbAttaque; i++) {
			Frigo frigo;
			if (!planeteVisee.equals("")) {
				do {
					frigo = banqueTempo.remove((Utilitaire.aleatoire(0, banqueTempo.size() - 1)));// methode aleatoire
																									// addaptée
				} while (frigo.getPlaneteAttaquante() != "1");
			} else {
				frigo = banqueTempo.remove((Utilitaire.aleatoire(0, banqueTempo.size() - 1)));// methode aleatoire
																								// addaptée
			}
			ListePlanetes.clic(frigo.getPlaneteAttaquante());

			Menu.clic("flotte");

			Flotte.clicVaisseau("grandTransporteur", nbGT);
			General.tape(KeyEvent.VK_ENTER);

			Flotte.coordonnes();
			General.taperNum(frigo.getCoordonnees().getGalaxie() + "");
			General.tape(KeyEvent.VK_TAB);
			General.taperNum(frigo.getCoordonnees().getSystemeSolaire() + "");
			General.tape(KeyEvent.VK_TAB);
			General.taperNum(frigo.getCoordonnees().getPositionPlanete() + "");
			General.tape(KeyEvent.VK_ENTER);

			General.rouletteBas();
			Flotte.attaquer();
			General.tape(KeyEvent.VK_ENTER);
			General.rouletteHaut();

		}

	}

	public void lancerExpedition(String noPlanete, int nbExpe) {// A REVOIR
		Flotte flotte = new Flotte();
		ListePlanetes.clic(noPlanete);
		Menu.clic("flotte");

		for (int i = 0; i < nbExpe; i++) {
			Flotte.clicVaisseau("grandTransporteur", 150);
			General.tape(KeyEvent.VK_ENTER);

			Planete planete = ListePlanetes.getPlanete(noPlanete);
			Flotte.coordonnes();
			General.taperNum(planete.getCoordoGalaxie() + "");
			General.tape(KeyEvent.VK_TAB);
			General.taperNum(planete.getCoordoSysteme() + "");
			General.tape(KeyEvent.VK_TAB);
			General.taperNum(flotte.POS_EXPE + "");
			General.tape(KeyEvent.VK_ENTER);

			General.rouletteBas();
			Flotte.attaquer();
			General.tape(KeyEvent.VK_ENTER);
			General.rouletteHaut();
		}
	}

	public void lancerEnchere(String noPlanete, double nombreMinutes) {
		ListePlanetes.clic(noPlanete);
		Menu.clic("marchand");
		Marchand.commissaire();
		General.rouletteBas();

		long tempsDebut = System.currentTimeMillis();
		long tempsFin = 0;
		long difference = 0;
		while (difference <= nombreMinutes * 60 * 1000) {
			Marchand.commissaireAchat();
			tempsFin = System.currentTimeMillis();
			difference = tempsFin - tempsDebut;
		}
		General.rouletteHaut();
	}

	public void lancerImpExp(String noPlanete) {
		ListePlanetes.clic(noPlanete);
		Menu.clic("marchand");
		Marchand.impExp();
		Marchand.impExpAchat();
	}

	public void lancerRecherche(String noPlanete) {
		ListePlanetes.clic(noPlanete);
		Menu.clic("recherche");

		Recherche.lancer("plasma");// 1 plasma
		Recherche.lancer("espionnage");// 2 espio
		Recherche.lancer("intergalactique");// 3 reseau
		Recherche.lancer("astrophysique");// 4 astro
		Recherche.lancer("ordinateur");// 5 ordi
		Recherche.lancer("armes");// 6 armes
		Recherche.lancer("bouclier");// 7 bouclier
		Recherche.lancer("coque");// 8 coque
		Recherche.lancer("combustion");// 9 combu
		Recherche.lancer("impulsion");// 10 impu
		Recherche.lancer("propulsionHyperEspace");// 11 propuls. hyperesp
		Recherche.lancer("hyperEspace");// 12 hyperesp
		Recherche.lancer("ions");// 13 ions
		Recherche.lancer("energie");// 14 energie
		Recherche.lancer("laser");// 15 laser
		Recherche.lancer("graviton");// 16 graviton
	}

	public void activite() {
		ListePlanetes.clic("1");
		ListePlanetes.clic("2");
		ListePlanetes.clic("3");
		ListePlanetes.clic("4");
		ListePlanetes.clic("5");
		ListePlanetes.clic("6");
	}
}
