package pallina;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;

import javax.swing.JPanel;

public class Schermo extends JPanel{

	private Palla palla;
	private int s;
	public boolean enable;
	
	public Schermo(int speed) {
		super();
		s = speed;
		palla = new Palla(150, 250,Color.red, 30);
		this.setBackground(Color.white);
		palla.setVelX(1);
		palla.setVelY(1);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D	g2 = (Graphics2D)g;
		
		paintPalla(g2);
		int xVecchia = palla.getPosX();	// ;>
		int yVecchia = palla.getPosY(); // ;<
		
		palla.updatePosition((double)s);
		checkCollision(xVecchia,yVecchia);
	}
	
	private void checkCollision(int xv, int yv) {
				
		if(palla.getPosX()+palla.getRaggio() > this.getWidth() || palla.getPosX()-palla.getRaggio() < 0) {
			palla.setVelX(palla.getVelX()*-1);
			palla.setPosX(xv);
			palla.setPosY(yv);
			
			
		}
		
		if(palla.getPosY()+palla.getRaggio() > this.getHeight() || palla.getPosY()-palla.getRaggio() < 0) {
			palla.setVelY(palla.getVelY()*-1);
			palla.setPosX(xv);
			palla.setPosY(yv);
			
		}
		
		/*if(enable) {
			if(p.getPosY()>p.getRaggio() && p.getPosY()*-1<this.getHeight()-p.getRaggio())
				if(p.getPosY()>0)
					p.setVelY(p.getVelY()-1);
				if(p.getPosY()<0)
					p.setVelY(p.getVelY()+1);
		}
		*/
	}

	private void paintPalla(Graphics2D g2) {
		int raggio = palla.getRaggio();
		int x = palla.getPosX();
		int y = this.getHeight()-palla.getPosY();
		g2.setColor(palla.getColor());
		g2.fillOval(x-raggio, y-raggio, 2*raggio, 2*raggio);
		
	}
	
	public void akinaSpeed(int speed) {
		this.s=speed;
		
	}

	public Palla getPalla() {
		return palla;
	}

	public void setPalla(Palla p) {
		this.palla = p;
	}
		
}