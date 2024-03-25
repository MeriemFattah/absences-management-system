package Administration;



public class module {
	protected int id;
	protected String nom;
	protected int CNI;
	protected String n;
	protected String p;
	
	public module() {
	}

	public int getCNI() {
		return CNI;
	}

	public void setCNI(int CNI) {
		this.CNI = CNI;
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

	public void setN(String n) {
		this.n = n;
	}
	public String getN() {
		return n;
	}

	public void setP(String p) {
		this.p = p;
	}
	public String getP() {
		return p;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public module(int id, String nom, int CNI ) {
		super();
		this.id = id;
		this.nom = nom;
		this.CNI=CNI;}
	

	






	public module(int id, String nom, int CNI,String n,String p ) {
		super();
		this.id = id;
		this.nom = nom;
		this.CNI=CNI;
		this.n=n;
		this.p=p;
		
	
	}





}


