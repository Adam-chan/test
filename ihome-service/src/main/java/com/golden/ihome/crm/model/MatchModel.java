package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 赛事发布
 * 
 * @author guoweichen
 * 
 */
public class MatchModel implements Serializable {

	private SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 
	 */
	private static final long serialVersionUID = -6512723356713555874L;

	// 主键
	private Integer id;

	// 赛事名称
	private String name;

	// 赛区类别ID
	private Integer categoryId;

	// 开始时间
	private Date startTime;

	// 结束时间
	private Date endTime;

	// 赛事规则
	private String rule;

	// 发布状态
	private Integer status;

	// 发布时间
	private Date publishTime;

	// 赛区类别名称
	private String categoryName;

	// 赛区Id
	private Integer zoneId;
	
	// 赛区名称
	private String zoneName;
	
	// 赛区名称
	private Integer zoneType;
	
	// 买卖目标值
	private Integer deal;
	
	// 租赁目标值
	private Integer rent;
	
	// 备注
	private String remark;
	
	// 买卖战队名称
	private String dealTeamName;
	
	public String getDealTeamName() {
		return dealTeamName;
	}

	public void setDealTeamName(String dealTeamName) {
		this.dealTeamName = dealTeamName;
	}

	public String getRentTeamName() {
		return rentTeamName;
	}

	public void setRentTeamName(String rentTeamName) {
		this.rentTeamName = rentTeamName;
	}

	// 租赁站队名称
	private String rentTeamName;
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getDeal() {
		return deal;
	}

	public void setDeal(Integer deal) {
		this.deal = deal;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getStartTime() {
		if(startTime != null){
			return dateFormater.format(startTime);
		}
		return "";
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		if(endTime != null){
			return dateFormater.format(endTime);
		}
		return "";
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}
	
	public Integer getZoneId() {
		return zoneId;
	}
	
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	
	public String getZoneName() {
		return zoneName;
	}
	
	public String getPublishTime() {
		if(publishTime != null){
			return dateFormater.format(publishTime);
		}
		return "";
	}

	public void setPublishTime(Date publishTime) {
		if(publishTime != null){
			this.publishTime = publishTime;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMatchStatus() {
		if(startTime != null && endTime != null){
			Date date = new Date();
			if (startTime.getTime() <= date.getTime() && date.getTime() <= endTime.getTime()) {
				return "进行中";
			} else if (endTime.getTime() < date.getTime()) {
				return "已结束";
			}
		}
		return "未开始";
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public void setZoneType(Integer zoneType) {
		this.zoneType = zoneType;
	}
	
	public Integer getZoneType() {
		return zoneType;
	}
}
