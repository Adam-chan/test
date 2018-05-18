package com.golden.ihome.crm.dao.house;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.HouseSpaceSeeModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author sy
 * 类名称：房源空看管理
 * 时间：2016-11-26
 */
@Repository(value="houseSpaceSeeDao")
public class HouseSpaceSeeDao extends IBaseDao{
	
	/**
	 * 分页查询房源跟进 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSpaceSeeModel> getHouseSpaceSeeListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseSpaceSee.getHouseSpaceSeeListForPage", map);
	}
	
	/**
	 * 删除空看 sy
	 * @param map
	 * @return
	 */
	public Integer deleteSpaceSeeByIds(Map<String, Object> map) {
		return this.excutor.delete("houseSpaceSee.deleteSpaceSeeByIds", map);
	}
	
	/**
	 * 查询所属组列表 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSpaceSeeModel> getIsGroupListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseSpaceSee.getIsGroupListForPage", map);
	} 
	
	/**
	 * 查询非所属组列表 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSpaceSeeModel> getNoGroupListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseSpaceSee.getNoGroupListForPage", map);
	}
}
