package byml.fundanalysis.action;

import java.util.List;

import byml.fundanalysis.model.Fund;
import byml.fundanalysis.model.FundType;
import byml.fundanalysis.serivce.FundService;
import byml.fundanalysis.serivce.FundTypeService;

import com.opensymphony.xwork2.ActionSupport;

public class FundUpdater extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private transient FundService fundService;
	private transient FundTypeService fundTypeService;

	private Long id;
	private Fund fund;
	private List<FundType> fundTypes;

	/**
	 * Use the id value that was provided when the user clicked on the edit link
	 * get the associated Fund object.
	 * 
	 */
	public String input() {

		fund = fundService.findById(id);
		fundTypes = fundTypeService.findAllFundTypes();
		return INPUT;

	}

	/**
	 * Use the state of the Fund object (which was updated by the user in the
	 * view) to update the data repository.
	 */
	public String execute() {

		fundService.update(fund);

		return SUCCESS;
	}

	public FundService getFundService() {
		return fundService;
	}

	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	public FundTypeService getFundTypeService() {
		return fundTypeService;
	}

	public void setFundTypeService(FundTypeService fundTypeService) {
		this.fundTypeService = fundTypeService;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FundType> getFundTypes() {
		return fundTypes;
	}

	public void setFundTypes(List<FundType> fundTypes) {
		this.fundTypes = fundTypes;
	}

}
