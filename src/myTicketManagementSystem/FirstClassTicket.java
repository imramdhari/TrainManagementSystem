/**
 * 
 */
package myTicketManagementSystem;

/**
 * @author Kkeogh
 *
 */
              public class FirstClassTicket extends Ticket {

	/**
	 * 
	 */
	public FirstClassTicket(TrainService _service, TicketType _ticketType) {
		super(_service, _ticketType);
	}

	@Override
	public double getTicketPrice() {
		double ticketPrice = this.getService().getTicketPrice()*0.04;
		// update this to make ticketprice more expensive for first class ticket - add surcharge 25%
		return ticketPrice;
	}

@Override
	public String toString() {
		return "FirstClassTicket [getTicketPrice()=" + getTicketPrice() + ", getService()=" + getService()
				+ ", issueConcessionTicket()=" + issueConcessionTicket() + ", issueFullPriceTicket()="
				+ issueFullPriceTicket() + " ";
	}

}
