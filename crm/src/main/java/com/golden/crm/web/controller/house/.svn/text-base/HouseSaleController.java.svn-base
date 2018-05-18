package com.golden.crm.web.controller.house;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author shanying 类名称：买卖房源Controller 类描述：买卖房源 时间：2016-11-11
 */
@Controller
@RequestMapping(value = "houseManage")
public class HouseSaleController {
	
	@Resource(name = "crmService")
	private IServiceStore crmService;

	@Resource(name = "oaService")
	private OAService oaService;
	/**
	 * 房源管理初始化页面sy
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "houseIndex")
	public String houseIndex(HttpServletRequest request){
		return "houseSale/house_main";
		
	}
	
	/**
	 * 模糊查询详细地址 sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAddrDetail")
	public String getAddrDetail(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("house/houseSaleService.getAddrDetail", map);
		return result.getData();
	}
	
	/**
	 * 模糊查询详细地址B(用于：房源-车位) sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAddrDetailB")
	public String getAddrDetailB(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("house/houseSaleService.getAddrDetailB", map);
		return result.getData();
	}
	/**
	 * 分页查询 房源列表 sy
	 * @param map 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseSaleListForPage")
	public String getHouseSaleListForPage(@RequestParam Map<String,Object> map,HttpSession session){
		ResultValue result = new ResultValue();
		map.put("currentPage", map.get("page").toString());
		map.put("rowCount", map.get("rows").toString());
		map.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));
		result = crmService.access("house/houseSaleService.getHouseSaleListForPage", map);
		return result.getData();
	}
	/**
	 * 买卖房源管理 列表页面 sy
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getSellHouseTable")
	public String getSellHouseTable(HttpServletRequest request,HttpSession session){
		ResultValue ba1List = crmService.access("house/houseSaleService.getBa1List", null);//大商圈
		ResultValue sysParamMap = crmService.access("sysParam/sysParamService",null);//房源系统参数
		request.setAttribute("ba1List", ba1List.getJsonArray());//大商圈
		request.setAttribute("sysParamMap", sysParamMap.getJsonObject());//房源系统参数 可配置
		request.setAttribute("quOrgList", oaService.getQuOrgList());//OA组织结构
		request.setAttribute("curUser", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));//当前登陆人id
		return "houseSale/house_sale_table";
	}
	/**
	 * 模糊搜索车位 sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCarPortByMatch")
	public String getCarPortByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("carPort/carPortService.getCarPortByMatch", map);
		return result.getData();
	}
	/**
	 * 判断车位是否关联房源 sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isContactHouseSale")
	public String isContactHouseSale(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseSaleService.isContactHouseSale", map);
		return result.getData();
	}
	/**
	 * 新增弹窗 sy
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getSellAddDialog")
	public String getLeaseAddDialog(HttpServletRequest request,@RequestParam Map<String,Object > map){
		String useType = map.get("useType").toString();
		ResultValue result = crmService.access("ownerSource/ownerSourceService.getParentSources", null);
		ResultValue sysParamMap = crmService.access("sysParam/sysParamService",null);//房源系统参数
		request.setAttribute("useType", useType);
		request.setAttribute("parentSourceList", result.getJsonArray());
		request.setAttribute("sysParamMap", sysParamMap.getJsonObject());
		//修改-显示数据
		if(map.containsKey("houseInfoId") && null!=map.get("houseInfoId") && !map.get("houseInfoId").equals("")){
			ResultValue houseSaleResult = crmService.access("house/houseSaleService.getHouseSaleById", map);
			request.setAttribute("houseSaleResult", houseSaleResult.getJsonObject());
		}
		return "houseSale/house_sale_form";
	}
	
	/**
	 * 新增买卖房源 sy
	 * @param map
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "insertHouseSale")
	public String insertHouseLease(@RequestParam Map<String,Object> map,HttpSession session){
		ResultValue result = new ResultValue();
		//组织结构-登记人 
		map.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));
		map.put("userName", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY));
		map.put("userOrgCode", "02.01.02.01.01.");//组编号
		map.put("userOrg", "东一区1组");//组
		map.put("userQu", "东一区");//区
		map.put("userQuCode", "02.01.02.01.");//区编码
		map.put("userDaQu", "东大区");//大区
		if(map.containsKey("houseInfoId") && null!=map.get("houseInfoId") && !map.get("houseInfoId").equals("")){
			result = crmService.access("house/houseSaleService.updateHouseSaleById", map);
		}else{
			result = crmService.access("house/houseSaleService.insertHouseSale", map);
		}
		return result.getData();
	}
	/**Sas
	 * 业主来源(子) sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSourcesByParentId")
	public String getSourcesByParentId(@RequestParam Map<String,Object> map){
		ResultValue result = crmService.access("ownerSource/ownerSourceService.getSourcesByParentId", map);
		return result.getData();
	}
	
	/**
	 * 根据大商圈查询小商圈 sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBa2List")
	public String getBa2List(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseSaleService.getBa2List", map);
		return result.getData();
	}
	/**
	 * 模糊搜索教育设施 sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getEdusByMatch")
	public String getEdusByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseSaleService.getEdusByMatch", map);
		return result.getData();
	}
	/**
	 * 根据楼盘id查询楼栋 dl
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBuildingsList")
	public String getBuildingsByPremisesId(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("carPort/carPortService.getBuildingsByPremisesId", map);
		return result.getData();
	}
	
	/**
	 * 校验房源是否已存在 sy
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isExistWithHouseSale")
	public String isExistWithHouseSale(@RequestParam Map<String, Object> map){
		ResultValue result = crmService.access("house/houseSaleService.isExistWithHouseSale", map);
		return result.getData();
	}
	
	/**
	 * 评论弹窗
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getSellCommentDialog")
	public String getSellCommentDialog(HttpServletRequest request,@RequestParam Map<String,Object > map){
		
		return "houseSale/house_sal_comment";
	}
	/**
	 * 发表评论
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveComment")
	public String saveComment(@RequestParam Map<String,Object> map, HttpSession session){
		map.put("userId", session.getAttribute(AihomeConst.SESSION_USER_ID_KEY));
		map.put("userName", session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY));
		ResultValue result = crmService.access("house/houseSaleService.saveComment", map);
		return result.getData();
	}
	
	/**
	 * 获取评论
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCommemnt")
	public String getCommemnt(@RequestParam Map<String,Object> map, HttpSession session){
		ResultValue result = crmService.access("house/houseSaleService.getCommemnt", map);
		return result.getData();
	}
	/**
	 * 买卖房源查看open页 查看详情
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "lookUpDetail")
	public String lookUpDetail(@RequestParam Map<String,Object> map,HttpServletRequest request, HttpSession session){
		String proposerUser = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		String proposerUserId = session.getAttribute(AihomeConst.SESSION_USER_ID_KEY).toString();
		String sessionOrgCodeKey = session.getAttribute(AihomeConst.SESSION_ORG_CODE_KEY).toString();
		map.put("userName", proposerUser);//打假申请人名字
		map.put("userId", proposerUserId);//打假申请人Id
		map.put("userOgrCode", sessionOrgCodeKey);//打假申请人组织结构代码
		ResultValue result = crmService.access("house/houseSaleService.getDetail", map);
		request.setAttribute("houseSaleInfo", result.getJsonObject().get("houseSaledetail"));
		if(result.getJsonObject().get("collectResult") == null) {
			request.setAttribute("collectDisplay", "true");
		} else {
			request.setAttribute("collectDisplay", "false");//收藏数据
			request.setAttribute("collectId", result.getJsonObject().get("collectResult"));
		}
		if(result.getJsonObject().get("querySpaceSee") != null) {
			request.setAttribute("spaceSeeDisplay", "false");//空看
		}
		if(result.getJsonObject().get("queryReceiveKey") != null) {
			request.setAttribute("keyId", result.getJsonObject().get("queryReceiveKey"));//钥匙数量
		}
		request.setAttribute("carPort", result.getJsonObject().get("carPortList"));//车位
		request.setAttribute("linkManList", result.getJsonObject().get("linkManList"));//联系人
		request.setAttribute("eduList", result.getJsonObject().get("eduListByMatch"));//教育设施
		request.setAttribute("busStationList", result.getJsonObject().get("busStationList"));//公交线路
		request.setAttribute("subwayStationList",  result.getJsonObject().get("subwayStationList"));//地铁线路
		request.setAttribute("num", map.get("num").toString());//1住宅 2 商铺 3写字楼 4车库
		request.setAttribute("type", map.get("type").toString());//1买卖 2租赁
		return "houseSale/house_detail";
	}
}
