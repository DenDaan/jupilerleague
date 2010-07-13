package voetbal.doelpunt;

import voetbal.Game;
import javax.persistence.*;
import voetbal.doelpunt.util.Manier;
import voetbal.speler.Speler;

@Entity
@Table(name="GOALS")
public class Doelpunt {
	
	@Id
	@GeneratedValue
	@Column(name="GOAL_ID")
	private int id;

	private int minuut;
	
	@Enumerated
	@Column(name="WAY")
	private Manier manier;
	
	@OneToOne
	private Speler spelerPunt;
	
	@OneToOne
	private Speler spelerAssist;
	
	@ManyToOne
	private Game game;
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, Manier manier){
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.manier=manier;
	}
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, Game match, Manier manier) {
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.manier=manier;
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
	
	public Manier getManier(){
		return manier;
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
