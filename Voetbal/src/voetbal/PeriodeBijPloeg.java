package voetbal;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="PERIODS_TEAMS")
public class PeriodeBijPloeg implements Comparable<PeriodeBijPloeg>{

	@Id
	@GeneratedValue
	private int id;
	
	@JoinColumn(name="PERIODE")
	private Periode periode;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SPELER")
	private Ploeg ploeg;
	
	

	public PeriodeBijPloeg(Periode periode, Ploeg ploeg) {
		this.periode = periode;
		this.ploeg = ploeg;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public Ploeg getPloeg() {
		return ploeg;
	}

	public void setPloeg(Ploeg ploeg) {
		this.ploeg = ploeg;
	}

	@Override
	public int compareTo(PeriodeBijPloeg o) {
		return getComparator().compare(this, o);
	}
	
	public static Comparator<PeriodeBijPloeg> getComparator(){
        return new Comparator<PeriodeBijPloeg>(){
            public int compare(PeriodeBijPloeg w1, PeriodeBijPloeg w2){
                 if (w1.getPloeg().equals(w2.getPloeg())){
                	 return w1.getPeriode().compareTo(w2.getPeriode());
                 } else{
                	 return w1.getPloeg().compareTo(w2.getPloeg());
                 }
            }
        };
    }
	
}
