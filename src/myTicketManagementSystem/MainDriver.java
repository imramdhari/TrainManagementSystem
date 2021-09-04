package myTicketManagementSystem;

public class MainDriver {

	public static void main(String[] args) {
		RailManager m = new RailManager();
	m.setUpData(); // load in data of all services available
	//RailManagerGUI mgui = new RailManagerGUI(m);
      m.sellTickets(); // text based testing method

	}

}
