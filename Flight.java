package airline;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Flight {
	 private String FlightNumber;
	 private String AirlineName;
	 private String Departuarcity;
	 private String arrivalCity;
	 private int totalSeats;
	 private int availableNormalClassSeats;
	 private int Businessclasstickets;
	 private List<Passenger> passengers;
	 private   LocalDate departuarDate;
     private   LocalTime departureTime;
	 private   LocalTime arraivalTime;
	 private String  FlightType;
	public  Flight(String flightNumber,String AirlineName,String Departuarcity,String arrivalCity,int year,int month,int date,int Hour,int minutes,int aHour,int aMinutes,int totalSeats,int availableNormalClassSeats, int Businessclasstickets,String FlightType)
	 {
		 this.FlightNumber=flightNumber;
		 this.AirlineName=AirlineName;
		 this.Departuarcity=Departuarcity;
		 this.arrivalCity=arrivalCity;
		 this.departuarDate=LocalDate.of(year, month,date);
		 this.departureTime=LocalTime.of(Hour, minutes);
		 this.arraivalTime=LocalTime.of(aHour, aMinutes);
		 this.totalSeats=totalSeats;
		 this.availableNormalClassSeats=availableNormalClassSeats;
		 this.Businessclasstickets=Businessclasstickets;
		 this.FlightType=FlightType;
		 this.passengers=new ArrayList<>();		 
	 }
	public  LocalDate getDepartuarDate() {
		return departuarDate;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	 public String getFlightNumber() {
			return FlightNumber;
		}
		public String getAirlineName() {
			return AirlineName;
		}

		public String getDepartuarcity() {
			return Departuarcity;
		}

		public String getArrivalCity() {
			return arrivalCity;
		}

		public int getAvailableNormalClassSeats() {
			return availableNormalClassSeats;
		}
		public LocalTime getDepartureTime() {
			return departureTime;
		}
		public LocalTime getArraivalTime() {
			return arraivalTime;
		}
		public int getBusinessclasstickets() {
			return Businessclasstickets;
		}
		public boolean bookSeat(Passenger passenger) {
		    if (availableNormalClassSeats > 0) {
		        passengers.add(passenger);
		        availableNormalClassSeats--;
		        return true;
		    } else {
		        return false;
		    }
		}
		public boolean BookseatsBusiness(Passenger passenger) {
			if(Businessclasstickets>0) {
				passengers.add(passenger);
				Businessclasstickets--;
				return true;
			}
			else {
				return false;
			}
		}
		
		public void cancelRecervation(Passenger passenger)
		{	
		  if(passengers.remove(passenger))
		  {
			  availableNormalClassSeats++;
		  }
		  else
		  {
			  System.out.println("Enter the valid CoustemerId");
		  }
		  
		}
		public String getFlightType() {
			return FlightType;
		}
		
		
}


