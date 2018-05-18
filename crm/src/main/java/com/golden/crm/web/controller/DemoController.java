package com.golden.crm.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.resolvers.CurrentUser;
import com.golden.port.framework.resolvers.LoginUser;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

@Controller
@RequestMapping(value = "demo")
public class DemoController {
	
	@Resource(name="crmService")
	private IServiceStore crmService;
	
	@RequestMapping(value = "index")
	public String index(ModelMap model) throws IOException {
		/*long start = System.currentTimeMillis();
		ResultValue result = addrService.access("demo/demoService", null);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		model.put("data", JSON.parse(result.getData()));*/
		
		ResultValue result = crmService.access("houseManage/testService", null);
		model.addAttribute("data", result.getJsonArray());
		return "demo/demo";
	}
	@ResponseBody
	@RequestMapping(value = "index1")
	public String index1(ModelMap model) throws IOException {
		ResultValue result = crmService.access("houseManage/testService", null);
		return  result.getData();
	}
	@RequestMapping(value = "page")
	public String page() throws IOException {
		return "demo/page_table";
	}
	@ResponseBody
	@RequestMapping(value = "ajax")
	public String ajax(@RequestParam Map<String,Object> params,@CurrentUser LoginUser user) throws IOException {
		String currentPage = params.get("page").toString();
		String rowCount = params.get("rows").toString();
		params.put("currentPage", currentPage);
		params.put("rowCount", rowCount);
		ResultValue result = crmService.access("demo/demoService.getDemoList2", params);
		return result.getData();
	}
}
