package com.golden.addr.web.controller.BusiZoning;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author lza
 * 类名称：区划Controller
 * 类描述：区划的新增 、修改、下拉列表显示
 * 时间：2016-9-28
 */
@Controller
@RequestMapping(value = "busiZoning")
public class BusiZoningController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	/**
	 * 获取区划列表
	 * @return String:区划列表
	 */
	@ResponseBody
	@RequestMapping(value = "getbusiZoningList")
	public String getbusiZoningList(Map<String, Object> param){
		 ResultValue access = addrService.access("busiZoning/busiZoningService", param);
		return access.getData();
	}
}
