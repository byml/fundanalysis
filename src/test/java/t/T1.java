package t;

import net.sf.json.JSONObject;

import org.junit.Test;

import byml.fundanalysis.model.Fund;

public class T1 {
	@Test
	public void test(){
		Fund fund = new Fund();
		JSONObject jo = JSONObject.fromObject(fund);
		System.out.println(jo.toString());
	}
}
