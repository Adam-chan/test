package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.sql.Date;


/**
 * 房源收藏 sy
 * 
 * @author 
 * 
 */
public class HouseCollectModel implements Serializable{

	private static final long serialVersionUID = -8432352547788115767L;
	
	private Integer id;//id序列
	private Integer houseInfoId;//房源ID
	private Integer saleInfoId;//买卖表房源id
	private Integer leaseInfoId;//租赁表房源id
	private String houseCode;//房源编号
	private Integer demandType;//业务类型
	private Integer useType;//使用类别
	private Integer houseLevel;//房源等级
	private Double sellPrice;//售价
	private Integer unitPrice;//单价
	private Double leasePrice;//租价
	private String premisesId;//楼盘id
	private String premisesName;//楼盘名称
	private Integer rooms;//室
	private Integer office;//厅
	private Integer kitchen;//厨
	private Integer wc;//卫
	private String floor;//楼层
	private Double coveredArea;//建筑面积
	private Integer chaoXiang;//朝向1东，2南，3西，4北
	private Date createTime;// 创建时间
	private String prospectCount;//实勘数量
	private String keyCount;//钥匙数量
	private String timeLimitCount;//限时速递数量
	private String watchHouseCount;//看房次数
	private String operator;//经济人
	private String operateUserId;//经济人Id
	private String divideQu;//所属区
	private String divideQuCode;//所属区编号
	private String divideOrg;//所属组
	private String divideOrgCode;//所属组编号
	private String divideUser;//所属人
	private String divideUserId;//所属人Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Integer getSaleInfoId() {
		return saleInfoId;
	}
	public void setSaleInfoId(Integer saleInfoId) {
		this.saleInfoId = saleInfoId;
	}
	public Integer getLeaseInfoId() {
		return leaseInfoId;
	}
	public void setLeaseInfoId(Integer leaseInfoId) {
		this.leaseInfoId = leaseInfoId;
	}
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public Integer getDemandType() {
		return demandType;
	}
	public void setDemandType(Integer demandType) {
		this.demandType = demandType;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	public Integer getHouseLevel() {
		return houseLevel;
	}
	public void setHouseLevel(Integer houseLevel) {
		this.houseLevel = houseLevel;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getLeasePrice() {
		return leasePrice;
	}
	public void setLeasePrice(Double leasePrice) {
		this.leasePrice = leasePrice;
	}
	public String getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(String premisesId) {
		this.premisesId = premisesId;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	public Integer getRooms() {
		return rooms;
	}
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	public Integer getOffice() {
		return office;
	}
	public void setOffice(Integer office) {
		this.office = office;
	}
	public Integer getKitchen() {
		return kitchen;
	}
	public void setKitchen(Integer kitchen) {
		this.kitchen = kitchen;
	}
	public Integer getWc() {
		return wc;
	}
	public void setWc(Integer wc) {
		this.wc = wc;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public Double getCoveredArea() {
		return coveredArea;
	}
	public void setCoveredArea(Double coveredArea) {
		this.coveredArea = coveredArea;
	}
	public Integer getChaoXiang() {
		return chaoXiang;
	}
	public void setChaoXiang(Integer chaoXiang) {
		this.chaoXiang = chaoXiang;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getProspectCount() {
		return prospectCount;
	}
	public void setProspectCount(String prospectCount) {
		this.prospectCount = prospectCount;
	}
	public String getKeyCount() {
		return keyCount;
	}
	public void setKeyCount(String keyCount) {
		this.keyCount = keyCount;
	}
	public String getTimeLimitCount() {
		return timeLimitCount;
	}
	public void setTimeLimitCount(String timeLimitCount) {
		this.timeLimitCount = timeLimitCount;
	}
	public String getWatchHouseCount() {
		return watchHouseCount;
	}
	public void setWatchHouseCount(String watchHouseCount) {
		this.watchHouseCount = watchHouseCount;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperateUserId() {
		return operateUserId;
	}
	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}
	public String getDivideQu() {
		return divideQu;
	}
	public void setDivideQu(String divideQu) {
		this.divideQu = divideQu;
	}
	public String getDivideQuCode() {
		return divideQuCode;
	}
	public void setDivideQuCode(String divideQuCode) {
		this.divideQuCode = divideQuCode;
	}
	public String getDivideOrg() {
		return divideOrg;
	}
	public void setDivideOrg(String divideOrg) {
		this.divideOrg = divideOrg;
	}
	public String getDivideOrgCode() {
		return divideOrgCode;
	}
	public void setDivideOrgCode(String divideOrgCode) {
		this.divideOrgCode = divideOrgCode;
	}
	public String getDivideUser() {
		return divideUser;
	}
	public void setDivideUser(String divideUser) {
		this.divideUser = divideUser;
	}
	public String getDivideUserId() {
		return divideUserId;
	}
	public void setDivideUserId(String divideUserId) {
		this.divideUserId = divideUserId;
	}
}
