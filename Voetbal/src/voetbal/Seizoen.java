package voetbal;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import datum.DatumException;

import voetbal.speler.util.GoodDate;

@Entity
@Table(name="Seasons")
public class Seizoen implements PeriodeInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Start")
	private int jaar;
	
	@OneToMany(mappedBy="seizoen", cascade=CascadeType.ALL)
	private List<Game> games;
	
	public Seizoen(int jaar){
		if(geldigSeizoen(jaar)){
			this.jaar=jaar;
		}
		 else {
				throw new IllegalArgumentException("Ongeldig Seizoen. De begin- en/of einddatum is ongeldig.");
			}
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public Date getBegin() throws DatumException {
		return GoodDate.createDate(1, 7, jaar);
	}

	public Date getEinde() throws DatumException {
		return GoodDate.createDate(30, 6, jaar+1);
	}

	public int compareTo(Periode periode) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private boolean geldigSeizoen(int seizoen){
	//TODO: jaar mag niet te groot of te klein zijn!!!
		return true;
	}
}
