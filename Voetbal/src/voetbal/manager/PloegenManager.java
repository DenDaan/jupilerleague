package voetbal.manager;

import java.util.ArrayList;
import voetbal.dao.*;
import java.util.Iterator;
import java.util.List;

import voetbal.Ploeg;
import voetbal.services.*;
import voetbal.speler.Speler;

public class PloegenManager implements Manager<Ploeg> {

	// private static final PloegenManager instance = new PloegenManager();

	PloegService ploegService;

	// public static PloegenManager getInstance(){
	// return instance;
	// }
	//
	private List<Ploeg> ploegen = ploegService.getPloegen();

	public PloegenManager(PloegService ploegService) {
		this.ploegService = ploegService;
	}

	public void add(Ploeg ploeg) {
		ploegen.add(ploeg);
	}

	public List<Ploeg> getAll() {
		return ploegen;
	}

	public void set(List<Ploeg> ploegen) {
		this.ploegen = ploegen;
	}

	public void remove(Ploeg ploeg) {
		ploegen.remove(ploeg);
		Iterator<Speler> it = ploeg.getSpelers().iterator();
		while (it.hasNext()) {
			it.next().setPloeg(Ploeg.VRIJ);
		}
	}
}
