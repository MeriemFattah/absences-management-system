package Etudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class noteDAO {

	String connectionUrl="jdbc:mysql://localhost:3306/absence";
	String dbUser="root";
	String dbPwd="123654789";


	private static final String SELECT_ALL_USERS = "select etudiants.CNE ,nom_module ,nom ,prenom,TP,controle ,examen \r\n"
			+ " from etudiants inner join module_etudiant\r\n"
			+ " on module_etudiant.CNE=etudiants.CNE inner join modules \r\n"
			+ " on modules.idm=module_etudiant.idm\r\n"
			+ " where etudiants.CNE=? group by nom_module ;";
	
	 
	public noteDAO() {
	}

	protected Connection getConnection() {
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

	public List<Etudiant> selectAllUsers(int CNI) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Etudiant> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
		
			preparedStatement.setInt(1, CNI);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE= rs.getInt("CNE");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String niveau1 =rs.getString("nom_module");
				int TP =rs.getInt("TP");
				int controle =rs.getInt("controle");
				int examen =rs.getInt("examen");
				
		

				
				
				users.add(new Etudiant(CNE, name, prenom,niveau1,TP,controle,examen));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}


	
		

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}


}
