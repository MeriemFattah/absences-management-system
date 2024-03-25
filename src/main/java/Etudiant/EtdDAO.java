package Etudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtdDAO {







		


		
			String connectionUrl="jdbc:mysql://localhost:3306/absence";
			String dbUser="root";
			String dbPwd="123654789";


			private static final String SELECT_USER_BY_ID = "select CNE , nom, prenom, date_de_naissance, ville, rue, pay, code_postale, email,  sexe, mot_de_passe from etudiants where etudiants.CNE = ?";
			
			 
			public EtdDAO() {
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

			public Etudiant selectUser(int id) {
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
						String name = rs.getString("nom");
						String prenom = rs.getString("prenom");

						String pay = rs.getString("pay");
						
						String etat = rs.getString("sexe");
						String email = rs.getString("email");
						int tel = rs.getInt("mot_de_passe");
						String date_de_naissance = rs.getString("date_de_naissance");
						String ville = rs.getString("ville");


						user = new Etudiant(CNE,etat,prenom,name,date_de_naissance,ville,pay,email,tel);
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				return user;
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



