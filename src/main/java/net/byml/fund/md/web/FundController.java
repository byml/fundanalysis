package net.byml.fund.md.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.byml.fund.md.model.Fund;
import net.byml.fund.md.serivce.FundService;
import net.byml.util.DataGridModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fund")
public class FundController {
	@Autowired
	FundService service;

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	@ResponseBody
	public Fund find(@PathVariable("code") String code, Model model) {
		Fund entity = service.findByCode(code);
		return entity;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> save(Fund entity) throws Exception {
		// spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
		Map<String, String> map = new HashMap<String, String>();
		try {
			service.save(entity);
			map.put("mes", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("uid") List<Long> uid)
			throws Exception {
		// spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
		Map<String, String> map = new HashMap<String, String>();
		try {
			service.delete(uid);
			map.put("mes", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map;
	}

	@RequestMapping(value = "/listAll")
	@ResponseBody
	public Iterable<Fund> listAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/queryList")
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm) {
		Map<String, Object> map = new HashMap<String, Object>();
		Pageable pageable = new PageRequest(dgm.getPage() - 1, dgm.getRows());
		Page<Fund> page = service.findByQuery(pageable);
		map.put("rows", page.getContent());
		map.put("total", page.getTotalElements());
		return map;
	}
}
