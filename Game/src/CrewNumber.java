import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;


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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(78, 235, 126, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("New check box");
		checkBox.setBounds(267, 235, 126, 23);
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("New check box");
		checkBox_1.setBounds(435, 235, 126, 23);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(610, 235, 126, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
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