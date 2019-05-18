package SearchPlanet;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import MainScreen.MainScreen;
import WindowSettings.Display;


public class CrewPlanet {

	public JFrame frame;

	
	private void btnSearch()
	{
		JButton btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ExplorePlanet screen = new ExplorePlanet();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		btnSearchPlanet.setBounds(320, 440, 285, 173);
		frame.getContentPane().add(btnSearchPlanet);
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
		frame.getContentPane().setLayout(null);
		
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
//		frame.setResizable(false);
		
		
		// forward Button
		btnSearch();
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewPlanet() {
		initialize();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewPlanet window = new CrewPlanet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
