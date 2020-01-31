package cinema.Model;

import java.util.Date;

public class Ticket {

	private int id;
	private Projection projectionId;
	private Seat seatNumber;
	private Date date;
	private User userId;
	
	public Ticket(Projection projectionId, Seat seatNumber, Date date, User userId) {
		super();
		this.projectionId = projectionId;
		this.seatNumber = seatNumber;
		this.date = date;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projection getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(Projection projectionId) {
		this.projectionId = projectionId;
	}

	public Seat getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Seat seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	
}
