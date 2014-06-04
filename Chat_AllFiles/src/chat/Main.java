package chat;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args){
		//asks the user whether they would like to run a server or a client
		Object[] options = { "Client", "Server" };
		int clientServer = JOptionPane.showOptionDialog(null, 
																	"would you like to run a server or merely a client?",
																	"please choose one", 
																	JOptionPane.YES_NO_OPTION, 
																	JOptionPane.INFORMATION_MESSAGE, 
																	null, 
																	options, 
																	options[0]);
		
		if(clientServer == 0){
			start.buildClient(usr, address);
		}
		if(clientServer == 1){
			Server.buildServer();
		}
		/*
		else{
			System.out.println("Client OR Server was not picked | inappropriate input exception");
			System.exit(0);
		}*/
	}
	
	//requests the user to enter their display (user) name
	public static final String usr = JOptionPane.showInputDialog("Your desired UserName (letters and numbers only): ");

	//requests the user to enter the IP which they want to connect to
	public static final String address = JOptionPane.showInputDialog("The IP you wish to connect to: ");
}