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
	private MatchDay matchDay;
	
	//TODO: Add 'played'-boolean OR GameManager
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Home")
	private Team home;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Away")
	private Team away;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@Column(name="Goals")
	private Set<Goal> goals = new HashSet<Goal>();

	public Game(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MatchDay getSpeeldag() {
		return matchDay;
	}

	public void setSpeeldag(MatchDay matchDay) {
		this.matchDay = matchDay;
	}

	public Season getSeizoen() {
		return matchDay.getSeason();
	}

	public void setSeizoen(Season season) {
		this.matchDay.setSeason(season);
	}

	public Team getHomeTeam() {
		return home;
	}

	public void setHomeTeam(Team home) {
		this.home = home;
	}

	public Team getAwayTeam() {
		return away;
	}

	public void setAwayTeam(Team away) {
		this.away = away;
	}

	public Set<Goal> getGoals() {
		return goals;
	}

	public void setGoals(Set<Goal> goals) {
		this.goals = goals;
	}
	
	public void addGoal(Goal goal){
		goals.add(goal);
	}
	
	
}
