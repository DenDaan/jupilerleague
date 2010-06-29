
public class DoelpuntManager {

	private static final instance = new DoelpuntManager();
	
	public static void getInstance(){
		return instance;
	}
	
	private DoelpuntManager(){}
	
	public static void addAssist(Match match, Speler speler, Minuut minuut){
		//TODO
	}
	
	public static void addDoelpunt(Match match, Speler scorer, Speler assister, Minuut minuut){
		//TODO
		addAssist(match,assister,minuut);
	}
	
}
