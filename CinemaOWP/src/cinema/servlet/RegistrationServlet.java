package cinema.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema.DAO.UserDAO;
import cinema.model.User;
import cinema.model.User.Role;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String username = request.getParameter("username");
			if (UserDAO.getUserByUsername(username) != null) {
				throw new Exception("Username already exist!");
			}
			if ("".equals(username)) {
				throw new Exception("Username cannot be empty!");
			}
			
			String password = request.getParameter("password");
			if ("".equals(password)) {
				throw new Exception("Password cannot be empty!");
			}
			
			Date registrationDate = new Date();
			Boolean deleted = false;
			
			User user = new User(username, password, registrationDate, Role.user, deleted);
			UserDAO.addUser(user);
			
			request.getRequestDispatcher("./SuccessServlet").forward(request, response);
			
		} catch (Exception e) {
			String message = e.getMessage();
			if (message == null) {
				message = "Some unexpected error";
				e.printStackTrace();
			}
			
			Map<String, Object> data = new LinkedHashMap<String, Object>();
			data.put("message", message);
			
			request.setAttribute("data", data);
			request.getRequestDispatcher("./FailureServlet").forward(request, response);
		}
		
	}

}
