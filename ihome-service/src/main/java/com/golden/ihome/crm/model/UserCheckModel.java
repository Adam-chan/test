package com.golden.ihome.crm.model;

import java.util.Date;

public class UserCheckModel {
	private Integer id;
	private String userId;
	private String orgCode;//组织编号
	private Integer userType;//工作人员职位类型1经纪人，2组长，3区经理，4大区经理
	private Integer customerSaleTellCount;//买卖客源查看次数
	private Integer customerLeaseTellCount;//租赁客源查看次数
	private Integer houseSaleTellCount;//买卖房源电话查看次数
	private Integer houseLeaseTellCount;//租赁房源电话查看次数
	private Integer houseSaleAddrCount;//买卖房源地址查看次数
	private Integer houseLeaseAddrCount;//买卖房源地址查看次数
	private Date operateTime;//查看时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getCustomerSaleTellCount() {
		return customerSaleTellCount;
	}
	public void setCustomerSaleTellCount(Integer customerSaleTellCount) {
		this.customerSaleTellCount = customerSaleTellCount;
	}
	public Integer getCustomerLeaseTellCount() {
		return customerLeaseTellCount;
	}
	public void setCustomerLeaseTellCount(Integer customerLeaseTellCount) {
		this.customerLeaseTellCount = customerLeaseTellCount;
	}
	public Integer getHouseSaleTellCount() {
		return houseSaleTellCount;
	}
	public void setHouseSaleTellCount(Integer houseSaleTellCount) {
		this.houseSaleTellCount = houseSaleTellCount;
	}
	public Integer getHouseLeaseTellCount() {
		return houseLeaseTellCount;
	}
	public void setHouseLeaseTellCount(Integer houseLeaseTellCount) {
		this.houseLeaseTellCount = houseLeaseTellCount;
	}
	public Integer getHouseSaleAddrCount() {
		return houseSaleAddrCount;
	}
	public void setHouseSaleAddrCount(Integer houseSaleAddrCount) {
		this.houseSaleAddrCount = houseSaleAddrCount;
	}
	public Integer getHouseLeaseAddrCount() {
		return houseLeaseAddrCount;
	}
	public void setHouseLeaseAddrCount(Integer houseLeaseAddrCount) {
		this.houseLeaseAddrCount = houseLeaseAddrCount;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
}
