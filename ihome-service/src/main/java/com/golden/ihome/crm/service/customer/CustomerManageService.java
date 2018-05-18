package com.golden.ihome.crm.service.customer;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.common.CodeConst;
import com.golden.ihome.common.service.CommonCode;
import com.golden.ihome.crm.dao.customerManage.CustomerManageDao;
import com.golden.ihome.crm.model.CustomerManageModel;
import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

/**
 * @author weizhichao 
 * 类名称：联系人管理Service 
 * 类描述：联系人管理
 * 时间：2016-10-28
 */
@Service("customerManage/customerManageService")
public class CustomerManageService implements IBaseHandler{
	
	@Autowired
	private CustomerManageDao customerManageDao;

	@Resource(name = "commonCode")
	private CommonCode commonCode;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return null;
	}
	
	/**
	 * 分页查询联系人
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerManageModel> getCustomerManagePage(
			Map<String, Object> map) {
		return customerManageDao.getCustomerManagePage(map);
	}
	
	/**
	 * 根据联系人编码得到联系人详细信息
	 * 
	 * @return CustomerManageModel
	 */
	public CustomerManageModel getCustomerByUserCode(Map<String, Object> param) {
		CustomerManageModel model = customerManageDao.getCustomerByUserCode(param);
		return model;
	}
	
	/**
	 * 添加联系人
	 * @param param {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer addCustomer(Map<String, Object> map) throws Exception {
		String customerCode = commonCode.getCode(CodeConst.CUSTOMER_CODE);
		map.put("userCode", customerCode);
		return customerManageDao.addCustomer(map);
	}
	
	/**
	 * 模糊匹配联系人名称
	 * @param param matchStr : 名称
	 * @return List<CustomerManageModel>
	 */
	public List<CustomerManageModel> getUserName(Map<String, Object> param){
		return customerManageDao.getUserName(param);
	}
	
	/**
	 * 根据联系人Id得到联系人详细信息
	 * @return CustomerManageModel
	 */
	public CustomerManageModel getCustomerById(Map<String, Object> param) {
		CustomerManageModel model = customerManageDao.getCustomerById(param);
		return model;
	}
	
	/**
	 * 修改联系人
	 * @param param {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer updateCustomer(Map<String, Object> map) throws Exception {
		return customerManageDao.updateCustomer(map);
	}
	
	/**
	 * 根据联系人Tell得到联系人详细信息
	 * @return CustomerManageModel
	 */
	public CustomerManageModel getCustomerByTell(Map<String, Object> param) {
		CustomerManageModel model = customerManageDao.getCustomerByTell(param);
		return model;
	}
	
	/**
	 * 查询联系人是否已被拉黑
	 * @param map
	 * @return 
	 */
	public  Integer queryBlackListById(Map<String, Object> param) {
		Integer model = customerManageDao.queryBlackListById(param);
		return model;
	}
	
	/**
	 * 保存拉黑联系人
	 * @param param {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer saveBlackList(Map<String, Object> map) throws Exception {
		return customerManageDao.saveBlackList(map);
	}
	
	/**
	 * 查询插入的联系人ID
	 * @param map
	 * @return 
	 */
	public Integer getLastInsertCustomerId(Map<String, Object> map) {
		return customerManageDao.getLastInsertCustomerId(map);
	}
	
	/**
	 * 根据客户ID查询该客户有多少条未完成的客源
	 * 
	 * @param param{}
	 * @return Integer
	 */
	public List<Map<String, Object>> getCustSourceCountById(Map<String, Object> map) throws Exception {
		return customerManageDao.getCustSourceCountById(map);
	}
	
	/**
	 * 分页查询客户需求
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceModel> getdemandsPage(
			Map<String, Object> map) {
		return customerManageDao.getdemandsPage(map);
	}
}
