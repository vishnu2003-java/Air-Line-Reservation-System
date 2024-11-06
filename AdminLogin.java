package airline;

public class AdminLogin {

	
	private  final String ADMIN_USERNAME="admin";
	private  final String ADMIN_PASSWORD="123admin";
	
	public boolean authenticate(String username, String password) {
		
		return ADMIN_USERNAME.equalsIgnoreCase(username)&&ADMIN_PASSWORD.equalsIgnoreCase(password);
	}
}
