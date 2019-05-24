package CrewTypes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import SetUpScreens.CrewSelection;
import WindowSettings.Display;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Leader 
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
		// Setting Layout dimensions
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.setResizable(false);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		
		JLabel lblDesc = new JLabel("<html>Leader: \r\n" + 
				"Got a problem? These guys will break it down and solve it. Your crew needs someone to lead them when you are at the store. These leaders have been bred to work tirelessly throughout the day and night. They have made small biological advancements so they can eat anything that wont break their teeth. That means more 'real' food for the rest of the crew.</html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDesc.setBounds(614, 251, 711, 195);
		frmEliteDangerousBeta.getContentPane().add(lblDesc);
		
		JLabel lblLeader = new JLabel("Leader");
		lblLeader.setForeground(Color.LIGHT_GRAY);
		lblLeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeader.setFont(new Font("Dialog", Font.BOLD, 26));
		lblLeader.setBounds(650, 50, 600, 100);
		frmEliteDangerousBeta.getContentPane().add(lblLeader);
		
		
		// go back button
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public Leader() 
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
					Leader window = new Leader();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
