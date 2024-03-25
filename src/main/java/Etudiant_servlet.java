

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
 * Servlet implementation class Etudiant_servlet
 */
@WebServlet("/Etudiant_servlet")
public class Etudiant_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Etudiant_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("chercher".equals(action)) {
			select_Etudiant(request,response);
		}
		else if("edit".equals(action)) {
			try {
				showEditForm(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if("update".equals(action)) {
			try {
				updateUser(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if("close".equals(action)) {
			response.sendRedirect("InterfaceInitiale.jsp");
			
		}
		else {
			select_Modules(request,response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@SuppressWarnings("unused")
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("CNE"));
	String nom_module =request.getParameter("nom_module");
	String nom_classe =request.getParameter("nom_classe");
		etudiant_module existingUser = etud_note.selectUser(id,nom_module,nom_classe);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Etudiant_form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
	@SuppressWarnings("unused")
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNE =Integer.parseInt (request.getParameter("CNE"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		float TP=Float.parseFloat( request.getParameter("TP"));
		float Controle = Float.parseFloat(request.getParameter("Controle"));
		float examen = Float.parseFloat(request.getParameter("examen"));
		String nom_module = request.getParameter("nom_module");
		String nom_classe = request.getParameter("nomc");
		etudiant_module etudiant= new etudiant_module(CNE,nom, prenom,TP,Controle,examen,nom_module,nom_classe);
		etud_note.updateUser(etudiant);
		String major = request.getParameter("nom_classe");
		String cours = request.getParameter("nom_module");
		int CNI = (int) getServletContext().getAttribute("username");
		List<etudiant_module> listUser = etud_note.select_Etudiant(major,cours,CNI);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("liste_etudiant.jsp");
		request.setAttribute("listUser", listUser);
		dispatcher.forward(request, response);
		
	}

	public void select_Etudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String major = request.getParameter("filiere");
		String cours = request.getParameter("cours");
		int CNI = (int) getServletContext().getAttribute("username");
		List<etudiant_module> listUser = etud_note.select_Etudiant(major,cours,CNI);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("liste_etudiant.jsp");
		request.setAttribute("listUser", listUser);
		dispatcher.forward(request, response);
	}
	public void select_Modules(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CNI= (int)getServletContext().getAttribute("username");
		List<etudiant_module> listUser = etud_note.select_Modules(CNI);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("module.jsp");
		request.setAttribute("listUser", listUser);
		dispatcher.forward(request, response);
	}
	public void select_Etudiant2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String major = request.getParameter("nom_classe");
		String cours = request.getParameter("nom_module");
		int CNI = (int) getServletContext().getAttribute("username");
		List<etudiant_module> listUser = etud_note.select_Etudiant(major,cours,CNI);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("liste_etudiant.jsp");
		request.setAttribute("listUser", listUser);
		dispatcher.forward(request, response);
	}
	
}

