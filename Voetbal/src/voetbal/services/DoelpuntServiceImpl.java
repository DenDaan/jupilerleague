package voetbal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import voetbal.dao.DoelpuntDAO;
import voetbal.doelpunt.Doelpunt;

@Service
public class DoelpuntServiceImpl implements DoelpuntService{
	
	private DoelpuntDAO doelpuntDAO;
	
	@Autowired
	public DoelpuntServiceImpl(DoelpuntDAO doelpuntDAO){
		this.doelpuntDAO = doelpuntDAO;
	}
	
	public List<Doelpunt> getDoelpunten(){
		return doelpuntDAO.getDoelpunten();
	}

	public void setDoelpuntDAO(DoelpuntDAO doelpuntDAO){
		this.doelpuntDAO=doelpuntDAO;
	}
	
	public DoelpuntDAO getDoelpuntDAO(){
		return doelpuntDAO;
	}
}
