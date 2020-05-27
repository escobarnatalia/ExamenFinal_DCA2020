package model;

import java.util.Comparator;

public class FiguraTam implements Comparator<Figura> {

	@Override
	public int compare(Figura tam1, Figura tam2) {
		return tam1.getTam() - (tam2.getTam());
		
	}

}
