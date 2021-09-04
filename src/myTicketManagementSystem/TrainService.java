package myTicketManagementSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * @author Kkeogh
 *
 */
public abstract class TrainService implements TrainServiceInterface{

	private static final String ArriveStation = null;

	private static final String departStation = null;

// static attributes to share with all TrainServices
	// constants
static double MINTICKETPRICE = 25.00;
	// list of stations stored in an array - should change to an ArrayList for more flexibility 
	// remove dummy Station data here and write a new method to setup all stations based on file input
	/*static Station[] allStationNames = {new Station(1, "Boronia\n",1), 
									new Station(2, "Bayswater\n",1),
									new Station(3, "Ringwood\n", 2),
									new Station(4,"Berwick\n",3),
									new Station(5, "Beaconsfield\n",4), 
									new Station(6, "Officer\n",4), 
									new Station(7, "Clayton\n",3),
									new Station(8, "Cranburne\n",4),
									new Station(9, "ATMC\n", 4)};
	
*/
	
	 static List<Station>  allStation; 
	 // ArrayList named allStation but here no method given to assign value.

		

     // attributes for all Train Services
	int zonesTravelled = 1;  // default assumption one zone travelled, should calculate this
	int departureStationNumber; // index value for station in allStationNames list
	int arrivalStationNumber;
	String departureTime;
	String serviceName;
	
	
	




	// constructor
	public TrainService(String departStation, String arriveStation, String departureTime) {
		
		//super(departStation,arriveStation,departureTime);
		//System.out.println("check -1");
		this.setUpStationData("allStation.txt"); // not yet implemented
		this.setDepartStation(departStation);
		this.setArriveStation(arriveStation);
		this.setDepartureTime(departureTime);
		this.setZonesTravelled(zonesTravelled);
	}
	
	
		
	

	 public TrainService(int number, String name, int zone) {
		// TODO Auto-generated constructor stub
	}





	public void setZonesTravelled(int zonesTravelled) {
		// update this to calculate how many zones are travelled from Depart Station to Arrive Station
		this.zonesTravelled = this.getZonesTravelled();                     // to do update this
		
		
	}

	 public void setDepartureTime(String _departureTime) {
		this.departureTime = _departureTime;
		
	}
public int getDepartureStationNumber() {
		//this.departureStationNumber=this.getDepartureStationNumber();
		return departureStationNumber;
	}
	public int getarrivalStationNumber() {
		//this.arrivalStationNumber=this.getarrivalStationNumber();
		return arrivalStationNumber;
	}
	public void setArriveStation(String arriveStation) {
	       for(int ar=0; ar< allStation.size();ar++)
	       {
	    	 
	    if(allStation.get(ar).getName()==arriveStation)
	 this.arrivalStationNumber = allStation.get(ar).stationNo;
	       }  	
	    	    // change this to be the index value of the correct station
	}
	public String  getArriveStation() {
		
	  return ArriveStation;
	}
	public String  getdepartStation() {
		
		  return departStation;
		}

	public void setDepartStation(String departStation) {
		//todo: search in the train station list for this station arriveStation and find it's index value
		 for(int ar=0; ar< allStation.size();ar++)
	       {
	    	 
	    if(allStation.get(ar).getName()==departStation)
	 this.departureStationNumber = allStation.get(ar).stationNo;
	       }  	
		
	
				
	}

	// methods for Train Services
	public double getTicketPrice() {
		
		{MINTICKETPRICE= MINTICKETPRICE*zonesTravelled;
	}
		return MINTICKETPRICE;  // default price is minimum price
		// should change this so that the price is increased if more zones are travelled
	}

	public int getZonesTravelled() {
		
		int startZone = 0;
		int endZone=0; 
		int zonesTravelled =1;
		
		for(Station s:allStation)
				{
			if(s.getStationNo()==departureStationNumber)
				startZone=s.getZone();
			if(s.getStationNo()==arrivalStationNumber)
			endZone= s.getZone();
				}
		{
			if(endZone>startZone)
				zonesTravelled=(endZone-startZone)+1;
			else zonesTravelled = (startZone-endZone)+1;
			
			
		}
		
		return zonesTravelled;
		
		// need to look at departure station and arrival station and see how many zones are travelled
		// then update zonesTravelled
		// need to have a mechanism for finding or storing number of zones travelled
		

	}
	
	 public void  setUpStationData(String fname){
		// TODO finish this method to load station details from file named fname
		// open scanner on file fname to read in Station details into an ArrayList allStations to replace the array allStationNames
		// loop to read in Station data - station name on one line, zone number on next line, until EOF
		// TODO finish this method to load station details from file named fname
				// open scanner on file fname to read in Station details into an ArrayList allStations to replace the array allStationNames
				// loop to read in Station data - station name on one line, zone number on next line, until EOF




	allStation = new ArrayList<Station>();
		
		this.allStation=allStation;
		
		File sta=new File("allStation.txt")	;
		Scanner in;
		try {
			in = new Scanner(sta);
			while(in.hasNextLine()) {
				int s_No=Integer.parseInt(in.nextLine());
				String s_Name=in.nextLine();
				int zone= Integer.parseInt(in.nextLine());
				Station allStation =new Station(s_No,s_Name,zone);
				TrainService.allStation.add(allStation);
			}
		}
			catch (FileNotFoundException e) {
				System.out.println("File not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
}
		
		
		
		
		
		
		
		
		
		
	





	public String getServiceName() {
		// this is created to get service name
		return this.serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}





	
}
		
	
	

