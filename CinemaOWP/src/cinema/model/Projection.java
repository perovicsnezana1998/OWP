package cinema.model;

import java.util.Date;

public class Projection {
	
	private int id;
	private Movie movieId;
	private ProjectionType pTypeId;
	private Hall hallId;
	private Date date;
	private double price;
	private String adminId;
	
	public Projection(Movie movieId, ProjectionType pTypeId, Hall hallId, Date date, double price, String adminId) {
		super();
		this.movieId = movieId;
		this.pTypeId = pTypeId;
		this.hallId = hallId;
		this.date = date;
		this.price = price;
		this.adminId = adminId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovieId() {
		return movieId;
	}

	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}

	public ProjectionType getpTypeId() {
		return pTypeId;
	}

	public void setpTypeId(ProjectionType pTypeId) {
		this.pTypeId = pTypeId;
	}

	public Hall getHallId() {
		return hallId;
	}

	public void setHallId(Hall hallId) {
		this.hallId = hallId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
}
