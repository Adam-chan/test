package com.golden.crm.web.controller.house;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author lza
 * 类名称：限时速递管理Controller
 * 类描述：限时速递管理Controller
 * 时间：2016-11-18
 */
@Controller
@RequestMapping(value = "manageTimeLimitExpress")
public class ManageTimeLimitExpressController {
	
	@Resource(name = "crmService")
	private IServiceStore crmService;
	
	@Resource(name="oaService")
	private OAService oaService;

	/**
	 *限时速递初始化页面
	 * @param params{房源:houseInfoId,type:房源类型}
	 * @return
	 */
	@RequestMapping(value = "manageTimeLimitIndex")
	public String manageTimeLimitIndex(@RequestParam Map<String,Object> map,ModelMap model){
		model.addAttribute("houseInfoId",map.get("houseInfoId"));
		model.addAttribute("type",map.get("type"));
		return "manageTimeLimitExpress/manageTimeLimitExpressIndex";
	}
	
	/**
	 * 限时速递分页初始化
	 * map{houseInfoId：房源表id，type：1买卖，2租赁}
	 * return PagerResult<ManageTimeLimitExpressModel>
	 */
	@ResponseBody
	@RequestMapping(value = "getManageTimeLimitExpressPage")
	public String getManageTimeLimitExpressPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		map.put("houseInfoId",map.get("houseInfoId"));
		ResultValue result = crmService.access("house/manageTimeLimitExpressService.getManageTimeLimitExpressPage", map);
		return result.getData();
	}
	/**
	 * 根据限时速递id获取详情
	 * map{houseInfoId：房源表id，type：1买卖，2租赁}
	 * return PagerResult<ManageTimeLimitExpressModel>
	 */
	@RequestMapping(value = "getManageTimeLimitExpressDetail")
	public String getManageTimeLimitExpressDetail(ModelMap model,@RequestParam Map<String,Object> map){
		Map<String,Object> param = new HashMap<String, Object>();
		Object timeLimitId = map.get("id");
		param.put("timeLimitId", timeLimitId);
		//获取限时速递id下的建筑证件列表
		ResultValue result = crmService.access("house/manageTimeLimitExpressService.getBuildingPapers", param);
		model.addAttribute("BuildingPapersList", result.getJsonArray());
		//获取限时速递实体
		ResultValue ManageTimeLimitExpress = crmService.access("house/manageTimeLimitExpressService.getManageTimeLimitExpress", map);
		model.addAttribute("ManageTimeLimitExpress", ManageTimeLimitExpress.getJsonObject());
		return "manageTimeLimitExpress/add_manageTimeLimitExpress";
	}
	/**
	 *限时速递填加页面
	 * @param {houseInfoId:房源主表id，type：类型}
	 */
	@RequestMapping(value = "addManageTimeLimitIndex")
	public String addManageTimeLimitIndex(ModelMap model,@RequestParam Map<String, Object> map,HttpSession session){
		String type = (String) map.get("type");
		if(type.equals("1")){
			//获取出售表数据（获取业主姓名、业主电话、正宅地址、房源编号）
			ResultValue sale = crmService.access("house/manageTimeLimitExpressService.getManageTimeLimitExpressSale", map);
			model.addAttribute("sale",sale.getJsonObject());
		}else{
			//获取出租表数据（获取业主姓名、业主电话、正宅地址、房源编号）
			ResultValue Lease = crmService.access("house/manageTimeLimitExpressService.getManageTimeLimitExpressLease", map);
			model.addAttribute("Lease",Lease.getJsonObject());
		}
		//获取合同编码
		ResultValue code = crmService.access("house/manageTimeLimitExpressService.getCode", null);
		model.addAttribute("limittimeContractNum",code.getData());
		model.addAttribute("houseInfoId", map.get("houseInfoId"));
		String status = (String) map.get("status");
		if(status.equals("2")){
			model.addAttribute("originalContract", map.get("limittimeContractNum"));
			model.addAttribute("status",status);
		}else{
			model.addAttribute("status",1);
		}
		//获取限时速递收限人
		model.addAttribute("limitUserId",session.getAttribute( AihomeConst.SESSION_USER_ID_KEY));
		model.addAttribute("limitUser",session.getAttribute( AihomeConst.SESSION_USER_NAME_KEY));
		//获取组织结构、收限店、组、区、大区、组织结构编号
		model.addAttribute("recycleHouseShop",oaService.getOrgName((String) session.getAttribute( AihomeConst.SESSION_STORE_TELL_KEY)));
		model.addAttribute("limitUserOrg",oaService.getOrgName((String) session.getAttribute( AihomeConst.SESSION_ZU_KEY)));
		model.addAttribute("limitUserArea",oaService.getOrgName((String) session.getAttribute( AihomeConst.SESSION_QU_KEY)));
		model.addAttribute("limitUserBigArea",oaService.getOrgName((String) session.getAttribute( AihomeConst.SESSION_DAQU_KEY)));
		model.addAttribute("limitUserCode",oaService.getOrgName((String) session.getAttribute( AihomeConst.SESSION_ORG_CODE_KEY)));
		return "manageTimeLimitExpress/add_manageTimeLimitExpress";
	}
	
	/**
	 * 限时速递添加
	 */
	@ResponseBody
	@RequestMapping(value = "addManageTimeLimit")
	public String addManageTimeLimit(ModelMap model,@RequestParam Map<String, Object> map,@RequestParam Integer[] credentialsType,@RequestParam String[] credentialsNum){
		map.put("credentialsType", credentialsType);
		map.put("credentialsNum", credentialsNum);
		ResultValue Lease = crmService.access("house/manageTimeLimitExpressService.insertManageTimeLimitExpressLease", map);
		String type =Lease.getCode().toString();
		if(type == "0"){
			return type;
		}
		return Lease.getData();
		
	}
	
	/**
	 * 限时速递校验
	 */
	@ResponseBody
	@RequestMapping(value = "getBycount")
	public String getBycount(@RequestParam Map<String, Object> map){
		ResultValue Lease = crmService.access("house/manageTimeLimitExpressService.getBycount", map);
		return Lease.getData();
	}
	/**
	 * 限时速递初始化页面
	 */
	@RequestMapping(value = "changeStutsIndex")
	public String changeStutsIndex(@RequestParam Map<String, Object> map,ModelMap model) {
		model.addAttribute("LimitId", map.get("Id"));
		model.addAttribute("status", map.get("status"));
		return "manageTimeLimitExpress/endOrTermination";
	}
	/**
	 * 限时速递结束和终止操作
	 */
	@ResponseBody
	@RequestMapping(value = "updataStuts")
	public String changeStuts(@RequestParam Map<String, Object> map) {
		ResultValue Lease = crmService.access("house/manageTimeLimitExpressService.updataStuts", map);
		return Lease.getData();
	}
}
