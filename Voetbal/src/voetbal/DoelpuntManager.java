package voetbal;

public class DoelpuntManager {

	private static final DoelpuntManager instance = new DoelpuntManager();
	
	public static DoelpuntManager getInstance(){
		return instance;
	}
	
	private DoelpuntManager(){}
	
	public static void addAssist(Match match, Speler speler, int minuut){
		speler.addAssist(new Assist(match,minuut,speler));
	}
	
	public static void addDoelpunt(Match match, Speler scorer, Speler assister, int minuut){
		//TODO
		addAssist(match,assister,minuut);
	}
	
}
