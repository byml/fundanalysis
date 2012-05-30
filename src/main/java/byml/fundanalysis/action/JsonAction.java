package byml.fundanalysis.action;

import org.apache.struts2.convention.annotation.ParentPackage;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

@ParentPackage(value = "json")
public class JsonAction extends ActionSupport {
	private static final long serialVersionUID = 7044325217725864312L;

	private User user;
	// 用于记录返回结果
	private String result;

	// 省略相应的get和set方法

	@SuppressWarnings("static-access")
	public String execute() throws Exception {

		// 将要返回的user实体对象进行json处理
		JSONObject jo = JSONObject.fromObject(this.user);
		// 打印一下，格式如下
		// {"name":"风达","age":23}
		System.out.println(jo);

		// 调用json对象的toString方法转换为字符串然后赋值给result
		this.result = jo.toString();

		return this.SUCCESS;
	}

}
