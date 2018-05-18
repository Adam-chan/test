package com.golden.addr.web.controller.premisesManage;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author ChenHuan
 * 类名称：楼盘管理Controller
 * 类描述：楼盘管理的锁定、解锁、新增、修改等
 * 时间：2016-10-08
 */
@Controller
@RequestMapping(value = "premisesManage")
public class PremisesManageController {

	@Resource(name="addrService")
	private IServiceStore addrService;

	/**
	 * 楼盘管理查询页面
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		ResultValue busiZoninglist = addrService.access("busiArea/busiAreaService.getbusiZoningAll", param);
		model.addAttribute("busiZoninglist", busiZoninglist.getJsonArray());
		return "premisesManage/premisesIndex";
	}

	/**
	 * 获取楼盘管理列表
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesList")
	public String getPremisesList(@RequestParam Map<String, Object> param) {
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = addrService.access("basePremises/basePremisesService.getPremisesPage", param);
		return result.getData();
	}

	/**
	 * 商圈下拉框
	 */
	@ResponseBody
	@RequestMapping(value = "getQueryBusiArea")
	public String getQueryBusiArea(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("busiArea/busiAreaService.getQueryBusiArea", param);
		return access.getData();
	}

	/**
	 * 隐藏/显示
	 */
	@ResponseBody
	@RequestMapping(value = "updateHidden")
	public String updateHidden(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.updateHidden", param);
		return access.getData();
	}

	/**
	 * 买卖封盘/买卖解封
	 */
	@ResponseBody
	@RequestMapping(value = "updateSaleSeal")
	public String updateSaleSeal(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.updateSaleSeal", param);
		return access.getData();
	}

	/**
	 * 租赁封盘/租赁解封
	 */
	@ResponseBody
	@RequestMapping(value = "updateLeaseSeal")
	public String updateLeaseSeal(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.updateLeaseSeal", param);
		return access.getData();
	}

	/**
	 * 楼盘新增/修改
	 */
	@RequestMapping(value = "premisesInfo")
	public String premisesInfo(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		if(param.get("premisesId") != null) {
			ResultValue basePremisesModel = addrService.access("basePremises/basePremisesService.queryPremises", param);
			model.addAttribute("basePremisesModel", basePremisesModel.getJsonObject());
			param.put("inIds", basePremisesModel.getJsonObject().get("eduIds"));
			ResultValue eduList = addrService.access("basePremises/basePremisesService.getEduListByMatch", param);
			model.addAttribute("eduList", eduList.getJsonArray());
			param.put("trafficType", 1);
			param.put("inIds", basePremisesModel.getJsonObject().get("busStation"));
			ResultValue busStationList = addrService.access("basePremises/basePremisesService.getSiteLineListByMatch", param);
			model.addAttribute("busStationList", busStationList.getJsonArray());
			param.put("trafficType", 2);
			param.put("inIds", basePremisesModel.getJsonObject().get("subwayStation"));
			ResultValue subwayStationList = addrService.access("basePremises/basePremisesService.getSiteLineListByMatch", param);
			model.addAttribute("subwayStationList", subwayStationList.getJsonArray());
		}
		if(param.get("tableContent") != null) {
			model.addAttribute("tableContent", param.get("tableContent"));
		}
		if(param.get("auditingStatus") != null) {
			model.addAttribute("auditingStatus", param.get("auditingStatus"));
		}
		return "premisesManage/premisesInfo";
	}

	/**
	 * 新增楼盘
	 */
	@ResponseBody
	@RequestMapping(value = "addPremises")
	public String addPremises(@RequestParam Map<String, Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.addPremises", param);
		return access.getData();
	}

	/**
	 * 修改楼盘
	 */
	@ResponseBody
	@RequestMapping(value = "updatePremises")
	public String updatePremises(@RequestParam Map<String, Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.updatePremises", param);
		return access.getData();
	}

	/**
	 * 删除楼盘
	 */
	@ResponseBody
	@RequestMapping(value = "deletePremises")
	public String deletePremises(@RequestParam Map<String, Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.deletePremises", param);
		return access.getData();
	}

	/**
	 * 模糊匹配详细地址
	 */
	@ResponseBody
	@RequestMapping(value = "getAddrDetail")
	public String getAddrDetail(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.getAddrDetail", param);
		return access.getData();
	}

	/**
	 * 模糊匹配站点线路
	 */
	@ResponseBody
	@RequestMapping(value = "getSiteLineListByMatch")
	public String getSiteLineListByMatch(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.getSiteLineListByMatch", param);
		return access.getData();
	}

	/**
	 * 模糊匹配教育设施
	 */
	@ResponseBody
	@RequestMapping(value = "getEduListByMatch")
	public String getEduListByMatch(@RequestParam Map<String,Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.getEduListByMatch", param);
		return access.getData();
	}

	/**
	 * 提交审核
	 */
	@ResponseBody
	@RequestMapping(value = "auditingPremises")
	public String auditingPremises(@RequestParam Map<String, Object> param) {
		ResultValue access = addrService.access("basePremises/basePremisesService.auditingPremises", param);
		return access.getData();
	}

	/**
	 * 保存成功回调窗口
	 */
	@RequestMapping(value = "returnLayout")
	public String returnLayout(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		if(param.get("premisesId") != null) {
			model.addAttribute("premisesId", param.get("premisesId"));
		}
		if(param.get("premisesName") != null) {
			model.addAttribute("premisesName", param.get("premisesName"));
		}
		if(param.get("areaId") != null) {
			model.addAttribute("areaId", param.get("areaId"));
		}
		return "premisesManage/returnLayout";
	}
}
