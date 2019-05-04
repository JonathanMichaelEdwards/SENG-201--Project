import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class NameShip {

	private JFrame frame;
	private JTextField textField;

	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crew:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel.setBounds(40, 126, 81, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNameYourShip = new JLabel("Name Your ship");
		lblNameYourShip.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNameYourShip.setBounds(298, 12, 253, 107);
		frame.getContentPane().add(lblNameYourShip);
		
		textField = new JTextField();
		textField.setBounds(560, 244, 186, 68);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblShipType = new JLabel("Ship Type");
		lblShipType.setFont(new Font("Dialog", Font.BOLD, 19));
		lblShipType.setBounds(298, 126, 125, 94);
		frame.getContentPane().add(lblShipType);
		
		JLabel lblNameShip = new JLabel("Name Ship");
		lblNameShip.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNameShip.setBounds(560, 126, 134, 94);
		frame.getContentPane().add(lblNameShip);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(504, 374, 125, 77);
		frame.getContentPane().add(btnBack);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(672, 374, 125, 77);
		frame.getContentPane().add(btnStart);
	}
	
	
	/*
	 * Create the application.
	*/
	public NameShip() 
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
					NameShip window = new NameShip();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
