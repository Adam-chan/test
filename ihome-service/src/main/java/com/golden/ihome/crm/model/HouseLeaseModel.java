package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.List;

import com.golden.ihome.common.HouseCommon;

/**
 * @author dl
 * 类描述：房源管理-房源租赁
 * 时间：2016-11-1
 */
public class HouseLeaseModel implements Serializable{

	private static final long serialVersionUID = -3052124168508133337L;
	
	private Integer id;
	
	private Integer status;//房源状态  1待租 2暂不租 3错误信息 4已成交
	private Integer houseInfoId;//房源ID
	private Integer property;//房屋性质1已购公房2商铺房3空置房4使用权房5央产6经济适用房
	private String propertyStr;
	private Integer useType;//使用类别1住宅，2商铺，3写字楼，4车库
	private String  useTypeStr;
	private Integer rooms;//室
	private Integer office;//厅
	private Integer kitchen;//厨
	private Integer wc;//厕所
	private Integer balcony;//阳台
	private Double coveredArea;//建筑面积
	private Double usedArea;//套内面积(租)
	private Integer buildingType;//楼型1高层2多层3平房4别墅5其它
	private String buildingTypeStr;
	private Integer floorType;//楼层类型1低楼层 2中楼层 3高楼层
	private Integer useStatus;//使用现状1闲置2出租3自住
	private Double leasePrice;//租价
	private Double entrustPrice;//底价
	private Integer shortestLease;//最短租期（月）
	private Double depositWay;//押金要求（元）
	private Integer leaseType;//出租类型1整租，2分租
	private Integer payType;//付款方式：1季付，2月付，3日付，4半年付，5年付
	private Integer chaoXiang;//朝向1东，2南，3西，4北
	private String chaoXiangStr;
	private String lookWay;//看房方式（格式：1，2，3）
	private String lookWayStr;//看房方式（汉字字符串，用逗号分隔)1托人开门，2找承租人，3预约业主
	private Integer buildTime;//建筑年代
	private Integer decoradion;//装修状况 1毛坯,2简装,3精装,4豪装,5中等
	private Integer decoradionTime;//装修时间1半年以内，2一年以内，3一年至三年，4三年以上
	private String decoradionTimeStr;
	private Integer taxation;//税费情况1免税，2只有个税，3只有营业税，4有营业税有个税
	private Integer takeEmpty;//腾空时间1签约后1周内，2签约后10天内，3签约后20天内
	private String takeEmptyStr;
	private String fckCode;//房产证号
	private String fckDate;//房产证日期
	private String fckUse;//证载用途
	private Integer zhengDai;//证贷情况1有证无贷,2有证有贷,3无证有贷,4无证无贷
	private Integer separateLease;//是否分租1.是2否
	private Integer intent;//意向1普通，2房管
	private Integer payBrokerage;//是否愿意支付佣金1是，2否
	private String fwsh;//房屋设施（格式：1，2，3）
	private String fwshStr;//房屋设施（汉字字符串，用逗号分隔)1电话 2洗衣机 3冰箱 4彩电 5空调 6热水器 7以上均有
	private String furniture;//室内家具（格式：1，2，3）
	private String furnitureStr;//室内家具（汉字字符串,用逗号分隔）1双人床 2单人床 3衣柜 4书桌 5餐桌 6沙发 7以上均有 
	private String special;//房屋特性（房源描述，格式：1，2，3）
	private String specialStr;//房屋特性（房源描述，汉字字符串，用逗号分隔）
	private String tags;//房源标签（格式：1，2，3）
	private String tagsStr;//房源标签（逗号分隔）1随时看房 2新上房源 3业主诚租 4拎包入住
	private Integer assess;//房源评价1无效，2暂不租，3已租，4待租，5已成交
	private String remark;//备注
	private String createTime;//创建时间
	private String operateTime;//最后一次操作时间
	private Double propertyFee;//物业费
	private String ownerName;//业主
	private String ownerTel;//业主电话
	private List<HouseLinkManModel> linkManList;//房源联系人
	
	//houseInfo
	private String code;//房源编号
	private String operatorId;//登记人id
	private String operator;//登记人
	private String operateOrg;//登记人所属组织
	private String operateOrgCode;//登记人所属组织编号
	private String operateQu;//登记人所属区
	private String operateQuCode;//登记人所属区编号
	private String divideUserId;//收益分成人id
	private String infoOperateTime;//收益分成人 创建和变更时间
	private String divideUser;//收益分成人（所属人）
	private String divideOrgCode;//收益分成组code
	private String divideOrg;//收益分成组
	private String divideQu;//收益分成区
	
	//商铺
	private String fitManagement;//适合经营 （格式：1，2，3）
	private String fitManagement2;//适合经营（汉字字符串,用逗号分隔）
	private String closePosition;//临近位置
	
	//写字楼
	private Integer officeGrade;//写字楼等级1甲级， 2乙级，3丙级，4丁级
	private Integer containPerson;//可办公人数
	private Integer officeWc;//写字楼卫生间
	
	//车位
	private Integer carPortId;//车位id
	private String parkNum;//车位号
	private Integer carPortType;//车位类型 1车位 2车库
	private Integer carPortFloor;//车位楼层 1地上 2地下
	private Integer closeBuildingId;//临近栋座
	private Integer carPortPropertyRight;//车位产权 1有产权 2无产权
	
	//房管房
	private Integer houseManage;//是否为房管房 1是 2否
	private String entrustTerm;//委托期限
	private String leaseTerm;//承租期限
	private String collectHouseUser;//收房人
	private String collectHouseOrg;//收房组
	
	//其他
	private String prospectCount;//实勘数量
	private String keyCount;//钥匙数量
	private Integer watchHouseCount;//看房次数
	private String floor;//楼层
	private String kfCount;//看房次数
	private String lastFollowTime;//最后跟进日期
	private String timeLimitCount;//限时速递次数
	private Integer priceChangeType;//价格变动类型 1涨价 2降价
	
	//地址
	private String addressDetail;//详细地址
	private String zzdzDetail;//证载地址
	private String ba1Name;//一级商圈
	private String ba2Id;//二级商圈ID
	private String ba2Name;//二级商圈
	private String groupName;//楼盘分组
	private String buildingName;//楼栋
	private String unitCode;//单元
	private Integer roomId;//房间ID
	private String roomName;//房间
	private String communityName;//社区名称
	
	//楼盘
	private Integer premisesId;//楼盘ID
	private String premisesName;//楼盘名称
	private String premisesEduIds;//教育设施
	private String busStation;//公交
	private String subwayStation;//地铁
	private Integer maintenanceCategory;//小区维护类别 1:责任盘  2:非责任盘
	private String  maintenanceCategoryStr;
	
	//OWNER_SOURCE
	private String source1;//信息来源1级
	private String source2;//信息来源2级
	
	//linkMan
	private Integer linkType;//联系人类型1.业主(产权人) 2.父母 3.丈夫 4.妻子 5.子女 6.亲戚 7.其他
	private String linkTypeStr;
	private String linkName;//联系人姓名
	private String contactType;//联系方式
	
	//MANAGE_KEY_INFO
	private Integer keyId;//钥匙管理ID
	private Integer keyType;//钥匙类型：1钥匙，2门禁卡，3密码
	private String keyTypeStr;
	private String keyCode;//钥匙编号
	private String colelectUser;//收钥匙人
	private String colelectUserId;//收钥匙人Id
	private String colelectContact;//收钥匙人联系方式
	private String colelectZone;//收取区
	private String colelectZoneCode;//收取区编号
	private String colelectOrg;//收取组
	private String colelectOrgCode;//收取组编号
	private String deposit;//存放人
	private String depositContact;//存放人联系方式
	private String depositStoreId;//存放实体店
	private String password;//密码
	private String keyRemark;//备注
	private String keyOperatetime;
	
	//房间表
	private Integer bhNum;//楼层
	
	//实勘 MANAGE_PROSPECT_INFO
	private Integer skId;
	
	//车位
	private String cpId;
	public String getInfoOperateTime() {
		return infoOperateTime;
	}
	public void setInfoOperateTime(String infoOperateTime) {
		this.infoOperateTime = infoOperateTime;
	}
	public String getKeyOperatetime() {
		return keyOperatetime;
	}
	public void setKeyOperatetime(String keyOperatetime) {
		this.keyOperatetime = keyOperatetime;
	}
	public String getDivideOrgCode() {
		return divideOrgCode;
	}
	public void setDivideOrgCode(String divideOrgCode) {
		this.divideOrgCode = divideOrgCode;
	}
	public Integer getSkId() {
		return skId;
	}
	public void setSkId(Integer skId) {
		this.skId = skId;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepositStoreId() {
		return depositStoreId;
	}
	public void setDepositStoreId(String depositStoreId) {
		this.depositStoreId = depositStoreId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getDivideUserId() {
		return divideUserId;
	}
	public void setDivideUserId(String divideUserId) {
		this.divideUserId = divideUserId;
	}
	public String getDivideUser() {
		return divideUser;
	}
	public void setDivideUser(String divideUser) {
		this.divideUser = divideUser;
	}
	public String getDivideOrg() {
		return divideOrg;
	}
	public void setDivideOrg(String divideOrg) {
		this.divideOrg = divideOrg;
	}
	public String getDivideQu() {
		return divideQu;
	}
	public void setDivideQu(String divideQu) {
		this.divideQu = divideQu;
	}
	public Integer getPriceChangeType() {
		return priceChangeType;
	}
	public void setPriceChangeType(Integer priceChangeType) {
		this.priceChangeType = priceChangeType;
	}
	public Integer getHouseManage() {
		return houseManage;
	}
	public void setHouseManage(Integer houseManage) {
		this.houseManage = houseManage;
	}
	public String getEntrustTerm() {
		return entrustTerm;
	}
	public void setEntrustTerm(String entrustTerm) {
		this.entrustTerm = entrustTerm;
	}
	public String getLeaseTerm() {
		return leaseTerm;
	}
	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
	}
	public String getCollectHouseUser() {
		return collectHouseUser;
	}
	public void setCollectHouseUser(String collectHouseUser) {
		this.collectHouseUser = collectHouseUser;
	}
	public String getCollectHouseOrg() {
		return collectHouseOrg;
	}
	public void setCollectHouseOrg(String collectHouseOrg) {
		this.collectHouseOrg = collectHouseOrg;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getTimeLimitCount() {
		return timeLimitCount;
	}
	public void setTimeLimitCount(String timeLimitCount) {
		this.timeLimitCount = timeLimitCount;
	}
	public Integer getCarPortId() {
		return carPortId;
	}
	public void setCarPortId(Integer carPortId) {
		this.carPortId = carPortId;
	}
	public Integer getCloseBuildingId() {
		return closeBuildingId;
	}
	public void setCloseBuildingId(Integer closeBuildingId) {
		this.closeBuildingId = closeBuildingId;
	}
	public Integer getCarPortPropertyRight() {
		return carPortPropertyRight;
	}
	public void setCarPortPropertyRight(Integer carPortPropertyRight) {
		this.carPortPropertyRight = carPortPropertyRight;
	}
	public String getParkNum() {
		return parkNum;
	}
	public void setParkNum(String parkNum) {
		this.parkNum = parkNum;
	}
	public Integer getCarPortType() {
		return carPortType;
	}
	public void setCarPortType(Integer carPortType) {
		this.carPortType = carPortType;
	}
	public Integer getCarPortFloor() {
		return carPortFloor;
	}
	public void setCarPortFloor(Integer carPortFloor) {
		this.carPortFloor = carPortFloor;
	}
	public Integer getOfficeWc() {
		return officeWc;
	}
	public void setOfficeWc(Integer officeWc) {
		this.officeWc = officeWc;
	}
	public List<HouseLinkManModel> getLinkManList() {
		return linkManList;
	}
	public void setLinkManList(List<HouseLinkManModel> linkManList) {
		this.linkManList = linkManList;
	}
	public String getPremisesEduIds() {
		return premisesEduIds;
	}
	public void setPremisesEduIds(String premisesEduIds) {
		this.premisesEduIds = premisesEduIds;
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
	public String getSource1() {
		return source1;
	}
	public void setSource1(String source1) {
		this.source1 = source1;
	}
	public String getSource2() {
		return source2;
	}
	public void setSource2(String source2) {
		this.source2 = source2;
	}
	public Integer getLinkType() {
		return linkType;
	}
	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
		this.linkTypeStr = HouseCommon.getLinkTypeStr(linkType);
	}
	public String getLinkTypeStr() {
		return linkTypeStr;
	}
	public void setLinkTypeStr(String linkTypeStr) {
		this.linkTypeStr = linkTypeStr;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public Integer getKeyId() {
		return keyId;
	}
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	public Integer getKeyType() {
		return keyType;
	}
	public void setKeyType(Integer keyType) {
		this.keyType = keyType;
		this.keyTypeStr = HouseCommon.getKeyTypeStr(keyType);
	}
	public String getKeyTypeStr() {
		return keyTypeStr;
	}
	public void setKeyTypeStr(String keyTypeStr) {
		this.keyTypeStr = keyTypeStr;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getColelectUser() {
		return colelectUser;
	}
	public void setColelectUser(String colelectUser) {
		this.colelectUser = colelectUser;
	}
	public String getColelectUserId() {
		return colelectUserId;
	}
	public void setColelectUserId(String colelectUserId) {
		this.colelectUserId = colelectUserId;
	}
	public String getColelectContact() {
		return colelectContact;
	}
	public void setColelectContact(String colelectContact) {
		this.colelectContact = colelectContact;
	}
	public String getColelectZone() {
		return colelectZone;
	}
	public void setColelectZone(String colelectZone) {
		this.colelectZone = colelectZone;
	}
	public String getColelectZoneCode() {
		return colelectZoneCode;
	}
	public void setColelectZoneCode(String colelectZoneCode) {
		this.colelectZoneCode = colelectZoneCode;
	}
	public String getColelectOrg() {
		return colelectOrg;
	}
	public void setColelectOrg(String colelectOrg) {
		this.colelectOrg = colelectOrg;
	}
	public String getColelectOrgCode() {
		return colelectOrgCode;
	}
	public void setColelectOrgCode(String colelectOrgCode) {
		this.colelectOrgCode = colelectOrgCode;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getDepositContact() {
		return depositContact;
	}
	public void setDepositContact(String depositContact) {
		this.depositContact = depositContact;
	}
	public String getKeyRemark() {
		return keyRemark;
	}
	public void setKeyRemark(String keyRemark) {
		this.keyRemark = keyRemark;
	}
	public Integer getBhNum() {
		return bhNum;
	}
	public void setBhNum(Integer bhNum) {
		this.bhNum = bhNum;
	}
	public String getPropertyStr() {
		return propertyStr;
	}
	public void setPropertyStr(String propertyStr) {
		this.propertyStr = propertyStr;
	}
	public String getDecoradionTimeStr() {
		return decoradionTimeStr;
	}
	public void setDecoradionTimeStr(String decoradionTimeStr) {
		this.decoradionTimeStr = decoradionTimeStr;
	}
	public Integer getMaintenanceCategory() {
		return maintenanceCategory;
	}
	public void setMaintenanceCategory(Integer maintenanceCategory) {
		this.maintenanceCategory = maintenanceCategory;
		this.maintenanceCategoryStr = HouseCommon.getMaintenanceCategoryStr(maintenanceCategory);
	}
	public String getMaintenanceCategoryStr() {
		return maintenanceCategoryStr;
	}
	public void setMaintenanceCategoryStr(String maintenanceCategoryStr) {
		this.maintenanceCategoryStr = maintenanceCategoryStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getProperty() {
		return property;
	}
	public void setProperty(Integer property) {
		this.property = property;
		this.propertyStr = HouseCommon.getPropertyStr(property);
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
		this.useTypeStr = HouseCommon.getUseTypeStr(useType);
	}
	public String getUseTypeStr() {
		return useTypeStr;
	}
	public void setUseTypeStr(String useTypeStr) {
		this.useTypeStr = useTypeStr;
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
	public Integer getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(Integer buildingType) {
		this.buildingType = buildingType;
		this.buildingTypeStr = HouseCommon.getBuildingTypeStr(buildingType);
	}
	public String getBuildingTypeStr() {
		return buildingTypeStr;
	}
	public void setBuildingTypeStr(String buildingTypeStr) {
		this.buildingTypeStr = buildingTypeStr;
	}
	public Integer getFloorType() {
		return floorType;
	}
	public void setFloorType(Integer floorType) {
		this.floorType = floorType;
	}
	public Integer getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}
	public Double getLeasePrice() {
		return leasePrice;
	}
	public void setLeasePrice(Double leasePrice) {
		this.leasePrice = leasePrice;
	}
	public Double getEntrustPrice() {
		return entrustPrice;
	}
	public void setEntrustPrice(Double entrustPrice) {
		this.entrustPrice = entrustPrice;
	}
	public Integer getShortestLease() {
		return shortestLease;
	}
	public void setShortestLease(Integer shortestLease) {
		this.shortestLease = shortestLease;
	}
	public Double getDepositWay() {
		return depositWay;
	}
	public void setDepositWay(Double depositWay) {
		this.depositWay = depositWay;
	}
	public Integer getLeaseType() {
		return leaseType;
	}
	public void setLeaseType(Integer leaseType) {
		this.leaseType = leaseType;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Integer getChaoXiang() {
		return chaoXiang;
	}
	public void setChaoXiang(Integer chaoXiang) {
		this.chaoXiang = chaoXiang;
		this.chaoXiangStr = HouseCommon.getChaoXiangStr(chaoXiang);
	}
	public String getChaoXiangStr() {
		return chaoXiangStr;
	}
	public void setChaoXiangStr(String chaoXiangStr) {
		this.chaoXiangStr = chaoXiangStr;
	}
	public String getLookWay() {
		return lookWay;
	}
	public void setLookWay(String lookWay) {
		this.lookWay = lookWay;
	}
	public Integer getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Integer buildTime) {
		this.buildTime = buildTime;
	}
	public Integer getDecoradion() {
		return decoradion;
	}
	public void setDecoradion(Integer decoradion) {
		this.decoradion = decoradion;
	}
	public Integer getDecoradionTime() {
		return decoradionTime;
	}
	public void setDecoradionTime(Integer decoradionTime) {
		this.decoradionTime = decoradionTime;
		this.decoradionTimeStr = HouseCommon.getDecoradionTimeStr(decoradionTime);
	}
	public Integer getTaxation() {
		return taxation;
	}
	public void setTaxation(Integer taxation) {
		this.taxation = taxation;
	}
	public Integer getTakeEmpty() {
		return takeEmpty;
	}
	
	public String getTakeEmptyStr() {
		return takeEmptyStr;
	}
	public void setTakeEmptyStr(String takeEmptyStr) {
		this.takeEmptyStr = takeEmptyStr;
	}
	public void setTakeEmpty(Integer takeEmpty) {
		this.takeEmpty = takeEmpty;
		this.takeEmptyStr = HouseCommon.getTakeEmptyStr(takeEmpty);
	}
	public String getFckCode() {
		return fckCode;
	}
	public void setFckCode(String fckCode) {
		this.fckCode = fckCode;
	}
	public String getFckDate() {
		return fckDate;
	}
	public void setFckDate(String fckDate) {
		this.fckDate = fckDate;
	}
	public String getFckUse() {
		return fckUse;
	}
	public void setFckUse(String fckUse) {
		this.fckUse = fckUse;
	}
	public Integer getZhengDai() {
		return zhengDai;
	}
	public void setZhengDai(Integer zhengDai) {
		this.zhengDai = zhengDai;
	}
	public Integer getSeparateLease() {
		return separateLease;
	}
	public void setSeparateLease(Integer separateLease) {
		this.separateLease = separateLease;
	}
	public String getLookWayStr() {
		return lookWayStr;
	}
	public void setLookWayStr(String lookWayStr) {
		this.lookWayStr = lookWayStr;
	}
	public String getFwshStr() {
		return fwshStr;
	}
	public void setFwshStr(String fwshStr) {
		this.fwshStr = fwshStr;
	}
	public String getFurnitureStr() {
		return furnitureStr;
	}
	public void setFurnitureStr(String furnitureStr) {
		this.furnitureStr = furnitureStr;
	}
	public String getSpecialStr() {
		return specialStr;
	}
	public void setSpecialStr(String specialStr) {
		this.specialStr = specialStr;
	}
	public String getTagsStr() {
		return tagsStr;
	}
	public void setTagsStr(String tagsStr) {
		this.tagsStr = tagsStr;
	}
	public Integer getIntent() {
		return intent;
	}
	public void setIntent(Integer intent) {
		this.intent = intent;
	}
	public Integer getPayBrokerage() {
		return payBrokerage;
	}
	public void setPayBrokerage(Integer payBrokerage) {
		this.payBrokerage = payBrokerage;
	}
	public String getFwsh() {
		return fwsh;
	}
	public void setFwsh(String fwsh) {
		this.fwsh = fwsh;
	}
	public String getFurniture() {
		return furniture;
	}
	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getAssess() {
		return assess;
	}
	public void setAssess(Integer assess) {
		this.assess = assess;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getZzdzDetail() {
		return zzdzDetail;
	}
	public void setZzdzDetail(String zzdzDetail) {
		this.zzdzDetail = zzdzDetail;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	public String getBa2Id() {
		return ba2Id;
	}
	public void setBa2Id(String ba2Id) {
		this.ba2Id = ba2Id;
	}
	public String getBa2Name() {
		return ba2Name;
	}
	public void setBa2Name(String ba2Name) {
		this.ba2Name = ba2Name;
	}
	public Double getPropertyFee() {
		return propertyFee;
	}
	public void setPropertyFee(Double propertyFee) {
		this.propertyFee = propertyFee;
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
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerTel() {
		return ownerTel;
	}
	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getKfCount() {
		return kfCount;
	}
	public void setKfCount(String kfCount) {
		this.kfCount = kfCount;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getLastFollowTime() {
		return lastFollowTime;
	}
	public void setLastFollowTime(String lastFollowTime) {
		this.lastFollowTime = lastFollowTime;
	}
	public Integer getWatchHouseCount() {
		return watchHouseCount;
	}
	public void setWatchHouseCount(Integer watchHouseCount) {
		this.watchHouseCount = watchHouseCount;
	}
	public String getFitManagement() {
		return fitManagement;
	}
	public void setFitManagement(String fitManagement) {
		this.fitManagement = fitManagement;
	}
	public String getFitManagement2() {
		return fitManagement2;
	}
	public void setFitManagement2(String fitManagement2) {
		this.fitManagement2 = fitManagement2;
	}
	public String getClosePosition() {
		return closePosition;
	}
	public void setClosePosition(String closePosition) {
		this.closePosition = closePosition;
	}
	public Integer getOfficeGrade() {
		return officeGrade;
	}
	public void setOfficeGrade(Integer officeGrade) {
		this.officeGrade = officeGrade;
	}
	public Integer getContainPerson() {
		return containPerson;
	}
	public void setContainPerson(Integer containPerson) {
		this.containPerson = containPerson;
	}
	public String getBa1Name() {
		return ba1Name;
	}
	public void setBa1Name(String ba1Name) {
		this.ba1Name = ba1Name;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getOperateOrg() {
		return operateOrg;
	}
	public void setOperateOrg(String operateOrg) {
		this.operateOrg = operateOrg;
	}
	public String getOperateOrgCode() {
		return operateOrgCode;
	}
	public void setOperateOrgCode(String operateOrgCode) {
		this.operateOrgCode = operateOrgCode;
	}
	public String getOperateQu() {
		return operateQu;
	}
	public void setOperateQu(String operateQu) {
		this.operateQu = operateQu;
	}
	public String getOperateQuCode() {
		return operateQuCode;
	}
	public void setOperateQuCode(String operateQuCode) {
		this.operateQuCode = operateQuCode;
	}
	/**
	 * 房源状态字符串
	 * @return
	 */
	public String getStatusStr(){
		String statusStr = "";
		Integer status = this.status;
		if(status!=null){
			if(status==1){
				statusStr = "待租";
			}else if(status==2){
				statusStr = "暂不租";
			}else if(status==3){
				statusStr = "已成交";
			}else if(status==4){
				statusStr = "错误信息";
			}else{
				
			}
		}
		return statusStr;
	}
	/**
	 * 装修状况字符串
	 * @return
	 */
	public String getDecoradionStr(){
		String decoradionStr = "";
		Integer decoradion = this.decoradion;
		if(decoradion!=null){
			if(decoradion==1){
				decoradionStr = "毛坯";
			}else if(decoradion==2){
				decoradionStr = "简装";
			}else if(decoradion==3){
				decoradionStr = "精装";
			}else if(decoradion==4){
				decoradionStr = "豪装";
			}else if(decoradion==5){
				decoradionStr = "中等";
			}else{
				
			}
		}
		return decoradionStr;
	}
	/**
	 * 出租方式字符串
	 * @return
	 */
	public String getLeaseTypeStr(){
		String leaseTypeStr = "";
		Integer leaseType = this.leaseType;
		if(leaseType!=null){
			if(leaseType==1){
				leaseTypeStr = "整租";
			}else if(leaseType==2){
				leaseTypeStr = "分租";
			}else{
				
			}
		}
		return leaseTypeStr;
	}
	/**
	 * 付款方式字符串
	 * @return
	 */
	public String getPayTypeStr(){
		String payTypeStr = "";
		Integer payType = this.payType;
		if(payType!=null){
			if(payType==1){
				payTypeStr = "季付";
			}else if(payType==2){
				payTypeStr = "月付";
			}else if(payType==3){
				payTypeStr = "日付";
			}else if(payType==4){
				payTypeStr = "半年付";
			}else if(payType==5){
				payTypeStr = "年付";
			}else{
				
			}
		}
		return payTypeStr;
	}
	/**
	 * 写字楼等级字符串
	 * @return
	 */
	public String getOfficeGradeStr(){
		String officeGradeStr = "";
		Integer officeGrade = this.officeGrade;
		if(officeGrade!=null){
			if(officeGrade==1){
				officeGradeStr = "甲级";
			}else if(officeGrade==2){
				officeGradeStr = "乙级";
			}else if(officeGrade==3){
				officeGradeStr = "丙级";
			}else if(officeGrade==4){
				officeGradeStr = "丁级";
			}else{
				
			}
		}
		return officeGradeStr;
	}
	/**
	 * 使用现状
	 * @return
	 */
	public String getUseStatusStr(){
		String useStatusStr = "";
		Integer useStatus = this.useStatus;
		if(useStatus!=null){
			if(useStatus==1){
				useStatusStr = "闲置";
			}else if(useStatus==2){
				useStatusStr = "出租";
			}else if(useStatus==3){
				useStatusStr = "自住";
			}else{
				
			}
		}
		return useStatusStr;
	}
	/**
	 * 楼层类型1低楼层 2中楼层 3高楼层
	 * @return
	 */
	public String getFloorTypeStr(){
		String floorTypeStr = "";
		Integer floorType = this.floorType;
		if(floorType!=null){
			if(floorType==1){
				floorTypeStr = "低楼层";
			}else if(floorType==2){
				floorTypeStr = "中楼层";
			}else if(floorType==3){
				floorTypeStr = "高楼层";
			}else{
				
			}
		}
		return floorTypeStr;
	}
}
