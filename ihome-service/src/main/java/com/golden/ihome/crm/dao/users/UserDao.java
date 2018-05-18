package com.golden.ihome.crm.dao.users;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.UserCheckModel;
import com.golden.port.framework.mybatis.IBaseDao;

@Repository(value="userDao")
public class UserDao extends IBaseDao{
	/**
	 * 查询用户的电话次数等信息 
	 */
	public UserCheckModel getUserCheckInfo(String userId){
		return this.excutor.queryForObject("users.getUserCheckInfo", userId);
	}
	/**
	 * 更新用户的电话次数等信息 
	 */
	public Integer updateUserCheck(UserCheckModel userCheckModel){
		return this.excutor.update("users.updateUserCheck", userCheckModel);
	}
	/**
	 * 新增用户，并保存电话次数等信息 
	 */
	public Integer insertUserCheck(UserCheckModel userCheckModel){
		return this.excutor.insert("users.insertUserCheck", userCheckModel);
	}
	/**
	 * 查询房源联系方式列表显示
	 * 
	 */
	public List<Map<String,Object>> getHouseInfoContact(String houseId){
		return this.excutor.queryForList("users.getHouseInfoContact", houseId);
	}
	/**
	 * 查询房源地址
	 * 
	 */
	public Map<String,Object> getHouseInfoAddress(Map<String,Object> param){
		return this.excutor.queryForObject("users.getHouseInfoAddress", param);
	}
	/**
	 * 查询客源电话
	 * 
	 */
	public Map<String,Object> getCustomerInfoTell(Map<String,Object> param){
		return this.excutor.queryForObject("users.getCustomerInfoTell", param);
	}
	/**
	 * 查看自己是否有这个数据的运营权限
	 */
	public List<String> checkHouseJyPerview(Map<String,Object> param){
		return this.excutor.queryForList("users.checkHouseJyPerview", param);
	}
	/**
	 * 房源查看电话和地址：查看自己是否有这个数据的责任权限
	 */
	public Map<String,Object> checkHouseZrPerview(Map<String,Object> param){
		return this.excutor.queryForObject("users.checkHouseZrPerview", param);
	}
	/**
	 * 查看自己是否有这个客户的私客
	 */
	public Map<String,Object> checkCustomerPriv(Map<String,Object> param){
		return this.excutor.queryForObject("users.checkCustomerPriv", param);
	}
	/**
	 * 查看自己是否有这个数据的责任和运营权限
	 * 返回：map{
	 * 	ORG_CODE：组织编号, 
	 * 	USER_ID：用户ID
	 *	USER_NAME：用户姓名
	 * 	AREA_NAME：所在大区
	 * 	ZONE_NAME：所在区
	 * 	GROUP_NAME：所在组
	 * }
	 */
	public Map<String,Object> getZrByRoomId(Map<String,Object> param){
		return this.excutor.queryForObject("users.getZrByRoomId", param);
	}
}
