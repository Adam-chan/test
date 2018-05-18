package com.golden.ihome.addr.model;

import java.util.Date;
/**
 * 
 * @author lza
 * 类名称：楼栋实体类
 * 类描述：楼栋管理实体
 * 时间：2016-10-17
 */
public class BaseBuildingModel {
	/**
	 * 主键id
	 */
    private Integer id;
    
    /**
	 * 主键id
	 */
    private Integer unitId;
    
    /**
	 * 单元号
	 */
    private String code;
    
    /**
	 * 单元地上起始
	 */
    private String upFloors;
    
    /**
	 * 单元总层数
	 */
    private String floors;
    /**
     * 排序
     */
    private String sort;
    
    public String getUpFloors() {
		return upFloors;
	}

	public void setUpFloors(String upFloors) {
		this.upFloors = upFloors;
	}

	public String getFloors() {
		return floors;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 楼盘id
	 */
    private Integer premisesId;
    /**
	 * 楼盘分组的id
	 */
    private Integer buildingGroupId;
    /**
	 * 创建时间
	 */
    private Date createTime;
    /**
	 * 更新时间
	 */
    private Date updateTime;
    /**
	 * 楼栋名称
	 */
    private String buildingName;
    /**
	 * 楼栋编号
	 */
    private String buildingCode;
    /**
	 * 产权性质
	 */
    private Short propertyNature;
    /**
	 * 建筑类型?
	 */
    private Short buildingType;
    /**
	 * 建筑结构?
	 */
    private Short buildingConst;
    /**
	 * 建筑年代
	 */
    private Short buildingYear;
    /**
	 * 单元数
	 */
    private Short unitNum;
    /**
	 * 单元前缀
	 */
    private String unitPre;
    /**
	 * 单元后缀
	 */
    private String unitSuf;
    /**
	 * 单元编号类型1字母,2数字
	 */
    private String unitType;
    /**
	 * 楼栋地上楼层起
	 */
    private Short upFloorStart;
    /**
	 * 楼栋地上总层数
	 */
    private Short upFloorTotal;
    /**
	 * 楼栋地下层数
	 */
    private Short underFloors;
    /**
	 * 忽略楼层数(1,2,3)
	 */
    private String ignoreStairNum;
    /**
    * 房屋用途（1商用（有冷气费），2民用）
    */
    private Integer purpose;
    /**
     * 号段起始
     */
    private String numStart;
    public String getNumStart() {
		return numStart;
	}

	public void setNumStart(String numStart) {
		this.numStart = numStart;
	}

	public String getNumEnd() {
		return numEnd;
	}

	public void setNumEnd(String numEnd) {
		this.numEnd = numEnd;
	}

	/**
     * 号段终止
     */
    private String numEnd;
    /**
     *物业费或清洁费（1物业2清洁）
     */
    private Integer costType;
    /**
     * 冷气费
     */
    private Integer coolCost;
    /**
     * 物业费或清洁费
     */
    private Integer propertyFee;
    /**
     *教育设施
     */
    private Integer areaId;
    /**
     * 行政区
     */
    private Integer eduId;
    /**
     * 土地使用年限
     */
    private Integer	landLimit;
    
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 后缀
     */
    private String suffix;
    
    /**
     * 忽略房间号（1,2,3）
     */
    private String roomIgnore;
    
    /**
     * 楼梯数（几梯）
     */
    private Short ladders;
    
    /**
     * 一梯几户
     */  
    private Short flats;
    
    /**
     * 号段起始
     */
    private String roomNumStart;
    /**
     * 号段终止
     */
    private String roomNumEnd;
    
    /**
     * 生成规则（1单层排序2整层排序3楼层0部位4房号0部位，5加楼号6加-链接）
     */
    private Integer generativeRule;
    
    public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getRoomIgnore() {
		return roomIgnore;
	}

	public void setRoomIgnore(String roomIgnore) {
		this.roomIgnore = roomIgnore;
	}

	public Short getLadders() {
		return ladders;
	}

	public void setLadders(Short ladders) {
		this.ladders = ladders;
	}

	public Short getFlats() {
		return flats;
	}

	public void setFlats(Short flats) {
		this.flats = flats;
	}

	public String getRoomNumEnd() {
		return roomNumEnd;
	}

	public void setRoomNumEnd(String roomNumEnd) {
		this.roomNumEnd = roomNumEnd;
	}



	public String getRoomNumStart() {
		return roomNumStart;
	}

	public void setRoomNumStart(String roomNumStart) {
		this.roomNumStart = roomNumStart;
	}

	public Integer getGenerativeRule() {
		return generativeRule;
	}

	public void setGenerativeRule(Integer generativeRule) {
		this.generativeRule = generativeRule;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPremisesId() {
        return premisesId;
    }

    public void setPremisesId(Integer premisesId) {
        this.premisesId = premisesId;
    }

    public Integer getBuildingGroupId() {
		return buildingGroupId;
	}

	public void setBuildingGroupId(Integer buildingGroupId) {
		this.buildingGroupId = buildingGroupId;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode == null ? null : buildingCode.trim();
    }

    public Short getPropertyNature() {
        return propertyNature;
    }

    public void setPropertyNature(Short propertyNature) {
        this.propertyNature = propertyNature;
    }

    public Short getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(Short buildingType) {
        this.buildingType = buildingType;
    }

    public Short getBuildingConst() {
        return buildingConst;
    }

    public void setBuildingConst(Short buildingConst) {
        this.buildingConst = buildingConst;
    }

    public Short getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(Short buildingYear) {
        this.buildingYear = buildingYear;
    }

    public Short getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Short unitNum) {
        this.unitNum = unitNum;
    }

    public String getUnitPre() {
        return unitPre;
    }

    public void setUnitPre(String unitPre) {
        this.unitPre = unitPre == null ? null : unitPre.trim();
    }

    public String getUnitSuf() {
        return unitSuf;
    }

    public void setUnitSuf(String unitSuf) {
        this.unitSuf = unitSuf == null ? null : unitSuf.trim();
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public Short getUpFloorStart() {
        return upFloorStart;
    }

    public void setUpFloorStart(Short upFloorStart) {
        this.upFloorStart = upFloorStart;
    }

    public Short getUpFloorTotal() {
        return upFloorTotal;
    }

    public void setUpFloorTotal(Short upFloorTotal) {
        this.upFloorTotal = upFloorTotal;
    }

    public Short getUnderFloors() {
        return underFloors;
    }

    public void setUnderFloors(Short underFloors) {
        this.underFloors = underFloors;
    }

    public String getIgnoreStairNum() {
        return ignoreStairNum;
    }

    public void setIgnoreStairNum(String ignoreStairNum) {
        this.ignoreStairNum = ignoreStairNum == null ? null : ignoreStairNum.trim();
    }

	public Integer getPurpose() {
		return purpose;
	}

	public void setPurpose(Integer purpose) {
		this.purpose = purpose;
	}

	public Integer getCostType() {
		return costType;
	}

	public void setCostType(Integer costType) {
		this.costType = costType;
	}

	public Integer getCoolCost() {
		return coolCost;
	}

	public void setCoolCost(Integer coolCost) {
		this.coolCost = coolCost;
	}

	public Integer getPropertyFee() {
		return propertyFee;
	}

	public void setPropertyFee(Integer propertyFee) {
		this.propertyFee = propertyFee;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getEduId() {
		return eduId;
	}

	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}

	public Integer getLandLimit() {
		return landLimit;
	}

	public void setLandLimit(Integer landLimit) {
		this.landLimit = landLimit;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	
	
}