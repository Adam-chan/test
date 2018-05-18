package com.golden.crm.web.controller.match;

import java.io.IOException;
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
@RequestMapping(value = "match")
public class MatchController {
	
	@Resource(name="crmService")
	private IServiceStore crmService;
	
	/**
	 * 赛事发布页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model) throws IOException {
		return "match/match_index";
	}
	
	/**
	 * 赛事发布分页查询
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getMatchJQPage")
	public String getMatchJQPage(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.getMatchJQPage",params);
		return result.getData();
	}
	
	/**
	 * 赛事发布删除数据
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteMatch")
	public String deteleMatch(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.deleteMatch",params);
		return result.getData();
	}
	
	/**
	 * 赛事 发布
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "publishMatch")
	public String publishMatch(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.publishMatch",params);
		return result.getData();
	}
	
	/**
	 * 赛事发布新增数据
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addMatch")
	public String addMatch(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.addMatch",params);
		return result.getData();
	}
	
	/**
	 * 赛事发布修改数据
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "editMatch")
	public String editMatch(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.editMatch",params);
		return result.getData();
	}
	
	/**
	 * 赛事发布 获取赛区
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getMatchZone")
	public String getMatchZone(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.getMatchZone",params);
		return result.getData();
	}
	
	/**
	 * 赛事发布 赛事类别下拉列表
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSelectList")
	public String getSelectList(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.getSelectList", params);
		return result.getData();
	}
	
	/**
	 * 赛事发布 获取赛事
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectByPrimaryKey")
	public String getInputValue(@RequestParam Map<String, Object> params) throws IOException {
		ResultValue result = crmService.access("match/matchService.selectByPrimaryKey", params);
		return result.getData();
	}
	
	/**
	 * 赛事发布新增页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "addMatchIndex")
	public String addMatchIndex(HttpServletRequest request) throws IOException {
		request.setAttribute("matchId", 0);
		return "match/addMatch_Index";
	}
	
	/**
	 * 赛事发布修改页面
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "editMatchIndex")
	public String editMatchIndex(HttpServletRequest request) throws IOException {
		request.setAttribute("matchId", request.getParameter("matchId"));
		return "match/addMatch_Index";
	}
	
}
