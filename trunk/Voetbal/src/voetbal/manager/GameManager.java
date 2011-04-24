package voetbal.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import voetbal.Game;
import voetbal.services.GameService;

@Controller
public class GameManager implements Manager<Game>{
	
	GameService gameService;
	
	private List<Game> games;

	@Autowired
	private GameManager(GameService gameService){
		this.gameService = gameService;
		games = gameService.getGames();
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
	
	public void setGameService(GameService gameService){
		this.gameService=gameService;
	}
	
	public GameService getGameService(){
		return gameService;
	}
}
