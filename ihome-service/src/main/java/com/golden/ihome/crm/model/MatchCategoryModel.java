package com.golden.ihome.crm.model;

import java.util.Date;

public class MatchCategoryModel {
    private Double id;

    private String name;

    private String status;

    private String createUser;

    private Date createTime;

    private String layer;

    private Short sort;

    private String remark;
    
    private String createTimeFormat;
    
    private String createUserId;

    public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
	public String getCreateTimeFormat() {
		return createTimeFormat;
	}
	public void setCreateTimeFormat(String createTimeFormat) {
		this.createTimeFormat = createTimeFormat;
	}
	
}