package voetbal;

import java.io.Serializable;
import java.util.Date;

import datum.*;
import javax.persistence.*;

@Entity
@Table(name="PERIODS")
public class Period implements PeriodInterface, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.DATE)
	private Date begin;
	
	@Temporal(TemporalType.DATE)
	private Date end;
	
	/**
	 * Creëert een periode die op het moment van de creatie begint en nog niet voorbij is.
	 * @throws DatumException
	 */
	public Period() throws DatumException{
		this(new Date(),null);
	}
	
	/**
	 * Creëert een periode die op het opgegeven moment begint, maar nog niet voorbij is.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Period(Date begin) throws DatumException{
		this(begin,null);
	}

	/**
	 * Creëert een periode in het verleden die op de opgegeven momenten respectievelijk begint en eindigt.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @param einde Eindmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Period(Date begin, Date end) throws DatumException {
		if (validPeriod(begin, end)) {
			this.begin = begin;
			this.end = end;
		} else {
			throw new IllegalArgumentException("Illegal period. The start and/or end date aren't correct.");
		}
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/**
	 * Checkt of de opgegeven periode, in de vorm van een begin- en eindmoment, een geldige periode is.\n
	 * Een periode is geldig als: \n
	 * 1) het tweede moment later is dan het eerste \n
	 * 2) beide momenten niet na het moment van de creatie van de periode liggen
	 * @param begin2 het beginmoment van de periode, in de vorm van een Date-object
	 * @param einde2 het eindmoment van de periode, in de vorm van een Date-object
	 * @return true als de opgegeven periode een geldige periode is. Anders wordt false teruggegeven.
	 */
	private boolean validPeriod(Date begin, Date end) {
		Date now = new Date();
		if(end==null){
			if(!begin.after(now))
				return true;
			return false;
		}
		return (end.after(begin) && !begin.after(now)
				&& !end.after(now) ? true : false);
	}
	
	public Date getBegin(){
		return begin;
	}
	
	public Date getEnd(){
		if(end==null)
			return new Date();
		return end;
	}
	
	//TODO: hashcodes! equals!
	public int hashCode(){
		return 0;
	}
	
	public boolean equals(Object o){
		return false;
	}
	
	public int compareTo(Period period) {
		// TODO Auto-generated method stub
		return 0;
	}
}
