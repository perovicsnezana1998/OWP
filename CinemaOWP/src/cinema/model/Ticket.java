package cinema.model;

import java.util.Date;

public class Ticket {

	private int id;
	private Projection projectionId;
	private Seat seatId;
	private Date date;
	private User userId;
	
	public Ticket(Projection projectionId, Seat seatId, Date date, User userId) {
		super();
		this.projectionId = projectionId;
		this.seatId = seatId;
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

	public Seat getSeatId() {
		return seatId;
	}

	public void setSeatId(Seat seatId) {
		this.seatId = seatId;
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
