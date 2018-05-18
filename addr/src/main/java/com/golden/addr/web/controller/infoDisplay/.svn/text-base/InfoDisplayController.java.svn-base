package com.golden.addr.web.controller.infoDisplay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author sy
 * 类名称：楼盘Controller
 * 类描述：楼盘信息显示
 * 时间：2016-10-10
 */

@Controller
@RequestMapping(value="infoDisplay")
public class InfoDisplayController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	/**
	 * 打开信息展示页
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request,@RequestParam Map<String, Object> param) throws IOException{
		request.setAttribute("id", param.get("id").toString());
		request.setAttribute("areaId", param.get("areaId").toString());
		request.setAttribute("addBuilding", param.get("addBuilding"));
		return "infoDisplay/info_main";
	}
	/**
	 * 价格信息展示页
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "priceInfo")
	public String priceInfo(){
		return "infoDisplay/info_price";
	}
	/**
	 * 周边地图展示页
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "aroundMap")
	public String aroundMap(HttpServletRequest request,@RequestParam Map<String,Object> map)throws IOException{
		request.setAttribute("id", map.get("id").toString());
		map.put("premisesId", map.get("id"));
		ResultValue basePremisesModel = addrService.access("basePremises/basePremisesService.queryPremises", map);
		request.setAttribute("basePremisesModel", basePremisesModel.getJsonObject());
		if(map.get("type")!=null){
			request.setAttribute("type",map.get("type").toString());
		}
		return "infoDisplay/info_Around_Map";
	}
	/**
	 * 获取楼盘中心店
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "eidtMap")
	public String eidtMap(HttpServletRequest request,@RequestParam Map<String,Object> map)throws IOException{
		ResultValue basePremisesModel = addrService.access("basePremises/basePremisesService.queryPremises", map);
		request.setAttribute("basePremisesModel", basePremisesModel.getJsonObject());
		return "infoDisplay/info_Around_Map_open";
	}
	
	/**
	 * 更新楼盘信息添加经纬度
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updatePremisesLable")
	public String updatePremisesLable(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("basePremises/basePremisesService.updatePremises", map);
		return result.getData();
	}
	/**
	 * @return 约带看页面
	 * @throws IOException
	 */
	@RequestMapping(value = "arrangeLook")
	public String arrangeLook(HttpServletRequest request) throws IOException {
		return "infoDisplay/info_arrange_look";
	}
	/**
	 *  约带看页面分页查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesParrLookListPage")
	public String getPremisesParrLookListPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = addrService.access("premisesParrLook/premisesParrLookService", map);
		return result.getData();
	}
	/**
	 * 逻辑删除约带看
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateArrangeLookStatus")
	public String updateArrangeLookStatus(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("premisesParrLook/premisesParrLookService.updateParrLook", map);
		return result.getData();
	}
	
	/**
	 * 模糊楼盘名称 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesNameByMatch")
	public String getPremisesNameByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("premisesParrLook/premisesParrLookService.geteduNameByMatch", map);
		return result.getData();						
	}
	
	/**
	 * 模糊客户编号或客户名称
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "")
	public String 啊 (@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("education/EduService.geteduNameByMatch", map);
		return result.getData();						
	}
	/**
	 * @return 约带看取消模态
	 * @throws IOException
	 */
	@RequestMapping(value = "cancel")
	public String cancel(HttpServletRequest request) throws IOException {
		return "infoDisplay/info_arrange_open";
	}
	
	/**
	 * 楼盘信息展示
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getInfo")
	public String getInfo(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", request.getParameter("id"));
		ResultValue result = addrService.access("basePremises/basePremisesService.getPemisesInfoById", map);
		request.setAttribute("info", result.getJsonObject());
		request.setAttribute("premisesId", request.getParameter("id").toString());
		//楼盘图片
		ResultValue imgResult = addrService.access("basePremises/basePremisesService.getPemisesImages", map);
		request.setAttribute("infoImgList", imgResult.getJsonArray().toString());
		return "infoDisplay/info_display";
	}
}
