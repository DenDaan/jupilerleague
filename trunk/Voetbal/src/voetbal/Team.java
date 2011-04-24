package voetbal;

import java.io.Serializable;
import java.util.List;

import voetbal.speler.Speler;
import javax.persistence.*;

/**
 * The class team creates objects that represent a sports team. 
 * This team holds the players who are contracted by the team, 
 * but also every player that ever played for this team,
 *  but is now playing with another team, is teamless or retired.
 * @author Daan Vleugels
 *
 */
@Entity
@Table(name="Teams")
public class Team implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;

	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="Players")
	private List<Speler> players;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="ExPlayers")
	private List<Speler> exPlayers;
	
	@Column(name="Name")
	private String name;

	// FIXME: Needs to move to another class. A manager or something.
	public static final Team FREE = new Team();

	/**
	 * Creërt een voetbalploeg zonder naam en zonder lijst van spelers en ex-spelers. Deze constructor wordt gebruikt om de 'Ploeg' van werklozen te creëren.
	 */
	private Team() {
		this(null,null,null);
	}

	/**
	 * Creëert een voetbalploeg met de opgegeven naam, maar zonder spelers of ex-spelers.
	 * @param name De naam van de voetbalploeg
	 */
	public Team(String name) {
		this(name,null,null);
	}
	
	/**
	 * Creëert een voetbalploeg met de opgegeven naam, lijst van spelers en lijst van ex-spelers.
	 * @param name De naam van de voetbalploeg
	 * @param players De lijsts van de spelers die momenteel bij de ploeg aangesloten zijn
	 * @param exPlayers De lijst van de spelers die bij de ploeg hebben gespeeld, maar nu ergens anders spelen of werkloos of met pensioen zijn
	 */
	public Team(String name, List<Speler> players, List<Speler> exPlayers){
		this.name=name;
		this.players=players;
		this.exPlayers=exPlayers;
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
	public List<Speler> getPlayers() {
		return players;
	}

	/**
	 * Geeft de lijst van spelers terug die ooit voor de ploeg speelden. 
	 * Die spelers zijn nu met pensioen of werkloos of hebben zich aangesloten bij een ander team.
	 * @return De lijst van voormalige spelers van de ploeg
	 */
	public List<Speler> getExPlayers() {
		return exPlayers;
	}

	/**
	 * Geeft de naam van de ploeg terug.
	 * @return De naam van de ploeg
	 */
	public String getName() {
		return name;
	}

	/**
	 * Verandert de naam van de ploeg in de opgegeven naam.
	 * @param name De nieuwe naam voor de ploeg
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Met deze methode neemt de ploeg de opgegeven Speler aan en wordt hij ontslagen door zijn oude ploeg.
	 * @param player De speler die opgenomen wordt in de ploeg.
	 */
	public void contract(Speler player){
		player.getPloeg().fire(player);
		FREE.getPlayers().remove(player);
		players.add(player);
		player.setTeam(this);
		//TODO: speler aannemen en ontslaan van ploeg of uit unemployed ploeg halen
	}
	
	/**
	 * Ontslaat de opgegeven speler uit de ploeg. Hij wordt hierdoor werkloos(wordt toegevoegd aan de Ploeg van werklozen: VRIJ).
	 * @param player
	 */
	public void fire(Speler player){
		player.getPloeg().players.remove(player);
		if(!exPlayers.contains(player)){
			exPlayers.add(player);	
		}
		FREE.getPlayers().add(player);
		player.setTeam(FREE);
	}

	public void transfer(Speler player, Team team) {
		fire(player);
		team.contract(player);
	}
	
	@Override
	public String toString(){
		//TODO
		return name;
	}
	
	@Override
	public int hashCode(){
		//TODO: hash
		return name.hashCode();
	}
	
	public int compareTo(Object o){
		if (o.getClass()==this.getClass()){
			return name.compareTo(o.toString()); 
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object o){
		return name.equals(o);
	}
}
