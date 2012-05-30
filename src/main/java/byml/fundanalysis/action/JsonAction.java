package byml.fundanalysis.action;

import org.apache.struts2.convention.annotation.ParentPackage;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

@ParentPackage(value = "json")
public class JsonAction extends ActionSupport {
	private static final long serialVersionUID = 7044325217725864312L;

	private User user;
	// ���ڼ�¼���ؽ��
	private String result;

	// ʡ����Ӧ��get��set����

	@SuppressWarnings("static-access")
	public String execute() throws Exception {

		// ��Ҫ���ص�userʵ��������json����
		JSONObject jo = JSONObject.fromObject(this.user);
		// ��ӡһ�£���ʽ����
		// {"name":"���","age":23}
		System.out.println(jo);

		// ����json�����toString����ת��Ϊ�ַ���Ȼ��ֵ��result
		this.result = jo.toString();

		return this.SUCCESS;
	}

}
