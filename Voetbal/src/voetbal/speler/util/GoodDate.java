package voetbal.speler.util;

import java.util.Calendar;
import java.util.Date;

import datum.DatumException;

public class GoodDate {

	private GoodDate instance = new GoodDate();

	public GoodDate getInstance() {
		return instance;
	}

	private GoodDate() {
	}

	public static Date createDate(int day, int month, int year) throws DatumException {
		if(validDate(day,month,year)){
			return createCalendar(day, month, year).getTime();	
		} else{
			throw new DatumException();
		}
	}

	public static Calendar createCalendar(int day, int month, int year) throws DatumException {
		Calendar cal = Calendar.getInstance();
		if(validDate(day,month,year)){
			cal.set(year, month - 1, day);
			return cal;
		}else{
			throw new DatumException();
		}		
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	private static boolean validDate(int day, int month, int year) {
		int dvm[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		return year > 1583
				&& year < 4100
				&& month > 0
				&& month < 13
				&& day > 0
				&& day <= (dvm[month - 1] + ((month == 2 && (year % 4 == 0
						&& year % 100 != 0 || year % 400 == 0)) ? 1 : 0));
	}
	
	public static String print(Date date){
		return getDay(date) + "-" + getMonth(date) + "-" + getYear(date);
	}
}
