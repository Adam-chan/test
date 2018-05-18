package com.golden.addr.web.controller.operate;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * 楼盘的经营范围分配
 * @author dl
 * 时间 2016-12-5
 */
@Controller
@RequestMapping(value="operate")
public class OperateController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	@Resource(name = "oaService")
	private OAService oaService;
	
	/**
	 * 页面：经营分配 
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(){
		return "operate/operate_main";
	}
	/**
	 * 页面：经营分配 dl
	 * @return
	 */
	@RequestMapping(value = "getDistributionDialog")
	public String getDistributionDialog(HttpServletRequest request,Map<String,Object> map){
		map.put("eareId", "934");
		map.put("areaLevel", "3");
		ResultValue areaList = addrService.access("operate/operateService.getAreaList", map);
		request.setAttribute("daQuOrgList", JSON.parseArray(oaService.getOrgListStr(null)));//OA组织结构
		request.setAttribute("areaList", areaList.getJsonArray());//行政区划
		return "operate/distribute_form";
	}
	/**
	 * 页面：选择楼盘 dl
	 * @return
	 */
	@RequestMapping(value = "getAddPremisesDialog")
	public String getAddPremisesDialog(HttpServletRequest request,Map<String,Object> map){
		map.put("eareId", "934");
		map.put("areaLevel", "3");
		ResultValue areaList = addrService.access("operate/operateService.getAreaList", map);//行政区划
		request.setAttribute("areaList", areaList.getJsonArray());
		return "operate/add_premises_form";
	}
	/**
	 * 查询行政区划 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAreaList")
	public String getPremisesByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("operate/operateService.getAreaList", map);
		return result.getData();
	}
	/**
	 * 查询大商圈 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBa1List")
	public String getBa1List(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("busiArea/busiAreaService.getParentBusiAreaList", map);
		return result.getData();
	}
	/**
	 * 查询小商圈 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBa2List")
	public String getBa2List(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("busiArea/busiAreaService.getBusiAreaList", map);
		return result.getData();
	}
	/**
	 * 查询街道 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSubdistrictList")
	public String getSubdistrictList(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("operate/operateService.getSubdistrictList", map);
		return result.getData();
	}
	/**
	 * 查询社区 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCommunityList")
	public String getCommunityList(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("busiArea/busiAreaService.getCommunityList", map);
		return result.getData();
	}
	/**
	 * 查询道路 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoadList")
	public String getRoadList(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("road/roadService.getRoadList", null);
		return result.getData();
	}
	/**
	 * 楼盘列表 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesAddrForPage")
	public String getPremisesAddrForPage(@RequestParam Map<String, Object> map){
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		ResultValue result = addrService.access("operate/operateService.getPremisesAddrForPage", map);
		return result.getData();
	}
	
	
	
	
	//分水岭*************************************************************************************
	
		/**
		 * 楼盘的经营范围分配(买卖) 页面  sy
		 * 
		 * @param params
		 * @return
		 */
		@RequestMapping(value = "operateSaleTable")
		public String operateSaleTable(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
			param.put("pid", "934");
			ResultValue areaList = addrService.access("area/areaService.getAreaByMatchOfLevel3", param);
			model.addAttribute("areaList", areaList.getJsonArray());
			model.addAttribute("dutyAreaList", oaService.getDaQuOrgList());
			return "operate/operate_sale_table";
		}
		
		/**
		 * 分页查询楼盘的经营范围分配(买卖) 列表 sy
		 * @param map 
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "getOperateSaleListForPage")
		public String getOperateSaleListForPage(@RequestParam Map<String,Object> map){
			ResultValue result = new ResultValue();
			map.put("currentPage", map.get("page").toString());
			map.put("rowCount", map.get("rows").toString());
			result = addrService.access("operate/operateService.getOperateSaleListForPage", map);
			return result.getData();
		}
		/**
		 * 楼盘的经营范围分配(租赁) 页面  sy
		 * 
		 * @param params
		 * @return
		 */
		@RequestMapping(value = "operateLeaseTable")
		public String operateLeaseTable(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
			param.put("pid", "934");
			ResultValue areaList = addrService.access("area/areaService.getAreaByMatchOfLevel3", param);
			model.addAttribute("areaList", areaList.getJsonArray());
			model.addAttribute("dutyAreaList", oaService.getDaQuOrgList());
			return "operate/operate_lease_table";
		}
		
		/**
		 * 分页查询楼盘的经营范围分配(租赁) 列表 sy
		 * @param map 
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "getOperateLeaseListForPage")
		public String getOperateLeaseListForPage(@RequestParam Map<String,Object> map){
			ResultValue result = new ResultValue();
			map.put("currentPage", map.get("page").toString());
			map.put("rowCount", map.get("rows").toString());
			result = addrService.access("operate/operateService.getOperateLeaseListForPage", map);
			return result.getData();
		}
}
