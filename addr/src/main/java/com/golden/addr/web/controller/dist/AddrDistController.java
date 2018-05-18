package com.golden.addr.web.controller.dist;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author ChenHuan
 * 类名称：地址库分配Controller
 * 类描述：地址库的查询、分配等
 * 时间：2016-10-08
 */
@Controller
@RequestMapping(value = "addrDist")
public class AddrDistController {

	@Resource(name="addrService")
	private IServiceStore addrService;

	@Resource(name = "oaService")
	private OAService oaService;

	/**
	 * 地址库查询页面
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		return "dist/distMain";
	}

	/**
	 * 道路下拉框
	 */
	@ResponseBody
	@RequestMapping(value = "getRoadList")
	public String getRoadList(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("addrDist/addrDistService.getRoadList", param);
		return access.getData();
	}

	/**
	 * 模糊匹配楼盘
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesListByMatch")
	public String getPremisesListByMatch(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("addrDist/addrDistService.getPremisesListByMatch", param);
		return access.getData();
	}

	/**
	 * 楼栋分组下拉框
	 */
	@ResponseBody
	@RequestMapping(value = "getGroup")
	public String getGroup(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("addrDist/addrDistService.getGroup", param);
		return access.getData();
	}

	/**
	 * 楼栋下拉框
	 */
	@ResponseBody
	@RequestMapping(value = "getBuilding")
	public String getBuilding(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("addrDist/addrDistService.getBuilding", param);
		return access.getData();
	}

	/**
	 * 单元/商铺下拉框
	 */
	@ResponseBody
	@RequestMapping(value = "getUnit")
	public String getUnit(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("addrDist/addrDistService.getUnit", param);
		return access.getData();
	}

	/**
	 * 地址库查询页面
	 */
	@RequestMapping(value = "addrSaleDist")
	public String addrSaleDist(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		param.put("pid", "934");
		ResultValue areaList = addrService.access("area/areaService.getAreaByMatchOfLevel3", param);
		model.addAttribute("areaList", areaList.getJsonArray());
		model.addAttribute("dutyAreaList", oaService.getDaQuOrgList());
		return "dist/addrSaleDistIndex";
	}

	/**
	 * 获取地址库列表
	 */
	@ResponseBody
	@RequestMapping(value = "getSaleAddrDistList")
	public String getSaleAddrDistList(@RequestParam Map<String, Object> param) {
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = addrService.access("addrDist/addrDistService.getSaleAddrDistList", param);
		return result.getData();
	}

	/**
	 * 地址分配页面
	 */
	@RequestMapping(value = "saleAssignment")
	public String saleAssignment(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		model.addAttribute("saleAddress", param.get("saleAddress").toString().replaceAll(",", " "));
		ResultValue assignmentMap = addrService.access("addrDist/addrDistService.getSaleAssignment", param);
		model.addAttribute("assignmentMap", assignmentMap.getJsonObject());
		model.addAttribute("dutyAreaList", oaService.getDaQuOrgList());
		return "dist/saleAssignment";
	}

	/**
	 * 添加分配
	 */
	@ResponseBody
	@RequestMapping(value = "addSaleAssignment")
	public String addSaleAssignment(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("addrDist/addrDistService.addSaleAssignment", param);
		return access.getData();
	}

	/**
	 * 地址库查询页面
	 */
	@RequestMapping(value = "addrLeaseDist")
	public String addrLeaseDist(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		param.put("pid", "934");
		ResultValue areaList = addrService.access("area/areaService.getAreaByMatchOfLevel3", param);
		model.addAttribute("areaList", areaList.getJsonArray());
		model.addAttribute("dutyAreaList", oaService.getDaQuOrgList());
		return "dist/addrLeaseDistIndex";
	}

	/**
	 * 获取地址库列表
	 */
	@ResponseBody
	@RequestMapping(value = "getLeaseAddrDistList")
	public String getLeaseAddrDistList(@RequestParam Map<String, Object> param) {
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = addrService.access("addrDist/addrDistService.getLeaseAddrDistList", param);
		return result.getData();
	}

	/**
	 * 地址分配页面
	 */
	@RequestMapping(value = "leaseAssignment")
	public String leaseAssignment(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		model.addAttribute("leaseAddress", param.get("leaseAddress").toString().replaceAll(",", " "));
		ResultValue assignmentMap = addrService.access("addrDist/addrDistService.getLeaseAssignment", param);
		model.addAttribute("assignmentMap", assignmentMap.getJsonObject());
		model.addAttribute("dutyAreaList", oaService.getDaQuOrgList());
		return "dist/leaseAssignment";
	}

	/**
	 * 添加分配
	 */
	@ResponseBody
	@RequestMapping(value = "addLeaseAssignment")
	public String addLeaseAssignment(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("addrDist/addrDistService.addLeaseAssignment", param);
		return access.getData();
	}
}
