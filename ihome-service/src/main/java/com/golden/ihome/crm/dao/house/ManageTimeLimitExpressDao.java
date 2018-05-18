package com.golden.ihome.crm.dao.house;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.ManageTimeLimitExpressModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author lza
 * 类名称：限时速递dao
 * 类描述：限时速递管理到
 * 时间：2016-11-18
 */
@Repository(value="manageTimeLimitExpressDao")
public class ManageTimeLimitExpressDao  extends IBaseDao{

	/**
	 * 分页列表查询
	 * @param map{houseInfoId：房源表id，type：1买卖，2租赁}
	 * @return PagerResult<ManageTimeLimitExpressModel>
	 */
	public  PagerResult<ManageTimeLimitExpressModel> getManageTimeLimitExpressPage(Map<String, Object> map) {
		return this.excutor.queryListPage("manageTimeLimitExpress.getManageTimeLimitExpressPage", map);
	}
	
	/**
	 * 插入限速递
	 * @param map{ManageTimeLimitExpressModel：实体的所有字段有选择插入}
	 * @return Integer 大于0 成功  小于0失败
	 */
	public Integer insertManageTimeLimitExpress(Map<String, Object> map) {
		return this.excutor.insert("manageTimeLimitExpress.insertSelective", map);
	}
	
	/**
	 * 获取限时速递一条数据
	 * @param map{id：根据限时速递表id}
	 * @return ManageTimeLimitExpressModel
	 */
	public ManageTimeLimitExpressModel getManageTimeLimitExpress(Map<String, Object> map) {
		return this.excutor.queryForObject("manageTimeLimitExpress.getManageTimeLimitExpress", map);
	}
	/**
	 * 根据条件返回限时速递数据条数
	 * @param map{房源id：houseInfoId,合同签约状态：status}
	 * @return ManageTimeLimitExpressModel
	 */
	public Integer getBycount(Map<String, Object> map) {
		return this.excutor.queryForObject("manageTimeLimitExpress.getBycount", map);
	}
	/**
	 * 限时速递结束和终止操作
	 * @param map{房源id：限时速递id,合同签约状态：status}
	 * @return Integer 大于0成功，小于0失败
	 */
	public Integer updataStuts(Map<String, Object> map) {
		return this.excutor.update("manageTimeLimitExpress.updateSelective", map);
	}
	/**
	 * 获取限时速递唯一有效的一条数据LB
	 * @param map{id：根据限时速递表id}
	 * @return ManageTimeLimitExpressModel
	 */
	public ManageTimeLimitExpressModel getTimeLimitInfo(Map<String, Object> map) {
		return this.excutor.queryForObject("manageTimeLimitExpress.getTimeLimitInfo", map);
	}
}
