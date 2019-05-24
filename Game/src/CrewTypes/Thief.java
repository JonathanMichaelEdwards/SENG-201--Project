package CrewTypes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import SetUpScreens.CrewSelection;
import WindowSettings.Display;
import javax.swing.SwingConstants;

public class Thief 
{
	public JFrame frmEliteDangerousBeta;

	private void btnBack()
	{
		JButton btnBackToCrew = new JButton("Back to Crew Selection");
		btnBackToCrew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				CrewSelection select = new CrewSelection();
				select.frmEliteDangerousBeta.setVisible(true);    // turn on screen
				frmEliteDangerousBeta.setVisible(false);          // turn off screen
			}
		});
		btnBackToCrew.setBounds(940, 700, 250, 100);
		frmEliteDangerousBeta.getContentPane().add(btnBackToCrew);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		lblNewLabel.setOpaque(true);
		frmEliteDangerousBeta.getContentPane().add(lblNewLabel);
	}
	

	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.setResizable(false);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		
		JLabel lblDesc = new JLabel("<html>Thief: \r\n" + 
				"Grew up jacking cars, before long simple banks and museums got boring, we can source Thiefs hitting the most hidden, deadly and elusive treasures in the whole galaxy, if anything can be stolen, these guys will do it. They're pretty handy with weapons too, for when the heist gets a little loud. If there is a spaceship part on your current planet, sending these guys to search will almost guarantee the reward you're looking for. Be careful leaving your valuables around, the only loyalty the thieves have is to themselves </html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDesc.setBounds(616, 245, 711, 195);
		frmEliteDangerousBeta.getContentPane().add(lblDesc);
		
		JLabel lblThief = new JLabel("Thief");
		lblThief.setForeground(Color.LIGHT_GRAY);
		lblThief.setHorizontalAlignment(SwingConstants.CENTER);
		lblThief.setFont(new Font("Dialog", Font.BOLD, 24));
		lblThief.setBounds(650, 50, 600, 100);
		frmEliteDangerousBeta.getContentPane().add(lblThief);
		
		
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
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
