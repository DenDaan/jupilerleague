package voetbal.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import voetbal.Ploeg;
import voetbal.services.*;
import voetbal.speler.Speler;

@Controller
public class PloegenManager implements Manager<Ploeg> {

	PloegService ploegService;

	private List<Ploeg> ploegen;

	@Autowired
	public PloegenManager(PloegService ploegService) {
		this.ploegService = ploegService;
		 ploegen = ploegService.getPloegen();
	}

	public void add(Ploeg ploeg) {
		ploegen.add(ploeg);
		ploegService.add(ploeg);
	}

	public List<Ploeg> getAll() {
		return ploegen;
//		return ploegService.getPloegen();
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
	
	public void setPloegService(PloegService ploegService){
		this.ploegService = ploegService;
	}
	
	public PloegService getPloegService(){
		return ploegService;
	}
}
