package com.golden.ihome.addr.model;

import java.io.Serializable;

import com.golden.ihome.common.CommonConst;

public class EduFacilityModel implements Serializable{

	private static final long serialVersionUID = 5793754393549155649L;
	
	private Integer id;
	private String eduName;//教育机构名字
	private Integer eduType;//教育机构类型 1：幼儿园 2：小学 3：中学 4：大学 5：图书馆 6：培训机构  7:少年宫 
	private String eduTypeStr;
	private String roadId;//教育机构地址-道路ID
	private String eduPhone;//教育机构电话
	private String eduIntroduce;//教育机构介绍
	private String enrollScope;//招生范围
	private String enterCondition;//入学条件
	private String lng;//经度
	private String lat;//纬度
	private String counterpartsPrimary;//对口小学
	private String counterpartsMiddle;//对口中学
	private String allEduName;
	//物化视图
	private String addrDetail;//详细地址
	private Integer areaId;//区域ID
	private String areaName;//区域名称
	
	public String getCounterpartsPrimary() {
		return counterpartsPrimary;
	}
	public void setCounterpartsPrimary(String counterpartsPrimary) {
		this.counterpartsPrimary = counterpartsPrimary;
	}
	public String getCounterpartsMiddle() {
		return counterpartsMiddle;
	}
	public void setCounterpartsMiddle(String counterpartsMiddle) {
		this.counterpartsMiddle = counterpartsMiddle;
	}
	public String getAllEduName() {
		return allEduName;
	}
	public void setAllEduName(String allEduName) {
		this.allEduName = allEduName;
	}
	public String getEduName() {
		return eduName;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	public String getEduIntroduce() {
		return eduIntroduce;
	}
	public void setEduIntroduce(String eduIntroduce) {
		this.eduIntroduce = eduIntroduce;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
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
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getEduTypeStr() {
		return eduTypeStr;
	}
	public void setEduTypeStr(String eduTypeStr) {
		this.eduTypeStr = eduTypeStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEduType() {
		return eduType;
	}
	public void setEduType(Integer eduType) {
		this.eduType = eduType;
		this.eduTypeStr = CommonConst.getEduType(eduType);
	}
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	public String getEduPhone() {
		return eduPhone;
	}
	public void setEduPhone(String eduPhone) {
		this.eduPhone = eduPhone;
	}
	public String getEnrollScope() {
		return enrollScope;
	}
	public void setEnrollScope(String enrollScope) {
		this.enrollScope = enrollScope;
	}
	public String getEnterCondition() {
		return enterCondition;
	}
	public void setEnterCondition(String enterCondition) {
		this.enterCondition = enterCondition;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
