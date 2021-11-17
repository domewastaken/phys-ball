package pallina;

import java.awt.Color;

public class Palla {
	private int posX,posY;
	private double velX,velY;
	private int arrotondito;
	private Color c;


	public Palla(int posX, int posY, Color c, int arrotondito) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.c = c;
		this.arrotondito = arrotondito;
	}
	
	public void updatePosition(double time){
		posX +=velX*time;
		posY +=velY*time;
		
	}

	public int getArrotondito() {
		return arrotondito;
	}

	public void setArrotondito(int arrotondito) {
		this.arrotondito = arrotondito;
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


	public Color getC() {
		return c;
	}


	public void setC(Color c) {
		this.c = c;
	}
	
}
