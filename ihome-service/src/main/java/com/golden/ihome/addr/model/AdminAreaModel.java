package com.golden.ihome.addr.model;
/**
 * @author lza
 * 类名称：行政区类
 * 类描述：行政区管理类
 * 时间：2016-9-28
 */
public class AdminAreaModel {
    /**
     * 行政区id
     */
    private Integer adminId;
    /**
     * 全称（省,市,区/县）
     */
    private String  mergerName;
   /**
    * 区
    */
	private String name;
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getMergerName() {
		return mergerName;
	}
	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
    
}
