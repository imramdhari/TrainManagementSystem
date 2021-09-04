package myTicketManagementSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TicketTest {

	TrainService standardServiceZones1;
	TrainService sleeperServiceZones7;
	TicketType concessionTicketType;
	TicketType fullFareTicketType;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		standardServiceZones1 = new StandardService("Boronia", "ATMC", "10:00");
		sleeperServiceZones7 = new SleeperService("Boronia", "Bayswater", "20:00");
		concessionTicketType = new TicketType(TicketType.CONCESSION);
		fullFareTicketType = new TicketType(TicketType.FULLFARE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetService() {
	int	zone=7;
	String service;
	if(zone==7) {
		TrainService s=new SleeperService("Boronia","ATMC","10:00");
		 String result3="SleeperService";
		
		assertEquals("Checking Service for zone 7 ", result3, s.getServiceName());
	}
	
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetTicketPriceFirstClassConcessionZone1() {  // TODO create more thorough test cases
		Ticket t = new FirstClassTicket(standardServiceZones1, concessionTicketType);
		// first class ticket has 25% surcharge added
		// 1 zone of travel is charged at default min ticket price
		// concession fare is 10% discount
		// standard service min ticketprice is 25.0
		// expect this ticket to be (25.0 * 1) * 1.25 * 0.9
		double resultExpected = 25.0 *1 * 1.25 * 0.9;
		//System.out.println("result expected " + resultExpected);
		//System.out.println("actual ticket price issued " + t.getTicketPrice());
		assertEquals("Checking first class concession standard ticket 1 zone ", resultExpected, t.getTicketPrice(), 0.01);
	}

	@Test
	public final void testIssueConcessionTicket() {
		Ticket th=new EconomyClassTicket(sleeperServiceZones7,concessionTicketType);
		//sleeper service min ticketprice is 50.0
		double discount = 25*0.1;
		double result=50*7-discount;
		assertEquals("Checking economy class concession sleeper ticket 7 zone ", result, th.getTicketPrice(), 347.5);
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIssueFullPriceTicket() {
		Ticket the=new FirstClassTicket(sleeperServiceZones7,fullFareTicketType);
	double	result2=50*7;
		assertEquals("Checking sleeper  class full fare sleeper ticket 7 zone ", result2, the.getTicketPrice(), 350.01);
		//fail("Not yet implemented"); // TODO
	}

}
