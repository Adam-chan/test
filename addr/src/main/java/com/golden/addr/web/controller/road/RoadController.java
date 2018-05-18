package com.golden.addr.web.controller.road;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author dl
 * 类名称：道路Controller
 * 类描述：道路的新增 、修改、删除、查询显示
 * 时间：2016-9-28
 */
@Controller
@RequestMapping(value="road")
public class RoadController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	@RequestMapping(value = "index")
	public String index(){
//		return "traffic_site/site_main";
		return "road/road_main";
//		return "traffic_line/line_main";
	}
	/**
	 * 道路管理 table 初始化
	 */
	@RequestMapping(value = "getRoadTable")
	public String getRoadTable(HttpServletRequest request){
		ResultValue result = addrService.access("road/roadService.getRoadList", null);
		request.setAttribute("roadList", result.getJsonArray());
		request.setAttribute("type", 2);
		return "road/road_table";
	}
	/**
	 * 撒号管理 table 初始化
	 */
	@RequestMapping(value = "getRoadNumTable")
	public String getRoadNumTable(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("eareId",934);
		ResultValue result = addrService.access("area/areaService.getAreaList",map);
		request.setAttribute("provinceList", result.getJsonArray());
		request.setAttribute("type", 1);
		return "road/road_num_table";
	}
	/**
	 * 日志管理 table 初始化
	 */
	@RequestMapping(value = "getRoadLogTable")
	public String getRoadLogTable(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("eareId",934);
		ResultValue result = addrService.access("area/areaService.getAreaList",map);
		request.setAttribute("provinceList", result.getJsonArray());
		request.setAttribute("type", 1);
		return "road/road_log_table";
	}
	/**
	 * 道路撒号open页
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "roadNumIndex")
	public String roadNumIndex(@RequestParam Map<String,Object > map,HttpServletRequest request){
		if(!map.isEmpty() && map.get("id")!=null){
			ResultValue result = addrService.access("road/roadService.getRoadById", map);
			request.setAttribute("road", result.getJsonObject());
			map.put("eareId",934);
			ResultValue areaResult = addrService.access("area/areaService.getAreaList",map);
			request.setAttribute("provinceList", areaResult.getJsonArray());
		}
		return "road/road_num_open";
	}
	
	/**
	 * 分页查询道路号
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoadNumListForPage")
	public String getRoadNumListForPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		if(map.get("handOutNum")!=null && !map.get("handOutNum").equals("")){
			map.put("areaId", map.get("handOutNum").toString());
		}
		if(map.get("keyWord")!=null && !map.get("keyWord").equals("")){
			map.put("roadName", map.get("keyWord").toString());
		}
		ResultValue result = addrService.access("road/roadService", map);
		return result.getData();
	}
	/**
	 * 分页查询道道路日志
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "queryRoadLogListPage")
	public String queryRoadLogListPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		if(map.get("handOutNum")!=null && !map.get("handOutNum").equals("")){
			map.put("areaId", map.get("handOutNum").toString());
		}
		if(map.get("keyWord")!=null && !map.get("keyWord").equals("")){
			map.put("roadName", map.get("keyWord").toString());
		}
		ResultValue result = addrService.access("road/roadService.queryRoadLogListPage", map);
		return result.getData();
	}
	/**
	 * 更改道路号使用状态
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateRoadNumStaus")
	public String updateRoadNumStaus(@RequestParam Map<String, Object> map,HttpSession session){
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		map.put("operator", proposerUser);//操作人
		map.put("operatorId", proposerUserId);//操作人Id
		map.put("operatorOrgCode", sessionOrgCodeKey);//操作人组织结构
		ResultValue result = addrService.access("road/roadService.updateRoadNumStatus", map);
		return result.getData();
	}
	/**
	 * 更改道路日志使用状态
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateRoadLogStatus")
	public String updateRoadLogStatus(@RequestParam Map<String, Object> map,HttpSession session){
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		map.put("operator", proposerUser);//操作人
		map.put("operatorId", proposerUserId);//操作人Id
		map.put("operatorOrgCode", sessionOrgCodeKey);//操作人组织结构
		ResultValue result = addrService.access("road/roadService.updateRoadLogStatus", map);
		return result.getData();
	}
	
	/**
	 * 查询道路日志使用中的条数
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoadNumLogCount")
	public String getRoadNumLogCount(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("road/roadService.getRoadNumLogCount", map);
		return result.getData();
	}
	
	/**
	 * 模糊匹配道路名 道路号 TABLE
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAordListByMatch")
	public String getAordListByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("road/roadService.getRoadNumByMatch", map);
		return result.getData();						
	}
	/**
	 * 获得道路号数量 道路撒号验证
	 * @param String creatType 生成号段的规则  1：单号撒号   2：双号撒号   3：连续撒号   startNum 起始号
	 * @return Integer
	 */
	@ResponseBody
	@RequestMapping(value = "verifyArodNum")
	public String verifyArodNum(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("road/roadService.getRoadNumCount", map);
		return result.getData();						
	}
	/**
	 * 保存 撒号信息Btn
	 * @param map 
	 * @return Integer
	 */
	@ResponseBody
	@RequestMapping(value = "addRoadNum")
	public String addRoadNum(@RequestParam Map<String, Object> map,HttpSession session ){
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		map.put("operator", proposerUser);//操作人
		map.put("operatorId", proposerUserId);//操作人Id
		map.put("operatorOrgCode", sessionOrgCodeKey);//操作人组织结构
		ResultValue result = addrService.access("road/roadService.addRoadNum", map);
		return result.getData();				
	}
	
	/**
	 * 获取道路新增、编辑弹出框  dl
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getRoadAddDialog")
	public String getRoadAddDialog(@RequestParam Map<String,Object> map,HttpServletRequest request){
		if(!map.isEmpty() && map.get("id")!=null){
			ResultValue result = addrService.access("road/roadService.getRoadManagerById", map);
			request.setAttribute("road", result.getJsonObject());
		}
		return "road/road_form";
	}
	/**
	 * 保存道路(新增、修改) dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveRoad")
	public String saveRoad(@RequestParam Map<String,Object> map){
		String id = map.get("id").toString();
		ResultValue result = new ResultValue();
		if(id!=null && !id.equals("")){
			result = addrService.access("road/roadService.updateRoad", map);
		}else{
			result = addrService.access("road/roadService.insertRoad", map);
		}
		return result.getData();
	}
	/**
	 * 分页查询道路 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "roadListForPage")
	public String getRoadListForPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		String roadId = "";
		if(map.get("id")!=null && !map.get("id").equals("")){
			roadId = map.get("id").toString();
		}
		map.put("id", roadId);
		ResultValue result = addrService.access("road/roadService.getRoadListForPage", map);
		return result.getData();
	}
	/**
	 * 批量删除道路 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delRoads")
	public String delRoads(@RequestParam Map<String, Object> map,HttpSession session){
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		map.put("operator", proposerUser);//操作人
		map.put("operatorId", proposerUserId);//操作人Id
		map.put("operatorOrgCode", sessionOrgCodeKey);//操作人组织结构
		ResultValue result = addrService.access("road/roadService.deleteRoads", map);
		return result.getData();
	}
	/**
	 * 模糊匹配道路信息 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoadListByMatch")
	public String getRoadListByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("road/roadService.getRoadListByMatch", map);
		return result.getData();
	}
	/**
	 * 查询道路名称是否存在 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoadByNameIs")
	public String getRoadByNameIs(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("road/roadService.getRoadByNameIs", map);
		return result.getData();
	}
}
