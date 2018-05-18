package com.golden.ihome.addr.dao.road;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BaseAreaModel;
import com.golden.ihome.addr.model.RoadLogModel;
import com.golden.ihome.addr.model.RoadModel;
import com.golden.ihome.addr.model.RoadNumModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="roadDao")
public class RoadDao extends IBaseDao{
	/**
	 * 查询道路信息 dl
	 * 分页查询 
	 * 参数：map {currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<RoadModel> getRoadListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("road.queryRoadListPage", map);
	}
	/**
	 * 根据道路id查询道路信息 dl
	 * @param map
	 * @return
	 */
	public RoadModel getRoadById(Map<String, Object> map) {
		return this.excutor.queryForObject("road.getRoadById", map);
	}
	/**
	 * 新增道路信息 dl
	 * @param map
	 * @return
	 */
	public Integer insertRoad(Map<String, Object> map) {
		return this.excutor.insert("road.insertRoad", map);
	}
	/**
	 * 修改道路信息 dl
	 * @param map
	 * @return
	 */
	public Integer updateRoad(Map<String, Object> map) {
		return this.excutor.update("road.updateRoad", map);
	}
	/**
	 * 查询所有道路信息 dl
	 * @return
	 */
	public List<RoadModel> getRoadList() {
		return this.excutor.queryForList("road.getRoadList");
	}
	/**
	 * 批量删除道路信息 dl
	 * @param map
	 * @return
	 */
	public Integer deleteRoads(Map<String, Object> map) {
		return this.excutor.delete("road.deleteRoads", map);
	}
	/**
	 * 根据道路名模糊匹配 dl
	 * @param map
	 * @return
	 */
	public List<RoadModel> getRoadListByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("road.getRoadListByMatch", map);
	}
	public Integer insertRoadAreaContact(Map<String, Object> map) {
		return this.excutor.insert("road.insertRoadAreaContact", map);
	}

	public List<BaseAreaModel> getAreasList() {
		return this.excutor.queryForList("road.getAreasList");
	}
	/**
	 * 查询道路号信息--LB
	 * 分页查询
	 * 参数：map {currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<RoadNumModel> queryRoadNumListPage(Map<String, Object> map) {
		return this.excutor.queryListPage("road.queryRoadNumListPage", map);
	}
	/**
	 * 查询日志信息--LB
	 * 分页查询
	 * 参数：map {currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<RoadLogModel> queryRoadLogListPage(Map<String, Object> map) {
		return this.excutor.queryListPage("road.queryRoadLogListPage", map);
	}
	/**
	 * 模糊匹配 道路
	 * @param String roadId 道路ID   matchStr 模糊道路名字
	 * @return List<RoadModel>
	 */
	public List<RoadModel> getRoadNumByMatch(Map<String, Object> map){
		return this.excutor.queryForList("road.getRoadNumByMatch", map);
	}
	/**
	 * 更改道路号使用状态 道路号段
	 * @param String Id 道路号ID   roadNumStatus 使用状态 1：使用中 2：未使用
	 * @return Integer
	 */
	public Integer updateRoadNum(Map<String, Object> map) {
		return this.excutor.update("road.updateRoadNum", map);
	}
	/**
	 * 更改道路日志使用状态 
	 * @param String Id 日志ID   roadLogStatus 使用状态 1：使用中 2：未使用
	 * @return Integer
	 */
	public Integer updateRoadLog(Map<String, Object> map) {
		return this.excutor.update("road.updateRoadLog", map);
	}
	/**
	 * 获得道路号数量 道路撒号验证 第一次
	 * @param String creatType 生成号段的规则  1：单号撒号   2：双号撒号   3：连续撒号   startNum 起始号
	 * @return RoadLogModel
	 */
	public RoadLogModel getRoadNumCount(Map<String, Object> map){
		return this.excutor.queryForObject("road.getRoadNumCount", map);
	}
	
	/**
	 * 根据道路ID 获取所有起始号 和终止号 道路撒号验证  第二次
	 * @param String    startNum 起始号
	 * @return List<RoadLogModel>
	 */
	public List<RoadLogModel> getRoadNumInclude(Map<String, Object> map){
		return this.excutor.queryForList("road.getRoadNumInclude", map);
	}
	/**
	 * 批量插入道路号 撒号
	 * @param 
	 * @return Integer
	 */
	public Integer insertRoadNum(Map<String, Object> map) {
		return this.excutor.insert("road.insertRoadNum", map);
	}
	/**
	 * 批量插入 sync  
	 * @param 
	 * @return Integer
	 */
	public Integer insertRoadAddr(Map<String, Object> map) {
		return this.excutor.insert("sync.insertRoadAddr", map);
	}
	/**
	 * 插入道路日志记录
	 * @param 
	 * @return Integer
	 */
	public Integer insertRoadLog(Map<String, Object> map) {
		return this.excutor.insert("road.insertRoadLog", map);
	}
	/**
	 * 删除道路号 重新撒号
	 * @param 
	 * @return Integer
	 */
	public Integer deleteRoadNum(Map<String, Object> map) {
		return this.excutor.delete("road.deleteRoadNum", map);
	}
	/**
	 * 查询道路名称是否存在 dl
	 * @param map
	 * @return
	 */
	public Integer getRoadByNameIs(Map<String, Object> map) {
		return this.excutor.queryForObject("getRoadByNameIs", map);
	}
	/**
	 * 道路日志使用条数
	 */
	public RoadLogModel getRoadLogCount(Map<String, Object> map){
		return this.excutor.queryForObject("road.getRoadLogCount", map);
	}
	/**
	 * 同步索引 
	 */
	public void syncIndex(){
		this.excutor.queryForObject("sync.roadSyncIndex",null);
		this.excutor.queryForObject("sync.houseSyncIndex",null);
	}
	/**
	 * 删除sync道路数据
	 * @param 
	 * @return Integer
	 */
	public Integer deleteRoadAddr(Map<String, Object> map) {
		return this.excutor.delete("sync.deleteRoadAddr", map);
	}
	/**
	 * 更新Road--sync数据
	 * @param 
	 * @return Integer
	 */
	public Integer updateRoadAddr(Map<String, Object> map) {
		return this.excutor.update("sync.updateRoadAddr", map);
	}
	/**
	 * 更新House--sync数据
	 * @param 
	 * @return Integer
	 */
	public Integer updateHouseAddr(Map<String, Object> map) {
		return this.excutor.update("sync.updateHouseAddr", map);
	}
	/**
	 * 查询忽略道路号
	 * @param map
	 * @return
	 */
	public RoadLogModel getRoadLogInfo(Map<String, Object> map) {
		return this.excutor.queryForObject("road.getRoadLogInfo", map);
	}
	/**
	 * 更改道路日志忽略号 
	 * @param String Id 日志ID  
	 * @return Integer
	 */
	public Integer updateRoadLogNew(Map<String, Object> map) {
		return this.excutor.update("road.updateRoadLogNew", map);
	}
}
