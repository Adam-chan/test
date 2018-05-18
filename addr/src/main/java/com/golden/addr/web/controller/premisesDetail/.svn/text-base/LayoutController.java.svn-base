package com.golden.addr.web.controller.premisesDetail;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

@Controller
@RequestMapping(value = "layoutInfo")
public class LayoutController {
	
	@Resource(name="addrService")
	private IServiceStore addrService;
	
	@RequestMapping(value = "index")
	public String index(@RequestParam Map<String,Object> map , ModelMap model) throws IOException {
		model.addAttribute("premisesId",map.get("id").toString());
		ResultValue result = addrService.access("layout/layoutService.getLayoutNameList",map);
		model.addAttribute("layoutNameList", result.getJsonArray());
		return "layout/layoutInfo";
	}
	
	/**
	 * 分页查询户型页
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getLayoutListByPremisesId")
	public String getLayoutListByPremisesId(@RequestParam Map<String,Object> map) throws IOException {
		ResultValue result = addrService.access("layout/layoutService.getPremisesLayoutQCPage",map);
		return result.getData();
	}	
	
	/**
	 * 户型名称导航菜单
	 * @return 
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "getLayoutNameList")
	public String getlayoutNameMenu(@RequestParam Map<String,Object> map) throws IOException {
		ResultValue result = addrService.access("layout/layoutService.getLayoutNameList",map);
		return result.getData();
	} 
	
	/**
	 * 添加户型初始化页面
	 * @return 
	 */
	@RequestMapping(value = "toAddLayout")
	public String toAddLayout(@RequestParam Map<String,Object> map , HttpServletRequest request){
		request.setAttribute("premisesId",map.get("premisesId").toString());
		return "layout/addLayout";	
	}
	
	/**
	 * 添加户型
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "addLayout")
	public String addLayout(@RequestParam Map<String,Object> map){
		ResultValue result = addrService.access("layout/layoutService.addLayout",map);
		return result.getData();
	}
	
	
	/**
	 * 修改户型初始化页面
	 * @return Page
	 */
	@RequestMapping(value = "toUpdateLayout")
	public String toUpdateLayout(@RequestParam Map<String,Object> map , HttpServletRequest request){
		ResultValue result = addrService.access("layout/layoutService.getLayoutById", map);
		request.setAttribute("layout", result.getJsonObject());
		request.setAttribute("id",map.get("id").toString());
		return "layout/addLayout";	
	}
	
	/**
	 * 修改户型
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "updateLayout")
	public String updateLayout(@RequestParam Map<String,Object> map){
		ResultValue result = addrService.access("layout/layoutService.updateLayout",map);
		return result.getData();
	}
	
	/**
	 * 删除户型
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "deleteLayoutById")
	public String deleteLayoutById(@RequestParam Map<String,Object> map) throws IOException {
		ResultValue result = addrService.access("layout/layoutService.deleteLayout",map);
		return result.getData();
	}
}