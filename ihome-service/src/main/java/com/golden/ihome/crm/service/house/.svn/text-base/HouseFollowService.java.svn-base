package com.golden.ihome.crm.service.house;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.house.HouseFollowDao;
import com.golden.ihome.crm.dao.sysParame.SysParamDao;
import com.golden.ihome.crm.model.HouseFollowModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author dl
 * 类名称：房源跟进
 * 时间：2016-11-26
 */
@Service("house/houseFollowService")
public class HouseFollowService implements IBaseHandler{

	@Autowired
	private HouseFollowDao houseFollowDao;
	@Autowired
	private SysParamDao sysParamDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 分页查询房源跟进
	 * @param map
	 * @return
	 */
	public PagerResult<HouseFollowModel> getHouseFollowListForPage(Map<String, Object> map){
		String searchFlag = (String)map.get("searchFlag");
		if(null!=searchFlag && !searchFlag.equals("")){
			String[] searchFlags = searchFlag.split(",");
			map.put("searchFlagList", searchFlags);
		}
		PagerResult<HouseFollowModel> pagerResult = houseFollowDao.getHouseFollowListForPage(map);
		return pagerResult;
	}
}
