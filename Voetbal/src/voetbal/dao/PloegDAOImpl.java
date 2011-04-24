package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import voetbal.Ploeg;

@Repository
public class PloegDAOImpl implements PloegDAO{
	
	public String ploegenQuery = "from Ploeg";
	
	EntityManager entityManager;
	
	private final String getPloegQuery = "from Ploeg where naam=?";
	
	@Autowired
	public PloegDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Ploeg> getPloegen() {
		return (List<Ploeg>) entityManager.createQuery(ploegenQuery).getResultList();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Ploeg getPloeg(String ploeg){
		Query query = entityManager.createQuery(getPloegQuery);
		query.setParameter(0, ploeg);
		return (Ploeg) query.getSingleResult();
	}
	
	public Ploeg getPloeg(int id){
		return entityManager.find(Ploeg.class,id);
	}

	public void setEntityManager(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	public EntityManager getEntityManager(){
		return entityManager;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(Ploeg ploeg) {
		entityManager.createQuery("insert into Ploeg(id, naam) values (ploeg.id, ploeg.naam)");
	}
}
