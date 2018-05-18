package com.golden.crm.web.controller.customer;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author weizhichao 类名称：联系人管理Controller 类描述：联系人管理 时间：2016-10-28
 */
@RequestMapping(value = "customerManage")
@Controller
public class CustomerManageController {

	@Resource(name = "crmService")
	private IServiceStore crmService;

	/**
	 * 联系人管理初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "customerIndex")
	public String customerIndex(@RequestParam Map<String, Object> map) throws IOException {
		return "customerManage/customer_manage_index";
	}

	/**
	 * 分页查询联系人管理
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCustomerManagePage")
	public String getPremisesPicturesPage(@RequestParam Map<String, Object> map,ModelMap model)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		
		ResultValue result = crmService.access(
				"customerManage/customerManageService.getCustomerManagePage",map);
		return result.getData();
	}

	/**
	 * 联系人详情页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "showDetails")
	public String showDetails(@RequestParam Map<String, Object> map,ModelMap model) throws IOException {
			
		ResultValue result = crmService.access("customerManage/customerManageService.getCustomerByUserCode",map);
		model.addAttribute("customerModel", result.getJsonObject());
		return "customerManage/customer_show_details";
	}
	
	/**
	 * 添加联系人初始化
	 * @return 
	 */
	@RequestMapping(value = "toAddCustomer")
	public String toAddCustomer(@RequestParam Map<String,Object> map , HttpServletRequest request){
		return "customerManage/customerAdd_Update";	
	}
	
	/**
	 * 添加联系人
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "addCustomer")
	public String addCustomer(@RequestParam Map<String,Object> map, HttpSession session ){
		String userName = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		map.put("entryPerson", userName);
		ResultValue result = crmService.access("customerManage/customerManageService.addCustomer",map);
		return result.getData();
	}
	
	/**
	 * 修改联系人初始化
	 * @return 
	 */
	@RequestMapping(value = "toUpdateCustomer")
	public String toUpdateCustomer(@RequestParam Map<String,Object> map ,ModelMap model){
		ResultValue result = crmService.access("customerManage/customerManageService.getCustomerById", map);
		model.addAttribute("customerModel", result.getJsonObject());
		return "customerManage/customerAdd_Update";	
	}
	
	/**
	 * 模糊匹配联系人名称
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getUserName")
	public String getUserName(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("customerManage/customerManageService.getUserName", map);
		return result.getData();
	}
	
	/**
	 * 修改联系人
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "updateCustomer")
	public String updateCustomer(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("customerManage/customerManageService.updateCustomer",map);
		return result.getData();
	}
	
	/**
	 * 修改联系人初始化
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "customerCheck")
	public String customerCheck(@RequestParam Map<String,Object> map ,ModelMap model){
		ResultValue result = crmService.access("customerManage/customerManageService.getCustomerByTell", map);
		return result.getData();
	}
	
	/**
	 * 查询联系人是否已被拉黑
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "queryBlackListById")
	public String queryBlackListById(@RequestParam Map<String,Object> map ,ModelMap model){
		ResultValue result = crmService.access("customerManage/customerManageService.queryBlackListById", map);
		return result.getData();
	}
	
	/**
	 * 将联系人拉黑
	 * @return 
	 */
	
	@RequestMapping(value = "addBlackList")
	public String addBlackList(@RequestParam Map<String,Object> map ,ModelMap model){
		model.put("customerId", map.get("id"));
		return "/customerManage/add_black_list";
	}
	
	/**
	 * 保存拉黑联系人
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "saveBlackList")
	public String saveBlackList(@RequestParam Map<String,Object> map ,HttpSession session){
		map.put("operateUser", session.getAttribute("userName").toString());
		map.put("operateUserId", session.getAttribute("id").toString());
		ResultValue result = crmService.access("customerManage/customerManageService.saveBlackList", map);
		return result.getData();
	}
	
	/**
	 * 查询插入的联系人ID
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "getLastInsertCustomerId")
	public String getLastInsertCustomerId(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("customerManage/customerManageService.getLastInsertCustomerId", map);
		return result.getData();
	}
	
	/**
	 * 客源列表初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "showDemandsIndex")
	public String showDemandsIndex(@RequestParam Map<String, Object> map,ModelMap model) throws IOException {
		model.addAttribute("customerId", map.get("id").toString());
		return "customerManage/show_demands_index";
	}
	
	/**
	 * 分页查询客户需求
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getdemandsPage")
	public String getdemandsPage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		
		ResultValue result = crmService.access(
				"customerManage/customerManageService.getdemandsPage",map);
		return result.getData();
	}
	
}
