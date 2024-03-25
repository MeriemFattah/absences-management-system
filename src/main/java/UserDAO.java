




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
public class UserDAO {
	String connectionUrl="jdbc:mysql://localhost:3306/absence";
	String dbUser="root";
	String dbPwd="123654789";

	private static final String INSERT_USERS_SQL = "INSERT INTO modules VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = " select distinct etudiants.CNE ,etudiants.nom,etudiants.prenom from\r\n"
	 		+ "etudiants inner join classe \r\n"
	 		+ "on etudiants.idc=classe.idc inner join est_enseignee\r\n"
	 		+ "on est_enseignee.idc =classe.idc inner join modules\r\n"
	 		+ "on modules.CNI=est_enseignee.CNI\r\n"
	 		+ " where  etudiants.CNE= ? and classe.nomc= ?  and modules.nom_module=?  ";
	private static final String SELECT_ALL_USERS =" select distinct etudiants.CNE ,etudiants.nom,etudiants.prenom,classe.nomc,modules.nom_module from\r\n"
	 		+ "etudiants inner join classe \r\n"
	 		+ "on etudiants.idc=classe.idc inner join est_enseignee\r\n"
	 		+ "on est_enseignee.idc =classe.idc inner join modules\r\n"
	 		+ "on modules.CNI=est_enseignee.CNI\r\n"
	 		+ " where classe.nomc=? and modules.nom_module=? and est_enseignee.CNI=?";
	private static final String DELETE_USERS_SQL = "delete from modules where idm = ?";
	private static final String UPDATE_USERS_SQL = "insert  into absence values (?,?,?,?,?)";

	public UserDAO() {
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

	public void insertUser(User_ens newUser) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1,newUser.getId() );
			preparedStatement.setString(2, newUser.getNom());
			preparedStatement.setInt(3,  newUser.getCNE());
	
			int i=preparedStatement.executeUpdate();  
			System.out.println(i+" records affected"); 
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User_ens selectUser(int id,String niveau,String module) {
		User_ens user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, niveau);
			preparedStatement.setString(3,module);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int Id =  rs.getInt("CNE");
				String name = rs.getString("nom");
				String CNI = rs.getString("prenom");
			
				
			
				user = new User_ens(Id, name, CNI);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User_ens> selectAllUsers(int CNI,String niveau,String module) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User_ens> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			preparedStatement.setString(1, niveau);
			preparedStatement.setString(2, module);
			preparedStatement.setInt(3, CNI);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int CNE= rs.getInt("CNE");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String niveau1 =rs.getString("nomc");
				String module1 =rs.getString("nom_module");
		

				
				
				users.add(new User_ens(CNE, name, prenom,niveau1,module1));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	public boolean updateUser(User_ens book) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			statement.setInt(1,0);
			statement.setString(2,  book.getEtat());
			statement.setString(3, book.getJustif());
			statement.setString(4, book.getDate_absence());
			statement.setInt(5, book.getCNE());
	
			 rowUpdated = statement.executeUpdate()> 0;
		}
		return rowUpdated;
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

