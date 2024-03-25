package Etudiant;





import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/fichierEtudiant")
public class fichierEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtdDAO userDAO;

	public void init() {
		userDAO = new EtdDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String action = request.getServletPath();
		switch (action) {

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
		int id =  (int) getServletContext().getAttribute("username");;
		Etudiant existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formEtud.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	
}