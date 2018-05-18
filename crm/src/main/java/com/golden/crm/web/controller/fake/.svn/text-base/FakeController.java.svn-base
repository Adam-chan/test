package com.golden.crm.web.controller.fake;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

@Controller
@RequestMapping(value = "fake")
public class FakeController {
	@Resource(name="crmService")
	private IServiceStore crmService;

	/**
	 * 	我的打假Index
	 */
	@RequestMapping(value = "index")
	public String earningsIndex(){
		return "fake/myFake_main";
	}
	/**
	 * 分页查询我的打假列表
	 */
	@ResponseBody
	@RequestMapping(value="getFakePage")
	public String getFakePage(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = crmService.access("fake/fakeService", param);
		return result.getData();
	}
	/**
	 * 我的打假Open页
	 */
	@RequestMapping(value = "myFakeOpen")
	public String myFakeOpen(@RequestParam Map<String, Object> parame,ModelMap model,HttpSession session){
		ResultValue fakeResult = crmService.access("fake/fakeService.getFakeInfo",parame);
		parame.put("houseInfoId",fakeResult.getJsonObject().get("houseInfoId").toString());
		String type = fakeResult.getJsonObject().get("type").toString();
		String transType = fakeResult.getJsonObject().get("transType").toString();
		String url = "";
		if(transType.equals("1")){
			ResultValue houseSaleResult = crmService.access("house/houseSaleService.getDetail", parame);
			model.addAttribute("houseSaleInfo", houseSaleResult.getJsonObject());
		}else{
			ResultValue houseLeaseResult = crmService.access("house/houseLeaseService.getDetail", parame);
			model.addAttribute("houseLeaseInfo", houseLeaseResult.getJsonObject());
		}
		if(type.equals("1")){
			url =  "fake/fake_house_open";
		}else if(type.equals("2")){
			url =  "fake/fake_sk_open";
		}else if(type.equals("3")){
			url =  "fake/fake_key_open";
		}else{
			ResultValue houseProxyResult = crmService.access("house/commonSearchService.queryProxyInfo", parame);
			model.addAttribute("houseProxyInfo", houseProxyResult.getJsonObject());
			url =  "fake/fake_proxy_open";
		}
		model.addAttribute("fakeResult", fakeResult.getJsonObject());
		return url;
	}
}
