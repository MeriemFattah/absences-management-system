

public class etudiant_module {
	protected int CNE;
	protected String nom;
	protected String prenom;
	protected float TP;
	protected float controle;
	protected float Examen;
	protected String nom_module;
	protected String nom_classe;
	public String getNom_classe() {
		return nom_classe;
	}
	public void setNom_classe(String nom_classe) {
		this.nom_classe = nom_classe;
	}
	public etudiant_module(String nom_module) {
		super();
		this.nom_module = nom_module;
	}
	public String getNom_module() {
		return nom_module;
	}
	public void setNom_module(String nom_module) {
		this.nom_module = nom_module;
	}
	public int getCNE() {
		return CNE;
	}
	public void setCNE(int cNE) {
		CNE = cNE;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public float getTP() {
		return TP;
	}
	public void setTP(float tP) {
		TP = tP;
	}
	public float getControle() {
		return controle;
	}
	public void setControle(float controle) {
		this.controle = controle;
	}
	public float getExamen() {
		return Examen;
	}
	public void setExamen(float examen) {
		Examen = examen;
	}
	public etudiant_module(int CNE, String nom, String prenom, float TP, float Controle, float Examen,String nom_module,String nom_classe) {
		super();
		this.CNE = CNE;
		this.nom = nom;
		this.prenom = prenom;
		this.TP = TP;
		this.controle = Controle;
		this.Examen = Examen;
		this.nom_module=nom_module;
		this.nom_classe=nom_classe;
	}
}
