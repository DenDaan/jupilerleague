package voetbal;

import java.util.Date;
import java.util.List;

public class Speler {
	
	private String voornaam;
	private String familienaam;
	private String nationaliteit;
	private Date geboortejaar;
	
	private List<Ploeg> ploegen;
	private List<Doelpunt> doelpunten;
	private List<Assist> assisten;
	
	public List<Kaart> kaarten;
	public boolean geschorst = false;
	
	public String getVoornaam(){
		return voornaam;
	}
	
	public String getFamilienaam(){
		return familienaam;
	}
	
	public String getFullNaam(){
		return voornaam + " " + familienaam;
	}
	
	public String getFullNaam(boolean omgekeerd){
		return familienaam + " " + voornaam;
	}
	
	public String getNationaliteit(){
		return nationaliteit;
	}
	
	public Ploeg getPloeg(){
		return ploegen.get(ploegen.size()-1);
	}
	
	public void setPloeg(Ploeg ploeg){
		//TODO: if geen ploeg: setPloeg(unemployed)
		ploegen.add(ploeg);
	}
	
	public String getInitNaam(){
		//TODO: initialen + achternaam
		return voornaam + " " + familienaam;
	}
	
	public void addAssist(Assist assist){
		//TODO
	}
	public void addDoelpunt(Doelpunt doelpunt){
		//TODO
	}
	
}
