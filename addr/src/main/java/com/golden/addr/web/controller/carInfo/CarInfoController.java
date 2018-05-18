package com.golden.addr.web.controller.carInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author sy
 * 类名称：楼盘Controller
 * 类描述：楼盘信息显示
 * 时间：2016-10-10
 */

@Controller
@RequestMapping(value="carInfo")
public class CarInfoController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	/**
	 * 车位信息列表页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getCarInfo")
	public String getCarInfo(HttpServletRequest request,@RequestParam Map<String, Object> param) throws IOException{
		request.setAttribute("id",param.get("id").toString());
		return "carInfo/car_table";
	}
	
	/**
	 * 获取车位信息列表数据
	 */
	@ResponseBody
	@RequestMapping(value = "getParkList")
	public String getParkList(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = addrService.access("carPort/carPortService.getCarPortListForPage", param);
		return result.getData();
	}
	/**
	 * 查看-相当于修改页
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "updateCarInfo")
	public String updateCarInfo(HttpServletRequest request){
		String id = request.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		ResultValue result = addrService.access("carPort/carPortService.getCarPortById", map);
		request.setAttribute("carPort", result.getJsonObject());
		return "carInfo/edit_carInfo";
	}
	/**
	 * 查看-相当于修改操作
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="updateCarPort")
	public String updateCarPort(@RequestParam Map<String,Object> map){
		//String id = request.getParameter("id");
		ResultValue result = new ResultValue();
		result = addrService.access("carPort/carPortService.updateCarPortById", map);
		return result.getData();
	}
	
	/**
	 * 查看-相当于修改页——添加跟进
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "addFollow")
	public String addFollow(){
		return "carInfo/add_follow";
	}
	
	/**
	 * 添加跟进(新增)
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addCarPortRecord")
	public String addCarPortRecord(@RequestParam Map<String,Object> map,HttpSession session){
		map.put("userName", session.getAttribute("userName").toString());
		ResultValue result = addrService.access("carPortRecord/carPortRecordService.insertCarPortRecord", map);
		return result.getData();
	}
	
	/**
	 * 跟进列表数据
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCarPortRecordList")
	public String getCarPortRecordList(@RequestParam Map<String, Object> param){
		ResultValue result = addrService.access("carPortRecord/carPortRecordService.getCarPortRecordListById", param);
		return result.getData();
	}
	/**
	 * 转为出租(访问页面)
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "turnRent")
	public String turnRent(HttpServletRequest request){
		String id = request.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		//取得列表的每一个字段，在转为出租的初始页面使用
		ResultValue result = addrService.access("carPort/carPortService.getCarPortById", map);//页面初始化数据
		ResultValue sourceResult = addrService.access("ownerSource/ownerSourceService.getParentSources", null);//转为出租,字段“来源”数据
		request.setAttribute("leaseCarPort", result.getJsonObject());
		request.setAttribute("parentSourceList", sourceResult.getJsonArray());
		request.setAttribute("id", id);
		return "carInfo/turn_rent";
	}
	/**
	 * 转为出售(访问页面)
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "turnSell")
	public String turnSell(HttpServletRequest request){
		String id = request.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		//取得列表的每一个字段，在转为出租的初始页面使用
		ResultValue result = addrService.access("carPort/carPortService.getCarPortById", map);//页面初始化数据
		ResultValue sourceResult = addrService.access("ownerSource/ownerSourceService.getParentSources", null);//转为出租,字段“来源”数据
		request.setAttribute("leaseCarPort1", result.getJsonObject());
		request.setAttribute("parentSourceList1", sourceResult.getJsonArray());
		request.setAttribute("id", id);
		return "carInfo/turn_sell";
	}
	
	/**
	 * 添加车位页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value ="addCarPark")
	public String addCarPark(HttpServletRequest request){
		String id = request.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("premisesId", id);
		return "carInfo/add_carpark";
	}
	/**
	 * 车位唯一校验
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getCarPortIds")
	public String getCarPortIds(@RequestParam Map<String,Object> params){
		ResultValue result = new ResultValue();
		result = addrService.access("carPort/carPortService.getCarPortIs",params);
		return result.getData();
	}
	
	/**
	 * 单个、批量添加车位(新增)
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveCarPort")
	public String saveCarPort(@RequestParam Map<String,Object> map){
		String away = map.get("away").toString();
		//判断是单个添加还是批量添加 1 单个添加
		if(away.equals("1")){
			ResultValue result = addrService.access("carPort/carPortService.insertCarPort", map);
			return result.getData();
		}else{
			ResultValue result = addrService.access("carPort/carPortService.insertCarPorts",map);
			return result.getData();
		}
	}
	
	/**
	 * 车位信息列表页的关联房间
	 * @param params
	 * @return
	 */
	@RequestMapping(value= "linkRoom")
	public String linkRoom(@RequestParam Map<String,Object> params,ModelMap model) throws IOException {
		String id = params.get("id").toString();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("premisesId",id);
		ResultValue groupResult = addrService.access("carPort/carPortService.getGroupsByPremisesId",map);
		JSONArray json = groupResult.getJsonArray();
		if(json.isEmpty()){
			ResultValue buildingResult = addrService.access("carPort/carPortService.getBuildingsByPremisesId",map);
			model.addAttribute("flag", "0");//楼栋分组不存在
			model.addAttribute("buildingList", buildingResult.getJsonArray());//楼栋list
		}else{
			model.addAttribute("flag", "1");//楼栋分组存在
			model.addAttribute("groupList", groupResult.getJsonArray());//栋座list
		}
		model.addAttribute("id",id);
		return "carInfo/link_room";
	}
	
	/**
	 * 楼栋 下拉列表
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "buildingList")
	@ResponseBody
	public String buildingList(@RequestParam Map<String,Object> params){
		ResultValue result = addrService.access("carPort/carPortService.getBuildingsByGroupId",params);
		return result.getData();
	}
	
	/**
	 * 单元 下拉列表
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getUnitList")
	@ResponseBody
	public String getUnitList(@RequestParam Map<String,Object> params){
		ResultValue result = addrService.access("carPort/carPortService.getUnitsByBuildingId",params);
		return result.getData();
	}
	
	/**
	 * 获取关联房间列表数据
	 */
	@ResponseBody
	@RequestMapping(value = "getCarList")
	public String getCarList(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("carPort/carPortService.getRoomList", map);
		return result.getData();
	}
	
	/**
	 * 点击关联按钮触发关联事件
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "contactRoom")
	public String contactRoom(@RequestParam Map<String,Object> map,HttpSession session){
		map.put("userName", session.getAttribute("userName").toString());
		ResultValue result = addrService.access("carPort/carPortService.contactRoomByPortId", map);
		return result.getData();
	}
	
	/**
	 * 批量删除车位
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delCarPark")
	public String delCarPark(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("carPort/carPortService.deleteCarPorts", map);
		return result.getData();
	}
	
	/**
	 * 解除关联
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeRoom")
	public String removeRoom(@RequestParam Map<String, Object> map,HttpSession session){
		map.put("userName", session.getAttribute("userName").toString());
		ResultValue result = addrService.access("carPort/carPortService.removeRoomIdByPortId", map);
		return result.getData();
	}
	
	/**
	 * 转为出租(保存)
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "turnRentInsert")
	public String turnRentInsert(@RequestParam Map<String, Object> map,HttpSession session){
		map.put("userId", AihomeConst.SESSION_USER_ID_KEY);
		map.put("userName", AihomeConst.SESSION_USER_NAME_KEY);
		map.put("orgCode", AihomeConst.SESSION_ORG_CODE_KEY);
		ResultValue result = addrService.access("carPort/carPortService.insertHouseLeaseWithCarPort", map);
		return result.getData();
	}
	
	/**
	 * 转为出售(保存)
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "turnSellInsert")
	public String turnSellInsert(@RequestParam Map<String, Object> map,HttpSession session){
		map.put("userId", AihomeConst.SESSION_USER_ID_KEY);
		map.put("userName", AihomeConst.SESSION_USER_NAME_KEY);
		map.put("orgCode", AihomeConst.SESSION_ORG_CODE_KEY);
		ResultValue result = addrService.access("carPort/carPortService.insertHouseSaleWithCarPort", map);
		return result.getData();
	}
	/**
	 * 转为出租(字段“来源”子数据)
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSourcesByParentId")
	public String getSourcesByParentId(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("ownerSource/ownerSourceService.getSourcesByParentId", map);
		return result.getData();
	}
	/**
	 * 查询车位是否已出租
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "carPortLeasedIs")
	public String carPortLeasedIs(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("carPort/carPortService.carPortLeasedIs", map);
		return result.getData();
	}
	/**
	 * 查询车位是否已出售
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "carPortSaledIs")
	public String carPortSaledIs(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("carPort/carPortService.carPortSaledIs", map);
		return result.getData();
	}
	/**
	 * 批量删除车位
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteCarPortByIds")
	public String deleteCarPortByIds(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("carPort/carPortService.deleteCarPortByIds", map);
		return result.getData();
	}
	
}
