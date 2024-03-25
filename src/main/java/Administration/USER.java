package Administration;



public class USER {
	protected int CNI;
	protected String nom;
	protected String prenom;
	protected String date_de_naissance;
	protected String ville;
	protected String rue;
	protected String pay;
	protected String code_postale;
	protected String email;
	protected String etat;
	protected String statut;
	protected String grades;
	protected String mot_de_passe;
	
	public USER() {
	}

	public int getCNI() {
		return CNI;
	}

	public void setCNI(int CNI) {
		this.CNI = CNI;
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

	public String getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(String date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public USER(int CNI, String nom, String prenom, String date_de_naissance, String ville, String rue, String pay,
			String code_postale, String email, String etat, String statut, String grades,
			String mot_de_passe) {
		super();
		this.CNI = CNI;
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.ville = ville;
		this.rue = rue;
		this.pay = pay;
		this.code_postale = code_postale;
		this.email = email;
		
		this.etat = etat;
		this.statut = statut;
		this.grades = grades;
		this.mot_de_passe = mot_de_passe;
	}

	public USER(String nom, String prenom, String date_de_naissance, String ville, String rue, String pay,
			String code_postale, String email, String etat, String statut, String grades,
			String mot_de_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.ville = ville;
		this.rue = rue;
		this.pay = pay;
		this.code_postale = code_postale;
		this.email = email;
		
		this.etat = etat;
		this.statut = statut;
		this.grades = grades;
		this.mot_de_passe = mot_de_passe;
	}
	



}
