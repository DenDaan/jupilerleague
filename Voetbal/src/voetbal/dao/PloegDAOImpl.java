package voetbal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import voetbal.Ploeg;

@Repository
public class PloegDAOImpl implements PloegDAO{
	
	public String ploegenQuery = "from Ploeg";
	
	EntityManager entityManager;
	
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

}
