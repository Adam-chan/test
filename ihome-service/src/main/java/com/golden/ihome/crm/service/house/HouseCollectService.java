package com.golden.ihome.crm.service.house;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.house.HouseCollectDao;
import com.golden.ihome.crm.model.HouseCollectModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author sy
 * 类名称：房源收藏
 * 时间：2016-12-01
 */
@Service("house/houseCollectService")
public class HouseCollectService implements IBaseHandler{

	@Autowired
	private HouseCollectDao houseCollectDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 分页查询房源收藏管理 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseCollectModel> getHouseCollectListForPage(Map<String, Object> map){
		return houseCollectDao.getHouseCollectListForPage(map);
	}
	
	/**
	 * 取消收藏
	 * @param map
	 * @return
	 */
	public Integer deleteCollectByIds(Map<String, Object> map){
		return houseCollectDao.deleteCollectByIds(map);
	}
}
