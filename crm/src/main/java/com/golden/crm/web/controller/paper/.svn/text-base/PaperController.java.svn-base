package com.golden.crm.web.controller.paper;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

@Controller
@RequestMapping(value = "paper")
public class PaperController {
	@Resource(name="crmService")
	private IServiceStore crmService;
	/**
	 * 房源纸
	 */
	@RequestMapping(value = "index")
	public String index() {
		return "papers/index";
	}
	
	/**
	 * 房源纸模板列表
	 */
	@ResponseBody
	@RequestMapping(value = "paperListPage")
	public String paperListPage(@RequestParam Map<String,Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = crmService.access("paper/paperService", param);
		return result.getData();
	}
	
	@RequestMapping(value = "addIndex")
	public String addIndex() {
		return "papers/add_index";
	}
	
}
