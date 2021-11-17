package pallina;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;

import javax.swing.JPanel;

public class Schermo extends JPanel{

	private Palla p;
	private int s;
	public Schermo(int speed) {
		super();
		s = speed;
		p = new Palla(300, 300,Color.red, 30);
		this.setBackground(Color.white);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D	g2 = (Graphics2D)g;
		
		paintPalla(g2);
		p.updatePosition((double)s);
	}

	private void paintPalla(Graphics2D g2) {
		int raggio = p.getArrotondito();
		int x = p.getPosX();
		int y = this.getHeight()-p.getPosY();
		g2.setColor(p.getC());
		g2.fillOval(x, y, 2*raggio, 2*raggio);
		
	
	}
	
	
	
	
	
	
}
