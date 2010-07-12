package voetbal.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import voetbal.Ploeg;
import voetbal.speler.Speler;

public class PloegenManager {
	
private static final PloegenManager instance = new PloegenManager();
	
	public static PloegenManager getInstance(){
		return instance;
	}

	private List<Ploeg> ploegen = new ArrayList<Ploeg>();
	
	private PloegenManager(){}
//TODO: alles ploegenmanager
	
	public void addPloeg(Ploeg ploeg){
		ploegen.add(ploeg);
	}
	
	public List<Ploeg> getPloegen(){
		return ploegen;
	}
	
	public void setPloegen(List<Ploeg> ploegen){
		this.ploegen=ploegen;
	}
	
	public void removePloeg(Ploeg ploeg){
		ploegen.remove(ploeg);
		Iterator<Speler> it = ploeg.getSpelers().iterator();
		while(it.hasNext()){
			it.next().setPloeg(Ploeg.VRIJ);
		}
	}
}
