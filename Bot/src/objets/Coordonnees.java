package objets;

public class Coordonnees {
	private int galaxie;
	private int systemeSolaire;
	private int positionPlanete;
	
	public Coordonnees(int galaxie, int systemeSolaire, int positionPlanete) {
		this.galaxie = galaxie;
		this.systemeSolaire = systemeSolaire;
		this.positionPlanete = positionPlanete;
	}
	
	public Coordonnees(String chaine) {
		this.galaxie = Integer.parseInt(String.valueOf(chaine.charAt(1)));
		this.systemeSolaire = Integer.parseInt(chaine.substring(chaine.indexOf(":")+1,chaine.indexOf(":", chaine.indexOf(":") + 1)));
		this.positionPlanete = Integer.parseInt(chaine.substring(chaine.indexOf(":", chaine.indexOf(":") + 1)+1, chaine.indexOf("]")));
	}

	public int getGalaxie() {
		return galaxie;
	}

	public int getSystemeSolaire() {
		return systemeSolaire;
	}

	public int getPositionPlanete() {
		return positionPlanete;
	}
	
	public String toString() {
		return "[" + galaxie + ":" + systemeSolaire + ":"
				+ positionPlanete + "]";
	}
}
