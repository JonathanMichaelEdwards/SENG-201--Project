package crewInfo;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Soldier {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Soldier window = new Soldier();
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
	public Soldier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 990, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAbility = new JLabel("<html>Soldier: \r\n" + 
				"ABILITY: Picking one or more soldiers in your team means you have 50% less chance of being robbed by space pirates! (does not stack) </html>");
		lblAbility.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbility.setBounds(202, 150, 448, 109);
		frame.getContentPane().add(lblAbility);
		
		
		JLabel lblDesc = new JLabel("<html>Soldier: \r\n" + 
				"Who do you call to watch your back? The legendary Tediore Soldier, trained from birth after being handpicked for their aggression and absolute obedience. Each Tediore Soldier comes equipped with state of the art military gear found only on their training world <TOP SECRET>, picking a soldier as one of your crew gives far higher protection from space pirates. They will be headstrong and a machine of efficiency in your crew.</html>");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesc.setBounds(69, 248, 711, 195);
		frame.getContentPane().add(lblDesc);
		

		
		JButton btnBackToCrew = new JButton("Back to Crew Selection");
		btnBackToCrew.setBounds(681, 432, 171, 49);
		frame.getContentPane().add(btnBackToCrew);
		
		JLabel lblSoldier = new JLabel("Soldier");
		lblSoldier.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSoldier.setBounds(385, 25, 112, 151);
		frame.getContentPane().add(lblSoldier);
	}

}
