package com.golden.addr.web.controller.areaManage;

import java.io.IOException;
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
@RequestMapping(value = "area")
public class AreaController {
	
	@Resource(name="addrService")
	private IServiceStore addrService;
	/**
	 * 分页查询街道页
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model) throws IOException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("areaLevel", 1);
		ResultValue result = addrService.access("area/areaService.getAreaList",map);
		model.addAttribute("provinceList", result.getJsonArray());
		return "area/area_index";
	}
	/**
	 * 分页查询区分页列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "areaListPage")
	public String areaList(@RequestParam Map<String,Object> params) throws IOException {
		String currentPage = params.get("page").toString();
		String rowCount = params.get("rows").toString();
		params.put("currentPage", currentPage);
		params.put("rowCount", rowCount);
		ResultValue result = addrService.access("area/areaService", params);
	    return result.getData();
	}
	/**
	 * 分页查询街道分页列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "subdistrictPage")
	public String subdistrictPage(@RequestParam Map<String,Object> params) throws IOException {
		String currentPage = params.get("page").toString();
		String rowCount = params.get("rows").toString();
		params.put("currentPage", currentPage);
		params.put("rowCount", rowCount);
		ResultValue result = addrService.access("area/areaService.getSubdistrictPage", params);
		return result.getData();
	}
	/**
	 * 分页查询社区分页列表
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "communityPage")
	public String communityPage(@RequestParam Map<String,Object> params) throws IOException {
		String currentPage = params.get("page").toString();
		String rowCount = params.get("rows").toString();
		params.put("currentPage", currentPage);
		params.put("rowCount", rowCount);
		ResultValue result = addrService.access("area/areaService.getCommunityPage", params);
		return result.getData();
	}
	/**
	 * 模态-新增或修改页
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "addAreaIndex")
	public String addAreaIndex(@RequestParam Map<String,Object> params , HttpServletRequest request) throws IOException {
		String areaAll = request.getParameter("areaAll");
		areaAll = URLDecoder.decode(areaAll, "UTF-8");
		String unifyStr = request.getParameter("unifyStr");
		unifyStr = URLDecoder.decode(unifyStr, "UTF-8");
		request.setAttribute("baseAreaId",params.get("baseAreaId").toString());
		request.setAttribute("areaAll",areaAll);
		request.setAttribute("different",params.get("different").toString());
		request.setAttribute("unifyStr",unifyStr);
		String rowId = params.get("rowId").toString();
		request.setAttribute("rowId",rowId);
		String different = params.get("different").toString();
		if(!rowId.equals("")){
			if(different.equals("2")){
				Map<String,Object> map =new HashMap<String,Object>();
				map.put("baseAreaId", rowId);
				ResultValue result = addrService.access("area/areaService.getAreaInfo", map);
				request.setAttribute("result",result.getJsonObject());
			}else if(different.equals("3")){
				Map<String,Object> map2 =new HashMap<String,Object>();
				map2.put("subdistrictId", rowId);
				ResultValue result = addrService.access("area/areaService.getSubdistrict", map2);
				request.setAttribute("result",result.getJsonObject());
			}else{
				Map<String,Object> map3 =new HashMap<String,Object>();
				map3.put("communityId", rowId);
				ResultValue result = addrService.access("area/areaService.getCommunityName", map3);
				request.setAttribute("result",result.getJsonObject());
			}
			
		}
		return "area/edit_area";
	}	
	
	/**
	 * 模态-添加区域-验证
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "verifyAddArea")
	@ResponseBody
	public String verifyAddArea(@RequestParam Map<String,Object> params){
		ResultValue result = addrService.access("area/areaService.verifyAddArea",params);
		return result.getData();
	}
	
	/**
	 * 模态-新增或-修改区域Btn
	 * 			
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "addArea")
	@ResponseBody
	public String addArea(@RequestParam Map<String,Object> params){
		String rowId = params.get("rowId").toString();
		if(!rowId.equals("")){    //修改
			ResultValue result = addrService.access("area/areaService.updateArea",params);
			return result.getData();
		}else{						//新增
			ResultValue result = addrService.access("area/areaService.addArea",params);
			return result.getData();
		}
	}
	/**
	 * 删除区域
	 * @param map   rowIds : rowIds,  选择ID   逻辑删除
					different:different  选择行政等级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deteleArea")
	public String delRoads(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("area/areaService.deleteArea", map);
		return result.getData();
	}
	/**
	 * 删除区域验证是否含有下一级数据
	 * @param map   rowIds : rowIds,  选择ID   逻辑删除
					different:different  选择行政等级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deteleHint")
	public String deteleHint(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("area/areaService.deteleHint", map);
		return result.getData();
	}
	/**
	 * 省市级联 下拉列表
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getAreaList")
	@ResponseBody
	public String getAreaList(@RequestParam Map<String,Object> params){
		ResultValue result = addrService.access("area/areaService.getAreaList",params);
		return result.getData();
	}
	/**
	 * 下拉框中-街道-集合列表
	 * @param params  参数中传的是区ID
	 * @return
	 */
	@RequestMapping(value = "getSubdistrictList")
	@ResponseBody
	public String getSubdistrictList(@RequestParam Map<String,Object> params){
		ResultValue result = addrService.access("area/areaService.getSubdistrictList",params);
		return result.getData();
	}

	/**
	 * 模糊匹配区域
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAreaListByMatch")
	public String getAreaListByMatch(@RequestParam Map<String, Object> map){
		String different = map.get("different").toString();
		if(different.equals("2")){
			ResultValue result = addrService.access("area/areaService.getAreaByMatch", map);
			return result.getData();
		}else if(different.equals("3")){
			ResultValue result = addrService.access("area/areaService.getSubdistrictByMatch", map);
			return result.getData();
		}else{
			ResultValue result = addrService.access("area/areaService.getCommunityByMatch", map);
			return result.getData();
		}
		
	}
	/**
	 * 模糊匹配区域
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAreaByMatchOfLevel3")
	public String getAreaByMatchOfLevel3(@RequestParam Map<String, Object> map){
		map.put("pid", "934");
		ResultValue result = addrService.access("area/areaService.getAreaByMatchOfLevel3", map);
		return result.getData();
	}
	/**
	 * 获取社区列表
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCommunityList")
	public String getCommunityList(@RequestParam Map<String,Object> map){
		if(map.get("baseAreaId")!=null){
			map.put("subdistrictId", map.get("baseAreaId").toString());
		}
		ResultValue result = addrService.access("area/areaService.getCommunityList", map);
		return result.getData();
	}
}
