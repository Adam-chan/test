package com.golden.addr.web.controller.premisesExamine;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author chenqian
 * 类名称：楼盘审核Controller
 * 类描述：
 * 时间：2016-10-21
 */
@Controller
@RequestMapping(value = "premisesExamine")
public class PremisesExamineController {

	@Resource(name="addrService")
	private IServiceStore addrService;

	/**
	 * 楼盘审核列表页面
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		ResultValue result = addrService.access("busiArea/busiAreaService.getQueryBusiArea", param);
		ResultValue result2 = addrService.access("premisesExamine/premisesExamineService.getOperateUserList", param);
		ResultValue result3 = addrService.access("premisesExamine/premisesExamineService.getExamineUserList", param);
		model.addAttribute("busiAreaList", result.getJsonArray());
		model.addAttribute("operateUserList", result2.getJsonArray());
		model.addAttribute("examineUserList", result3.getJsonArray());
		return "premisesExamine/examineIndex";
	}

	/**
	 * 获取楼盘审核列表
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesExamineList")
	public String getPremisesList(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = addrService.access("premisesExamine/premisesExamineService.getPremisesExaminePage", param);
		return result.getData();
	}

	/**
	 * 楼盘审核确认页面
	 */
	@RequestMapping(value = "toExamine")
	public String toExamine(ModelMap model, @RequestParam Map<String, Object> map) throws IOException {
		model.addAttribute("examineType",map.get("examineType").toString());
		return "premisesExamine/examine";
	}

	/**
	 * 楼盘审核
	 */
	@ResponseBody
	@RequestMapping(value = "examine")
	public String examine(@RequestParam Map<String, Object> map, HttpSession session ){
		String userId = (String) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		map.put("examineId", (userId != null) ? userId : "");
		map.put("examineUser", userName);
		ResultValue result = addrService.access("premisesExamine/premisesExamineService.examine", map);
		return result.getData();
	}
	
	/**
	 * 模糊匹配楼盘
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesListByMatch")
	public String getAreaListByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("premisesExamine/premisesExamineService.getPremisesListByMatch", map);
		return result.getData();
	}

}
