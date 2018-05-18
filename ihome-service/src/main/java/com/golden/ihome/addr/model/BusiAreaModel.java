package com.golden.ihome.addr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lza 
 * 类名称：商圈管理业务表
 * 类描述：商圈管理业务表
 * 时间：2016-9-27
 */
public class BusiAreaModel implements Serializable{
	
	private static final long serialVersionUID = 4124776494448799696L;
	
	// BUSI_AREA表 Start
	 
	/**
	 * 商圈id
	 */
    private Integer id;
    /**
     * 商圈名称
     */
    private String busiAreaName;
    /**
     *区划id
     */
    private Integer busiZoningId;
    /**
     * 区划名称
     */
    private String busiZoningName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 楼盘数
     */
    private Integer hoursNum;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 备注
     */
    private String remark;
    /**
     * 统计 大商圈下的小商圈数量
     */
    private Integer statistics;
   
    //BUSI_AREA表 End
    
    // BASE_AREA表 Start
    
    /**
     * 行政区表父类id
     */
    private Integer pid;
    /**
     * 所属区
     */
    private String ItsArea;
    /**
     * 行政区
     */
    private String adminName;
    
    private Integer count;
    
    // BASE_AREA表 End

    //  BASE_AREA实体集合表 Start
    private List<AdminAreaModel> list = new ArrayList<AdminAreaModel>();
    //  BASE_AREA end
 




public Integer getId() {
	return id;
}

public Integer getCount() {
	return count;
}

public void setCount(Integer count) {
	this.count = count;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public void setId(Integer id) {
	this.id = id;
}

public String getBusiAreaName() {
	return busiAreaName;
}

public void setBusiAreaName(String busiAreaName) {
	this.busiAreaName = busiAreaName;
}

public Integer getBusiZoningId() {
	return busiZoningId;
}

public void setBusiZoningId(Integer busiZoningId) {
	this.busiZoningId = busiZoningId;
}

public String getBusiZoningName() {
	return busiZoningName;
}

public void setBusiZoningName(String busiZoningName) {
	this.busiZoningName = busiZoningName;
}

public Integer getSort() {
	return sort;
}

public void setSort(Integer sort) {
	this.sort = sort;
}


public String getRemark() {
	return remark;
}

public void setRemark(String remark) {
	this.remark = remark;
}

public Integer getStatistics() {
	return statistics;
}

public void setStatistics(Integer statistics) {
	this.statistics = statistics;
}

public Integer getHoursNum() {
	return hoursNum;
}

public void setHoursNum(Integer hoursNum) {
	this.hoursNum = hoursNum;
}

public String getLng() {
	return lng;
}

public void setLng(String lng) {
	this.lng = lng;
}

public String getLat() {
	return lat;
}

public void setLat(String lat) {
	this.lat = lat;
}

public Integer getPid() {
	return pid;
}

public void setPid(Integer pid) {
	this.pid = pid;
}

public String getItsArea() {
	return ItsArea;
}

public void setItsArea(String itsArea) {
	ItsArea = itsArea;
}

public String getAdminName() {
	return adminName;
}

public void setAdminName(String adminName) {
	this.adminName = adminName;
}

public List<AdminAreaModel> getList() {
	return list;
}

public void setList(List<AdminAreaModel> list) {
	this.list = list;
}
 
 
}