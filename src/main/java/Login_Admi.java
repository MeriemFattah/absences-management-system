

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

/**
 * Servlet implementation class Login_Admi
 */
@WebServlet("/Login_Admi")
public class Login_Admi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Admi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String action = request.getParameter("action");
			if("log".equals(action)) {
				try {
					 int username  =Integer.parseInt(request.getParameter("username"));
					int password =Integer.parseInt(request.getParameter("password"));
					
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/absence", "root", "123654789");
		PreparedStatement preparedStatement = connection.prepareStatement("select * from administration where username=? and passwordd=? ;");
		preparedStatement.setInt(1,username);
		preparedStatement.setInt(2,password);
		 getServletContext().setAttribute("username", username);
		ResultSet rs= preparedStatement.executeQuery();
			if(rs.next()) {
			response.sendRedirect("Interface_Initiale.jsp");}
			else {
				request.setAttribute("status", "failed");
				response.sendRedirect("login_Admi.jsp");
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
