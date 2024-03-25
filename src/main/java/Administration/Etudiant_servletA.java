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




@WebServlet("/STUDENTS")
public class Etudiant_servletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Etudiant_servletA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String action = request.getParameter("action");
		  System.out.println(action);
			    if ("edit_Etudiant".equals(action)) {
			    	try {
			    		showEditForm_Etudiant(request, response);
					} catch (SQLException | IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    else if ("delete_Etudiant".equals(action)) {
					    	try {
					    		deleteEtudiant(request, response);
							} catch (SQLException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    } 
			    else if("update_Etudiant".equals(action)){
			    	try {
			    		update_Etudiant(request, response);
					} catch (IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    else if("new_Etudiant".equals(action)){
			    	try {
			    		showNewForm_Etudiant(request, response);
						
					} catch (IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    else if("insert_Etudiant".equals(action)){
			    	try {
						insertEtudiant(request, response);
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    else if("search_Etudiant".equals(action)){
			    	try {
			    		search_Etudiant(request, response);
					} catch (IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    else if("Majors_etudiant".equals(action)){
			    	try {
			    		search_Etudiant_Majors(request, response);
					} catch (IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    else if("list_Etudiant".equals(action)){
			    	try {
			    		listEtudiant(request, response);
					} catch (IOException | ServletException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    
			    else if(action==null) {
					try {
						listEtudiant(request, response);
					} catch (SQLException | IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    
			    }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Etudiant> listUser = Etudiant_DAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list_Etudiant.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm_Etudiant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Etudiant_Forme.jsp");
		dispatcher.forward(request, response);
	}
	@SuppressWarnings("unused")
	private void showNewForm_Etudiant_major(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Etudiant_Forme_major.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm_Etudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("CNE"));
		Etudiant existingUser = Etudiant_DAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Etudiant_Forme.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertEtudiant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int CNE = Integer.parseInt(request.getParameter("CNE"));
		String CIN = request.getParameter("CIN");

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String date_de_naissance = request.getParameter("date_de_naissance");
		String ville = request.getParameter("ville");
		String rue = request.getParameter("rue");
		String pay = request.getParameter("pay");
		String code_postale= request.getParameter("code_postale");
		String email = request.getParameter("email");
		//int Numero_tele  =Integer.parseInt( request.getParameter("Numero_tele"));
		String sexe = request.getParameter("sexe");
		String m_d_p = request.getParameter("mot_de_passe");
		int idc= Integer.parseInt(request.getParameter("idc"));
		
		Etudiant newUser = new Etudiant(CNE,CIN, nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,m_d_p,idc);
		Etudiant_DAO.insertUser(newUser);
		//response.sendRedirect("list");
		try {
			listEtudiant(request, response);
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}
	public void search_Etudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("chercher"));
		Etudiant existingUser = Etudiant_DAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search_Etudiant.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void update_Etudiant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNE = Integer.parseInt(request.getParameter("CNE"));
		String CIN = request.getParameter("CIN");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String date_de_naissance = request.getParameter("date_de_naissance");
		String ville = request.getParameter("ville");
		String rue = request.getParameter("rue");
		String pay = request.getParameter("pay");
		String code_postale= request.getParameter("code_postale");
		String email = request.getParameter("email");
		//int Numero_tele  =Integer.parseInt( request.getParameter("Numero_tele"));
		String sexe = request.getParameter("sexe");
		String m_d_p = request.getParameter("mot_de_passe");
		int idc = Integer.parseInt(request.getParameter("idc"));
		Etudiant book = new Etudiant(CNE,CIN,nom, prenom,date_de_naissance,ville,rue,pay,code_postale,email,sexe,m_d_p,idc);
		Etudiant_DAO.updateUser(book);
		//response.sendRedirect("list");
		List<Etudiant> listUser = Etudiant_DAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list_Etudiant.jsp");
		dispatcher.forward(request, response);		
	}

	public void search_Etudiant_Majors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String major = request.getParameter("choix_etudiant");
		List<Etudiant> listUser = Etudiant_DAO.select_by_majors(major);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("search_Etudiant_by_majors.jsp");
		request.setAttribute("listUser", listUser);
		dispatcher.forward(request, response);}
	
	private void deleteEtudiant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("CNE"));

		Etudiant_DAO.deleteUser(id);
		try {
			listEtudiant(request, response);
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}

	}

}


