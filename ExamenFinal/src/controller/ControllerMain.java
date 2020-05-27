package controller;

import model.Logica;
import processing.core.PApplet;

public class ControllerMain {
	private PApplet app;
	private Logica logica;

	public ControllerMain(PApplet app) {
		this.app = app;

		logica = new Logica(app);
	}

	public void pintarController() {
		logica.pintarLogica();
	}
	
	public void mouse() {
		logica.mouseLogica();
	}
}
