package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

public class CustomerRecommendModel implements Serializable{
	
	
	private static final long serialVersionUID = -6709880490389827990L;

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 房源编号
	 */
	private String code;
	/**
	 * 房源ID
	 */
	private Integer houseInfoId;
	/**
	 * 客户需求表ID
	 */
	private Integer demandId;
	/**
	 * 推荐时间
	 */
	private Date createTime;
	/**
	 * 推荐人
	 */
	private String recommendUser;
	/**
	 * 推荐人ID
	 */
	private String recommendUserId;
	/**
	 * 推荐组编号
	 */
	private String recommendOrgCode;
	/**
	 * 楼盘ID
	 */
	private Integer premisesId;
	/**
	 * 楼盘名称
	 */
	private String premisesName;
	/**
	 * 总价
	 */
	private Double totalPrice;
	/**
	 * 建筑面积
	 */
	private Double coveredArea;
	/**
	 * 朝向1东，2南，3西，4北
	 */
	private Integer chaoXiang;
	/**
	 * 详细地址
	 */
	private String addressDetail;
	/**
	 * 钥匙情况
	 */
	private String keyPosition;
	/**
	 * 车位类型
	 */
	private String carPortType;
	/**
	 * 车位楼层
	 */
	private String carFloor;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Integer getDemandId() {
		return demandId;
	}
	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRecommendUser() {
		return recommendUser;
	}
	public void setRecommendUser(String recommendUser) {
		this.recommendUser = recommendUser;
	}
	public String getRecommendUserId() {
		return recommendUserId;
	}
	public void setRecommendUserId(String recommendUserId) {
		this.recommendUserId = recommendUserId;
	}
	public String getRecommendOrgCode() {
		return recommendOrgCode;
	}
	public void setRecommendOrgCode(String recommendOrgCode) {
		this.recommendOrgCode = recommendOrgCode;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getCoveredArea() {
		return coveredArea;
	}
	public void setCoveredArea(Double coveredArea) {
		this.coveredArea = coveredArea;
	}
	public Integer getChaoXiang() {
		return chaoXiang;
	}
	public void setChaoXiang(Integer chaoXiang) {
		this.chaoXiang = chaoXiang;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getKeyPosition() {
		return keyPosition;
	}
	public void setKeyPosition(String keyPosition) {
		this.keyPosition = keyPosition;
	}	
	public String getCarPortType() {
		return carPortType;
	}
	public void setCarPortType(String carPortType) {
		this.carPortType = carPortType;
	}
	public String getCarFloor() {
		return carFloor;
	}
	public void setCarFloor(String carFloor) {
		this.carFloor = carFloor;
	}
	/**
	 * 添加时间
	 * 
	 * @return
	 */
	public String getCreateTimeStr() {
		String createTimeStr = "";
		if (this.createTime == null) {
			return null;
		} else {
			createTimeStr = DateUtil.getStringByDate(this.createTime, "yyyy-MM-dd");
			return createTimeStr;
		}
	}
}
