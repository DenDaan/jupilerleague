package voetbal.manager;

import java.util.Map;
import java.util.TreeMap;

import voetbal.Game;

public class GameManager {

	private static final GameManager instance = new GameManager();
	
	public GameManager getInstance(){
		return instance;
	}
	
	private GameManager(){}
	
	private Map<Integer,Game> games = new TreeMap<Integer,Game>();
	
	
	
	public void addGame(int speeldag, Game game){
		games.put(speeldag, game);
		}
	
	public Map<Integer,Game> getGames(){
		return games;
	}
	
	public void setGames(Map<Integer,Game> games){
		this.games=games;
	}
}
