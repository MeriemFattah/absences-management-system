

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String action = request.getParameter("action");
			if("log_in".equals(action)) {
				try {
					 int username  =Integer.parseInt(request.getParameter("username"));
					int password =Integer.parseInt(request.getParameter("password"));
					
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/absence", "root", "123654789");
		PreparedStatement preparedStatement = connection.prepareStatement("select * from enseignants where CNI=? and mot_de_passe=? ;");
		preparedStatement.setInt(1,username);
		preparedStatement.setInt(2,password);
		 getServletContext().setAttribute("username", username);
		ResultSet rs= preparedStatement.executeQuery();
			if(rs.next()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("fichierEnseignant");
			dispatcher.forward(request,response);}
			else {
				request.setAttribute("status", "failed");
				response.sendRedirect("login.jsp");
			}
					
				}
				catch(Exception e) {
					e.getStackTrace();
				}
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
		
	
	}

}
