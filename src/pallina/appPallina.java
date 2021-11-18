package pallina;

import java.awt.EventQueue;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class appPallina {

	private JFrame frame;
	private int speed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appPallina window = new appPallina();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public appPallina() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		speed = 60;
		Schermo panel = new Schermo(60);
		panel.setBounds(10, 11, 511, 446);
		frame.getContentPane().add(panel);
		
		Timer t = new Timer();
		
	
		
	}
}
