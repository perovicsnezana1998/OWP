package cinema.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cinema.model.Movie;

public class MovieDAO {

	public static ArrayList<Movie> getAllMovies() {
		
		ConnectionManager.open();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		try {
			String query = "SELECT * FROM MOVIES";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				int id = rset.getInt(1);
				String name = rset.getString(2);
				String director = rset.getString(3);
				ArrayList<String> actors = new ArrayList<String>();
				actors.add(rset.getString(4));
				Movie.Genre genre = Movie.Genre.valueOf(rset.getString(5));
				int duration = rset.getInt(6);
				String distributor = rset.getString(7);
				String country = rset.getString(8);
				int year = rset.getInt(9);
				String description = rset.getString(10);
				
				Movie movie = new Movie(name, director, actors, genre, duration, distributor, country, year, description);
				movie.setId(id);
				movies.add(movie);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	public static Movie getMovieById(int id) {
		
		ConnectionManager.open();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			
			String query = "SELECT * FROM MOVIES WHERE ID=?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				String name = rset.getString(2);
				String director= rset.getString(3);
				String actorsStr = rset.getString(4);
				ArrayList<String> actors = new ArrayList<String>();
				actors.add(actorsStr);
				Movie.Genre genre = Movie.Genre.valueOf(rset.getString(5));
				int duration = rset.getInt(6);
				String distributor = rset.getString(7);
				String country = rset.getString(8);
				int year = rset.getInt(9);
				String description = rset.getString(10);
				
				Movie movie = new Movie(name, director, actors, genre, duration, distributor, country, year, description);
				movie.setId(id);
				
				return movie;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean addMovie(Movie movie) {
		
		ConnectionManager.open();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String query = "INSERT INTO MOVIES (NAME, DIRECTOR, ACTORS, GENRE, DURATION, DISTRIBUTOR, COUNTRY, YEAR, DECSCRIPTION) VALUES (?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, movie.getName());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getActors().toString());
			pstmt.setString(4, movie.getGenre().toString());
			pstmt.setInt(5, movie.getDuration());
			pstmt.setString(6, movie.getDistributor());
			pstmt.setString(7, movie.getCountry());
			pstmt.setInt(8, movie.getYear());
			pstmt.setString(9, movie.getDescription());
			
			return pstmt.executeUpdate() == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();} 
		}
		
		return false;
	}
	
}
