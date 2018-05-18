package com.golden.crm.web.controller.match;

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

import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
@Controller
@RequestMapping(value = "matchCategory")
public class MatchCategoryController {
	
	@Resource(name="crmService")
	private IServiceStore crmService;

	/**
	 * 赛区类别页面
	 */
	@RequestMapping(value = "index")
	public String index() {
		return "match/matchCategory_index";
	}
	
	/**
	 * 获取赛区类别列表
	 */
	@ResponseBody
	@RequestMapping(value="getMatchCategoryList")
	public String getMatchCategoryList(@RequestParam Map<String, Object> param){
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = crmService.access("matchCategory/matchCategoryService.getMatchCategoryPage", param);
		return result.getData();
	}
	
	/**
	 * 返回添加 修改页面
	 */
	@RequestMapping(value="insertMatchCategory")
	public String insertMatchCategory(ModelMap model,HttpServletRequest request){
		Map<String, Object> params = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String read = request.getParameter("read");
		if(id != "" && id != null){
			params.put("id", id);
			ResultValue result = crmService.access("matchCategory/matchCategoryService.initUpdateData", params);
			model.put("categoryObj", result.getJsonObject());
			model.put("readType", read);
		}
		return "match/matchCategory_edit";
	}
	
	/**
	 * 新增 修改
	 */
	@ResponseBody
	@RequestMapping(value="saveMatchCategory")
	public String saveMatchCategory(@RequestParam Map<String, Object> param, HttpSession session,HttpServletRequest request){
		param.put("createUserId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString());
		param.put("createUser", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		param.put("status", Integer.parseInt(param.get("status").toString()));
		if(param.get("layer") != "" && param.get("layer")!=null){
			param.put("layer", Integer.parseInt(param.get("layer").toString()));
		}else{
			param.put("layer", "");
		}
		if(param.get("sort") != "" && param.get("sort")!=null){
			param.put("sort", Integer.parseInt(param.get("sort").toString()));
		}else{
			param.put("sort", "");
		}
		ResultValue result = new ResultValue();
		String id = request.getParameter("id");
		if(id != "" && id != null){
			param.put("id", id);
			result = crmService.access("matchCategory/matchCategoryService.updateMatchCategory", param);
		}else{
			result = crmService.access("matchCategory/matchCategoryService.addMatchCategory", param);
		}
		return result.getData();
	}
	
	/**
	 * 删除类别
	 */
	@ResponseBody
	@RequestMapping(value="deleteMatchCategory")
	public String deleteMatchCategory(@RequestParam Map<String, Object> param){
		ResultValue result = crmService.access("matchCategory/matchCategoryService.deleteMatchCategory", param);
		return result.getData();
	}
}
