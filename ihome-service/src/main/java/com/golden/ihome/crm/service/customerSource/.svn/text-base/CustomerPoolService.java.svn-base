package com.golden.ihome.crm.service.customerSource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.crm.dao.customerSource.CustomerPoolDao;
import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

/**
 * 公客池
 * @author dl
 * 时间：2016-11-30
 */
@Service("customerSource/CustomerPoolService")
public class CustomerPoolService implements IBaseHandler{

	@Autowired
	private CustomerPoolDao customerPoolDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 分页查询成交公客池
	 * @param map
	 * @return
	 */
	public PagerResult<CustomerSourceModel> getCustomerPoolListForPage(Map<String, Object> map){
		return customerPoolDao.getCustomerPoolListForPage(map);
	}
	/**
	 * 商圈-模糊搜索
	 * @param map
	 * @return
	 */
	public List<BusiAreaModel> getBusiAreaByMatch(Map<String, Object> map){
		return customerPoolDao.getBusiAreaByMatch(map);
	}
	/**
	 * 公客池分配
	 * @param map
	 * @return
	 */
	public Integer customerPoolComment(Map<String, Object> map){
		return customerPoolDao.customerPoolComment(map);
	}

}
