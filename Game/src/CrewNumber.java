import java.awt.EventQueue;
import javax.swing.JFrame;



public class CrewNumber {

	private JFrame frame;

	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewNumber() {
		Settings setting = new Settings();
		initialize();
		System.out.println(setting.distance());
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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