package voetbal;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

import datum.*;
import javax.persistence.*;

import voetbal.speler.util.GoodDate;

@Entity
@Table(name="PERIODS")
public class Periode implements Serializable{

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.DATE)
	private Date begin;
	
	@Temporal(TemporalType.DATE)
	private Date einde;
	
	/**
	 * Creëert een periode die op het moment van de creatie begint en nog niet voorbij is.
	 * @throws DatumException
	 */
	public Periode() throws DatumException{
		this(new Date(),null);
	}
	
	/**
	 * Creëert een periode die op het opgegeven moment begint, maar nog niet voorbij is.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Periode(Date begin) throws DatumException{
		this(begin,null);
	}

	/**
	 * Creëert een periode in het verleden die op de opgegeven momenten respectievelijk begint en eindigt.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @param einde Eindmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Periode(Date begin, Date einde) throws DatumException {
		if (geldigePeriode(begin, einde)) {
			this.begin = begin;
			this.einde = einde;
		} else {
			throw new IllegalArgumentException("Ongeldige periode. De begin- en/of einddatum is ongeldig.");
		}
		;
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
	 * @param begin2 het beginmoment van de periode, in de vorm van een Datum-object
	 * @param einde2 het eindmoment van de periode, in de vorm van een Datum-object
	 * @return true als de opgegeven periode een geldige periode is. Anders wordt false teruggegeven.
	 */
	private boolean geldigePeriode(Date begin, Date einde) {
		Date now = new Date();
		if(einde==null){
			if(!begin.after(now))
				return true;
			return false;
		}
		return (einde.after(begin) && !begin.after(now)
				&& !einde.after(now) ? true : false);
	}
	
	public Date getBegin(){
		return begin;
	}
	
	public Date getEinde(){
		if(einde==null)
			return new Date();
		return einde;
	}

	public int compareTo(Periode periode) {
		// TODO Auto-generated method stub
		return 0;
	}
}
