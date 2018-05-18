package com.golden.ihome.crm.dao.house;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.HouseCollectModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author sy
 * 类名称：房源收藏管理
 * 时间：2016-12-01
 */
@Repository(value="houseCollectDao")
public class HouseCollectDao extends IBaseDao{
	
	/**
	 * 分页查询房源跟进 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseCollectModel> getHouseCollectListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseCollect.getHouseCollectListForPage", map);
	}
	
	/**
	 * 取消收藏  sy
	 * @param map
	 * @return
	 */
	public Integer deleteCollectByIds(Map<String, Object> map) {
		return this.excutor.delete("houseCollect.deleteCollectByIds", map);
	}
}
