package airline;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AirlineReservationSystem {



    private List<Flight> flights;
	private List<Reservation> reservations;
	private static List<String> FlightNumbers=new LinkedList<>();
	static int newTotalSeats;
    static int newBusinessClassSeats;
	static int NormalClassSeats;
	public  AirlineReservationSystem()
	{
		flights=new LinkedList<>();
		reservations=new ArrayList<>();
		
	}
	public void addFlight(Flight flight)
	{
		flights.add(flight);
	}
	public void searchCity( String Dcity,String Acity,int Ayear,int Amonth,int Adate ) {
		 for(Flight flight1:flights) {
			 while(flight1.getDepartuarcity().contains(Dcity)&&flight1.getArrivalCity().contains(Acity)&&flight1.getDepartuarDate().equals(LocalDate.of(Ayear, Amonth, Adate))) {
				
				   System.out.println("AirLine Name       :"+flight1.getAirlineName());
				   System.out.println("flight Number       :"+flight1.getFlightNumber());
				   System.out.println("Departure City     :"+flight1.getDepartuarcity());
				   System.out.println("Arraival City      :"+flight1.getArrivalCity());
				   System.out.println("Date               :"+flight1.getDepartuarDate());
				   System.out.println("Departure Time     :"+flight1.getDepartureTime());
				   System.out.println("Arraival Time:     :"+flight1.getArraivalTime());
				   System.out.println("Toatal Seats       :"+flight1.getTotalSeats());
				   System.out.println("EconamyClass Seats :"+flight1.getAvailableNormalClassSeats());
				   System.out.println("BusinessClass Seats: "+flight1.getBusinessclasstickets());
				   System.out.println();
				   break;
			 }
			 
		 }
	}
	
	public boolean notValidCity(String Dcity,String Acyty,int Ayear,int Amonth,int Adate ) {
		for(Flight flight1 : flights) {
			while(flight1.getDepartuarcity().contains(Dcity)&&flight1.getArrivalCity().contains(Acyty)&&flight1.getDepartuarDate().equals(LocalDate.of(Ayear, Amonth, Adate)))
			{
				return true;
			}
		}
		 return false;
		
			
			}

	public void makeReservation(String flightNumber,Passenger passenger,String TicketType, String passengername, int age, String gender, String passportNumber, String phoneNumber, String Dcity, String Acity, Date datee, AirlineReservationSystem system, Time DTimee, Time ATimee,PreparedStatement st,ResultSet result)throws Exception {

	     for(Flight flight1:flights) {
			if(flight1.getFlightNumber().equals(flightNumber)) 
			{
				
				if(flight1.bookSeat( passenger,TicketType)) {
				
					reservations.add(new Reservation(flight1, passenger));
					
					
			}
		
					System.out.println("Reservation successful");
					
					
				}
				else {
					System.out.println("No available seats");
				}
				return;
			}
	     System.out.println("Flight not found");
		}
	public boolean cancelReservation(int reservationID,String TicketType) {
		
		for(Reservation reservation:reservations) {
			if(reservation.getReservationID()== reservationID) {
				reservation.getFlight().cancelRecervation(reservation.getPassenger(),TicketType);
				reservations.remove(reservation);
				System.out.println("Reservation canceled");
				return true;
			}
			else {
			
				return false;
			}
				}
		       return false;
	}
	public void displayReservation()
	{
		
			 
		if(reservations.size()!=0) {
		for(Reservation reservation:reservations)
			
	         {
			System.out.println("Reservation ID:  " +reservation.getReservationID()+"  \t "+
	         "Date:    "+reservation.getFlight().getDepartuarDate()+" \t "
					+ "Flight Number:   "+reservation.getFlight().getFlightNumber()+" \t "
							+ "passenge Name:  "+reservation.getPassenger().getName()+"\t"+"PassportNumber   :"+reservation.getPassenger().getPassportNumber()+" \t "+"Passenger Phone Number  :"+reservation.getPassenger().getPhoneNumber()+"Passenger Age    :"+"\t"+reservation.getPassenger().getAge()+"\t"+"Passenger Gender    :"+reservation.getPassenger().getGender());
			System.out.println();
	         }
		}
		else {
		    System.out.println("Not Visible Any Resrevation");
			System.out.println();
		}
		 }
	
	public void UserdisplayReservation(int ReserveID)
	{
		
			 
		if(reservations.size()!=0) {
		for(Reservation reservation:reservations)
			if(reservation.getReservationID()==ReserveID){
	         {
			System.out.println("Reservation ID:  " +reservation.getReservationID()+"\t"+
	         "Date:    "+reservation.getFlight().getDepartuarDate()+"\t"
					+ "Flight Number:   "+reservation.getFlight().getFlightNumber()+"\t"
							+ "passenge Name:  "+reservation.getPassenger().getName()+"\t"+"PassportNumber   :"+reservation.getPassenger().getPassportNumber()+"\t"+"Passenger Phone Number  :"+reservation.getPassenger().getPhoneNumber()+" \t" +"Passenger Age    :"+"\t"+reservation.getPassenger().getAge()+ "\t" +"Passenger Gender    :"+reservation.getPassenger().getGender());
			System.out.println();
	         }
		}
			else 
			{
			System.out.println("Enter Valid Reservation ID");
			
		}
		}
		else {
		    System.out.println("Not Visible Any Resrevation");
			System.out.println();
		}
		 }
	
	
	
	
	public void  searchFlight(String AirLineName) {
	
		
		for(Flight flight2 : flights)
			
		{
			if(flight2.getAirlineName().equals(AirLineName)) {
				   
				   System.out.println("AirLine Name       :"+flight2.getAirlineName());
				   System.out.println("flight Number       :"+flight2.getFlightNumber());
				   System.out.println("Departure City     :"+flight2.getDepartuarcity());
				   System.out.println("Arraival City      :"+flight2.getArrivalCity());
				   System.out.println("Date               :"+flight2.getDepartuarDate());
				   System.out.println("Departure Time     :"+flight2.getDepartureTime());
				   System.out.println("Arraival Time:     :"+flight2.getArraivalTime());
				   System.out.println("Toatal Seats       :"+flight2.getTotalSeats());
				   System.out.println("EconamyClass Seats    :"+flight2.getAvailableNormalClassSeats());
				   System.out.println("BusinessClass Seats: "+flight2.getBusinessclasstickets());
				   System.out.println();
			}
		}
	}
public void  searchFlight() {
	
		for(Flight flight2 : flights)
		{
				   
				   System.out.println("AirLine Name       :"+flight2.getAirlineName());
				   System.out.println("flight Number      :"+flight2.getFlightNumber());
				   System.out.println("Departure City     :"+flight2.getDepartuarcity());
				   System.out.println("Arraival City      :"+flight2.getArrivalCity());
				   System.out.println("Date               :"+flight2.getDepartuarDate());
				   System.out.println("Departure Time     :"+flight2.getDepartureTime());
				   System.out.println("Arraival Time:     :"+flight2.getArraivalTime());
				   System.out.println("Toatal Seats       :"+flight2.getTotalSeats());
				   System.out.println("EconamyClass Seats    :"+flight2.getAvailableNormalClassSeats());
				   System.out.println("BusinessClass Seats: "+flight2.getBusinessclasstickets());
				   System.out.println();
		}
	}
	public boolean notValid(String AirLineName) {
		for(Flight flight1 : flights) {
			while(flight1.getAirlineName().contains(AirLineName))
			{
				return true;
			}
		}
		 return false;
		
			
			}

		
	
	public boolean validFlight(String flightNumber) {
		for(Flight fligh:flights) {
		    while(fligh.getFlightNumber().equals(flightNumber)) {
		    	return true;
		    }
		    }
		 return false;
		}
	private static boolean loginPassenger(Scanner s,PreparedStatement st,ResultSet result)throws Exception {
		  
		   System.out.println("Enter Username");
		   String name=s.nextLine();
		   String NameQuery="select UserName from user where UserName=?;";
		   st=SqlConnection.SQLConnector().prepareStatement(NameQuery);
		   st.setString(1,name);
		   result=st.executeQuery();
		   if(result.next()) {
		   
		   System.out.println("Enter Password");
		   String password=s.nextLine();
		   String passwordQuery="select password from user where UserName=? AND password=? ;";
		   st=SqlConnection.SQLConnector().prepareStatement(passwordQuery);
		   st.setString(1,name);
		   st.setString(2,password);
		   result=st.executeQuery();
		    if(result.next()) {
		    	return true;
			  
		   }else {
			   return false;  
		   }
		   }
		   else {
			   return false;
		   }
		   
	   }
	public boolean DeleteFlight(String DeleteFlightNumber) {
		for(Flight flight1 : flights) {
			while(flight1.getFlightNumber().equals(DeleteFlightNumber))
			{
				
				flights.remove(flight1);
							return true;
			}
			}
		 return false;
	}
	public boolean ValidFlightNumbers(String newFlightNumber) {
		for(String FlightNumber1:FlightNumbers) {
	        while(FlightNumber1.equals(newFlightNumber)) {
		    return false;
		}
		}
		return true;
	}
		public Time Departuertimereturn(String flightNumber,Time DTimee) {
			
			for(Flight flight1:flights) {
				if(flight1.getFlightNumber().equals(flightNumber)) {
				  LocalTime Dtime =flight1.getDepartureTime();
				 return DTimee=Time.valueOf(Dtime);
				}
			}
			return DTimee;
		}
public Time Arrivaltimereturn(String flightNumber,Time ATimee) {
			
			for(Flight flight1:flights) {
				if(flight1.getFlightNumber().equals(flightNumber)) {
				  LocalTime Dtime =flight1.getArraivalTime();
				 return ATimee=Time.valueOf(Dtime);
				}
			}
			return ATimee;
		}
public boolean CheckAdminName(Scanner s3,Scanner s,PreparedStatement st,ResultSet result) throws Exception{
	 
	 System.out.println("Enter Admin Name");
	 String AdminName=s3.nextLine();
	 System.out.println("Enter Admin ID");
	 int AdminID=s.nextInt();
	 String ADMINQUERY="select AdminName from admin where AdminName=?;";
	 st=SqlConnection.SQLConnector().prepareStatement(ADMINQUERY);
	 st.setString(1,AdminName);
	 result=st.executeQuery();
	 while(result.next()) {
	 
		 
	 String ADMINQUERYID="select AdminId from admin where AdminId=?;";
	 st=SqlConnection.SQLConnector().prepareStatement(ADMINQUERYID);
	 st.setInt(1,AdminID);
	 result=st.executeQuery();
	 while(result.next()) {
		
	  return true;
	 }
	 }

 return false;
 }
public static void CheckUserName(Scanner s,CheckMethods method,PreparedStatement st,ResultSet result) throws Exception{
	
	System.out.println("Enter UserName");
	String username=s.nextLine();
	if(!method.validuserName(username)) {
 	   System.out.println("Enter Valid username");
 	   return;
 	   }else {
	String NameQuery="select UserName from user where UserName=?;";
	st=SqlConnection.SQLConnector().prepareStatement(NameQuery);
	st.setString(1,username);
	result=st.executeQuery();
	if(result.next()) {
		
		System.out.println("Username aldready exists.please choose a diffrent username");
	}
	else {
	   System.out.println("Enter password (must 9 Characters& Numbers )");
	   String userpassword=s.nextLine();
	   if(!method.validPassword(userpassword)) {
		   System.out.println("Enter Valid Password");
			   return;
		   }
		   String UserQuery="insert into user values(?,?);";
	       st=SqlConnection.SQLConnector().prepareStatement(UserQuery);
	       st.setString(1,username);
	       st.setString(2,userpassword);
	       int n=st.executeUpdate();
	      
	       if(n>0) {
		   System.out.println("Registration Successfull"); 
		   System.out.println();
	   }
		}
 	   }
	}
 	   

     public static void main(String[] args) {

		 Scanner s=new Scanner(System.in);
		 Scanner s1=new Scanner(System.in);
         Scanner s2=new Scanner(System.in);
         Scanner s3=new Scanner(System.in);
		 
         AirlineReservationSystem system=new AirlineReservationSystem();
    	 CheckMethods method =new CheckMethods();
	 	 AdminLogin a=new AdminLogin();
	 	 String newFlightType=null;    
	 	  
	 	 ResultSet  result=null;
	     PreparedStatement st = null;
	     while(true) {
	    	 
	     
	    	 System.out.print ("                 ");System.out.println("Welcome To Airline Reservation System");
				System.out.println();
				System.out.println("a.USER");
				System.out.println();
				System.out.println("b.ADMIN");
				System.out.println();
				System.out.println("c.Exit");
				 if(s.hasNext()) {
					try {
				
				String option=s.nextLine();
				switch (option) {
	 		     
				
				case "a":
					boolean LOGGORREG=false;
					
					while(!LOGGORREG) {
						 System.out.println("1.User Registration ");
						 
						 System.out.println("2.User Login");
						 
						 System.out.println("3.Exit");
						 int LogOrReg=s.nextInt();
						 s.nextLine();
					switch(LogOrReg) {
					
                     
					case 1:
				    	  CheckUserName(s,method,st, result);
				    	  break;
					case 2:
				    	   if(loginPassenger(s3, st, result)) {
				    		   System.out.println("Login Successfull  !");
				    	   }
				    	   else {
				    		    System.out.println("Invalid Login");
				    		    break;
				    	   }
				    	   boolean exitUser=true;
				    	   while(exitUser) {
				                boolean Exit=true;
								while(Exit) {
									
									
								 System.out.println("1.Search Flight And Details");
								 
								 System.out.println("2.Make  Reservation");
								 
								 System.out.println("3.Display Your Reservation"); 
								 
								 System.out.println("4.Cancel Reservation");
								 
								 System.out.println("5.exit");
								
										int choiceUser =s.nextInt();
										s.nextLine();
										
									   switch(choiceUser) { 
									   
										   case 1:
								
												System.out.println("Search Flight With AirLine Name");
												String  AireLineName=s.nextLine();
												
												String FlightNumberQuery="select * from flights where flightName = ?;";
												st=SqlConnection.SQLConnector().prepareStatement(FlightNumberQuery);
												st.setString(1, AireLineName);
												result=st.executeQuery();
												
												 System.out.printf("%-5s | %-5s | %-5s | %-15s | %-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s\n", 
										            	    "Flight Name", "Flight Number", "Departure City", "Arrival City", 
										            	    "Departure Date", "Departure Time", "Arrival Time", "Total Seats", 
										            	    "Economy Seats", "Business Seats" ,"Businessticketprice", "Econamyticketprice");

										            	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										            	
										            while(result.next()) {
										            	
										            	String flightName=result.getString("flightName");
										            	String flightNumber=result.getString("flightNumber");
										            	String departurCity=result.getString("DepartuerCity");
										            	String arrivalCity=result.getString("ArrivalCity");
										            	Date DepartuerDate=result.getDate("DepartuerDate");
										            	Time DepartuerTime=result.getTime("DepartuerTime");
										            	Time ArrivalTime=result.getTime("ArrivalTime");
										            	int TotalSeats=result.getInt("TotalSeats");
										            	int econamicalSeats=result.getInt("EconamiClassSeats");
										            	int businessSeats=result.getInt("BusinessClassSeats");
										            	double businessSeatPrice=result.getDouble("Businessticketprice");
										            	double econamySeatprice=result.getDouble("Econamyticketprice");
										            	
										            	//Display the flights
										            	
										            	
										            	System.out.printf("%-15s %-17s %-15s %-16s %-18s %-15s %-14s %-15d %-20d %-15d %-15.2f %-16.2f \n", 
										            	    flightName, flightNumber, departurCity, arrivalCity, 
										            	    DepartuerDate, DepartuerTime, ArrivalTime, TotalSeats, 
										            	    econamicalSeats, businessSeats,businessSeatPrice,econamySeatprice);
								                          
										            }
										   
												break;
											case 2:
												Scanner s5=new Scanner(System.in);
										
												System.out.println("How Many Tickets Book(4 Tickets Only Allow Sametime)");
											
												int Bookings=s5.nextInt();
											
												if(Bookings>4) {
													
													System.out.println("Only 4 Tickets Allowed for Bookings At The time");
													System.out.println();
													
												}
												
												else {
											    System.out.println("Enter From City       :");
									            String Dcity=s2.nextLine();
									            System.out.println("Enter To City         :"); 
									            String Acity=s5.next();
									            System.out.println("Enter Year (yyyy)     :");
									            int Ayear=s5.nextInt();
									            System.out.println("Enter Month   (mm)    :");
									            int Amonth=s5.nextInt();
									            System.out.println("Enter Date    (dd)    :");
									            int Adate=s5.nextInt();
									            LocalDate da=LocalDate.of(Ayear,Amonth,Adate);
								        		Date daa=Date.valueOf(da);
									            
									            String FlightsQueryUser="Select*from flights where DepartuerCity=? AND ArrivalCity=? AND DepartuerDate=?";
									            st=SqlConnection.SQLConnector().prepareStatement(FlightsQueryUser);
									            st.setString(1,Dcity);
									            st.setString(2,Acity);
									            st.setDate(3,daa);
									            result=st.executeQuery();
									            System.out.printf("%-5s | %-5s | %-5s | %-15s | %-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s\n", 
									            	    "Flight Name", "Flight Number", "Departure City", "Arrival City", 
									            	    "Departure Date", "Departure Time", "Arrival Time", "Total Seats", 
									            	    "Economy Seats", "Business Seats" ,"Businessticketprice", "Econamyticketprice");

									            	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
									            	
									            if(result.next()) {
									            	
									            	String flightName=result.getString("flightName");
									            	String flightNumber=result.getString("flightNumber");
									            	String departurCity=result.getString("DepartuerCity");
									            	String arrivalCity=result.getString("ArrivalCity");
									            	Date DepartuerDate=result.getDate("DepartuerDate");
									            	Time DepartuerTime=result.getTime("DepartuerTime");
									            	Time ArrivalTime=result.getTime("ArrivalTime");
									            	int TotalSeats=result.getInt("TotalSeats");
									            	int econamicalSeats=result.getInt("EconamiClassSeats");
									            	int businessSeats=result.getInt("BusinessClassSeats");
									            	double businessSeatPrice=result.getDouble("Businessticketprice");
									            	double econamySeatprice=result.getDouble("Econamyticketprice");
									            	
									            	//Display the flights
									            	
									            	
									            	System.out.printf("%-15s %-17s %-15s %-16s %-18s %-15s %-14s %-15d %-20d %-15d %-15.2f %-16.2f \n", 
									            	    flightName, flightNumber, departurCity, arrivalCity, 
									            	    DepartuerDate, DepartuerTime, ArrivalTime, TotalSeats, 
									            	    econamicalSeats, businessSeats,businessSeatPrice,econamySeatprice);
							                          

									            
									            									            }else {
									            	System.out.println("Enter Valid Flight Details");
									            	break;
									            }
									  
												System.out.println("Enter Which flight Number :");
												System.out.println();
												
												String flightNumber=s2.nextLine();
												String FlightNumberQueryReservation="select flightNumber from flights where flightNumber=?";
												st=SqlConnection.SQLConnector().prepareStatement(FlightNumberQueryReservation);
												st.setString(1,flightNumber);
												result=st.executeQuery();
												while(result.next()) {
												    	
												
												for(int i=1;i<=Bookings;i++){
													
																	
												System.out.println("Enter passenger Name:");
												System.out.println();
												
												String passengername=s.nextLine();
												if(!method.validName(passengername))
												{
														System.out.println("Enter Valid Passenger Name");
												}
											
												else {
													
													 System.out.println("Enter Passenger Age");
													 int age=s5.nextInt();
													 if(age<120) {
													 
												     System.out.println("Enter Gender male OR femail ");
												     String gender=s3.nextLine();
												     
												     String male="male";
												     String femail="femail";
												     if(gender.equalsIgnoreCase(male)||gender.equalsIgnoreCase(femail)) {
													
												System.out.println("Enter passport Number:");
												
												String passportNumber=s.nextLine();
												
												if(!method.validPassporNumber(passportNumber)) 
												{
													
														System.out.println("Invalid Paassport Number");
													
												}
												else {
													String ValidPassportNumberQuery="Select passenger_passportNumber from passengers where passenger_passportNumber=?;";
													st=SqlConnection.SQLConnector().prepareStatement(ValidPassportNumberQuery);
													st.setString(1,passportNumber);
													result=st.executeQuery();
													if(result.next()) {
													System.out.println("Enter Valid PassportNumber");
													}else {
												System.out.println("Enter Phone Number :");
												
												String phoneNumber=s3.nextLine();
												
												if(!method.validPhoneNumber(phoneNumber)) {
													
														System.out.println("Enter Valid Phone Number");
													
												}
												
												else {
													System.out.println("Enter Economy Or Business");
													String TicketType=s.nextLine();
													LocalDate daate=LocalDate.of(Ayear, Amonth, Adate);
													Date datee=Date.valueOf(daate);
													
													
													String TimeQueryArrival="select DepartuerTime,ArrivalTime from flights where flightNumber=? ;";
													st=SqlConnection.SQLConnector().prepareStatement(TimeQueryArrival);
													st.setString(1,flightNumber);
													result=st.executeQuery();
													Time DTimee=null;
													Time ATimee=null;
													if(result.next()) {
														
													 DTimee=result.getTime("DepartuerTime");
													
													 ATimee=result.getTime("ArrivalTime");
													 
													}
												    int n1=0;
													int n2=0;
													/*String QueryTicketAvailablityCheck=null;
													ResultSet result1=null;
													if(TicketType.equalsIgnoreCase("Econamy")) {
													    QueryTicketAvailablityCheck="select EconomiClassSeats from flights where flightNumber=? AND EconomiClassSeats >0;";
														st=SqlConnection.SQLConnector().prepareStatement(QueryTicketAvailablityCheck);
													    st.setString(1,flightNumber);
														
														result1=st.executeQuery();
													}
														 else if(TicketType.equalsIgnoreCase("Business")) {
															 QueryTicketAvailablityCheck="select BusinessClassSeats from flights where flightNumber=? AND BusinessClassSeats >0 ;";
															st=SqlConnection.SQLConnector().prepareStatement(QueryTicketAvailablityCheck);
															st.setString(1,flightNumber);
															
															result1=st.executeQuery();
														 }
														 
															if(result1.next() && result1!=null) {*/
													
														if(TicketType.equalsIgnoreCase("Economy")) {
														String TicketQuery="UPDATE flights SET EconamiClassSeats = EconamiClassSeats - 1 WHERE flightNumber = ?;";
														st=SqlConnection.SQLConnector().prepareStatement(TicketQuery);
														
														st.setString(1,flightNumber);
														n1=st.executeUpdate();
														}	
												else if(TicketType.equalsIgnoreCase("Business")){
															String TicketTypeQuery="UPDATE flights SET BusinessClassSeats = BusinessClassSeats - 1 WHERE flightNumber = ?;";
															st=SqlConnection.SQLConnector().prepareStatement(TicketTypeQuery);
															
															st.setString(1,flightNumber);
															n2=st.executeUpdate();
															
														}
														double price=0;
														if(n1>0||n2>0) {
															if(TicketType.equalsIgnoreCase("Business")) {
															
															String PriceQuery="select Businessticketprice from flights where DepartuerCity = ? AND ArrivalCity = ?;";
															st=SqlConnection.SQLConnector().prepareStatement(PriceQuery);
											
															st.setString(1,Dcity);
															st.setString(2,Acity);
															result=st.executeQuery();
															if(result.next()) {
																price=result.getDouble("Businessticketprice");
															}
															}
															else if(TicketType.equalsIgnoreCase("Economy")) {
																String EconamiPriceQuery="select Econamyticketprice from flights where DepartuerCity = ? AND ArrivalCity = ?;";
																st=SqlConnection.SQLConnector().prepareStatement(EconamiPriceQuery);
												
																st.setString(1,Dcity);
																st.setString(2,Acity);
																result=st.executeQuery();
																if(result.next()) {
																	price=result.getDouble("Econamyticketprice");
																}
															}
															
															else {
																System.out.println("Enter Econamy or Business");
															}
															
															int CancelFees=0;
															boolean cancelfee=false;
															while(!cancelfee) {
																System.out.println("Cancel Fee 1000rs ");
																System.out.println();
																System.out.println("1.Yes");
																System.out.println();
																System.out.println("2.No");
																int CancelNoYes=s.nextInt();
																switch(CancelNoYes) {
																case 1:
																	CancelFees=1000;
																	cancelfee=true;
																	break;
																case 2:
																	CancelFees=0;
																	cancelfee=true;
																	break;
																default:
																	System.out.println("Choose Correct Option");
																   break;
																}
																
															}
															String PassengerQuery="insert into passengers(passenger_name,passenger_age,passenger_gender,passenger_passportNumber,passenger_ContactNumber,passenger_TicketType,passenger_departureCity,passenger_arrivalCity,departureDate,FlightNumber,departuerTime,arrivalTime,ticketprice,CancelFee) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
															st=SqlConnection.SQLConnector().prepareStatement(PassengerQuery);
															
															st.setString(1,passengername);
															st.setInt(2,age);
															st.setString(3,gender);
															st.setString(4,passportNumber);
															st.setString(5,phoneNumber);
															st.setString(6,TicketType);
															st.setNString(7,Dcity);
															st.setString(8,Acity);
															st.setDate(9,datee);
															st.setString(10,flightNumber);
															st.setTime(11,DTimee);
															st.setTime(12,ATimee);
															st.setDouble(13,price);
															st.setDouble(14,CancelFees);
															int n=st.executeUpdate();	
													if(n>0) {
													     String ReserveIDQuery="select passenger_reservationID from passengers where passenger_passportNumber=?;";
													     
													     st=SqlConnection.SQLConnector().prepareStatement(ReserveIDQuery);
													     st.setString(1,passportNumber);
													     result=st.executeQuery();
													     while(result.next()) {
													    	 int ReserveId=result.getInt("passenger_reservationID");
													    	 System.out.println("Resrvation ID :"+ReserveId);
													     }
													
													     result.close();
													
													     st.close();
														}
														}
															
															
														else {
															System.out.println("Enter Economy OR Business");
														}
													/*}
															else {
																System.out.println("Seats are not available");
															}*/
													}
											
												
													}
										
												
												     }
												
												} else {
													 System.out.println("Enter Valid Age");
												 }
												}
												}
												}
											 }
												}
										        
												    break;
											
											case 3:
												
												System.out.println("Enter Resevatiopn ID");
												int ReserveID=s3.nextInt();
												
												String UserDisplyQuery ="select * from passengers where passenger_reservationID=? ;";
												st=SqlConnection.SQLConnector().prepareStatement(UserDisplyQuery);
												st.setInt(1,ReserveID);
												result=st.executeQuery();
												while(result.next()) {
													int reservevatiid=result.getInt("passenger_reservationID");
													String passengername=result.getString("passenger_name");
													int age=result.getInt("passenger_age");
													String gender=result.getString("passenger_gender");
													String passportNumber=result.getString("passenger_passportNumber");
													String phoneNumber=result.getString("passenger_ContactNumber");
													String ticketType=result.getString("passenger_TicketType");
													String dcity=result.getString("passenger_departureCity");
													String acity=result.getString("passenger_arrivalCity");
													Date dDate=result.getDate("departureDate");
													String FlName=result.getString("FlightNumber");
													Time dTime=result.getTime("departuerTime");
													Time aTime=result.getTime("arrivalTime");
													double price =result.getDouble("ticketprice");
													double cancelFee=result.getDouble("CancelFee");
									
													
													System.out.println("+----------------------+------------------+-----+--------+------------------+------------------+-------------+----------------+--------------+----------------+---------------+----------------+--------------+------------+------------+");
													System.out.println("| Reservation ID       | Passenger Name   | Age | Gender | Passport Number  | Contact Number   | Ticket Type | Departure City | Arrival City | Departure Date | Flight Number | Departure Time | Arrival Time |ticketprice | CancelFees |");
													System.out.println("+----------------------+------------------+-----+--------+------------------+------------------+-------------+----------------+--------------+----------------+---------------+----------------+--------------+------------+------------+");

												
													System.out.printf("| %-20d | %-16s | %-3d | %-6s | %-16s | %-16s | %-11s | %-14s | %-12s | %-14s | %-13s | %-14s | %-12s | %-12f |%-12f |\n",
													    reservevatiid, passengername, age, gender, passportNumber, phoneNumber, ticketType, dcity, acity, dDate.toString(), FlName, dTime.toString(), aTime.toString(),price, cancelFee);

													System.out.println("+----------------------+------------------+-----+--------+------------------+------------------+-------------+----------------+--------------+----------------+---------------+----------------+--------------+------------+------------+");

												}
												break;
											 
								            case 4:
								            	
								            	System.out.println("Enter Economy Or Business");
												String TicketType=s.nextLine();
											
												String Econamy="Economy";
												String Business="Business";
												int n1=0;
												int n2=0;
												if(TicketType.equalsIgnoreCase(Econamy)||TicketType.equalsIgnoreCase(Business)) {
													
						                            System.out.println("Enter Passenger Name :");
						                            String name=s2.nextLine();
								             		System.out.println("Enter Reservation ID :");
								    				int reservationID=s.nextInt();
								    				try {
								    				String CancelfeeCheckQuery="select CancelFee from passengers where CancelFee != 0 AND passenger_name = ? AND passenger_reservationID = ?;";
								    				st=SqlConnection.SQLConnector().prepareStatement(CancelfeeCheckQuery);
								    				st.setString(1,name);
								    				st.setInt(2,reservationID);
								    				result=st.executeQuery();
								    				while(result.next()) {
								    				
								    				String CancelQuery="Delete from passengers where passenger_reservationID = ?;";
								    						
								    				st=SqlConnection.SQLConnector().prepareStatement(CancelQuery);
								    				st.setInt(1, reservationID);
								    			    int n=st.executeUpdate();
								    			    if(n<0) {
								             		if(system.cancelReservation(reservationID,TicketType))
								             		{
								             			if(TicketType.equals(Econamy)) {
								    						String TicketQuery="UPDATE flights SET EconomiClassSeats = EconomiClassSeats + ?;";
								    						st=SqlConnection.SQLConnector().prepareStatement(TicketQuery);
								    						st.setInt(1,1);
								    						n1=st.executeUpdate();
								    						System.out.println("Reservation Cancel Successfull");
								    						}
								             			else if(TicketType.equalsIgnoreCase(Business)){
															String TicketTypeQuery="UPDATE flights SET BusinessClassSeats = BusinessClassSeats + ?;";
															st=SqlConnection.SQLConnector().prepareStatement(TicketTypeQuery);
															st.setInt(1,1);
															n2=st.executeUpdate();
															System.out.println("Reservation Cancel Successfull");
								             			}
								             		}
								    			    }
								    				}
								    				}catch(SQLException e) {
								    					System.out.println("Enter Valid ID or your Reservation Is Not To be Cancel");
								    				}
												}
												else {
													System.out.println("Enter Valid Input");
												}
								             	break;
								            case 5:
								            	exitUser=false;
								            	Exit=false;
								            	break;
						             default :
						            	 System.out.println("Enter Valid Option");
						            	 break;
									   }
									   }
								 }
									break;	

				    	         
					case 3:
						
						LOGGORREG=true;
						break;
				    	   default:
				    		   System.out.println("Enter Valid Option");
					}
					}
					break;
									case "b":
					boolean exitAdmin=true;
					while(exitAdmin) {
					 System.out.println("1.Admin Registration");
					   
				     System.out.println("2.Admin Login");
				     System.out.println("3.Exit");
				 int Adminchoice =s.nextInt();
					s.nextLine();
				
				   switch(Adminchoice) { 
			    	  
			       case 1:
			    	 
			    	   boolean AD=false;
			    	   while(!AD) {
				     System.out.println("Enter Admin UserName (Enter AirLine Given Admin Name):");
				     String username=s.nextLine();
				     
				     System.out.println("Enter Admin password (Enter AirLine Given Admin Password)");
				     String password=s.nextLine();
		 
				     if(a.authenticate(username,password)) {
				    	 AD=true;
				    	 boolean ANAME=false;
				    	 while(!ANAME) {
				    	 System.out.println("Enter Your Name :");
				    	 
				    	 String AdminNameValid=s.nextLine();
				    	 if(!method.validAdminName(AdminNameValid)) {
				    		 System.out.println("Name is Only in Letters");
				    	 }
				    	 else {
				    		 
				    		 ANAME=true;
					     
					     String AdminQuery="insert into admin(AdminName) values(?);";
					     
					     st=SqlConnection.SQLConnector().prepareStatement(AdminQuery);
					     st.setString(1,AdminNameValid);
					     
					    int n=st.executeUpdate();
					  
					     if(n>0);
					     {
					    	
					    	String AdminIDTable="select AdminId from admin where AdminName=?";
					    	st=SqlConnection.SQLConnector().prepareStatement(AdminIDTable);
					    	st.setString(1,AdminNameValid);
					    	result=st.executeQuery();
					        while(result.next()) {
					    		
					    		int AdminId=result.getInt("AdminId");
					    		System.out.println("Admin ID  :"+AdminId);
					    	}
					    	
					     }
				    	 }
				    	 }
				    	 }
				     else {
						 System.out.println("Invalid Admin Username OR Password ");
					      }
			    	   }
			    	   
				     break;
				     
			                   case 2:
						
			             	if(system.CheckAdminName(s3,s,st, result)) {
			             		boolean AdminFuntions=false;
			             		
			             		while(!AdminFuntions) {
			             			
			             		 System.out.println("1.Display Reservation");
							  		
			   			         System.out.println("2.Add Flight");	     
			   						
			   			         System.out.println("3.Show All Flights");
			   			                                         
			   				     System.out.println("4.Remove the Flight");
			   				     
			   				     System.out.println("5.Exit");
			   				  int ADMINCHOOCE=s.nextInt();
		             			switch(ADMINCHOOCE) {
		             			
			             			
		             			case 1:            
			             		
			             		String AdminDisplyQuery ="select * from passengers;";
			    				st=SqlConnection.SQLConnector().prepareStatement(AdminDisplyQuery);
			    				result=st.executeQuery();
			    				System.out.println("+----------------------+------------------+-----+--------+------------------+------------------+-------------+----------------+--------------+----------------+---------------+----------------+--------------+------------+------------+");
		    					System.out.println("| Reservation ID       | Passenger Name   | Age | Gender | Passport Number  | Contact Number   | Ticket Type | Departure City | Arrival City | Departure Date | Flight Number | Departure Time | Arrival Time |ticketprice | CancelFees |");
		    					System.out.println("+----------------------+------------------+-----+--------+------------------+------------------+-------------+----------------+--------------+----------------+---------------+----------------+--------------+------------+------------+");

			    				while(result.next()) {
			    					int reservevatiid=result.getInt("passenger_reservationID");
			    					String passengername=result.getString("passenger_name");
			    					int age=result.getInt("passenger_age");
			    					String gender=result.getString("passenger_gender");
			    					String passportNumber=result.getString("passenger_passportNumber");
			    					String phoneNumber=result.getString("passenger_ContactNumber");
			    					String ticketType=result.getString("passenger_TicketType");
			    					String dcity=result.getString("passenger_departureCity");
			    					String acity=result.getString("passenger_arrivalCity");
			    					Date dDate=result.getDate("departureDate");
			    					String FlName=result.getString("FlightNumber");
			    					Time dTime=result.getTime("departuerTime");
			    					Time aTime=result.getTime("arrivalTime");
			    					double price =result.getDouble("ticketprice");
									double cancelFee=result.getDouble("CancelFee");
			    					
			    					
			    				
			    					System.out.printf("| %-20d | %-16s | %-3d | %-6s | %-16s | %-16s | %-11s | %-14s | %-12s | %-14s | %-13s | %-14s | %-12s |%-12f |%-12f |\n",
			    					    reservevatiid, passengername, age, gender, passportNumber, phoneNumber, ticketType, dcity, acity, dDate.toString(), FlName, dTime.toString(), aTime.toString(),price,cancelFee);

			    					System.out.println("+----------------------+------------------+-----+--------+------------------+------------------+-------------+----------------+--------------+----------------+---------------+----------------+--------------+");
                            
			             	}
			             break;
				       
		           case 2:  
		        	   Scanner s4=new Scanner(System.in);
		        	      
		        	        boolean typef=false;
		        	        System.out.println("Add  Flight Type");
		        	        while(!typef) {
		        	        System.out.println();
		        	        System.out.println("1.Narrow-body aircraft");
		        	        System.out.println();
		        	        System.out.println("2.Wide-body aircraft");
		        	        System.out.println();
		        	        System.out.println("3.Very Large Aircraft");
		        	        if(s4.hasNextInt()) {
		        	        
		        	        int optionFlightType =s4.nextInt();
		        	        try {
		        	        switch(optionFlightType) {
		        	        case 1:
		        	        	newFlightType="Narrow-body aircraft";
		        	        	newTotalSeats =200;
		        	        	newBusinessClassSeats=8;
		        	        	NormalClassSeats=newTotalSeats-newBusinessClassSeats;
		        	        	typef=true;
		        	        	break;
		        	        case 2:
		        	        	newFlightType="Wide-body aircraft";
		        	        	newTotalSeats=500;
		        	            newBusinessClassSeats=28;
		        	        	NormalClassSeats=newTotalSeats-newBusinessClassSeats;
		        	        	typef=true;
		        	        	break;
		        	        case 3:
		        	        	newFlightType="Very Large Aircraft";
		        	        	newTotalSeats=700;
		        	        	newBusinessClassSeats=0;
		        	        	NormalClassSeats=newTotalSeats-newBusinessClassSeats;
		        	        	typef=true;
		        	        	break;
		                    default:
		                    	System.out.println("Enter Valid Option");
		                    	break;
		        	        }
		        	        
		        	        }catch(Exception e) {
		        	        	System.out.println("Enter Valid Option");
		        	        }
		        	       
		        	        }
		               else {
		        	        System.out.println("Enter Valid Option");
		        	        s4.next();
		        	        }
		        	        }
		        	        boolean FNN=false;
		        	        System.out.println("Enter Flight Name");
		        	        while(!FNN) {
		        		
		        		
		        		String newFlightName=s4.nextLine();
		    
		        		if(newFlightName.isEmpty()){
		        			
		        		}
		        		else {
		        			FNN=true;
		        	        	boolean FL=false;
		        	        	
		            		System.out.println(" Enter Flight Number :");
		            		String newFlightNumber=s4.nextLine();
		            		
		            		while(!FL&&!newFlightNumber.isEmpty()) {
		               
		                    	 if(!system.ValidFlightNumbers(newFlightNumber)) {
		                    		 System.out.println("Enter Valid Flight Number");
		                    		 break;
		                    	 }
		                    	 else {
		                    		 FlightNumbers.add(newFlightNumber);
		            			       FL=true;	
		            			boolean D=false;
		            			
		            				
		            		System.out.println("Enter Departure place");
		            		while(!D) {
		            		String newDeparture=s4.nextLine();
		            		if(newDeparture.isEmpty()) {
		            			     		}
		            		else {
		            			D=true;
		            			boolean A=false;
		            			while(!A) {
		            				
		            		System.out.println("Enter Arraival City");
		            		String newArraivalcity=s4.nextLine();
		            		if(newArraivalcity.isEmpty()||newArraivalcity.equals(newDeparture))
		            		{
		            			System.out.println("Enter Valid City");
		            			break;
		            			        		}
		            		else {
		            		A=true;
		            		boolean DA=false; 
		            		while(!DA) {
		            		System.out.println("Enter Date");
		            		System.out.println("Year");
		            		int year =s4.nextInt();
		            		System.out.println("Month");
		            		int month =s4.nextInt();
		            		System.out.println("Date");
		            		int date=s4.nextInt();
		            		LocalDate da=LocalDate.of(year, month,date);
		            		Date daa=Date.valueOf(da);
		            		
		            			DA=true;
		            		    boolean DT=false;
		            		    while(!DT) {
		            		System.out.println("Enter DepartureTime");
		            		System.out.println();
		            		System.out.println("Enter Hour");
		            		int  Hour=s4.nextInt();
		            		System.out.println("Enter Minutes");
		            		int minutes=s4.nextInt();
		                    LocalTime dt=LocalTime.of(Hour, minutes);       		
		            			DT=true;
		            			boolean AT=false;
		            			while(!AT) {
		            		System.out.println("Enter ArraivalTime");
		            		System.out.println();
		            		System.out.println("Enter Hour");
		            		int aHour=s4.nextInt();
		            		System.out.println("Enter Minutes");
		            		int aMinutes=s4.nextInt();
		            		LocalTime at=LocalTime.of(aHour, aMinutes);
		            		
		            		System.out.println("Enter Business Ticket Price");
		            		double BusinessTprice=s.nextDouble();
		            		if(BusinessTprice!=0) {
		            			System.out.println("Enter Econamy Ticket Price");
		            			double EconamiTicket=s2.nextDouble();
		            			if(EconamiTicket!=0) {
		            			AT=true;
		            			String FlightQuery="insert into Flights values (?,?,?,?,?,?,?,?,?,?,?,?);";
		            			st=SqlConnection.SQLConnector().prepareStatement(FlightQuery);
		            			st.setString(1,newFlightName);
		            			st.setNString(2,newFlightNumber);
		            			st.setString(3,newDeparture);
		            			st.setString(4, newArraivalcity);
		            			st.setDate(5,daa);
		            			st.setTime(6,Time.valueOf(dt));
		            			st.setTime(7,Time.valueOf(at));
		            			st.setInt(8,newTotalSeats);
		            			st.setInt(9,NormalClassSeats);
		            			st.setInt(10,newBusinessClassSeats);
		            			st.setDouble(11, BusinessTprice);
		            			st.setDouble(12, EconamiTicket);
		            			
		            			int n=st.executeUpdate();
		            			if(n>0) {
		            		system.addFlight(new Flight(newFlightNumber,newFlightName,newDeparture,newArraivalcity,year,month,date,Hour,minutes,aHour,aMinutes,newTotalSeats,NormalClassSeats,newBusinessClassSeats,newFlightType));
		            		System.out.println("Flight added successfully!");
		            	}
		            		}
		            		}
		            			}
		            			}
		            		}
		            		}
		            			}
		            		}
		            		}
		                     }
		            		    }
		            		}
		        	        }
		            	break;
		           case 3:
		        	   
		        	    String FlightsQueryUser="select * from flights;";
			            st=SqlConnection.SQLConnector().prepareStatement(FlightsQueryUser);
			            result=st.executeQuery();
			            System.out.printf("%-5s | %-5s | %-5s | %-15s | %-10s | %-15s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s\n", 
			            	    "Flight Name", "Flight Number", "Departure City", "Arrival City", 
			            	    "Departure Date", "Departure Time", "Arrival Time", "Total Seats", 
			            	    "Economy Seats", "Business Seats" ,"Businessticketprice", "Econamyticketprice");

			            	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			            	
			            while(result.next()) {
			            	
			            	String flightName=result.getString("flightName");
			            	String flightNumber=result.getString("flightNumber");
			            	String departurCity=result.getString("DepartuerCity");
			            	String arrivalCity=result.getString("ArrivalCity");
			            	Date DepartuerDate=result.getDate("DepartuerDate");
			            	Time DepartuerTime=result.getTime("DepartuerTime");
			            	Time ArrivalTime=result.getTime("ArrivalTime");
			            	int TotalSeats=result.getInt("TotalSeats");
			            	int econamicalSeats=result.getInt("EconamiClassSeats");
			            	int businessSeats=result.getInt("BusinessClassSeats");
			            	double businessSeatPrice=result.getDouble("Businessticketprice");
			            	double econamySeatprice=result.getDouble("Econamyticketprice");
			            	
			            	//Display the flights
			            	
			            	
			            	System.out.printf("%-15s %-17s %-15s %-16s %-18s %-15s %-14s %-15d %-20d %-15d %-15.2f %-16.2f \n", 
			            	    flightName, flightNumber, departurCity, arrivalCity, 
			            	    DepartuerDate, DepartuerTime, ArrivalTime, TotalSeats, 
			            	    econamicalSeats, businessSeats,businessSeatPrice,econamySeatprice);
	                          
			            }
			           		        	   break;
		            case 4:
							
		            	System.out.println("Enter Flight Number");
		            	
		            	String DeleteFlightNumber=s1.nextLine();
		            	
		            		String CancelQuery="Delete from flights where flightNumber = ?;";
		            		st=SqlConnection.SQLConnector().prepareStatement(CancelQuery);
		            		st.setString(1,DeleteFlightNumber);
		            		int n=st.executeUpdate();
		            		if(n>0) {
		            		System.out.println("Remove The Flight Successfully"); 
		            		}
		         		    break;
					case 5:
						AdminFuntions=true;
						break;
						default:
							System.out.println("Invalid Choice please try again.");
						
		             			}
			             		}
		             			}else {	
		             				System.out.println("AdminLogin First");
		             			}
			                   break;
			                   case 3:
			                	   exitAdmin=false;
			                	   break;
				    default:
				    	System.out.println("Invalid Choice please try again.");
					
					}
					}
					
					break;
					
				case "c":
					System.out.println("Exit...");
					return;
					default:
						System.out.println("Enter Valid Option");
					}
				}catch(Exception e) {
					
				}
				
	     }else {
						System.out.println("INVALID OPERATION IS PRESENT SO IT'S CAN'T EXCECUTE THAT");
						System.out.println();
						s.next();
					}
				 
	              }
					}
}
