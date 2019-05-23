package CrewTypes;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import SetUpScreens.CrewSelection;
import WindowSettings.Display;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mechanic 
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
		Display display = new Display(); 
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAbility = new JLabel("<html>Mechanic: \r\n" + 
				"ABILITY: Having a Mechanic on your ship means that asteroids have a 50% less chance of dealing damage to your ship </html>");
		lblAbility.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbility.setBounds(202, 150, 448, 109);
		frame.getContentPane().add(lblAbility);
		
		JLabel lblDesc = new JLabel("<html>Mechanic: \r\n" + 
				"Flying, driving, riding or controlling anything? The last thing you want is your equipment to let you down. These guys come straight off a huge industrial world Maliwan, with experience fixing and upgrading anything with an engine or a computer! Bringing one of these guys on board will mean you have a less chance of your spaceship and equipment getting damaged in your journey </html>");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesc.setBounds(69, 248, 711, 195);
		frame.getContentPane().add(lblDesc);

		JLabel lblMechanic = new JLabel("Mechanic");
		lblMechanic.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMechanic.setBounds(347, 51, 146, 109);
		frame.getContentPane().add(lblMechanic);
		
		
		// Go back button
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public Mechanic()
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
					Mechanic window = new Mechanic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
