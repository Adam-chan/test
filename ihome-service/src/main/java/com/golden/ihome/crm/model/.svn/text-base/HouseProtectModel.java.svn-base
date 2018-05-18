package com.golden.ihome.crm.model;

import java.util.Date;

import com.golden.ihome.common.HouseCommon;
import com.golden.ihome.utils.DateUtil;

/**
 * 房源保护管理
 *  
 */
public class HouseProtectModel {
	
	private Integer id;//保护ID
	private Integer houseInfoId;//房源ID
	private String protectUser;//保护人
	private String protectUserId;//申请保护人ID
	private String protectUserOrgCode;//申请保护人组织编号
	private Date createTime;//创建时间
	private String createTimeStr;
	private Integer examineStatus;
	private String examineStatusStr;//审核状态
	private String examineUser;//审核人
	private String examineUserId;//审核人ID
	private Date endDate;//保护结束时间
	private String endDateStr;
	
	private String houseCode;//房源编号
	private Integer demandType;//需求类型
	private String demandTypeStr;
	private String owner;//业主
	private String ownerTell;//业主电话
	private Integer useType;//使用类别，住宅，商铺，写字楼等---数据库配置
	private String usedTypeStr;//
	private String premisesName;//楼盘名称
	private String premisesAddress;//楼盘详细地址
	private String bilityArea;//所属区
	private String bilityTeam;//所属组
	private String bilityUser;//所属人
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public String getProtectUserId() {
		return protectUserId;
	}
	public void setProtectUserId(String protectUserId) {
		this.protectUserId = protectUserId;
	}
	public String getProtectUserOrgCode() {
		return protectUserOrgCode;
	}
	public void setProtectUserOrgCode(String protectUserOrgCode) {
		this.protectUserOrgCode = protectUserOrgCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateTimeStr() {
		this.createTimeStr = DateUtil.getDateString(this.getCreateTime(), "yyyy-MM-dd HH:mm");
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public Integer getExamineStatus() {
		return examineStatus;
	}
	public void setExamineStatus(Integer examineStatus) {
		this.examineStatus = examineStatus;
	}
	public String getExamineStatusStr() {
		return examineStatusStr;
	}
	public void setExamineStatusStr(String examineStatusStr) {
		this.examineStatusStr = examineStatusStr;
	}
	public String getExamineUser() {
		return examineUser;
	}
	public void setExamineUser(String examineUser) {
		this.examineUser = examineUser;
	}
	public String getExamineUserId() {
		return examineUserId;
	}
	public void setExamineUserId(String examineUserId) {
		this.examineUserId = examineUserId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEndDateStr() {
		this.endDateStr = DateUtil.getDateString(this.getEndDate(),"yyyy-MM-dd HH:mm");
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Integer getDemandType() {
		return demandType;
	}
	public void setDemandType(Integer demandType) {
		this.demandType = demandType;
	}
	public String getDemandTypeStr() {
		this.demandTypeStr = HouseCommon.getHouseTypeStr(this.getDemandType());
		return demandTypeStr;
	}
	public void setDemandTypeStr(String demandTypeStr) {
		this.demandTypeStr = demandTypeStr;
	}
	public String getOwnerTell() {
		return ownerTell;
	}
	public void setOwnerTell(String ownerTell) {
		this.ownerTell = ownerTell;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	public String getUsedTypeStr() {
		this.usedTypeStr = HouseCommon.getUseTypeStr(this.getUseType());
		return usedTypeStr;
	}
	public void setUsedTypeStr(String usedTypeStr) {
		this.usedTypeStr = usedTypeStr;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	public String getPremisesAddress() {
		return premisesAddress;
	}
	public void setPremisesAddress(String premisesAddress) {
		this.premisesAddress = premisesAddress;
	}
	public String getBilityArea() {
		return bilityArea;
	}
	public void setBilityArea(String bilityArea) {
		this.bilityArea = bilityArea;
	}
	public String getBilityTeam() {
		return bilityTeam;
	}
	public void setBilityTeam(String bilityTeam) {
		this.bilityTeam = bilityTeam;
	}
	public String getBilityUser() {
		return bilityUser;
	}
	public void setBilityUser(String bilityUser) {
		this.bilityUser = bilityUser;
	}
	public String getProtectUser() {
		return protectUser;
	}
	public void setProtectUser(String protectUser) {
		this.protectUser = protectUser;
	}
}
