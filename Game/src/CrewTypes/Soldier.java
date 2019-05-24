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

public class Soldier 
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
		
		JLabel lblDesc = new JLabel("<html>Soldier: \r\n" + 
				"Who do you call to watch your back? The legendary Tediore Soldier, trained from birth after being handpicked for their aggression and absolute obedience. Each Tediore Soldier comes equipped with state of the art military gear found only on their training world <TOP SECRET>, picking a soldier as one of your crew gives far higher protection from space pirates. They will be headstrong and a machine of efficiency in your crew.</html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDesc.setBounds(626, 245, 711, 195);
		frmEliteDangerousBeta.getContentPane().add(lblDesc);
		
		JLabel lblSoldier = new JLabel("Soldier");
		lblSoldier.setForeground(Color.LIGHT_GRAY);
		lblSoldier.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoldier.setFont(new Font("Dialog", Font.BOLD, 26));
		lblSoldier.setBounds(650, 50, 600, 100);
		frmEliteDangerousBeta.getContentPane().add(lblSoldier);
		
		
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
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
