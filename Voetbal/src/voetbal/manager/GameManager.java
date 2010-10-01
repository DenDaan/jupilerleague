package voetbal.manager;

import java.util.ArrayList;
import java.util.List;

import voetbal.Game;
import voetbal.services.GameService;

public class GameManager implements Manager<Game>{
	
	GameService gameService;
	
	private List<Game> games = gameService.getGames();

	private GameManager(GameService gameService){
		this.gameService = gameService;
	}
	
	
	
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
