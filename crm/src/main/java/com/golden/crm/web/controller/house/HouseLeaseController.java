package com.golden.crm.web.controller.house;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author dl
 * 类名称：租赁房源管理Controller
 * 时间：2016-11-1
 */
@Controller
@RequestMapping(value="houseLease")
public class HouseLeaseController {
	
	@Resource(name = "crmService")
	private IServiceStore crmService;
	
	@Resource(name = "oaService")
	private OAService oaService;
	/**
	 * 模糊查询详细地址 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAddrDetail")
	public String getAddrDetail(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("house/houseLeaseService.getAddrDetail", map);
		return result.getData();
	}
	/**
	 * 模糊查询详细地址B(用于：房源-车位) dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAddrDetailB")
	public String getAddrDetailB(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("house/houseLeaseService.getAddrDetailB", map);
		return result.getData();
	}
	/**
	 * 业主来源(子) dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSourcesByParentId")
	public String getSourcesByParentId(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("ownerSource/ownerSourceService.getSourcesByParentId", map);
		return result.getData();
	}
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getHouseLeaseTable")
	public String getHouseLeaseTable(HttpServletRequest request,HttpSession session){
		ResultValue ba1List = crmService.access("house/houseLeaseService.getBa1List", null);
		ResultValue sysParamMap = crmService.access("sysParam/sysParamService",null);
		request.setAttribute("ba1List", ba1List.getJsonArray());//大商圈
		request.setAttribute("sysParamMap", sysParamMap.getJsonObject());//房源系统参数
		request.setAttribute("quOrgList", oaService.getQuOrgList());//OA组织结构
		request.setAttribute("curUser", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));//当前登陆人id
		return "houseLease/lease_table";
	}
	/**
	 * 弹窗 dl
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "getLeaseAddDialog")
	public String getLeaseAddDialog(HttpServletRequest request,@RequestParam Map<String,Object > map){
		String useType = map.get("useType").toString();
		ResultValue parentSourceList = crmService.access("ownerSource/ownerSourceService.getParentSources", null);//业主来源
		ResultValue sysParamMap = crmService.access("sysParam/sysParamService",null);//房源系统参数
		request.setAttribute("useType", useType);
		request.setAttribute("parentSourceList", parentSourceList.getJsonArray());
		request.setAttribute("sysParamMap", sysParamMap.getJsonObject());
		//修改-显示数据
		if(map.containsKey("houseInfoId") && null!=map.get("houseInfoId") && !map.get("houseInfoId").equals("")){
			ResultValue houseLeaseResult = crmService.access("house/houseLeaseService.getHouseLeaseById", map);
			request.setAttribute("houseLeaseResult", houseLeaseResult.getJsonObject());
		}
		if(useType.equals("1")){
			return "houseLease/lease_form_residence";//住宅
		}else if(useType.equals("2")){
			return "houseLease/lease_form_shops";//商铺
		}else if(useType.equals("3")){
			return "houseLease/lease_form_office";//写字楼
		}else{
			return "houseLease/lease_form_carport";//车位
		}
	}
	/**
	 * 保存租赁房源 dl
	 * @param map
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveHouseLease")
	public String insertHouseLease(@RequestParam Map<String,Object> map,HttpSession session){
		ResultValue result = new ResultValue();
		//TODO 刁兰 1）取房间的所属权限 2）区编码去掉
		//组织结构-登记人（模拟）
		map.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));
		map.put("userName", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY));
		map.put("userOrgCode", "02.01.02.01.01.");//组编号
		map.put("userOrg", "东一区1组");//组
		map.put("userQu", "东一区");//区
		map.put("userQuCode", "02.01.02.01.");//区编码
		map.put("userDaQu", "东大区");//大区
		if(map.containsKey("houseInfoId") && null!=map.get("houseInfoId") && !map.get("houseInfoId").equals("")){
			result = crmService.access("house/houseLeaseService.updateHouseLeaseById", map);
		}else{
			result = crmService.access("house/houseLeaseService.insertHouseLease", map);
		}
		return result.getData();
	}
	/**
	 * 分页查询 dl
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseLeaseListForPage")
	public String getHouseLeaseListForPage(@RequestParam Map<String,Object> map,HttpSession session){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		map.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));
		ResultValue result = crmService.access("house/houseLeaseService.getHouseLeaseListForPage", map);
		return result.getData();
	}
	/**
	 * 模糊搜索车位 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCarPortByMatch")
	public String getCarPortByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("carPort/carPortService.getCarPortByMatch", map);
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
		map.put("demandType", "2");
		ResultValue result = crmService.access("house/houseLeaseService.isContactHouseLease", map);
		return result.getData();
	}
	/**
	 * 模糊搜索楼盘名称 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesByMatch")
	public String getPremisesByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseLeaseService.getPremisesByMatch", map);
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
		ResultValue result = crmService.access("carPort/carPortService.getBuildingsByPremisesId", map);
		return result.getData();
	}
	/**
	 * 根据楼栋id查询单元 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getUnitlist")
	public String getUnitslist(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("carPort/carPortService.getUnitsByBuildingId", map);
		return result.getData();
	}
	/**
	 * 模糊搜索房间号 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoomList")
	public String getRoomList(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("carPort/carPortService.getRoomList", map);
		return result.getData();
	}
	/**
	 * 根据大商圈查询小商圈 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBa2List")
	public String getBa2List(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseLeaseService.getBa2List", map);
		return result.getData();
	}
	/**
	 * 模糊搜索教育设施 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getEdusByMatch")
	public String getEdusByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseLeaseService.getEdusByMatch", map);
		return result.getData();
	}
	/**
	 * 校验房源是否已存在 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isExistWithHouseLease")
	public String isExistWithHouseLease(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseLeaseService.isExistWithHouseLease", map);
		return result.getData();
	}
	/**
	 * 校验具体地址是否属于地址库 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isExistWithAddrDetail")
	public String isExistWithAddrDetail(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseLeaseService.isExistWithAddrDetail", map);
		return result.getData();
	}
	/**
	 * 租赁房源查看open页 查看详情
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "lookUpDetail")
	public String lookUpDetail(@RequestParam Map<String,Object> map,HttpServletRequest request,HttpSession session){
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		map.put("userName", proposerUser);//打假申请人名字
		map.put("userId", proposerUserId);//打假申请人Id
		map.put("userOgrCode", sessionOrgCodeKey);//打假申请人组织结构代码
		ResultValue result = crmService.access("house/houseLeaseService.getDetail", map);
		request.setAttribute("houseLeaseInfo", result.getJsonObject().get("houseLeaseInfo"));
		if(result.getJsonObject().get("collectResult") == null) {
			request.setAttribute("collectDisplay", "true");
		} else {
			request.setAttribute("collectDisplay", "false");//收藏数据
			request.setAttribute("collectId", result.getJsonObject().get("collectResult"));
		}
		if(result.getJsonObject().get("querySpaceSee") != null) {
			request.setAttribute("spaceSeeDisplay", "false");//空看
		}
		if(result.getJsonObject().get("queryReceiveKey") != null) {
			request.setAttribute("keyId", result.getJsonObject().get("queryReceiveKey"));//钥匙数量
		}
		request.setAttribute("carPort", result.getJsonObject().get("carPortList"));//车位
		request.setAttribute("linkManList", result.getJsonObject().get("linkManList"));//联系人
		request.setAttribute("eduList", result.getJsonObject().get("eduListByMatch"));//教育设施
		request.setAttribute("busStationList", result.getJsonObject().get("busStationList"));//公交线路
		request.setAttribute("subwayStationList",  result.getJsonObject().get("subwayStationList"));//地铁线路
		request.setAttribute("num", map.get("num").toString());//1住宅 2 商铺 3写字楼 4车库
		request.setAttribute("type", map.get("type").toString());//1买卖 2租赁
		return "houseLease/house_detail";
	}
}
