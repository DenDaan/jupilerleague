package voetbal.dao;

import java.util.List;

import org.springframework.stereotype.Controller;

import voetbal.Game;
import voetbal.Ploeg;


public interface GameDAO {

	public List<Game> getGames();
	
}
