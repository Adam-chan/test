package com.golden.ihome.addr.dao.busiZoning;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.port.framework.mybatis.IBaseDao;
/**
 * @author lza
 * 类名称：区划管理dao
 * 类描述：区划新增、修改、下拉列表
 * 时间：2016-9-27
 */
@Repository(value="busiZoningDao")
public class BusiZoningDao extends IBaseDao{

	
	/**
	 * 添加区划
	 * @param map {BusiZoningName:区划名称}
	 * @return Integer(type非等于0 成功，否则失败)
	 */
	public Integer addBusiZoning(Map<String, Object> map) {
		return this.excutor.insert("busiZoning.insert", map);
	}
	/**
	 * 修改区划
	 * @param map {BusiZoningName:区划名称 ,BusiZoningId:主键}
	 * @return Integer(type非等于0 成功，否则失败)
	 */
	public Integer updateBusiZoning(Map<String, Object> map) {
		return this.excutor.insert("busiZoning.update", map);
	}
	
	/**
	 * 获取区划列表
	 * @return List<BusiAreaModel>:区划列表
	 */
	public List<BusiAreaModel> getBusiZoningLst() {
		return this.excutor.queryForList("busiZoning.getBusiZoningList");
	}
	
	/**
	 * 修改区划
	 * @param map {BusiZoningId:主键}
	 * @return Integer(type非等于0 成功，否则失败)
	 */
	public Integer deleteBusiZoning(Map<String, Object> map) {
		return this.excutor.insert("busiZoning.delete", map);
	}
}
