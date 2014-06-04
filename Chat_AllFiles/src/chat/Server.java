package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Server{
	
	public static <ClientThread> void buildServer() {
		//requests the user to input the port to which clients should connect
		String portString = JOptionPane.showInputDialog("Which port would you like the server to run on?");
		//converts the port from a string to an int
		int port = Integer.parseInt(portString);
		//sets the running boolean to true
		boolean running = true;
		//declares a list of connections/threads
		ArrayList<ClientThread> tl = new ArrayList<ClientThread>();
		
		try{
			ServerSocket connection = new ServerSocket(port);
			
			//loop while waiting for connections
			while(running){
				//accepts incoming connections
				Socket socket = connection.accept();
				if(!running){
					break;
				}
				//creates a client  Thread called thread
				ClientThread thread = new ClientThread(socket);
				//adds this thread to the list
				tl.add(thread);
				thread.start();
			}
			//getting to this code means that the while loop has been broker (quit)
			try{
				connection.close();
				for(int i = 0; i < tl.size(); ++i){
					ClientThread tc = tl.get(i);
					try{
						tc.sInput.close();
						tc.sOutPut.close();
						tc.socket.close();
					}
					catch(IOException ioE){
						//stub. nothing that can be done about it.
					}
				}
			}
			Socket socket = connection.accept();
			System.out.print("Someone has connected!");
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			System.out.print("You've connected to the server!");
		}
		catch(Exception e){
			System.out.print("An Error has occured with the connection D:");
		}
	}
}
