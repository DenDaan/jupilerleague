package voetbal;

import javax.persistence.*;

import voetbal.doelpunt.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="GAMES")
public class Game implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="GAME_ID")
	private int id;
	
	@Column(name="MATCHDAY")
	private int speeldag;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@Column(name="SEASON")
	private Periode seizoen;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@Column(name="HOME_TEAM")
	private Ploeg thuis;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@Column(name="AWAY_TEAM")
	private Ploeg uit;
	
	@OneToMany(mappedBy="game", cascade=CascadeType.PERSIST)
	private Set<Doelpunt> doelpunten = new HashSet<Doelpunt>();

	public Game(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpeeldag() {
		return speeldag;
	}

	public void setSpeeldag(int speeldag) {
		this.speeldag = speeldag;
	}

	public Periode getSeizoen() {
		return seizoen;
	}

	public void setSeizoen(Periode seizoen) {
		this.seizoen = seizoen;
	}

	public Ploeg getThuis() {
		return thuis;
	}

	public void setThuis(Ploeg thuis) {
		this.thuis = thuis;
	}

	public Ploeg getUit() {
		return uit;
	}

	public void setUit(Ploeg uit) {
		this.uit = uit;
	}

	public Set<Doelpunt> getDoelpunten() {
		return doelpunten;
	}

	public void setDoelpunten(Set<Doelpunt> doelpunten) {
		this.doelpunten = doelpunten;
	}
	
	public void addDoelpunt(Doelpunt doelpunt){
		doelpunten.add(doelpunt);
	}
	
	
}
