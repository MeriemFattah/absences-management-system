package Password_modification;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class modifier_servlet
 */
@WebServlet("/modifier")
public class modifier_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		 System.out.println(action);
		 if("modifier_pass".equals(action)) {
			 try {
				selectPassword(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		 }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void updatepassword(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int CNI   =  (int) getServletContext().getAttribute("username");
		String pass = request.getParameter("confirme_password");
		modifier password = new modifier (CNI,pass);
		modifier_DAO.updatepassword(password);
	}
	private void selectPassword(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int CNI = (int) getServletContext().getAttribute("username");
		String password =modifier_DAO.selectpassword(CNI);
		System.out.println(password);
		String inputData = request.getParameter("pass");
		String pass1 = request.getParameter("confirme_password");
		String pass2 = request.getParameter("new_password");
		if(password.equals(inputData)) {
			if(pass1.equals(pass2)) {
			updatepassword(request,response);
			request.setAttribute("successMessage", "Your password has been changed successfully");
	        request.getRequestDispatcher("change_pass_admin.jsp").forward(request, response);
			}
			else {
				  request.setAttribute("errorMessage", "new password must be different from the confirme password");
		          request.getRequestDispatcher("change_pass_admin.jsp").forward(request, response);
			}
		}
		else {
			  request.setAttribute("errorMessage", " incorrect Old password ");
	          request.getRequestDispatcher("change_pass_admin.jsp").forward(request, response);
		}
			
		

		 
			
	}

}
