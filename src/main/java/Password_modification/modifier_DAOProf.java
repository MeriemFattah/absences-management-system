package Password_modification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class modifier_DAOProf {
		static String connectionUrl="jdbc:mysql://localhost:3306/absence";
		static String dbUser="root";
		static String dbPwd="123654789";

		private static final String select_password = "select mot_de_passe from  enseignants where CNI= "
				+ " (?);";
		private static final String UPDATE_password = "update enseignants  set  mot_de_passe = ? where CNI =?";
		protected static Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		}
		public static boolean updatepassword(modifier password) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement( UPDATE_password);) {
				
				statement.setString(1,password.getPassword());
				statement.setInt(2, password.getUsername());
				System.out.println(statement);
				 rowUpdated = statement.executeUpdate()> 0;
			}
			return rowUpdated;
		}
		public static String selectpassword(int username) {
			String passwordd = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(select_password);) {
				preparedStatement.setInt(1, username);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String pass = rs.getString("mot_de_passe");
					passwordd=pass;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return passwordd;
		}
	}




