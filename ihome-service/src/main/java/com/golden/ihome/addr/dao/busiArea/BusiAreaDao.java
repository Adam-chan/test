package com.golden.ihome.addr.dao.busiArea;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author lza
 * 类名称：商圈管理dao
 * 类描述：商圈的新增 、修改、分页列表显示
 * 时间：2016-9-27
 */
@Repository(value="busiAreaDao")
public class BusiAreaDao extends IBaseDao{
	
	/**
	 * 商圈分页列表
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<BusiAreaModel> getBusiAreaQCPage(Map<String, Object> map) {
		return this.excutor.queryListPage("busiArea.getBusiAreaQCPage", map);
	}
	/**
	 * 获取区划列表
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getbusiZoningAll(Map<String, Object> map){
		return this.excutor.queryForList("busiArea.getbusiZoningAll");
	}
	
	/**
	 * 修改商圈（选择性）
	 * @param map {key:businessAreaId,商圈名:AreaName,区划id:zoningId}
	 * @return Integer(type非等于0 成功，否则失败)
	 */
	public Integer updateBusiArea(Map<String, Object> map) {
		return this.excutor.insert("busiArea.updateBySelective", map);
	}
	
	/**
	 * 插入商圈和行政区关系
	 * @param map {key:businessAreaId,行政区id:adminId}
	 * @return Integer(type非等于0 成功，否则失败)
	 */
	public Integer addRelation(Map<String, Object> map) {
		return this.excutor.insert("busiArea.insertRelation", map);
	}
	
	/**
	 * 插入商圈
	 * @param map {key:businessAreaId,行政区id:adminId}
	 * @return {busiName:商圈名 ,parentId:上级id,sort:排序,remark:备注,lng:经,lat:纬}
	 */
	public Integer addBusiArea(Map<String, Object> map) {
		return this.excutor.insert("busiArea.insertSelective", map);
	}
	/**
	 * 根据商圈id删除商圈和行政区的关系
	 * @param map {key:businessAreaId}
	 * @return Integer(type非等于0 成功，否则失败)
	 */
	public Integer deleteRelation(Map<String, Object> map) {
		return this.excutor.delete("busiArea.deleteRelation", map);
	}
	
	/**
	 * 商圈列表
	 * @param map
	 * @return BusiAreaModel
	 */
	public BusiAreaModel getBusiArea(Map<String, Object> map) {
		return this.excutor.queryForObject("busiArea.getBusiAreas", map);
	}
	/**
	 * 删除商圈
	 * @param map
	 * @return
	 */
	public Integer deleteBusiArea(Map<String, Object> map) {
		return this.excutor.delete("busiArea.delete", map);
	}
	
	/**
	 * 获取商圈名称
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public BusiAreaModel getBusiName(Map<String, Object> map){
		return this.excutor.queryForObject("busiArea.getBusiNameList",map);
	}
	/**
	 * 模糊查询获取商圈列表
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiNameList(Map<String, Object> map){
		return this.excutor.queryForList("busiArea.getBusiNameList",map);
	}
	
	/**
	 * 获取商圈
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getQueryBusiArea(Map<String, Object> map){
		return this.excutor.queryForList("busiArea.getQueryBusiArea",map);
	}

	/**
	 * 获取大商圈
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getParentBusiAreaList(Map<String, Object> map){
		return this.excutor.queryForList("busiArea.getParentBusiAreaList",map);
	}

	/**
	 * 获取小商圈
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiAreaList(Map<String, Object> map){
		return this.excutor.queryForList("busiArea.getBusiAreaList",map);
	}
	
	/**
	 * 获取小商圈
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public Integer getBusiAreaCount(Map<String, Object> map){
		return this.excutor.queryForObject("busiArea.getBusiAreaCount",map);
	}
	
	/**
	 * 根据id获商圈
	 * @param map{id：busiAreaId}
	 * @return BusiAreaModel
	 */
	public BusiAreaModel getBusiAreaById(Map<String, Object> map){
		return this.excutor.queryForObject("busiArea.getBusiArea",map);
	}
	/**
	 * 获取区域下商圈数量
	 * @return BusiAreaModel
	 */
	public BusiAreaModel getAreaBusiCount(Map<String, Object> map){
		return this.excutor.queryForObject("busiArea.getAreaBusiCount",map);
	}
	
	/**
	 * 获取楼盘下的商圈数量
	 * @return integer
	 *map{busiAreaId：商圈id}
	 */
	public Integer getPremisesCount(Map<String, Object> map){
		return this.excutor.queryForObject("busiArea.getPremisesCount",map);
	}
}
