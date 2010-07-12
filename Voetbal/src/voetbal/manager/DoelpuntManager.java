package voetbal.manager;

import java.util.List;

import voetbal.Game;
import voetbal.doelpunt.Assist;
import voetbal.doelpunt.Doelpunt;
import voetbal.doelpunt.util.Manier;
import voetbal.speler.Speler;

public class DoelpuntManager {

	private static final DoelpuntManager instance = new DoelpuntManager();
	
	public static DoelpuntManager getInstance(){
		return instance;
	}
	
	private DoelpuntManager(){}
	
	private static List<Doelpunt> doelpunten;
	
	
	public static void addDoelpunt(Game match, Speler scorer, Speler assister, int minuut,Manier manier){
		Doelpunt temp = new Doelpunt(scorer,assister,minuut,match,manier);
		scorer.addDoelpunt(temp);
		//assister.addAssist(new Assist(match, minuut, assister));
		assister.addAssist(new Assist(temp));
		doelpunten.add(temp);
	}
	
	public static void addDoelpunt(Doelpunt doelpunt){
		doelpunt.getSpelerPunt().addDoelpunt(doelpunt);
		//doelpunt.getSpelerAssist().addAssist(new Assist(doelpunt.getGame(), doelpunt.getMinuut(), doelpunt.getSpelerAssist()));
		doelpunt.getSpelerAssist().addAssist(new Assist(doelpunt));
		doelpunten.add(doelpunt);
	}
	
}
