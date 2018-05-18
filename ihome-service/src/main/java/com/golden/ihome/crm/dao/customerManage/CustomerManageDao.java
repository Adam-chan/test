package com.golden.ihome.crm.dao.customerManage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.CustomerManageModel;
import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author weizhichao 类名称：联系人管理Dao 类描述：联系人管理 时间：2016-10-28
 */
@Repository(value = "customerManageDao")
public class CustomerManageDao extends IBaseDao {

	/**
	 * 分页查询联系人
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerManageModel> getCustomerManagePage(Map<String, Object> map) {
		PagerResult<CustomerManageModel> model = this.excutor.queryListPage("customers.getCustomerManagePage", map);
		return model;
	}

	/**
	 * 根据联系人编码得到联系人详细信息
	 * @param map
	 * @return CustomerManageModel
	 */
	public CustomerManageModel getCustomerByUserCode(Map<String, Object> map) {
		List<CustomerManageModel> list = this.excutor.queryForList("customers.getCustomerByUserCode", map);
		CustomerManageModel model = list.get(0);
		return model;
	}

	/**
	 * 新增联系人
	 * @param map
	 * @return {}
	 */
	public Integer addCustomer(Map<String, Object> map) {
		return this.excutor.insert("customers.addCustomer", map);
	}

	/**
	 * 模糊匹配联系人名称
	 * @param String matchStr 匹配字段
	 * @return List<CustomerManageModel>
	 */
	public List<CustomerManageModel> getUserName(Map<String, Object> map) {
		return this.excutor.queryForList("customers.getUserName", map);
	}

	/**
	 * 根据联系人Id得到联系人详细信息
	 * @param map
	 * @return CustomerManageModel
	 */
	public CustomerManageModel getCustomerById(Map<String, Object> map) {
		CustomerManageModel model = this.excutor.queryForObject
		("customers.getCustomerById", map);
		return model;
	}

	/**
	 * 修改联系人
	 * @param map
	 * @return {}
	 */
	public Integer updateCustomer(Map<String, Object> map) {
		return this.excutor.update("customers.updateCustomer", map);
	}

	/**
	 * 根据联系人Tell得到联系人详细信息
	 * @param map
	 * @return CustomerManageModel
	 */
	public CustomerManageModel getCustomerByTell(Map<String, Object> map) {
		CustomerManageModel model = this.excutor.queryForObject
		("customers.getCustomerByTell", map);
		return model;
	}
	
	/**
	 * 查询联系人是否已被拉黑
	 * @param map
	 * @return 
	 */
	public Integer queryBlackListById(Map<String, Object> map) {
		return this.excutor.queryForObject("customers.queryBlackListById", map);
	}
	
	/**
	 * 保存拉黑联系人
	 * @param map
	 * @return 
	 */
	public Integer saveBlackList(Map<String, Object> map) {
		return this.excutor.insert("customers.saveBlackList", map);
	}
	
	/**
	 * 查询插入的联系人ID
	 * @param map
	 * @return 
	 */
	public Integer getLastInsertCustomerId(Map<String, Object> map) {
		Integer in = this.excutor.queryForObject("customers.getLastInsertCustomerId",map);
		return in;
	}
	
	/**
	 * 根据客户ID查询该客户有多少条未完成的客源
	 * @param map
	 */
	public List<Map<String, Object>> getCustSourceCountById(Map<String, Object> map) {
		return this.excutor.queryForList("customers.getCustSourceCountById", map);
	}

	/**
	 * 分页查询联系人
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceModel> getdemandsPage(Map<String, Object> map) {
		PagerResult<CustomerSourceModel> model = this.excutor.queryListPage("customers.getdemandsPage", map);
		return model;
	}
}
