package model;

import java.lang.Thread.State;
import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private String[] text; 
	private LinkedList<Figura> figuraList;
	boolean ordenF;
	private FiguraTam ordenFT;
	

	public Logica(PApplet app) {
		this.app = app;
		
		ordenFT = new FiguraTam();
		
		text = app.loadStrings("../1.txt");
		figuraList = new LinkedList<Figura>();
		
		for(int i = 0; i < text.length; i++) {
			String[] figurastxt = text[i].split(":");
			int tam = Integer.parseInt(figurastxt[1]);
			float posX = app.random(50, 450);
			float posY = app.random(50,450);
			
			
			figuraList.add(new Figura(figurastxt[0], tam, posX, posY, app));
						
		System.out.println(text[i]);
		}
		
	}
	
	public void pintarLogica() {
		
		for(int i = 0; i < figuraList.size(); i ++) {
			Figura figTemp = figuraList.get(i);
			if (figTemp.getState() == State.NEW) {
				figTemp.start();
				//System.out.println("holaa");
			}else {
				figTemp.pintarFig();
			}
		}
		
	}
	
	public void mouseLogica() {
		
			
		figuraList.add(new Figura("Cuadrado", (int)app.random(50, 100), app.mouseX, app.mouseY, app));
	}
	
	public void accionTeclado() {

		if (ordenF == true) {
			if (app.key == 'p' || app.key == 'P') {
				Collections.sort(figuraList, ordenFT);
			}
			if (app.key == 'c' || app.key == 'C') {
				// ordenamiento color
			}
		}
	}
}
