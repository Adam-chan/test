package com.golden.ihome.crm.dao.house;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.HouseFollowModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author dl
 * 类名称：房源跟进
 * 时间：2016-11-26
 */
@Repository(value="houseFollowDao")
public class HouseFollowDao extends IBaseDao{
	
	/**
	 * 分页查询房源跟进
	 * @param map
	 * @return
	 */
	public PagerResult<HouseFollowModel> getHouseFollowListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseFollow.getHouseFollowListForPage", map);
	}
	
}
