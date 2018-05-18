package com.golden.ihome.addr.model;

import java.util.Date;

/**
 * @author chenqian 
 * 类名称：户型信息
 * 类描述：户型信息表
 * 时间：2016-10-17
 */
public class LayoutModel {
	/**
	 * 主键id
	 */
    private Integer id;
    /**
     * 单元id
     */
    private Integer unitsId;
    /**
     * 楼盘id
     */
    private Integer premisesId;
    /**
     * 户型名称
     */
    private String layoutName;
    /**
     * 室
     */
    private Integer room;
    /**
     * 厅
     */
    private Integer office;
    /**
     * 卫
     */
    private Integer wc;
    /**
     * 厨
     */
    private Integer balcony;
    /**
     * 建筑面积
     */
    private Double coveredArea;
    /**
     * 使用面积
     */
    private Double usedArea;
    /**
     * 单价
     */
    private Double unitPrice;
    /**
     * 总价
     */
    private Double totalPrice;
    /**
     * 朝向
     */
    private String orientation;
    /**
     * 图片文件夹
     */
    private String folderName;
    /**
     * 图片名称
     */
    private String fileName;
    /**
     * 上传时间
     */
    private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(Integer unitsId) {
		this.unitsId = unitsId;
	}

	public Integer getPremisesId() {
		return premisesId;
	}

	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Integer getOffice() {
		return office;
	}

	public void setOffice(Integer office) {
		this.office = office;
	}

	public Integer getWc() {
		return wc;
	}

	public void setWc(Integer wc) {
		this.wc = wc;
	}

	public Integer getBalcony() {
		return balcony;
	}

	public void setBalcony(Integer balcony) {
		this.balcony = balcony;
	}

	public Double getCoveredArea() {
		return coveredArea;
	}

	public void setCoveredArea(Double coveredArea) {
		this.coveredArea = coveredArea;
	}

	public Double getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(Double usedArea) {
		this.usedArea = usedArea;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    
}