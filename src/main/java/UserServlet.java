

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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public void init() {
		userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if("fill".equals(action)) {
		try {
			showEditForm(request,response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if ("update".equals("action")) {
			try {
				updateUser(request, response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else if ("close".equals(action)) {
			response.sendRedirect("InterfaceInitiale.jsp");
		}
		else if ("chercher1".equals(action)) {
			try {
				listUser(request,response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				int CNI= (int)getServletContext().getAttribute("username");
				List<etudiant_module> listUser = etud_note.select_Modules(CNI);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("module1.jsp");
				request.setAttribute("listUser", listUser);
				dispatcher.forward(request, response);
				
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int CNI= (int) getServletContext().getAttribute("username");
		String niveau =request.getParameter("filiere1");
		String module =request.getParameter("cours1");
		List<User_ens> listUser = userDAO.selectAllUsers(CNI,niveau,module);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listy.jsp");
		dispatcher.forward(request, response);
	}

//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		dispatcher.forward(request, response);
//	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("CNE"));
		String niveau = request.getParameter("nom_classe");
		getServletContext().setAttribute("nom_classe",niveau);
		String module = request.getParameter("nom_module");
		getServletContext().setAttribute("nom_module",module);
		User_ens existingUser = userDAO.selectUser(id,niveau,module);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNE =Integer.parseInt (request.getParameter("CNE"));
		String nom = request.getParameter("etat");
		String prenom =request.getParameter("justif");
		String date_absence = request.getParameter("date_absence");
		
		User_ens book = new User_ens(CNE,nom, prenom,date_absence);
		userDAO.updateUser(book);
		int CNI= (int) getServletContext().getAttribute("username");
		String niveau =(String) getServletContext().getAttribute("nom_classe");
		String module =(String) getServletContext().getAttribute("nom_module");
		List<User_ens> listUser = userDAO.selectAllUsers(CNI,niveau,module);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listy.jsp");
		dispatcher.forward(request, response);
		
	}
	



}
