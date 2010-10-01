package voetbal.manager;

import java.util.List;

import voetbal.Game;
import voetbal.doelpunt.Doelpunt;
import voetbal.doelpunt.util.DoelpuntManier;
import voetbal.speler.Speler;

public class DoelpuntManager implements Manager<Doelpunt>{

	private static final DoelpuntManager instance = new DoelpuntManager();
	
	public static DoelpuntManager getInstance(){
		return instance;
	}
	
	private DoelpuntManager(){}
	
	private static List<Doelpunt> doelpunten;
	
	public void add(Doelpunt doelpunt){
		doelpunt.getSpelerPunt().addDoelpunt(doelpunt);
		doelpunt.getSpelerAssist().addAssist(doelpunt);
		doelpunten.add(doelpunt);
	}

	@Override
	public List<Doelpunt> getAll() {
		return doelpunten;
	}
	@Override
	public void set(List<Doelpunt> doelpunten) {
		this.doelpunten = doelpunten;
		
	}

	@Override
	public void remove(Doelpunt doelpunt) {
		// TODO Alle verwijzingen moeten ook verwijderd worden!!!
		doelpunten.remove(doelpunt);
	}
	
}
