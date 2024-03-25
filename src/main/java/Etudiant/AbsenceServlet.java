package Etudiant;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AbsenceServlet
 */
@WebServlet("/AbsenceServlet")
public class AbsenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbsenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    AbsDAO fichierEnseignant_DAO =new AbsDAO();
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("AbsEtud.jsp");
		dispatcher.forward(request, response);
	}
}
