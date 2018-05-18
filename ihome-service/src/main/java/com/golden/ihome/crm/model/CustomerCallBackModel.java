package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.sql.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * 客源回访
 * 
 * @author weizhichao
 * 
 */
public class CustomerCallBackModel implements Serializable{

	private static final long serialVersionUID = 7866156862122883118L;
	/**
	 * id序列
	 */
	private Integer id;
	/**
	 * 约带看id
	 */
	private Integer promiseId;
	/**
	 * 客源id
	 */
	private Integer demandId;
	/**
	 * 楼盘id
	 */
	private Integer premisesId;
	/**
	 * 房源id
	 */
	private Integer houseId;
	/**
	 * 回访时间
	 */
	private Date callBackTime;
	/**
	 * 回访人
	 */
	private String operateUser;
	/**
	 * 反馈内容
	 */
	private String remark;
	/**
	 * 约带看次数
	 */
	private Integer promiseCount;
	/**
	 * 约带看时间
	 */
	private Date takeDate;
	/**
	 * 客户姓名
	 */
	private String customerName;
	/**
	 * 回访状态:1已回访2未回访
	 */
	private Integer isCallBack;
	/**
	 * 客源编号
	 */
	private String demandCode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPromiseId() {
		return promiseId;
	}
	public void setPromiseId(Integer promiseId) {
		this.promiseId = promiseId;
	}
	public Integer getDemandId() {
		return demandId;
	}
	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public Date getCallBackTime() {
		return callBackTime;
	}
	public void setCallBackTime(Date callBackTime) {
		this.callBackTime = callBackTime;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getPromiseCount() {
		return promiseCount;
	}
	public void setPromiseCount(Integer promiseCount) {
		this.promiseCount = promiseCount;
	}
	public Date getTakeDate() {
		return takeDate;
	}
	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getIsCallBack() {
		return isCallBack;
	}
	public void setIsCallBack(Integer isCallBack) {
		this.isCallBack = isCallBack;
	}
	public String getDemandCode() {
		return demandCode;
	}
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}
	
	/**
	 * 获得带看时间
	 * 
	 * @return
	 */
	public String getTakeDateStr() {
		String takeDateStr = "";
		if (this.takeDate == null) {
			return null;
		} else {
			takeDateStr = DateUtil.getStringByDate(this.takeDate, "yyyy-MM-dd");
			return takeDateStr;
		}
	}
	
	/**
	 * 获得回访时间
	 * 
	 * @return
	 */
	public String getCallBackTimeStr() {
		String callBackTimeStr = "";
		if (this.callBackTime == null) {
			return null;
		} else {
			callBackTimeStr = DateUtil.getStringByDate(this.callBackTime, "yyyy-MM-dd");
			return callBackTimeStr;
		}
	}

}
