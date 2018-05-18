package com.golden.ihome.addr.model;

import java.io.Serializable;

import com.golden.ihome.common.CommonConst;

/**
 * @author lb
 * 类名称：社区表
 * 类描述：社区表
 * 时间：2016-9-27
 */
public class CommunityModel implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
    private Integer id;
    /**
	 * 数据量
	 */
    private Integer conunt;
    /**
	 * 行政编码
	 */
    private String areaCode;
    /**
     * 社区名称
     */
    private String name;
    /**
     * 街道ID
     */
    private Integer subdistrictId;
    /**
     * 表中行政等级 4
     */
    private String areaLevel;
    
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
    

	public Integer getConunt() {
		return conunt;
	}

	public void setConunt(Integer conunt) {
		this.conunt = conunt;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

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

	public String getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getSubdistrictId() {
		return subdistrictId;
	}

	public void setSubdistrictId(Integer subdistrictId) {
		this.subdistrictId = subdistrictId;
	}

}