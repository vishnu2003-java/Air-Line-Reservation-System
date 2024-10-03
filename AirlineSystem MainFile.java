package airline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AirlineSystem {
    private List<Flight> flights;
	private List<Reservation> reservations;
	static int reserveId;
	static int newTotalSeats;
    int newBusinessClassSeats;
	static int NormalClassSeats;
	private static final Map<String,String> passengerCredentials=new HashMap<>();
	public  AirlineSystem()
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
			 if(flight1.getDepartuarcity().equals(Dcity)&&flight1.getArrivalCity().equals(Acity)&&flight1.getDepartuarDate().equals(LocalDate.of(Ayear, Amonth, Amonth))) {
				 System.out.println("flight Number       :"+flight1.getFlightNumber());
				   System.out.println("AirLine Name       :"+flight1.getAirlineName());
				   System.out.println("Departure City     :"+flight1.getDepartuarcity());
				   System.out.println("Arraival City      :"+flight1.getArrivalCity());
				   System.out.println("Date               :"+flight1.getDepartuarDate());
				   System.out.println("Departure Time     :"+flight1.getDepartureTime());
				   System.out.println("Arraival Time:     :"+flight1.getArraivalTime());
				   System.out.println("Toatal Seats       :"+flight1.getTotalSeats());
				   System.out.println("EconamyClass Seats    :"+flight1.getAvailableNormalClassSeats());
				   System.out.println("BusinessClass Seats: "+flight1.getBusinessclasstickets());
				   System.out.println();
			 }
			 
		 }
	}
	public boolean notValidCity(String Dcity,String Acyty,int Ayear,int Amonth,int Adate ) {
		for(Flight flight1 : flights) {
			while(flight1.getDepartuarcity().contains(Dcity)&&flight1.getArrivalCity().contains(Acyty)&&flight1.getDepartuarDate().equals(LocalDate.of(Ayear, Amonth, Amonth)))
			{
				return true;
			}
		}
		 return false;
		
			
			}

	public void makeReservation(String flightNumber,Passenger passenger) {

	     for(Flight flight1:flights) {
			if(flight1.getFlightNumber().equals(flightNumber)) 
			{
				
				if(flight1.bookSeat(passenger)) {
				
					reservations.add(new Reservation(flight1,passenger));
					
					System.out.println("Reservation successful");
						 ++reserveId;
						 System.out.println();
					System.out.println(" Your Reservation ID:"+ "  " +reserveId);
					System.out.println();
				}
				else {
					System.out.println("No available seats");
				}
				return;
			}
		}
		System.out.println("Flight not found");
	}
	public boolean cancelReservation(int reservationID) {
		
		for(Reservation reservation:reservations) {
			if(reservation.getReservationID()== reservationID) {
				reservation.getFlight().cancelRecervation(reservation.getPassenger());
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
			System.out.println("Reservation ID:  " +reservation.getReservationID()+"  |  "+
	         "Date:    "+reservation.getFlight().getDepartuarDate()+"  |   "
					+ "Flight Number:   "+reservation.getFlight().getFlightNumber()+" |    "
							+ "passenge Name:  "+reservation.getPassenger().getName()+" |  "+"PassportNumber   :"+reservation.getPassenger().getPassportNumber()+"  |  "+"Passenger Phone Number  :"+reservation.getPassenger().getPhoneNumber()+"Passenger Age    :"+"    |   "+reservation.getPassenger().getAge()+"Passenger Gender    :"+reservation.getPassenger().getGender());
			System.out.println();
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
				   System.out.println("flight Number       :"+flight2.getFlightNumber());
				   System.out.println("AirLine Name       :"+flight2.getAirlineName());
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
				   System.out.println("flight Number      :"+flight2.getFlightNumber());
				   System.out.println("AirLine Name       :"+flight2.getAirlineName());
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
		

	private static boolean authenticate1(String name,String userPassword) {
		return userPassword.equals(passengerCredentials.get(name));
	}
	private static boolean loginPassenger(Scanner s) {
		   System.out.println("Login First");
		   System.out.println();
		   System.out.println("Enter Username");
		   String name=s.nextLine();
		   System.out.println("Enter Password");
		   String password=s.nextLine();
		   if(authenticate1(name,password)) {
			   System.out.println("Login Successfull");
			
					   return true;
		   }
		   else {
			  System.out.println("Invalid Username or password");
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
			
public static void main(String[] args) {



		 Scanner s=new Scanner(System.in);
		 Scanner s1=new Scanner(System.in);
         Scanner s2=new Scanner(System.in);
         Scanner s3=new Scanner(System.in);
		 List<String> ADMINname=new LinkedList<>();
		 List<String> FlightNumbers=new LinkedList<>();
		 List<String> PassportNumbers=new LinkedList<>();
	 	  AdminLogin a=new AdminLogin();
	 	  CheckMethods method=new CheckMethods();
	 	  String newFlightType=null;
	 	 
		  AirlineSystem system=new AirlineSystem();
		  int choice =0;
		  //system.addFlight(new Flight("1","a","a","a",2021,1,2,12,21,12,3,110,110,76));
	      //system.addFlight(new Flight("2","Air","Kerla","Madurai",2012,1,1,12,21,22,1,11,11,76));
	      //system.addFlight(new Flight("3","a","Chennai","Kolkata","12-02-2024","3.30 pm","7:28 pm",110,110));
	    boolean Admin=false;     	
		while(true) {
			
			System.out.print ("                 ");System.out.println("Welcome To Airline Reservation System");
			System.out.println();
			System.out.print("     USER");System.out.print("                                     ");System.out.print("ADMIN");
			System.out.println();
	    	System.out.println(); 
		    System.out.print("2.User Registration ");              System.out.print("                 ");       System.out.print("1.Admin Login");
		    System.out.println();                                  System.out.print("                 ");       System.out.println("");
		    System.out.print("3.User Login");                      System.out.print("                         ");       System.out.print("7.Display Reservation(Admin Only)");
			System.out.println();                                  System.out.print("           ");       System.out.println("");
			System.out.print("4.Search Flight And Details");       System.out.print("          ");       System.out.print("8.Add Flight(Admin Only)");	     
			System.out.println();                                  System.out.print("            ");       System.out.println("");
			System.out.print("5.Make BusinessClass Reservation");System.out.print("     ");       System.out.print("9.Show All Flights");
                                                                     System.out.println("            ");      System.out.println("");
	        System.out.print("6.Cancel Reservation");              System.out.print("                 ");       System.out.print("10.Remove the Flight");
     		                                                      System.out.println();
     		                                                      System.out.println();
            System.out.print("                            ");            System.out.println("11.Exit");              
			
			if(s.hasNextInt()) {
			choice =s.nextInt();
			s.nextLine();
		
			try {
		   switch(choice) { 
	    	  
	       case 1:
	    	   boolean AD=false;
	    	   while(!AD) {
		     System.out.println("Enter Admin UserName (Enter AirLine Given Admin Name):");
		     String username=s.nextLine();
		     System.out.println("Enter Admin password (Enter AirLine Given Admin Password)");
		     String password=s.nextLine();
 
		     if(a.authenticate(username,password)) {
		    	 Admin=true;
		    	 AD=true;
		    	 boolean ANAME=false;
		    	 while(!ANAME) {
		    	 System.out.println("Enter Your Name :");
		    	 
		    	 String AdminNameValid=s.nextLine();
		    	 if(!method.validAdminName(AdminNameValid)) {
		    		 System.out.println("Admin Name Only in Letters");
		    	 }
		    	 else {
		    	 if(ADMINname.contains(AdminNameValid)) {
		    		 System.out.println("This Name Aldready exists .please Enter Another Name");
		    	 }
		    	 else {
		    		 ANAME=true;
			     ADMINname.add(AdminNameValid);
			     System.out.println("Admin Login Successfull");
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
	    	   boolean namee=false;
	    	  
	    	   while(!namee) {
	    	   System.out.println("Enter User name");
	    	   String name=s.nextLine();
	    	   if(!method.validuserName(name)) {
	    	   System.out.println("Enter Valid username");
	    	   }
	    	   else {
	    	   namee=true;
	    	   boolean passwordd=false;
	    	   while(!passwordd) {
	    		  
	    	   System.out.println("Enter password (must 9 Characters& Numbers )");
	    	   
	    	   String userpassword=s.nextLine();
	    	   if(!method.validPassword(userpassword)) {
	    		   System.out.println("Enter Valid Password");
	    		   
	    	   }
	    	   else {
	    		   passwordd=true;
	    		   
	    	   if(passengerCredentials.containsKey(name))
	    	   {
	    		   namee=false;
	    		   System.out.println("Username aldready exists.please choosw a diffrent username");
	    	   }
	    	   else {
	    		   namee=true;
	    		   passengerCredentials.put(name, userpassword);
	    	       
	    		   System.out.println("Registration Successfull"); 
	    		   System.out.println();
	    	   }
	    		   }
	    	   }
	    	   }
	    	   }
	    	   break;
	       case 3:
	    	   loginPassenger(s);
	    	   break;
		   case 4:
			      
					if(!loginPassenger(s)) {
						System.out.println(" please Login First");
						break;
					}
					else {
				boolean A=false;
			    while(!A) {
				System.out.println("Search Flight With AirLine Name");
				String  AireLineName=s.nextLine();
				
				if(system.notValid(AireLineName)) {
					
					system.searchFlight(AireLineName);
					A=true;
				}
				else {
					System.out.println("Invalid Flight Name Try Again");
					System.out.println();
					
				}
			    }
			    }
					
				break;
			case 5:
				Scanner s5=new Scanner(System.in);
				if(!loginPassenger(s)) {
					System.out.println(" please Login First");
					break;
				}
				else {
				boolean B=false;
				while(!B) {
				System.out.println("How Many Tickets Book(4 Tickets Only Allow Sametime)");
			
				int Bookings=s1.nextInt();
			
				if(Bookings>4) {
					
					System.out.println("Only 4 Tickets Allowed for Bookings At The time");
					System.out.println();
					
				}
				
				else {
				B=true;
				boolean c=false;
				while(!c) {
	            System.out.println("Enter From City       :");
	            String Dcity=s2.nextLine();
				
	            System.out.println("Enter To City         :"); 
	            String Acity=s3.next();
	        
	            System.out.println("Enter Year (yyyy)     :");
	            
	            int Ayear=s5.nextInt();
	            System.out.println("Enter Month   (mm)    :");
	            int Amonth=s5.nextInt();
	            System.out.println("Enter Date    (dd)    :");
	            int Adate=s5.nextInt();
	            try {
	            if(!system.notValidCity(Dcity,Acity,Ayear,Amonth,Adate )) {
	            	System.out.println("Not Availabe This Flight");
	            }
	            else {
	            system.searchCity(Dcity, Acity,Ayear,Amonth,Adate );
	            c=true;
				boolean f=false;
			    while(!f) {
				System.out.println("Enter Which flight Number :");
				System.out.println();
				
				String flightNumber=s3.nextLine();
				if(!system.validFlight(flightNumber))
				{
				    	 System.out.println("Enter valid flightNumber");
					    break;
				}
				else {
					f=true;
					
				for(int i=1;i<=Bookings;i++){
					boolean p=false;
					while(!p) {
									
				System.out.println("Enter passenger Name:");
				System.out.println();
				
				String passengername=s3.nextLine();
				if(!method.validName(passengername))
				{
						System.out.println("Enter Valid Passenger Name");
				}
				
				
				else {
					p=true;
					boolean AG=false;
					while(!AG) {
					 System.out.println("Enter Passenger Age");
					 int age=s3.nextInt();
					 if(age==0) {
					 }
					 else {
						 boolean GN=false;
						 while(!GN) {
				     System.out.println("Enter Gender Male OR Femail ");
				     String gender=s3.nextLine();
				     if(!gender.equalsIgnoreCase("male")||!gender.equalsIgnoreCase("femail")) {
				    	 
				     }else {
						 AG=true;
					boolean Pass=false;
					while(!Pass) {
				System.out.println("Enter passport Number:");
				
				String passportNumber=s3.nextLine();
				
				if(!method.validPassporNumber(passportNumber)) 
				{
					
						System.out.println("Invalid Paassport Number");
					
				}
				else {
					if(PassportNumbers.contains(passportNumber)) {
						System.out.println("Enter Valid PassportNumber");
					}
					else {
						Pass=true;
						PassportNumbers.add(passportNumber);
					boolean PN=false;
					while(!PN) {
					
				System.out.println("Enter Phone Number :");
				
				String phoneNumber=s3.nextLine();
				
				if(!method.validPhoneNumber(phoneNumber)) {
					
						System.out.println("Enter Valid Phone Number");
					
				}
				else {
					PN=true;
					
				Passenger passenger=new Passenger(passengername,passportNumber,phoneNumber,age,gender);
				system.makeReservation(flightNumber, passenger);
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
	            }
	            
	            }catch(Exception e) {
	            	System.out.println("Enter Valid Date");
	            }
				}
				}
				}
				}
				    break;
			
				
			case 6:
				if(Admin) {
					 System.out.println(" Enter Admin Name    :");
	             	 String AdminNamme=s3.nextLine();
	             	if(ADMINname.contains(AdminNamme)){
		        system.displayReservation();
	             	}
	             
	             	else {
	             		System.out.println("Invalid Admin Name");
	             	}
				}
				else {
					System.out.println("Admin Can Only See the Reseravtions");
				}
		        break;
            case 7:
            	if(!loginPassenger(s)) {
					System.out.println(" please Login First");
					break;
				}
            	boolean R=false;
            	while(!R) {
				System.out.println("Enter Reservation ID:");
				int reservationID=s.nextInt();
				if(system.cancelReservation(reservationID)) {
				system.cancelReservation(reservationID);
				R=true;
				}
				else {
					System.out.println("Enter Valid Reservation ID :");
					System.out.println();
				}
            	}
				break;
           case 8:  
        	   Scanner s4=new Scanner(System.in);
        	        if(Admin)
        	        {
        	        System.out.println(" Enter Admin Name    :");
             	    String AdminNamme=s.nextLine();
        	        if(ADMINname.contains(AdminNamme)){
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
        	        
        	        int option =s4.nextInt();
        	        try {
        	        switch(option) {
        	        case 1:
        	        	newFlightType="Narrow-body aircraft";
        	        	newTotalSeats =200;
        	        	system.newBusinessClassSeats=8;
        	        	NormalClassSeats=newTotalSeats-system.newBusinessClassSeats;
        	        	typef=true;
        	        	break;
        	        case 2:
        	        	newFlightType="Wide-body aircraft";
        	        	newTotalSeats=500;
        	        	system.newBusinessClassSeats=28;
        	        	NormalClassSeats=newTotalSeats-system.newBusinessClassSeats;
        	        	typef=true;
        	        	break;
        	        case 3:
        	        	newFlightType="Very Large Aircraft";
        	        	newTotalSeats=700;
        	        	system.newBusinessClassSeats=0;
        	        	NormalClassSeats=newTotalSeats-system.newBusinessClassSeats;
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
        		
        		
        		String newFlightName=s2.nextLine();
    
        		if(newFlightName.equals("")) {
        			
        		}
        		else {
        			FNN=true;
        	        
        	        	boolean FL=false;
        	        	
            		System.out.println(" Enter Flight Number :");
            		String newFlightNumber=s2.nextLine();
            		while(!FL) {
            		if(newFlightNumber.isBlank()) {
            			
            		}
            		
            		else {
            			if(FlightNumbers.contains(newFlightNumber)) {
            				System.out.println("Enter Valid FlightNumber :");
            			    System.out.println();
            			}
            			else {
            			FlightNumbers.add(newFlightNumber);
            			FL=true;
            			
            			boolean D=false;
            			
            				
            		System.out.println("Enter Departure place");
            		while(!D) {
            		String newDeparture=s2.nextLine();
            		if(newDeparture.isEmpty()) {
            			     		}
            		else {
            			D=true;
            			boolean A=false;
            			while(!A) {
            				
            		System.out.println("Enter Arraival City");
            		String newArraivalcity=s2.nextLine();
            		if(newArraivalcity.isEmpty())
            		{
            			        		}
            		else {
            		A=true;
            		boolean DA=false; 
            		while(!DA) {
            		System.out.println("Enter Date (DD-MM-YYYY)");
            		System.out.println("Year");
            		int year =s2.nextInt();
            		System.out.println("Month");
            		int month =s2.nextInt();
            		System.out.println("Date");
            		int date=s2.nextInt();
            		
            		if(date<0&&year<2000&&month<0) {
            			     		}
            		else {
            			DA=true;
            		    boolean DT=false;
            		    while(!DT) {
            		    	
            		System.out.println("Enter DepartureTime (HR:MM  AM/PM)");
            		System.out.println("Enter Hour");
            		int  Hour=s2.nextInt();
            		System.out.println("Enter Minutes");
            		int minutes=s2.nextInt();
            		
            		if(minutes>60&&Hour>24) {
            			        		}
            		else
            		{
            			DT=true;
            			boolean AT=false;
            			while(!AT) {
            		System.out.println("Enter ArraivalTime  (HR:MM) AM/PM");
            		System.out.println();
            		System.out.println("Enter Hour");
            		int aHour=s2.nextInt();
            		System.out.println("Enter Minutes");
            		int aMinutes=s2.nextInt();
            		if(aHour>24&&aMinutes>60) {
            			
            		}
            		else {
            			AT=true;
            		system.addFlight(new Flight(newFlightNumber,newFlightName,newDeparture,newArraivalcity,year,month,date,Hour,minutes,aHour,aMinutes,newTotalSeats,NormalClassSeats,system.newBusinessClassSeats,newFlightType));
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
        	        }
        	        }
        	        	else {
        	        		System.out.println("Invalid Admin Name ");
        	        	}
        	        }
            	else {
            		System.out.println("Only admin can add Flights");
            	} 
            	break;
           case 9:
        	   if(Admin) {
        		   System.out.println(" Enter Admin Name    :");
            	   String AdminNamme=s.nextLine();
       	        if(ADMINname.contains(AdminNamme)){
        	   system.searchFlight();
       	        }
       	        else {
       	        	System.out.println("Enter Valid Admin Name ");
       	        }
        	   }
        	   else {
        		   System.out.println("Admin Can Only Show All Flights ");
        	   }
        	   break;
            case 10:
                boolean DeleteFlight=false;
                while(!DeleteFlight) {
            	System.out.println("Enter Flight Number");
            	
            	String DeleteFlightNumber=s1.nextLine();
            	
            	if(!system.DeleteFlight(DeleteFlightNumber)) {
            		System.out.println("Enter The Valid FlightNumber");
            	}
            	else {
            		DeleteFlight=true;
            		System.out.println("Remove The Flight Successfully");
            	}
                }
            	break;
			case 11:
				System.out.println("Exiting......");
				return;
		    default:
		    	System.out.println("Invalid Choice please try again.");
		   
			}
			}catch(Exception e) {
				System.out.println("INVALID OPERATION IS PRESENT SO IT'S CAN'T EXCECUTE ");
						}
			}else {
				System.out.println("Invalid Option Given The Below Options");
				System.out.println();
				s.next();
			}
		}
		}
		
		}


