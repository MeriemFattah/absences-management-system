package Etudiant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Etudiant_Space
 */
@WebServlet("/Etudiant_Space")
public class Etudiant_Space extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Etudiant_Space() {
        super();
        // TODO Auto-generated constructor stub
    }

    EtdDAO fichierEnseignant_DAO =new EtdDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		switch (action) {
		default:
			searchuser(request,response);
			break;
		
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void searchuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CNI   =  (int) getServletContext().getAttribute("username");
		Etudiant existingUser = fichierEnseignant_DAO.selectUser(CNI);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formEtud.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
}
