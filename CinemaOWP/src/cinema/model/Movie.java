package cinema.model;

import java.util.ArrayList;

public class Movie {

	public enum Genre{
		horror, 
		trailer,
		action,
		romanse,
		fantasy
	}
	
	private int id;
	private String name;
	private String director;
	private ArrayList<String> actors;
	private Genre genre;
	private int duration;
	private String distributor;
	private String country;
	private int year;
	private String description;
	
	public Movie(String name, String director, ArrayList<String> actors, Genre genre, int duration, String distributor,
			String country, int year, String description) {
		super();
		this.name = name;
		this.director = director;
		this.actors = actors;
		this.genre = genre;
		this.duration = duration;
		this.distributor = distributor;
		this.country = country;
		this.year = year;
		this.description = description;
	}
	
	public Movie(String name, int duration, String distributor, String country, int year) {
		super();
		this.name = name;
		this.duration = duration;
		this.distributor = distributor;
		this.country = country;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public ArrayList<String> getActors() {
		return actors;
	}

	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
