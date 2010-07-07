package voetbal;

import java.sql.Date;
import datum.Datum;

public class Periode {

	private Datum begin;
	private Datum einde;
	/**
	 * Voor een periode te creëren die nog niet voorbij is
	 * @param begin
	 * @throws IllegalArgumentException
	 */
	public Periode() throws IllegalArgumentException{
		this(Datum.now(),null);
	}
	
	public Periode(Datum begin) throws IllegalArgumentException{
		this(begin,null);
	}

	public Periode(Datum begin, Datum einde) throws IllegalArgumentException {
		if (geldigePeriode(begin, einde)) {
			this.begin = begin;
			this.einde = einde;
		} else {
			throw new IllegalArgumentException();
		}
		;
	}

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
