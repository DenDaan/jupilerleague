package voetbal;

import java.util.Date;

import datum.DatumException;

public interface PeriodInterface {

	public Date getBegin() throws DatumException;
	
	public Date getEnd() throws DatumException;

	public int compareTo(Period periode);
	
}
