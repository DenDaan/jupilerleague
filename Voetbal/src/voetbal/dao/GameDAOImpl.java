package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import voetbal.Game;
import voetbal.Ploeg;

@Controller
public class GameDAOImpl implements GameDAO {

	private EntityManager entityManager;

	private String getGamesQuery = "from Game";

	@Autowired
	public GameDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Game> getGames() {
		return entityManager.createQuery(getGamesQuery).getResultList();
	}
}
