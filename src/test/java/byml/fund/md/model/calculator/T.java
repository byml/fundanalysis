package byml.fund.md.model.calculator;

import java.util.Date;

import net.byml.util.DateUtil;

import org.junit.Test;


public class T {
	// 固定利率固定期限

	public double[] getExpectedYields(double agreedYield, double[] prices, int year, Date endDate) {
		double[] expectedYields = new double[prices.length];
		for (int i = 0; i < expectedYields.length; i++) {
			expectedYields[i] = this.getExpectedYield(agreedYield, prices[i], year, endDate);
		}
		return expectedYields;
	}

	// 根据预期收益（复利）计算价格
	public double getExpectedYield(double agreedYield, double price, int year, Date endDate) {
		long dayDiff = DateUtil.dayDiff(new Date(), endDate);
		return Math.pow((1 + agreedYield * year) / price, 365d / dayDiff) - 1;
	}

	public double[] getPrices(double agreedYield, double[] expectedYields, int year, Date endDate) {
		double[] prices = new double[expectedYields.length];
		for (int i = 0; i < expectedYields.length; i++) {
			prices[i] = this.getPrice(agreedYield, expectedYields[i], year, endDate);
		}
		return prices;
	}

	// 根据价格计算预期收益（复利）
	public double getPrice(double agreedYield, double expectedYield, int year, Date endDate) {
		long dayDiff = DateUtil.dayDiff(new Date(), endDate);
		return (1 + agreedYield * year) / Math.pow((1 + expectedYield), (0.000 + dayDiff) / 365);

	}

	@Test
	public void t() throws Exception {
		System.out.println(getPrice(0.0403, 0.07, 3, DateUtil.toDate(2013, 10, 15)));
		double[] expectedYields = new double[] {0.065,0.07,0.0725,0.075,0.0775,0.08,0.0825,0.085 };
		double[] prices = getPrices(0.0525, expectedYields, 3, DateUtil.toDate(2014, 12,23));
		for (int i = 0; i < expectedYields.length; i++) {			
			System.out.println("price:" + prices[i] + " yield:" + expectedYields[i]);
		}
	}

}
