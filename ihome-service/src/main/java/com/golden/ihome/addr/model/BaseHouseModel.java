package com.golden.ihome.addr.model;

import com.golden.ihome.common.HouseCommon;

/**
 * 
 * @author lza
 * 类名称：房间管理类
 * 类描述：房间管理类
 * 时间：2016-10-18
 */
public class BaseHouseModel {
	/**
	 * 主键id
	 */
    private Integer id;
    /**
	 * 房间名称
	 */
    private String houseName;
    /**
	 * 创建时间
	 */
    private String createTime;
    /**
	 * 单元id
	 */
    private Integer unitId;
    /**
	 * 更新时间
	 */
    private String updateTime;
    /**
	 * 楼层
	 */
    private Integer num;
    /**
	 * 状态1正常，2删除
	 */
    private Short status;

    /**
	 * 朝向
	 */
    private String orientation;
    /**
	 * 建筑面积
	 */
    private Integer coveredArea;
    /**
	 * 户型（几梯几户）
	 */
    private String houseType;
    /**
	 * 装修情况(1已装修，2未装修)
	 */
    private Integer decoration;
    private String decorationName;
    /**
	 * 使用面积
	 */
    private Integer useLand;
    /**
	 * 单元编号
	 */
    private String unitCode;
    /**
     * 楼盘id
     */
    private Integer premisesId;
    /**
     * 楼盘分组id
     */
    private Integer groupId;
    /**
     *楼栋id
     */
    private Integer buildingId;
    /**
     * 房屋用途（1住宅2商住两用3商铺）
     */
    private Integer purpose;
    
    private String purposeName;
    /**
     *房屋性质：1已购公房 2 商品房 3 空置房 4 使用权房 5经济使用房 
     */
    private Integer houseNature;
    private String houseNatureName;
    /**
     * 土地使用年限：1.70年2.60年3.50年4.40年
     */
    private Integer landLimit;
    private String landLimitName;
    /**
     * 业主姓名
     */
    private String proprietor;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 产权变更装填由有房屋性质5触发 （1已变更2位变更）
     */
    private Integer propertyStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public Integer getCoveredArea() {
		return coveredArea;
	}
	public void setCoveredArea(Integer coveredArea) {
		this.coveredArea = coveredArea;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public Integer getDecoration() {
		return decoration;
	}
	public void setDecoration(Integer decoration) {
		this.decoration = decoration;
	}
	public Integer getUseLand() {
		return useLand;
	}
	public void setUseLand(Integer useLand) {
		this.useLand = useLand;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public Integer getPurpose() {
		return purpose;
	}
	public void setPurpose(Integer purpose) {
		this.purpose = purpose;
	}
	public Integer getHouseNature() {
		return houseNature;
	}
	public void setHouseNature(Integer houseNature) {
		this.houseNature = houseNature;
	}
	public Integer getLandLimit() {
		return landLimit;
	}
	public void setLandLimit(Integer landLimit) {
		this.landLimit = landLimit;
	}
	public String getProprietor() {
		return proprietor;
	}
	public void setProprietor(String proprietor) {
		this.proprietor = proprietor;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public Integer getPropertyStatus() {
		return propertyStatus;
	}
	public void setPropertyStatus(Integer propertyStatus) {
		this.propertyStatus = propertyStatus;
	}
	public String getPurposeName() {
		if(this.purpose!=null){
			this.purposeName = HouseCommon.getUseTypeStr(this.purpose);
		}else{
			this.purposeName = "";
		}
		return purposeName;
	}
	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}
	public String getDecorationName() {
		if(this.decoration!=null){
			this.decorationName = HouseCommon.getDecoradionStr(this.decoration);
		}else{
			this.decorationName = "";
		}
		return decorationName;
	}
	public void setDecorationName(String decorationName) {
		this.decorationName = decorationName;
	}
	public String getHouseNatureName() {
		if(this.houseNature!=null){
			this.houseNatureName=HouseCommon.getPropertyStr(this.houseNature);
		}else{
			this.houseNatureName = "";
		}
		return houseNatureName;
	}
	public void setHouseNatureName(String houseNatureName) {
		this.houseNatureName = houseNatureName;
	}
	public String getLandLimitName() {
	 	if(this.landLimit!=null){
			return HouseCommon.getLandLimitNames(this.landLimit);
		}
		return "";
	}
	public void setLandLimitName(String landLimitName) {
		this.landLimitName = landLimitName;
	}
    

}