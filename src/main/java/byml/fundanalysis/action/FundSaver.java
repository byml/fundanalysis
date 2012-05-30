package byml.fundanalysis.action;

import byml.fundanalysis.model.Fund;
import byml.fundanalysis.serivce.FundService;

import com.opensymphony.xwork2.ActionSupport;

public class FundSaver extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private transient FundService fundService;

	private Fund fund;

	/**
	 * Use id provided in the user's request to find the Fund object and
	 * then delete that Fund's record.
	 */
	public String execute() {

		fundService.save(fund);

		return SUCCESS;
	}

	public void validate() {

		if (fund.getCode().length() == 0) {

			addFieldError("fund.first_name", "First name is required.");

		}

		if (fund.getFullName().length() == 0) {

			addFieldError("fund.last_name", "Last name is required.");

		}

	}

	public FundService getFundService() {
		return fundService;
	}

	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

}
