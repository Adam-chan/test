package com.golden.ihome.addr.dao.ctxdll;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.port.framework.mybatis.IBaseDao;

@Repository(value = "roomAddrDao")
public class RoomAddrDao extends IBaseDao{
	/**
	 * 同步索引 
	 */
	public void syncIndex(){
		this.excutor.queryForObject("sync.houseSyncIndex",null);
	}
	/**
	 * 优化房间索引碎片
	 */
	public void houseOptimizeIndex(){
		this.excutor.queryForObject("sync.houseOptimizeIndex",null);
	}
	/**
	 * 优化道路索引碎片
	 */
	public void roadOptimizeIndex(){
		this.excutor.queryForObject("sync.roadOptimizeIndex",null);
	}
	/**
	 * 更新道路状态。道路名称,省，市，区 
	 */
	public Integer updateRoadAddr(Map<String,Object> param){
		return this.excutor.update("sync.updateRoadAddr", param);
	}
	/**
	 * 更新房间。道路名称,省，市，区 ，楼盘，分组，楼栋，房间
	 */
	public Integer updateHouseAddr(Map<String,Object> param){
		return this.excutor.update("sync.updateHouseAddr", param);
	}
	/**
	 * 批量添加房间全地址。道路名称,省，市，区 
	 */
	public Integer insertBatchHouseAddr(Map<String,Object> param){
		return this.excutor.update("sync.insertBatchHouse", param);
	}
	/**
	 *填加房间全地址。道路名称,省，市，区 (一条数据)
	 */
	public Integer insertHouseAddr(Map<String,Object> param){
		return this.excutor.update("sync.insertHouseAddr", param);
	}
	/**
	 *填加房间全地址。道路名称,省，市，区 (一条数据)
	 */
	public Map<String,Object> getRoadNumDetail(Map<String,Object> param){
		return this.excutor.queryForObject("sync.getRoadNumDetail", param);
	}
	
	public Integer updatePeremisesRoadNum(Map<String,Object> param){
		return this.excutor.update("sync.updatePeremisesRoadNum", param);
	}
	/**
	 * 根据单元删除房间全地址
	 */
	public Integer deleteHouseAddr(Map<String,Object> param){
		return this.excutor.update("sync.deleteHouseAddr", param);
	}
	
}
