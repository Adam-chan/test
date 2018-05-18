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
 * 类名称：车位信息Controller
 * 时间：2016-11-25
 */

@Controller
@RequestMapping(value="carPort")
public class CarPortController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	/**
	 * 车位信息列表页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getCarInfo")
	public String getCarInfo(HttpServletRequest request,@RequestParam Map<String, Object> param) throws IOException{
		request.setAttribute("premisesId",param.get("id").toString());
		return "carInfo/car_table";
	}
	/**
	 * 添加车位页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value ="addCarPort")
	public String addCarPort(){
		return "carInfo/add_carPort";
	}
	/**
	 * 车位信息分页查询
	 */
	@ResponseBody
	@RequestMapping(value = "getCarPortListForPage")
	public String getCarPortListForPage(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = addrService.access("carPort/carPortService.getCarPortListForPage", param);
		return result.getData();
	}
	/**
	 * 新增
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "insertCarPort")
	public String insertCarPort(@RequestParam Map<String,Object> map){
		String addWays = map.get("addWays").toString();//1单个添加 2批量添加
		if(addWays.equals("1")){
			ResultValue result = addrService.access("carPort/carPortService.insertCarPort", map);
			return result.getData();
		}else{
			ResultValue result = addrService.access("carPort/carPortService.insertCarPorts",map);
			return result.getData();
		}
	}
	/**
	 * 修改
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="updateCarPort")
	public String updateCarPort(@RequestParam Map<String,Object> map){
		ResultValue result = addrService.access("carPort/carPortService.updateCarPortById", map);
		return result.getData();
	}
	/**
	 * 车位唯一校验
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getCarPortIs")
	public String getCarPortIs(@RequestParam Map<String,Object> map){
		ResultValue result = addrService.access("carPort/carPortService.getCarPortIs",map);
		return result.getData();
	}
	/**
	 * 详情页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "carPortDetail")
	public String carPortDetail(HttpServletRequest request,@RequestParam Map<String,Object> map){
		ResultValue result = addrService.access("carPort/carPortService.getCarPortById", map);
		request.setAttribute("carPort", result.getJsonObject());
		return "carInfo/edit_carPort";
	}
	/**
	 * 转为出租、出售(访问页面)
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "turnRentSale")
	public String turnRent(HttpServletRequest request,@RequestParam Map<String, Object> map){
		String type = map.get("type").toString();
		ResultValue result = addrService.access("carPort/carPortService.getCarPortById", map);
		ResultValue sourceResult = addrService.access("ownerSource/ownerSourceService.getParentSources", null);
		ResultValue sysParamMap = addrService.access("sysParam/sysParamService",null);
		request.setAttribute("leaseCarPort", result.getJsonObject());
		request.setAttribute("parentSourceList", sourceResult.getJsonArray());
		request.setAttribute("sysParamMap", sysParamMap.getJsonObject());//房源系统参数
		if(type.equals("rent")){
			return "carInfo/turn_rent";
		}else{
			return "carInfo/turn_sale";
		}
	}
	/**
	 * 转为出租、出售
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "turnRentSaleInsert")
	public String turnRentSaleInsert(@RequestParam Map<String, Object> map,HttpSession session){
		String type = map.get("type").toString();
		ResultValue result = new ResultValue();
		//TODO 刁兰
		//组织结构-登记人 
		map.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));
		map.put("userName", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY));
		map.put("userOrgCode", "02.01.02.01.01.");//组编号
		map.put("userOrg", "东一区1组");//组
		map.put("userQu", "东一区");//区
		map.put("userQuCode", "02.01.02.01.");//区编码
		map.put("userDaQu", "东大区");//大区
		//组织结构-收益分成人（模拟）
		map.put("divideId", "0006746e-c77a-453d-be3b-0fbcaf3d47b2");
		map.put("divideUser", "test2");
		map.put("divideOrg", "西一区1组");//组
		map.put("divideOrgCode", "02.01.01.01.01.");//组编号
		map.put("divideQu", "西一区");//区
		map.put("divideQuCode", "02.01.01.01.");//区编码
		map.put("divideDaQu", "西大区");//大区
		if(type.equals("rent")){
			result = addrService.access("house/houseLeaseService.insertHouseLease", map);
		}else{
			result = addrService.access("house/houseSaleService.insertHouseSale", map);
		}
		return result.getData();
	}
	/**
	 * 根据楼盘id查询楼栋 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBuildingsList")
	public String getBuildingsByPremisesId(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("carPort/carPortService.getBuildingsByPremisesId", map);
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
	 * 楼栋下拉列表
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
	 * 单元下拉列表
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
	 * 解除关联
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeRoom")
	public String removeRoom(@RequestParam Map<String, Object> map,HttpSession session){
		map.put("userId", AihomeConst.SESSION_USER_ID_KEY);
		map.put("userName", AihomeConst.SESSION_USER_NAME_KEY);
		ResultValue result = addrService.access("carPort/carPortService.removeRoom", map);
		return result.getData();
	}
	/**
	 * 业主来源2
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
	/**
	 * 判断车位是否关联房源 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isContactHouseLease")
	public String isContactHouseLease(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("house/houseLeaseService.isContactHouseLease", map);
		return result.getData();
	}
	
}
