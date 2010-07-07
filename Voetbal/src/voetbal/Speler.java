package voetbal;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import datum.Datum;

public class Speler {
	
	private String voornaam;
	private String familienaam;
	private String nationaliteit;
	private Date geboortejaar;
	
	//TODO: keyset met ploeg en begin en einde periode
	private TreeMap<Periode, Ploeg> ploegen;
	private List<Doelpunt> doelpunten;
	private List<Assist> assists;
	
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
	
	public String getInitNaam(){
		//TODO: initialen + achternaam
		return voornaam + " " + familienaam;
	}
	
	public String getNationaliteit(){
		return nationaliteit;
	}
	
	public Ploeg getPloeg(){
		return ploegen.lastEntry().getValue();
	}
	
	public void setPloeg(Ploeg ploeg){
		//TODO: if geen ploeg: setPloeg(unemployed)
		setPloeg(new Periode(Datum.now()), ploeg);
	}
	public void setPloeg(Periode periode,Ploeg ploeg){
		//TODO: if geen ploeg: setPloeg(unemployed)
		ploegen.put(periode, ploeg);
	}
	
	/**
	 * Als op dit moment unemployed geraakt
	 */
	public void unemployed(){
		unemployed(new Periode());
	}
	
	/**
	 * Unemployed vanaf de opgegeven periode
	 * @param periode
	 */
	public void unemployed(Periode periode){
		ploegen.put(periode, Ploeg.VRIJ);
	}
	
	public TreeMap<Periode,Ploeg> getPloegenEnPeriode(){
		return ploegen;
	}
	
	public Set<Ploeg> getPloegen(){
		return (Set)ploegen.values();
	}
	
	public Set<Periode> getPeriodes(){
		return ploegen.keySet();
	}
	
	public Set<Periode> periodeBijPloeg(Ploeg ploeg){
		Iterator<Entry<Periode,Ploeg>> it = ploegen.entrySet().iterator();
		Set<Periode> result=null;
		Entry<Periode,Ploeg> temp;
		while(it.hasNext()){
			temp = it.next();
			if(temp.getValue().equals(ploeg)){
				result.add(temp.getKey());
			}
		}
		return result;
	}
	
	public void addAssist(Assist assist){
		assists.add(assist);
	}
	public void addDoelpunt(Doelpunt doelpunt){
		doelpunten.add(doelpunt);
	}
	
	public void clear(){
		doelpunten.clear();
		assists.clear();
	}
	
}
