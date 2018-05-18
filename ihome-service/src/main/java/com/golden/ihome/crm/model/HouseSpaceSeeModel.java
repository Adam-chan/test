package com.golden.ihome.crm.model;

import java.io.Serializable;


/**
 * 空看管理
 * 
 * @author 
 * 
 */
public class HouseSpaceSeeModel implements Serializable{

	private static final long serialVersionUID = -8432352547788115767L;
	
	/**
	 * id序列
	 */
	private Integer id;
	/**
	 * 空看时间
	 */
	private String spaceSeeTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 空看人
	 */
	private String operateUser;
	/**
	 * 空看人Id
	 */
	private String operateUserId;
	/**
	 * 组id
	 */
	private String operateGroup;
	/**
	 * 组名称
	 */
	private String operateGroupName;
	//所属组
	private String isOperateUserCount;
	//非所属组
	private String noOperateUserCount;
	//非所属组看房次数
	private String spaceSeeCount;
	//非所属组最后空看时间
	private String lastSpaceSeeTime;
	/**
	 * 房源信息
	 */
	private Integer houseInfoId;//房源ID
	private String houseCode;//房源编号
	private String demandType;//业务类型
	private Integer useType;//使用类别
	private String divideQu;//所属区
	private String divideQuCode;//所属区编号
	private String divideOrg;//所属组
	private String divideOrgCode;//所属组编号
	private String divideUser;//所属人
	private String divideUserId;//所属人Id
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpaceSeeTime() {
		return spaceSeeTime;
	}
	public void setSpaceSeeTime(String spaceSeeTime) {
		this.spaceSeeTime = spaceSeeTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDemandType() {
		return demandType;
	}
	public void setDemandType(String demandType) {
		this.demandType = demandType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public String getDivideQu() {
		return divideQu;
	}
	public void setDivideQu(String divideQu) {
		this.divideQu = divideQu;
	}
	public String getDivideQuCode() {
		return divideQuCode;
	}
	public void setDivideQuCode(String divideQuCode) {
		this.divideQuCode = divideQuCode;
	}
	public String getDivideOrg() {
		return divideOrg;
	}
	public void setDivideOrg(String divideOrg) {
		this.divideOrg = divideOrg;
	}
	public String getDivideOrgCode() {
		return divideOrgCode;
	}
	public void setDivideOrgCode(String divideOrgCode) {
		this.divideOrgCode = divideOrgCode;
	}
	public String getDivideUser() {
		return divideUser;
	}
	public void setDivideUser(String divideUser) {
		this.divideUser = divideUser;
	}
	public String getDivideUserId() {
		return divideUserId;
	}
	public void setDivideUserId(String divideUserId) {
		this.divideUserId = divideUserId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getOperateUserId() {
		return operateUserId;
	}
	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}
	public String getOperateGroup() {
		return operateGroup;
	}
	public void setOperateGroup(String operateGroup) {
		this.operateGroup = operateGroup;
	}
	public String getOperateGroupName() {
		return operateGroupName;
	}
	public void setOperateGroupName(String operateGroupName) {
		this.operateGroupName = operateGroupName;
	}
	public String getIsOperateUserCount() {
		return isOperateUserCount;
	}
	public void setIsOperateUserCount(String isOperateUserCount) {
		this.isOperateUserCount = isOperateUserCount;
	}
	public String getNoOperateUserCount() {
		return noOperateUserCount;
	}
	public void setNoOperateUserCount(String noOperateUserCount) {
		this.noOperateUserCount = noOperateUserCount;
	}
	public String getSpaceSeeCount() {
		return spaceSeeCount;
	}
	public void setSpaceSeeCount(String spaceSeeCount) {
		this.spaceSeeCount = spaceSeeCount;
	}
	public String getLastSpaceSeeTime() {
		return lastSpaceSeeTime;
	}
	public void setLastSpaceSeeTime(String lastSpaceSeeTime) {
		this.lastSpaceSeeTime = lastSpaceSeeTime;
	}
	public String getDemmandType() {
		return demandType;
	}
	public void setDemmandType(String demmandType) {
		this.demandType = demmandType;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	
}
