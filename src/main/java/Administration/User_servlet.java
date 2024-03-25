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

@WebServlet("/PROFESSORS_SPACE")
public class User_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAOE userDAO;

	public void init() {
		userDAO= new userDAOE();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action =request.getParameter("action");
		if("show".equals(action)) {
			try {
				showEditForm(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("lister".equals(action)) {
			try {
				listUser(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("ajouter".equals(action)) {
			try {
				showNewForm(request, response);
				
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("insert".equals(action)) {
			try {
				insertUser(request, response);
				
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("enter".equals(action)) {
			try {
				search_users_Majors(request, response);
				
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("search".equals(action)) {
			try {
				searchuser(request, response);
				
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("update".equals(action)) {
			try {
				updateUser(request, response);
				
			} catch ( IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("oumaima".equals(action)) {
			try {
				listUser(request, response);
				
			} catch ( IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
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
		List<USER> listUser;
			listUser = userDAOE.selectAllUsers();
		
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listP.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-formE.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("CNI"));
		USER existingUser = userDAOE.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-formE.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNI = Integer.parseInt(request.getParameter("CNI"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String date_de_naissance = request.getParameter("date_de_naissance");
		String ville = request.getParameter("ville");
		String rue = request.getParameter("rue");
		String pay = request.getParameter("pay");
		String code_postale= request.getParameter("code_postale");
		String email = request.getParameter("email");
		String etat = request.getParameter("etat");
		String statut = request.getParameter("statut");
		String grades = request.getParameter("grades");
		String m_d_p = request.getParameter("mot_de_passe");
		USER newUser = new USER(CNI, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,etat,statut,grades,m_d_p);
		userDAOE.insertUser(newUser);
		listUser(request,response);
	}



	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNI =Integer.parseInt (request.getParameter("CNI"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String date_de_naissance = request.getParameter("date_de_naissance");
		String ville = request.getParameter("ville");
		String rue = request.getParameter("rue");
		String pay = request.getParameter("pay");
		String code_postale= request.getParameter("code_postale");
		String email = request.getParameter("email");
		String etat = request.getParameter("etat");
		String statut = request.getParameter("statut");
		String grades = request.getParameter("grades");
		String m_d_p = request.getParameter("mot_de_passe");
		USER book = new USER(CNI,nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,etat,statut,grades,m_d_p);
		userDAOE.updateUser(book);
		List<USER> listUser = userDAOE.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listP.jsp");
		dispatcher.forward(request, response);
	}

	public void searchuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("chercher"));
		USER existingUser = userDAOE.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	public void search_users_Majors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String major = request.getParameter("choix");
		List<USER> listUser = userDAOE.select_by_majors(major);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("listP.jsp");
		request.setAttribute("listUser", listUser);
		dispatcher.forward(request, response);
	}


}
