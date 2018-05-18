package com.golden.ihome.addr.dao.basearea;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BaseAreaModel;
import com.golden.ihome.addr.model.CommunityModel;
import com.golden.ihome.addr.model.SubdistrictModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * 省市级联 
 */
@Repository(value="baseAreaDao")
public class BaseAreaDao extends IBaseDao{
	/**
	 * 查询省市区
	 * 分页查询
	 * 参数：map {areaLeve：查询的等级,pid:所属父ID,currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<BaseAreaModel> getAreaListPage(Map<String,Object> param){
		return this.excutor.queryListPage("baseArea.getAreaPage", param);
	}
	/**
	 * 查询社区
	 * 分页查询
	 * 参数：map {areaLeve：查询的等级,pid:所属父ID,currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<CommunityModel> getCommunityPage(Map<String,Object> param){
		return this.excutor.queryListPage("baseArea.getCommunityPage", param);
	}
	/**
	 * 省市级联，非分页
	 * 参数：map {areaLeve：查询的等级,pid:所属父ID}
	 */
	public List<BaseAreaModel> getAreaList(Map<String,Object> param){
		return this.excutor.queryForList("baseArea.getAreaList", param);
	}
	/**
	 * 修改区 
	 */
	public Integer updateArea(Map<String,Object> param){
		return this.excutor.update("baseArea.updateArea", param);
	}
	
	/**
	 * 修改社区 
	 */
	public Integer updateCommunity(Map<String,Object> param){
		return this.excutor.update("baseArea.updateCommunity", param);
	}
	
	/**
	 * 根据ID查询BaseArea信息
	 * 参数：map {baseAreaId：表的主ID,pid:所属父ID}
	 */
	public BaseAreaModel getAreaInfo(Map<String,Object> param){
		return this.excutor.queryForObject("baseArea.getAreaInfo", param);
	}
	/**
	 * 根据ID查询getAreaCodeInfo信息
	 * 参数：map {baseAreaId：表的主ID,pid:所属父ID}
	 */
	public BaseAreaModel getAreaCodeInfo(Map<String,Object> param){
		return this.excutor.queryForObject("baseArea.getAreaCodeInfo", param);
	}
	
	
	/**
	 * 根据名字和PID查询社区表信息
	 * 参数：map {subdistrictId：街道ID,areaName:社区名称}
	 */
	public CommunityModel getCommunityName(Map<String,Object> param){
		return this.excutor.queryForObject("baseArea.getCommunityName", param);
	}
	
	/**
	 * 增加区
	 */
	public Integer insertAreaBorough(Map<String,Object> param){
		return this.excutor.insert("baseArea.insertAreaBorough", param);
	}
	/**
	 * 批量删除区信息
	 * 参数：map {所属ID}
	 */
	public Integer deleteArea(Map<String, Object> map) {
		return this.excutor.update("baseArea.updateArea", map);
	}
	/**
	 * 批量删除街道信息
	 * 参数：map {所属ID}
	 */
	public Integer deleteAreaSubdistrict(Map<String, Object> map) {
		return this.excutor.update("baseArea.updateSubdistrict", map);
	}
	/**
	 * 批量删除社区信息
	 * 参数：map {所属ID}
	 */
	public Integer deleteAreaCommunity(Map<String, Object> map) {
		return this.excutor.update("baseArea.updateCommunity", map);
	}

	/**
	 * 街道分页列表
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<SubdistrictModel> getSubdistrictPage(Map<String, Object> map){
		return this.excutor.queryListPage("baseArea.getSubdistrictPage", map);
	}
	
	/**
	 * 根据ID查询街道表数据
	 * @param String 街道表ID
	 * @return SubdistrictModel
	 */
	public SubdistrictModel getSubdistrict(Map<String, Object> map){
		return this.excutor.queryForObject("baseArea.getSubdistrict", map);
	}
	
	/**
	 * 根据区ID查询街道列表数据
	 * @param String subdistrictId 是区ID
	 * @return List<SubdistrictModel>
	 */
	public List<SubdistrictModel> getSubdistrictList(String subdistrictId){
		return this.excutor.queryForList("baseArea.getSubdistrictList", subdistrictId);
	}
	
	/**
	 * 验证街道名是否存在
	 * @param String map
	 * @return SubdistrictModel
	 */
	public SubdistrictModel getSubdistrictName(Map<String, Object> map){
		return this.excutor.queryForObject("baseArea.getSubdistrictName", map);
	}
	
	/**
	 * 查询街数量
	 * @param String map
	 * @return SubdistrictModel
	 */
	public SubdistrictModel getSubdistrictCount(Map<String, Object> map){
		return this.excutor.queryForObject("baseArea.getSubdistrictCount", map);
	}
	/**
	 * 查社区数量
	 * @param String map
	 * @return SubdistrictModel
	 */
	public CommunityModel getCommunityCount(Map<String, Object> map){
		return this.excutor.queryForObject("baseArea.getCommunityCount", map);
	}
	/**
	 *批量添加添加街道 
	 * @param map
	 * @return Integer
	 */
	public Integer addSubdistrict(Map<String, Object> map) {
		return this.excutor.insert("baseArea.insertSubdistrict", map);
	}
	
	/**
	 *批量添加添加社区 
	 * @param map
	 * @return Integer
	 */
	public Integer addCommunity(Map<String, Object> map) {
		return this.excutor.insert("baseArea.insertCommunity", map);
	}
	/**
	 * 修改街道
	 * @param map
	 * @return Integer
	 */
	public Integer updateSubdistrict(Map<String, Object> map) {
		return this.excutor.update("baseArea.updateSubdistrict", map);
	}

	/**
	 * 模糊匹配 区
	 * @param String subdistrictId 是区ID
	 * @return List<SubdistrictModel>
	 */
	public List<BaseAreaModel> getAreaByMatch(Map<String, Object> map){
		return this.excutor.queryForList("baseArea.getAreaByMatch", map);
	}
	
	/**
	 * 模糊匹配 街道
	 * @param String subdistrictId 是区ID
	 * @return List<SubdistrictModel>
	 */
	public List<SubdistrictModel> getSubdistrictByMatch(Map<String, Object> map){
		return this.excutor.queryForList("baseArea.getSubdistrictByMatch", map);
	}
	
	/**
	 * 模糊匹配 社区
	 * @param String subdistrictId 是区ID
	 * @return List<SubdistrictModel>
	 */
	public List<CommunityModel> getCommunityByMatch(Map<String, Object> map){
		return this.excutor.queryForList("baseArea.getCommunityByMatch", map);
	}

	/**
	 * 模糊匹配
	 * @param String matchStr 匹配字段
	 * @return List<SubdistrictModel>
	 */
	public List<BaseAreaModel> getAreaByMatchOfLevel3(Map<String, Object> map){
		return this.excutor.queryForList("baseArea.getAreaByMatchOfLevel3", map);
	}

	/**
	 * 获取社区列表
	 * @param String subdistrictId 街道ID
	 * @return List<CommunityModel>
	 */
	public List<CommunityModel> getCommunityList(Map<String, Object> map){
		return this.excutor.queryForList("baseArea.getCommunityList", map);
	}
	
	/**
	 * 根据区ID查询多有街道ID
	 *  区ID
	 */
	public List<SubdistrictModel> getSubdistrictIdByAreaId(Map<String,Object> param){
		return this.excutor.queryForList("baseArea.getSubdistrictIdByAreaId", param);
	}
}
