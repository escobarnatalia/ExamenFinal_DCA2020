package view;

import controller.ControllerMain;
import processing.core.PApplet;

public class Main extends PApplet {
	ControllerMain controller;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	
	public void settings() {
		size(500,500);
		
	}
	public void setup() {
		
	controller = new ControllerMain(this);
		
	}
	public void draw() {
		background(0);
		controller.pintarController();
	}
	
	public void mouseClicked() {
		controller.mouse();
	}

}
