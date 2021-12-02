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
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class appPallina {

	private JFrame frmGravit;
	private int speed;
	private String[] hexColori = { "#FF0000","#FFFF00","#0000FF","#654321","#000000","#800080","#00FF00","#FF00FF"};
	private String[] arrColori = {"Rosso", "Giallo", "Blu", "Marrone", "Nero", "Viola", "Verde", "Rosa"};
	private String[] arrPianeti = {"Terra", "Luna", "Marte", "Giove"};
	private double[] arrGravita = {9.81, 1.62, 3.72, 24.79};
	private int gigio;
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
		
		JCheckBox Gravit = new JCheckBox("gravit\u00E0");
		Gravit.setBounds(536, 193, 97, 23);
		frmGravit.getContentPane().add(Gravit);
		
		JComboBox<String> cmbColore = new JComboBox<String>(arrColori);
		
		cmbColore.setBounds(539, 140, 140, 32);
		frmGravit.getContentPane().add(cmbColore);
		
		JLabel lblSelezionaIlColore = new JLabel("Seleziona il colore:");
		lblSelezionaIlColore.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelezionaIlColore.setBounds(539, 114, 140, 14);
		frmGravit.getContentPane().add(lblSelezionaIlColore);
		
		JLabel lblVelxPallina = new JLabel("Vel-X pallina : ");
		lblVelxPallina.setBounds(539, 40, 94, 20);
		frmGravit.getContentPane().add(lblVelxPallina);
		
		JLabel lblVelyPallina = new JLabel("Vel-Y pallina : ");
		lblVelyPallina.setBounds(539, 66, 94, 20);
		frmGravit.getContentPane().add(lblVelyPallina);
		
		JLabel ScVelX = new JLabel("");
		ScVelX.setBounds(633, 46, 46, 14);
		frmGravit.getContentPane().add(ScVelX);
		
		JLabel ScVelY = new JLabel("");
		ScVelY.setBounds(633, 66, 46, 14);
		frmGravit.getContentPane().add(ScVelY);
		
		JButton btnReset = new JButton("reset");
		btnReset.setBounds(633, 416, 89, 23);
		frmGravit.getContentPane().add(btnReset);
		
		JLabel PlayPausa = new JLabel("");
		
		panel.setGravity(9.81); //gravità iniziale ovvero la Terra
		
		PlayPausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(gigio == 0) {

					gigio = 1;
					panel.setPlay(true);
					
				PlayPausa.setIcon(new ImageIcon("src/pauseButton.png"));
				}else {
					gigio = 0;
					panel.setPlay(false);
					PlayPausa.setIcon(new ImageIcon("src/playButton.png"));
				}
				
			}
		});
		
		PlayPausa.setHorizontalAlignment(SwingConstants.CENTER);
		PlayPausa.setIcon(new ImageIcon("src/playButton.png"));
		PlayPausa.setBounds(543, 393, 72, 64);
		
		frmGravit.getContentPane().add(PlayPausa);
		
		JComboBox<String> cmbPianeti = new JComboBox<String>(arrPianeti);
		
		cmbPianeti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			panel.setGravity(arrGravita[cmbPianeti.getSelectedIndex()]);
			
			}
		});
		
		cmbPianeti.setBounds(539, 261, 143, 25);
		frmGravit.getContentPane().add(cmbPianeti);
		
		JLabel lblPianeti = new JLabel("Seleziona il pianeta:");
		lblPianeti.setBounds(539, 233, 140, 16);
		frmGravit.getContentPane().add(lblPianeti);
		
		btnReset.addActionListener(e->{
			panel.reset();
		});
		
		cmbColore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.getPalla().setColor(Color.decode(hexColori[cmbColore.getSelectedIndex()]));
				
			}
		});
		
		Gravit.addActionListener(e->{
					
			panel.setGravity( Gravit.isSelected());
					
		});
		
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				ScVelX.setText(panel.getPalla().getVelX()+"");
				ScVelY.setText(panel.getPalla().getVelY()+"");
				panel.repaint();
				
			}
		}, 1, 10);
	
		}
}
