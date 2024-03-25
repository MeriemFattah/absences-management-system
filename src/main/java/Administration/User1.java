package Administration;


public class User1 {
	protected int ida;
	protected int CNE;
	protected String nom;
	protected String prenom;
	protected int abs;
	public final String s=null ;
	private String sanction;
	public User1() {
	}
 
	public int getIda() {
		return ida;
	}

	public void setIda(int CN) {
		this.ida = CNE;
	}
	public int getCNE() {
		return CNE;
	}

	public void setCNE(int CNE) {
		this.CNE = CNE;
	}
	
	public int getAbs() {
		return abs;
	}

	public void setAbs(int abs) {
		this.abs = abs;
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

	
	


//	public User1( int cNE2, String name, String prenom2, int nbr) {
//		
//		this.CNE=cNE2;
//		this.nom=name;
//		this.prenom= prenom2;
//		this.abs=nbr;
//		
//	}

//	public User(int cNI, String nom2, String prenom2, int abscence) {
//		
//		this.CNE=cNI;
//		this.nom=nom2;
//		this.prenom= prenom2;
//		this.abs=abscence;
//	}
	
	public String getSanction() {
		return sanction;
	}

	
	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	public User1(int CNE ,String sanction) {
		this.sanction=sanction;
		this.CNE=CNE;
		
	}

	public User1(int cNE2, String name, String prenom2, int nbr, String sct) {
		this.CNE=cNE2;
		this.nom=name;
		this.prenom= prenom2;
		this.abs=nbr;
		this.sanction=sct;
	}





}
