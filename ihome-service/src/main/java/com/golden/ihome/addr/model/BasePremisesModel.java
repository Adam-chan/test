package com.golden.ihome.addr.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * @author Administrator
 * 类名称：楼盘管理
 * 类描述：楼盘管理
 * 时间：2016-10-18
 */
public class BasePremisesModel implements Serializable{

	private static final long serialVersionUID = -1022318419236163905L;
	
	private Integer id;
	private Integer type;//楼盘类型 1：二手楼盘、2：一手楼盘、3：一手兼二手楼盘
	private Integer locked;//锁定(1：非锁定、2：锁定）
    private Integer hidden;//隐藏(1：显示、2：隐藏）
    private Integer saleSeal;//买卖封盘(1：未封盘、2：封盘）
    private Integer leaseSeal;//租赁封盘(1：未封盘、2：封盘）
    private Integer auditingStatus;//审核状态（1：待审核、2：已审核、3：拒绝）
    private String name;//楼盘名称
	private String alias;//楼盘别名
	private String roadId;//详细地址-道路
	private Integer roadNum;//详细地址-道路号（实体化视图道路号）
	private Integer busiAreaParentId;//商圈id
	private Integer busiAreaId;//商圈id
    private Integer subdistrictId;//街道id
    private Integer communityId;//社区id
    private String alternateAddress;//备用地址
    private String buildingGroup;//楼栋分组
    private Integer buildingAge;//建筑年代
    private Integer housingPurposes;//房屋用途 (1：住宅、2：商业、3：商住两用)
    private Integer landUsageTerm;//土地使用权限 (1：70年、2：50年)
    private Integer buildingStructure;//建筑结构
    private Integer buildingType;//建筑类型
    private Integer housingProperty;//房屋性质 (1：已购公房、2：商品房、3：使用权房、4：经济适用房、5：空置房)
    private Double regionMeasure;//区域面积(㎡)
    private Double areaCovered;//占地面积(㎡)
    private Double overallFloorage;//总建筑面积(㎡)
    private Double plotRatio;//容积率
    private Double greeningRate;//绿化率
    private Integer parkingNum;//车位数
    private Integer maintenanceCategory;//小区维护类别 
    private Integer housingType;//房屋类型 (1：公寓、2：别墅、3：排屋)
    private Double startingAtPrice;//起价(元/㎡)
    private Double averagePrice;//均价(元/㎡)
    private Integer developer;//开发商
    private Integer builder;//建筑商
    private Integer agent;//代理商
    private Integer hasPropertyManagementCompany;//是否有物业公司(1：有、2：无)
    private String propertyManagementCompany;//物业公司
    private String companyAddress;//物业公司地址
    private Double propertyFee;//物业费(元/月/平)
    private Double cleaningFee;//清洁费(元/年)
    private String busStation;//公交站点(保存格式为1，2，3)
    private String subwayStation;//地铁站点(保存格式为1，2，3)
    private Integer level;//推荐星级
    private Integer agentType;//代理类型(1：全程代理)
    private Date salesStartDate;//销售开始时间
    private Date salesEndDate;//销售结束时间
    private Integer totalHouseholds;//总户数
    private Double commissionRate;//佣金比例
    private Long expectEarnings;//预计业绩
    private Integer tradedHouseholds;//已成交户数
    private String contacts;//联系人
    private String contactsPhone;//联系电话
    private String salesAddress;//售楼地址
    private String permitForPresale;//预售许可证
    private Integer houseType;//主力户型(1：3居、2：2居
    private Integer totalBuildings;//总幢数
    private Integer totalApartments;//总套数
    private Integer status;//状态(1：有效、2：无效)
    private Date openingTime;//开盘时间
    private Date checkInTime;//入住时间
    private String eduIds;//教育设施(保存格式为1，2，3)
    private String livingFacilities;//生活配套(保存格式为1，2，3)
    private String communitySafe;//社区安全(保存格式为1，2，3)
    private String hotSpotClassificationLease;//小区热点分类(租赁)
    private String hotSpotClassificationSales;//小区热点分类（买卖）
    private String premisesProfile;//小区简介
    private String farmProductMarket;//农贸市场
    private String supermarket;//商场超市
    private String entertainment;//餐饮娱乐
    private String bankParkHospital;//银行、公园、医院
    private String supportingFacilities;//配套设施
    private String remark;//备注
    private String mapRemark;
    //显示字段
    private String busiAreaName;//商圈名称
    private String busiAreaParentName;//大商圈名称
    private String subdistrictName;//街道名称
    private String communityName;//社区名称
    private String addrDetail;//详细地址
    private String salesStartDateFormat;
    private String residenceNum;//住宅栋数
    private String residenceUnits;//住宅单元数
    private String residenceRooms;//住宅户数
    private String residenceLease;//住宅房源租
    private String residenceSales;//住宅房源售
    private String businessNum;//商业栋数
    private String businessUnits;//商业单元数
    private String businessRooms;//商业户数
    private String businessLease;//商业房源租
    private String businessSales;//商业房源售
    private String areaId;//区域id
    private String areaName;//区域名称
    private String responsibilityZone;//责任区
    private String physicalStore;//实体店
    private String responsibilityGroup;//责任组
    private String responsibilityPerson;//责任人
    //楼盘审核显示字段
    private Integer completeStatus;//完整度状态（1：已审核、2：待审核、3：拒绝）
    private Integer dataStatus;//数据准确审核（1：已审核、2：待审核、3：拒绝）
    private Date operateTime;//登记时间
    private String operateUser;//申请人
    private String operateUserId;//申请人ID
    private String examineUser;//审核人
    private String examineUserId;//审核人ID
    private String lat;//纬度
    private String lng;//经度
    
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public Integer getHidden() {
		return hidden;
	}
	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}
	public Integer getSaleSeal() {
		return saleSeal;
	}
	public void setSaleSeal(Integer saleSeal) {
		this.saleSeal = saleSeal;
	}
	public Integer getLeaseSeal() {
		return leaseSeal;
	}
	public void setLeaseSeal(Integer leaseSeal) {
		this.leaseSeal = leaseSeal;
	}
	public Integer getAuditingStatus() {
		return auditingStatus;
	}
	public void setAuditingStatus(Integer auditingStatus) {
		this.auditingStatus = auditingStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	public Integer getRoadNum() {
		return roadNum;
	}
	public void setRoadNum(Integer roadNum) {
		this.roadNum = roadNum;
	}
	public Integer getBusiAreaParentId() {
		return busiAreaParentId;
	}
	public void setBusiAreaParentId(Integer busiAreaParentId) {
		this.busiAreaParentId = busiAreaParentId;
	}
	public Integer getBusiAreaId() {
		return busiAreaId;
	}
	public void setBusiAreaId(Integer busiAreaId) {
		this.busiAreaId = busiAreaId;
	}
	public Integer getSubdistrictId() {
		return subdistrictId;
	}
	public void setSubdistrictId(Integer subdistrictId) {
		this.subdistrictId = subdistrictId;
	}
	public Integer getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	public String getAlternateAddress() {
		return alternateAddress;
	}
	public void setAlternateAddress(String alternateAddress) {
		this.alternateAddress = alternateAddress;
	}
	public String getBuildingGroup() {
		return buildingGroup;
	}
	public void setBuildingGroup(String buildingGroup) {
		this.buildingGroup = buildingGroup;
	}
	public Integer getBuildingAge() {
		return buildingAge;
	}
	public void setBuildingAge(Integer buildingAge) {
		this.buildingAge = buildingAge;
	}
	public Integer getHousingPurposes() {
		return housingPurposes;
	}
	public void setHousingPurposes(Integer housingPurposes) {
		this.housingPurposes = housingPurposes;
	}
	public Integer getLandUsageTerm() {
		return landUsageTerm;
	}
	public void setLandUsageTerm(Integer landUsageTerm) {
		this.landUsageTerm = landUsageTerm;
	}
	public Integer getBuildingStructure() {
		return buildingStructure;
	}
	public void setBuildingStructure(Integer buildingStructure) {
		this.buildingStructure = buildingStructure;
	}
	public Integer getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(Integer buildingType) {
		this.buildingType = buildingType;
	}
	public Integer getHousingProperty() {
		return housingProperty;
	}
	public void setHousingProperty(Integer housingProperty) {
		this.housingProperty = housingProperty;
	}
	public Double getRegionMeasure() {
		return regionMeasure;
	}
	public void setRegionMeasure(Double regionMeasure) {
		this.regionMeasure = regionMeasure;
	}
	public Double getAreaCovered() {
		return areaCovered;
	}
	public void setAreaCovered(Double areaCovered) {
		this.areaCovered = areaCovered;
	}
	public Double getOverallFloorage() {
		return overallFloorage;
	}
	public void setOverallFloorage(Double overallFloorage) {
		this.overallFloorage = overallFloorage;
	}
	public Double getPlotRatio() {
		return plotRatio;
	}
	public void setPlotRatio(Double plotRatio) {
		this.plotRatio = plotRatio;
	}
	public Double getGreeningRate() {
		return greeningRate;
	}
	public void setGreeningRate(Double greeningRate) {
		this.greeningRate = greeningRate;
	}
	public Integer getParkingNum() {
		return parkingNum;
	}
	public void setParkingNum(Integer parkingNum) {
		this.parkingNum = parkingNum;
	}
	public Integer getMaintenanceCategory() {
		return maintenanceCategory;
	}
	public void setMaintenanceCategory(Integer maintenanceCategory) {
		this.maintenanceCategory = maintenanceCategory;
	}
	public Integer getHousingType() {
		return housingType;
	}
	public void setHousingType(Integer housingType) {
		this.housingType = housingType;
	}
	public Double getStartingAtPrice() {
		return startingAtPrice;
	}
	public void setStartingAtPrice(Double startingAtPrice) {
		this.startingAtPrice = startingAtPrice;
	}
	public Double getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}
	public Integer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Integer developer) {
		this.developer = developer;
	}
	public Integer getBuilder() {
		return builder;
	}
	public void setBuilder(Integer builder) {
		this.builder = builder;
	}
	public Integer getAgent() {
		return agent;
	}
	public void setAgent(Integer agent) {
		this.agent = agent;
	}
	public Integer getHasPropertyManagementCompany() {
		return hasPropertyManagementCompany;
	}
	public void setHasPropertyManagementCompany(Integer hasPropertyManagementCompany) {
		this.hasPropertyManagementCompany = hasPropertyManagementCompany;
	}
	public String getPropertyManagementCompany() {
		return propertyManagementCompany;
	}
	public void setPropertyManagementCompany(String propertyManagementCompany) {
		this.propertyManagementCompany = propertyManagementCompany;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public Double getPropertyFee() {
		return propertyFee;
	}
	public void setPropertyFee(Double propertyFee) {
		this.propertyFee = propertyFee;
	}
	public Double getCleaningFee() {
		return cleaningFee;
	}
	public void setCleaningFee(Double cleaningFee) {
		this.cleaningFee = cleaningFee;
	}
	public String getBusStation() {
		return busStation;
	}
	public void setBusStation(String busStation) {
		this.busStation = busStation;
	}
	public String getSubwayStation() {
		return subwayStation;
	}
	public void setSubwayStation(String subwayStation) {
		this.subwayStation = subwayStation;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getAgentType() {
		return agentType;
	}
	public void setAgentType(Integer agentType) {
		this.agentType = agentType;
	}
	public Date getSalesStartDate() {
		return salesStartDate;
	}
	public void setSalesStartDate(Date salesStartDate) {
		this.salesStartDate = salesStartDate;
	}
	public Date getSalesEndDate() {
		return salesEndDate;
	}
	public void setSalesEndDate(Date salesEndDate) {
		this.salesEndDate = salesEndDate;
	}
	public Integer getTotalHouseholds() {
		return totalHouseholds;
	}
	public void setTotalHouseholds(Integer totalHouseholds) {
		this.totalHouseholds = totalHouseholds;
	}
	public Double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(Double commissionRate) {
		this.commissionRate = commissionRate;
	}
	public Long getExpectEarnings() {
		return expectEarnings;
	}
	public void setExpectEarnings(Long expectEarnings) {
		this.expectEarnings = expectEarnings;
	}
	public Integer getTradedHouseholds() {
		return tradedHouseholds;
	}
	public void setTradedHouseholds(Integer tradedHouseholds) {
		this.tradedHouseholds = tradedHouseholds;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContactsPhone() {
		return contactsPhone;
	}
	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}
	public String getSalesAddress() {
		return salesAddress;
	}
	public void setSalesAddress(String salesAddress) {
		this.salesAddress = salesAddress;
	}
	public String getPermitForPresale() {
		return permitForPresale;
	}
	public void setPermitForPresale(String permitForPresale) {
		this.permitForPresale = permitForPresale;
	}
	public String getSupportingFacilities() {
		return supportingFacilities;
	}
	public void setSupportingFacilities(String supportingFacilities) {
		this.supportingFacilities = supportingFacilities;
	}
	public Integer getHouseType() {
		return houseType;
	}
	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}
	public Integer getTotalBuildings() {
		return totalBuildings;
	}
	public void setTotalBuildings(Integer totalBuildings) {
		this.totalBuildings = totalBuildings;
	}
	public Integer getTotalApartments() {
		return totalApartments;
	}
	public void setTotalApartments(Integer totalApartments) {
		this.totalApartments = totalApartments;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getEduIds() {
		return eduIds;
	}
	public void setEduIds(String eduIds) {
		this.eduIds = eduIds;
	}
	public String getLivingFacilities() {
		return livingFacilities;
	}
	public void setLivingFacilities(String livingFacilities) {
		this.livingFacilities = livingFacilities;
	}
	public String getCommunitySafe() {
		return communitySafe;
	}
	public void setCommunitySafe(String communitySafe) {
		this.communitySafe = communitySafe;
	}
	public String getHotSpotClassificationLease() {
		return hotSpotClassificationLease;
	}
	public void setHotSpotClassificationLease(String hotSpotClassificationLease) {
		this.hotSpotClassificationLease = hotSpotClassificationLease;
	}
	public String getHotSpotClassificationSales() {
		return hotSpotClassificationSales;
	}
	public void setHotSpotClassificationSales(String hotSpotClassificationSales) {
		this.hotSpotClassificationSales = hotSpotClassificationSales;
	}
	public String getPremisesProfile() {
		return premisesProfile;
	}
	public void setPremisesProfile(String premisesProfile) {
		this.premisesProfile = premisesProfile;
	}
	public String getFarmProductMarket() {
		return farmProductMarket;
	}
	public void setFarmProductMarket(String farmProductMarket) {
		this.farmProductMarket = farmProductMarket;
	}
	public String getSupermarket() {
		return supermarket;
	}
	public void setSupermarket(String supermarket) {
		this.supermarket = supermarket;
	}
	public String getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}
	public String getBankParkHospital() {
		return bankParkHospital;
	}
	public void setBankParkHospital(String bankParkHospital) {
		this.bankParkHospital = bankParkHospital;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMapRemark() {
		return mapRemark;
	}
	public void setMapRemark(String mapRemark) {
		this.mapRemark = mapRemark;
	}
	public String getBusiAreaName() {
		return busiAreaName;
	}
	public void setBusiAreaName(String busiAreaName) {
		this.busiAreaName = busiAreaName;
	}
	public String getSubdistrictName() {
		return subdistrictName;
	}
	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getSalesStartDateFormat() {
		return salesStartDateFormat;
	}
	public void setSalesStartDateFormat(String salesStartDateFormat) {
		this.salesStartDateFormat = salesStartDateFormat;
	}
	public String getResidenceNum() {
		return residenceNum;
	}
	public void setResidenceNum(String residenceNum) {
		this.residenceNum = residenceNum;
	}
	public String getResidenceUnits() {
		return residenceUnits;
	}
	public void setResidenceUnits(String residenceUnits) {
		this.residenceUnits = residenceUnits;
	}
	public String getResidenceRooms() {
		return residenceRooms;
	}
	public void setResidenceRooms(String residenceRooms) {
		this.residenceRooms = residenceRooms;
	}
	public String getResidenceLease() {
		return residenceLease;
	}
	public void setResidenceLease(String residenceLease) {
		this.residenceLease = residenceLease;
	}
	public String getResidenceSales() {
		return residenceSales;
	}
	public void setResidenceSales(String residenceSales) {
		this.residenceSales = residenceSales;
	}
	public String getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
	public String getBusinessUnits() {
		return businessUnits;
	}
	public void setBusinessUnits(String businessUnits) {
		this.businessUnits = businessUnits;
	}
	public String getBusinessRooms() {
		return businessRooms;
	}
	public void setBusinessRooms(String businessRooms) {
		this.businessRooms = businessRooms;
	}
	public String getBusinessLease() {
		return businessLease;
	}
	public void setBusinessLease(String businessLease) {
		this.businessLease = businessLease;
	}
	public String getBusinessSales() {
		return businessSales;
	}
	public void setBusinessSales(String businessSales) {
		this.businessSales = businessSales;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getResponsibilityZone() {
		return responsibilityZone;
	}
	public void setResponsibilityZone(String responsibilityZone) {
		this.responsibilityZone = responsibilityZone;
	}
	public String getPhysicalStore() {
		return physicalStore;
	}
	public void setPhysicalStore(String physicalStore) {
		this.physicalStore = physicalStore;
	}
	public String getResponsibilityGroup() {
		return responsibilityGroup;
	}
	public void setResponsibilityGroup(String responsibilityGroup) {
		this.responsibilityGroup = responsibilityGroup;
	}
	public String getResponsibilityPerson() {
		return responsibilityPerson;
	}
	public void setResponsibilityPerson(String responsibilityPerson) {
		this.responsibilityPerson = responsibilityPerson;
	}
	public Integer getCompleteStatus() {
		return completeStatus;
	}
	public void setCompleteStatus(Integer completeStatus) {
		this.completeStatus = completeStatus;
	}
	public Integer getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getExamineUser() {
		return examineUser;
	}
	public void setExamineUser(String examineUser) {
		this.examineUser = examineUser;
	}
	public String getBusiAreaParentName() {
		return busiAreaParentName;
	}
	public void setBusiAreaParentName(String busiAreaParentName) {
		this.busiAreaParentName = busiAreaParentName;
	}
	public String getOperateUserId() {
		return operateUserId;
	}
	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}
	public String getExamineUserId() {
		return examineUserId;
	}
	public void setExamineUserId(String examineUserId) {
		this.examineUserId = examineUserId;
	}
	/**
	 * 获取房屋用途字符串
	 * @return
	 */
	public String getHousingPurposesStr(){
		String housingPurposesStr = "";
		Integer housingPurposes = this.housingPurposes;
		if(housingPurposes!=null){
			if(housingPurposes==1){
				housingPurposesStr = "住宅";
			}else if(housingPurposes==2){
				housingPurposesStr = "商业";
			}else if(housingPurposes==3){
				housingPurposesStr = "商住两用";
			}else{
				
			}
		}
		return housingPurposesStr;
	}
	/**
	 * 获取房屋类型字符串
	 * @return
	 */
	public String getHousingTypeStr(){
		String housingTypeStr = "";
		Integer housingType = this.housingType;
		if(housingType!=null){
			if(housingType==1){
				housingTypeStr = "公寓";
			}else if(housingType==2){
				housingTypeStr = "别墅";
			}else if(housingType==3){
				housingTypeStr = "排屋";
			}else{
				
			}
		}
		return housingTypeStr;
	}
	/**
	 * 获取土地使用年限字符串
	 * @return
	 */
	public String getLandUsageTermStr(){
		String landUsageTermStr = "";
		Integer landUsageTerm = this.landUsageTerm;
		if(landUsageTerm!=null){
			if(landUsageTerm==1){
				landUsageTermStr = "70年";
			}else if(landUsageTerm==2){
				landUsageTermStr = "50年";
			}else{
				
			}
		}
		return landUsageTermStr;
	}
	/**
	 * 获取楼盘列表显示状态字符串
	 * @return
	 */
	public String getLayoutStatusStr(){
		String layoutStatusStr = "";
		Integer status = this.status;
		Integer auditingStatus = this.auditingStatus;
		if(status!=null){
			if(status==1){
				if(auditingStatus!=null){
					if(auditingStatus==2){
						layoutStatusStr = "未审核";
					}else if(auditingStatus==1){
						layoutStatusStr = "已审核";
					}else if(auditingStatus==3){
						layoutStatusStr = "审核拒绝";
					}else{
						
					}
				}else{
					layoutStatusStr = "未提交审核";
				}
			}else if(status==2){
				layoutStatusStr = "无效";
			}else{
				
			}
		}
		return layoutStatusStr;
	}
	/**
	 * 获取建筑结构字符串
	 * @return
	 */
	public String getBuildingStructureStr(){
		String buildingStructureStr = "";
		Integer buildingStructure = this.buildingStructure;
		if(buildingStructure!=null){
			if(buildingStructure==1){
				buildingStructureStr = "框架结构";
			}else if(buildingStructure==2){
				buildingStructureStr = "剪力墙结构";
			}else if(buildingStructure==3){
				buildingStructureStr = "框架-剪力墙结构";
			}else if(buildingStructure==4){
				buildingStructureStr = "筒体结构";
			}else if(buildingStructure==5){
				buildingStructureStr = "筒中筒结构";
			}else if(buildingStructure==6){
				buildingStructureStr = "砖混结构";
			}else if(buildingStructure==7){
				buildingStructureStr = "板柱筒结构";
			}else if(buildingStructure==8){
				buildingStructureStr = "砌体筒结构";
			}else if(buildingStructure==9){
				buildingStructureStr = "钢筋混凝土筒结构";
			}else if(buildingStructure==10){
				buildingStructureStr = "钢结构";
			}else if(buildingStructure==11){
				buildingStructureStr = "木结构";
			}else{
				
			}
		}
		return buildingStructureStr;
	}
	/**
	 * 销售开始时间
	 */
	public String getSalesStartDateStr() {
		return getDateForYYYYMMDD(salesStartDate);
	}
	/**
	 * 销售结束时间
	 */
	public String getSalesEndDateStr() {
		return getDateForYYYYMMDD(salesEndDate);
	}
	/**
	 * 开盘时间
	 */
	public String getOpeningTimeStr() {
		return getDateForYYYYMMDD(openingTime);
	}
	/**
	 * 入住时间
	 */
	public String getCheckInTimeStr() {
		return getDateForYYYYMMDD(checkInTime);
	}

	/**
	 * 获取YYYY-MM-DD格式
	 */
	public String getDateForYYYYMMDD(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(date == null) {
			return null;
		}
		return simpleDateFormat.format(date);
	}
	/**
	 * 获取楼盘登记时间字符串
	 * @return
	 */
	public String getOperateTimeStr(){
		return DateUtil.getDateString(this.operateTime, "yyyy-MM-dd hh:mm:ss");
	}

	/**
	 * 获取楼盘审核完整度状态字符串
	 * @return
	 */
	public String getCompleteStatusStr(){
		String completeStatusStr = "";
		Integer completeStatus = this.completeStatus;
		if(completeStatus!=null){
			if(completeStatus==1){
				completeStatusStr = "完整";
			}else if(completeStatus==2){
				completeStatusStr = "待审核";
			}else{
				completeStatusStr = "不完整";
			}
		}
		return completeStatusStr;
	}

	/**
	 * 获取楼盘审核准确度状态字符串
	 * @return
	 */
	public String getDataStatusStr(){
		String dataStatusStr = "";
		Integer dataStatus = this.dataStatus;
		if(dataStatus!=null){
			if(dataStatus==1){
				dataStatusStr = "审核通过";
			}else if(dataStatus==2){
				dataStatusStr = "待审核";
			}else{
				dataStatusStr = "不通过";
			}
		}
		return dataStatusStr;
	}
	
	/**
	 * 获取楼盘审核状态字符串
	 * @return
	 */
	public String getAuditingStatusStr(){
		String auditingStatusStr = "";
		Integer auditingStatus = this.auditingStatus;
		if(auditingStatus!=null){
			if(auditingStatus==1){
				auditingStatusStr = "已审核";
			}else if(auditingStatus==2){
				auditingStatusStr = "待审核";
			}else{
				auditingStatusStr = "拒绝";
			}
		}
		return auditingStatusStr;
	}
}
