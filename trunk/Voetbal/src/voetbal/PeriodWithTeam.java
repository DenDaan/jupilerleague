package voetbal;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="Periods-Teams")
public class PeriodWithTeam implements Comparable<PeriodWithTeam>{

	@Id
	@GeneratedValue
	private int id;
	
	@JoinColumn(name="Period")
	private Period period;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Player")
	private Team team;
	
	

	public PeriodWithTeam(Period period, Team team) {
		this.period = period;
		this.team = team;
	}

	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public Period getPeriode() {
		return period;
	}

	public void setPeriode(Period period) {
		this.period = period;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public int compareTo(PeriodWithTeam o) {
		return getComparator().compare(this, o);
	}
	
	public static Comparator<PeriodWithTeam> getComparator(){
        return new Comparator<PeriodWithTeam>(){
            public int compare(PeriodWithTeam w1, PeriodWithTeam w2){
                 if (w1.getTeam().equals(w2.getTeam())){
                	 return w1.getPeriode().compareTo(w2.getPeriode());
                 } else{
                	 return w1.getTeam().compareTo(w2.getTeam());
                 }
            }
        };
    }
	
}
