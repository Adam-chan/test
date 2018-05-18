package com.golden.crm.web.controller.myDuty;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.golden.port.framework.stores.IServiceStore;

@Controller
@RequestMapping(value = "myDuty")
public class MyDutyController {

	@Resource(name="crmService")
	private IServiceStore crmService;

	/**
	 * 我的责任盘页面
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		return "myDuty/myDutyIndex";
	}
}