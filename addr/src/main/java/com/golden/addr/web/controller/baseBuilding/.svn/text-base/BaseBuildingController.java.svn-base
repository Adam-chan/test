package com.golden.addr.web.controller.baseBuilding;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
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
@RequestMapping(value = "baseBuilding")
public class BaseBuildingController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	/**
	 * @return 栋座首页
	 * @throws IOException
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model,@RequestParam Map<String,Object> param) throws IOException {
		
		model.addAttribute("premisesId", param.get("premisesId"));

		Map<String,Object> map = new  HashMap<String,Object>();
		map.put("premisesId", param.get("premisesId"));
		ResultValue basePremisesModel = addrService.access("baseBuilding/baseBuildingService.getPremises", map);
		model.addAttribute("basePremises", basePremisesModel.getJsonObject());
		model.addAttribute("areaId", param.get("areaId"));
		//eduIds(教育设施) name（楼盘名字）
		return "baseBuilding/BaseBuilding_main";
	}
	/**
	 * @return 栋座保存 Ajax
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "saveBuilding")
	public String saveBlock(@RequestParam Map<String,Object> params) throws IOException {
 		ResultValue result = addrService.access("baseBuilding/baseBuildingService.insertSelective",params);
 		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	
	
	/**
	 * @return 左侧导航及中部数据
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesMenuPage")
	public String getSelectList(@RequestParam Map<String,Object> param) throws IOException {
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.getPremisesMenuPage", param);
		return result.getData();
	} 
	
	/**
	 * @return 批量添加楼栋
	 * @throws IOException
	 */
	@RequestMapping(value = "addBuilding")
	public String addBuilding(ModelMap model,@RequestParam Map<String,Object> param) throws IOException {
		Map<String,Object> map = new HashMap<String, Object>();
		//行政区id、级别
		map.put("eareId", 934);
		map.put("areaLevel",3);
		//获取行政区下拉列表
		ResultValue resultArea = addrService.access("area/areaService.getAreaList",map);
		model.addAttribute("AreaList",resultArea.getJsonArray());
		map.clear();
		//获取楼盘实体
		map.put("premisesId",param.get("premisesId") );
		ResultValue basePremisesModel = addrService.access("baseBuilding/baseBuildingService.getPremises", map);
		model.addAttribute("basePremises", basePremisesModel.getJsonObject());
		map.clear();
		//获取教育设施名字的数组
		if(basePremisesModel.getJsonObject().get("eduIds")!=null && basePremisesModel.getJsonObject().get("eduIds")!=""){
			map.put("inIds", basePremisesModel.getJsonObject().get("eduIds"));
			ResultValue eduList = addrService.access("basePremises/basePremisesService.getEduListByMatch", map);
			model.addAttribute("eduList", eduList.getJsonArray());
		}
		//楼盘id
		model.addAttribute("premisesId", param.get("premisesId"));
		//楼盘行政区
		model.addAttribute("eareId", Integer.parseInt(param.get("areaId").toString()));
		//获取楼盘分组
		ResultValue access = addrService.access("baseBuilding/baseBuildingService.getBuildingGroupList",param);
		model.addAttribute("groupList",access.getJsonArray());
		
		return "baseBuilding/add_Check_Building_Table";
	}
	
	@RequestMapping(value = "updateInfo")
	public String updateInfo(){
		return "baseBuilding/updateInfo";
		
	}
	
	/**
	 * @return 模糊查询分组
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "getBuildingGroupList")
	public String getBuildingGroupList(@RequestParam Map<String,Object> param) throws IOException {		
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.getBuildingGroupList",param);
   		return result.getData();
	}
	
	/**
	 * 添加分组初始化页面
	 * @return 
	 */
	@RequestMapping(value = "addGroupIndex")
	public String addGroup(ModelMap model,@RequestParam Map<String,Object> param){		
		model.addAttribute("premisesId", param.get("premisesId"));
   		return "baseBuilding/add_Group";
	}
	/**
	 * 批量添加分组
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "addBatchGroup")
	public String insertBatchGroup(@RequestParam Map<String,Object> param) throws IOException {		
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.insertBatch",param);
   		return result.getData();
	}
	
	/**
	 * 校验名字是否重复
	 * @param param{groupName：groupName} or param{updateGroupName:updateGroupName,groupId:groupId}
	 * @return Integer
	 */
	@ResponseBody
	@RequestMapping(value = "getGroupNum")
	public String getGroupNum(@RequestParam Map<String, Object> param){
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.getGroupNum",param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	
	/**
	 * 删除楼栋和分组
	 */
	@ResponseBody
	@RequestMapping(value = "delGroupBuild")
	public String delGroupBuild(@RequestParam Map<String, Object> param){
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.delGroupBuild",param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	
	
	/**
	 * 保存修改的分组和楼栋
	 */
	@ResponseBody
	@RequestMapping(value = "updateGroupBuilding")
	public String updateGroupBuilding(@RequestParam Map<String, Object> param){
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.updateGroupBuilding",param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	
	/**
	 * 根据id修改楼栋的数据
	 */
	@RequestMapping(value = "updateBuildingIndex")
	public String updateBuildingIndex(ModelMap model,@RequestParam Map<String, Object> param){
		//获取楼栋信息
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.getBuilding",param);
		model.addAttribute("building", result.getJsonObject());
		model.addAttribute("premisesName", param.get("premisesName"));
		model.addAttribute("premisesId", param.get("premisesId"));
		//获取楼盘分组
		ResultValue access = addrService.access("baseBuilding/baseBuildingService.getBuildingGroupList",param);
		model.addAttribute("groupList",access.getJsonArray());
		return "baseBuilding/update_Building";
	}
	/**
	 * 根据id修改楼栋的数据
	 */
	@ResponseBody
	@RequestMapping(value = "updateBuilding")
	public String updateBuilding(@RequestParam Map<String, Object> param){
		ResultValue result = addrService.access("baseBuilding/baseBuildingService.updateBuilding",param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}

	
	/**
	 * 单元添加
	 */
	@ResponseBody
	@RequestMapping(value = "addRoom")
	public String creatRoom(@RequestParam Map<String, Object> params) {
		ResultValue result = addrService.access("buildingUnits/buildingUnitsService.insertBatch", params);
		return result.getData();
	}
	
	/**
	 * 跳转商铺页面
	 */
	@RequestMapping(value = "storeIndex")
	public String storeIndex(ModelMap model,@RequestParam Map<String, Object> param){
		//楼盘、分组、楼栋
		model.addAttribute("premisesName", param.get("premisesName"));
		model.addAttribute("premisesId", param.get("premisesId"));
		model.addAttribute("groupName", param.get("groupName"));
		model.addAttribute("groupId", param.get("groupId"));
		model.addAttribute("buildingName", param.get("buildingName"));
		model.addAttribute("buildingId", param.get("buildingId"));
		return "baseBuilding/storeIndex";
	}
	
	/**
	 * 跳转商铺添加或修改页面
	 */
	@RequestMapping(value = "addOrUpdateStoreIndex")
	public String addOrUpdateStoreIndex(ModelMap model,@RequestParam Map<String, Object> param){
		//标示1添加2为修改
		Integer isFlag = 1;
		Map<String, Object> map = new HashMap<String,Object>();
		//楼盘、分组、楼栋
		model.addAttribute("premisesName", param.get("premisesName"));
		model.addAttribute("premisesId", param.get("premisesId"));
		model.addAttribute("groupName", param.get("groupName"));
		model.addAttribute("groupId", param.get("groupId"));
		model.addAttribute("buildingName", param.get("buildingName"));
		model.addAttribute("buildingId", param.get("buildingId"));
		Object baseHouseId = param.get("baseHouseId");
		
		if(baseHouseId!=null){
			map.put("baseHouseId",baseHouseId);
			ResultValue result = addrService.access("baseHouse/baseHouseService", map);
			model.addAttribute("baseHouse", result.getJsonObject());
			isFlag = 2;
		}
		model.addAttribute("isFlag",isFlag);
		return "baseBuilding/addOrUpdateStoreIndex";
	}
	
	/**
	 * 添加商铺
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "addStore")
	public String addStore(@RequestParam Map<String, Object> param) throws UnsupportedEncodingException{
		param.put("proprietor", param.get("proprietor"));
		ResultValue result = addrService.access("baseHouse/baseHouseService.insertSelective", param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	
	/**
	 *修改商铺 
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "updateStore")
	public String updateStore(@RequestParam Map<String, Object> param) throws UnsupportedEncodingException{
		param.put("proprietor",  URLEncoder.encode(param.get("proprietor").toString(), "UTF-8"));
		ResultValue result = addrService.access("baseHouse/baseHouseService.updatebaseHouse", param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	/**
	 * 获取单元编辑页面数据
	 */
	@ResponseBody
	@RequestMapping(value = "getEditUnit")
	public String getEditUnit(ModelMap model,@RequestParam Map<String, Object> params){
		ResultValue result = addrService.access("buildingUnits/buildingUnitsService.geteditUnit", params);
		return result.getData();
	}
	
	/**
	 * 根据楼栋id获取商铺分页数据
	 */
	@ResponseBody
	@RequestMapping(value = "getStorePage")
	public String getHousePage(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = addrService.access("baseHouse/baseHouseService.getStorePage", param);
		return result.getData();
	}
	/**
	 * 删除单元id
	 */
	@ResponseBody
	@RequestMapping(value = "delUnit")
	public String delUnit(@RequestParam Map<String, Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.deletebuildingUnits", param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	/**
	 * 批量删除商铺
	 */
	@ResponseBody
	@RequestMapping(value = "delStore")
	public String delStore(@RequestParam Map<String, Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.deletebaseHouse", param);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
	/**
	 * 删除单元
	 */
	@ResponseBody
	@RequestMapping(value = "deletebuildingUnits")
	public String deletebuildingUnits(@RequestParam Map<String, Object> params){
		ResultValue result = addrService.access("buildingUnits/buildingUnitsService.deletebuildingUnits", params);
		return result.getData();
	}
	/**
	 * 修改单元页面
	 */
	@RequestMapping(value = "updateUnitIndex")
	public String updateUnitIndex(ModelMap model,@RequestParam Map<String, Object> params){
		ResultValue buildingUnit = addrService.access("buildingUnits/buildingUnitsService", params);
		model.addAttribute("unit", buildingUnit.getJsonObject());
		model.addAttribute("groupName", params.get("groupName"));
		model.addAttribute("buildingName", params.get("buildingName"));
		model.addAttribute("premisesName", params.get("premisesName"));
		return "baseBuilding/update_unit";
	}
	 /**
	  * 修改单元信息
	  */
	@ResponseBody
	@RequestMapping(value = "updateUnits")
	public String updateUnits(@RequestParam Map<String, Object> params){
		ResultValue result = addrService.access("buildingUnits/buildingUnitsService.updatebuildingUnits", params);
		return result.getData();
	}
	
	/**
	 * 批量修改房间页面
	 */
	@RequestMapping(value = "batchUpdateHouseIndex")
	public String batchUpdateHouseIndex(ModelMap model,@RequestParam Map<String, Object> params){
		model.addAttribute("houseIds", params.get("houseIds"));
		return "baseBuilding/batch_Update_House";
	}
	
	/**
	 * 批量修改房
	 */
	@ResponseBody
	@RequestMapping(value = "batchUpdateHouse")
	public String batchUpdateHouse(@RequestParam Map<String, Object> params){
		ResultValue result = addrService.access("baseHouse/baseHouseService.batchUpdateHouse", params);
		Integer code = result.getCode();
		if(code==0){
			result.setData(code.toString());
		}
		return result.getData();
	}
}
