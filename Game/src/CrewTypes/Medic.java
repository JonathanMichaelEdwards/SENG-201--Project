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

public class Medic {

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
		
		JLabel lblDesc = new JLabel("<html>Medic: \r\n" + 
				"Straight out of the Galactic Medical Force, these medics take salary to respond anywhere in the galaxy to anyone in need of assistance. However you have the option to pick up a Medic-for-Hire, taking your currency and giving their expertise. These Medics come pre equipped to handle almost any medical emergency, and we can guarantee that the recently returned space plague will have a tough time getting to your crew!</html>");
		lblDesc.setForeground(Color.LIGHT_GRAY);
		lblDesc.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDesc.setBounds(638, 247, 711, 195);
		frmEliteDangerousBeta.getContentPane().add(lblDesc);

		JLabel lblMedic = new JLabel("Medic");
		lblMedic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedic.setForeground(Color.LIGHT_GRAY);
		lblMedic.setFont(new Font("Dialog", Font.BOLD, 24));
		lblMedic.setBounds(650, 50, 600, 100);
		frmEliteDangerousBeta.getContentPane().add(lblMedic);
		
		
		// Back button
		btnBack();
	}


	/*
	 * Create the application.
	*/
	public Medic() 
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
					Medic window = new Medic();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
