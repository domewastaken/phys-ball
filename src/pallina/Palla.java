package pallina;

import java.awt.Color;

public class Palla {
	private float posX,posY;
	
	private double velX,velY;
	private int raggio;
	private Color c;
	


	public Palla(float posX, float posY, Color c, int raggio) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.c = c;
		this.raggio = raggio;
	}
	

	public int getRaggio() {
		return raggio;
	}

	public void setRaggio(int raggio) {
		this.raggio = raggio;
	}

	public float getPosX() {
		return posX;
	}


	public void setPosX(float posX) {
		this.posX = posX;
	}


	public float getPosY() {
		return posY;
	}


	public void setPosY(float posY) {
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
	
	public static int convertFloat(float f) {
		int intero = (int)f; //memorizzo la parte intera di f
		
		if(f - intero <0.5) // calcolo la parte decimale e vedo se è minore della metà
			return intero; // arrotondo per difetto
		else
			return intero+1; // arrotondo per eccesso
	}
}
