package com.golden.ihome.crm.dao.customerSource;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * 公客池
 * @author dl
 * 时间：2016-11-30
 */
@Repository(value="customerPoolDao")
public class CustomerPoolDao extends IBaseDao{

	public PagerResult<CustomerSourceModel> getCustomerPoolListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("customerPool.getCustomerPoolListForPage", map);
	}

	public List<BusiAreaModel> getBusiAreaByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("customerPool.getBusiAreaByMatch", map);
	}

	public Integer customerPoolComment(Map<String, Object> map) {
		return this.excutor.update("customerPool.customerPoolComment", map);
	}

}
