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

public class Pilot 
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
		
		JLabel lblDesc = new JLabel("<html>Pilot: \r\n" + 
				"The normal human body is 60% water, these pilots are 60% energy drink. These guys have trained all their lives in simulation for day long voyages piloting anything that can move in the most extreme conditions, you'll find these guys useful for planning any of your travels to new planets, and you can trust these pilots never to sleep. Although they dont want to, make them - the last thing you want is your pilot asleep when you really need him.</html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDesc.setBounds(629, 247, 711, 195);
		frmEliteDangerousBeta.getContentPane().add(lblDesc);
		
		JLabel lblPilot = new JLabel("Pilot");
		lblPilot.setForeground(Color.LIGHT_GRAY);
		lblPilot.setBackground(Color.LIGHT_GRAY);
		lblPilot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPilot.setFont(new Font("Dialog", Font.BOLD, 26));
		lblPilot.setBounds(650, 50, 600, 100);
		frmEliteDangerousBeta.getContentPane().add(lblPilot);
		
		
		//	Back Button
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public Pilot() {
		initialize();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pilot window = new Pilot();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
