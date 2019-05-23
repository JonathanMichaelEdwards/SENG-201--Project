package RandomEvents;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

import WindowSettings.Display;
import javax.swing.JLabel;

import IOFile.IOFile;
import MainScreen.MainScreen;
import MainScreen.loseGame;

//import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;

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
				
				ArrayList<String> changeShields = ioFile.fileRead("src/StoreGame/ShipInfo.txt");

				Integer explosion;
				
				
				int dmg = Integer.parseInt(changeShields.get(2)) - 30; //this is the value in which a repair heals
				changeShields.set(2, "" + dmg);
				ioFile.fileWrite(changeShields, "src/StoreGame/ShipInfo.txt");
				ArrayList<String> checkShields = ioFile.fileRead("src/StoreGame/ShipInfo.txt");				
//				explosion = Integer.parseInt(checkShields.get(2));
				
				if (dmg <= 0)
				{

					loseGame outpost = new loseGame();
					outpost.frame.setVisible(true);
					frame.setVisible(false);
				}
				
				if (dmg > 0)
				{
					MainScreen screen = new MainScreen();
					screen.frame.setVisible(true);    // turn on screen
					frame.setVisible(false);   
				}// turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		
		
		
	
		btnSearchPlanet.setBounds(940, 700, 250, 100);
		frame.getContentPane().add(btnSearchPlanet);
	}

	
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
		lblFdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblFdf.setFont(new Font("Dialog", Font.BOLD, 19));
		lblFdf.setBounds(500, 297, 905, 294);
		frame.getContentPane().add(lblFdf);
		
		JLabel lblAsteroids = new JLabel("ASTEROIDS!");
		lblAsteroids.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsteroids.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAsteroids.setBounds(650, 50, 600, 100);
		frame.getContentPane().add(lblAsteroids);
		btnBack();
	}
}
