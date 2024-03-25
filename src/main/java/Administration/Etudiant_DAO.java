package Administration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Etudiant_DAO {
	


	
	static String connectionUrl="jdbc:mysql://localhost:3306/absence";
	static String dbUser="root";
	static String dbPwd="123654789";

	private static final String INSERT_USERS_SQL = "INSERT INTO etudiants" + "  (CNE,CNI, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,mot_de_passe,idc) VALUES "
			+ " (?,?,?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_USER_BY_ID = "select CNE,CNI, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,mot_de_passe,nomc,classe.idc from etudiants JOIN classe ON etudiants.idc = classe.idc where CNE = ?";
	//private static final String SELECT_USER_BY_ID1 = "select nomc from classe where idc in (select idc from etudiants where CNE= ?) ;";
	private static final String SELECT_ALL_USERS = "select CNE,CNI, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,mot_de_passe,nomc,classe.idc from etudiants JOIN classe ON etudiants.idc = classe.idc";
	private static final String DELETE_USERS_SQL = "delete from etudiants where CNE = ?;";
	private static final String DELETE_USERS_SQL1 ="delete from absence where CNE = ?;";
	private static final String DELETE_USERS_SQL3 ="delete from abscence_module where ida in(Select ida from absence where CNE =?);";

	
			private static final String DELETE_USERS_SQL2 ="delete  from module_etudiant where CNE = ?;";
			private static final String SELECT_USERS_MAJORS = "select CNE,CNI, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,mot_de_passe,nomc,classe.idc from etudiants JOIN classe ON etudiants.idc = classe.idc where nomc=? ;";

	private static final String UPDATE_USERS_SQL = "update  etudiants set CNI= ?, nom = ?,prenom= ?, date_de_naissance =? , ville =? , rue =? , pay =? , code_postale =? , email =? , sexe=? ,  mot_de_passe =?,idc=? where CNE =?";

	public Etudiant_DAO() {
	}

	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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

	public static void insertUser(Etudiant user) throws SQLException {
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			) {
			

			preparedStatement.setInt(1, user.getCNE());
			preparedStatement.setString(2, user.getCIN());
			preparedStatement.setString(3, user.getNom());
			preparedStatement.setString(4, user.getPrenom());
			preparedStatement.setString(5, user.getDate_de_naissance());
			preparedStatement.setString(6, user. getVille());
			preparedStatement.setString(7, user.getRue());
			preparedStatement.setString(8, user.getPay());
			preparedStatement.setString(9, user.getCode_postale());
			preparedStatement.setString(10, user.getEmail());
			preparedStatement.setString(11, user.getSexe());
			preparedStatement.setString(12, user.getMot_de_passe());
			System.out.println(preparedStatement);
			preparedStatement.setInt(13, user.getId()); 
			int i=preparedStatement.executeUpdate();  
			System.out.println(i+" records affected");
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public static List<Etudiant> select_by_majors(String major) {
		List<Etudiant> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_MAJORS);) {
			preparedStatement.setString(1, major);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE =  rs.getInt("CNE");
				String CNI = rs.getString("CNI");

				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String date_de_naissance = rs.getString("date_de_naissance");
				String ville = rs.getString("ville");
				String rue = rs.getString("rue");
				String pay = rs.getString("pay");
				String code_postale = rs.getString("code_postale");
				String email = rs.getString("email");
				String sexe = rs.getString("sexe");
				String m_d_p = rs.getString("mot_de_passe");
				String nomc= rs.getString("nomc");
				int idc =  rs.getInt("idc");
				users.add (new Etudiant(CNE,CNI, name, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,m_d_p,nomc,idc));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	public static Etudiant selectUser(int id) {
		Etudiant user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
				//PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_USER_BY_ID1);

				)
		{
			preparedStatement.setInt(1, id);
			//preparedStatement1.setInt(1, id);

			System.out.println(preparedStatement);
			//System.out.println(preparedStatement1);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			//ResultSet rs1 = preparedStatement1.executeQuery();


			// Step 4: Process the ResultSet object.
			while (rs.next()  ) {
				int CNE =  rs.getInt("CNE");
				String CIN = rs.getString("CNI");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String date_de_naissance = rs.getString("date_de_naissance");
				String ville = rs.getString("ville");
				String rue = rs.getString("rue");
				String pay = rs.getString("pay");
				String code_postale = rs.getString("code_postale");
				String email = rs.getString("email");
				//int Numero_tele = rs.getInt("Numero_tele");
				String sexe = rs.getString("sexe");
				String m_d_p = rs.getString("mot_de_passe");
				String nomc = rs.getString("nomc");
				int idc =  rs.getInt("idc");
				user = new Etudiant(CNE,CIN, name, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,m_d_p,nomc,idc);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public static List<Etudiant> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Etudiant> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE= rs.getInt("CNE");
				String CIN= rs.getString("CNI");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String date_de_naissance = rs.getString("date_de_naissance");
				String ville = rs.getString("ville");
				String rue = rs.getString("rue");
				String pay = rs.getString("pay");
				String code_postale = rs.getString("code_postale");
				String email = rs.getString("email");
				
				//int Numero_tele = rs.getInt("Numero_tele");
				String sexe = rs.getString("sexe");
				String m_d_p = rs.getString("mot_de_passe");
				String nomc = rs.getString("nomc");
				int idc =  rs.getInt("idc");
				users.add(new Etudiant(CNE,CIN, name, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,m_d_p,nomc,idc));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public static  boolean deleteUser(int CNE) throws SQLException {
		boolean rowDeleted;
		
		
	
		try (Connection connection = getConnection();
				PreparedStatement statement3 = connection.prepareStatement(DELETE_USERS_SQL3);
				PreparedStatement statement1 = connection.prepareStatement(DELETE_USERS_SQL1);

				PreparedStatement statement2 = connection.prepareStatement(DELETE_USERS_SQL2);
				
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
		){
			statement3.setInt(1, CNE);
			statement1.setInt(1, CNE);

			statement2.setInt(1, CNE);
			statement.setInt(1, CNE);
			rowDeleted = statement3.executeUpdate() > 0;

			rowDeleted = statement1.executeUpdate() > 0;
			rowDeleted = statement2.executeUpdate() > 0;
			rowDeleted = statement.executeUpdate() > 0;
		
		}
		return rowDeleted; 
		
	
	}
	public static boolean updateUser(Etudiant user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getCIN());
			statement.setString(2, user.getNom());
			statement.setString(3, user.getPrenom());
			statement.setString(4, user.getDate_de_naissance());
			statement.setString(5, user.getVille());
			statement.setString(6, user.getRue());
			statement.setString(7, user.getPay());
			statement.setString(8, user.getCode_postale());
			statement.setString(9, user. getEmail());
			//statement.setInt(10, user.getNum_tele());
			statement.setString(10, user.getSexe());
			statement.setString(11, user.getMot_de_passe());
			statement.setInt(12 , user.getId());
			statement.setInt(13 , user.getCNE());
			rowUpdated = statement.executeUpdate()> 0;
		}
		return rowUpdated;
	}

	private static void printSQLException(SQLException ex) {
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
