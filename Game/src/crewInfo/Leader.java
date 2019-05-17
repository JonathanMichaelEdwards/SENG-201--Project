package crewInfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;

public class Leader {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leader window = new Leader();
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
	public Leader() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAbility = new JLabel("<html>Leader: \r\n" + 
				"ABILITY: The leader never gets hungry </html>");
		lblAbility.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbility.setBounds(202, 150, 448, 109);
		frame.getContentPane().add(lblAbility);
		
		
		JLabel lblDesc = new JLabel("<html>Leader: \r\n" + 
				"Got a problem? These guys will break it down and solve it. Your crew needs someone to lead them when you are at the store. These leaders have been bred to work tirelessly throughout the day and night. They have made small biological advancements so they never need food. That means more food for the rest of the crew.</html>");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesc.setBounds(69, 248, 711, 195);
		frame.getContentPane().add(lblDesc);
		

		
		JButton btnBackToCrew = new JButton("Back to Crew Selection");
		btnBackToCrew.setBounds(681, 432, 171, 49);
		frame.getContentPane().add(btnBackToCrew);
		
		JLabel lblLeader = new JLabel("Leader");
		lblLeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLeader.setBounds(333, 45, 180, 88);
		frame.getContentPane().add(lblLeader);
	}
}
