package com.golden.crm.web.controller.checkinfo;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * 用户查看电话，地址，证载地址 
 * @author zhr
 */
@Controller
@RequestMapping(value = "checks")
public class CheckInfoController {
	
	@Resource(name = "crmService")
	private IServiceStore crmService;
	/**
	 * 查看房源电话，地址。证载地址。
	 * 参数：  
	 * 		houseId 房源ID
	 * 		houseCode 房源编号
	 * 		seeType:查看类型。1电话，2地址,3证载地址
	 * 		demandType:需求类型，1租赁，2买卖
	 * 		userId:用户ID
	 * 		uesrType:用户类型1经纪人，2组长，3区经理，4大区经理
	 */
	@ResponseBody
	@RequestMapping(value = "houseInfo")
	public String houseInfo(@RequestParam Map<String,Object> param,HttpSession session){
		String userId= session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String orgCode = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		//用户职位
		String userPosi = session.getAttribute(AihomeConst.SESSION_USER_POSI).toString();
		//数据权限
		String dataPowers = session.getAttribute(AihomeConst.SESSION_DATA_POWERS_KEY).toString();
		param.put("userId", userId);
		param.put("orgCode", orgCode);
		param.put("userPosi", userPosi);
		param.put("dataPowers", dataPowers);
		ResultValue result = crmService.access("users/userService", param);
		return result.getData();
	}
	/**
	 * 查看客源电话
	 * 参数：
	 * demandId 查看的客源需求ID 
	 * demandCode 查看的客源需求编号
	 * userId
	 * userType 用户职位类型
	 * orgCode 组织编号
	 * demandType 擦看类型，1租赁2买卖
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "customerTell")
	public String customerInfo(@RequestParam Map<String,Object> param,HttpSession session){
		String userId= session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String orgCode = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		String userPosi = session.getAttribute(AihomeConst.SESSION_USER_POSI).toString();
		param.put("userId", userId);
		param.put("orgCode", orgCode);
		param.put("userPosi", userPosi);
		ResultValue result = crmService.access("users/userService.customerTell", param);
		return result.getData();
	}
}
