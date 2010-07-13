package voetbal;

import java.sql.Date;
import java.util.Calendar;

import datum.*;
import javax.persistence.*;

@Entity
@Table(name="PERIODS")
public class Periode {

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.DATE)
	private Calendar begin = Calendar.getInstance();
	
	@Temporal(TemporalType.DATE)
	private Calendar einde = Calendar.getInstance();
	/**
	 * Creëert een periode die op het moment van de creatie begint en nog niet voorbij is.
	 * @throws DatumException
	 */
	public Periode() throws DatumException{
		this(Calendar.getInstance(),null);
	}
	
	/**
	 * Creëert een periode die op het opgegeven moment begint, maar nog niet voorbij is.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Periode(Calendar begin) throws DatumException{
		this(begin,null);
	}

	/**
	 * Creëert een periode in het verleden die op de opgegeven momenten respectievelijk begint en eindigt.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @param einde Eindmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Periode(Calendar begin, Calendar einde) throws DatumException {
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
	private boolean geldigePeriode(Calendar begin2, Calendar einde2) {
		if(einde2==null){
			if(!begin2.after(Calendar.getInstance()))
				return true;
			return false;
		}
		return (einde2.after(begin2) && !begin2.after(Calendar.getInstance())
				&& !einde2.after(Calendar.getInstance()) ? true : false);
	}
	
	public Calendar getBegin(){
		return begin;
	}
	
	public Calendar getEinde(){
		if(einde==null)
			return Calendar.getInstance();
		return einde;
	}
}
