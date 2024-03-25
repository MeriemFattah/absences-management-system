package Administration;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/courses")
public class moduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private moduleDAO moduleDAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		  System.out.println(action);
			    if ("edit".equals(action)) {
			    	try {
			    		showEditForm(request, response);
					} catch (SQLException | IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    if("update".equals(action)) {
			    	try {
						updateUser(request, response);
					} catch (SQLException | IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    if("delete".equals(action)) {
			    	try {
			    		deleteUser(request, response);
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			  else if ("new".equals(action)) {
					    	try {
					    		showNewForm(request, response);
							} catch (IOException | ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  }
			else if ("insert".equals(action)) {
							
								 try {
									insertUser(request, response);
								} catch (SQLException | IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
			    }
			else if ("list".equals(action)) {
				
				 try {
					 listUser(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				  else  {
				    	try {
							listUser(request, response);
						} catch (SQLException | IOException | ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	}
			
}
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//			case "/new":
//				showNewForm(request, response);
//				break;
//			case "/insert":
//				insertUser(request, response);
//				break;
//			case "/delete":
//				deleteUser(request, response);
//				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
//			case "/update":
//				updateUser(request, response);
//				break;
//			default:
//				listUser(request, response);
//				break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}

	@SuppressWarnings("unused")
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<module> listUser = moduleDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("liste_module.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("module-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		module existingUser =moduleDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("module-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	@SuppressWarnings("unused")
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNI = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		int prenom = Integer.parseInt( request.getParameter("CNI"));

		module newUser = new module(CNI, nom, prenom);
		moduleDAO.insertUser(newUser);
		listUser(request,response);
	}

	@SuppressWarnings("unused")
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNI =Integer.parseInt (request.getParameter("id"));
		String nom = request.getParameter("nom");
		int prenom =Integer.parseInt ( request.getParameter("CNI"));
		
		module book = new module(CNI,nom, prenom);
		moduleDAO.updateUser(book);
		listUser(request,response);
		
	}

	@SuppressWarnings("unused")
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
	moduleDAO.deleteUser(id);
		listUser(request,response);

	}

}
