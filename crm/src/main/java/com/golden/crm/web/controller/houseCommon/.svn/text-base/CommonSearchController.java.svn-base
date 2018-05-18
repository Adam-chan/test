package com.golden.crm.web.controller.houseCommon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
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
 * @author ChenHuan
 * 类名称：房源公共查询按钮Controller
 * 类描述：房源的收藏、实勘、跟进、空看等
 * 时间：2016-10-08
 */
@Controller
@RequestMapping(value = "commonSearch")
public class CommonSearchController {

	@Resource(name="crmService")
	private IServiceStore crmService;

	@Resource(name="oaService")
	private OAService oaService;

	@RequestMapping(value = "index")
	public String index(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		return null;
	}

	/**
	 * 收藏
	 */
	@ResponseBody
	@RequestMapping(value = "addCollect")
	public String addCollect(@RequestParam Map<String,Object> param, HttpSession session) {
		param.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString());
		ResultValue access = crmService.access("house/commonSearchService.addCollect", param);
		return access.getData();
	}

	/**
	 * 取消收藏
	 */
	@ResponseBody
	@RequestMapping(value = "deleteCollect")
	public String deleteCollect(@RequestParam Map<String,Object> param) {
		ResultValue access = crmService.access("house/commonSearchService.deleteCollect", param);
		return access.getData();
	}

	/**
	 * 实勘页面
	 */
	@RequestMapping(value = "openProspect")
	public String openProspect(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
//		ResultValue result = crmService.access("house/commonSearchService.getManageProspectInfo", param);
		// 房源ID
		model.put("houseInfoId", param.get("houseInfoId"));
		// 房源编号
		model.put("houseCode", param.get("houseCode"));
		// 建筑面积
		model.put("coveredArea", param.get("coveredArea"));
		// 室
		model.put("rooms", param.get("rooms"));
		// 厅
		model.put("office", param.get("office"));
		// 厨
		model.put("kitchen", param.get("kitchen"));
		// 卫
		model.put("wc", param.get("wc"));
//		model.addAttribute("prospectInfo", result.getJsonObject());
		return "houseCommon/openProspect";
	}
	
	/**
	 * 实勘信息
	 */
	@ResponseBody
	@RequestMapping(value = "getManageProspectInfo")
	public String getManageProspectInfo(@RequestParam Map<String,Object> map) throws IOException {
		ResultValue result = crmService.access("house/commonSearchService.getManageProspectInfo",map);
		return result.getData();
	}
	
	/**
	 * 实勘图片
	 */
	@ResponseBody
	@RequestMapping(value = "getManageProspectImagePage")
	public String getManageProspectImagePage(@RequestParam Map<String,Object> map) throws IOException {
		ResultValue result = crmService.access("house/commonSearchService.getManageProspectImagePage",map);
		return result.getData();
	}	
	
	/**
	 * 实勘上传页面
	 */
	@RequestMapping(value = "openProspectAdd")
	public String openProspectAdd(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		return "houseCommon/openProspectAdd";
	}	
	
	/**
	 * 保存实勘信息
	 */
	@ResponseBody
	@RequestMapping(value = "saveProspectInfo")
	public String saveProspectInfo(@RequestParam Map<String, Object> map, HttpSession session) {
		map.put("prospectUser", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		map.put("prospectUserId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString());
		map.put("prospectOrgCode", session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString());
		ResultValue result = crmService.access("house/commonSearchService.saveProspectInfo", map);
		return result.getData();
	}
	
	/**
	 * 查询插入的实勘ID
	 */
	@ResponseBody
	@RequestMapping(value = "getLastInsertProspectId")
	public String getLastInsertProspectId(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("house/commonSearchService.getLastInsertProspectId", map);
		return result.getData();
	}
	
	/**
	 * 保存上传的实勘图片
	 */
	@ResponseBody
	@RequestMapping(value = "saveProspectPicture")
	public String saveProspectPicture(@RequestParam Map<String, Object> map) {
		String dataStr = (String) map.get("dataStr");
		if (dataStr == "[]") {
			return "";
		}
		ResultValue result = crmService.access("house/commonSearchService.saveProspectPicture", map);
		return result.getData();
	}

	/**
	 * 删除实勘图片
	 */
	@ResponseBody
	@RequestMapping(value = "deletePicture")
	public String deletePicture(@RequestParam("idList") ArrayList<String> idList,@RequestParam Map<String, Object> map) {
		map.put("idList", idList);
		ResultValue result = crmService.access("house/commonSearchService.deletePicture", map);
		return result.getData();
	}
	
	/**
	 * 提交实勘
	 */
	@ResponseBody
	@RequestMapping(value = "submitProspect")
	public String submitProspect(@RequestParam Map<String, Object> map) {
		ResultValue result = crmService.access("house/commonSearchService.submitProspect", map);
		return result.getData();
	}
	
	/**
	 * 实勘上传户型图页面
	 */
	@RequestMapping(value = "openLayoutUpload")
	public String openLayoutUpload(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		return "houseCommon/openLayoutUpload";
	}
	
	/**
	 * 跟进页面
	 */
	@RequestMapping(value = "openFollow")
	public String openFollow(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		// 测试-房源ID
		model.put("houseInfoId", "19890412");
		return "houseCommon/openFollow";
	}

	/**
	 * 添加跟进
	 */
	@ResponseBody
	@RequestMapping(value = "addFollow")
	public String addFollow(@RequestParam Map<String,Object> param, HttpSession session) {
		param.put("followType", 1);
		param.put("operateUser", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		param.put("operateUserId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString());
		ResultValue access = crmService.access("house/commonSearchService.addFollow", param);
		return access.getData();
	}

	/**
	 * 空看页面
	 */
	@RequestMapping(value = "openSpaceSee")
	public String openSpaceSee(ModelMap model, @RequestParam Map<String, Object> param, HttpSession session) throws IOException {
		model.put("operateUser", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		return "houseCommon/openSpaceSee";
	}

	/**
	 * 添加空看
	 */
	@ResponseBody
	@RequestMapping(value = "addSpaceSee")
	public String addSpaceSee(@RequestParam Map<String,Object> param, HttpSession session) {
		param.put("operateUser", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		param.put("operateUserId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString());
		param.put("operateGroup", session.getAttribute(AihomeConst.SESSION_ZU_KEY).toString());
		param.put("operateGroupCode", session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString());
		param.put("orgCodelist", session.getAttribute(AihomeConst.SESSION_DATA_POWERS_KEY).toString());
		ResultValue access = crmService.access("house/commonSearchService.addSpaceSee", param);
		return access.getData();
	}

	/**
	 * 配客页面
	 */
	@RequestMapping(value = "openMatchCustomer")
	public String openMatchCustomer(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		// 房源ID
		model.put("houseInfoId", param.get("houseInfoId"));
		// 售价
		model.put("sellPrice", param.get("sellPrice"));
		// 建筑面积
		model.put("coveredArea", param.get("coveredArea"));
		// 楼层
		model.put("floorsNum", param.get("floorsNum"));
		// 装修情况
		model.put("decoradion", param.get("decoradion"));
		// 室
		model.put("rooms", param.get("rooms"));
		// 厅
		model.put("office", param.get("office"));
		// 厨
		model.put("kitchen", param.get("kitchen"));
		// 卫
		model.put("wc", param.get("wc"));
		// 楼盘名称
		model.put("premisesName", param.get("premisesName"));
		// 需求类型
		model.put("demandType", param.get("demandType"));
		// 物业类型
		model.put("propertyType", param.get("propertyType"));
		return "houseCommon/openMatchCustomer";
	}

	/**
	 * 配客列表
	 */
	@ResponseBody
	@RequestMapping(value = "getMatchCustomerListForPage")
	public String getMatchCustomerListForPage(@RequestParam Map<String, Object> param) {
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = crmService.access("house/commonSearchService.getMatchCustomerListForPage", param);
		return result.getData();
	}

	/**
	 * 收钥匙页面
	 */
	@RequestMapping(value = "openReceiveKey")
	public String openReceiveKey(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		// 测试-房源ID
		model.put("houseInfoId", "19890412");
		// 测试-房源Code
		model.put("houseCode", "210001");
		return "houseCommon/openReceiveKey";
	}

	/**
	 * 添加钥匙
	 */
	@ResponseBody
	@RequestMapping(value = "addKey")
	public String addKey(@RequestParam Map<String,Object> param) {
		ResultValue access = crmService.access("house/commonSearchService.addKey", param);
		return access.getData();
	}

	/**
	 * 保护页面
	 */
	@RequestMapping(value = "openProtect")
	public String openProtect(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		return "houseCommon/openProtect";
	}

	/**
	 * 保护列表
	 */
	@ResponseBody
	@RequestMapping(value = "getProtectListForPage")
	public String getProtectListForPage(@RequestParam Map<String, Object> param) {
		String currentPage = param.get("page").toString();
		String rowCount = param.get("rows").toString();
		param.put("currentPage", currentPage);
		param.put("rowCount", rowCount);
		ResultValue result = crmService.access("house/commonSearchService.getProtectListForPage", param);
		return result.getData();
	}

	/**
	 * 添加保护
	 */
	@ResponseBody
	@RequestMapping(value = "addProtect")
	public String addProtect(@RequestParam Map<String,Object> param, HttpSession session) {
		param.put("userName", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		param.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString());
		ResultValue access = crmService.access("house/commonSearchService.addProtect", param);
		return access.getData();
	}

	/**
	 * 委托书录入页面
	 */
	@RequestMapping(value = "openProxyInput")
	public String openProxyInput(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		ResultValue access = crmService.access("house/commonSearchService.queryProxyInput", param);
		if(access.getData() != null) {
			model.put("proxyInputInfo", access.getJsonObject());
		}
		return "houseCommon/openProxyInput";
	}

	/**
	 * 添加委托书
	 */
	@ResponseBody
	@RequestMapping(value = "addProxyInput")
	public String addProxyInput(@RequestParam Map<String,Object> param,HttpSession session) {
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		String sessionQuKey = session.getAttribute(AihomeConst.SESSION_QU_KEY).toString();
		String sessionZuKey = session.getAttribute(AihomeConst.SESSION_ZU_KEY).toString();
		param.put("operateUser", proposerUser);//操作员
		param.put("operateUserId", proposerUserId);//操作员Id
		param.put("operateOrg", sessionZuKey);//操作员组名
		param.put("operateOrgCode", sessionOrgCodeKey);//操作员组织结构编号
		param.put("operateZone", sessionQuKey);//操作员所属区
		ResultValue access = crmService.access("house/commonSearchService.addProxyInput", param);
		return access.getData();
	}

	/**
	 * 撤销委托书
	 */
	@ResponseBody
	@RequestMapping(value = "deleteProxyInput")
	public String deleteProxyInput(@RequestParam Map<String,Object> param) {
		ResultValue access = crmService.access("house/commonSearchService.deleteProxyInput", param);
		return access.getData();
	}

	/**
	 * 模糊匹配员工信息
	 */
	@ResponseBody
	@RequestMapping(value = "personnelInfoList")
	public String personnelInfoList(@RequestParam Map<String, Object> param) {
		return oaService.personnelInfoList(param);
	}
	/**
	 * 打假页面
	 */
	@RequestMapping(value = "openAntiCounterfeiting")
	public String openAntiCounterfeiting(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		ResultValue access = crmService.access("house/commonSearchService.queryFakeInfo", param);
		model.addAttribute("result",access.getJsonObject());
		model.addAttribute("transType",param.get("transType").toString());
		return "houseCommon/openFake";
	}
	/**
	 * 提交房源打假
	 */
	@ResponseBody
	@RequestMapping(value = "saveHouseFake")
	public String saveHouseFake(@RequestParam Map<String,Object> param,HttpSession session){
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		param.put("proposerUser", proposerUser);//打假申请人
		param.put("proposerUserId", proposerUserId);//打假申请人Id
		param.put("proposerOrgCode", sessionOrgCodeKey);//打假申请人组织编号
		ResultValue access = crmService.access("house/commonSearchService.insertFake", param);
		return access.getData();
	}
	/**
	 * 房源归属open
	 */
	@RequestMapping(value = "openHousingOwnership")
	public String openHousingOwnership(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		ResultValue access = crmService.access("house/commonSearchService.queryHouseOwnerInfo", param);
		model.addAttribute("result",access.getJsonObject());
		model.addAttribute("transType",param.get("transType").toString());
		return "houseCommon/openHouse_OwnerShip";
	}
	/**
	 * 房源归属Open-open
	 */
	@RequestMapping(value = "editOwner")
	public String editOwner(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		model.addAttribute("dutyAreaList", oaService.getDaQuOrgList());
		return "houseCommon/openHouse_OpenOwnerShip";
	}
	/**
	 * 房源归属open-Button
	 */
	@ResponseBody
	@RequestMapping(value = "editOwnerButton")
	public String editOwnerButton(ModelMap model, @RequestParam Map<String, Object> param,HttpSession session) throws IOException {
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		param.put("operator", proposerUser);//操作员
		param.put("operatorId", proposerUserId);//操作员Id
		param.put("operatorCode", sessionOrgCodeKey);//操作员code
		ResultValue result = crmService.access("house/commonSearchService.updateOwner", param);
		return result.getData();
	}
	/**
	 * 房产证录入页面
	 */
	@RequestMapping(value = "openPropertyCertificate")
	public String openPropertyCertificate(ModelMap model, @RequestParam Map<String, Object> param) throws IOException {
		ResultValue result = crmService.access("house/commonSearchService.queryHouseDeed", param);
		model.put("houseDeedInfo", result.getJsonObject());
		return "houseCommon/openHouseDeed";
	}

	/**
	 * 添加房产证
	 */
	@ResponseBody
	@RequestMapping(value = "insertHouseDeed")
	public String addHouseDeed(@RequestParam Map<String,Object> param,HttpSession session) {
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		String sessionQuKey = session.getAttribute(AihomeConst.SESSION_QU_KEY).toString();
		String sessionZuKey = session.getAttribute(AihomeConst.SESSION_ZU_KEY).toString();
		param.put("operateUser", proposerUser);//操作员
		param.put("operateUserId", proposerUserId);//操作员Id
		param.put("operateOrg", sessionZuKey);//操作员组名
		param.put("operateOrgCode", sessionOrgCodeKey);//操作员组织结构编号
		param.put("operateZone", sessionQuKey);//操作员所属区
		ResultValue access = crmService.access("house/commonSearchService.insertHouseDeed", param);
		return access.getData();
	}

	/**
	 * 撤销房产证
	 */
	@ResponseBody
	@RequestMapping(value = "deleteHouseDeed")
	public String deleteHouseDeed(@RequestParam Map<String,Object> param,HttpSession session) {
		ResultValue access = crmService.access("house/commonSearchService.deleteHouseDeed", param);
		return access.getData();
	}
}
