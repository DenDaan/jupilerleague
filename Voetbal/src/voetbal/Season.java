package voetbal;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import datum.DatumException;

import voetbal.speler.util.GoodDate;

@Entity
@Table(name="Seasons")
public class Season implements PeriodInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Start")
	private int year;
	
	@OneToMany(mappedBy="seizoen", cascade=CascadeType.ALL)
	private List<Game> games;
	
	public Season(int year){
		if(validSeason(year)){
			this.year=year;
		}
		 else {
				throw new IllegalArgumentException("Illegal season. The begin or end date is incorrect.");
			}
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public Date getBegin() throws DatumException {
		return GoodDate.createDate(1, 7, year);
	}

	public Date getEnd() throws DatumException {
		return GoodDate.createDate(30, 6, year+1);
	}

	public int compareTo(Period periode) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int hashCode(){
		//TODO: hashcode!
		return 0;
	}
	
	public boolean equals(Object o){
		//TODO: equals!
		return false;
	}
	
	private boolean validSeason(int seizoen){
	//TODO: jaar mag niet te groot of te klein zijn!!!
		return true;
	}
}
