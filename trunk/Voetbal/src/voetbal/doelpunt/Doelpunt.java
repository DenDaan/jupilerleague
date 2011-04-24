package voetbal.doelpunt;

import java.io.Serializable;

import voetbal.Game;
import javax.persistence.*;

import voetbal.doelpunt.util.DoelpuntManier;
import voetbal.speler.Speler;

@Entity
@Table(name="GOALS")
public class Doelpunt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;

	private final int minuut;
	
	@Enumerated
	@Column(name="Way")
	private final DoelpuntManier doelpuntManier;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Scorer")
	private final Speler spelerPunt;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Assist")
	private final Speler spelerAssist;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Game")
	private final Game game;
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, DoelpuntManier doelpuntManier, Game game){
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.doelpuntManier=doelpuntManier;
		this.game=game;
	}
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, Game match, DoelpuntManier doelpuntManier) {
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.doelpuntManier=doelpuntManier;
		this.game=match;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getMinuut(){
		return minuut;
	}
	
	public DoelpuntManier getManier(){
		return doelpuntManier;
	}
	
	public Speler getSpelerPunt(){
		return spelerPunt;
	}
	
	public Speler getSpelerAssist(){
		return spelerAssist;
	}

	public Game getGame() {
		return game;
	}
}
