package objets;

import java.io.Serializable;

import actions.ListePlanetes;

public class Frigo extends Planete implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomCible;
	private Coordonnees coordonnees;
	private String planeteAttaquante;
	private int coupure00 = 0;
	private int coupure01 = (ListePlanetes.zero.getCoordoSysteme() + ListePlanetes.un.getCoordoSysteme()) / 2;
	private int coupure12 = (ListePlanetes.un.getCoordoSysteme() + ListePlanetes.deux.getCoordoSysteme()) / 2;
	private int coupure23 = (ListePlanetes.deux.getCoordoSysteme() + ListePlanetes.trois.getCoordoSysteme()) / 2;
	private int coupure34 = (ListePlanetes.trois.getCoordoSysteme() + ListePlanetes.quatre.getCoordoSysteme()) / 2;
	private int coupure45 = (ListePlanetes.quatre.getCoordoSysteme() + ListePlanetes.cinq.getCoordoSysteme()) / 2;
	private int coupure56 = (ListePlanetes.cinq.getCoordoSysteme() + ListePlanetes.six.getCoordoSysteme()) / 2;
	private int coupure67 = (ListePlanetes.six.getCoordoSysteme() + ListePlanetes.sept.getCoordoSysteme()) / 2;
	private int coupure77 = ListePlanetes.sept.getCoordoSysteme() + 25;

	public Frigo() {
	}

	public Frigo(Coordonnees coordonnees, String nomCible) {
		this.nomCible = nomCible;
		this.coordonnees = coordonnees;

		if (coupure00 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure01) {
			this.planeteAttaquante = "0";
		} else if (coupure01 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure12) {
			this.planeteAttaquante = "1";
		} else if (coupure12 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure23) {
			this.planeteAttaquante = "2";
		} else if (coupure23 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure34) {
			this.planeteAttaquante = "3";
		} else if (coupure34 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure45) {
			this.planeteAttaquante = "4";
		} else if (coupure45 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure56) {
			this.planeteAttaquante = "5";
		} else if (coupure56 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure67) {
			this.planeteAttaquante = "6";
		} else if (coupure67 < coordonnees.getSystemeSolaire() && coordonnees.getSystemeSolaire() < coupure77) {
			this.planeteAttaquante = "7";
		} else {
			System.out.println("Bug. Clase Frigo");
		}

	}

	public String getNomCible() {
		return nomCible;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public String getPlaneteAttaquante() {
		return planeteAttaquante;
	}

	@Override
	public String toString() {
		return "Frigo [nomCible=" + nomCible + ", coordonnees=" + coordonnees.toString() + ", planeteAttaquante="
				+ planeteAttaquante + "]";
	}
}
