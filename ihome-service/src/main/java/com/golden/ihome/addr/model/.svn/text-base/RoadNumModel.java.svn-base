package com.golden.ihome.addr.model;

import java.io.Serializable;

import com.golden.ihome.common.CommonConst;

/**
 * @author lb
 * 类名称：道路号
 * 类描述：道路号实体
 * 时间：2016-10-17
 */
public class RoadNumModel implements Serializable{

	private static final long serialVersionUID = 5793754393549155649L;
	
	private Integer id;//道路号ID
	private String  roadName;//道路名称
	private Integer areaId;//区域ID
	private Integer roadNum;//道路号
	private Integer status;//1：使用 2：删除
	private String statusStr;//1：使用 2：删除
	private Integer roadId;//道路ID
	private String name;//区域名字
	private String uniteId;
	
	public String getUniteId() {
		return uniteId;
	}
	public void setUniteId(String uniteId) {
		this.uniteId = uniteId;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
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
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getRoadNum() {
		return roadNum;
	}
	public void setRoadNum(Integer roadNum) {
		this.roadNum = roadNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
		this.statusStr=CommonConst.getUseStatus(status);
	}
	public Integer getRoadId() {
		return roadId;
	}
	public void setRoadId(Integer roadId) {
		this.roadId = roadId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
