package com.golden.ihome.addr.model;

import com.golden.ihome.common.CommonConst;

/**
 * @author lza 
 * 类名称：行政区域表
 * 类描述：行政区域表
 * 时间：2016-9-27
 */
public class BaseAreaModel {
	/**
	 * 主键id
	 */
    private Integer id;
    /**
     * 行政编码
     */
    private String areaCode;
    /**
     * 父id
     */
    private Long pid;
    /**
     * 简称
     */
    private String shortName;
    /**
     * 名称
     */
    private String name;
    /**
     * 全称（省,市,区/县）
     */
    private String mergerName;
    /**
     * 行政级别
     */
    private Short areaLevel;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     *座机区号
     */
    private String telCode;
    /**
     * 邮政编码
     */
    private String zipCode;
    /**
     * 首字母
     */
    private String fristChar;
    /**
     * 精度
     */
    private String lng;
    /**
     * 维度
     */
    private String lat;
    
    /**
     * 是否对外网显示 1;显示 2：不显示
     */
    private Integer showStatus;
    /**
     * 是否对外网显示 1;显示 2：不显示 文本
     */
    private String showStatusStr;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String  remark;
    /**
     * 1:使用中 2：删除中
     */
    private Integer status;
    public String getShowStatusStr() {
		return showStatusStr;
	}

	public void setShowStatusStr(String showStatusStr) {
		this.showStatusStr = showStatusStr;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
		this.showStatusStr=CommonConst.getShowStatus(showStatus);
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName == null ? null : mergerName.trim();
    }

    public Short getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Short areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getTelCode() {
        return telCode;
    }

    public void setTelCode(String telCode) {
        this.telCode = telCode == null ? null : telCode.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getFristChar() {
        return fristChar;
    }

    public void setFristChar(String fristChar) {
        this.fristChar = fristChar == null ? null : fristChar.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }
}