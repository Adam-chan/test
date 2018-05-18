package com.golden.addr.web.controller.baseHouse;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

@Controller
@RequestMapping(value = "baseHouse")
public class BaseHouseController {
	@Resource(name="addrService")
	private IServiceStore addrService;
	
	/**
	 * 获取
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoomInfo")
	public String getRoomInfo(@RequestParam Map<String,Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.getRoomsInfo", param);
		return result.getData();
	}
	
	@ResponseBody
	@RequestMapping(value = "saveEchoedRoom")
	public String saveEchoedRoom(@RequestParam Map<String,Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.updateHouseStatus", param);
		return result.getData();
	}
	
	/**
	 * 跳转新增页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "restoreRoom")
	public String restoreRoom(ModelMap model,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		param.put("buildingId", buildingId);
		ResultValue unitResult = addrService.access("baseHouse/baseHouseService.getUnitsInfo", param);
		param.clear();
		param.put("baseBuildingId", buildingId);
		ResultValue buildingResult = addrService.access("baseHouse/baseHouseService.getBuildingInfo", param);
		map.put("premisesName", request.getParameter("premisesName"));
		map.put("gName", request.getParameter("gName"));
		map.put("bName", request.getParameter("bName"));
		map.put("buildingId", buildingId);
		map.put("premisesId", request.getParameter("premisesId"));
		map.put("groupId", request.getParameter("groupId"));

		model.addAttribute("unitCodeList", unitResult.getJsonArray());
		model.addAttribute("buildingInfo", buildingResult.getJsonObject());
		model.addAttribute("restoreRoomNames", map);
		return "baseBuilding/add_House";
	}
	
	/**
	 * 获取单元信息
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getUnitsInfo")
	public String getUnitInfo(@RequestParam Map<String,Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.getUnitsInfo", param);
		return result.getData();
	}
	
	/**
	 * 获取匹配房间
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoomsMatchFloor")
	public String getRoomsMatchFloor(@RequestParam Map<String,Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.getRoomsMatchFloor", param);
		return result.getData();
	}
	
	/**
	 * 单个添加
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "singleRestoreRoom")
	public String singleRestoreRoom(@RequestParam Map<String,Object> param) throws UnsupportedEncodingException{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("status", 1);
		if(!"".equals(param.get("singleOrientationsNm"))){
			map.put("orientation", URLDecoder.decode((String) param.get("singleOrientationsNm"), "UTF-8"));
		}
		if(!"".equals(param.get("singleBuildingAreaNm"))){
			map.put("coveredArea", Integer.parseInt((String) param.get("singleBuildingAreaNm")));
		}
		Object roomObj = param.get("singleBedroomNm");
		Object hallObj = param.get("singleLivingRoomNm");
		Object defendObj = param.get("singleToiletNm");
		Object kitchenObj = param.get("singleKitchenNm");
		StringBuffer houseType= new StringBuffer("");
		if(roomObj != null && !roomObj.equals("")){
			houseType.append((roomObj.toString()+"室"));
		}else{
			houseType.append(("0室"));
		}
		if(hallObj != null && !hallObj.equals("")){
			houseType.append((hallObj.toString()+"厅"));
		}else{
			houseType.append(("0厅"));
		}
		if(defendObj != null && !defendObj.equals("")){
			houseType.append((defendObj.toString()+"卫"));
		}else{
			houseType.append(("0卫"));
		}
		if(kitchenObj != null && !kitchenObj.equals("")){
			houseType.append((kitchenObj.toString()+"厨"));
		}else{
			houseType.append(("0厨"));
		}
		map.put("houseType", houseType.toString());
		if(!"".equals(param.get("singleDecorationNm"))){
			map.put("decoration", (String) param.get("singleDecorationNm"));
		}
		if(!"".equals(param.get("singleUseAreaNm"))){
			map.put("useLand", (String) param.get("singleUseAreaNm"));
		}
		if(!"".equals(param.get("singlePurposeNm"))){
			map.put("purpose", (String) param.get("singlePurposeNm"));
		}
		if(!"".equals(param.get("singleNatureNm"))){
			map.put("houseNature", (String) param.get("singleNatureNm"));
		}
		if(!"".equals(param.get("singleYearsNm"))){
			map.put("landLimit", (String) param.get("singleYearsNm"));
		}
		if(!"".equals(param.get("singleOwnerPhoneNm"))){
			map.put("contactPhone", (String) param.get("singleOwnerPhoneNm"));
		}
		if(!"".equals(param.get("singleOwnersNameNm"))){
			map.put("proprietor", URLDecoder.decode((String) param.get("singleOwnersNameNm"), "UTF-8"));
		}
		map.put("baseHouseIds", Long.parseLong((String) param.get("singleRoomNumNm")));
		ResultValue result = addrService.access("baseHouse/baseHouseService.singleRestoreRoom", map);
		return result.getData();
	}
	
	/**
	 * 批量新增房间
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "batchRestoreRoom")
	public String batchRestoreRoom(@RequestParam Map<String,Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.batchRestoreRoom", param);
		return result.getData();
	}

	@RequestMapping(value = "editHousePage")
	public String editHousePage(ModelMap model,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String,Object>();
		Map<String, Object> headInfo = new HashMap<String,Object>();
		Map<String, Object> typeObj = new HashMap<String,Object>();
		headInfo.put("buildingId", request.getParameter("buildingId"));
		headInfo.put("premisesName", request.getParameter("premisesName"));
		headInfo.put("groupName", request.getParameter("groupName"));
		headInfo.put("groupId", request.getParameter("groupId"));
		headInfo.put("premisesId", request.getParameter("premisesId"));
		headInfo.put("buildingName", request.getParameter("buildingName"));
		headInfo.put("houseId", request.getParameter("houseId"));
		headInfo.put("houseName", request.getParameter("houseName"));
		map.put("baseHouseId", request.getParameter("houseId"));
		ResultValue result = addrService.access("baseHouse/baseHouseService.execute", map);
		if(!"".equals(result.getJsonObject().get("houseType")) && result.getJsonObject().get("houseType")!= null){
			if(result.getJsonObject().get("houseType").toString().indexOf("室")>-1){
				typeObj.put("bedRoom", result.getJsonObject().get("houseType").toString().substring(0, result.getJsonObject().get("houseType").toString().indexOf("室")));
			}
			if(result.getJsonObject().get("houseType").toString().indexOf("厅")>-1){
				typeObj.put("livingRoom", result.getJsonObject().get("houseType").toString().substring(result.getJsonObject().get("houseType").toString().indexOf("室")+1, result.getJsonObject().get("houseType").toString().indexOf("厅")));
			}
			if(result.getJsonObject().get("houseType").toString().indexOf("卫")>-1){
				typeObj.put("toilet", result.getJsonObject().get("houseType").toString().substring(result.getJsonObject().get("houseType").toString().indexOf("厅")+1, result.getJsonObject().get("houseType").toString().indexOf("卫")));
			}
			if(result.getJsonObject().get("houseType").toString().indexOf("厨")>-1){
				typeObj.put("kitchen", result.getJsonObject().get("houseType").toString().substring(result.getJsonObject().get("houseType").toString().indexOf("卫")+1, result.getJsonObject().get("houseType").toString().indexOf("厨")));
			}
		}
		model.addAttribute("roomInfoObj", result.getJsonObject());
		model.addAttribute("headInfoObj", headInfo);
		model.addAttribute("typeObj", typeObj);
		return "baseBuilding/editHouse";
	}
	
	@ResponseBody
	@RequestMapping(value = "updateEditHouse")
	public String updateEditHouse(@RequestParam Map<String,Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.updateEditHouse", param);
		return result.getData();
	}
	
	@ResponseBody
	@RequestMapping(value = "houseSource")
	public String houseSource(@RequestParam Map<String,Object> param){
		ResultValue result = addrService.access("baseHouse/baseHouseService.getHouseSource", param);
		return result.getData();
	}
}
