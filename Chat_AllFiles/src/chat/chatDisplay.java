package chat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class chatDisplay extends Frame implements ActionListener, WindowListener{
	
	private static final long serialVersionUID = 1L;

	//create vatiables for the input, send button, quit button and message display
	JTextField input = new JTextField();
	
	Button send = new Button("send");
	
	Button quit = new Button("Exit");
	
	Button server = new Button("Convert to a server");
	
	Button client = new Button("Convert to a client");
	
	static JTextArea messageField = new JTextArea();
	
	protected void CreateWindow(){
		
		//create constraint variables (see below)
		double[] colWeight = {1,1,1,1,1,1};
		double[] rowWeight = {5,1,1,1,1};
		int[] colWidth = {1,1,1,1,1,1};
		int[] rowHeight = {5,1,1,1,1};
		
		//creates new GridBagLayout and the Constraints for it
		GridBagLayout normal = new GridBagLayout();
		
		GridBagConstraints constrain = new GridBagConstraints();
		
		normal.rowHeights = rowHeight;
		normal.columnWidths = colWidth;
		normal.columnWeights = colWeight;
		normal.rowWeights = rowWeight;
		
		setBounds(100,100,400,600);
		setLayout(normal);
		
		//create messagefield. set the Grid Layout for it.
		chatDisplay.messageField.setSize(300, 500);
		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.gridwidth = 5;
		constrain.gridheight = 18;
		constrain.fill = 1;
		constrain.gridx = 0;
		constrain.gridy = 0;
		normal.setConstraints(chatDisplay.messageField, constrain);
		
		//create input. set the Grid Layout for it.
		this.input.setSize(450, 20);
		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.gridwidth = 4;
		constrain.gridheight = 2;
		constrain.fill = 1;
		constrain.gridx = 0;
		constrain.gridy = 18;
		normal.setConstraints(this.input, constrain);
		
		//create send button. set the Grid Layout for it.
		this.send.setSize(50, 5);
		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.gridwidth = 1;
		constrain.gridheight = 1;
		constrain.fill = 1;
		constrain.gridx = 4;
		constrain.gridy = 18;
		normal.setConstraints(this.send, constrain);
		
		this.quit.setSize(50, 5);
		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.gridwidth = 1;
		constrain.gridheight = 1;
		constrain.fill = 1;
		constrain.gridx = 4;
		constrain.gridy = 19;
		normal.setConstraints(this.quit, constrain);
		
		this.server.setSize(50, 5);
		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.gridwidth = 1;
		constrain.gridheight = 1;
		constrain.fill = 1;
		constrain.gridx = 4;
		constrain.gridy = 20;
		normal.setConstraints(this.server, constrain);
		
		this.client.setSize(50, 5);
		constrain.weightx = 1;
		constrain.weighty = 1;
		constrain.gridwidth = 1;
		constrain.gridheight = 1;
		constrain.fill = 1;
		constrain.gridx = 4;
		constrain.gridy = 21;
		normal.setConstraints(this.client, constrain);
		
		//add the fields...
		add(this.input);
		add(chatDisplay.messageField);
		add(this.send);
		add(this.quit);
		add(this.server);
		add(this.client);
		
		//set windowlistener and set the window resizability to true
		addWindowListener(this);
		setResizable(true);
		
		//adds action listeners for use later on.
		input.addActionListener(this);
		send.addActionListener(this);
		quit.addActionListener(this);
		server.addActionListener(this);
		client.addActionListener(this);
		
		this.setVisible(true);
		
		run();
	}
	
	public void run(){
		Send.post("Starting your client...");
	}
	//adds action listener to see which buttons are pressed
	public void actionPerformed(ActionEvent e) throws NumberFormatException{
		Object object = e.getSource();
		
		if(object == send){
			if(input.getText() != ""){
				Send.post(input.getText());
				input.setText("");
			}
		}
		if(object == quit){
			System.exit(0);
		}
		if(object == server){
			Server.buildServer();
		}
		if(object == client){
			start.buildClient(Main.address, Main.usr);
		}
	}
	
	//stubs to satisfy windowListener.
	public void windowClosed(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e) {}
}