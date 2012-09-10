package byml.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DateUtilTest {
	
	@Test
	public void testYearDiff() { 
		double delta = 0.00000000001;
		assertEquals("", 1d/366+1d/365,DateUtil.yearDiff(DateUtil.toDate(2011,12, 31), DateUtil.toDate(2012,1, 1)),delta);
		System.out.println("MM"+DateUtil.yearDiff(DateUtil.toDate(2012,6, 25), DateUtil.toDate(2013,1, 4)));
	}

	@Test
	public void testFirstDayOfYear() { 
		assertEquals("", DateUtil.toDate(2012,1, 1),DateUtil.firstDayOfYear(2012));
	}

	@Test
	public void testLastDayOfYear() {
		assertEquals("", DateUtil.toDate(2012,12, 31),DateUtil.lastDayOfYear(2012));
	}

}
