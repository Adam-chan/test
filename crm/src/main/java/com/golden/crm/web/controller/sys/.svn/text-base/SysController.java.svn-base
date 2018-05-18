package com.golden.crm.web.controller.sys;

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
@RequestMapping(value = "sys")
public class SysController {
	@Resource(name="crmService")
	private IServiceStore crmService;
	/**
	 * 客源系统参数设置Index
	 */
	@RequestMapping(value = "customerIndex")
	public String customerIndex(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService.getSysCustomerInfo",parame);
		model.addAttribute("result", result.getJsonObject());
		return "sysParameter/coustomerSysParame_main";
	}
	/** 
	 * 房源系统参数设置Index
	 */
	@RequestMapping(value = "houseIndex")
	public String houseIndex(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService",parame);
		model.addAttribute("result", result.getJsonObject());
		return "sysParameter/houseSysParame_main";
	}
	/**
	 * 收益分成系统参数设置Index
	 */
	@RequestMapping(value = "earningsIndex")
	public String earningsIndex(){
		return "sysParameter/gainSharing_main";
	}
	/**
	 * 其他系统参数设置Index
	 */
	@RequestMapping(value = "otherIndex")
	public String otherIndex(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService.getSysOtherAllList",parame);
		model.addAttribute("result", result.getJsonObject());
		return "sysParameter/otherSysParame_main";
	}
	/**
	 * 新增-房源参数
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "insertHouseInfo")
	@ResponseBody
	public String insertHouseInfo(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.saveSysHouseInfo",params);
		return result.getData();
	}
	
	/**
	 * 查询房源参数数据list
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getSysHouseParame")
	@ResponseBody
	public String getSysHouseParame(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.getSysHouseList",params);
		return result.getData();
	}
	/**
	 *  删除房源系统参数
	 */
	@ResponseBody
	@RequestMapping(value = "deleteSysHouse")
	public String deleteSysHouse(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService.deleteSysHouse",parame);
		return  result.getData();
	}
	/**
	 * 分页查询收益分成比例列表
	 */
	@ResponseBody
	@RequestMapping(value="getGainSharingPage")
	public String getGainSharingPage(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = crmService.access("sysParam/sysParamService.getGainSharingPage", param);
		return result.getData();
	}
	/**
	 * 收益分成比例Open页
	 */
	@RequestMapping(value = "gainSharingEdit")
	public String gainSharingEdit(@RequestParam Map<String, Object> parame,ModelMap model){
		if(!parame.get("gainSharingId").toString().equals("")){
			ResultValue result = crmService.access("sysParam/sysParamService.getGainSharingInfo",parame);
			model.addAttribute("result", result.getJsonObject());
		}
		return "sysParameter/gainSharing_open";
	}
	/**
	 * 收益分成successBtn
	 */
	@ResponseBody
	@RequestMapping(value = "editGainSharing")
	public String editGainSharing(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService.editGainSharing",parame);
		return  result.getData();
	}
	/**
	 * 删除收益参数
	 */
	@ResponseBody
	@RequestMapping(value = "deleteGainSharing")
	public String deleteGainSharing(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService.deleteGainSharing",parame);
		return  result.getData();
	}
	/**
	 * 新增-客源参数  客户评价 黑名单级别
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "insertCustomerInfo")
	@ResponseBody
	public String insertCustomerInfo(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.saveSysCustomerInfo",params);
		return result.getData();
	}
	/**
	 * 新增-经纪人跟进提醒
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "saveSysCustomer")
	@ResponseBody
	public String saveSysCustomer(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.saveSysCustomer",params);
		return result.getData();
	}
	/**
	 * 新增修改 查看房源电话次数
	 * @param params 
	 *  	sysUpdateDescribe	  修改时职位描述
	 *   	sysCoustomerDescribe  职位描述	
	 *     	sysCoustomerTDescribe 修改次数字符串
	 *      sysCoustomerType  系统参数类型
	 *  	operationType  1 新增 2修改
	 *@return
	*/
	@ResponseBody
	@RequestMapping(value = "saveSysCustomerTell")
	public String saveSysCustomerTell(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.saveSysCustomerTell",params);
		return result.getData();
	}
	/**
	 * 查询客源参数数据list 回显
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSysCustomerParame")
	public String getSysCustomerParame(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.getSysCustomerList",params);
		return result.getData();
	}
	/**
	 *  删除客源系统参数
	 */
	@ResponseBody
	@RequestMapping(value = "deleteSysCustomer")
	public String deleteSysCustomer(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService.deleteSysCustomer",parame);
		return  result.getData();
	}
	/**
	 * 新增-其他参数
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "insertOtherInfo")
	@ResponseBody
	public String insertOtherInfo(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.saveSysOtherInfo",params);
		return result.getData();
	}
	
	/**
	 * 查询其他参数数据list
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getSysOtherParame")
	@ResponseBody
	public String getSysOtherParame(@RequestParam Map<String,Object> params){
		ResultValue result = crmService.access("sysParam/sysParamService.getSysOtherList",params);
		return result.getData();
	}
	/**
	 *  删除其他系统参数
	 */
	@ResponseBody
	@RequestMapping(value = "deleteSysOther")
	public String deleteSysOther(@RequestParam Map<String, Object> parame,ModelMap model){
		ResultValue result = crmService.access("sysParam/sysParamService.deleteSysOther",parame);
		return  result.getData();
	}
}
