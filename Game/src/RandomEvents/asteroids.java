package RandomEvents;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

import WindowSettings.Display;
import javax.swing.JLabel;

import IOFile.IOFile;
import MainScreen.MainScreen;

//import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class asteroids {

	public JFrame frame;
	private void btnBack()
	{
		JButton btnSearchPlanet = new JButton("View Damage");
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IOFile ioFile = new IOFile();
				
				ArrayList<String> changeShields = ioFile.fileRead("StoreGame/ShipInfo.txt");
				int repair = Integer.parseInt(changeShields.get(2)) - 50; //this is the value in which a repair heals
				
				changeShields.set(2, "" + repair);
				ioFile.fileWrite(changeShields, "StoreGame/ShipInfo.txt");  // Writing in new days
				
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		
		
		
	
		btnSearchPlanet.setBounds(725, 580, 197, 97);
		frame.getContentPane().add(btnSearchPlanet);
	}
//	private void btnBack()
//	{
//		JButton btnLetsGetGoing = new JButton("Back to Base");
//		btnLetsGetGoing.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent e) 
//			{
//				MainScreen screen = new MainScreen();
//				screen.frame.setVisible(true);    // turn on screen
//				frame.setVisible(false);          // turn off screen
//			}
//		});
//		frame.getContentPane().setLayout(null);
//		btnLetsGetGoing.setBounds(655, 508, 210, 56);
//		frame.getContentPane().add(btnLetsGetGoing);
//	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asteroids window = new asteroids();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public asteroids() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		frame = new JFrame();
		Display display = new Display();
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFdf = new JLabel("<html>The shields have taken a hit from high speed asteroids we had no chance of detecting, let alone avoiding. See to it that the shields be repaired quickly, as too much damage will result in the ship exploding, killing our crew inside and ending the game!</html>");
		lblFdf.setFont(new Font("Dialog", Font.BOLD, 23));
		lblFdf.setBounds(201, 131, 905, 463);
		frame.getContentPane().add(lblFdf);
		
		JLabel lblAsteroids = new JLabel("ASTEROIDS!");
		lblAsteroids.setFont(new Font("Dialog", Font.BOLD, 39));
		lblAsteroids.setBounds(304, 37, 533, 82);
		frame.getContentPane().add(lblAsteroids);
		btnBack();
	}
}
