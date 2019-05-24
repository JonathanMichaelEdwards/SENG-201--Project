package NewPlanet;

// Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// Self implemented
import MainScreen.MainScreen;
import WindowSettings.Display;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

import IOFile.IOFile;


public class TravelPlanet 
{
	public JFrame frmEliteDangerousBeta;
	private final JLabel lblLookAtThis = new JLabel("Welcome to the next planet on your journey!");


	private void btnBack()
	{
		JButton btnLetsGetGoing = new JButton("Back to Base");
		btnLetsGetGoing.setBackground(new Color(163, 184, 204));
		btnLetsGetGoing.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen screen = new MainScreen();
				screen.frmEliteDangerousBeta.setVisible(true);    // turn on screen
				frmEliteDangerousBeta.setVisible(false);          // turn off screen
			}
		});
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		btnLetsGetGoing.setBounds(940, 700, 250, 100);
		btnLetsGetGoing.setOpaque(true);
		frmEliteDangerousBeta.getContentPane().add(btnLetsGetGoing);
		lblLookAtThis.setForeground(Color.WHITE);
		lblLookAtThis.setBackground(Color.DARK_GRAY);
		lblLookAtThis.setOpaque(true);
		lblLookAtThis.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLookAtThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblLookAtThis.setBounds(650, 50, 600, 100);
		frmEliteDangerousBeta.getContentPane().add(lblLookAtThis);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TravelPlanet.class.getResource("/gameImages/HyperSpace.png")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		frmEliteDangerousBeta.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 0, 1920, 1080);
		frmEliteDangerousBeta.getContentPane().add(lblNewLabel_1);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		// Setting Layout dimensions
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		frmEliteDangerousBeta.setResizable(false);
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
		IOFile ioFile = new IOFile();
		
		ArrayList<String> updatePlanet = ioFile.fileRead("src/StoreGame/ShipInfo.txt");
		int planetCount = Integer.parseInt(updatePlanet.get(4)) + 1; //this is the value in which a repair heals
		updatePlanet.set(4, "" + planetCount);
		ioFile.fileWrite(updatePlanet, "src/StoreGame/ShipInfo.txt");
		
		// Back button
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public TravelPlanet() 
	{
		initialize();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TravelPlanet window = new TravelPlanet();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
