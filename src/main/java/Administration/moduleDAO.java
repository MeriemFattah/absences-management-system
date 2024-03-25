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
public class moduleDAO {
	static String connectionUrl="jdbc:mysql://localhost:3306/absence";
	static String dbUser="root";
	static String dbPwd="123654789";

	private static final String INSERT_USERS_SQL = "INSERT INTO modules VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select  idm,nom_module,CNI from modules where idm = ?";
	private static final String SELECT_ALL_USERS = "select idm,nom_module,modules.CNI,nom,prenom from\r\n"
			+ "modules inner join enseignants \r\n"
			+ "on modules.CNI=enseignants.CNI ";
	private static final String DELETE_USERS_SQL = "delete from modules where idm = ?";
	private static final String DELETE1_USERS_SQL = "delete from Abscence_module where idm=?";
	private static final String DELETE2_USERS_SQL=" delete from module_etudiant where idm=?";
	private static final String UPDATE_USERS_SQL = "update modules set  nom_module = ?,CNI=? where idm =?";

	public moduleDAO() {
	}

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

	public static void insertUser(module user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getNom());
			preparedStatement.setInt(3, user.getCNI());
	
			int i=preparedStatement.executeUpdate();  
			System.out.println(i+" records affected"); 
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public static module selectUser(int id) {
		module user = null;
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
				int Id =  rs.getInt("idm");
				String name = rs.getString("nom_module");
				int CNI = rs.getInt("CNI");
			
				
			
				user = new module(Id, name, CNI);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public static List<module> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<module> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNI= rs.getInt("idm");
				String name = rs.getString("nom_module");
				int prenom = rs.getInt("CNI");
				String n = rs.getString("nom");
				String p = rs.getString("prenom");

				
				
				users.add(new module(CNI, name, prenom,n,p));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public static boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement1 = connection.prepareStatement(DELETE1_USERS_SQL);
				PreparedStatement statement2 = connection.prepareStatement(DELETE2_USERS_SQL);
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
				statement1.setInt(1, id);
				statement2.setInt(1, id);
				statement.setInt(1, id);
				rowDeleted = statement1.executeUpdate() > 0;
				rowDeleted = statement2.executeUpdate() > 0;
				rowDeleted = statement.executeUpdate() > 0;
				
		}
		return rowDeleted;
	}
	public static boolean updateUser(module user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			statement.setInt(3, user.getId());
			statement.setString(1, user.getNom());
			statement.setInt(2, user.getCNI());
	
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

