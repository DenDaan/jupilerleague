package voetbal.doelpunt;

import java.io.Serializable;

import voetbal.Game;
import javax.persistence.*;

import voetbal.doelpunt.util.DoelpuntManier;
import voetbal.speler.Speler;

@Entity
@Table(name="GOALS")
public class Doelpunt implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="GOAL_ID")
	private int id;

	private int minuut;
	
	@Enumerated
	@Column(name="WAY")
	private DoelpuntManier doelpuntManier;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Speler spelerPunt;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Speler spelerAssist;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Game game;
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, DoelpuntManier doelpuntManier){
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.doelpuntManier=doelpuntManier;
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
