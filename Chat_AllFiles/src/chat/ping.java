package chat;

import java.io.IOException;
import java.net.InetAddress;

public class ping{
	
	//a function to ping the target IP, and check whether reachable.
	public boolean Ping(InetAddress ip){
		
		//creates the variable
		boolean testIp = false;
		
		//tries to ping IP. If not reachable throws an exception
		try {
			testIp = ip.isReachable(10000);
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//returns the boolean testIp.
		return testIp;
	}
}