package RepairShields;

//Library imports
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import IOFile.IOFile;
import MainScreen.MainScreen;
//Self implemented
import WindowSettings.Display;


public class CrewRepair {

	public JFrame frame;

	
	private void btnRepair()
	{
		JButton btnSearchPlanet = new JButton("Repair");
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IOFile ioFile = new IOFile();
				
				ArrayList<String> changeShields = ioFile.fileRead("StoreGame/ShipInfo.txt");
				int repair = Integer.parseInt(changeShields.get(2)) + 10;
				
				changeShields.set(2, "" + repair);
				ioFile.fileWrite(changeShields, "StoreGame/ShipInfo.txt");  // Writing in new days
				
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		btnSearchPlanet.setBounds(502, 539, 197, 97);
		frame.getContentPane().add(btnSearchPlanet);
	}
	
	
	// back button
	private void btnBack()
	{
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		btnBack.setBounds(171, 475, 197, 97);
		frame.getContentPane().add(btnBack);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() {
		// Setting Layout dimensions
		frame = new JFrame();
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
		
		
		// Button actions
		btnRepair();
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewRepair() {
		initialize();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewRepair window = new CrewRepair();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
