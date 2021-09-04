package myTicketManagementSystem;
/**
 * @author Kkeogh
 *
 */
public class StandardService extends TrainService {

	static final double MINTICKETPRICE = 25.00; // set minimum ticket price for a standard service

	public StandardService(String departStation, String arriveStation, String departureTime) {
		super(departStation, arriveStation, departureTime);
	}
	
	
	/*  public StandardService(int departStationNo, int arriveStationNo, String
	 departTime) { super(TrainService.allStation(departStationNo).getName(),
	  TrainService.allStation(arriveStationNo).getName(), departTime); }*/
	 

}
