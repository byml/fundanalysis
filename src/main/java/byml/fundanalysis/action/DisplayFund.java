package byml.fundanalysis.action;

import org.apache.struts2.convention.annotation.ParentPackage;

import net.sf.json.JSONObject;
import byml.fundanalysis.model.Fund;

@ParentPackage(value = "json")
public class DisplayFund {
	private Fund fund;
	private String result;

	public Fund getFund() {
		if (fund == null) {
			fund = new Fund();
			fund.setCode("N");
		}
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() {
		JSONObject jo = JSONObject.fromObject(this.fund);
		result = jo.toString();
		return "success";
	}
}
