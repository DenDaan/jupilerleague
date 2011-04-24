package voetbal;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="Periods-Teams")
public class PeriodeWithTeam implements Comparable<PeriodeWithTeam>{

	@Id
	@GeneratedValue
	private int id;
	
	@JoinColumn(name="Period")
	private Period periode;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Player")
	private Team ploeg;
	
	

	public PeriodeWithTeam(Period periode, Team ploeg) {
		this.periode = periode;
		this.ploeg = ploeg;
	}

	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public Period getPeriode() {
		return periode;
	}

	public void setPeriode(Period periode) {
		this.periode = periode;
	}

	public Team getPloeg() {
		return ploeg;
	}

	public void setPloeg(Team ploeg) {
		this.ploeg = ploeg;
	}

	@Override
	public int compareTo(PeriodeWithTeam o) {
		return getComparator().compare(this, o);
	}
	
	public static Comparator<PeriodeWithTeam> getComparator(){
        return new Comparator<PeriodeWithTeam>(){
            public int compare(PeriodeWithTeam w1, PeriodeWithTeam w2){
                 if (w1.getPloeg().equals(w2.getPloeg())){
                	 return w1.getPeriode().compareTo(w2.getPeriode());
                 } else{
                	 return w1.getPloeg().compareTo(w2.getPloeg());
                 }
            }
        };
    }
	
}
