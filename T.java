import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class T {
	protected double calculateWorth(double li, int year) {
		double total = 1;
		for (int i = 0; i < year; i++) {
			total += li * Math.pow(1 + li, i);
		}
		return total;
	}

	public double calculatePrice(Date toDate, double agreedYield, double expectedYield) {
		Date now = new Date();
		double price = agreedYield * ((1 / expectedYield + 1) - dayDiff(now, toDate) / 365d);
		return price;
	}

	public double calculateExpectedYield(Date toDate, double agreedYield, double price) {
		Date now = new Date();
		double expectedYield = 1 / (price / agreedYield + dayDiff(now, toDate) / 365d - 1);
		return expectedYield;
	}

	protected double calculatePrice(double worth, double interestRate, Date endDate) {
		Date now = new Date();
		double price = worth / Math.pow(1 + interestRate, dayDiff(now, endDate) / 365d);
		return price;
	}

	protected double calculateExpectedYield(double worth, double price, Date endDate) {
		Date now = new Date();
		double expectedYield = Math.pow(worth / price, 365d / (dayDiff(now, endDate))) - 1;
		return expectedYield;
	}

	protected long dayDiff(Date fromDate, Date toDate) {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(fromDate);
		fromCal.set(Calendar.HOUR_OF_DAY, 0);
		fromCal.set(Calendar.MINUTE, 0);
		fromCal.set(Calendar.SECOND, 0);
		fromCal.set(Calendar.MILLISECOND, 0);

		Calendar toCal = Calendar.getInstance();
		toCal.setTime(toDate);
		toCal.set(Calendar.HOUR_OF_DAY, 0);
		toCal.set(Calendar.MINUTE, 0);
		toCal.set(Calendar.SECOND, 0);
		toCal.set(Calendar.MILLISECOND, 0);

		return (toCal.getTime().getTime() - fromCal.getTime().getTime()) / (1000 * 3600 * 24);
	}

	public static void main(String[] args) throws Exception {
		T t = new T();
		System.out.println(t.calculateExpectedYield(DateUtils.parseDate("2013-1-1", new String[] { "yyyy-MM-dd" }), 0.07, 0.896));
		System.out.println(t.calculatePrice(DateUtils.parseDate("2013-1-1", new String[] { "yyyy-MM-dd" }), 0.07, 0.08));

		System.out.println(t.calculateExpectedYield(t.calculateWorth(0.07, 3), 1.03, DateUtils.parseDate("2015-3-23", new String[] { "yyyy-MM-dd" })));
	}
}
