package pallina;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Schermo extends JPanel{

	private Palla palla;

	private boolean enabled = false;
	private double gravita;
	private boolean play = false;
	
	public Schermo(int speed) {
		super();

		palla = new Palla(150, 250,Color.red, 30);
		this.setBackground(Color.white);
		palla.setVelX(100);
		palla.setVelY(0);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D	g2 = (Graphics2D)g;
		
		paintPalla(g2);

		if (play) { //se il pulsante play è stato premuto allora eseguo le istruzioni per muovere la pallina
			this.aggiornaPosizione(0.01);
			this.risolviCollisioni();
		}
	}
	
	public boolean isPlay() {
		return play;
	} 

	public void setPlay(boolean play) {
		this.play = play;
	}

	private void risolviCollisioni() {
				
		if(palla.getPosX()+palla.getRaggio() >= this.getWidth() || palla.getPosX()-palla.getRaggio() <= 0) 
			palla.setVelX(palla.getVelX()*-1);				
		
		if(palla.getPosY()+palla.getRaggio() >= this.getHeight() || palla.getPosY()-palla.getRaggio() <= 0) 
			palla.setVelY(palla.getVelY()*-1);

	}
	
	//disegno la palla
	private void paintPalla(Graphics2D g2) {
		int raggio = palla.getRaggio();
		int x = Palla.convertFloat( palla.getPosX() );
		int y = Palla.convertFloat(this.getHeight()-palla.getPosY());
		g2.setColor(palla.getColor());
		g2.fillOval(x-raggio, y-raggio, 2*raggio, 2*raggio);
		
	}
	
	
	//aggiorno la posizione della palla in seguito alla velocità
	public void aggiornaPosizione(double time){
		palla.setPosX((float) (palla.getPosX() + palla.getVelX()*time));
		palla.setPosY((float) (palla.getPosY() + palla.getVelY()*time));
		
		if(enabled) { //se la gravità è abilitata 
			palla.setVelY(palla.getVelY() - gravita);
		}
	}
	
	public void setGravity(double gravita) {
		this.gravita = gravita;
	}

	public Palla getPalla() {
		return palla;
	}

	public void setPalla(Palla p) {
		this.palla = p;
	}

	public void setGravity(boolean selected) {
		this.enabled = selected;	
	}

	public void reset() {
		Random r = new Random();
		palla.setPosX(this.getWidth()/2);
		palla.setPosY(this.getHeight()/2);
		palla.setVelY(0);
		palla.setVelX(r.nextFloat()*300);
		
	}
		
}