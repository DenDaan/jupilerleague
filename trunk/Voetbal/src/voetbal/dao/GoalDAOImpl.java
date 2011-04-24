package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import voetbal.doelpunt.Goal;

@Repository
public class GoalDAOImpl implements GoalDAO {

	private EntityManager entityManager;
	
//	String getGoalsQuery = "from Doelpunt";
	String getGoalsQuery = "from Goal";
	
	@Autowired
	public GoalDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Goal> getGoals(){
		return entityManager.createQuery(getGoalsQuery).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	public EntityManager getEntityManager(){
		return entityManager;
	}
}
