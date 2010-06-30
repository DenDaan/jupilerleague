package voetbal;

import java.util.Date;
import java.util.List;

public class Speler {
	
	private String voornaam;
	private String naam;
	private String nationaliteit;
	private Date geboortejaar;
	
	private Ploeg ploeg;
	private List<Doelpunt> doelpunten;
	private List<Assist> assisten;
	
	public List<Kaart> kaarten;
	public boolean geschorst = false;
	
	public void addAssist(Assist assist){
		//TODO
	}
	public void addDoelpunt(Doelpunt doelpunt){
		//TODO
	}
	
}
