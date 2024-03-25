


public class Enseignant {
	protected  int CIN ;
	protected  String  nom ;
	protected  String  prenom ;
	protected  String  level ;
	protected  String  status ;
	protected  String  pay ;
	protected  String  email ;
	protected  String  date_de_naissance ;
	protected  String  ville ;
	
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the date_de_naissance
	 */
	public String getDate_de_naissance() {
		return date_de_naissance;
	}
	/**
	 * @param date_de_naissance the date_de_naissance to set
	 */
	public void setDate_de_naissance(String date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	protected  int  tel ;
	/**
	 * 
	 */
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cIN
	 * @param nom
	 * @param prenom
	 * @param level
	 * @param status
	 * @param pay
	 * @param email
	 * @param tel
	 */
	public Enseignant(int cIN, String nom, String prenom, String level, String status, String pay, String email,
			int tel,String date_de_naissance,String ville) {
		CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.level = level;
		this.status = status;
		this.pay = pay;
		this.email = email;
		this.tel = tel;
		this.date_de_naissance=date_de_naissance;
		this.ville=ville;}
	/**
	 * @return the cIN
	 */
	public int getCIN() {
		return CIN;
	}
	/**
	 * @param cIN the cIN to set
	 */
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the pay
	 */
	public String getPay() {
		return pay;
	}
	/**
	 * @param pay the pay to set
	 */
	public void setPay(String pay) {
		this.pay = pay;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the tel
	 */
	public int getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}


}
