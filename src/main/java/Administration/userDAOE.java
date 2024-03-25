package Administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class userDAOE {
	static String connectionUrl="jdbc:mysql://localhost:3306/Absence";
	static String dbUser="root";
	static String dbPwd="123654789";

	private static final String INSERT_USERS_SQL = "INSERT INTO enseignants" + "  (CNI, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,etat,statut,grades,mot_de_passe) VALUES "
			+ " (?, ?, ?,?,?,?,?,?,?,?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select CNI, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,etat,statut,grades,mot_de_passe from enseignants where CNI = ?";
	private static final String SELECT_ALL_USERS = "select * from enseignants";
	private static final String DELETE_USERS_SQL = "delete from enseignants where CNI = ?;";
	private static final String UPDATE_USERS_SQL = "update enseignants set nom = ?,prenom= ?, date_de_naissance =? , ville =? , rue =? , pay =? , code_postale =? , email =? , etat =? , statut =? , grades =? , mot_de_passe =? where CNI =?";
	private static final String SELECT_USERS_MAJORS = "select * from enseignants where CNI in (select CNI from est_enseignee where idc in (select idc from classe where nomc= ?))";
	
	public userDAOE() {
	}

	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void insertUser(USER user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, user.getCNI());
			preparedStatement.setString(2, user.getNom());
			preparedStatement.setString(3, user.getPrenom());
			preparedStatement.setString(4, user.getDate_de_naissance());
			preparedStatement.setString(5, user. getVille());
			preparedStatement.setString(6, user.getRue());
			preparedStatement.setString(7, user.getPay());
			preparedStatement.setString(8, user.getCode_postale());
			preparedStatement.setString(9, user.getEmail());
			preparedStatement.setString(10, user.getEtat());
			preparedStatement.setString(11, user.getStatut());
			preparedStatement.setString(12, user. getGrades());
			preparedStatement.setString(13, user.getMot_de_passe());
			int i=preparedStatement.executeUpdate();  
			System.out.println(i+" records affected"); 
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public static List<USER> select_by_majors(String major) {
			List<USER> users = new ArrayList<>();
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
					int CNI =  rs.getInt("CNI");
					String name = rs.getString("nom");
					String prenom = rs.getString("prenom");
					String date_de_naissance = rs.getString("date_de_naissance");
					String ville = rs.getString("ville");
					String rue = rs.getString("rue");
					String pay = rs.getString("pay");
					String code_postale = rs.getString("code_postale");
					String email = rs.getString("email");
					String etat = rs.getString("etat");
					String statut = rs.getString("statut");
					String grades= rs.getString("grades");
					String m_d_p = rs.getString("mot_de_passe");
					users.add (new USER(CNI, name, prenom,date_de_naissance,ville,rue,pay,code_postale,email,etat,statut,grades,m_d_p));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return users;
		}
	

	public static USER selectUser(int id) {
		USER user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNI =  rs.getInt("CNI");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String date_de_naissance = rs.getString("date_de_naissance");
				String ville = rs.getString("ville");
				String rue = rs.getString("rue");
				String pay = rs.getString("pay");
				String code_postale = rs.getString("code_postale");
				String email = rs.getString("email");
				String etat = rs.getString("etat");
				String statut = rs.getString("statut");
				String grades= rs.getString("grades");
				String m_d_p = rs.getString("mot_de_passe");
				user = new USER(CNI, name, prenom,date_de_naissance,ville,rue,pay,code_postale,email,etat,statut,grades,m_d_p);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public static List<USER> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<USER> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNI= rs.getInt("CNI");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String date_de_naissance = rs.getString("date_de_naissance");
				String ville = rs.getString("ville");
				String rue = rs.getString("rue");
				String pay = rs.getString("pay");
				String code_postale = rs.getString("code_postale");
				String email = rs.getString("email");
				
				String etat = rs.getString("etat");
				String statut = rs.getString("statut");
				String grades= rs.getString("grades");
				String m_d_p = rs.getString("mot_de_passe");
				users.add(new USER(CNI, name, prenom,date_de_naissance,ville,rue,pay,code_postale,email,etat,statut,grades,m_d_p));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public static boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	public static boolean updateUser(USER user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			statement.setString(1, user.getNom());
			statement.setString(2, user.getPrenom());
			statement.setString(3, user.getDate_de_naissance());
			statement.setString(4, user.getVille());
			statement.setString(5, user.getRue());
			statement.setString(6, user.getPay());
			statement.setString(7, user.getCode_postale());
			statement.setString(8, user. getEmail());
			statement.setString(9, user.getEtat());
			statement.setString(10, user.getStatut());
			statement.setString(11, user.getGrades());
			statement.setString(12, user.getMot_de_passe());
			statement.setInt(13 , user.getCNI());
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
