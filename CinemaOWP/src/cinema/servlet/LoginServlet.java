package cinema.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema.DAO.UserDAO;
import cinema.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username.equals("") || password.equals("")) {
			request.getRequestDispatcher("./FailureServlet").forward(request, response);
			return;
		}
		if (username.equals("") && password.equals("")) {
			request.getRequestDispatcher("./FailureServlet").forward(request, response);
			return;
		}
		
		User user = UserDAO.getUser(username, password);
		if(user == null) {
			request.getRequestDispatcher("./FailureServlet").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("loggedInUser", user);
		request.getRequestDispatcher("./SuccessServlet").forward(request, response);
		
	}

}
