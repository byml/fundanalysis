package byml.fundanalysis.action;

import byml.fundanalysis.model.Fund;
import byml.fundanalysis.serivce.FundService;

import com.opensymphony.xwork2.ActionSupport;

public class FundFinder extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	/**
	 * employee ID of the fund to find.
	 */
	private Long id;
	
	/**
	 * Fund found using the id.
	 */
	private Fund fund;
	
	/**
	 * Provides methods to get Fund objects.
	 */
	private  transient FundService fundService;
	
	
	@Override
	public String execute() throws Exception {
		
		fund = fundService.findById(id);
		
		return SUCCESS;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public FundService getFundService() {
		return fundService;
	}

	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}
	
	
	
	

}
