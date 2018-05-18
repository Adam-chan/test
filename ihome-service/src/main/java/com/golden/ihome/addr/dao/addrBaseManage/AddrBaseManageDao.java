package com.golden.ihome.addr.dao.addrBaseManage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.AddressBaseManageModel;
import com.golden.ihome.addr.model.TemporaryAddrBaseModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * 地址库管理 
 */
@Repository(value="addrBaseManageDao")
public class AddrBaseManageDao extends IBaseDao{
	/**
	 * 标准地址库分页列表
	 * 分页查询
	 * 参数：map {currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<AddressBaseManageModel> getStandAddrManagePage(Map<String,Object> param){
		return this.excutor.queryListPage("addressBaseManage.getAddrBaseManagePage", param);
	}
	/**
	 * 楼盘分组Id-List
	 */
	public List<AddressBaseManageModel> getAddrGroupIdList(Map<String,Object> param){
		return this.excutor.queryForList("addressBaseManage.getAddrGroupIdList", param);
	}
	/**
	 * 楼栋Id-List
	 */
	public List<AddressBaseManageModel> getAddrBudldingIdList(Map<String,Object> param){
		return this.excutor.queryForList("addressBaseManage.getAddrBudldingIdList", param);
	}
	/**
	 * 临时地址库分页列表
	 * 分页查询
	 * 参数：map {currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<TemporaryAddrBaseModel> getTemAddrBasePage(Map<String,Object> param){
		return this.excutor.queryListPage("addressBaseManage.getTemAddrBasePage", param);
	}
	
	/**
	 * 模糊匹配道路 楼盘 楼盘分组 
	 * @param 
	 * @return List<AddressBaseManageModel>
	 */
	public List<AddressBaseManageModel> getAddrKeyWordMatch(Map<String, Object> map){
		return this.excutor.queryForList("addressBaseManage.getAddrkeyWordByMatch", map);
	}
	/**
	 * 房间的启用和禁用
	 */
	public Integer updateHouseStatus(Map<String, Object> map){
		return this.excutor.update("addressBaseManage.updateHouseStatus", map);
	}
	/**
	 * 模糊匹配临时地址 
	 * @param 
	 * @return List<TemporaryAddrBaseModel>
	 */
	public List<TemporaryAddrBaseModel> getTemAddrkeyWordByMatch(Map<String, Object> map){
		return this.excutor.queryForList("addressBaseManage.getTemAddrkeyWordByMatch", map);
	}
	/**
	 * 临时地址库审核 修改临时地址为地址库地址
	 * @param params   checkTime 审核时间  checkMan 审核人
	 * 		  temAddrBaseId 临时地址库ID   bizType 业务类型 1买卖 2租赁	
	 * 	      houseInfoId  houseInfo表ID  refuseReson 拒绝审核原因  houseAddr  地址库地址		  
	 * @return
	 */
	public Integer updateHouseAddr(Map<String, Object> map) {
		return this.excutor.update("addressBaseManage.updateHouseAddr", map);
	}
}
