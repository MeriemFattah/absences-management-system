package Etudiant;



public class Etudiant {


	


		protected int cne;
		protected String cin;
		protected String sanction;
		/**
		 * @param cne
		 * @param sanction
		 * @param prenom
		 * @param nom
		 */
		public Etudiant(int cne, String prenom, String nom,String sanction) {
			this.cne = cne;
			this.sanction = sanction;
			this.prenom = prenom;
			this.nom = nom;
		}




		protected String prenom;
		protected String nom_module;
		protected int TP;
		protected int controle;
		protected int examen;
		
		/**
		 * @param cne
		 * @param prenom
		 * @param nom_module
		 * @param tP
		 * @param controle
		 * @param examen
		 * @param nom
		 */
		public Etudiant(int cne, String nom_module,String prenom, String nom, int tP, int controle, int examen) {
			this.cne = cne;
			this.prenom = prenom;
			this.nom_module = nom_module;
			TP = tP;
			this.controle = controle;
			this.examen = examen;
			this.nom = nom;
		}









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
		 * @return the tP
		 */
		public int getTP() {
			return TP;
		}









		/**
		 * @param tP the tP to set
		 */
		public void setTP(int tP) {
			TP = tP;
		}









		/**
		 * @return the controle
		 */
		public int getControle() {
			return controle;
		}









		/**
		 * @param controle the controle to set
		 */
		public void setControle(int controle) {
			this.controle = controle;
		}









		/**
		 * @return the examen
		 */
		public int getExamen() {
			return examen;
		}









		/**
		 * @param examen the examen to set
		 */
		public void setExamen(int examen) {
			this.examen = examen;
		}




		protected String nom;
		protected String date;
		protected String ville;
		protected String rue;
		protected String pay;
		protected String cp;
		protected String email;
		protected int num;
		protected String sexe;
		protected String mdp;

		

		
		public Etudiant() {
		}




		




		/**
		 * @param cne
		 * @param cin
		 * @param prenom
		 * @param nom
		 * @param date
		 * @param ville
		 * @param pay
		 * @param email
		 * @param num
		 */
		public Etudiant(int cne, String sexe, String prenom, String nom, String date, String ville, String pay,
				String email, int num) {
			this.cne = cne;
			this.sexe = sexe;
			this.prenom = prenom;
			this.nom = nom;
			this.date = date;
			this.ville = ville;
			this.pay = pay;
			this.email = email;
			this.num = num;
		}









	








		public int getCne() {
			return cne;
		}




		public void setCne(int cne) {
			this.cne = cne;
		}




		public String getCin() {
			return cin;
		}




		public void setCin(String cin) {
			this.cin = cin;
		}

		

		public String getSanction() {
			return sanction;
		}




		public void setSanction(String cin) {
			this.sanction = cin;
		}



		public String getPrenom() {
			return prenom;
		}




		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}




		public String getNom() {
			return nom;
		}




		public void setNom(String nom) {
			this.nom = nom;
		}




		public String getDate() {
			return date;
		}




		public void setDate(String date) {
			this.date = date;
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




		public String getCp() {
			return cp;
		}




		public void setCp(String cp) {
			this.cp = cp;
		}




		public String getEmail() {
			return email;
		}




		public void setEmail(String email) {
			this.email = email;
		}




		public int getNum() {
			return num;
		}




		public void setNum(int num) {
			this.num = num;
		}




		public String getSexe() {
			return sexe;
		}




		public void setSexe(String sexe) {
			this.sexe = sexe;
		}




		public String getMdp() {
			return mdp;
		}




		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
		
		



	}


