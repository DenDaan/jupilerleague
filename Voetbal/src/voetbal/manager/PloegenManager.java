package voetbal.manager;

public class PloegenManager {
	
private static final PloegenManager instance = new PloegenManager();
	
	public static PloegenManager getInstance(){
		return instance;
	}
	
	private PloegenManager(){}
//TODO: alles ploegenmanager
}
