package cinema.model;

public class Seat {
	
	private int id;
	private Hall hallId;
	private Projection projectionId;
	
	public Seat(Hall hallId, Projection projectionId) {
		super();
		this.hallId = hallId;
		this.projectionId = projectionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hall getHallId() {
		return hallId;
	}

	public void setHallId(Hall hallId) {
		this.hallId = hallId;
	}

	public Projection getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(Projection projectionId) {
		this.projectionId = projectionId;
	}
	
}
