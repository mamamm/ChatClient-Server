package chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class start {
	
	public static void buildClient(String usr, String address){
		
		//declares and utilises the ip variable
		InetAddress ip = null;
		
		//transforms the STRING address into an InetAddress
		//throws an exception if not possible
		try {
			ip = InetAddress.getByName(address);
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		//pings the address
		boolean pingIt = new ping().Ping(ip);
		
		//checks whether the username is letters and numbers only.
		boolean usrIsGood = new usrCheck().check(usr);
		
		//checks that both username and the ip are okay, and then opens the chat window.
		if(usrIsGood == true && pingIt == true){
			
			//displays a pop-up with the message
			JOptionPane.showMessageDialog(null, "Welcome to RedChat " + usr + "!");
			
			//opens chat window.
			new chatDisplay().CreateWindow();
		}
		else{
			//shows the exiting... message.
			JOptionPane.showMessageDialog(null, "Exiting... The UserName you entered, or the IP you entered was incorrect.");
			//exits the system.
			System.exit(0);
		}
	}
}
