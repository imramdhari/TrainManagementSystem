/**
 * 
 */
package myTicketManagementSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * @author Kkeogh
 *@author balvinder singh
 */
public class RailManager {
	private static final String allStation = null;
	ArrayList<TrainService> allServices ; // up to 100 services, change to ArrayList
	static Scanner input = new Scanner(System.in);
	
	
	
	public void setUpData(){
		
		
	/*	File sta=new File("/TransportManagementSystem/src/myTicketManagementSystem/allStation.txt")	;
		Scanner in = new Scanner(sta);
		while(in.hasNextLine()) {
			int s_No=Integer.parseInt(in.nextLine());
			String s_Name=in.nextLine();
			int zone= Integer.parseInt(in.nextLine());
			Station sa=new Station(s_No,s_Name,zone);
			this.allServices.addAll((Collection<? extends TrainService>) sa);
		}
		*/
		// set up some dummy data - need to change or overload to read from a file
	
		allServices =  new ArrayList<TrainService>(100);
		allServices.add(new StandardService("Boronia", "Bayswater", "10:00"));
		allServices.add(new StandardService("Boronia", "Ringwood", "10:00"));
		allServices.add(new StandardService("Bayswater", "Berwick", "12:00"));
		allServices.add(new SleeperService("Bayswater", "ATMC", "22:00"));
		allServices.add(new SleeperService("ATMC", "Boronia", "22:00"));
		
	}
	
	public String getAllStat() {
		String result = "";
		// print a list of all stations for information
		for (Station s : TrainService.allStation) {
					result = result +"\n"+ s.name + " ";
					//System.out.println(result);
		}
		return result;
	}
	
	
	public void sellTickets() {
		int departSt;
		int  arriveSt ;
		String hourDepart;
		String dname,arname;
		String reply;
		TicketType fareType;
		Ticket newTicket;
		boolean isArrivalStation=false;
		boolean isDepartureStation=false;

		
		System.out.println(getAllStat());
		
	//	System.out.println("Please Enter Departure Station number : ");
		System.out.println("Please Enter Departure Station name : ");                       // user will enter Departure Station Name
		dname = input.next();
		dname=dname.toUpperCase();
		//departStation = input.nextLine();
	//	System.out.println("Please Enter Destination Station number : ");
		System.out.println("Please Enter Destination Station Name : ");                  //user will enter Arrival Station Name
		arname = input.next();
		arname=arname.toUpperCase();
		System.out.println("Please Enter Departure Hour (00-24): ");
		hourDepart = input.next();                                                      // user will enter hours
		System.out.println("Is this a concession Ticket? ");
		reply = input.next();
		reply = reply.toUpperCase();
		if (reply.startsWith("Y")) 
			fareType = new TicketType(TicketType.CONCESSION);
		else
			fareType = new TicketType(TicketType.FULLFARE);
		
	TrainService ts= new StandardService(dname,arname,hourDepart) ;
	
		
		
		
		 for(Station sn:TrainService.allStation) {
		 
		 if(sn.getName().equalsIgnoreCase(arname)) 
		 {
			 isArrivalStation=true;
		 ts.setArriveStation(arname); arriveSt=ts.getarrivalStationNumber(); }
		 if(sn.getName().equalsIgnoreCase(dname)) 
		 { 
			 isDepartureStation=true;
			 ts.setDepartStation(dname); departSt=ts.getDepartureStationNumber();
		 
		 // update this next line so that it displays name of stations, not station numbers
			 //System.out.println("Ticket requested from " + dname + " to " + arname + " at " + hourDepart);
		  }
		 }
			
		
		if(isArrivalStation && isDepartureStation)
		{
			System.out.println("Ticket requested from " + dname + " to " + arname + " at " + hourDepart);
		}
		else
		{
			System.out.print("Check you station Names");
		
		}
		
		//System.out.println(getZoneNum(departStation));
		
		
		newTicket = createTicket(dname, arname,fareType, hourDepart);
		newTicket.print();
	}
		

	

	private Ticket createTicket(String departSt, String arriveSt, TicketType fareType, String departureTime) {
		// first work out service details for this trip
		TrainService aService;
		Ticket t;
		System.out.println("Enter 1 for standard service, 2 for sleeper service : ");
		int ans = input.nextInt();
		if (ans==1) {
			aService = new StandardService(departSt, arriveSt, departureTime);
			aService.setServiceName("Standard Services");
		}
		else {
			aService = new SleeperService(departSt, arriveSt, departureTime);
			aService.setServiceName("Sleeper Services");
		}
		 
		// work out fare for this service
		System.out.println("Enter 1 for Economy seat, 2 for First Class seat : ");
		ans = input.nextInt();
		if (ans==1) {
			t = new EconomyClassTicket(aService, fareType);
		}
		else {
			t = new FirstClassTicket(aService, fareType);
		}
		
		
		return t;
	}
	
	public Ticket createTicket(String departSt, String arriveSt, TicketType fareType, String departureTime, boolean sleeper, boolean firstClass) {
		TrainService aService;
		Ticket t;
		
		if (sleeper)
			aService = new SleeperService(departSt, arriveSt, departureTime);
		else
			aService = new StandardService(departSt, arriveSt, departureTime);
		
		if (firstClass)
			t = new FirstClassTicket(aService, fareType);
		else
			t = new EconomyClassTicket(aService, fareType);
		
		return t;
	}


	

}
