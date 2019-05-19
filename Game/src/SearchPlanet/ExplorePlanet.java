package SearchPlanet;

//Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Self implemented
import MainScreen.MainScreen;
import WindowSettings.Display;


public class ExplorePlanet 
{
	public JFrame frame;

	
	private void btnBack()
	{
		JButton btnRecallToShip = new JButton("Re-call to ship");
		btnRecallToShip.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		btnRecallToShip.setBounds(444, 626, 193, 88);
		frame.getContentPane().add(btnRecallToShip);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		// Setting Layout dimensions
		frame = new JFrame();
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
		
		// Initialize displays
		JLabel lblXLaunchesDown = new JLabel("X launches down from the spaceship in the ships rider/glider/shuttle/teleporter.");
		lblXLaunchesDown.setBounds(41, 27, 787, 15);
		frame.getContentPane().add(lblXLaunchesDown);
		
		JLabel lblTheLandscapeIs = new JLabel("The landscape is dusty/murky/clear/mountainous and seems safe for the meantime");
		lblTheLandscapeIs.setBounds(41, 81, 787, 15);
		frame.getContentPane().add(lblTheLandscapeIs);
		
		JLabel lblHoweverThisSoon = new JLabel("However this soon changes when X hears the scratches/howl/rattle of the deadly thresher/goliath/spiderants closing in");
		lblHoweverThisSoon.setBounds(41, 128, 856, 15);
		frame.getContentPane().add(lblHoweverThisSoon);
		
		JButton btnFight = new JButton("Fight");
		btnFight.setBounds(41, 155, 114, 25);
		frame.getContentPane().add(btnFight);
		
		JButton btnBag = new JButton("Bag");
		btnBag.setBounds(200, 155, 114, 25);
		frame.getContentPane().add(btnBag);
		
		JButton btnCrew = new JButton("Crew");
		btnCrew.setBounds(41, 192, 114, 25);
		frame.getContentPane().add(btnCrew);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(200, 192, 114, 25);
		frame.getContentPane().add(btnRun);
		
		JLabel lblFightXDraws = new JLabel("Fight: X draws their reapeater/thumper/scattergun and fires away. Emerging victorious");
		lblFightXDraws.setBounds(41, 309, 787, 15);
		frame.getContentPane().add(lblFightXDraws);
		
		JLabel lblRunXHides = new JLabel("Run: X hides under/in the nearby bush/rock/tree. Emerging unscathed");
		lblRunXHides.setBounds(41, 344, 787, 15);
		frame.getContentPane().add(lblRunXHides);
		
		JLabel lblHavingLocatedThe = new JLabel("Having located the loot locker, X finds");
		lblHavingLocatedThe.setBounds(41, 433, 787, 15);
		frame.getContentPane().add(lblHavingLocatedThe);
		
		JLabel lblHeaapsOfStufff = new JLabel("HEAAPS OF STUFFF :)))))");
		lblHeaapsOfStufff.setBounds(205, 460, 465, 75);
		frame.getContentPane().add(lblHeaapsOfStufff);
		
		JLabel lblBagYou = new JLabel("Bag - You lost your only camo net/sentry/air support beacon in the trip down");
		lblBagYou.setBounds(41, 250, 787, 15);
		frame.getContentPane().add(lblBagYou);
		
		JLabel lblCrewYou = new JLabel("Crew - You have no backup, the rest of the crew is off world");
		lblCrewYou.setBounds(34, 535, 414, 64);
		frame.getContentPane().add(lblCrewYou);
		
		// Back button
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public ExplorePlanet() {
		initialize();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExplorePlanet window = new ExplorePlanet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
