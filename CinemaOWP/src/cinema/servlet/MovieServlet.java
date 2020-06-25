package cinema.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema.DAO.MovieDAO;
import cinema.model.Movie;
import cinema.model.User;

/**
 * Servlet implementation class MovieServlet
 */
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Movie movie = MovieDAO.getMovieById(id);
		
		data.put("movie", movie);
		
		request.setAttribute("data", data);
		request.getRequestDispatcher("./SuccessServlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("loggedInUser");
		
		if(user.getRole() == User.Role.admin) {
			
			try {
				
				String name = request.getParameter("name");
				String director = request.getParameter("director");
				String actorsStr = request.getParameter("actors");
				ArrayList<String> actors = new ArrayList<String>();
				actors.add(actorsStr);
				String genreStr = request.getParameter("genre");
				Movie.Genre genre = Movie.Genre.valueOf(genreStr);
				String durationStr = request.getParameter("duration");
				int duration = Integer.parseInt(durationStr);
				String distributor = request.getParameter("distributor");
				String country = request.getParameter("country");
				String yearStr = request.getParameter("year");
				int year = Integer.parseInt(yearStr);
				String description = request.getParameter("description");
				
				Movie movie = new Movie(name, director, actors, genre, duration, distributor, country, year, description);
				MovieDAO.addMovie(movie);
				request.getRequestDispatcher("./SuccessServlet").forward(request, response);
				
			} catch (Exception e) {
				String message = e.getMessage();
				
				if (message == null) {
					message = "Some NEPREDVIDJENA greska!";
					e.printStackTrace();
				}

				Map<String, Object> data = new LinkedHashMap<>();
				data.put("message", message);
				request.setAttribute("data", data);
				
				request.getRequestDispatcher("./FailureServlet").forward(request, response);
			}
			
			
			
		}
		
	}

}
