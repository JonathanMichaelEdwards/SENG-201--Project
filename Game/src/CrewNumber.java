import java.awt.EventQueue;
import javax.swing.JFrame;


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
		frame.setBounds(set.x, set.y, set.width, set.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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