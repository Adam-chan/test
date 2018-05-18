package com.golden.crm.web.controller.houseManage.keys;

import java.util.HashMap;
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

@Controller
@RequestMapping(value = "keysManage")
public class KeysManageController {
	@Resource(name = "oaService")
	private OAService oaService;
	
	@Resource(name="crmService")
	private IServiceStore crmService;
	
	/**
	 * 钥匙管理列表
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap model) {
		model.addAttribute("quOrgList", oaService.getQuOrgList());
		return "keysManage/keyManage_index";
	}
	/**
	 * 钥匙确认页面
	 */
	@RequestMapping(value = "keyConfirmPage")
	public String keyConfirmPage(ModelMap model,HttpServletRequest request,HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyId", request.getParameter("keyId"));
		map.put("keyCode", request.getParameter("keyCode"));
		map.put("houseCode", request.getParameter("houseCode"));
		map.put("colelectZone", request.getParameter("colelectZone"));
		map.put("colelectOrg", request.getParameter("colelectOrg"));
		map.put("colelectUser", request.getParameter("colelectUser"));
		map.put("createTime", request.getParameter("createTime"));
		map.put("depositStoreId", request.getParameter("depositStoreId"));
		map.put("user", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		model.addAttribute("confirmObj", map);
		return "keysManage/key_confirm";
	}
	
	/**
	 * 钥匙确认
	 */
	@ResponseBody
	@RequestMapping(value = "keyConfrim")
	public String keyConfrim(@RequestParam Map<String, Object> param) {
		ResultValue result = crmService.access("key/manageKey.keyConfirm",param);
		return result.getData();
	}
	
	/**
	 * 钥匙借出页面
	 */
	@RequestMapping(value = "keyLendPage")
	public String keyLendPage(ModelMap model,HttpSession session,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString());
		map.put("keyId", request.getParameter("keyId"));
		model.addAttribute("lendObj", map);
		return "keysManage/key_lend";
	}
	
	/**
	 * 钥匙借出
	 */
	@ResponseBody
	@RequestMapping(value = "keyLend")
	public String keyLend(@RequestParam Map<String, Object> param) {
		ResultValue result = crmService.access("key/manageKey.lendKey",param);
		return result.getData();
	}
	
	/**
	 * 钥匙归还页面
	 */
	@RequestMapping(value = "keyReturnPage")
	public String keyReturnPage(ModelMap model,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("borrowUser", request.getParameter("borrowUser"));
		map.put("borrowUserContact", request.getParameter("borrowUserContact"));
		map.put("borrowTime", request.getParameter("borrowTime"));
		map.put("operateUser", request.getParameter("operateUser"));
		map.put("broBackTime", request.getParameter("broBackTime"));
		map.put("keyId", request.getParameter("keyId"));
		model.addAttribute("returnObj", map);
		return "keysManage/key_return";
	}
	
	/**
	 * 钥匙归还
	 */
	@ResponseBody
	@RequestMapping(value = "keyReturn")
	public String keyReturn(@RequestParam Map<String, Object> param) {
		ResultValue result = crmService.access("key/manageKey.returnKey",param);
		return result.getData();
	}
	
	/**
	 * 钥匙退还页面
	 */
	@RequestMapping(value = "keyBackPage")
	public String keyBackPage() {
		return "keysManage/key_back";
	}
	
	/**
	 * 钥匙退还
	 */
	@ResponseBody
	@RequestMapping(value = "keyBack")
	public String keyBack(@RequestParam Map<String, Object> param) {
		ResultValue result = crmService.access("key/manageKey.backKey",param);
		return result.getData();
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
	 * 模糊匹配实体店
	 */
	@ResponseBody
	@RequestMapping(value = "getStoreList")
	public String getStoreList(@RequestParam Map<String, Object> param) {
		return oaService.getStoreList(param.get("matchStr").toString());
	}
	
	/**
	 * 初始化钥匙管理列表
	 */
	@ResponseBody
	@RequestMapping(value = "keyListInit")
	public String keyListInit(@RequestParam Map<String, Object> param) {
		ResultValue result = crmService.access("key/manageKey.getManageKeyJQPage",param);
		return result.getData();
	}

}
