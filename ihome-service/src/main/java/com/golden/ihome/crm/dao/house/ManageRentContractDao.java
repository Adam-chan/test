package com.golden.ihome.crm.dao.house;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.ManageRentContractModel;
import com.golden.port.framework.mybatis.IBaseDao;
/**
 * @author lza
 * 类名称：普租签约管理Dao
 * 类描述：普租签约管理表的数据访问
 * 日          期：2016-11-24
 */
@Repository(value="manageRentContractDao")
public class ManageRentContractDao extends IBaseDao{
	/**
	 * 获取普租一条数据根据房源id
	 * @param map{houseInfoId：房源主表id}
	 * @return list<ManageRentContractModel>
	 */
	public  ManageRentContractModel getManageRentContract(Map<String, Object> map) {
		return this.excutor.queryForObject("manageRentContract.getManageRentContract", map);
	}
	
	/**
	 * 插入获取普租
	 * @param map{ManageRentContractModel：实体的所有字段有选择插入}
	 * @return Integer 大于0 成功  小于0失败
	 */
	public Integer insertManageRentContract(Map<String, Object> map) {
		return this.excutor.insert("manageRentContract.insertSelective", map);
	}
	
	/**
	 * 根据房源id获取房源所在的区县
	 * @param map{houseInfoId：房源主表id}
	 * @return list<ManageRentContractModel>
	 */
	public  ManageRentContractModel getCounty(Map<String, Object> map) {
		return this.excutor.queryForObject("manageRentContract.getCounty", map);
	}
	/**
	 * 根据普租合同id修改普租合同
	 * @param map{houseInfoId：房源主表id}
	 * @return list<ManageRentContractModel>
	 */
	public Integer updateManageRentContract(Map<String, Object> map) {
		return this.excutor.update("manageRentContract.updateSelective", map);
	}
}
