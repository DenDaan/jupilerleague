package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import voetbal.Team;

@Repository
public class TeamDAOImpl implements TeamDAO{
	
//	public String ploegenQuery = "from Ploeg";
	public String teamsQuery = "from Team";
	
	EntityManager entityManager;
	
//	private final String getPloegQuery = "from Ploeg where naam=?";
	private final String getTeamQuery = "from team where name=?";
	
	@Autowired
	public TeamDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Team> getTeams() {
		return (List<Team>) entityManager.createQuery(teamsQuery).getResultList();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Team getTeam(String team){
		Query query = entityManager.createQuery(getTeamQuery);
		query.setParameter(0, team);
		return (Team) query.getSingleResult();
	}
	
	public Team getTeam(int id){
		return entityManager.find(Team.class,id);
	}

	public void setEntityManager(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	public EntityManager getEntityManager(){
		return entityManager;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(Team team) {
//		entityManager.createQuery("insert into Ploeg(id, naam) values (ploeg.id, ploeg.naam)");
		entityManager.createQuery("insert into Team(id, name) values (team.id, team.name)");
	}
}
