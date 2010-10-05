package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import voetbal.doelpunt.Doelpunt;

@Repository
public class DoelpuntDAOImpl implements DoelpuntDAO {

	private EntityManager entityManager;
	
	String getDoelpuntenQuery = "from Doelpunt";

	
	@Autowired
	public DoelpuntDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Doelpunt> getDoelpunten(){
		return entityManager.createQuery(getDoelpuntenQuery).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	public EntityManager getEntityManager(){
		return entityManager;
	}
}
