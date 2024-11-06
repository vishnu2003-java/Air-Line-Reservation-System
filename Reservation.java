package airline;
public class Reservation {
         
	 private static int idCount=0;
	 private int  reservationID;
	 private Flight flight;
	 private Passenger passenger;
	 public Reservation(Flight flight,Passenger passenger)
	 {
		this.reservationID=++idCount;
		this.flight=flight;
		this.passenger=passenger;
	 }
	 public Flight getFlight() {
			return flight;
	 }
		public Passenger getPassenger() {
			return passenger;
		}
	public int getReservationID() {
		return reservationID;
	}

	
     
}

