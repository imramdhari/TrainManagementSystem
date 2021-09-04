package myTicketManagementSystem;

public class TicketType {
	static final int CONCESSION = 0, FULLFARE = 1, SENIORS = 2;
	
	int fareType = FULLFARE; // default fareType is FULLFARE
	
	public TicketType (int type) {
		setFareType(type);
	}

	private void setFareType(int type) {
		// toDO validate that the type is a valid ticket type
		this.fareType = type;
		
	}
	private  Object getFareType() {

	this.fareType = fareType;
		return getFareType();
	}
}
