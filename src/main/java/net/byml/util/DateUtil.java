package net.byml.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

public class DateUtil {
	public static Date toDate(String date) {
		try {
			return DateUtils.parseDate(date, new String[]{"yyyy-MM-dd","yyyy/MM/dd"});
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static Date toDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static long dayDiff(Date fromDate, Date toDate) {
		return 1 + (toDate.getTime() - fromDate.getTime()) / 1000 / 3600 / 24;
	}

	public static long getDaysOfYear(Date date) {
		Date startDate = DateUtils.setDays(DateUtils.setMonths(date, Calendar.JANUARY), 1);
		Date endDate = DateUtils.addYears(DateUtils.addDays(startDate, -1), 1);
		return dayDiff(startDate, endDate);
	}

}
