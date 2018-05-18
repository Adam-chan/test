package com.golden.crm.web.controller.customerSource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author weizhichao 类名称：客源管理Controller 类描述：客源管理 时间：2016-11-02
 */
@RequestMapping(value = "customerSource")
@Controller
public class CustomerSourceController {

	@Resource(name = "crmService")
	private IServiceStore crmService;
	@Resource(name = "oaService")
	private OAService oaService;

	/**
	 * 客源管理初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "custSourceIndex")
	public String customerIndex(HttpServletRequest request,
			@RequestParam Map<String, Object> map) throws IOException {
		ResultValue result = crmService.access(
				"ownerSource/ownerSourceService.getParentSources", null);
		request.setAttribute("parentSourceList", result.getJsonArray());
		request.setAttribute("quOrgList", oaService.getQuOrgList());

		return "customerSource/customer_source_index";
	}

	/**
	 * 分页查询客源管理
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCustomerSourcePage")
	public String getCustomerSourcePage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getCustomerSourcePage",
				map);
		return result.getData();
	}

	/**
	 * 添加客源初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAddCustomerSource")
	public String toAddCustomer(@RequestParam Map<String, Object> map,
			ModelMap model) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService", map);
		model.addAttribute("sysHouseKHPJList", result.getJsonArray());
		ResultValue result2 = crmService.access(
				"ownerSource/ownerSourceService.getParentSources", null);
		model.addAttribute("parentSourceList", result2.getJsonArray());
		return "customerSource/customerSourceAdd_Update";
	}

	/**
	 * 业主来源(子)
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSourcesByParentId")
	public String getSourcesByParentId(@RequestParam Map<String, Object> map) {
		ResultValue result = crmService.access(
				"ownerSource/ownerSourceService.getSourcesByParentId", map);
		return result.getData();
	}

	/**
	 * 添加客源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addCustomerSource")
	public String addCustomerSource(@RequestParam Map<String, Object> map,
			HttpSession session) {
		String userName = session.getAttribute(
				AihomeConst.SESSION_USER_NAME_KEY).toString();
		String userId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY)
				.toString();
		String orgCode = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY)
				.toString();
		String orgName = session.getAttribute(AihomeConst.SESSION_ZU_KEY)
				.toString();
		map.put("operateUser", userName);
		map.put("operateUserId", userId);
		map.put("orgCode", orgCode);
		map.put("orgName", orgName);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.addCustomerSource", map);
		return result.getData();
	}

	/**
	 * 约带看管理初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "takeLook")
	public String takeLook(ModelMap model, @RequestParam Map<String, Object> map)
			throws IOException {
		model.addAttribute("quOrgList", oaService.getQuOrgList());
		return "customerSource/take_look_index";
	}

	/**
	 * 分页查询约带看管理
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getLookManagePage")
	public String getLookManagePage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getLookManagePage", map);
		return result.getData();
	}

	/**
	 * 约带看房源添加初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "toTakeLookCust")
	public String toTakeLookCust(HttpServletRequest request,
			@RequestParam Map<String, Object> map) throws IOException {

		return "customerSource/to_cust_take_look";
	}

	/**
	 * 约带看楼盘添加初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "toTakeLookPremises")
	public String toTakeLookPremises(ModelMap model,
			@RequestParam Map<String, Object> map) throws IOException {

		ResultValue busiZoningList = crmService.access(
				"customerSource/customerSourceService.getBusiZoningAll", map);
		model.addAttribute("busiZoningList", busiZoningList.getJsonArray());

		return "customerSource/to_premises_take_look";
	}

	/**
	 * 添加约带看
	 * 
	 * @return
	 */
	@RequestMapping(value = "addAppointTakeLook")
	public String addAppointTakeLook(@RequestParam Map<String, Object> map,
			ModelMap model) {
		model.addAttribute("userNameCust", map.get("userName"));
		model.addAttribute("demandCodeCust", map.get("demandCode"));
		model.addAttribute("addCustomerId", map.get("addCustomerId"));
		model.addAttribute("demandType", map.get("demandType"));
		model.addAttribute("premisesId", map.get("premisesId"));
		model.addAttribute("houseInfoId", map.get("houseInfoId"));
		model.addAttribute("promiseDateStr", map.get("promiseDateStr"));
		model.addAttribute("takeDateStr", map.get("takeDateStr"));
		model.addAttribute("takeUser", map.get("takeUser"));
		model.addAttribute("operateUser", map.get("operateUser"));
		model.addAttribute("accompany", map.get("accompany"));
		return "customerSource/add_appoint_take_look";
	}

	/**
	 * 跟进详情初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "getFollowRecords")
	public String getFollowRecords(@RequestParam Map<String, Object> map,
			HttpServletRequest request) {
		request.setAttribute("HouseInfoId", map.get("HouseInfoId"));
		return "customerSource/get_follow_records";
	}

	/**
	 * 分页查询约带看房源
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseSourcePage")
	public String getHouseSourcePage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);

		String demandType = map.get("demandType").toString();
		if (null != demandType && demandType.equals("2")) {
			ResultValue result = crmService.access(
					"customerSource/customerSourceService.getHouseLeasePage",
					map);
			return result.getData();
		} else if (null != demandType && demandType.equals("1")) {
			ResultValue result = crmService.access(
					"customerSource/customerSourceService.getHouseSalePage",
					map);
			return result.getData();
		} else {
			return null;
		}
	}

	/**
	 * 分页查询约带看房源
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesPage")
	public String getPremisesPage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getPremisesPage", map);
		return result.getData();
	}

	/**
	 * 分页查询跟进详情
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getFollowRecordsPage")
	public String getFollowRecordsPage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getFollowRecordsPage",
				map);
		return result.getData();
	}

	/**
	 * 客源详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "customerSourceDetail")
	public String getCustomerDetail(@RequestParam Map<String, Object> map,
			ModelMap model) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getCustomerSourceById",
				map);
		if (result.getJsonObject().get("demandRegion") != null) {
			String demandRegionName = result.getJsonObject()
					.get("demandRegion").toString();
			String firstDemandRegionName = demandRegionName.substring(
					0,
					demandRegionName.indexOf(",") > 0 ? demandRegionName
							.indexOf(",") : demandRegionName.length());
			String otherDemandRegionName = demandRegionName
					.substring(demandRegionName.indexOf(",") > 0 ? demandRegionName
							.indexOf(",") + 1 : demandRegionName.length());
			model.addAttribute("firstDemandRegionName", firstDemandRegionName);
			model.addAttribute("otherDemandRegionName", otherDemandRegionName);
		}
		model.addAttribute("source", result.getJsonObject());
		return "customerSource/customerSourceDetail";
	}

	/**
	 * 保存添加房源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveCustTakeLook")
	public String saveCustTakeLook(@RequestParam Map<String, Object> map,
			HttpSession session) {
		String operateOrgCode = session.getAttribute(
				AihomeConst.SESSION_ORG_CODE_KEY).toString();
		String operateUserId = session.getAttribute(
				AihomeConst.SESSION_USER_ID_KEY).toString();
		String operateUser = session.getAttribute(
				AihomeConst.SESSION_USER_NAME_KEY).toString();
		map.put("operateOrgCode", operateOrgCode);
		map.put("operateUserId", operateUserId);
		map.put("operateUser", operateUser);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.saveCustTakeLook", map);
		return result.getData();
	}

	/**
	 * 根据约带看id删除一条约带看记录
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteCustPromisebyId")
	public String deleteCustPromisebyId(@RequestParam Map<String, Object> map) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.deleteCustPromisebyId",
				map);
		return result.getData();
	}

	/**
	 * 保存添加楼盘
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "savePremisesTakeLook")
	public String savePremisesTakeLook(@RequestParam Map<String, Object> map,
			HttpSession session) {
		String operateOrgCode = session.getAttribute(
				AihomeConst.SESSION_ORG_CODE_KEY).toString();
		String operateUserId = session.getAttribute(
				AihomeConst.SESSION_USER_ID_KEY).toString();
		String operateUser = session.getAttribute(
				AihomeConst.SESSION_USER_NAME_KEY).toString();
		map.put("operateOrgCode", operateOrgCode);
		map.put("operateUserId", operateUserId);
		map.put("operateUser", operateUser);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.savePremisesTakeLook",
				map);
		return result.getData();
	}

	/**
	 * 模糊查询获取商圈列表
	 * 
	 * @return List<BusiAreaModel>
	 */
	@ResponseBody
	@RequestMapping(value = "getBusiNameList")
	public String getBusiNameList(@RequestParam Map<String, Object> map) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getBusiNameList", map);
		return result.getData();
	}

	/**
	 * 模糊匹配楼盘
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesListByMatch")
	public String getAreaListByMatch(@RequestParam Map<String, Object> map) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getPremisesListByMatch",
				map);
		return result.getData();
	}

	/**
	 * 转成交客户池
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "toDealCustomerPool")
	public String toDealCustomerPool(@RequestParam Map<String, Object> map) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.toDealCustomerPool", map);
		return result.getData();
	}

	/**
	 * 模糊匹配楼盘
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesName")
	public String getPremisesName(@RequestParam Map<String, Object> param) {
		ResultValue access = crmService.access(
				"customerSource/customerSourceService.getPremisesName", param);
		return access.getData();
	}

	/**
	 * 客源修改初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "toUpdateCustomerSource")
	public String toUpdateCustomerSource(@RequestParam Map<String, Object> map,
			ModelMap model) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getCustomerSourceById",
				map);
		if (result.getJsonObject().get("demandRegionIds") != null) {
			String demandRegionIds = result.getJsonObject()
					.get("demandRegionIds").toString();
			String firstDemandRegionId = demandRegionIds.substring(
					0,
					demandRegionIds.indexOf(",") > 0 ? demandRegionIds
							.indexOf(",") : demandRegionIds.length());
			String demandRegionName = result.getJsonObject()
					.get("demandRegion").toString();
			String firstDemandRegionName = demandRegionName.substring(
					0,
					demandRegionName.indexOf(",") > 0 ? demandRegionName
							.indexOf(",") : demandRegionName.length());
			String otherDemandRegionIds = demandRegionIds
					.substring(demandRegionIds.indexOf(",") > 0 ? demandRegionIds
							.indexOf(",") + 1 : demandRegionIds.length());
			map.put("inIds", otherDemandRegionIds);
			ResultValue otherDemandRegionList = crmService
					.access("customerSource/customerSourceService.getBusiNameList",
							map);
			map.put("inIds", result.getJsonObject().get("demandPremisesIds"));
			ResultValue demandPremisesList = crmService
					.access("customerSource/customerSourceService.getPremisesListByMatch",
							map);
			model.addAttribute("firstDemandRegionId", firstDemandRegionId);
			model.addAttribute("firstDemandRegionName", firstDemandRegionName);
			model.addAttribute("otherDemandRegionList",
					otherDemandRegionList.getJsonArray());
			model.addAttribute("demandPremisesList",
					demandPremisesList.getJsonArray());
		}
		model.addAttribute("source", result.getJsonObject());
		return "customerSource/customerSourceUpdate";
	}

	/**
	 * 修改客源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateCustomerSource")
	public String updateCustomerSource(@RequestParam Map<String, Object> map,
			HttpSession session) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.updateCustomerSource",
				map);
		return result.getData();
	}

	/**
	 * 取消约带看
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "cancelLookManage")
	public String cancelLookManage(@RequestParam Map<String, Object> map,
			HttpSession session) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.cancelLookManage", map);
		return result.getData();
	}

	/**
	 * 根据id查询楼盘
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesByid")
	public String getPremisesByid(@RequestParam Map<String, Object> param,
			ModelMap model) {
		ResultValue result1 = crmService.access(
				"customerSource/customerSourceService.getPremisesByid", param);
		model.addAttribute("premisesModel", result1.getJsonObject());
		return result1.getData();
	}

	/**
	 * 根据id查询房源
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseById")
	public String getHouseById(@RequestParam Map<String, Object> map,
			ModelMap model) {

		String demandType = map.get("demandType").toString();
		ResultValue result = null;
		if ("2".equals(demandType)) {
			result = crmService.access(
					"customerSource/customerSourceService.getHouseLeaseById",
					map);
		} else if ("1".equals(demandType)) {
			result = crmService.access(
					"customerSource/customerSourceService.getHouseSaleById",
					map);
		}

		return result.getData();
	}

	/**
	 * 客源推荐房源tab
	 * 
	 * @return
	 */
	@RequestMapping(value = "getRecommendPage")
	public String getRecommendPage(@RequestParam Map<String, Object> map,
			ModelMap model) {
		model.addAttribute("custDemandId", map.get("custDemandId"));
		return "customerSource/cus_recommend_tab";
	}

	/**
	 * 分页查询推荐房源
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCustomerRecommendPage")
	public String getCustomerRecommendPage(@RequestParam Map<String, Object> map)
			throws IOException {
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		String demandType = map.get("demandType").toString();
		ResultValue result = null;
		if ("2".equals(demandType)) {
			result = crmService
					.access("customerSource/customerSourceService.getCustomerLeaseRecommendPage",
							map);
		} else if ("1".equals(demandType)) {
			result = crmService
					.access("customerSource/customerSourceService.getCustomerSaleRecommendPage",
							map);
		}
		return result.getData();
	}

	/**
	 * 设置为保护客源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "setProtectedCust")
	public String saveCustTakeLook(@RequestParam Map<String, Object> map) {

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.setProtectedCust", map);
		return result.getData();
	}

	/**
	 * 取消保护该客源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "cancelProtectedCust")
	public String cancelProtectedCust(@RequestParam Map<String, Object> map) {

		ResultValue result = crmService
				.access("customerSource/customerSourceService.cancelProtectedCust",
						map);
		return result.getData();
	}

	/**
	 * 客源转介页面初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "transferCustomer")
	public String transferCustomer(@RequestParam Map<String, Object> map,
			ModelMap model, HttpSession session) {
		model.addAttribute("quOrgList", oaService.getQuOrgList());
		String zuCode = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY)
				.toString();
		String quName = session.getAttribute(AihomeConst.SESSION_QU_KEY)
				.toString();
		String quCode = zuCode.substring(0, 12);
		model.addAttribute("quCode", quCode);
		model.addAttribute("quCodeName", quName);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.transferCustomer", map);
		model.addAttribute("sysHouseLPTPFLList", result.getJsonArray());
		return "customerSource/transfer_customer";
	}

	/**
	 * 客源调配页面初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "dispatchCustomerSource")
	public String dispatchCustomerSource(@RequestParam Map<String, Object> map,
			ModelMap model, HttpSession session) {
		model.addAttribute("quOrgList", oaService.getQuOrgList());
		String zuCode = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY)
				.toString();
		String quName = session.getAttribute(AihomeConst.SESSION_QU_KEY)
				.toString();
		String zuName = session.getAttribute(AihomeConst.SESSION_ZU_KEY)
				.toString();
		String quCode = zuCode.substring(0, 12);
		model.addAttribute("renCode", oaService.getOrgUserList(zuCode));
		model.addAttribute("zuCode", zuCode);
		model.addAttribute("quCode", quCode);
		model.addAttribute("quCodeName", quName);
		model.addAttribute("zuCodeName", zuName);

		return "customerSource/dispatch_customer_source";
	}

	/**
	 * 客源回访页面初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "callBackCustomer")
	public String callBackCustomer(@RequestParam Map<String, Object> map,
			ModelMap model) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getCustomerSourceById",
				map);
		if (result.getJsonObject().get("demandRegionIds") != null) {
			String demandRegionIds = result.getJsonObject()
					.get("demandRegionIds").toString();
			String firstDemandRegionId = demandRegionIds.substring(
					0,
					demandRegionIds.indexOf(",") > 0 ? demandRegionIds
							.indexOf(",") : demandRegionIds.length());
			String demandRegionName = result.getJsonObject()
					.get("demandRegion").toString();
			String firstDemandRegionName = demandRegionName.substring(
					0,
					demandRegionName.indexOf(",") > 0 ? demandRegionName
							.indexOf(",") : demandRegionName.length());
			String otherDemandRegionIds = demandRegionIds
					.substring(demandRegionIds.indexOf(",") > 0 ? demandRegionIds
							.indexOf(",") + 1 : demandRegionIds.length());
			map.put("inIds", otherDemandRegionIds);
			ResultValue otherDemandRegionList = crmService
					.access("customerSource/customerSourceService.getBusiNameList",
							map);
			map.put("inIds", result.getJsonObject().get("demandPremisesIds"));
			ResultValue demandPremisesList = crmService
					.access("customerSource/customerSourceService.getPremisesListByMatch",
							map);
			model.addAttribute("firstDemandRegionId", firstDemandRegionId);
			model.addAttribute("firstDemandRegionName", firstDemandRegionName);
			model.addAttribute("otherDemandRegionList",
					otherDemandRegionList.getJsonArray());
			model.addAttribute("demandPremisesList",
					demandPremisesList.getJsonArray());
		}
		model.addAttribute("source", result.getJsonObject());

		ResultValue promiseModel = crmService
				.access("customerSource/customerSourceService.getPromiseModelById",
						map);
		model.addAttribute("promiseModel", promiseModel.getJsonObject());
		model.addAttribute("demandId", map.get("id").toString());
		return "customerSource/call_back_customer";
	}

	/**
	 * 根据id查询该客源是否有处于新建的约带看
	 */
	@ResponseBody
	@RequestMapping(value = "getTakeLookCount")
	public String getTakeLookCount(@RequestParam Map<String, Object> map,
			ModelMap model) {

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getTakeLookCount", map);

		return result.getData();
	}

	/**
	 * 根据id查询该客源是否需要回访
	 */
	@ResponseBody
	@RequestMapping(value = "getTakeLookDoneCount")
	public String getTakeLookDoneCount(@RequestParam Map<String, Object> map,
			ModelMap model) {

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getTakeLookDoneCount",
				map);

		return result.getData();
	}

	/**
	 * 添加推荐房源页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAddRecommend")
	public String toAddRecommend(@RequestParam Map<String, Object> map,
			ModelMap model) {
		model.addAttribute("demandType", map.get("demandType"));
		model.addAttribute("propertyType", map.get("propertyType"));
		return "customerSource/cus_recommend_add";
	}

	/**
	 * 保存推荐房源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "recommend")
	public String recommend(@RequestParam Map<String, Object> map,
			HttpSession session) {
		String userName = session.getAttribute(
				AihomeConst.SESSION_USER_NAME_KEY).toString();
		String userId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY)
				.toString();
		map.put("recommendUser", userName);
		map.put("recommendUserId", userId);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.recommend", map);
		return result.getData();
	}

	/**
	 * 删除推荐房源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteRecommend")
	public String deleteRecommend(@RequestParam Map<String, Object> map,
			HttpSession session) {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.deleteRecommend", map);
		return result.getData();
	}

	/**
	 * 客源约带看tab
	 * 
	 * @return
	 */
	@RequestMapping(value = "getTakeLookPage")
	public String getTakeLookPage(@RequestParam Map<String, Object> map,
			ModelMap model) {
		model.addAttribute("custDemandId", map.get("custDemandId"));
		return "customerSource/cus_take_look_tab";
	}

	/**
	 * 分页查询跟进tab
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTakeLookTabPage")
	public String getTakeLookTabPage(@RequestParam Map<String, Object> map)
			throws IOException {
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getTakeLookTabPage", map);
		return result.getData();
	}

	/**
	 * 客源跟进tab
	 * 
	 * @return
	 */
	@RequestMapping(value = "getFollowPage")
	public String getFollowPage(@RequestParam Map<String, Object> map,
			ModelMap model) {
		model.addAttribute("custDemandId", map.get("custDemandId"));
		return "customerSource/cus_follow_tab";
	}

	/**
	 * 分页查询跟进tab
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getFollowTabPage")
	public String getFollowTabPage(@RequestParam Map<String, Object> map)
			throws IOException {
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getFollowTabPage", map);
		return result.getData();
	}

	/**
	 * 保存客源回访信息
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveCustCallBack")
	public String saveCustCallBack(@RequestParam Map<String, Object> map,
			HttpSession session) throws IOException {

		map.put("operateUser",
				session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY)
						.toString());
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.saveCustCallBack", map);
		return result.getData();
	}

	/**
	 * 客源回访初始化页面
	 * 
	 * @param params
	 */
	@RequestMapping(value = "custCallBackIndex")
	public String custCallBackIndex(@RequestParam Map<String, Object> map) {

		return "customerSource/customer_call_back_index";
	}

	/**
	 * 分页查询客源管理
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCustCallBackPage")
	public String getCustCallBackPage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);

		ResultValue result = crmService
				.access("customerSource/customerSourceService.getCustCallBackPage",
						map);
		return result.getData();
	}

	/**
	 * 添加跟进页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAddFollow")
	public String toAddFollow(@RequestParam Map<String, Object> map,
			ModelMap model, HttpSession session) throws IOException {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String dateStr = dateFormat.format(date);
		model.addAttribute("dateStr", dateStr);
		model.addAttribute("operateUser",
				session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY)
						.toString());
		model.addAttribute("custDemandId", map.get("custDemandId"));
		return "customerSource/cus_follow_add";
	}

	/**
	 * 保存客源跟进信息
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "follow")
	public String follow(@RequestParam Map<String, Object> map,
			HttpSession session) throws IOException {
		map.put("operateUser",
				session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY)
						.toString());
		map.put("operateUserId",
				session.getAttribute(AihomeConst.SESSION_USER_ID_KEY)
						.toString());
		map.put("orgCode",
				session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY)
						.toString());
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.follow", map);
		return result.getData();
	}

	/**
	 * 客源分配tab页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "getDispatchPage")
	public String getDispatchPage(@RequestParam Map<String, Object> map,
			ModelMap model, HttpSession session) throws IOException {
		model.addAttribute("custDemandId", map.get("custDemandId"));
		return "customerSource/cus_dispatch_tab";
	}

	/**
	 * 分页查询分配tab
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getDispatchTabPage")
	public String getDispatchPage(@RequestParam Map<String, Object> map,
			ModelMap model) throws IOException {
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getDispatchPage", map);
		return result.getData();
	}

	/**
	 * 将客源转入公客池
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveCustToPubPool")
	public String saveCustToPubPool(@RequestParam Map<String, Object> map)
			throws IOException {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.saveCustToPubPool", map);
		return result.getData();
	}

	/**
	 * 转成交客户池页面初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "dealCustomerPoolIndex")
	public String dealCustomerPoolIndex(@RequestParam Map<String, Object> map)
			throws IOException {

		return "customerPool/deal_customer_pool_index";
	}

	/**
	 * 保存调配客源
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveDispatchCustSource")
	public String saveDispatchCustSource(@RequestParam Map<String, Object> map)
			throws IOException {
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.saveDispatchCustSource",
				map);
		return result.getData();
	}

	/**
	 * 保存转介客源
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "transferCustomerToOther")
	public String transferCustomerToOther(
			@RequestParam Map<String, Object> map, HttpSession session) {
		map.put("transferUserId",
				session.getAttribute(AihomeConst.SESSION_USER_ID_KEY)
						.toString());
		map.put("transferUser",
				session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY)
						.toString());
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.transferCustomerToOther",
				map);
		return result.getData();
	}

	/**
	 * 客源转介初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "custTransferIndex")
	public String custTransferIndex(ModelMap model, HttpSession session)
			throws IOException {
		model.put("currentUser",
				session.getAttribute(AihomeConst.SESSION_USER_ID_KEY)
						.toString());
		return "customerSource/cust_transfer_index";
	}

	/**
	 * 分页查询客源转介
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCustTransferPage")
	public String getCustTransferPage(@RequestParam Map<String, Object> map)
			throws IOException {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);

		ResultValue result = crmService
				.access("customerSource/customerSourceService.getCustTransferPage",
						map);
		return result.getData();
	}

	/**
	 * 确认接收转介客源
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "confirmReceiveTransfer")
	public String confirmReceiveTransfer(@RequestParam Map<String, Object> map) {

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.confirmReceiveTransfer",
				map);
		return result.getData();
	}

	/**
	 * 拒绝接收转介客源
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "refuseReceiveTransfer")
	public String refuseReceiveTransfer(@RequestParam Map<String, Object> map) {

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.refuseReceiveTransfer",
				map);
		return result.getData();
	}

	/**
	 * 根据客源id查询该客源的保护状态
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getProtectedByDemandId")
	public String getProtectedByDemandId(@RequestParam Map<String, Object> map) {

		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getProtectedByDemandId",
				map);
		return result.getData();
	}

	/**
	 * 根据客源id查询该客源的cdType状态
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getDealedByDemandId")
	public String getDealedByDemandId(@RequestParam Map<String, Object> map) {

		ResultValue result = crmService
				.access("customerSource/customerSourceService.getDealedByDemandId",
						map);
		return result.getData();
	}

	/**
	 * 客源回访约带看初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getCallBackPromiseIndex")
	public String getCallBackPromiseIndex(@RequestParam Map<String, Object> map ,ModelMap model)
			throws IOException {
		model.addAttribute("demandId", map.get("demandId").toString());
		model.addAttribute("takeDate", map.get("takeDate").toString());
		
		return "customerSource/show_promise_detail";
	}

	/**
	 * 分页查询客源回访约带看详情
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCallBackPromisePage")
	public String getCallBackPromisePage(@RequestParam Map<String, Object> map) {

		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = crmService.access(
				"customerSource/customerSourceService.getCallBackPromisePage",
				map);
		return result.getData();
	}

}
