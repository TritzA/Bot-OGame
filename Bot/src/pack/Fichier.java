package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import objets.Coordonnees;
import objets.Frigo;

public class Fichier {

	private ArrayList<Frigo> banque = new ArrayList<Frigo>();

	void traiterTempo() throws IOException {
		FileReader nomFichier;
		BufferedReader fluxEntree;

		nomFichier = new FileReader("tempo.txt");
		fluxEntree = new BufferedReader(nomFichier);

		String ligne = "";
		String nom = null;
		String coordonnee = null;
		String defenseFlotte = null;
		
		int nbAjout = 0;
		int nbDejaPresent = 0;

		while (ligne != null) {

			if (ligne.contains("[")) {
				coordonnee = ligne.substring(ligne.indexOf("["), ligne.indexOf("]") + 1);
			}
			if (ligne.contains("Joueur")) {
				if (ligne.contains("(")) {
					nom = "Joueur : " + ligne.substring(9, ligne.indexOf("("));
				} else if (ligne.contains(" Activité")) {
					nom = "Joueur : " + ligne.substring(9, ligne.lastIndexOf("A") - 2);
				} else {
					System.out.println("Bug. Classe Fichier.");
				}

			}
			if (ligne.contains("Flottes: ")) {
				if (ligne.charAt(9) == '0' && ligne.charAt(19) == '0') {
					defenseFlotte = "Flottes et défenses : false ";
				} else {
					defenseFlotte = "Flottes et défenses : true " + ligne.substring(0, 9 + 1) + " "
							+ ligne.substring(10);
					;
				}
			}

			if (nom != null && coordonnee != null && defenseFlotte != null) {
				boolean absent = ecrireTempo(nom, coordonnee, defenseFlotte);
				if(absent == true) {
					nbAjout++;
				}else {
					nbDejaPresent++;
				}
				nom = null;
				coordonnee = null;
				defenseFlotte = null;
			}

			ligne = fluxEntree.readLine();
		}
		fluxEntree.close();
		System.out.println("Fichier banque.txt prêt pour la lecture. "+nbAjout+" ajout sur "+(nbAjout+nbDejaPresent));
	}

	private boolean ecrireTempo(String nom, String coordonnee, String defenseFlotte) throws IOException {
		String filename = "banque.txt";
		boolean absent = false;
		try (FileWriter fw = new FileWriter(filename, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			if (absent(coordonnee)) {
				absent = true;
				out.println(nom);
				out.println(coordonnee);
				out.println(defenseFlotte);
				out.println("");
			} else {
				absent = false;
			}
		} catch (IOException e) {
		}
		return absent;
	}

	private boolean absent(String nouvelleCoordonnees) throws IOException {
		FileReader nomFichier;
		BufferedReader fluxEntree;

		nomFichier = new FileReader("banque.txt");
		fluxEntree = new BufferedReader(nomFichier);

		String ligne = null;
		ligne = fluxEntree.readLine();
		boolean retour = true;

		while (ligne != null) {
			if (ligne.contains("[")) {
				String coordonnees = ligne.substring(ligne.indexOf("["), ligne.indexOf("]") + 1);
				if (coordonnees.toString().equals(nouvelleCoordonnees)) {
					fluxEntree.close();
					return false;
				}

			}
			ligne = fluxEntree.readLine();
		}
		fluxEntree.close();
		return retour;
	}

	void lireBanque() throws IOException, ClassNotFoundException {
		FileReader nomFichier;
		BufferedReader fluxEntree;

		nomFichier = new FileReader("banque.txt");
		fluxEntree = new BufferedReader(nomFichier);

		String ligne = "";
		String nom = null;
		String coordonnee = null;
		String defenseFlotte = null;

		while (ligne != null) {

			if (ligne.contains("Joueur : ")) {
				nom = ligne.substring(10);
			}

			if (ligne.contains("[")) {
				coordonnee = ligne.substring(ligne.indexOf("["), ligne.indexOf("]") + 1);
			}

			if (ligne.contains("Flottes")) {
				if (ligne.charAt(22) == 'f') {
					defenseFlotte = "f";
				} else if (ligne.charAt(22) == 't') {
					defenseFlotte = "t";
				} else {
					System.out.println("Bug. Classe Fichier :" + ligne);
				}
			}

			if (nom != null && coordonnee != null && defenseFlotte != null && defenseFlotte != "t") {
				Coordonnees coordonnees = new Coordonnees(coordonnee);
				Frigo frigo = new Frigo(coordonnees, nom);
				banque.add(frigo);

				nom = null;
				coordonnee = null;
				defenseFlotte = null;
			}
			ligne = fluxEntree.readLine();
		}
		fluxEntree.close();
		System.out.println("La banque est lue et stockée. La liste contient : " + banque.size());
	}

	public ArrayList<Frigo> getBanque() {
		return banque;
	}

	public void setBanque(ArrayList<Frigo> banque) {
		this.banque = banque;
	}
}
