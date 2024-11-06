package airline;

public class Passenger {
	    private String name;
	    private int Age;
	    private String Gender;
		private String passportNumber;
	    private String phoneNumber;
    
	    public Passenger(String name, String passportNumber, String phoneNumber ,int Age,String Gender) {
	        this.name = name;
	        this.passportNumber = passportNumber;
	        this.phoneNumber =phoneNumber;
	        this.Age=Age;
	        this.Gender=Gender;
	    }
	    public int getAge() {
			return Age;
		}
		public String getGender() {
			return Gender;
		}
		public String getName() {
			return name;
		}
		public String getPassportNumber() {
			return passportNumber;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
} 
