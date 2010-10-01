package voetbal.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import voetbal.Ploeg;
import voetbal.dao.PloegDAO;

@Service
public class PloegServiceImpl implements PloegService {

	PloegDAO ploegDAO;
	
	public PloegServiceImpl(PloegDAO ploegDAO){
		this.ploegDAO=ploegDAO;
	}
	
	@Override
	public List<Ploeg> getPloegen() {
		return ploegDAO.getPloegen();
	}

}
