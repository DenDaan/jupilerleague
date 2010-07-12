package voetbal;

import java.sql.Date;
import datum.*;

public class Periode {

	private Datum begin;
	private Datum einde;
	/**
	 * Creëert een periode die op het moment van de creatie begint en nog niet voorbij is.
	 * @throws DatumException
	 */
	public Periode() throws DatumException{
		this(Datum.now(),null);
	}
	
	/**
	 * Creëert een periode die op het opgegeven moment begint, maar nog niet voorbij is.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Periode(Datum begin) throws DatumException{
		this(begin,null);
	}

	/**
	 * Creëert een periode in het verleden die op de opgegeven momenten respectievelijk begint en eindigt.
	 * @param begin Beginmoment van de periode, in de vorm van een Datum-object
	 * @param einde Eindmoment van de periode, in de vorm van een Datum-object
	 * @throws DatumException
	 */
	public Periode(Datum begin, Datum einde) throws DatumException {
		if (geldigePeriode(begin, einde)) {
			this.begin = begin;
			this.einde = einde;
		} else {
			throw new IllegalArgumentException("Ongeldige periode. De begin- en/of einddatum is ongeldig.");
		}
		;
	}
	
	/**
	 * Checkt of de opgegeven periode, in de vorm van een begin- en eindmoment, een geldige periode is.\n
	 * Een periode is geldig als: \n
	 * 1) het tweede moment later is dan het eerste \n
	 * 2) beide momenten niet na het moment van de creatie van de periode liggen
	 * @param datum1 het beginmoment van de periode, in de vorm van een Datum-object
	 * @param datum2 het eindmoment van de periode, in de vorm van een Datum-object
	 * @return true als de opgegeven periode een geldige periode is. Anders wordt false teruggegeven.
	 */
	private boolean geldigePeriode(Datum datum1, Datum datum2) {
		return (datum2.compareTo(datum1)>0 && datum1.compareTo(Datum.now())<=0
				&& datum2.compareTo(Datum.now())<=0 ? true : false);
	}
	
	public Datum getBegin(){
		return begin;
	}
	
	public Datum getEinde(){
		if(einde==null)
			return Datum.now();
		return einde;
	}
}
