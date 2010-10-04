package voetbal;

import javax.persistence.*;

import voetbal.doelpunt.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="Games")
public class Game implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="MatchDay")
	private int speeldag;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Season")
	private Seizoen seizoen;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Home")
	private Ploeg thuis;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Away")
	private Ploeg uit;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@Column(name="Goals")
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

	public Seizoen getSeizoen() {
		return seizoen;
	}

	public void setSeizoen(Seizoen seizoen) {
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
