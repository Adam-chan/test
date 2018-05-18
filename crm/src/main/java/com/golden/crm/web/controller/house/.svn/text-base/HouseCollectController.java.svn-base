package com.golden.crm.web.controller.house;

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
 * 收藏房源
 * @author sy
 * 时间：2016-11-30
 */
@Controller
@RequestMapping(value="houseCollect")
public class HouseCollectController {

	@Resource(name = "crmService")
	private IServiceStore crmService;
	
	@Resource(name = "oaService")
	private OAService oaService;
	
	/**
	 * 初始化房源收藏页面 sy
	 * @param map 
	 * @return
	 */
	@RequestMapping(value = "houseCollectIndex")
	public String getHouseCollectTable(HttpServletRequest request,@RequestParam Map<String, Object> map){
		request.setAttribute("quOrgList", oaService.getQuOrgList());//OA组织结构
		return "houseCollect/house_collect";
	}
	
	/**
	 * 分页查询房源收藏 sy
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseCollectListForPage")
	public String getHouseCollectListForPage(@RequestParam Map<String,Object> map){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		ResultValue result = crmService.access("house/houseCollectService.getHouseCollectListForPage", map);
		return result.getData();
	}
	/**
	 * 取消房源收藏  sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteCollectByIds")
	public String deleteCollectByIds(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseCollectService.deleteCollectByIds", map);
		return result.getData();
	}
}
