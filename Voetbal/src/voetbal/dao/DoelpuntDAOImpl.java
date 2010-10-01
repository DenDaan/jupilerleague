package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import voetbal.doelpunt.Doelpunt;

public class DoelpuntDAOImpl {

	String getDoelpuntenQuery = "from Doelpunt";

	private EntityManager entityManager;
	
	public DoelpuntDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public List<Doelpunt> getDoelpunten(){
		return entityManager.createQuery(getDoelpuntenQuery).getResultList();
	}
}
