package chat;

public class usrCheck {
	
	/* a simple function to check the username
	 * Checks whether it's letters and numbers only, otherwise
	 * returns false.
	 */
	public boolean check(String usr){
		
		//creates a pattern that the username should match
		String pattern = "^[a-zA-z0-9]*$";
			
			//checks the username against the pattern
			if(usr.matches(pattern)){
				return true;
			}
			else{
				return false;
			}
	}
}
