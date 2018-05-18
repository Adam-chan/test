package com.golden.ihome.crm.service.house;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.house.HouseSpaceSeeDao;
import com.golden.ihome.crm.model.HouseSpaceSeeModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author sy
 * 类名称：房源空看
 * 时间：2016-11-26
 */
@Service("house/houseSpaceSeeService")
public class houseSpaceSeeService implements IBaseHandler{

	@Autowired
	private HouseSpaceSeeDao houseSpaceSeeDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 分页查询房源空看管理 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSpaceSeeModel> getHouseSpaceSeeListForPage(Map<String, Object> map){
		return houseSpaceSeeDao.getHouseSpaceSeeListForPage(map);
	}
	
	/**
	 * 删除空看
	 * @param map
	 * @return
	 */
	public Integer deleteSpaceSeeByIds(Map<String, Object> map){
		return houseSpaceSeeDao.deleteSpaceSeeByIds(map);
	}
	
	/**
	 * 查询所属组列表 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSpaceSeeModel> getIsGroupListListForPage(Map<String, Object> map){
		return houseSpaceSeeDao.getIsGroupListForPage(map);
	}
	
	/**
	 * 查询非所属组列表 sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSpaceSeeModel> getNoGroupListListForPage(Map<String, Object> map){
		return houseSpaceSeeDao.getNoGroupListForPage(map);
	}
}
