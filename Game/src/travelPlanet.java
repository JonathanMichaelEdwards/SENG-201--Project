import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class travelPlanet {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					travelPlanet window = new travelPlanet();
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
	public travelPlanet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 961, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTimeToTravel = new JLabel("Time to travel to a new location");
		lblTimeToTravel.setBounds(351, 54, 260, 40);
		frame.getContentPane().add(lblTimeToTravel);
		
		JLabel lblPleasePickTwo = new JLabel("Please pick two of your crew (they must both have 1 action)");
		lblPleasePickTwo.setBounds(351, 104, 330, 33);
		frame.getContentPane().add(lblPleasePickTwo);
		
		JButton btnLetsGetGoing = new JButton("Lets get going!");
		btnLetsGetGoing.setBounds(655, 508, 210, 56);
		frame.getContentPane().add(btnLetsGetGoing);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(398, 511, 213, 50);
		frame.getContentPane().add(btnBack);
	}
}
