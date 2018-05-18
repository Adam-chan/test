package com.golden.crm.web.controller.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping(value = "matchFiles")
public class MatchZoneController {

	@Resource(name="crmService")
	private IServiceStore crmService;
	
	/**
	 * 赛事档案页面
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", "1");
		ResultValue result = crmService.access("matchZone/MatchZoneService.getCategoryName", params);
		model.put("categoryNameList", result.getJsonArray());
		return "matchFiles/matchFiles_index";
	}
	
	/**
	 * 赛事档案分页列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getmatchZoneList")
	public String getmatchFilesList(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = crmService.access("matchZone/MatchZoneService.getMatchZonePage", param);
		return result.getData();
	}
	
	/**
	 * 返回赛事新增 修改页面并获取赛事类别
	 * @return
	 */
	@RequestMapping(value = "insertMatchZonePage")
	public String insertMatchZonePage(ModelMap model,HttpServletRequest request){
		Map<String, Object> params = new HashMap<String, Object>();
		String id = request.getParameter("id");
		params.put("status", "1");
		ResultValue result = crmService.access("matchZone/MatchZoneService.getCategoryName", params);
		model.put("categoryNameList", result.getJsonArray());
		model.put("readType", request.getParameter("read"));
		if(id != null && id != ""){
			params.clear();
			params.put("id", id);
			ResultValue updateData = crmService.access("matchZone/MatchZoneService.getUpdateMatchZone", params);
			model.put("updateDataObj", updateData.getJsonObject());
		}
		return "matchFiles/matchFiles_edit";
	}
	
	/**
	 * 获取新增赛区树形菜单判断条件参赛层级字段
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCategoryLayer")
	public String getCategoryLayer(@RequestParam Map<String, Object> param){
		ResultValue result = crmService.access("matchZone/MatchZoneService.getCategoryLayerByName", param);
		return result.getData();
	}
	
	@ResponseBody
	@RequestMapping(value = "insertMatchZone")
	public String insertMatchZone(@RequestParam Map<String, Object> param,HttpServletRequest request){
		String id = request.getParameter("id");
		ResultValue result = new ResultValue();
		if(id != null && id != ""){
			param.put("id", id);
			result = crmService.access("matchZone/MatchZoneService.updateMatchZone", param);
		}else{
			result = crmService.access("matchZone/MatchZoneService.insertMatchZone", param);
		}
		return result.getData();
	}
	
	@ResponseBody
	@RequestMapping(value = "getBusinessTeam")
	public String getBusinessTeam(ModelMap model){
		Map<String, Object> params = new HashMap<String,Object>();
		String teamStr = "东大区,东一大区,南大区,中一大区,西大区,西一大区,西南大区,北大区,北一大区";
		String areaStr = "杭州我爱我家,大连我爱我家,"; 
		String[] teamArr = teamStr.split(",");
		String[] areaArr = areaStr.split(",");
		List<Map<String, Object>> teamList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < areaArr.length; i++) {
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("area", areaArr[i]);
			map.put("team", teamArr);
			teamList.add(map);
		}
		params.put("key", teamList);
		ResultValue result = crmService.access("matchZone/MatchZoneService.getBusinessTeam", params);
		return result.getData();
	}
	
	/**
	 * 删除赛区
	 */
	@ResponseBody
	@RequestMapping(value="deleteMatchZone")
	public String deleteMatchCategory(@RequestParam Map<String, Object> param){
		ResultValue result = crmService.access("matchZone/MatchZoneService.deleteMatchZone", param);
		return result.getData();
	}
	
}
