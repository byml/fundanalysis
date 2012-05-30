package byml.fundanalysis.action;

import java.util.List;

import byml.fundanalysis.model.Fund;
import byml.fundanalysis.serivce.FundService;

import com.opensymphony.xwork2.ActionSupport;

public class AllFundsFinder extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Collection of all funds.
	 */
	private List<Fund> funds;
	
	
	/**
	 * Provides methods to get Fund objects.
	 */
	
	private transient FundService fundService;
	
	
	@Override
	public String execute() throws Exception {
		
		funds = fundService.findAllFunds();
		
		return SUCCESS;
		
	}

	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

	public FundService getFundService() {
		return fundService;
	}

	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

}
