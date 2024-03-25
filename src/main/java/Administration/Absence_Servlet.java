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
import javax.servlet.http.HttpSession;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/Absence")
public class Absence_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
		    else if ("delete".equals(action)) {
				    	try {
				    		deleteUser(request, response);
						} catch (SQLException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    } 
		    else if("update".equals(action)){
		    	try {
					updateUser(request, response);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    
		    else if(action==null) {
				try {
					listUser(request, response);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
		    }
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User1> listUser = Absence_DAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list_Absence.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Absence_form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = (request.getParameter("CNE"));
		System.out.println(id);
		User1 existingUser = Absence_DAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Absence_form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNE =Integer.parseInt (request.getParameter("CNE"));
		String nom = request.getParameter("sanction");
		
		User1 book = new User1(CNE,nom);
		Absence_DAO.updateUser(book);
		listUser(request,response);
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNE = Integer.parseInt(request.getParameter("CNE"));
		Absence_DAO.deleteUser(CNE);
		listUser(request,response);

	}

}
