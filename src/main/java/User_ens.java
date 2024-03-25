

public class User_ens {
	protected int id;
	protected String nom;
	protected int CNE;
	protected String prenom;
	protected String etat;
	protected String justif;
	protected String date_absence;
	protected String nom_module;
	protected String nom_classe;
	
	/**
	 * @return the nom_module
	 */
	public String getNom_module() {
		return nom_module;
	}

	/**
	 * @param nom_module the nom_module to set
	 */
	public void setNom_module(String nom_module) {
		this.nom_module = nom_module;
	}

	/**
	 * @return the nom_classe
	 */
	public String getNom_classe() {
		return nom_classe;
	}

	/**
	 * @param nom_classe the nom_classe to set
	 */
	public void setNom_classe(String nom_classe) {
		this.nom_classe = nom_classe;
	}

	public User_ens() {
	}

	public int getCNE() {
		return CNE;
	}

	public void setCNE(int CNI) {
		this.CNE = CNI;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public String getNom() {
		return nom;
	}

	public void setPrenom(String n) {
		this.prenom = n;
	}
	public String getPrenom() {
		return prenom;
	}

	public void setEtat(String p) {
		this.etat = p;
	}
	
	
	
	
	public String getEtat() {
		return etat;
	}

	public void setJustif(String p) {
		this.justif = p;
	}
	
	
	public String getJustif() {
		return justif;
	}

	public void setDate_absence(String nom) {
		this.date_absence = nom;
	}
	
	public String getDate_absence() {
		return date_absence;
	}


	

	public User_ens(int id, String nom, String prenom2 ) {
		super();
		this.CNE = id;
		this.nom = nom;
		this.prenom=prenom2;}
	

	






	public User_ens(int id, String nom ) {
		super();
		this.id = id;
		this.nom = nom;
	
	
	}

	public User_ens(int cNI, String nom2, String prenom2, String date_absence2) {
		// TODO Auto-generated constructor stub
		this.CNE = cNI;
		this.etat = nom2;
		this.justif = prenom2;
		this.date_absence = date_absence2;
		
	}

	/**
	 * @param nom
	 * @param cNE
	 * @param prenom
	 * @param nom_module
	 * @param nom_classe
	 */
	public User_ens( int cNE,String nom, String prenom, String nom_classe,String nom_module) {
		this.nom = nom;
		CNE = cNE;
		this.prenom = prenom;
		this.nom_module = nom_module;
		this.nom_classe = nom_classe;
	}

	





}


