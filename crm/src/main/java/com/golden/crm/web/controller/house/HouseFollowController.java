package com.golden.crm.web.controller.house;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * 房源跟进
 * @author dl
 * 时间：2016-11-26
 */
@Controller
@RequestMapping(value="houseFollow")
public class HouseFollowController {

	@Resource(name = "crmService")
	private IServiceStore crmService;
	
	@Resource(name = "oaService")
	private OAService oaService;
	
	@RequestMapping(value = "houseFollowPage")
	public String getHouseLeaseTable(HttpServletRequest request,@RequestParam Map<String, Object> map){
		ResultValue sysParamMap = crmService.access("sysParam/sysParamService",null);//房源系统参数
		request.setAttribute("quOrgList", oaService.getQuOrgList());//OA组织结构
		request.setAttribute("sysParamMap", sysParamMap.getJsonObject());
		return "houseFollow/house_follow";
	}
	/**
	 * 分页查询 dl
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseFollowListForPage")
	public String getHouseFollowListForPage(@RequestParam Map<String,Object> map,HttpSession session){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		//TODO 刁兰 处理数据权限
		//1）判断登陆人职位（区、组、人） 2）查询登陆人管辖内所有经纪人   
		//String searchRange = null;
		//String zhiwei = session.getAttribute(AihomeConst.SESSION_USER_ZHIWEI).toString();//登陆人职位
		//if(zhiwei.equals("jingjiren")){
		//	searchRange = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		//}else{
		//	searchRange = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		//}
		//map.put("searchRange", searchRange);
		//map.put("zhiwei", zhiwei);
		ResultValue result = crmService.access("house/houseFollowService.getHouseFollowListForPage", map);
		return result.getData();
	}
}
