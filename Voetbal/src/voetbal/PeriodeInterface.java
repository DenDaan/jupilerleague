package voetbal;

import java.util.Date;

import datum.DatumException;

public interface PeriodeInterface {

	public Date getBegin() throws DatumException;
	
	public Date getEinde() throws DatumException;

	public int compareTo(Periode periode);
	
}
