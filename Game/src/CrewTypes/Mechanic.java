package CrewTypes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import SetUpScreens.CrewSelection;
import WindowSettings.Display;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Mechanic 
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
		Display display = new Display(); 
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.setResizable(false);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		
		JLabel lblDesc = new JLabel("<html>Mechanic: \r\n" + 
				"Flying, driving, riding or controlling anything? The last thing you want is your equipment to let you down. These guys come straight off a huge industrial world Maliwan, with experience fixing and upgrading anything with an engine or a computer! Bringing one of these guys on board will mean you have a less chance of your spaceship and equipment getting damaged in your journey, thats if they're sober enough </html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDesc.setBounds(612, 261, 711, 195);
		frmEliteDangerousBeta.getContentPane().add(lblDesc);

		JLabel lblMechanic = new JLabel("Mechanic");
		lblMechanic.setForeground(Color.LIGHT_GRAY);
		lblMechanic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMechanic.setFont(new Font("Dialog", Font.BOLD, 24));
		lblMechanic.setBounds(650, 50, 600, 100);
		frmEliteDangerousBeta.getContentPane().add(lblMechanic);
		
		
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
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
