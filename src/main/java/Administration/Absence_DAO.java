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
public class Absence_DAO {
	static String connectionUrl="jdbc:mysql://localhost:3306/absence";
	static String dbUser="root";
	static String dbPwd="123654789";

	private static final String INSERT_USERS_SQL = "update etudiants set sanction=? where CNE=? ";

	private static final String SELECT_USER_BY_ID = " select etudiants.CNE,nom,prenom,count(absence.ida)as abs,sanction from absence inner join etudiants on etudiants.CNE=absence.CNE where etudiants.CNE=? and  absence.etat=\"oui\" group by etudiants.CNE;";
	private static final String SELECT_ALL_USERS = "select etudiants.CNE,nom,prenom,count(absence.ida)as abs,sanction from etudiants inner join absence on etudiants.CNE=absence.CNE where etat=\"oui\" group by etudiants.CNE" ;
	private static final String DELETE_USERS_SQL = "update etudiants set  sanction = \"  \" where CNE = ?";
	private static final String UPDATE_USERS_SQL = "update etudiants set sanction = ? where CNE =?";

	public Absence_DAO() {
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

	public static User1 selectUser(String id) {
		User1 user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE = rs.getInt("CNE");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int abs = rs.getInt("abs");
				String sanction =rs.getString("sanction");
			
				user = new User1( CNE, nom,prenom,abs,sanction);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public static List<User1> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User1> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE = rs.getInt("CNE");
				String nom = rs.getString("nom");
				String n = rs.getString("prenom");
				int abs= rs.getInt("abs");
				String p = rs.getString("sanction");
				users.add(new User1(CNE, nom,n,abs,p));
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
	public static boolean updateUser(User1 user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			statement.setString(1, user.getSanction());
			statement.setInt(2, user.getCNE());
	
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
