package com.golden.addr.web.controller.addrBaseManage;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * @author lb
 * 类名称：地址库管理Controller
 * 类描述：地址库的分配、审核、查询等
 * 时间：2016-10-31
 */
@Controller
@RequestMapping(value="addrBaseManage")
public class AddrBaseManageController {

	@Resource(name="addrService")
	private IServiceStore addrService;
	
	@RequestMapping(value = "index")
	public String index(){
		return "addrBaseManage/addressbaseManage_main";
	}
	/**
	 * 标准地址库 table 初始化
	 */
	@RequestMapping(value = "standardAddrBaseTable")
	public String standardAddrBaseTable(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("eareId",934);
		ResultValue result = addrService.access("area/areaService.getAreaList",map);
		request.setAttribute("provinceList", result.getJsonArray());
		request.setAttribute("type", 1);
		return "addrBaseManage/standard_addrBase_table";
	}
	/**
	 * 临时地址库 table 初始化
	 */
	@RequestMapping(value = "temporaryAddrBaseTable")
	public String temporaryAddrBaseTable(HttpServletRequest request){
		request.setAttribute("type", 2);
		return "addrBaseManage/temporary_addrBase_table";
	}
	/**
	 * 标准地址库-修改open页
	 * @param map 需要传楼盘ID   根据楼盘ID 查出区 街道 社区 道路 楼盘名 带回页面
	 * @return
	 */
	@RequestMapping(value = "updataStandardAddrBase")
	public String updataStandardAddrBase(@RequestParam Map<String,Object> params , HttpServletRequest request)throws IOException {
		String areaName = request.getParameter("areaName");
		areaName = URLDecoder.decode(areaName, "UTF-8");
		String aasName = request.getParameter("aasName");
		aasName = URLDecoder.decode(aasName, "UTF-8");
		String acName = request.getParameter("acName");
		acName = URLDecoder.decode(acName, "UTF-8");
		String roadName = request.getParameter("roadName");
		roadName = URLDecoder.decode(roadName, "UTF-8");
		String bpName = request.getParameter("bpName");
		bpName = URLDecoder.decode(bpName, "UTF-8");
		request.setAttribute("areaName",areaName);
		request.setAttribute("aasName",aasName);
		request.setAttribute("acName",acName);
		request.setAttribute("roadName",roadName);
		request.setAttribute("bpName",bpName);
		params.put("eareId",934);
		ResultValue result = addrService.access("area/areaService.getAreaList",params);
		request.setAttribute("provinceList", result.getJsonArray());
		return "addrBaseManage/standard_addrBase_open";
	}
	/**
	 * 临时地址库-审核open页
	 * @param map 需要当前行ID  审核表ID  根据ID 查业务类型 具体地址 带回页面
	 * @return
	 */
	@RequestMapping(value = "temporaryAddrBaseAudits")
	public String temporaryAddrBaseAudits(@RequestParam Map<String,Object > map,HttpServletRequest request)throws IOException {
		String temAddrName = request.getParameter("temAddrName");
		temAddrName = URLDecoder.decode(temAddrName, "UTF-8");
		request.setAttribute("temAddrName",temAddrName);
		return "addrBaseManage/temporary_addrBase_open";
	}
	/**
	 * 模糊查询房间详细地址
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRoomAddrDetail")
	public String getRoomAddrDetail(@RequestParam Map<String,Object> map){
		ResultValue result = addrService.access("house/houseLeaseService.getAddrDetail", map);
		return result.getData();
	}
	/**
	 *  模糊匹配临时地址 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTemAddrkeyWordByMatch")
	public String getTemAddrkeyWordByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("addrBaseManage/AddrBaseManageService.getTemAddrkeyWordByMatch", map);
		return result.getData();						
	}
	/**
	 *  模糊匹配道路 楼盘 楼盘分组
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAddrKeyWordMatch")
	public String getAordListByMatch(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("addrBaseManage/AddrBaseManageService.getAddrKeyWordMatch", map);
		return result.getData();						
	}
	/**
	 * 分页查询-标准地址库-列表
	 * @param map 有条件查询  道路名或楼盘名   区 街道 社区 分配状态 6个条件  
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getStandardAddrBasePage")
	public String getStandardAddrBasePage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = addrService.access("addrBaseManage/AddrBaseManageService", map);
		return result.getData();
	}
	/**
	 * 分页查询-临时地址库-列表   条件 审核状态
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTemporaryAddrBasePage")
	public String getTemporaryAddrBasePage(@RequestParam Map<String,Object> map){
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = addrService.access("addrBaseManage/AddrBaseManageService.getTemAddrBasePage", map);
		return result.getData();
	}
	
	/**
	 * 临时地址库审核 修改临时地址为地址库地址
	 * @param params   checkTime 审核时间  checkMan 审核人
	 * 		  temAddrBaseId 临时地址库ID   bizType 业务类型 1买卖 2租赁	
	 * 	      houseInfoId  houseInfo表ID  refuseReson 拒绝审核原因  houseAddr  地址库地址		  
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateHouseAddr")
	public String updateHouseAddr(@RequestParam Map<String, Object> map,HttpSession session ){
		String userName = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		map.put("checkMan", userName);
		ResultValue result = addrService.access("addrBaseManage/AddrBaseManageService.updateHouseAddr", map);
		return result.getData();
	}
	
	/**
	 * 标准地址库更改状态 1：启用 2：禁用 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateAddrUseStatus")
	public String updateAddrUseStatus(@RequestParam Map<String, Object> map){
		ResultValue result = addrService.access("addrBaseManage/AddrBaseManageService.updateHouseStatus", map);
		return result.getData();
	}


}
