package myTicketManagementSystem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

public class RailManagerGUI extends JFrame implements ActionListener {
	private static final Container tmp = null;
	JButton JBquit = new JButton("Quit");
	JButton JBPurchaseTicket = new JButton("Purchase Ticket");
	JRadioButton rbc, rbf;
	JRadioButton rbsl, rbst;
	JRadioButton slp, fct;
	boolean concession = false, sleeper = false;
	boolean economy = false, firstclass = false;
	RailManager theTicketingSystem;
   private JComboBox<Station> allStation;
   TrainService stations;
	
private JTextField txtstation;
	private JTextField txtname;
	private JTextField txtzone;
	private JComboBox box;
	private JComboBox arbox;

	public RailManagerGUI (RailManager theSystem) {
		this.theTicketingSystem = theSystem;
		this.add(setUpTopPanel(), BorderLayout.NORTH);
		this.add(setupCenterPanel(), BorderLayout.CENTER);
		this.add(setupBottomPanel(), BorderLayout.SOUTH);
		this.setBounds(200,200,600,400);
		this.setTitle("Rail Management System");
		this.setVisible(true);
	}
	
	public JPanel setUpTopPanel() {
		JPanel newJpanel = new JPanel();
		JLabel newJLabe2 = new JLabel("	Welcome to Ticket Management Services");// add a label to top panel 
		JLabel newJLabel = new JLabel("Select Stations :");
	    newJLabel.setVisible(true);
	    newJpanel.add(newJLabel);
		newJpanel.add(newJLabel);
		newJpanel.add(newJLabe2,"North");
	
		
	     JLabel label = new JLabel("Departure Station");
		     JComboBox box = new JComboBox();
		     
		     JPanel panel = new JPanel();
		    
		   
box.addItem("Boronia");
box.addItem("Bayswater");
box.addItem("Ringwood");
box.addItem("Berwick");
box.addItem("Beaconsfield");
box.addItem("Officer");
box.addItem("Clayton");
box.addItem("Cranburne");
box.addItem("ATMC");

box.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent evt) {
    	System.out.println("Departure Station :"+box.getSelectedItem().toString());

    }
});
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        panel.setLayout(new FlowLayout());
		        panel.add(label);
		        panel.add(box);

		        

			     JLabel arlabel = new JLabel("Arrival Station");
				     JComboBox arbox = new JComboBox();
				    
				    
				   
		arbox.addItem("Boronia");
		arbox.addItem("Bayswater");
		arbox.addItem("Ringwood");
		arbox.addItem("Berwick");
		arbox.addItem("Beaconsfield");
		arbox.addItem("Officer");
		arbox.addItem("Clayton");
		arbox.addItem("Cranburne");
		arbox.addItem("ATMC");

		arbox.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent evt) {
		    	
		    	
		    	System.out.println("Ticket from "+""+"\n"+box.getSelectedItem().toString()+ ""+ "\n"+"to" +"" + "\n" + arbox.getSelectedItem().toString());
		    	
		    }
		});
				        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        panel.setLayout(new FlowLayout());
				        panel.add(arlabel);
				        panel.add(arbox);
		     
				return panel;
		    }
	 

	     
	   
    	    	   	   	
		
		// add a display that lists all stations and a mechanism for the user to select a station for departure and arrival
		// perhaps use a JComboBox or JCheckbox so user can select a station
		

	
	public JPanel setupCenterPanel() {
		JPanel newJpanel = new JPanel();
		// add radio button group for CONCESSION or FULL FARE
		JLabel con=new JLabel("Do You Have Concession Card or Full Fare");
		newJpanel.add(con);
		rbc = new JRadioButton("CONCESSION");
		rbf = new JRadioButton("FULL FARE");
		ButtonGroup rbgFare = new ButtonGroup();
		rbgFare.add(rbc);
		rbgFare.add(rbf);
		rbc.addActionListener(this);
		rbf.addActionListener(this);
		JPanel serviceJpanel = new JPanel();
		JLabel ncon=new JLabel("Which Service Would you like to Select:");
		serviceJpanel.add(ncon);


		// add radio button group for SLEEPER or STANDARD car
		rbsl = new JRadioButton("SLEEPER CAR");
		rbst = new JRadioButton("STANDARD CAR");
		ButtonGroup rbgCar = new ButtonGroup();
		rbgCar.add(rbsl);
		rbgCar.add(rbst);
		// TODO: add action listeners for these radio buttons
	 rbsl.addActionListener(this);
	 rbst.addActionListener(this);
		// TODO: add radio button group for ECONOMY or FIRST CLASS ticket
		slp = new JRadioButton("ECONOMY TICKET");
		fct = new JRadioButton("FIRST CLASS TICKET");
		ButtonGroup ticketst = new ButtonGroup();
		ticketst.add(slp);
		ticketst.add(fct);
		 slp.addActionListener(this);
		 fct.addActionListener(this);
		 
		// add radio buttons to the panel
		newJpanel.add(rbc);
		newJpanel.add(rbf);
		newJpanel.add(rbsl);
		newJpanel.add(rbst);
		newJpanel.add(slp);
		newJpanel.add(fct);
		
		return newJpanel;
	}
	
	public JPanel setupBottomPanel() {
		JPanel newJpanel = new JPanel();
		newJpanel.add(JBPurchaseTicket);
		newJpanel.add(JBquit);
		JBquit.addActionListener(this);
		JBPurchaseTicket.addActionListener(this);
		return newJpanel;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBquit) {
			this.dispose();
		}
		if (e.getSource()==this.rbc) {
			// concession fare selected
			System.out.println("Concession fare requested");
			concession = true;
		}
		if (e.getSource()==this.rbf) {
			// full fare selected
			System.out.println("Full fare requested");
			concession = false;
		}
		if (e.getSource()==this.rbsl) {
			// sleeper car selected
			System.out.println("Sleeper car selected");
			sleeper = true;
		}
		
		if (e.getSource()==this.rbst) {
			//standard car selected
			System.out.println("Standard car selected");
			sleeper = false;
		}
		
		if (e.getSource()==this.slp) {
			//economy  selected
			System.out.println("Economy Ticket  Selected");
			economy = true;
		}
		
		if (e.getSource()==this.fct) {
			//First class selected  selected
			System.out.println("First Class Ticket  Selected");
			economy = false;
		}
		
		
		if (e.getSource()==this.JBPurchaseTicket) {
		String departSt;
			String arriveSt="";
			TicketType fareType = null;
			boolean sleeper = false;
			boolean firstClass = false ;
			boolean concession;
			boolean fulllfare;
			double ticket=25;
			double conc;
		String departureTime = null;
		 departSt = (String) box.getSelectedItem();
		 arriveSt=(String) arbox.getSelectedItem();

			this.theTicketingSystem.createTicket(departSt, arriveSt, fareType, departureTime, sleeper, firstClass);
			if(concession=true) {
			     conc = ticket * 0.1;
		              System.out.println(" Concession  " + conc);
		           }
		            else {
			               conc =ticket;
		                     }
			 if (sleeper=true) {
				ticket=ticket+SleeperService.MINTICKETPRICE;
				System.out.println(" Sleeper  " + ticket);
			}
			 else {
				 ticket=ticket+StandardService.MINTICKETPRICE;
			 System.out.println(" Standard  " + ticket);
			
			
		           }
			if( economy=true)
			{  ticket = ticket+StandardService.MINTICKETPRICE;
			System.out.println(" Economy  " + ticket);
			}
			else {
				ticket = ticket+ticket*0.04;
			}
			
			
			
		}
			//todo : add code to create the ticket here using this.theTicketingSystem 
		
		
	}

	@Override
	public String toString() {
		return "RailManagerGUI [JBquit=" + JBquit + ", JBPurchaseTicket=" + JBPurchaseTicket + "]";
	}

	
	

}

	

