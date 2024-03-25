

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class etud_note{
	 static String connectionUrl="jdbc:mysql://localhost:3306/absence";
	 static String dbUser="root";
	 static String dbPwd="123654789";
	private static final String UPDATE_Etudiant_SQL = "update module_etudiant set TP = ?,Controle= ?, examen =?  where CNE =? and idm in (select idm from modules where nom_module=?)";
	private static final String SELECT_Etudiant =(" SELECT etudiants.CNE ,nom,nomc,prenom,nom_module,TP,Controle,Examen FROM (etudiants  JOIN classe ON etudiants.idc = classe.idc) join (module_etudiant JOIN modules ON modules.idm = module_etudiant.idm) ON etudiants.CNE = module_etudiant.CNE where nom_module =? and nomc in (select nomc from classe where nomc=?) and classe.idc in (select idc from est_enseignee where CNI=?)");
	private static final String SELECT_Note_BY_ID = "SELECT etudiants.CNE,nomc ,nom,prenom,nom_module,TP,Controle,Examen FROM (etudiants  JOIN classe ON etudiants.idc = classe.idc) join (module_etudiant JOIN modules ON modules.idm = module_etudiant.idm) ON etudiants.CNE = module_etudiant.CNE where etudiants.CNE = ? and nom_module= ? and nomc=?";
	private static final String SELECT_Modules="Select nom_module from modules where CNI=?"; 
	
	   
	
	
	
	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static List<etudiant_module> select_Modules(int id) {
		List<etudiant_module> Modules = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Modules);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String module =  rs.getString("nom_module");
				Modules.add (new etudiant_module(module));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Modules;
	}
	
	
	public static List<etudiant_module> select_Etudiant(String major,String nom_module,int CNI) {
		List<etudiant_module> Etudiant = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Etudiant);) {
			preparedStatement.setString(1, nom_module);
			preparedStatement.setString(2, major);
			preparedStatement.setInt(3, CNI);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE =  rs.getInt("CNE");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				float tp = rs.getFloat("TP");
				float Controle= rs.getFloat("Controle");
				float examen = rs.getFloat("examen");
				String nom_module1 = rs.getString("nom_module");
				String nom_classe= rs.getString("nomc");
				Etudiant.add (new etudiant_module(CNE,name,prenom,tp,Controle,examen,nom_module1,nom_classe));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Etudiant;
	}
	
	public static boolean updateUser(etudiant_module Etudiant) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Etudiant_SQL);) {
			
	
			statement.setFloat(1, Etudiant.getTP());
			statement.setFloat(2, Etudiant.getControle());
			statement.setFloat(3, Etudiant.getExamen());
			statement.setInt(4 , Etudiant.getCNE());
			statement.setString(5 , Etudiant.getNom_module());
			 rowUpdated = statement.executeUpdate()> 0;
		}
		return rowUpdated;
	}
	
	public static etudiant_module selectUser(int id , String nom_module,String nom_classe) {
		etudiant_module user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Note_BY_ID);) {
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, nom_module);
			preparedStatement.setString(3, nom_classe);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE =  rs.getInt("CNE");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String nom_module1 = rs.getString("nom_module");
				float tp = rs.getFloat("TP");
				float Controle  = rs.getFloat("Controle");
				float examen = rs.getFloat("examen");
				String nom_cl= rs.getString("nomc");
				user = new etudiant_module(CNE, name, prenom,tp,Controle,examen,nom_module1,nom_cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
