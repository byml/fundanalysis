package byml.fundanalysis.action;

import java.util.List;

public class ListFundsAction {
	private int rowNumber;
	private int count;
	private int page;
	
	private List funds;

	public List getFunds() {
		return funds;
	}

	public void setFunds(List funds) {
		this.funds = funds;
	}

}
