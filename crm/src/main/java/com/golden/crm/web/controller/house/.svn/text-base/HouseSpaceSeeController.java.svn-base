package com.golden.crm.web.controller.house;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * 房源空看管理
 * @author sy
 * 时间：2016-11-26
 */
@Controller
@RequestMapping(value="houseSpaceSee")
public class HouseSpaceSeeController {

	@Resource(name = "crmService")
	private IServiceStore crmService;
	
	@Resource(name = "oaService")
	private OAService oaService;
	
	@RequestMapping(value = "houseSpaceSeeIndex")
	public String getHouseSaleTable(HttpServletRequest request,@RequestParam Map<String, Object> map){
		request.setAttribute("quOrgList", oaService.getQuOrgList());//OA组织结构
		return "houseSpaceSee/house_space_see";
	}
	/**
	 * 分页查询 sy
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseSpaceSeeListForPage")
	public String getHouseSpaceSeeListForPage(@RequestParam Map<String,Object> map){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		ResultValue result = crmService.access("house/houseSpaceSeeService.getHouseSpaceSeeListForPage", map);
		return result.getData();
	}
	
	/**
	 * 批量删除空看  sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteSpaceSeeByIds")
	public String deleteSpaceSeeByIds(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseSpaceSeeService.deleteSpaceSeeByIds", map);
		return result.getData();
	}
	
	/**
	 * 所属组弹出框  sy
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "isGroup")
	public String isGroup(HttpServletRequest request,@RequestParam Map<String, Object> param)throws IOException{
	     request.setAttribute("houseInfoId",param.get("houseInfoId").toString());
		 return "houseSpaceSee/house_isgroup";
	}
	
	/**
	 * 非所属组弹出框  sy
	 * @param map
	 * @return
	 */
	
	@RequestMapping(value = "noGroup")
	public String noGroup(HttpServletRequest request,@RequestParam Map<String, Object> param)throws IOException{
		 request.setAttribute("houseInfoId",param.get("houseInfoId").toString());
		 return "houseSpaceSee/house_nogroup";
	}
	/**
	 * 分页查询所属组 sy
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getIsGroupListListForPage")
	public String getIsGroupListListForPage(@RequestParam Map<String,Object> map){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		ResultValue result = crmService.access("house/houseSpaceSeeService.getIsGroupListListForPage", map);
		return result.getData();
	}
	
	/**
	 * 分页查询非所属组 sy
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getNoGroupListListForPage")
	public String getNoGroupListListForPage(@RequestParam Map<String,Object> map){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		ResultValue result = crmService.access("house/houseSpaceSeeService.getNoGroupListListForPage", map);
		return result.getData();
	}
}
