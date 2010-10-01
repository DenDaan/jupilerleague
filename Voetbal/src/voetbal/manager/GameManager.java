package voetbal.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import voetbal.Game;

public class GameManager implements Manager<Game>{

	private static final GameManager instance = new GameManager();
	
	public GameManager getInstance(){
		return instance;
	}
	
	private GameManager(){}
	
	private List<Game> games = new ArrayList<Game>();
	
	
	
	public void add(Game game){
		games.add(game);
		}
	
	public List<Game> getAll(){
		return games;
	}
	
	public void set(List<Game> games){
		this.games=games;
	}

	@Override
	public void remove(Game game) {
		// TODO alle references moeten nog weg!!!
		games.remove(game);
	}
}
