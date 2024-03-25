package Administration;



public class Etudiant {


	

	protected int CNE;
	protected String CIN;
	protected String nom;
	protected String prenom;
	protected String date_de_naissance;
	protected String ville;
	protected String rue;
	protected String pay;
	protected String code_postale;
	protected String email;
	//protected int Numero_tele;
	protected String sexe;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String nomc;


	protected String mot_de_passe;
	
	public Etudiant() {
	}
	public int  getCNE() {
		return CNE;
	}

	public void setCNE(int CNE) {
		this.CNE = CNE;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
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



	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/*public int getNum_tele() {
		return Numero_tele;
	}

	public void setNum_tele(int Numero_tele) {
		this.Numero_tele = Numero_tele;
	}*/


	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Etudiant(int CNE,String CIN , String nom, String prenom, String date_de_naissance, String ville, String rue, String pay,
			String code_postale, String email,String sexe,
			String mot_de_passe,String nomc,int id) {
		super();
		this.CNE = CNE;
		this.CIN=CIN;
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.ville = ville;
		this.rue = rue;
		this.pay = pay;
		this.code_postale = code_postale;
		this.email = email;
		this.nomc = nomc;
		this.id=id;
		//this.Numero_tele =Numero_tele;
		this.sexe = sexe;
		this.mot_de_passe = mot_de_passe;
	}

	public String getNomc() {
		return nomc;
	}
	public void setNomc(String nomc) {
		this.nomc = nomc;
	}
	public Etudiant(int CNE,String CIN ,String nom, String prenom, String date_de_naissance, String ville, String rue, String pay,
			String code_postale, String email,String sexe,
			String mot_de_passe,int id) {
		super();
		this.CIN=CIN;
		this.CNE=CNE;
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.ville = ville;
		this.rue = rue;
		this.pay = pay;
		this.code_postale = code_postale;
		this.email = email;
		this.sexe= sexe;
		this.mot_de_passe = mot_de_passe;
		this.id=id;
	}



}
