package model;

import processing.core.PApplet;

public class Figura extends Thread implements Comparable<Figura>{

	private PApplet app;
	int tam;
	private float posX, posY, r, g, b;
	private String tipo;
	private int velX, velY;
	private boolean mover, vivo;
	

	public Figura(String tipo, int tam, float posX, float posY, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.tam = tam;

		r = app.random(0, 255);
		g = app.random(0, 255);
		b = app.random(0, 255);
		velocidad();
		mover = true;
		vivo = true;
		
			}
	
	@Override
	public int compareTo(Figura c) {
		//return r.compareTo(c.getR());
		return 0;
	}
	
	public void pintarFig() {
		if(tipo == "Cuadrado") {
			pintarCuadrado();
		}
		
		if(tipo == "Circulo") {
			pintarCirculo();
		}
	}
	
	public void cambio() {
		if(posX < 250) {
			tipo = "Cuadrado";
		}
		
		if(posX > 250) {
			tipo = "Circulo";
		}
		
	}

	public void pintarCuadrado() {
		app.rectMode(app.CENTER);
		app.fill(r, g, b);
		app.rect(posX, posY, tam, tam);

	}

	public void pintarCirculo() {
		app.ellipseMode(app.CENTER);
		app.fill(r, g, b);
		app.ellipse(posX, posY, tam, tam);

	}
	
	protected void velocidad() {

		int dirX = (int) app.random(0, 10);
		int dirY = (int) app.random(0, 10);

		velX = (dirX % 2 == 0) ? (int) app.random(-5, -1) : (int) app.random(1, 5);
		velY = (dirX % 2 == 0) ? (int) app.random(-5, -1) : (int) app.random(1, 5);
	}

	protected void moverFigura() {

		if (mover == true) {
			posX += velX;
			posY += velY;
		}

	}

	protected void rebotar() {

		if (posX + velX < 0 + tam / 2) {
			velX *= -1;
		}

		if (posX + velX > 500 - tam / 2) {
			velX *= -1;
		}

		if (posY + velY < 0 + tam / 2) {
			velY *= -1;
		}

		if (posY + velY > 500 - tam / 2) {
			velY *= -1;
		}
	}
	
	public void run() {
		while (vivo) {
			moverFigura();
			cambio();
			rebotar();
			//System.out.println(mover);
			try {
				Thread.sleep(33);

			} catch (Exception e) {
				System.out.println("Cambio de Figura");
			}
		}
	}
	
	
	

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
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

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	
}

	
