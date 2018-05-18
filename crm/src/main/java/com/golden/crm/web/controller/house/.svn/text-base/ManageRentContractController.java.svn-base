package com.golden.crm.web.controller.house;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author lza
 * 类名称：普租签约管理controller
 * 类描述：普租签约表的数据访问
 * 日          期：2016-11-24
 */
@Controller
@RequestMapping(value = "manageRentContract")
public class ManageRentContractController {
	
	@Resource(name = "crmService")
	private IServiceStore crmService;
	
	@Resource(name="oaService")
	private OAService oaService;

	/**
	 *添加普租合约初始化页面
	 * @param params{房源:houseInfoId}
	 */
	@RequestMapping(value = "manageRentContractIndex")
	public String manageRentContractIndex(@RequestParam Map<String,Object> map,ModelMap model,HttpSession session){
		
		//查看
		ResultValue resul = crmService.access("house/manageRentContractService", map);
		if(resul.getJsonObject()!=null){
			model.addAttribute("manageRentContract",resul.getJsonObject());
		}else{
			//获取房源id houseInfoId
			model.addAttribute("houseInfoId", map.get("houseInfoId"));
			//获取合同编号
			ResultValue code = crmService.access("house/manageRentContractService.getCode", null);
			model.addAttribute("code",code.getData());
			//获取出租表数据（获取业主姓名、业主电话、正宅地址、获取租金）
			ResultValue Lease = crmService.access("house/manageTimeLimitExpressService.getManageTimeLimitExpressLease", map);
			//获取房源所在区县
			model.addAttribute("Lease",Lease.getJsonObject());
			ResultValue manageRentContract = crmService.access("house/manageRentContractService.getCounty", map);
			//省市区
			model.addAttribute("mergerName",manageRentContract.getJsonObject().getString("mergerName"));
			//区
			model.addAttribute("county",manageRentContract.getJsonObject().getString("county"));
			//区id
			model.addAttribute("baseAreaId",manageRentContract.getJsonObject().getString("baseAreaId"));
			//获取限时速递收限人
			/*	model.addAttribute("userId",session.getAttribute( AihomeConst.SESSION_USER_ID_KEY));
				model.addAttribute("middleman",session.getAttribute( AihomeConst.SESSION_USER_NAME_KEY));*/
				//获取组织结构？
			/*model.addAttribute("recycleHouseShop",oaService.getOrgName((String) session.getAttribute( AihomeConst.SESSION_ORG_CODE_KEY)));
	 		*/	
		}
		return "manageRentContract/manageRentContract";
	}
	/**
	 *添加普租合约初始化页面
	 * @param params{房源:houseInfoId}
	 */
	@ResponseBody
	@RequestMapping(value = "addManageRentContract")
	public String addManageRentContract(@RequestParam Map<String,Object> map){
		ResultValue resul = crmService.access("house/manageRentContractService.insertManageRentContract", map);
		if(resul.getCode() == 0){
			resul.setData(resul.getCode().toString());
		}
		return resul.getData();
	}
	/**
	 *修改普租合约合同
	 * @param params{房源:houseInfoId}
	 */
	@ResponseBody
	@RequestMapping(value = "updateManageRentContract")
	public String updateManageRentContract(@RequestParam Map<String,Object> map){
		ResultValue resul = crmService.access("house/manageRentContractService.updateManageRentContract", map);
		if(resul.getCode() == 0){
			resul.setData(resul.getCode().toString());
		}
		return resul.getData();
	}
}
