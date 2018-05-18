package com.golden.addr.web.controller.duty;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

@Controller
@RequestMapping(value = "duty")
public class DutyController {
	
	@Resource(name="addrService")
	private IServiceStore addrService;

	/**
	 * 地址库查询页面
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model) throws IOException {
		return "duty/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "list")
	public String list(@RequestParam Map<String, Object> param) throws IOException {
		ResultValue result = addrService.access("", param);
		return result.getData();
	}
}
