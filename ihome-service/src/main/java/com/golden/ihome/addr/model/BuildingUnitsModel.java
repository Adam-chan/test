package com.golden.ihome.addr.model;
/**

 * @author lza
 * 类名称：单元实体类
 * 类描述：单元管理实体
 * 时间：2016-10-17
 */
public class BuildingUnitsModel {
    /**
     * 主键id 
     */
    private Long id;
    /**
     * 楼栋ID
     */
    private Long buildingId;
    /**
     * 单元编号
     */
    private String code;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 后缀
     */
    private String suffix;
    /**
     * 房间总数
     */
    private Short roomTotal;
    /**
     * 忽略房间号（1,2,3）
     */
    private String roomIgnore;
    /**
     * 楼梯数（几梯）
     */
    private Short ladders;
    /**
     * 电梯数
     */
    private Short elevator;
    /**
     * 一梯几户
     */  
    private Short flats;
    /**
     * 楼层数
     */
    private Short floors;
    /**
     * 地上楼层数
     */
    private Short upFloors;
    /**
	 * 地下楼层数
	 */
    private String underFloors;
    /**
     * 号段起始
     */
    private String numStart;
    /**
     * 号段终止
     */
    private String numEnd;
    /**
     * 生成规则（1单层排序2整层排序3楼层0部位4房号0部位，5加楼号6加-链接）
     */
    private Integer generative_rule;
    /**
     * 房屋用途（1住宅2商住两用3商铺）
     */
    private Integer purpose;
    /**
     *房屋性质：1已购公房 2 商品房 3 空置房 4 使用权房 5经济使用房 
     */
    private Integer houseNature;
    /**
     * 土地使用年限：1.70年2.60年3.50年4.40年
     */
    private Integer landLimit;
    /**
   	 * 建筑年代
   	 */
    private Short buildingYear;
    /**
	 * 建筑类型?
	 */
    private Short buildingType;
    /**
	 * 建筑结构?
	 */
    private Short buildingConst;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseId() {
        return buildingId;
    }

    public void setHouseId(Long houseId) {
        this.buildingId = houseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public Short getRoomTotal() {
        return roomTotal;
    }

    public void setRoomTotal(Short roomTotal) {
        this.roomTotal = roomTotal;
    }

    public String getRoomIgnore() {
        return roomIgnore;
    }

    public void setRoomIgnore(String roomIgnore) {
        this.roomIgnore = roomIgnore == null ? null : roomIgnore.trim();
    }

    public Short getLadders() {
        return ladders;
    }

    public void setLadders(Short ladders) {
        this.ladders = ladders;
    }

    public Short getElevator() {
        return elevator;
    }

    public void setElevator(Short elevator) {
        this.elevator = elevator;
    }

    public Short getFlats() {
        return flats;
    }

    public void setFlats(Short flats) {
        this.flats = flats;
    }

    public Short getFloors() {
        return floors;
    }

    public void setFloors(Short floors) {
        this.floors = floors;
    }

    public Short getUpFloors() {
        return upFloors;
    }

    public void setUpFloors(Short upFloors) {
        this.upFloors = upFloors;
    }

    public String getUnderFloors() {
        return underFloors;
    }

    public void setUnderFloors(String underFloors) {
        this.underFloors = underFloors == null ? null : underFloors.trim();
    }

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

	public Integer getGenerative_rule() {
		return generative_rule;
	}

	public void setGenerative_rule(Integer generative_rule) {
		this.generative_rule = generative_rule;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
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

	public Short getBuildingYear() {
		return buildingYear;
	}

	public void setBuildingYear(Short buildingYear) {
		this.buildingYear = buildingYear;
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
    
}