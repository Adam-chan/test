package com.golden.crm.web.controller.customerSource;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

@Controller
@RequestMapping(value = "customerPool")
public class CustomerPoolController {

	@Resource(name = "crmService")
	private IServiceStore crmService;
	
	@Resource(name = "oaService")
	private OAService oaService;
	
	/**
	 * 页面：公客池
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "customerPoolPage")
	public String index(){
		return "customerPool/customer_pool_main";
	}
	/**
	 * 页面：列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "customerPoolTable")
	public String publicCustomerPool(HttpServletRequest request,HttpSession session,@RequestParam Map<String,Object > map){
		String type = map.get("type").toString();
		String userPosi = session.getAttribute(AihomeConst.SESSION_USER_POSI).toString();//经纪人1，组长2，区经理3，大区经理4
		JSONArray operaterList = null;//登记人
		if(userPosi.equals("1")){
			operaterList = JSON.parseArray("[{\"name\":\""+session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY)+"\",\"userId\":\""+session.getAttribute(AihomeConst.SESSION_USER_ID_KEY)+"\"}]");
		}else{
			operaterList = oaService.getOrgUserList(session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString());
		}
		ResultValue sysParamMap = crmService.access("sysParam/sysParamService",null);//房源系统参数
		ResultValue parentSourceList = crmService.access("ownerSource/ownerSourceService.getParentSources", null);//业主来源
		request.setAttribute("parentSourceList", parentSourceList.getJsonArray());
		request.setAttribute("operaterList", operaterList);
		request.setAttribute("sysParamMap", sysParamMap.getJsonObject());
		if(type.equals("1")){
			return "customerPool/public_pool_table";
		}else{
			return "customerPool/deal_pool_table";
		}
	}
	/**
	 * 页面：分配弹出框
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "distributeDialog")
	public String distributeDialog(HttpServletRequest request){
		request.setAttribute("quOrgList", oaService.getQuOrgList());//OA组织结构
		return "customerPool/distribute_dialog";
	}
	/**
	 * 分页查询成交公客池
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCustomerPoolListForPage")
	public String getHouseLeaseListForPage(@RequestParam Map<String,Object> map,HttpSession session){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		ResultValue result = crmService.access("customerSource/CustomerPoolService.getCustomerPoolListForPage", map);
		return result.getData();
	}
	/**
	 * 商圈-模糊搜索
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBusiAreaByMatch")
	public String getBusiAreaByMatch(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("customerSource/CustomerPoolService.getBusiAreaByMatch", map);
		return result.getData();
	}
	/**
	 * 公客池分配
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "customerPoolComment")
	public String customerPoolComment(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("customerSource/CustomerPoolService.customerPoolComment", map);
		return result.getData();
	}
	
	
}
