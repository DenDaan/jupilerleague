package voetbal.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import voetbal.doelpunt.*;
import voetbal.services.DoelpuntService;

@Controller
public class DoelpuntManager implements Manager<Doelpunt>{

	DoelpuntService doelpuntService;
	
	private List<Doelpunt> doelpunten;
	
	@Autowired
	public DoelpuntManager(DoelpuntService doelpuntService){
		this.doelpuntService = doelpuntService;
		doelpunten = doelpuntService.getDoelpunten();
	}
	
	
	public void add(Doelpunt doelpunt){
		doelpunt.getSpelerPunt().addDoelpunt(doelpunt);
		doelpunt.getSpelerAssist().addAssist(doelpunt);
		doelpunten.add(doelpunt);
	}

	@Override
	public List<Doelpunt> getAll() {
		return doelpunten;
	}
	@Override
	public void set(List<Doelpunt> doelpunten) {
		this.doelpunten = doelpunten;
		
	}

	@Override
	public void remove(Doelpunt doelpunt) {
		// TODO Alle verwijzingen moeten ook verwijderd worden!!!
		doelpunten.remove(doelpunt);
	}
	
	public void setDoelpuntService(DoelpuntService doelpuntService){
		this.doelpuntService = doelpuntService;
	}
	
	public DoelpuntService getDoelpuntService(){
		return doelpuntService;
	}
	
}
