package com.golden.addr.web.controller.busiArea;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author lza
 * 类名称：商圈管理Controller
 * 类描述：商圈的新增 、修改、分页列表显示
 * 时间：2016-9-28
 */
@Controller
@RequestMapping(value = "busiArea")
public class BusiAreaController {
	
	@Resource(name="addrService")
	private IServiceStore addrService;
	
	/**
	 * 商圈初始化页面
	 * @return Page
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model){
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("areaLevel", 1);
		ResultValue result = addrService.access("area/areaService.getAreaList",map);
		model.addAttribute("provinceList", result.getJsonArray());
		return "busiArea/busiAreaIndex";	
	}
	
	/**
	 * 商圈添加
	 * @param map
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "addBusiArea")
	public String addBusiArea(@RequestParam Map<String,Object> params) throws IOException {
		ResultValue result = addrService.access("busiArea/busiAreaService.addBusiArea", params);
		Integer code = result.getCode();
		if(code == 0){
			result.setData(code.toString());
		};
		return result.getData();
	}
	
	/**
	 * 商圈列表页面
	 * 
	 */
	@ResponseBody 
	@RequestMapping(value = "getBusiAreaQCPage")
	public String getBusiAreaQCPage(@RequestParam Map<String,Object> params){
		String currentPage = params.get("page").toString();
		String rowCount = params.get("rows").toString();
		params.put("currentPage", currentPage);
		params.put("rowCount", rowCount);
		ResultValue access = addrService.access("busiArea/busiAreaService.getBusiAreaQCPage", params);
		return access.getData();
	}
	/**
	 * 商圈列表修改页面
	 * 
	 */
	@RequestMapping(value = "updateBusiIndex")
	public String  getBusiAreaList(ModelMap model,@RequestParam Map<String,Object> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		//初始化区划
		ResultValue busiZoninglist = addrService.access("busiArea/busiAreaService.getbusiZoningAll",params);
		model.addAttribute("busiZoninglist", busiZoninglist.getJsonArray());
		//初始化行政区
		ResultValue result = addrService.access("area/areaService.getAreaList",params);
		model.addAttribute("provinceList", result.getJsonArray());
		//初始化修改属性
		String busiAreaId = (String) params.get("busiAreaId");
		String look = (String) params.get("isFlag");
		if(!look.equals("")){
			model.addAttribute("isFlag", look);
		}
		if(busiAreaId != null && !busiAreaId.equals("")){
			ResultValue BusiArea = addrService.access("busiArea/busiAreaService.getBusiArea",params);
			model.addAttribute("busiArea", BusiArea.getJsonObject());
			//获取大商圈
			JSONObject jsonObject = BusiArea.getJsonObject();
			Object  busiZoningId = jsonObject.get("busiZoningId");
			map.put("busiZoningId", busiZoningId);
			ResultValue BusiAreajudge = addrService.access("busiArea/busiAreaService.getBusiArea",map);
			model.addAttribute("BusiAreajudge", BusiAreajudge.getJsonObject());
			map.clear();
			map.put("busiAreaId", Integer.parseInt(busiAreaId));
			ResultValue premisesCount = addrService.access("busiArea/busiAreaService.getPremisesCount",map);
			model.addAttribute("premisesCount", premisesCount.getData());
		}
		return "busiArea/addbusiOrUpdateAreaIndex";
	}
	
	/**
	 * 商圈修改
	 * @param map
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "updateBusiArea")
	public String updateBusiArea(@RequestParam Map<String,Object> params) throws IOException {
		ResultValue result = addrService.access("busiArea/busiAreaService.updateBusiArea", params);
		Integer code = result.getCode();
		if(code == 0){
			result.setData(code.toString());
		};
		return result.getData();
	}
	
	/**
	 * 商圈删除
	 * @param map
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "deleteBusiArea")
	public String deleteBusiArea(@RequestParam Map<String,Object> params) throws IOException {
		ResultValue result = addrService.access("busiArea/busiAreaService.deleteBusiArea", params);
		Integer code = result.getCode();
		if(code == 0){
			result.setData(code.toString());
		};
		return result.getData();
	}
	
	/**
	 * 根据区划id显示行政区(杭州所有行政区)
	 * @param map
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "getAdminAreaList")
	public String getAdminAreaList(@RequestParam Map<String,Object> params) throws IOException {
		//初始化行政区
		params.put("eareId",934);
		ResultValue result = addrService.access("area/areaService.getAreaList",params);
		return result.getJsonArray().toString();
	}
	/**
	 * 根据区划id显示行政区(区划下的行政区)
	 * @param map
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "getbuisAdminList")
	public String getbuisAdminList(@RequestParam Map<String,Object> params) throws IOException {
		//初始化行政区
		ResultValue result = addrService.access("busiArea/busiAreaService.getBusiArea",params);
	return result.getJsonObject().toString();
	}
	
	/**
	 * 获取要修改商圈列表
	 * @return  List<BusiAreaModel>
	 */
	@ResponseBody
	@RequestMapping(value = "getBusiName")
	public String getBusiName(@RequestParam Map<String,Object> map) {
		 ResultValue result = addrService.access("busiArea/busiAreaService.getBusiName",map);
		 return result.getData();
	}
	/**
	 * 模糊查询获取商圈列表
	 * @return  List<BusiAreaModel>
	 */
	@ResponseBody
	@RequestMapping(value = "getBusiNameList")
	public String getBusiNameList(@RequestParam Map<String,Object> map) {
		 ResultValue result = addrService.access("busiArea/busiAreaService.getBusiNameList",map);
		 return result.getData();
	}
	
	/**
	 * 获取大商圈列表
	 * @return  List<BusiAreaModel>
	 */
	@ResponseBody
	@RequestMapping(value = "getParentBusiAreaList")
	public String getParentBusiAreaList(@RequestParam Map<String,Object> map) {
		 ResultValue result = addrService.access("busiArea/busiAreaService.getParentBusiAreaList",map);
		 return result.getData();
	}
	
	/**
	 * 获取小商圈列表
	 * @return  List<BusiAreaModel>
	 */
	@ResponseBody
	@RequestMapping(value = "getBusiAreaList")
	public String getBusiAreaList(@RequestParam Map<String,Object> map) {
		 ResultValue result = addrService.access("busiArea/busiAreaService.getBusiAreaList",map);
		 return result.getData();
	}
}
