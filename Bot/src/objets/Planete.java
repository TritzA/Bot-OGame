package objets;

public class Planete {
	private String planete;
	private int coordoGalaxie;
	private int coordoSysteme;
	private int coordoPlanete;

	public Planete() {

	}

	public Planete(String planete, int coordoGalaxie, int coordoSysteme, int coordoPlanete) {
		this.planete = planete;
		this.coordoGalaxie = coordoGalaxie;
		this.coordoSysteme = coordoSysteme;
		this.coordoPlanete = coordoPlanete;
	}

	public String getNomCible() {
		return planete;
	}

	public int getCoordoGalaxie() {
		return coordoGalaxie;
	}

	public int getCoordoSysteme() {
		return coordoSysteme;
	}

	public int getCoordoPlanete() {
		return coordoPlanete;
	}

}
