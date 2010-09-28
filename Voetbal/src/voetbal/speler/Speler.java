package voetbal.speler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import voetbal.Periode;
import voetbal.PeriodeBijPloeg;
import voetbal.Ploeg;
import voetbal.doelpunt.Doelpunt;
import voetbal.kaart.Kaart;
import voetbal.speler.util.GoodDate;
import voetbal.speler.util.Positie;
import voetbal.speler.util.Voet;
import datum.DatumException;

@Entity
@Table(name="PLAYERS")
public class Speler implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="PLAYER_ID")
	private int id;

	@Column(name="GIVEN_NAME")
	private final String voornaam;
	
	@Column(name="NAME")
	private final String familienaam;
	
	@Column(name="NATIONS")
	private List<String> nationaliteiten;
	
	@Column(name="BIRTHDAY")
	private final Date geboortedatum;
	
	private List<Positie> posities = new ArrayList<Positie>();
	
	@Enumerated
	@Column(name="PREFERRED_FOOT")
	private Voet goedeVoet;

	@OneToMany(mappedBy="ploeg")
	@Sort(type = SortType.NATURAL) 
	private SortedSet<PeriodeBijPloeg> ploegen = new TreeSet<PeriodeBijPloeg>();
	//private TreeMap<Periode, Ploeg> ploegen = new TreeMap<Periode,Ploeg>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Doelpunt> doelpunten = new ArrayList<Doelpunt>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Doelpunt> assists = new ArrayList<Doelpunt>();

	@OneToMany(cascade=CascadeType.ALL)
	private List<Kaart> kaarten = new ArrayList<Kaart>();
	private boolean geschorst = false;

	public Speler(String voornaam, String familienaam,
			List<String> nationaliteiten, Date geboortedatum,
			List<Positie> posities, Voet goedeVoet, Ploeg ploeg) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.nationaliteiten = nationaliteiten;
		this.geboortedatum = geboortedatum;
		this.posities = posities;
		this.goedeVoet = goedeVoet;
		setPloeg(ploeg);
	}
	
	public Speler(String voornaam, String familienaam,
			List<String> nationaliteiten, Date geboortedatum,
			List<Positie> posities, Voet goedeVoet, Ploeg ploeg, Periode periode) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.nationaliteiten = nationaliteiten;
		this.geboortedatum = geboortedatum;
		this.posities = posities;
		this.goedeVoet = goedeVoet;
		setPloeg(periode,ploeg);
	}
	
	public Speler(String voornaam, String familienaam,
			String nationaliteit, Date geboortedatum,
			Positie positie, Voet goedeVoet, Ploeg ploeg, Periode periode) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		addNationaliteit(nationaliteit);
		this.geboortedatum = geboortedatum;
		addPositie(positie);
		this.goedeVoet = goedeVoet;
		setPloeg(periode,ploeg);
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

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

	public List<String> getNationaliteit() {
		return nationaliteiten;
	}
	
	public void addNationaliteit(String nation){
		nationaliteiten.add(nation);//TODO: nationaliteit toegvoegen
	}
	
	public Calendar getGeboortedatum(){
		return GoodDate.getCalendar(geboortedatum);
	}
	
	public int getDay(){
		return GoodDate.getDay(geboortedatum);
	}
	
	public int getMonth(){
		return GoodDate.getMonth(geboortedatum);
	}
	
	public int getYear(){
		return GoodDate.getYear(geboortedatum);
	}

	public boolean isGeschorst() {
		return geschorst;
	}

	public void setGeschorst(boolean geschorst) {
		this.geschorst = geschorst;
	}

	public List<Positie> getPosities() {
		return posities;
	}
	
	public void addPositie(Positie positie){
		posities.add(positie);
	}

	public List<Doelpunt> getDoelpunten() {
		return doelpunten;
	}

	public List<Doelpunt> getAssists() {
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
		int leeftijd = -1;
		Date now = new Date();
		leeftijd = getYear()-GoodDate.getYear(now);
		if(getMonth()>GoodDate.getMonth(now) || getMonth()==GoodDate.getMonth(now) && getDay()>GoodDate.getDay(now)){
			leeftijd--;			
		}		
		return leeftijd;
	}

	public Ploeg getPloeg() {
		return ploegen.last().getPloeg();
	}

	public void setPloeg(Ploeg ploeg) {
		try {
			setPloeg(new Periode(), ploeg);
		} catch (DatumException de) {
			System.out.println(de.getMessage());
		}
	}

	public void setPloeg(Periode periode, Ploeg ploeg) {
		// TODO: if geen ploeg: setPloeg(unemployed)
		PeriodeBijPloeg pbp = new PeriodeBijPloeg(periode, ploeg);
		ploegen.add(pbp);
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
		ploegen.add(new PeriodeBijPloeg(periode, Ploeg.VRIJ));
	}

	public SortedSet<PeriodeBijPloeg> getPloegenEnPeriode() {
		return ploegen;
	}

	public SortedSet<Ploeg> getPloegen() {
		SortedSet<Ploeg> result=null;
		Iterator<PeriodeBijPloeg> it = ploegen.iterator();
		while(it.hasNext()){
			result.add(it.next().getPloeg());
		}
		return result;
	}

	public SortedSet<Periode> getPeriodes() {
		SortedSet<Periode> result=null;
		Iterator<PeriodeBijPloeg> it = ploegen.iterator();
		while(it.hasNext()){
			result.add(it.next().getPeriode());
		}
		return result;
	}

	public SortedSet<Periode> periodeBijPloeg(Ploeg ploeg) {
		Iterator<PeriodeBijPloeg> it = ploegen.iterator();
		SortedSet<Periode> result = null;
		PeriodeBijPloeg temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getPloeg().equals(ploeg)) {
				result.add(temp.getPeriode());
			}
		}
		return result;
	}

	public void addAssist(Doelpunt doelpunt) {
		assists.add(doelpunt);
	}

	public void addDoelpunt(Doelpunt doelpunt) {
		doelpunten.add(doelpunt);
	}

	public void clear() {
		doelpunten.clear();
		assists.clear();
	}

	@Override
	public String toString() {
		return "Speler [id="
				+ id
				+ ", "
				+ (voornaam != null ? "voornaam=" + voornaam + ", " : "")
				+ (familienaam != null ? "familienaam=" + familienaam + ", "
						: "")
				+ (nationaliteiten != null ? "nationaliteiten="
						+ nationaliteiten + ", " : "")
				+ (geboortedatum != null ? "geboortedatum=" + geboortedatum
						+ ", " : "")
				+ (posities != null ? "posities=" + posities + ", " : "")
				+ (goedeVoet != null ? "goedeVoet=" + goedeVoet + ", " : "")
				+ (ploegen != null ? "ploegen=" + ploegen + ", " : "")
				+ (doelpunten != null ? "doelpunten=" + doelpunten + ", " : "")
				+ (assists != null ? "assists=" + assists + ", " : "")
				+ (kaarten != null ? "kaarten=" + kaarten + ", " : "")
				+ "geschorst=" + geschorst + "]";
	}
	
	
	
	

}
