import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CrewNumber 
{

	private JFrame frame;

	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		Settings set = new Settings();
		frame = new JFrame();
		frame.setBounds(set.x, set.y, 828, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How many Crew members do you want?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(141, 44, 595, 109);
		frame.getContentPane().add(lblNewLabel);
		
		JSlider slider = new JSlider();
		slider.setBounds(247, 209, 356, 68);
		frame.getContentPane().add(slider);
		
		JLabel lblCrewNumber = new JLabel("Crew number ...");
		lblCrewNumber.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCrewNumber.setBounds(351, 289, 166, 16);
		frame.getContentPane().add(lblCrewNumber);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(454, 380, 136, 75);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(663, 380, 136, 75);
		frame.getContentPane().add(btnNewButton);
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewNumber() 
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
					CrewNumber window = new CrewNumber();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}