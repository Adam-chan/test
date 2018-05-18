package com.golden.ihome.addr.dao.dist;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.DistModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="addrDistDao")
public class AddrDistDao extends IBaseDao{

	/**
	 * 道路
	 */
	public List<Map<String, Object>> getRoadList(Map<String, Object> map) {
		return this.excutor.queryForList("addrDist.getRoadList", map);
	}

	/**
	 * 楼盘
	 */
	public List<Map<String, Object>> getPremisesListByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("addrDist.getPremisesListByMatch", map);
	}

	/**
	 * 楼栋分组
	 */
	public List<Map<String, Object>> getGroup(Map<String, Object> map) {
		return this.excutor.queryForList("addrDist.getGroup", map);
	}

	/**
	 * 楼栋
	 */
	public List<Map<String, Object>> getBuilding(Map<String, Object> map) {
		return this.excutor.queryForList("addrDist.getBuilding", map);
	}

	/**
	 * 单元/商铺
	 */
	public List<Map<String, Object>> getUnit(Map<String, Object> map) {
		return this.excutor.queryForList("addrDist.getUnit", map);
	}

	/**
	 * 地址库列表分页
	 */
	public PagerResult<DistModel> getSaleAddrDistList(Map<String, Object> map) {
		return this.excutor.queryListPage("addrDist.getSaleAddrDistListPage", map);
	}

	/**
	 * 原分配人
	 */
	public Map<String, Object> oldSaleAssignment(Map<String, Object> map) {
		return this.excutor.queryForObject("addrDist.oldSaleAssignment", map);
	}

	/**
	 * 上一级组织结构
	 */
	public String lastSaleOrg(Map<String, Object> map) {
		return this.excutor.queryForObject("addrDist.lastSaleOrg", map);
	}

	/**
	 * 下属层级是否被分配
	 */
	public String nextSaleAssignment(Map<String, Object> map) {
		return this.excutor.queryForObject("addrDist.nextSaleAssignment", map);
	}

	/**
	 * 添加分配
	 */
	public Integer addSaleAssignment(Map<String, Object> map) {
		return this.excutor.insert("addrDist.addSaleAssignment", map);
	}

	/**
	 * 修改分配
	 */
	public Integer updateSaleAssignment(Map<String, Object> map) {
		return this.excutor.update("addrDist.updateSaleAssignment", map);
	}

	/**
	 * 删除分配
	 */
	public Integer deleteSaleAssignment(Map<String, Object> map) {
		return this.excutor.delete("addrDist.deleteSaleAssignment", map);
	}

	/**
	 * 添加分配并更新房源所属人
	 */
	public Integer addAndUpdateSaleAssignment(Map<String, Object> map) {
//		return this.excutor.update("addrDist.addAndUpdateSaleAssignment", map);
		return 1;
	}

	/**
	 * 地址库列表分页
	 */
	public PagerResult<DistModel> getLeaseAddrDistList(Map<String, Object> map) {
		return this.excutor.queryListPage("addrDist.getLeaseAddrDistListPage", map);
	}

	/**
	 * 原分配人
	 */
	public Map<String, Object> oldLeaseAssignment(Map<String, Object> map) {
		return this.excutor.queryForObject("addrDist.oldLeaseAssignment", map);
	}

	/**
	 * 上一级组织结构
	 */
	public String lastLeaseOrg(Map<String, Object> map) {
		return this.excutor.queryForObject("addrDist.lastLeaseOrg", map);
	}

	/**
	 * 下属层级是否被分配
	 */
	public String nextLeaseAssignment(Map<String, Object> map) {
		return this.excutor.queryForObject("addrDist.nextLeaseAssignment", map);
	}

	/**
	 * 添加分配
	 */
	public Integer addLeaseAssignment(Map<String, Object> map) {
		return this.excutor.insert("addrDist.addLeaseAssignment", map);
	}

	/**
	 * 修改分配
	 */
	public Integer updateLeaseAssignment(Map<String, Object> map) {
		return this.excutor.update("addrDist.updateLeaseAssignment", map);
	}

	/**
	 * 删除分配
	 */
	public Integer deleteLeaseAssignment(Map<String, Object> map) {
		return this.excutor.delete("addrDist.deleteLeaseAssignment", map);
	}

	/**
	 * 添加分配并更新房源所属人
	 */
	public Integer addAndUpdateLeaseAssignment(Map<String, Object> map) {
//		return this.excutor.update("addrDist.addAndUpdateLeaseAssignment", map);
		return 1;
	}
}
 