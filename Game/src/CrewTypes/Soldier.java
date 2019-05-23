package CrewTypes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import SetUpScreens.CrewSelection;
import WindowSettings.Display;

public class Soldier 
{

	public JFrame frame;

	
	private void btnBack()
	{
		JButton btnBackToCrew = new JButton("Back to Crew Selection");
		btnBackToCrew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				CrewSelection select = new CrewSelection();
				select.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		btnBackToCrew.setBounds(681, 432, 171, 49);
		frame.getContentPane().add(btnBackToCrew);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		frame = new JFrame();
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
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
		
		JLabel lblSoldier = new JLabel("Soldier");
		lblSoldier.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSoldier.setBounds(385, 25, 112, 151);
		frame.getContentPane().add(lblSoldier);
		
		
		// Back button
		btnBack();
	}

	
	/*
	 * Create the application.
	*/
	public Soldier() 
	{
		initialize();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					Soldier window = new Soldier();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
