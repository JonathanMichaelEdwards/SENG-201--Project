package CrewTypes;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import SetUpScreens.CrewSelection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Medic {

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
		frame.setBounds(100, 100, 924, 681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblAbility = new JLabel("<html>Medic: \r\n" + 
				"ABILITY: Having a Medic on your ship means that the space plague has a 50% less chance of infecting your ship (does not stack) </html>");
		lblAbility.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbility.setBounds(202, 150, 448, 109);
		frame.getContentPane().add(lblAbility);
		
		JLabel lblDesc = new JLabel("<html>Medic: \r\n" + 
				"Straight out of the Galactic Medical Force, these medics take salary to respond anywhere in the galaxy to anyone in need of assistance. However you have the option to pick up a Medic-for-Hire, taking your currency and giving their expertise. These Medics come pre equipped to handle almost any medical emergency, and we can guarantee that the recently returned space plague will have a tough time getting to your crew!</html>");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesc.setBounds(69, 248, 711, 195);
		frame.getContentPane().add(lblDesc);

		JLabel lblMedic = new JLabel("Medic");
		lblMedic.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMedic.setBounds(347, 51, 146, 109);
		frame.getContentPane().add(lblMedic);
		
		
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
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
