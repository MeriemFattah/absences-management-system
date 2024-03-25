

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Professor_space
 */
@WebServlet("/Professor_Space")
public class Professor_Space extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Professor_Space() {
        super();
        // TODO Auto-generated constructor stub
    }

    fichierEnseignant_DAO fichierEnseignant_DAO =new fichierEnseignant_DAO();
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
		//		int id = Integer.parseInt(request.getParameter("chercher"));
		int CNI   =  (int) getServletContext().getAttribute("username");
		Enseignant existingUser = fichierEnseignant_DAO.selectUser(CNI);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
}
