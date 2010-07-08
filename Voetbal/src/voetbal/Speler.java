package voetbal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import datum.Datum;
import datum.DatumException;

public class Speler {

	private String voornaam;
	private String familienaam;
	private ArrayList<String> nationaliteiten;
	private Datum geboortejaar;
	private Positie positie;
	private Voet goedeVoet;

	// TODO: keyset met ploeg en begin en einde periode
	private TreeMap<Periode, Ploeg> ploegen;
	private List<Doelpunt> doelpunten;
	private List<Assist> assists;

	public List<Kaart> kaarten;
	public boolean geschorst = false;

	public String getVoornaam() {
		return voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public String getFullNaam() {
		return voornaam + " " + familienaam;
	}

	public String getFullNaam(boolean omgekeerd) {
		return familienaam + " " + voornaam;
	}

	public String getInitNaam() {
		// TODO: initialen + achternaam
		StringBuffer init= new StringBuffer();
		StringTokenizer token = new StringTokenizer(voornaam," ");
		init.append(token.nextToken());
		return voornaam + " " + familienaam;
	}

	public ArrayList<String> getNationaliteit() {
		return nationaliteiten;
	}
	
	public void addNationaliteit(String nation){
		nationaliteiten.add(nation);//TODO: nationaliteit toegvoegen
	}
	
	public Datum getGeboortejaar(){
		return geboortejaar;
	}

	public boolean isGeschorst() {
		return geschorst;
	}

	public void setGeschorst(boolean geschorst) {
		this.geschorst = geschorst;
	}

	public Positie getPositie() {
		return positie;
	}
	
	public void addPositie(Positie positie){
		//TODO: positie toevoegen
	}

	public List<Doelpunt> getDoelpunten() {
		return doelpunten;
	}

	public List<Assist> getAssists() {
		return assists;
	}

	public List<Kaart> getKaarten() {
		return kaarten;
	}

	public void setGoedeVoet(Voet goedeVoet) {
		this.goedeVoet = goedeVoet;
	}

	public Voet getGoedeVoet() {
		return goedeVoet;
	}

	public int getLeeftijd() {
		int result = geboortejaar.getJaar();
		if (geboortejaar.getMaand() > Datum.now().getMaand()) {
			return (result - 1);
		}
		if (geboortejaar.getMaand() == Datum.now().getMaand()
				&& geboortejaar.getDag() > Datum.now().getDag()) {
			return (result - 1);
		}
		return result;
	}

	public Ploeg getPloeg() {
		return ploegen.lastEntry().getValue();
	}

	public void setPloeg(Ploeg ploeg) {
		// TODO: if geen ploeg: setPloeg(unemployed)
		try {
			setPloeg(new Periode(), ploeg);
		} catch (DatumException de) {
			System.out.println(de.getMessage());
		}
	}

	public void setPloeg(Periode periode, Ploeg ploeg) {
		// TODO: if geen ploeg: setPloeg(unemployed)
		ploegen.put(periode, ploeg);
	}

	/**
	 * Als op dit moment unemployed geraakt
	 */
	public void unemployed() {
		try {
			unemployed(new Periode());
		} catch (DatumException de) {
			System.out.println(de.getMessage());
		}
	}

	/**
	 * Unemployed vanaf de opgegeven periode
	 * 
	 * @param periode
	 */
	public void unemployed(Periode periode) {
		ploegen.put(periode, Ploeg.VRIJ);
	}

	public TreeMap<Periode, Ploeg> getPloegenEnPeriode() {
		return ploegen;
	}

	public TreeSet<Ploeg> getPloegen() {
		return (TreeSet<Ploeg>) ploegen.values();
	}

	public TreeSet<Periode> getPeriodes() {
		return (TreeSet<Periode>) ploegen.keySet();
	}

	public TreeSet<Periode> periodeBijPloeg(Ploeg ploeg) {
		Iterator<Entry<Periode, Ploeg>> it = ploegen.entrySet().iterator();
		TreeSet<Periode> result = null;
		Entry<Periode, Ploeg> temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getValue().equals(ploeg)) {
				result.add(temp.getKey());
			}
		}
		return result;
	}

	public void addAssist(Assist assist) {
		assists.add(assist);
	}

	public void addDoelpunt(Doelpunt doelpunt) {
		doelpunten.add(doelpunt);
	}

	public void clear() {
		doelpunten.clear();
		assists.clear();
	}

}
