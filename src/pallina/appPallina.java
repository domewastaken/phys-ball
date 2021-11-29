package pallina;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appPallina {

	private JFrame frmGravit;
	private int speed;
	private JSlider Jspeedd;
	private JLabel veloci;
	private String[] hexColori = { "#FF0000","#FFFF00","#0000FF","#654321","#000000","#800080","#00FF00","#FF00FF"};
	private String[] arrColori = {"Rosso", "Giallo", "Blu", "Marrone", "Nero", "Viola", "Verde", "Rosa"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appPallina window = new appPallina();
					window.frmGravit.setVisible(true);
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
		
		frmGravit = new JFrame();
		frmGravit.setTitle("Gravit\u00E0");
		frmGravit.setBounds(100, 100, 749, 507);
		frmGravit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		speed = 1;
		frmGravit.getContentPane().setLayout(null);
		Schermo panel = new Schermo(speed);
		panel.setBounds(10, 11, 511, 446);
		frmGravit.getContentPane().add(panel);
	
		
		
		JLabel lblVelocit = new JLabel("Velocit\u00E0 : ");
		lblVelocit.setBounds(561, 80, 76, 20);
		lblVelocit.setHorizontalAlignment(SwingConstants.CENTER);
		lblVelocit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmGravit.getContentPane().add(lblVelocit);
		
		Jspeedd = new JSlider();
		Jspeedd.setBounds(523, 129, 200, 26);
		Jspeedd.setMaximum(10);
		Jspeedd.setMinimum(-10);
		frmGravit.getContentPane().add(Jspeedd);
		Jspeedd.setValue(speed);
		
		veloci = new JLabel("");
		veloci.setBounds(647, 83, 46, 14);
		frmGravit.getContentPane().add(veloci);
		veloci.setText(speed+"");
		
		JCheckBox Gravit = new JCheckBox("gravit\u00E0");
		Gravit.setBounds(543, 220, 97, 23);
		frmGravit.getContentPane().add(Gravit);
		
		JComboBox cmbColore = new JComboBox();

		
		cmbColore.setModel(new DefaultComboBoxModel(arrColori));
		
		cmbColore.setBounds(543, 317, 140, 32);
		frmGravit.getContentPane().add(cmbColore);
		
		JLabel lblSelezionaIlColore = new JLabel("Seleziona il colore");
		lblSelezionaIlColore.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelezionaIlColore.setBounds(543, 292, 140, 14);
		frmGravit.getContentPane().add(lblSelezionaIlColore);
	
		cmbColore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.getPalla().setColor(Color.decode(hexColori[cmbColore.getSelectedIndex()]));
				
			}
		});
		
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				veloci.setText(Jspeedd.getValue()+"");
				panel.akinaSpeed((int)Jspeedd.getValue());
				panel.repaint();
				
			}
		}, 1, 1);
	
		}
}
