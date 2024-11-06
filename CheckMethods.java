package airline;

public class CheckMethods {

	
	public boolean validPhoneNumber(String phoneNumber) {
	    if (phoneNumber.length() != 10) {
	        return false;
	    }
	    for (int j = 0; j < phoneNumber.length(); j++) {
	        
	    	if (!Character.isDigit(phoneNumber.charAt(j))) {
	            return false;
	        }
	    }
	    return true;
	}

public boolean validName(String passengername) {
	    for (int j = 0; j <passengername.length(); j++) {
	        
	    	if (!Character.isLetter(passengername.charAt(j))) {
	            return false;
	        }
	    }
	    return true;
	}
public boolean validAdminName(String AdminNameValid) {
    for (int j = 0; j <AdminNameValid.length(); j++) {
        
    	if (!Character.isLetter(AdminNameValid.charAt(j))) {
            return false;
        }
    }
    return true;
}
public boolean validPassporNumber(String passportNumber) {
	  if (passportNumber.length() != 9) {
	        return false;
	    }
	    for (int j = 0; j < passportNumber.length(); j++) {
	    	if (!Character.isDigit(passportNumber.charAt(j))&&!Character.isUpperCase(passportNumber.charAt(j))) {
	            return false;
	        }
	    }
	    return true;
	}
public boolean validuserName(String username) {
    for (int j = 0; j <username.length(); j++) {
        
    	if (!Character.isLetter(username.charAt(j))) {
            return false;
        }
    }
    return true;
}
public boolean validPassword(String userpassword) {
	  if (userpassword.length() < 9) {
	        return false;
	    }
	    for (int j = 0; j < userpassword.length(); j++) {
	    	if (!Character.isDigit(userpassword.charAt(j))&&!Character.isLetter(userpassword.charAt(j))) {
	            return false;
	        }
	    	
	    }
	    return true;
	}

}
