package voetbal;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MatchDay {

	public int playDay;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Season")
	private Season season;

	public void setSeason(Season season) {
		this.season = season;
	}

	public Season getSeason() {
		return season;
	}
	
}
