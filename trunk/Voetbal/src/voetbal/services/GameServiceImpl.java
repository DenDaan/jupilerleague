package voetbal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import voetbal.Game;
import voetbal.dao.GameDAO;
import voetbal.dao.GameDAO;

@Service
public class GameServiceImpl implements GameService{

	private GameDAO gameDAO;
	
	@Autowired
	public GameServiceImpl(GameDAO gameDAO){
		this.gameDAO=gameDAO;
	}
	
	public List<Game> getGames(){
		return gameDAO.getGames();
	}
	public void setGameDAO(GameDAO gameDAO){
		this.gameDAO=gameDAO;
	}
	
	public GameDAO getGameDAO(){
		return gameDAO;
	}
}
