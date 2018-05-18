package com.golden.ihome.addr.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 类名称：责任分配
 * 类描述：责任分配
 * 时间：2016-11-08
 */
public class DistModel implements Serializable{

	private static final long serialVersionUID = 1L;

	// 行政区
	private Integer areaId;
	private String areaName;
	// 街道
	private Integer subdistrictId;
	private String subdistrictName;
	// 社区
	private Integer communityId;
	private String communityName;
	// 道路
	private String roadAddr;
	// 楼盘
	private Integer premisesId;
	private String premisesName;
	// 楼盘分组
	private Integer groupId;
	private String groupName;
	// 栋座
	private Integer buildingId;
	private String buildingName;
	// 单元
	private Integer unitId;
	private String unitCode;
	// 责任大区
	private String dutyArea;
	// 责任区
	private String dutyZone;
	// 责任组
	private String dutyGroup;
	// 责任人
	private String userName;
	// 分配时间
	private String operateDate;
	// 数据类型
	private String dataType;

	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getSubdistrictId() {
		return subdistrictId;
	}
	public void setSubdistrictId(Integer subdistrictId) {
		this.subdistrictId = subdistrictId;
	}
	public String getSubdistrictName() {
		return subdistrictName;
	}
	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}
	public Integer getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getRoadAddr() {
		return roadAddr;
	}
	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
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
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getDutyArea() {
		return dutyArea;
	}
	public void setDutyArea(String dutyArea) {
		this.dutyArea = dutyArea;
	}
	public String getDutyZone() {
		return dutyZone;
	}
	public void setDutyZone(String dutyZone) {
		this.dutyZone = dutyZone;
	}
	public String getDutyGroup() {
		return dutyGroup;
	}
	public void setDutyGroup(String dutyGroup) {
		this.dutyGroup = dutyGroup;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
