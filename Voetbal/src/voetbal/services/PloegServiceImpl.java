package voetbal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import voetbal.Ploeg;
import voetbal.dao.PloegDAO;
import voetbal.dao.PloegDAO;

@Service
public class PloegServiceImpl implements PloegService {

	PloegDAO ploegDAO;
	
	@Autowired
	public PloegServiceImpl(PloegDAO ploegDAO){
		this.ploegDAO=ploegDAO;
	}
	
	@Override
	public List<Ploeg> getPloegen() {
		return ploegDAO.getPloegen();
	}
	
	public void setPloegDAO(PloegDAO ploegDAO){
		this.ploegDAO=ploegDAO;
	}
	
	public PloegDAO getPloegDAO(){
		return ploegDAO;
	}

	@Override
	public void add(Ploeg ploeg) {
		ploegDAO.add(ploeg);
		
	}

}
