package NewPlanet;

// Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Self implemented
import MainScreen.MainScreen;
import WindowSettings.Display;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class TravelPlanet 
{
	public JFrame frame;
	private final JLabel lblLookAtThis = new JLabel("Welcome to the next planet on your journey!");


	private void btnBack()
	{
		JButton btnLetsGetGoing = new JButton("Back to Base");
		btnLetsGetGoing.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		btnLetsGetGoing.setBounds(940, 700, 250, 100);
		frame.getContentPane().add(btnLetsGetGoing);
		lblLookAtThis.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLookAtThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblLookAtThis.setBounds(650, 50, 600, 100);
		frame.getContentPane().add(lblLookAtThis);
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
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
		
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
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
