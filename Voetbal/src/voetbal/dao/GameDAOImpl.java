package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import voetbal.Game;

@Repository
public class GameDAOImpl implements GameDAO {

	private EntityManager entityManager;

	private String getGamesQuery = "from Game";

	@Autowired
	public GameDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Game> getGames() {
		return entityManager.createQuery(getGamesQuery).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager(){
		return entityManager;
	}
}
