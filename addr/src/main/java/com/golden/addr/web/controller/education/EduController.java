package com.golden.addr.web.controller.education;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author dl
 * 类名称：道路Controller
 * 类描述：道路的新增 、修改、删除、查询显示
 * 时间：2016-9-28
 */
@Controller
@RequestMapping(value="edu")
public class EduController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("eareId",934);
		ResultValue result = addrService.access("area/areaService.getAreaList",map);
		request.setAttribute("provinceList", result.getJsonArray());
		request.setAttribute("type", 1);
		return "education/edu_main";
	}
	/**
	 * 教育设施open页 新增或修改
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "editEduIndex")
	public String editEduIndex(@RequestParam Map<String,Object> map,HttpServletRequest request){
		if(!map.get("eduId").toString().equals("undefined")){
			ResultValue result = addrService.access("education/EduService.getEduAllInfo", map);
			request.setAttribute("eduInfo", result.getJsonObject());
			ResultValue resultList = addrService.access("education/EduService.getEduAllInfoList", map);
			request.setAttribute("getEduAllInfoList", resultList.getJsonObject());
			request.setAttribute("eduId",map.get("eduId").toString());
			ResultValue imgResult = addrService.access("education/EduService.getEduImgList", map);
			request.setAttribute("eduImg", imgResult.getJsonObject());
		}
		return "education/edu_Edit_open";
	}
	
	/**
	 * 教育设施open页 查看详情
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "lookUpEduIndex")
	public String lookUpEduIndex(@RequestParam Map<String,Object> map,HttpServletRequest request){
			ResultValue result = addrService.access("education/EduService.getEduAllInfo", map);
			request.setAttribute("eduInfo", result.getJsonObject());
			ResultValue resultList = addrService.access("education/EduService.getEduAllInfoList", map);
			request.setAttribute("getEduAllInfoList", resultList.getJsonObject());
			ResultValue Imgresult = addrService.access("education/EduService.getEduImgList", map);
			request.setAttribute("eduImg", Imgresult.getJsonObject());
		return "education/edu_lookUp_open";
	}
	/**
	 * 编辑教育信息(新增、修改)
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "editEdu")
	public String editEdu(@RequestParam Map<String,Object> map){
		ResultValue access = addrService.access("education/EduService.editEdu", map);
		return access.getData();
	}
	/**
	 * 分页查询教育设施
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "eduListForPage")
	public String eduListForPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		if(map.get("keyWord")!=null && !map.get("keyWord").equals("")){
			map.put("eduName", map.get("keyWord").toString());
		}
		if(map.get("eduType")!=null && !map.get("eduType").equals("")){
			map.put("eduType", map.get("eduType").toString());
		}
		if(map.get("eduTypeName")!=null && !map.get("eduTypeName").equals("")){
			map.put("eduType", map.get("eduTypeName").toString());
		}
		ResultValue result = addrService.access("education/EduService", map);
		return result.getData();
	}
	/**
	 * 逻辑删除教育设施
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateEduStatus")
	public String updateEduStatus(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("education/EduService.updateEduStatus", map);
		return result.getData();
	}
	/**
	 * 模糊教育设施 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "geteduNameByMatch")
	public String geteduNameByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("education/EduService.geteduNameByMatch", map);
		return result.getData();						
	}
	/**
	 * 教育设施名字和地址验证
	 * @param map creatType 
	 * @return Integer
	 */
	@ResponseBody
	@RequestMapping(value = "verifyEduName")
	public String verifyEduName(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("education/EduService.getEduInfo", map);
		return result.getData();						
	}
}
