package byml.fundanalysis.model.calculator;

import java.util.Date;

import org.junit.Test;

import byml.util.DateUtil;

public class F {
	// 固定期限浮动利率

	public double getLi(double agreedYield, Date fromDate, Date toDate) {
		long dayDiff = DateUtil.dayDiff(fromDate, toDate);
		System.out.println(dayDiff);
		long days = DateUtil.getDaysOfYear(fromDate);
		return agreedYield * dayDiff / days;
	}

	@Test
	public void t() {
		double l1 = getLi(4.56586, DateUtil.toDate("2011-5-13"), DateUtil.toDate("2011-6-30"));
		double l2 = getLi(4.63203, DateUtil.toDate("2011-7-1"), DateUtil.toDate("2011-9-30"));
		double l3 = getLi(4.892668, DateUtil.toDate("2011-10-1"), DateUtil.toDate("2011-12-31"));
		double l4 = getLi(4.00205, DateUtil.toDate("2012-1-1"), DateUtil.toDate("2016-5-12"));
		System.out.println(l1 + " " + l2 + " " + l3 + " " + l4);
		System.out.println(l1 + l2 + l3 + l4);
	}
}
