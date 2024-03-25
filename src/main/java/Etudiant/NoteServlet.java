package Etudiant;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NoteServlet
 */
@WebServlet("/NoteServlet")
public class NoteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    noteDAO fichierEnseignant_DAO =new noteDAO();
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
		List<Etudiant> existingUser = fichierEnseignant_DAO.selectAllUsers(CNI);
		request.setAttribute("listUser", existingUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NoteEtd1.jsp");
		dispatcher.forward(request, response);
	}

}
