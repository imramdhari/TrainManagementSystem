package myTicketManagementSystem;

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
public  interface TrainServiceInterface {

	// static attributes to share with all TrainServices
	// constants

	
	

	void setZonesTravelled(int zonesTravelled);

	 void setDepartureTime(String _departureTime) ;
	
public int getDepartureStationNumber() ;
	public int getarrivalStationNumber() ;
	public void setArriveStation(String arriveStation) ;

	public void setDepartStation(String departStation) ;

	// methods for Train Services
	public double getTicketPrice() ;
	public int getZonesTravelled() ;
	
	void  setUpStationData(String fname) ;
	//List<Station> putStationData() ;
}
		
	
	

