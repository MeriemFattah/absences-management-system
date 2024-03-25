



import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/fichierEnseignant")
public class fichierEnseignant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private fichierEnseignant_DAO userDAO;

	public void init() {
		userDAO = new fichierEnseignant_DAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String action = request.getServletPath();
		switch (action) {
//		case "/s":
//			searchuser(request,response);
//			break;
		default:
			Afficher (request,response);
			break;
		
		
		}
	}
	private void Afficher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("InterfaceInitiale.jsp");
		
	}

	public void searchuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("chercher"));
		Enseignant existingUser = userDAO.selectUser(1213);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	
}