package com.golden.ihome.addr.model;

import java.io.Serializable;

/**
 * 楼盘的经营范围分配
 * @author dl
 * 时间：2016-12-5
 */
public class OperateModel implements Serializable{

	private static final long serialVersionUID = 3721289488911686970L;
	
	private Integer id;
	// 类型（1：楼盘,2：商圈）
	private Integer type;
	// 数据Id
	private Integer dataId;
	// 组织编码
	private String orgCode;
	// 操作时间
	private String operateDate;
	// 大区名称
	private String areaName;
	// 区名称
	private String zoneName;
	// 组名称
	private String groupName;
	// 楼盘id
	private Integer premisesId;
	// 楼盘名称
	private String premisesName;
	//区id
	private String baseAreaId;
	// 区名称
	private String baseAreaName;
	//街道id
	private String subdistricId;
	// 街道名称
	private String subdistrictName;
	// 社区id
	private String communityId;
	// 社区名称
	private String communityName;
	//道路id
	private String roadId;
	// 道路名称
	private String roadName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public String getBaseAreaId() {
		return baseAreaId;
	}
	public void setBaseAreaId(String baseAreaId) {
		this.baseAreaId = baseAreaId;
	}
	public String getSubdistricId() {
		return subdistricId;
	}
	public void setSubdistricId(String subdistricId) {
		this.subdistricId = subdistricId;
	}
	public String getCommunityId() {
		return communityId;
	}
	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	public String getBaseAreaName() {
		return baseAreaName;
	}
	public void setBaseAreaName(String baseAreaName) {
		this.baseAreaName = baseAreaName;
	}
	public String getSubdistrictName() {
		return subdistrictName;
	}
	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	
}
