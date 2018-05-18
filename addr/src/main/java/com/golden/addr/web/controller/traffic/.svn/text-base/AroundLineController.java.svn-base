package com.golden.addr.web.controller.traffic;

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
 * 类名称：公共交通线路Controller
 * 类描述：站点的新增 、修改、删除、查询显示
 * 时间：2016-10-11
 */
@Controller
@RequestMapping(value="aroundLine")
public class AroundLineController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	@RequestMapping(value = "index")
	public String index(){
		return "traffic_line/line_main";
	}
	/**
	 * 获取列表页
	 */
	@RequestMapping(value = "getLineTable")
	public String getSiteTable(HttpServletRequest request){
		return "traffic_line/line_table";
	}
	/**
	 * 获取新增弹出框
	 */
	@RequestMapping(value = "getLineAddDialog")
	public String getLineAddDialog(HttpServletRequest request){
		String id = request.getParameter("id");
		//处理编辑时数据默认显示
		if(id!=null && !id.equals("") ){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			ResultValue result = addrService.access("traffic/aroundLineService.getLineById", map);
			request.setAttribute("line", result.getJsonObject());
		}
		return "traffic_line/line_form";
	}
	/**
	 * 根据站点id查询所有关联线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getLinesBySiteId")
	public String getLinesBySiteId(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundLineService.getLinesBySiteId", map);
		return result.getData();  
	}
	/**
	 * 新增线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="saveLine")
	public String insertLine(@RequestParam Map<String, Object> map){
		String id = map.get("id").toString();
		ResultValue result = new ResultValue();
		if(id!=null && !id.equals("")){
			result = addrService.access("traffic/aroundLineService.updateLineById", map);
		}else{
			result = addrService.access("traffic/aroundLineService.insertLine", map);
		}
		return result.getData();  
	}
	/**
	 * 根据id查询线路信息
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getLineById")
	public String getLineById(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundLineService.getLineById", map);
		return result.getData();  
	}
	/**
	 * 根据id更新线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="updateLineById")
	public String updateLineById(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundLineService.updateLineById", map);
		return result.getData();  
	}
	/**
	 * 根据id删除线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deleteLineById")
	public String deleteLineById(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundLineService.deleteLineById", map);
		return result.getData();  
	}
	/**
	 * 批量删除线路信息
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deleteLines")
	public String deleteLines(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundLineService.deleteLines", map);
		return result.getData();  
	}
	/**
	 * 分页查询线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getLineListForPage")
	public String getLineListForPage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		String trafficType = map.get("trafficType").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		map.put("trafficType", trafficType);
		ResultValue result = addrService.access("traffic/aroundLineService.getLineListForPage", map);
		return result.getData();
	}
	/**
	 * 查询所有线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getLineList")
	public String getLineList(){
		ResultValue result = addrService.access("traffic/aroundLineService.getLineList", null);
		return result.getData();
	}
	/**
	 * 查询线路名称是否存在
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getLineByNameIs")
	public String getLineByNameIs(@RequestParam Map<String,Object> map){
		String trafficType = map.get("trafficType").toString();
		String lineName = map.get("lineName").toString();
		map.put("trafficType", trafficType);
		map.put("lineName", lineName);
		ResultValue result = addrService.access("traffic/aroundLineService.getLineByNameIs", map);
		return result.getData();
	}
	/**
	 * 模糊匹配线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getLineListByMatch")
	public String getLineListByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundLineService.getLineListByMatch", map);
		return result.getData();
	}
	/**
	 * 根据线路名称查询线路
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getLineByLineName")
	public String getLineByLineName(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("traffic/aroundLineService.getLineByLineName", map);
		return result.getData();
	}
	
}
