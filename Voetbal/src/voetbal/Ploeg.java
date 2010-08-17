package voetbal;

import java.io.Serializable;
import java.util.List;

import voetbal.speler.Speler;
import javax.persistence.*;

/**
 * De klasse Ploeg creëert een Object dat een voetbalploeg voorstelt. 
 * Deze ploeg houdt uiteraard de spelers bij die een contract hebben bij het team,
 *  maar ook de spelers die ooit voor de ploeg speelden, maar ondertussen bij een andere ploeg spelen of werkloos of met pensioen zijn.
 * @author Daan Vleugels
 *
 */
@Entity
@Table(name="TEAMS")
public class Ploeg implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="TEAM_ID")
	private int id;

	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="PLAYERS")
	private List<Speler> spelers;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="EX_PLAYERS")
	private List<Speler> exSpelers;
	
	@Column(name="NAME")
	private String naam;

	public static final Ploeg VRIJ = new Ploeg();

	/**
	 * Creërt een voetbalploeg zonder naam en zonder lijst van spelers en ex-spelers. Deze constructor wordt gebruikt om de 'Ploeg' van werklozen te creëren.
	 */
	private Ploeg() {
		this(null,null,null);
	}

	/**
	 * Creëert een voetbalploeg met de opgegeven naam, maar zonder spelers of ex-spelers.
	 * @param naam De naam van de voetbalploeg
	 */
	public Ploeg(String naam) {
		this(naam,null,null);
	}
	
	/**
	 * Creëert een voetbalploeg met de opgegeven naam, lijst van spelers en lijst van ex-spelers.
	 * @param naam De naam van de voetbalploeg
	 * @param spelers De lijsts van de spelers die momenteel bij de ploeg aangesloten zijn
	 * @param exSpelers De lijst van de spelers die bij de ploeg hebben gespeeld, maar nu ergens anders spelen of werkloos of met pensioen zijn
	 */
	public Ploeg(String naam, List<Speler> spelers, List<Speler> exSpelers){
		this.naam=naam;
		this.spelers=spelers;
		this.exSpelers=exSpelers;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}

	/**
	 * Geeft een lijst met alle spelers die momenteel bij de club actief zijn.
	 * @return De lijst van aangesloten spelers
	 */
	public List<Speler> getSpelers() {
		return spelers;
	}

	/**
	 * Geeft de lijst van spelers terug die ooit voor de ploeg speelden. 
	 * Die spelers zijn nu met pensioen of werkloos of hebben zich aangesloten bij een ander team.
	 * @return De lijst van voormalige spelers van de ploeg
	 */
	public List<Speler> getExSpelers() {
		return exSpelers;
	}

	/**
	 * Geeft de naam van de ploeg terug.
	 * @return De naam van de ploeg
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * Verandert de naam van de ploeg in de opgegeven naam.
	 * @param naam De nieuwe naam voor de ploeg
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	/**
	 * Met deze methode neemt de ploeg de opgegeven Speler aan en wordt hij ontslagen door zijn oude ploeg.
	 * @param speler De speler die opgenomen wordt in de ploeg.
	 */
	public void contracteer(Speler speler){
		ontsla(speler);
		VRIJ.getSpelers().remove(speler);
		spelers.add(speler);
		speler.setPloeg(this);
		//TODO: speler aannemen en ontslaan van ploeg of uit unemployed ploeg halen
	}
	
	/**
	 * Ontslaat de opgegeven speler uit de ploeg. Hij wordt hierdoor werkloos(wordt toegevoegd aan de Ploeg van werklozen: VRIJ).
	 * @param speler
	 */
	public void ontsla(Speler speler){
		speler.getPloeg().spelers.remove(speler);
		if(!exSpelers.contains(speler)){
			exSpelers.add(speler);	
		}
		VRIJ.getSpelers().add(speler);
		speler.setPloeg(VRIJ);
	}

	public void transfer(Speler speler, Ploeg ploeg) {
		// TODO: transfer naar ploeg
	}
	
	@Override
	public String toString(){
		//TODO
		return naam;
	}
	
	@Override
	public int hashCode(){
		//TODO
		return naam.hashCode();
	}
	
	public int compareTo(Object o){
		if (o.getClass()==this.getClass()){
			return naam.compareTo(o.toString()); 
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object o){
		return naam.equals(o);
	}
}
