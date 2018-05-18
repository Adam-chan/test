package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.List;

import com.golden.ihome.common.HouseCommon;

/**
 * @author sy
 * 类描述：房源管理-房源买卖
 * 时间：2016-11-1
 */
public class HouseSaleModel implements Serializable{
	
	private static final long serialVersionUID = -3052124168508133337L;
	private Integer id;

	private Integer status;//状态1无效、2暂不售、3待售、4已成交、5已售
	private Integer houseInfoId;//房源ID
	private Integer roomId;//房间ID
	private String unitName;//房屋名称 
	private String ownerName;//业主姓名
	private String ownerTel;//业主电话
	private Integer property;//房屋性质1已购公房2商铺房3空置房4使用权房5央产6经济适用房
	private String propertyStr;
	private Integer useType;//使用类别1住宅，2商铺，3写字楼，4车库
	private String  useTypeStr;
	private Integer rooms;//室
	private Integer office;//厅
	private Integer kitchen;//厨
	private Integer balcony;//阳台
	private Integer wc;//卫
	private Integer buildingType;//（建筑类型）1高层2多层3平房4别墅5其它
	private String buildingTypeStr;
	private Integer buildingFloor;//楼层1低楼层2中楼层3高楼层
	private String buildingFloorStr;
	private Integer floorType;//楼层类型1高层，2中间层，3顶楼，4底楼，5地下层
	private Double coveredArea;//建筑面积
	private Double usedArea;//使用面积
	private Integer chaoXiang;//朝向1东，2南，3西，4北
	private String chaoXiangStr;
	private Integer unitPrice;//单价
	private Double sellPrice;//房屋售价
	private Double carportSellPrice;//车位售价
	private Double entrustPrice;//底价
	private Integer zhengDai;//证贷情况1有证无贷,2有证有贷,3无证有贷,4无证无贷
	private String zhengDaiStr;
	private Integer taxation;//税费情况1免税，2只有个税，3只有营业税，4有营业税有个税
	private String taxationRamark;//税费情况备注
	private String taxationStr;
	private String fukUse;//证载用途
	private Integer houseLevel;//房源等级1普通房源，2诚盘,3必卖盘，4诚盘+必卖盘
	private String houseLevelStr;
	private String fckCode;//房产证号
	private String fckDate;//房产证日期
	private Integer hjInfoType;//户籍信息类型1有-可迁出,2无-不可迁出,3无
	private String hjInfoTypeStr;
	private Integer assess;//房源评价1暂不售，2已售，3无效，4待售，5已成交
	private Integer moveOutType;//迁出时间1随时，2过户后，3半年内
	private String moveOutTypeStr;
	private Integer takeEmpty;//腾空时间1签约后1周内，2签约后10天内，3签约后20天内
	private String takeEmptyStr;
	private String lookWay;//看房方式   1托人开门，2找承租人，3预约业主
	private String lookWayStr;//看房方式 (汉字字符串，用逗号分隔)（格式：1，2，3）
	private String haunted;//是否是凶宅(汉字字符串，用逗号分隔)1不是，2是
	private String haunted2;//是否是凶宅(格式：1，2，3）
	private String special;//房屋描述（汉字字符串，用逗号分隔）
	private String specialStr;//房屋描述（格式：1，2，3）
	private String tags;//房源标签（逗号分隔）1业主诚售，2随时看房，3新上房源
	private String tagsStr;//房源标签（格式：1，2，3）
	private Integer sellReason;//卖房原因1长期置闲，2买新房，3出国，4新房还贷，5其它原因
	private String sellReasonStr;
	private String remark;//备注
	private String bugDemand;//新购房屋要求
	private String createTime;//创建时间
	private String operateTime;//最后一次操作时间
	private Integer decoradion;//装修类型1毛坯,2简装,3精装,4豪装,5中等
	private String decoradionStr;
	private Integer decoradionTime;//装修时间1半年以内，2一年以内，3一年至三年，4三年以上
	private String decoradionTimeStr;
	private Integer propertyRightType;//产权性质变更 1已变更产权，2未变更产权
	private Integer buildTime;//建筑年代
	private Integer useStatus;//使用现状1闲置2出租3自住
	private String addressDetail;//详细地址
	private String zzdzDetail;//证载地址
	private String ba1Id;//二级商圈ID
	private String ba1Name;//二级商圈名称
	private String groupName;//分组
	private String buildingName;//栋座
	private String unitCode;//单元
	private String roomName;//房间名称
	private String ba2Id;//二级商圈ID
	private String ba2Name;//二级商圈名称
	private String prospectCount;//实勘数量
	private String keyCount;//钥匙数量
	private String timeLimitCount;//限时速递数量
	private String floor;//楼层
	private String lastFollowTime;//最后跟进日期
	private String eduIds;//教育设施
	private String watchHouseCount;//看房次数
	private String houseSaleCode;
	private List<HouseLinkManModel> linkManList;//房源联系人
	private String communityName; //小区名称
	private Integer priceChangeType;//价格变动类型 1涨价 2降价
	
	//houseInfo
	private String code;//房源编号
	private String operatorId;//登记人id
	private String operator;//登记人
	private String operateOrg;//登记人部门
	private String operateOrgCode;//登记人部门编码
	private String operateQu;//登记人所属区
	private String operateQuCode;//登记人所属区编号
	private String divideUserId;//收益分成人id
	private String infoOperateTime;//收益分成人 创建和变更时间
	private String infoOperateTimestr;
	private String divideUser;//收益分成人（所属人）
	private String divideOrgCode;//收益分成组code
	private String divideOrg;//收益分成组
	private String divideQu;//收益分成区
	private String divideDaqu;//收益分成大区
	//商铺
	private Double yield;//实得率
	private Integer fitManagement;//适合经营 1服装2餐饮
	private String fitManagementStr;
	private String nearPosition;//临近位置
	private Double propertyFee;//物业费
	
	//写字楼
	private Integer officeLevel;//写字楼等级1甲级，2乙级，3丙级，4丁级
	private String officeLevelStr;
	private Integer containPerson;//可容纳人数
	private Integer toilet;//厕所1公厕2私厕
	private String toiletStr;
	
	//车位
	private Integer carPortId;//车位id
	private Integer carFloor;//楼层
	private String carPortType;//车位类型 1车位 2车库
	private String parkNum;//车位号
	private Integer carPortFloor;//车位楼层 1地上 2地下
	private Integer closeBuildingId;//临近栋座
	private Integer carPropertyRightType;//车位产权 1有产权 2无产权
	
	//楼盘
	private Integer premisesId;//楼盘ID
	private String premisesName;//楼盘名称
	private String premisesEduIds;//教育设施
	private String busStation;//公交
	private String subwayStation;//地铁
	
	//OWNER_SOURCE
	private String source1;//信息来源1级
	private String source2;//信息来源2级
	
	//linkMan 联系人
	private Integer linkType;//联系人类型1.业主(产权人) 2.父母 3.丈夫 4.妻子 5.子女 6.亲戚 7.其他
	private String linkTypeStr;
	private String linkName;//联系人姓名
	private String contactType;//联系方式
	
	
	//MANAGE_KEY_INFO 钥匙管理
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
	private String password;//密码divideOrgCode
	private String keyRemark;//备注
	private String keyOperatetime;
	
	//房间表
	private Integer bhNum;
	
	//实勘 MANAGE_PROSPECT_INFO
	private Integer skId;
	//车位
	private String cpId;
	
	public String getKeyOperatetime() {
		return keyOperatetime;
	}
	public void setKeyOperatetime(String keyOperatetime) {
		this.keyOperatetime = keyOperatetime;
	}
	public String getInfoOperateTime() {
		return infoOperateTime;
	}
	public void setInfoOperateTime(String infoOperateTime) {
		this.infoOperateTime = infoOperateTime;
	}
	public String getInfoOperateTimestr() {
		return infoOperateTimestr;
	}
	public void setInfoOperateTimestr(String infoOperateTimestr) {
		this.infoOperateTimestr = infoOperateTimestr;
	}
	public String getDivideOrgCode() {
		return divideOrgCode;
	}
	public void setDivideOrgCode(String divideOrgCode) {
		this.divideOrgCode = divideOrgCode;
	}
	public String getCpId(){
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public Integer getSkId() {
		return skId;
	}
	public void setSkId(Integer skId) {
		this.skId = skId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBuildingFloorStr() {
		return buildingFloorStr;
	}
	public void setBuildingFloorStr(String buildingFloorStr) {
		this.buildingFloorStr = buildingFloorStr;
	}
	public String getOfficeLevelStr() {
		return officeLevelStr;
	}
	public void setOfficeLevelStr(String officeLevelStr) {
		this.officeLevelStr = officeLevelStr;
	}
	public String getFitManagementStr() {
		return fitManagementStr;
	}
	public void setFitManagementStr(String fitManagementStr) {
		this.fitManagementStr = fitManagementStr;
	}
	public Integer getBhNum() {
		return bhNum;
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
	public String getOperateOrg() {
		return operateOrg;
	}
	public String getDivideDaqu() {
		return divideDaqu;
	}
	public void setDivideDaqu(String divideDaqu) {
		this.divideDaqu = divideDaqu;
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
	public String getDepositStoreId() {
		return depositStoreId;
	}
	public void setDepositStoreId(String depositStoreId) {
		this.depositStoreId = depositStoreId;
	}
	public void setBhNum(Integer bhNum) {
		this.bhNum = bhNum;
	}
	public String getHouseSaleCode() {
		return houseSaleCode;
	}
	public void setHouseSaleCode(String houseSaleCode) {
		this.houseSaleCode = houseSaleCode;
	}
	public List<HouseLinkManModel> getLinkManList() {
		return linkManList;
	}
	public void setLinkManList(List<HouseLinkManModel> linkManList) {
		this.linkManList = linkManList;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public Integer getPriceChangeType() {
		return priceChangeType;
	}
	public void setPriceChangeType(Integer priceChangeType) {
		this.priceChangeType = priceChangeType;
	}
	public String getKeyTypeStr() {
		return keyTypeStr;
	}
	public void setKeyTypeStr(String keyTypeStr) {
		this.keyTypeStr = keyTypeStr;
	}
	public String getKeyRemark() {
		return keyRemark;
	}
	public void setKeyRemark(String keyRemark) {
		this.keyRemark = keyRemark;
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
	public String getUseTypeStr() {
		return useTypeStr;
	}
	public void setUseTypeStr(String useTypeStr) {
		this.useTypeStr = useTypeStr;
	}
	public String getBuildingTypeStr() {
		return buildingTypeStr;
	}
	public void setBuildingTypeStr(String buildingTypeStr) {
		this.buildingTypeStr = buildingTypeStr;
		
	}
	public String getChaoXiangStr() {
		return chaoXiangStr;
	}
	public void setChaoXiangStr(String chaoXiangStr) {
		this.chaoXiangStr = chaoXiangStr;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getZhengDaiStr() {
		return zhengDaiStr;
	}
	public void setZhengDaiStr(String zhengDaiStr) {
		this.zhengDaiStr = zhengDaiStr;
	}
	public String getTaxationStr() {
		return taxationStr;
	}
	public void setTaxationStr(String taxationStr) {
		this.taxationStr = taxationStr;
	}
	public String getTaxationRamark() {
		return taxationRamark;
	}
	public void setTaxationRamark(String taxationRamark) {
		this.taxationRamark = taxationRamark;
	}
	public String getHouseLevelStr() {
		return houseLevelStr;
	}
	public void setHouseLevelStr(String houseLevelStr) {
		this.houseLevelStr = houseLevelStr;
	}
	public String getMoveOutTypeStr() {
		return moveOutTypeStr;
	}
	public void setMoveOutTypeStr(String moveOutTypeStr) {
		this.moveOutTypeStr = moveOutTypeStr;
	}
	public String getTakeEmptyStr() {
		return takeEmptyStr;
	}
	public void setTakeEmptyStr(String takeEmptyStr) {
		this.takeEmptyStr = takeEmptyStr;
	}
	public String getLookWay() {
		return lookWay;
	}
	
	public void setLookWay(String lookWay) {
		this.lookWay = lookWay;
	}
	public String getSellReasonStr() {
		return sellReasonStr;
	}
	public void setSellReasonStr(String sellReasonStr) {
		this.sellReasonStr = sellReasonStr;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	public Integer getBalcony() {
		return balcony;
	}
	public void setBalcony(Integer balcony) {
		this.balcony = balcony;
	}
	public Integer getWc() {
		return wc;
	}
	public void setWc(Integer wc) {
		this.wc = wc;
	}
	public Integer getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(Integer buildingType) {
		this.buildingType = buildingType;
		this.buildingTypeStr = HouseCommon.getBuildingTypeStr(buildingType);
	}
	public Integer getBuildingFloor() {
		return buildingFloor;
	}
	public void setBuildingFloor(Integer buildingFloor) {
		this.buildingFloor = buildingFloor;
		this.buildingFloorStr = HouseCommon.getBuildingFloorStr(buildingFloor);
	}
	public Integer getFloorType() {
		return floorType;
	}
	public void setFloorType(Integer floorType) {
		this.floorType = floorType;
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
	public Integer getChaoXiang() {
		return chaoXiang;
	}
	public void setChaoXiang(Integer chaoXiang) {
		this.chaoXiang = chaoXiang;
		this.chaoXiangStr = HouseCommon.getChaoXiangStr(chaoXiang);
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Double getCarportSellPrice() {
		return carportSellPrice;
	}
	public void setCarportSellPrice(Double carportSellPrice) {
		this.carportSellPrice = carportSellPrice;
	}
	public Double getEntrustPrice() {
		return entrustPrice;
	}
	public void setEntrustPrice(Double entrustPrice) {
		this.entrustPrice = entrustPrice;
	}
	public Integer getZhengDai() {
		return zhengDai;
	}
	public void setZhengDai(Integer zhengDai) {
		this.zhengDai = zhengDai;
		this.zhengDaiStr = HouseCommon.getZhengDaiStr(zhengDai);
	}
	public Integer getTaxation() {
		return taxation;
	}
	public void setTaxation(Integer taxation) {
		this.taxation = taxation;
		this.taxationStr = HouseCommon.getTaxationStr(taxation);
	}
	public String getFukUse() {
		return fukUse;
	}
	public void setFukUse(String fukUse) {
		this.fukUse = fukUse;
	}
	
	public Integer getHouseLevel() {
		return houseLevel;
	}
	public void setHouseLevel(Integer houseLevel) {
		this.houseLevel = houseLevel;
		this.houseLevelStr = HouseCommon.getHouseLevelStr(houseLevel);
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
	public Integer getHjInfoType() {
		return hjInfoType;
	}
	public void setHjInfoType(Integer hjInfoType) {
		this.hjInfoType = hjInfoType;
		this.hjInfoTypeStr = HouseCommon.getHjInfoTypeStr(hjInfoType);
	}
	
	public String getHjInfoTypeStr() {
		return hjInfoTypeStr;
	}
	public void setHjInfoTypeStr(String hjInfoTypeStr) {
		this.hjInfoTypeStr = hjInfoTypeStr;
	}
	public Integer getAssess() {
		return assess;
	}
	public void setAssess(Integer assess) {
		this.assess = assess;
	}
	public Integer getMoveOutType() {
		return moveOutType;
	}
	public void setMoveOutType(Integer moveOutType) {
		this.moveOutType = moveOutType;
		this.moveOutTypeStr = HouseCommon.getMoveOutTypeStr(moveOutType);
	}
	public Integer getTakeEmpty() {
		return takeEmpty;
	}
	public void setTakeEmpty(Integer takeEmpty) {
		this.takeEmpty = takeEmpty;
		this.takeEmptyStr = HouseCommon.getTakeEmptyStr(takeEmpty);
	}
	
	
	public String getHaunted() {
		return haunted;
	}
	public void setHaunted(String haunted) {
		this.haunted = haunted;
	}
	public String getHaunted2() {
		return haunted2;
	}
	public void setHaunted2(String haunted2) {
		this.haunted2 = haunted2;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getLookWayStr() {
		return lookWayStr;
	}
	public void setLookWayStr(String lookWayStr) {
		this.lookWayStr = lookWayStr;
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
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getSellReason() {
		return sellReason;
	}
	public void setSellReason(Integer sellReason) {
		this.sellReason = sellReason;
		this.sellReasonStr = HouseCommon.getSellReasonStr(sellReason);
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBugDemand() {
		return bugDemand;
	}
	public void setBugDemand(String bugDemand) {
		this.bugDemand = bugDemand;
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
	public Integer getDecoradion() {
		return decoradion;
	}
	public void setDecoradion(Integer decoradion) {
		this.decoradion = decoradion;
		this.decoradionStr = HouseCommon.getDecoradionStr(decoradion);
	}
	public String getDecoradionStr() {
		return decoradionStr;
	}
	public void setDecoradionStr(String decoradionStr) {
		this.decoradionStr = decoradionStr;
	}
	public String getDecoradionTimeStr() {
		return decoradionTimeStr;
	}
	public void setDecoradionTimeStr(String decoradionTimeStr) {
		this.decoradionTimeStr = decoradionTimeStr;
	}
	public Integer getDecoradionTime() {
		return decoradionTime;
	}
	public void setDecoradionTime(Integer decoradionTime) {
		this.decoradionTime = decoradionTime;
		this.decoradionTimeStr = HouseCommon.getDecoradionTimeStr(decoradionTime);
	}
	public Integer getPropertyRightType() {
		return propertyRightType;
	}
	public void setPropertyRightType(Integer propertyRightType) {
		this.propertyRightType = propertyRightType;
	}
	public Double getPropertyFee() {
		return propertyFee;
	}
	public void setPropertyFee(Double propertyFee) {
		this.propertyFee = propertyFee;
	}
	public Integer getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Integer buildTime) {
		this.buildTime = buildTime;
	}
	public Integer getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}
	public Double getYield() {
		return yield;
	}
	public void setYield(Double yield) {
		this.yield = yield;
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
	public String getBa1Id() {
		return ba1Id;
	}
	public void setBa1Id(String ba1Id) {
		this.ba1Id = ba1Id;
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
	public String getToiletStr() {
		return toiletStr;
	}
	public void setToiletStr(String toiletStr) {
		this.toiletStr = toiletStr;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getOperator() {
		return operator;
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
	public void setOperator(String operator) {
		this.operator = operator;
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
	public String getLastFollowTime() {
		return lastFollowTime;
	}
	public void setLastFollowTime(String lastFollowTime) {
		this.lastFollowTime = lastFollowTime;
	}
	public String getEduIds() {
		return eduIds;
	}
	public void setEduIds(String eduIds) {
		this.eduIds = eduIds;
	}
	
	public String getPropertyStr() {
		return propertyStr;
	}
	public void setPropertyStr(String propertyStr) {
		this.propertyStr = propertyStr;
	}
	public String getWatchHouseCount() {
		return watchHouseCount;
	}
	public void setWatchHouseCount(String watchHouseCount) {
		this.watchHouseCount = watchHouseCount;
	}
	public Integer getFitManagement() {
		return fitManagement;
	}
	public void setFitManagement(Integer fitManagement) {
		this.fitManagement = fitManagement;
		this.fitManagementStr = HouseCommon.getFitManagementStr(fitManagement);
		
	}
	public String getNearPosition() {
		return nearPosition;
	}
	public void setNearPosition(String nearPosition) {
		this.nearPosition = nearPosition;
	}
	public Integer getOfficeLevel() {
		return officeLevel;
	}
	public void setOfficeLevel(Integer officeLevel) {
		this.officeLevel = officeLevel;
		this.officeLevelStr = HouseCommon.getOfficeLevelStr(officeLevel);
	}
	public Integer getContainPerson() {
		return containPerson;
	}
	public void setContainPerson(Integer containPerson) {
		this.containPerson = containPerson;
	}
	public Integer getToilet() {
		return toilet;
	}
	public void setToilet(Integer toilet) {
		this.toilet = toilet;
		this.toiletStr = HouseCommon.getToiletStr(toilet);
		
	}
	public Integer getCarPortId() {
		return carPortId;
	}
	public void setCarPortId(Integer carPortId) {
		this.carPortId = carPortId;
	}
	public Integer getCarFloor() {
		return carFloor;
	}
	public void setCarFloor(Integer carFloor) {
		this.carFloor = carFloor;
	}
	public String getCarPortType() {
		return carPortType;
	}
	public void setCarPortType(String carPortType) {
		this.carPortType = carPortType;
	}
	public String getParkNum() {
		return parkNum;
	}
	public void setParkNum(String parkNum) {
		this.parkNum = parkNum;
	}
	public Integer getCarPortFloor() {
		return carPortFloor;
	}
	public void setCarPortFloor(Integer carPortFloor) {
		this.carPortFloor = carPortFloor;
	}
	public Integer getCloseBuildingId() {
		return closeBuildingId;
	}
	public void setCloseBuildingId(Integer closeBuildingId) {
		this.closeBuildingId = closeBuildingId;
	}
	public Integer getCarPropertyRightType() {
		return carPropertyRightType;
	}
	public void setCarPropertyRightType(Integer carPropertyRightType) {
		this.carPropertyRightType = carPropertyRightType;
	}
	/**
	 * 房源评价字符串
	 * @return
	 */
	public String getAssessStr(){
		String assessStr = "";
		Integer assess = this.assess;
		if(assess!=null){
			if(assess==1){
				assessStr = "暂不售";
			}else if(assess==2){
				assessStr = "已售";
			}else if(assess==3){
				assessStr = "无效";
			}else if(assess==4){
				assessStr = "待售";
			}else if(assess==5){
				assessStr = "已成交";
			}
		}
		return assessStr;
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
				statusStr = "待售";
			}else if(status==2){
				statusStr = "暂不售";
			}else if(status==3){
				statusStr = "已成交";
			}else{
				statusStr = "错误信息";
			}
		}
		return statusStr;
	}
	
	public String getUseStatusStr(){
		String useStatusStr ="";
		Integer useStatus= this.useStatus;
		if(useStatus!=null){
			if(useStatus==1){
				useStatusStr="闲置";
			}else if(useStatus==2){
				useStatusStr="出租";
			}else{
				useStatusStr="自住";
			}
		}
		return useStatusStr;
	}
}
