package com.golden.crm.web.controller.prospectingManage;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
@Controller
@RequestMapping(value = "prospectingManage")
public class ProspectingManageController {
	@Resource(name="crmService")
	private IServiceStore crmService;
	
	/**
	 * 我的实勘列表
	 */
	@RequestMapping(value = "index")
	public String index() {
		return "prospectingManage/prospecting_index";
	}
	
	
	/**
	 * tab页切换
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getProspectingTab")
	public String getProspectingTab(HttpServletRequest request){
		String tabCode = request.getParameter("tabCode");
		if("1".equals(tabCode)){
			return "prospectingManage/myProspecting";	
		}else if("2".equals(tabCode)){
			return "prospectingManage/fakeProspecting";
		}
		return null;
	}
	
	/**
	 * tab页列表切换
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "manageProspectList")
	public String manageProspectList(@RequestParam Map<String, Object> param,HttpServletRequest request,HttpSession session){
		param.put("prospectUser",session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		String tabCode = request.getParameter("tabCode");
		if("1".equals(tabCode)){
			ResultValue result = crmService.access("prospect/manageProspect.getManageKeyJQPage",param);
			return result.getData();	
		}else if("2".equals(tabCode)){
			ResultValue result = crmService.access("prospect/manageProspect.getFakeProspectJQPage",param);
			return result.getData();
		}
		return null;
	}
}
