package com.golden.addr.web.controller.traffic;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author dl
 * 类名称：公共交通站点Controller
 * 类描述：站点的新增 、修改、删除、查询显示
 * 时间：2016-10-10
 */
@Controller
@RequestMapping(value="aroundSite")
public class AroundSiteController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	@RequestMapping(value = "index")
	public String index(){
		return "traffic_site/site_main";
	}
	/**
	 * 获取列表页
	 */
	@RequestMapping(value = "getSiteTable")
	public String getSiteTable(HttpServletRequest request){
		String selTabIndex = request.getParameter("selTabIndex");
		Map<String,Object> map = new HashMap<String, Object>();
		if(selTabIndex.equals("1")){
			map.put("trafficType", 1);
			ResultValue result = addrService.access("traffic/aroundLineService.getLineList", map);
			request.setAttribute("lineList", result.getJsonArray());
			return "traffic_site/bus_site_table";
		}else{
			map.put("trafficType", 2);
			ResultValue result = addrService.access("traffic/aroundLineService.getLineList", map);
			request.setAttribute("lineList", result.getJsonArray());
			return "traffic_site/subway_site_table";
		}
	}
	/**
	 * 获取新增弹出框
	 */
	@RequestMapping(value = "getSiteAddDialog")
	public String getSiteAddDialog(HttpServletRequest request){
		String selTabIndex = request.getParameter("selTabIndex");
		String id = request.getParameter("id");
		//处理编辑时数据默认显示
		if(id!=null && !id.equals("") ){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			ResultValue site = addrService.access("traffic/aroundSiteService.getSiteById", map);
			ResultValue lineList = addrService.access("traffic/aroundLineService.getLinesBySiteId", map);
			request.setAttribute("site", site.getJsonObject());
			request.setAttribute("lineList", lineList.getJsonArray());
		}
		if(selTabIndex.equals("1")){
			return "traffic_site/bus_site_form";
		}else{
			return "traffic_site/subway_site_form";
		}
	}
	/**
	 * 分页查询站点
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSiteListForPage")
	public String getSiteListForPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		String trafficType = map.get("trafficType").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		map.put("trafficType", trafficType);
		String siteId = "";
		String lineId = "";
		if(map.containsKey("siteId") && map.containsKey("lineId")){
			siteId = map.get("siteId").toString();
			lineId = map.get("lineId").toString();
			map.put("siteId", siteId);
			map.put("lineId", lineId);
		}
		ResultValue result = addrService.access("traffic/aroundSiteService.getSiteListForPage", map);
		return result.getData();
	}
	/**
	 * 查询站点名称是否存在
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSiteByNameIs")
	public String getSiteByNameIs(@RequestParam Map<String,Object> map){
		ResultValue result = addrService.access("traffic/aroundSiteService.getSiteByNameIs", map);
		return result.getData();
	}
	/**
	 * 保存站点(新增、修改)
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveSite")
	public String saveSite(@RequestParam Map<String,Object> map){
		String id = map.get("id").toString();
		ResultValue result = new ResultValue();
		if(id!=null && !id.equals("")){
			result = addrService.access("traffic/aroundSiteService.updateSite", map);
		}else{
			result = addrService.access("traffic/aroundSiteService.insertSite", map);
		}
		return result.getData();
	}
	/**
	 * 批量删除站点
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteSites")
	public String delRoads(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundSiteService.deleteSites", map);
		return result.getData();
	}
	/**
	 * 查询所有站点
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSiteList")
	public String getSiteList(){
		ResultValue result = addrService.access("traffic/aroundSiteService.getSiteList", null);
		return result.getData();
	}
	/**
	 * 模糊匹配站点
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSiteListByMatch")
	public String getSiteListByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundSiteService.getSiteListByMatch", map);
		return result.getData();
	}
	/**
	 * 站点Excel解析
	 * @param file
	 * @param trafficType
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "uploadExcel")
	public String uploadExcel(@RequestParam("file") MultipartFile file,@RequestParam("trafficType") String trafficType) throws Exception{
		if(file.isEmpty()){  
	        throw new Exception("文件不存在！");  
	    } 
		Map<String, Object> map = new HashMap<String, Object>();
		ResultValue result = new ResultValue();
		InputStream is = null;
		try {
			is = file.getInputStream();
			String fileName = file.getOriginalFilename();
			byte[] isArray = IOUtils.toByteArray(is);
			//解析Excel
	        map.put("isArray", isArray);
	        map.put("fileName", fileName);
	        map.put("trafficType", trafficType);
	        result = addrService.access("traffic/readSiteExcelService.batchImport", map);
		} catch (IOException e) {
			e.printStackTrace();
		} 
        return result.getData();
	}
	
}
