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

public class Thief 
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
		
		
		JLabel lblAbility = new JLabel("<html>Thief: \r\n" + 
				"ABILITY: Sending a thief on an exploration mission on the current planet rewards with a 50% higher chance of better loot. </html>");
		lblAbility.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbility.setBounds(202, 150, 448, 109);
		frame.getContentPane().add(lblAbility);
		
		JLabel lblDesc = new JLabel("<html>Thief: \r\n" + 
				"Grew up jacking cars, before long simple banks and museums got boring, we can source Thiefs hitting the most hidden, deadly and elusive treasures in the whole galaxy, if anything can be stolen, these guys will do it. They're pretty handy with weapons too, for when the heist gets a little loud. If there is a spaceship part on your current planet, sending these guys to search will almost guarantee the reward you're looking for. Be careful leaving your valuables around, the only loyalty the thieves have is to themselves </html>");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesc.setBounds(69, 248, 711, 195);
		frame.getContentPane().add(lblDesc);
		
		JLabel lblThief = new JLabel("Thief");
		lblThief.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblThief.setBounds(385, 25, 112, 151);
		frame.getContentPane().add(lblThief);
		
		
		// Back button 
		btnBack();
		
	}
	
	
	/*
	 * Create the application.
	*/
	public Thief() 
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
					Thief window = new Thief();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
