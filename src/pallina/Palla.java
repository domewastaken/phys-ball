package pallina;

import java.awt.Color;

public class Palla {
	private int posX,posY;
	
	private double velX,velY;
	private int raggio;
	private Color c;


	public Palla(int posX, int posY, Color c, int raggio) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.c = c;
		this.raggio = raggio;
	}
	
	public void updatePosition(double time){
		posX +=velX*time;
		posY +=velY*time;
		
		velY -= 0.25;

	}

	public int getRaggio() {
		return raggio;
	}

	public void setRaggio(int raggio) {
		this.raggio = raggio;
	}

	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public double getVelX() {
		return velX;
	}


	public void setVelX(double velX) {
		this.velX = velX;
	}


	public double getVelY() {
		return velY;
	}


	public void setVelY(double velY) {
		this.velY = velY;
	}


	public Color getColor() {
		return c;
	}


	public void setColor(Color c) {
		this.c = c;
	}
	
}
