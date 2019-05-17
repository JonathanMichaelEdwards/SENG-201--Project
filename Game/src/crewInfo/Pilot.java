package crewInfo;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pilot {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pilot window = new Pilot();
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
	public Pilot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1017, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAbility = new JLabel("<html>Pilot: \r\n" + 
				"ABILITY: The pilot never gets tired! </html>");
		lblAbility.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbility.setBounds(202, 150, 448, 109);
		frame.getContentPane().add(lblAbility);
		
		
		JLabel lblDesc = new JLabel("<html>Pilot: \r\n" + 
				"The normal human body is 60% water, these pilots are 60% energy drink. These guys have trained all their lives in simulation for day long voyages piloting anything that can move in the most extreme conditions, you'll find these guys useful for planning any of your travels to new planets, and you can trust these pilots never to sleep. The pilot will never need to sleep, meaning he has 100% uptime to help the team and crew.</html>");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesc.setBounds(69, 248, 711, 195);
		frame.getContentPane().add(lblDesc);
		

		
		JButton btnBackToCrew = new JButton("Back to Crew Selection");
		btnBackToCrew.setBounds(681, 432, 171, 49);
		frame.getContentPane().add(btnBackToCrew);
		
		JLabel lblPilot = new JLabel("Pilot");
		lblPilot.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPilot.setBounds(385, 25, 112, 151);
		frame.getContentPane().add(lblPilot);
	}

}
