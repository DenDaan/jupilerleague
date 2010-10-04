package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import voetbal.doelpunt.Doelpunt;

@Repository
public class DoelpuntDAOImpl implements DoelpuntDAO {

	String getDoelpuntenQuery = "from Doelpunt";

	private EntityManager entityManager;
	
	@Autowired
	public DoelpuntDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Doelpunt> getDoelpunten(){
		return entityManager.createQuery(getDoelpuntenQuery).getResultList();
	}
}
