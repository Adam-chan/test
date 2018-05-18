package com.golden.ihome.addr.model;

import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.common.CommonConst;
import com.golden.ihome.utils.DateUtil;

public class RoadLogModel implements Serializable{

	private static final long serialVersionUID = 5793754393549155649L;
	
	private Integer id;
	private Integer roadId;//道路ID
	private Integer startNum;//起始号
	private Integer endNum;//结束号
	private Integer creatType;//生成号段的规则  1：单号撒号   2：双号撒号   3：连续撒号
	private String creatTypeStr;//生成号段的规则  1：单号撒号   2：双号撒号   3：连续撒号
	private Integer status;//1：使用 2：删除
	private String statusStr;//1：使用 2：删除
	private String ignoreNum;//忽略号段
	private String operator;//操作员
	private Date operTime;//操作时间
	private String operTimeStr;//操作时间
	private Integer areaId;//区域ID
	private String areaName;
	private String roadName;
	private Integer numbers;
	private Integer count;//查询条数
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getIgnoreNum() {
		return ignoreNum;
	}
	public void setIgnoreNum(String ignoreNum) {
		this.ignoreNum = ignoreNum;
	}
	public String getOperTimeStr() {
		return operTimeStr;
	}
	public void setOperTimeStr(String operTimeStr) {
		this.operTimeStr = operTimeStr;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperTime() {
		return operTime;
	}
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
		this.operTimeStr=DateUtil.getStringByDate(operTime, "yyyy/MM/dd HH:mm");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoadId() {
		return roadId;
	}
	public void setRoadId(Integer roadId) {
		this.roadId = roadId;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getEndNum() {
		return endNum;
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	public Integer getCreatType() {
		return creatType;
	}
	public void setCreatType(Integer creatType) {
		this.creatType = creatType;
		this.creatTypeStr=CommonConst.getRoadNumType(creatType);
	}
	public String getCreatTypeStr() {
		return creatTypeStr;
	}
	public void setCreatTypeStr(String creatTypeStr) {
		this.creatTypeStr = creatTypeStr;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
		this.statusStr=CommonConst.getLogUseStatus(status);
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
