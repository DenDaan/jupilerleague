package voetbal.doelpunt;

import java.io.Serializable;

import voetbal.Game;
import javax.persistence.*;

import voetbal.doelpunt.util.WayToScore;
import voetbal.speler.Speler;

@Entity
@Table(name="GOALS")
public class Goal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;

	private final int minute;
	
	@Enumerated
	@Column(name="Way")
	private final WayToScore wayToScore;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Scorer")
	private final Speler scorer;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Assist")
	private final Speler assist;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Game")
	private final Game game;
	
	public Goal(Speler scorer, Speler assist, int minute, WayToScore wayToScore, Game game){
		this.scorer=scorer;		
		this.assist=assist;
		this.minute=minute;
		this.wayToScore=wayToScore;
		this.game=game;
	}
	
	public Goal(Speler scorer, int minute, Game game){
		this.scorer = scorer;
		this.minute = minute;
		this.game = game;
		this.assist = null;
		this.wayToScore = null;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getMinute(){
		return minute;
	}
	
	public WayToScore getWayToScore(){
		return wayToScore;
	}
	
	public Speler getScorer(){
		return scorer;
	}
	
	public Speler getAssist(){
		return assist;
	}

	public Game getGame() {
		return game;
	}
}
