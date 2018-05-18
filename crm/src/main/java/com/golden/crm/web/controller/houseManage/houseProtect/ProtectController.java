package com.golden.crm.web.controller.houseManage.houseProtect;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * 保护管理 
 */
@Controller
@RequestMapping(value = "protect")
public class ProtectController {
	@Resource(name="crmService")
	private IServiceStore crmService;
	@Resource(name = "oaService")
	private OAService oaService;
	/**
	 * 赛事发布页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model) throws IOException {
		model.addAttribute("quOrgList", oaService.getQuOrgList());
		return "demo/test";
		//return "houseProtect/index";
	}
	@ResponseBody
	@RequestMapping(value = "list")
	public String list(@RequestParam Map<String,Object> param) throws IOException {
		param.put("currentPage", param.get("page").toString());
		param.put("rowCount", param.get("rows").toString());
		ResultValue result = crmService.access("houseManage/protectService", param);
		return result.getData();
	}
	
	@ResponseBody
	@RequestMapping(value = "cancel")
	public String cancel(@RequestParam Map<String,Object> param) throws IOException {
		ResultValue result = crmService.access("houseManage/protectService.cancel", param);
		return result.getData();
	}
}
