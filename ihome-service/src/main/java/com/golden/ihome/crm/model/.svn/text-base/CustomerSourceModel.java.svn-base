package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.sql.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * 客源管理
 * 
 * @author weizhichao
 * 
 */
public class CustomerSourceModel implements Serializable {

	private static final long serialVersionUID = 3695402795112976081L;
	/**
	 * id序列
	 */
	private Integer id;
	/**
	 * 客户表ID
	 */
	private Integer customerId;
	/**
	 * 需求编号
	 */
	private String demandCode;
	/**
	 * 需求状态：1新信息，2约带看，3再推荐，4意向中，5成交，6放弃，7假信息，8所有有效
	 */
	private Integer demandStatus;
	/**
	 * 需求类型2求租，1求购
	 */
	private Integer demandType;
	/**
	 * 物业类型1住宅，2商铺，3写字楼，4车位
	 */
	private Integer propertyType;
	/**
	 * 客源类型 1私客， 2组公客， 3区公客， 4成交客户池
	 */
	private Integer cdType;
	/**
	 * 紧急程度
	 */
	private Integer demandUrgent;
	/**
	 * 承受价格
	 */
	private Double affordPrice;
	/**
	 * 建筑面积
	 */
	private Double buildArea;
	/**
	 * 室
	 */
	private Integer rooms;
	/**
	 * 厅
	 */
	private Integer office;
	/**
	 * 卫
	 */
	private Integer wc;
	/**
	 * 厨房
	 */
	private Integer balcony;
	/**
	 * 需求区域ID（商圈ID逗号分隔）
	 */
	private String demandRegionIds;
	/**
	 * 需求区域名字（商圈名字逗号分隔）
	 */
	private String demandRegion;
	/**
	 * 需求楼盘ID（楼盘ID逗号分隔）
	 */
	private String demandPremisesIds;
	/**
	 * 需求楼盘名字（楼盘名字逗号分隔）
	 */
	private String demandPremises;
	/**
	 * 入住时间
	 */
	private Date checkInTime;
	/**
	 * 租期,单位月
	 */
	private Integer rentTime;
	/**
	 * 合租意向(1合租，2整租)
	 */
	private String joinRent;
	/**
	 * 付租方式(文字)
	 */
	private String rentWay;
	/**
	 * 押金方式（押一付三）
	 */
	private String deposit;
	/**
	 * 是否了解有服务费1了解，2不了解
	 */
	private Integer serviceCharge;
	/**
	 * 建筑类型（1所有，2高层，3多层，4平房，5别墅，6其他）
	 */
	private String buildType;
	/**
	 * 家电(逗号分隔)
	 */
	private String houseHold;
	/**
	 * 家具(逗号分隔)
	 */
	private String furniture;
	/**
	 * 其它需求
	 */
	private String otherDemand;
	/**
	 * 看房时间段（1下班后，2休息日，3随时）
	 */
	private String takeLookTime;
	/**
	 * 发票抬头
	 */
	private String invoiceHeader;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后操作时间
	 */
	private Date operateTime;
	/**
	 * 操作人（录入人）
	 */
	private String operateUser;
	/**
	 * 是否保护1未保护，2保护
	 */
	private Integer protect;
	/**
	 * 回访状态：1未回访，2已回访
	 */
	private Integer visitStatus;
	/**
	 * 回访时间
	 */
	private Date visitTime;
	/**
	 * 回访人
	 */
	private String visitUser;
	/**
	 * 信息归本店（记录组织结构代码）
	 */
	private String messOwner;
	/**
	 * 朝向：1东2南3西4北5均可
	 */
	private Integer orientation;
	/**
	 * 装修：1毛坯2中装3精装4均可
	 */
	private Integer decoration;
	/**
	 * 客户姓名
	 */
	private String userName;
	/**
	 * 客户电话
	 */
	private String tell;
	/**
	 * 客户性别
	 */
	private String sex;
	/**
	 * 归属部门
	 */
	private String operateOrg;
	/**
	 * 带看时间
	 */
	private Date takeDate;
	/**
	 * 看房次数
	 */
	private Integer isPromised;
	/**
	 * 客户来源(15i5j网站2呼叫中心3店面宣传4ERP外拓5老客户6社区外拓7外网端口8移动平台9其他)
	 */
	private Integer parentSource;
	/**
	 * 客户来源子(太多了...)
	 */
	private Integer childSource;
	/**
	 * 客户评价(1A,2B,3C,4F)
	 */
	private Integer custJudge;
	/**
	 * 楼层要求start
	 */
	private Integer needFloorStart;
	/**
	 * 楼层要求end
	 */
	private Integer needFloorEnd;
	/**
	 * 购房动机(1拆迁2投资3自住4上学5上班6就医7改善8结婚9养老10照顾父母11其他)
	 */
	private String buyMotivation;
	/**
	 * 首付款
	 */
	private Double firstPay;
	/**
	 * 操作人（录入人）ID
	 */
	private String operateUserId;
	/**
	 * 转介接收人
	 */
	private String receiveUser;
	/**
	 * 转介接收人ID
	 */
	private String receiveUserId;
	/**
	 * 房间数start
	 */
	private Integer roomAmountStart;
	/**
	 * 房间数end
	 */
	private Integer roomAmountEnd;
	/**
	 * 房屋性质(1已购公房,2商品房,3使用权房,4经济适用房)
	 */
	private Integer houseProperty;
	/**
	 * 购房资格(1本地,2外地)
	 */
	private Integer buyQualification;
	/**
	 * 付款方式(1商业贷款,2公积金贷款,3公积金+商业贷款)
	 */
	private Integer payment;
	/**
	 * 是否卖旧买新(1是,2否)
	 */
	private Integer selloldBuynew;
	/**
	 * 物管费start
	 */
	private Double propertyFeeStart;
	/**
	 * 物管费end
	 */
	private Double propertyFeeEnd;
	/**
	 * 承受价位单位(1:元/月,2:元/平/天)
	 */
	private Integer affordPriceUnit;
	/**
	 * 购房资格子(1首套,2二套,3二套以上)
	 */
	private Integer buyQualification2;
	/**
	 * 门宽start
	 */
	private Double doorWidthStart;
	/**
	 * 门宽end
	 */
	private Double doorWidthEnd;
	/**
	 * 房高start
	 */
	private Double houseHeightStart;
	/**
	 * 房高end
	 */
	private Double houseHeightEnd;
	/**
	 * 位置类型(1商业街临街,2市场,3社区,4建筑底层,5商城,6交通设施,7可做餐饮,8可明火)
	 */
	private String locationType;
	/**
	 * 楼层要求(已废)
	 */
	private Integer needFloor;
	/**
	 * 佣金发票
	 */
	private Integer invoiceType1;
	/**
	 * 租金发票
	 */
	private Integer invoiceType2;
	/**
	 * 贷款金额
	 */
	private Double loanMoney;
	/**
	 * 贷款时长
	 */
	private Integer loanTerm;
	/**
	 * 金融业务类型(1房屋抵押业务,2企业贷款业务,3金融垫资业务,4客户理财咨询)
	 */
	private Integer financeType;
	/**
	 * 每期还款金额
	 */
	private Double repayment;
	/**
	 * 看房经历
	 */
	private Integer viewHome;
	/**
	 * 是否被保护1是2否
	 */
	private Integer isProtected;
	/**
	 * 佣金比例
	 */
	private Double rate;
	/**
	 * 客源转介状态
	 */
	private Integer transferStatus;
	/**
	 * 客源转介的客源id
	 */
	private Integer transferDemandId;
	/**
	 * 客源转介id
	 */
	private Integer transferId;
	/**
	 * 看房总量
	 */
	private Integer promisedCount;
	/**
	 * 跟进时间
	 */
	private String visiteTimeStr;
	/**
	 * 成交原因
	 */
	private String dealReason;
	/**
	 * 所属部门名称
	 */
	private String orgName;
	/**
	 * 评价（字符串）
	 */
	private String custJudge2;

	public String getCustJudge2() {
		return custJudge2;
	}

	public void setCustJudge2(String custJudge2) {
		this.custJudge2 = custJudge2;
	}

	public String getDealReason() {
		return dealReason;
	}

	public void setDealReason(String dealReason) {
		this.dealReason = dealReason;
	}

	public String getVisiteTimeStr() {
		return visiteTimeStr;
	}

	public void setVisiteTimeStr(String visiteTimeStr) {
		this.visiteTimeStr = visiteTimeStr;
	}

	public Integer getPromisedCount() {
		return promisedCount;
	}

	public void setPromisedCount(Integer promisedCount) {
		this.promisedCount = promisedCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDemandCode() {
		return demandCode;
	}

	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}

	public Integer getDemandStatus() {
		return demandStatus;
	}

	public void setDemandStatus(Integer demandStatus) {
		this.demandStatus = demandStatus;
	}

	public Integer getDemandType() {
		return demandType;
	}

	public void setDemandType(Integer demandType) {
		this.demandType = demandType;
	}

	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getDemandUrgent() {
		return demandUrgent;
	}

	public void setDemandUrgent(Integer demandUrgent) {
		this.demandUrgent = demandUrgent;
	}

	public Double getAffordPrice() {
		return affordPrice;
	}

	public void setAffordPrice(Double affordPrice) {
		this.affordPrice = affordPrice;
	}

	public Double getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(Double buildArea) {
		this.buildArea = buildArea;
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

	public String getDemandRegionIds() {
		return demandRegionIds;
	}

	public void setDemandRegionIds(String demandRegionIds) {
		this.demandRegionIds = demandRegionIds;
	}

	public String getDemandRegion() {
		return demandRegion;
	}

	public void setDemandRegion(String demandRegion) {
		this.demandRegion = demandRegion;
	}

	public String getDemandPremisesIds() {
		return demandPremisesIds;
	}

	public void setDemandPremisesIds(String demandPremisesIds) {
		this.demandPremisesIds = demandPremisesIds;
	}

	public String getDemandPremises() {
		return demandPremises;
	}

	public void setDemandPremises(String demandPremises) {
		this.demandPremises = demandPremises;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Integer getRentTime() {
		return rentTime;
	}

	public void setRentTime(Integer rentTime) {
		this.rentTime = rentTime;
	}

	public String getJoinRent() {
		return joinRent;
	}

	public void setJoinRent(String joinRent) {
		this.joinRent = joinRent;
	}

	public String getRentWay() {
		return rentWay;
	}

	public void setRentWay(String rentWay) {
		this.rentWay = rentWay;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public Integer getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Integer serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getHouseHold() {
		return houseHold;
	}

	public void setHouseHold(String houseHold) {
		this.houseHold = houseHold;
	}

	public String getFurniture() {
		return furniture;
	}

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}

	public String getOtherDemand() {
		return otherDemand;
	}

	public void setOtherDemand(String otherDemand) {
		this.otherDemand = otherDemand;
	}

	public String getTakeLookTime() {
		return takeLookTime;
	}

	public void setTakeLookTime(String takeLookTime) {
		this.takeLookTime = takeLookTime;
	}

	public String getInvoiceHeader() {
		return invoiceHeader;
	}

	public void setInvoiceHeader(String invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Integer getProtect() {
		return protect;
	}

	public void setProtect(Integer protect) {
		this.protect = protect;
	}

	public Integer getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(Integer visitStatus) {
		this.visitStatus = visitStatus;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitUser() {
		return visitUser;
	}

	public void setVisitUser(String visitUser) {
		this.visitUser = visitUser;
	}

	public String getMessOwner() {
		return messOwner;
	}

	public void setMessOwner(String messOwner) {
		this.messOwner = messOwner;
	}

	public Integer getDecoration() {
		return decoration;
	}

	public void setDecoration(Integer decoration) {
		this.decoration = decoration;
	}

	public Integer getOrientation() {
		return orientation;
	}

	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}

	public String getOperateUserId() {
		return operateUserId;
	}

	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}

	public Integer getRoomAmountStart() {
		return roomAmountStart;
	}

	public void setRoomAmountStart(Integer roomAmountStart) {
		this.roomAmountStart = roomAmountStart;
	}

	public Integer getRoomAmountEnd() {
		return roomAmountEnd;
	}

	public void setRoomAmountEnd(Integer roomAmountEnd) {
		this.roomAmountEnd = roomAmountEnd;
	}

	public Integer getHouseProperty() {
		return houseProperty;
	}

	public void setHouseProperty(Integer houseProperty) {
		this.houseProperty = houseProperty;
	}

	public Integer getBuyQualification() {
		return buyQualification;
	}

	public void setBuyQualification(Integer buyQualification) {
		this.buyQualification = buyQualification;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public Integer getSelloldBuynew() {
		return selloldBuynew;
	}

	public void setSelloldBuynew(Integer selloldBuynew) {
		this.selloldBuynew = selloldBuynew;
	}

	public Double getPropertyFeeStart() {
		return propertyFeeStart;
	}

	public void setPropertyFeeStart(Double propertyFeeStart) {
		this.propertyFeeStart = propertyFeeStart;
	}

	public Double getPropertyFeeEnd() {
		return propertyFeeEnd;
	}

	public void setPropertyFeeEnd(Double propertyFeeEnd) {
		this.propertyFeeEnd = propertyFeeEnd;
	}

	public Integer getAffordPriceUnit() {
		return affordPriceUnit;
	}

	public void setAffordPriceUnit(Integer affordPriceUnit) {
		this.affordPriceUnit = affordPriceUnit;
	}

	public Integer getBuyQualification2() {
		return buyQualification2;
	}

	public void setBuyQualification2(Integer buyQualification2) {
		this.buyQualification2 = buyQualification2;
	}

	public Double getDoorWidthStart() {
		return doorWidthStart;
	}

	public void setDoorWidthStart(Double doorWidthStart) {
		this.doorWidthStart = doorWidthStart;
	}

	public Double getDoorWidthEnd() {
		return doorWidthEnd;
	}

	public void setDoorWidthEnd(Double doorWidthEnd) {
		this.doorWidthEnd = doorWidthEnd;
	}

	public Double getHouseHeightStart() {
		return houseHeightStart;
	}

	public void setHouseHeightStart(Double houseHeightStart) {
		this.houseHeightStart = houseHeightStart;
	}

	public Double getHouseHeightEnd() {
		return houseHeightEnd;
	}

	public void setHouseHeightEnd(Double houseHeightEnd) {
		this.houseHeightEnd = houseHeightEnd;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public Integer getNeedFloor() {
		return needFloor;
	}

	public void setNeedFloor(Integer needFloor) {
		this.needFloor = needFloor;
	}

	public Integer getInvoiceType1() {
		return invoiceType1;
	}

	public void setInvoiceType1(Integer invoiceType1) {
		this.invoiceType1 = invoiceType1;
	}

	public Integer getInvoiceType2() {
		return invoiceType2;
	}

	public void setInvoiceType2(Integer invoiceType2) {
		this.invoiceType2 = invoiceType2;
	}

	public Double getLoanMoney() {
		return loanMoney;
	}

	public void setLoanMoney(Double loanMoney) {
		this.loanMoney = loanMoney;
	}

	public Integer getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(Integer loanTerm) {
		this.loanTerm = loanTerm;
	}

	public Integer getFinanceType() {
		return financeType;
	}

	public void setFinanceType(Integer financeType) {
		this.financeType = financeType;
	}

	public Double getRepayment() {
		return repayment;
	}

	public void setRepayment(Double repayment) {
		this.repayment = repayment;
	}

	public Integer getViewHome() {
		return viewHome;
	}

	public void setViewHome(Integer viewHome) {
		this.viewHome = viewHome;
	}

	/**
	 * 紧急程度
	 * 
	 * @return
	 */
	public String getDemandUrgentStr() {
		String demandUrgentStr = "";
		Integer demandUrgent = this.demandUrgent;
		if (demandUrgent != null) {
			if (demandUrgent == 1) {
				demandUrgentStr = "1个月内";
			} else if (demandUrgent == 2) {
				demandUrgentStr = "1~3个月";
			} else if (demandUrgent == 3) {
				demandUrgentStr = "3个月以上";
			}
		}
		return demandUrgentStr;
	}

	/**
	 * 装修
	 * 
	 * @return
	 */
	public String getDecorationStr() {
		String decorationStr = "";
		Integer decoration = this.decoration;
		if (decoration != null) {
			if (decoration == 1) {
				decorationStr = "毛坯";
			} else if (decoration == 2) {
				decorationStr = "中装";
			} else if (decoration == 3) {
				decorationStr = "精装";
			} else if (decoration == 4) {
				decorationStr = "均可";
			}
		}
		return decorationStr;
	}

	/**
	 * 朝向
	 * 
	 * @return
	 */
	public String getOrientationStr() {
		String orientationStr = "";
		Integer orientation = this.orientation;
		if (orientation != null) {
			if (orientation == 1) {
				orientationStr = "东";
			} else if (orientation == 2) {
				orientationStr = "南";
			} else if (orientation == 3) {
				orientationStr = "西";
			} else if (orientation == 4) {
				orientationStr = "北";
			} else if (orientation == 5) {
				orientationStr = "均可";
			}
		}
		return orientationStr;
	}


	/**
	 * 租赁方式
	 * 
	 * @return
	 */
	public String getJoinRentStr() {
		String joinRentStr = "";
		String joinRent = this.joinRent;
		if (joinRent != null) {
			if ("1".equals(joinRent)) {
				joinRentStr = "均可";
			} else if ("2".equals(joinRent)) {
				joinRentStr = "可合租";
			}else if ("3".equals(joinRent)) {
				joinRentStr = "不愿合租";
			}
		}
		return joinRentStr;
	}

	/**
	 * 获得最后跟进时间
	 * 
	 * @return
	 */
	public String getOperateTimeStr() {
		String operateTimeStr = "";
		if (this.operateTime == null) {
			return null;
		} else {
			operateTimeStr = DateUtil.getStringByDate(this.operateTime,
					"yyyy-MM-dd");
			return operateTimeStr;
		}
	}

	/**
	 * 获得录入时间
	 * 
	 * @return
	 */
	public String getCreateTimeStr() {
		String createTimeStr = "";
		if (this.createTime == null) {
			return null;
		} else {
			createTimeStr = DateUtil.getStringByDate(this.createTime,
					"yyyy-MM-dd");
			return createTimeStr;
		}
	}

	/**
	 * 获得带看时间
	 * 
	 * @return
	 */
	public String getTakeDateStr() {
		String takeDateStr = "";
		if (this.takeDate == null) {
			return null;
		} else {
			takeDateStr = DateUtil.getStringByDate(this.takeDate, "yyyy-MM-dd");
			return takeDateStr;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOperateOrg() {
		return operateOrg;
	}

	public void setOperateOrg(String operateOrg) {
		this.operateOrg = operateOrg;
	}

	public Date getTakeDate() {
		return takeDate;
	}

	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}

	public Integer getIsPromised() {
		return isPromised;
	}

	public void setIsPromised(Integer isPromised) {
		this.isPromised = isPromised;
	}

	public Integer getParentSource() {
		return parentSource;
	}

	public void setParentSource(Integer parentSource) {
		this.parentSource = parentSource;
	}

	public Integer getChildSource() {
		return childSource;
	}

	public void setChildSource(Integer childSource) {
		this.childSource = childSource;
	}

//	/**
//	 * 建筑类型
//	 * 
//	 * @return
//	 */
//	public String getBuildTypeStr() {
//		String buildTypeStr = "";
//		String buildType = this.buildType;
//		if (buildType != null) {
//			if ("1".equals(buildType)) {
//				buildTypeStr = "所有";
//			} else if ("2".equals(buildType)) {
//				buildTypeStr = "高层";
//			} else if ("3".equals(buildType)) {
//				buildTypeStr = "多层";
//			} else if ("4".equals(buildType)) {
//				buildTypeStr = "平房";
//			} else if ("5".equals(buildType)) {
//				buildTypeStr = "别墅";
//			} else if ("6".equals(buildType)) {
//				buildTypeStr = "其他";
//			}
//		}
//		return buildTypeStr;
//	}

	public Integer getCustJudge() {
		return custJudge;
	}

	public void setCustJudge(Integer custJudge) {
		this.custJudge = custJudge;
	}

	/**
	 * 获得客户评价
	 * 
	 * @return
	 */
	public String getCustJudgeStr() {
		String custJudgeStr = "";
		Integer custJudge = this.custJudge;
		if (custJudge != null) {
			if (custJudge == 1) {
				custJudgeStr = "A";
			} else if (custJudge == 2) {
				custJudgeStr = "B";
			} else if (custJudge == 3) {
				custJudgeStr = "C";
			} else if (custJudge == 4) {
				custJudgeStr = "F";
			} else if (custJudge == 0) {
				custJudgeStr = "无";
			}
		}
		return custJudgeStr;
	}
	
	/**
	 * 获得需求状态
	 * 
	 * @return
	 */
	public String getDemandStatusStr() {
		String demandStatusStr = "";
		Integer demandStatus = this.demandStatus;
		if (demandStatus != null) {
			if (demandStatus == 1) {
				demandStatusStr = "新信息";
			} else if (demandStatus == 2) {
				demandStatusStr = "约带看";
			} else if (demandStatus == 3) {
				demandStatusStr = "再推荐";
			} else if (demandStatus == 4) {
				demandStatusStr = "意向中";
			} else if (demandStatus == 5) {
				demandStatusStr = "成交";
			} else if (demandStatus == 6) {
				demandStatusStr = "放弃";
			} else if (demandStatus == 7) {
				demandStatusStr = "假信息";
			}
		}
		return demandStatusStr;
	}
	
//	/**
//	 * 获得购房动机
//	 * 
//	 * @return
//	 */
//	public String getBuyMotivationStr() {
//		String buyMotivationStr = "";
//		Integer buyMotivation = this.buyMotivation;
//		if (buyMotivation != null) {
//			if (buyMotivation == 1) {
//				buyMotivationStr = "拆迁";
//			} else if (buyMotivation == 2) {
//				buyMotivationStr = "投资";
//			} else if (buyMotivation == 3) {
//				buyMotivationStr = "自住";
//			} else if (buyMotivation == 4) {
//				buyMotivationStr = "上学";
//			} else if (buyMotivation == 5) {
//				buyMotivationStr = "上班";
//			}else if (buyMotivation == 6) {
//				buyMotivationStr = "就医";
//			}else if (buyMotivation == 7) {
//				buyMotivationStr = "改善";
//			}else if (buyMotivation == 8) {
//				buyMotivationStr = "结婚";
//			}else if (buyMotivation == 9) {
//				buyMotivationStr = "养老";
//			}else if (buyMotivation == 10) {
//				buyMotivationStr = "照顾父母";
//			}else if (buyMotivation == 11) {
//				buyMotivationStr = "其他";
//			}
//		}
//		return buyMotivationStr;
//	}

	public Integer getNeedFloorStart() {
		return needFloorStart;
	}

	public void setNeedFloorStart(Integer needFloorStart) {
		this.needFloorStart = needFloorStart;
	}

	public Integer getNeedFloorEnd() {
		return needFloorEnd;
	}

	public void setNeedFloorEnd(Integer needFloorEnd) {
		this.needFloorEnd = needFloorEnd;
	}

	public String getBuyMotivation() {
		return buyMotivation;
	}

	public void setBuyMotivation(String buyMotivation) {
		this.buyMotivation = buyMotivation;
	}

	public Double getFirstPay() {
		return firstPay;
	}

	public void setFirstPay(Double firstPay) {
		this.firstPay = firstPay;
	}
	
	/**
	 * 获得客户来源1Str
	 * @return
	 */
	public String getParentSourceStr() {
		String parentSourceStr = "";
		Integer parentSource = this.parentSource;
		if (parentSource != null) {
			if (parentSource == 1) {
				parentSourceStr = "5i5j网站";
			} else if (parentSource == 2) {
				parentSourceStr = "呼叫中心";
			} else if (parentSource == 3) {
				parentSourceStr = "店面宣传";
			} else if (parentSource == 4) {
				parentSourceStr = "ERP外拓";
			} else if (parentSource == 5) {
				parentSourceStr = "老客户";
			} else if (parentSource == 6) {
				parentSourceStr = "社区外拓";
			} else if (parentSource == 7) {
				parentSourceStr = "外网端口";
			} else if (parentSource == 8) {
				parentSourceStr = "移动平台";
			} else if (parentSource == 9) {
				parentSourceStr = "其他";
			}
		}
		return parentSourceStr;
	}	
	/**
	 * 获得客户来源2Str
	 * @return
	 */
	public String getChildSourceStr() {
		String childSourceStr = "";
		Integer childSource = this.childSource;
		Integer parentSource = this.parentSource;
		if(parentSource!=null){
			if(parentSource == 1){
				childSourceStr = "5i5j网站";
			} else if(parentSource == 2){
				childSourceStr = "我要屋热线(4008)";
			} else if(parentSource == 3){
				if (childSource != null) {
					if (childSource == 1) {
						childSourceStr = "店面LED展板";
					} else if (childSource == 2) {
						childSourceStr = "店面滚动条";
					} else if (childSource == 3) {
						childSourceStr = "店面灯箱";
					} else if (childSource == 4) {
						childSourceStr = "其它";
					}
				}
			} else if(parentSource == 4){
				childSourceStr = "洗盘";
			} else if(parentSource == 5){
				if (childSource != null) {
					if (childSource == 1) {
						childSourceStr = "老客户再委托";
					} else if (childSource == 2) {
						childSourceStr = "老客户推荐";
					}
				}
			} else if(parentSource == 6){
				if (childSource != null) {
					if (childSource == 1) {
						childSourceStr = "社区活动";
					} else if (childSource == 2) {
						childSourceStr = "社区驻守";
					} else if (childSource == 3) {
						childSourceStr = "社区填单";
					} else if (childSource == 4) {
						childSourceStr = "社区海报";
					} else if (childSource == 5) {
						childSourceStr = "切客";
					} else if (childSource == 6) {
						childSourceStr = "其它";
					}
				}
			} else if(parentSource == 7){
				if (childSource != null) {
					if (childSource == 1) {
						childSourceStr = "安居客";
					} else if (childSource == 2) {
						childSourceStr = "新浪";
					} else if (childSource == 3) {
						childSourceStr = "焦点";
					} else if (childSource == 4) {
						childSourceStr = "58同城";
					} else if (childSource == 5) {
						childSourceStr = "端口开发";
					} else if (childSource == 6) {
						childSourceStr = "其它";
					}
				}
			} else if(parentSource == 8){
				if (childSource != null) {
					if (childSource == 1) {
						childSourceStr = "官方微博";
					} else if (childSource == 2) {
						childSourceStr = "官方微信";
					} else if (childSource == 3) {
						childSourceStr = "个人微信";
					} else if (childSource == 4) {
						childSourceStr = "个人微博";
					} else if (childSource == 5) {
						childSourceStr = "找房吧APP";
					} else if (childSource == 6) {
						childSourceStr = "其它APP";
					}
				}
			} else if(parentSource == 9){
				if (childSource != null) {
					if (childSource == 1) {
						childSourceStr = "企事业单位合作";
					} else if (childSource == 2) {
						childSourceStr = "房展会";
					} else if (childSource == 3) {
						childSourceStr = "外场讲座 活动";
					} else if (childSource == 4) {
						childSourceStr = "朋友 同事介绍";
					} else if (childSource == 5) {
						childSourceStr = "其它";
					}
				}
			}

		}
		return childSourceStr;
	}
	
	/**
	 * 获得房屋性质Str
	 * @return
	 */
	public String getHousePropertyStr() {
		String housePropertyStr = "";
		Integer houseProperty = this.houseProperty;
		if (houseProperty != null) {
			if (houseProperty == 1) {
				housePropertyStr = "已购公房";
			} else if (houseProperty == 2) {
				housePropertyStr = "商品房";
			} else if (houseProperty == 3) {
				housePropertyStr = "使用权房";
			} else if (houseProperty == 4) {
				housePropertyStr = "经济适用房";
			}
		}
		return housePropertyStr;
	}
	
	/**
	 * 获得购房资格Str
	 * @return
	 */
	public String getHuyQualificationStr() {
		String buyQualificationStr = "";
		Integer buyQualification = this.buyQualification;
		if (buyQualification != null) {
			if (buyQualification == 1) {
				buyQualificationStr = "本地";
			} else if (buyQualification == 2) {
				buyQualificationStr = "外地";
			}
		}
		return buyQualificationStr;
	}
	/**
	 * 获得付款方式Str
	 * @return
	 */
	public String getPaymentStr() {
		String paymentStr = "";
		Integer payment = this.payment;
		if (payment != null) {
			if (payment == 1) {
				paymentStr = "商业贷款";
			} else if (payment == 2) {
				paymentStr = "公积金贷款";
			} else if (payment == 3) {
				paymentStr = "公积金+商业贷款";
			}
		}
		return paymentStr;
	}

	/**
	 * 获得是否卖旧买新Str
	 * @return
	 */
	public String getSelloldBuynewStr() {
		String selloldBuynewStr = "";
		Integer selloldBuynew = this.selloldBuynew;
		if (selloldBuynew != null) {
			if (selloldBuynew == 1) {
				selloldBuynewStr = "是";
			} else if (selloldBuynew == 2) {
				selloldBuynewStr = "否";
			}
		}
		return selloldBuynewStr;
	}
	
	/**
	 * 获得承受价位单位Str
	 * @return
	 */
	public String getAffordPriceUnitStr() {
		String affordPriceUnitStr = "";
		Integer affordPriceUnit = this.affordPriceUnit;
		if (affordPriceUnit != null) {
			if (affordPriceUnit == 1) {
				affordPriceUnitStr = "元/月";
			} else if (affordPriceUnit == 2) {
				affordPriceUnitStr = "元/平/天";
			}
		}
		return affordPriceUnitStr;
	}
	
	/**
	 * 获得购房资格Str
	 * @return
	 */
	public String getBuyQualificationStr() {
		String buyQualificationStr = "";
		Integer buyQualification = this.buyQualification;
		if (buyQualification != null) {
			if (buyQualification == 1) {
				buyQualificationStr = "本地";
			} else if (buyQualification == 2) {
				buyQualificationStr = "外地";
			}
		}
		return buyQualificationStr;
	}
	
	/**
	 * 获得购房资格子Str
	 * @return
	 */
	public String getBuyQualification2Str() {
		String buyQualification2Str = "";
		Integer buyQualification2 = this.buyQualification2;
		if (buyQualification2 != null) {
			if (buyQualification2 == 1) {
				buyQualification2Str = "首套";
			} else if (buyQualification2 == 2) {
				buyQualification2Str = "二套";
			} else if (buyQualification2 == 3) {
				buyQualification2Str = "二套以上";
			}
		}
		return buyQualification2Str;
	}
	
	/**
	 * 获得佣金发票Str
	 * @return
	 */
	public String getInvoiceType1Str() {
		String invoiceType1Str = "";
		Integer invoiceType1 = this.invoiceType1;
		if (invoiceType1 != null) {
			if (invoiceType1 == 1) {
				invoiceType1Str = "佣金发票";
			}
		}
		return invoiceType1Str;
	}	
	/**
	 * 获得租金发票Str
	 * @return
	 */
	public String getInvoiceType2Str() {
		String invoiceType2Str = "";
		Integer invoiceType2 = this.invoiceType2;
		if (invoiceType2 != null) {
			if (invoiceType2 == 1) {
				invoiceType2Str = "佣金发票";
			}
		}
		return invoiceType2Str;
	}

	/**
	 * 获得金融业务类型Str
	 * @return
	 */
	public String getFinanceTypeStr() {
		String financeTypeStr = "";
		Integer financeType = this.financeType;
		if (financeType != null) {
			if (financeType == 1) {
				financeTypeStr = "房屋抵押业务";
			} else if (financeType == 2) {
				financeTypeStr = "企业贷款业务";
			} else if (financeType == 3) {
				financeTypeStr = "金融垫资业务";
			} else if (financeType == 4) {
				financeTypeStr = "客户理财咨询";
			}
		}
		return financeTypeStr;
	}

	/**
	 * 获得需求类型Str
	 * @return
	 */
	public String getDemandTypeStr() {
		String demandTypeStr = "";
		Integer demandType = this.demandType;
		if (demandType != null) {
			if (demandType == 2) {
				demandTypeStr = "求租";
			} else if (demandType == 1) {
				demandTypeStr = "求购";
			}
		}
		return demandTypeStr;
	}

	/**
	 * 获得需求类型Str
	 * @return
	 */
	public String getPropertyTypeStr() {
		String propertyTypeStr = "";
		Integer propertyType = this.propertyType;
		if (propertyType != null) {
			if (propertyType == 1) {
				propertyTypeStr = "住宅";
			} else if (propertyType == 2) {
				propertyTypeStr = "商铺";
			} else if (propertyType == 3) {
				propertyTypeStr = "写字楼";
			} else if (propertyType == 4) {
				propertyTypeStr = "车位";
			} 
		}
		return propertyTypeStr;
	}

	/**
	 * 获得入住时间Str
	 * @return
	 */
	public String getCheckInTimeStr() {
		if (this.checkInTime == null) {
			return null;
		} else {
			return DateUtil.getStringByDate(this.checkInTime,
					"yyyy-MM-dd");
		}
	}

	/**
	 * 获得付租方式Str
	 * @return
	 */
	public String getRentWayStr() {
		String rentWayStr = "";
		String rentWay = this.rentWay;
		if (rentWay != null) {
			if ("1".equals(rentWay)) {
				rentWayStr = "季付";
			} else if ("2".equals(rentWay)) {
				rentWayStr = "月付";
			} else if ("3".equals(rentWay)) {
				rentWayStr = "年付";
			}
		}
		return rentWayStr;
	}

	/**
	 * 获得押金方式Str
	 * @return
	 */
	public String getDepositStr() {
		String depositStr = "";
		String deposit = this.deposit;
		if (deposit != null) {
			if ("1".equals(deposit)) {
				depositStr = "一个月";
			} else if ("2".equals(deposit)) {
				depositStr = "三个月";
			}
		}
		return depositStr;
	}
	
	/**
	 * 获得服务费Str
	 * @return
	 */
	public String getServiceChargeStr() {
		String serviceChargeStr = "";
		Integer serviceCharge = this.serviceCharge;
		if (serviceCharge != null) {
			if (serviceCharge == 1) {
				serviceChargeStr = "了解";
			} else if (serviceCharge == 2) {
				serviceChargeStr = "不了解";
			}
		}
		return serviceChargeStr;
	}
	
	/**
	 * 获得其它需求Str
	 * @return
	 */
	public String getOtherDemandStr() {
		String otherDemandStr = "";
		String otherDemand = this.otherDemand;
		if (otherDemand != null) {
			if ("1".equals(otherDemand)) {
				otherDemandStr = "开发票";
			} else if ("2".equals(otherDemand)) {
				otherDemandStr = "不开发票";
			}
		}
		return otherDemandStr;
	}	
	
	/**
	 * 获得家电Str
	 * @return
	 */
	public String getHouseHoldStr() {
		String houseHoldStr = "";
		String houseHold = this.houseHold;
		if (houseHold != null) {
			String[] strArray = houseHold.split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] != null) {
					if ("1".equals(strArray[i])) {
						houseHoldStr += "电视、";
					} else if ("2".equals(strArray[i])) {
						houseHoldStr += "冰箱、";
					} else if ("3".equals(strArray[i])) {
						houseHoldStr += "电话、";
					} else if ("4".equals(strArray[i])) {
						houseHoldStr += "空调、";
					} else if ("5".equals(strArray[i])) {
						houseHoldStr += "洗衣机、";
					}
				}
			}
			houseHoldStr = houseHoldStr.substring(0,houseHoldStr.length()-1);
		}
		return houseHoldStr;
	}	
	
	/**
	 * 获得家具Str
	 * @return
	 */
	public String getFurnitureStr() {
		String furnitureStr = "";
		String furniture = this.furniture;
		if (furniture != null) {
			String[] strArray = furniture.split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] != null) {
					if ("1".equals(strArray[i])) {
						furnitureStr += "床、";
					} else if ("2".equals(strArray[i])) {
						furnitureStr += "沙发、";
					} else if ("3".equals(strArray[i])) {
						furnitureStr += "桌子、";
					} else if ("4".equals(strArray[i])) {
						furnitureStr += "电视柜、";
					}
				}
			}
			furnitureStr = furnitureStr.substring(0,furnitureStr.length()-1);
		}
		return furnitureStr;
	}
	
	/**
	 * 获得所需楼型Str
	 * @return
	 */
	public String getBuildTypeStr() {
		String buildTypeStr = "";
		String buildType = this.buildType;
		if (buildType != null) {
			String[] strArray = buildType.split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] != null) {
					if (strArray[i].equals("1")) {
						buildTypeStr += "高层、";
					} else if ("2".equals(strArray[i])) {
						buildTypeStr += "多层、";
					} else if ("3".equals(strArray[i])) {
						buildTypeStr += "平房、";
					} else if ("4".equals(strArray[i])) {
						buildTypeStr += "别墅、";
					} else if ("5".equals(strArray[i])) {
						buildTypeStr += "其它、";
					} else if ("6".equals(strArray[i])) {
						buildTypeStr += "均可、";
					}
				}
			}
			buildTypeStr = buildTypeStr.substring(0,buildTypeStr.length()-1);
		}
		return buildTypeStr;
	}
	/**
	 * 获得方便看房时间Str
	 * @return
	 */
	public String getTakeLookTimeStr() {
		String takeLookTimeStr = "";
		String takeLookTime = this.takeLookTime;
		if (takeLookTime != null) {
			String[] strArray = takeLookTime.split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] != null) {
					if (strArray[i].equals("1")) {
						takeLookTimeStr += "下班后、";
					} else if ("2".equals(strArray[i])) {
						takeLookTimeStr += "休息日、";
					} else if ("3".equals(strArray[i])) {
						takeLookTimeStr += "随时、";
					}
				}
			}
			takeLookTimeStr = takeLookTimeStr.substring(0,takeLookTimeStr.length()-1);
		}
		return takeLookTimeStr;
	}
	
	/**
	 * 获得购房动机Str
	 * @return
	 */
	public String getBuyMotivationStr() {
		String buyMotivationStr = "";
		String buyMotivation = this.buyMotivation;
		if (buyMotivation != null) {
			String[] strArray = buyMotivation.split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] != null) {
					if (strArray[i].equals("1")) {
						buyMotivationStr += "拆迁、";
					} else if ("2".equals(strArray[i])) {
						buyMotivationStr += "投资、";
					} else if ("3".equals(strArray[i])) {
						buyMotivationStr += "自住、";
					} else if ("4".equals(strArray[i])) {
						buyMotivationStr += "上学、";
					} else if ("5".equals(strArray[i])) {
						buyMotivationStr += "上班、";
					} else if ("6".equals(strArray[i])) {
						buyMotivationStr += "就医、";
					} else if ("7".equals(strArray[i])) {
						buyMotivationStr += "改善、";
					} else if ("8".equals(strArray[i])) {
						buyMotivationStr += "结婚、";
					} else if ("9".equals(strArray[i])) {
						buyMotivationStr += "养老、";
					} else if ("10".equals(strArray[i])) {
						buyMotivationStr += "照顾父母、";
					} else if ("11".equals(strArray[i])) {
						buyMotivationStr += "其它、";
					}
				}
			}
			buyMotivationStr = buyMotivationStr.substring(0,buyMotivationStr.length()-1);
		}
		return buyMotivationStr;
	}
	
	/**
	 * 获得位置类型Str
	 * @return
	 */
	public String getLocationTypeStr() {
		String locationTypeStr = "";
		String locationType = this.locationType;
		if (locationType != null) {
			String[] strArray = locationType.split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] != null) {
					if ("1".equals(strArray[i])) {
						locationTypeStr += "商业街临街、";
					} else if ("2".equals(strArray[i])) {
						locationTypeStr += "市场、";
					} else if ("3".equals(strArray[i])) {
						locationTypeStr += "社区、";
					} else if ("4".equals(strArray[i])) {
						locationTypeStr += "建筑底层、";
					} else if ("5".equals(strArray[i])) {
						locationTypeStr += "商城、";
					} else if ("6".equals(strArray[i])) {
						locationTypeStr += "交通设施、";
					} else if ("7".equals(strArray[i])) {
						locationTypeStr += "可做餐饮、";
					} else if ("8".equals(strArray[i])) {
						locationTypeStr += "可明火、";
					}
				}
			}
			locationTypeStr = locationTypeStr.substring(0,locationTypeStr.length()-1);
		}
		return locationTypeStr;
	}

	/**
	 * 获得性别Str
	 * @return
	 */
	public String getSexStr() {
		String sexStr = "";
		String sex = this.sex;
		if (sex != null) {
			if ("1".equals(sex)) {
				sexStr = "男";
			} else if ("2".equals(sex)) {
				sexStr = "女";
			} 
		}
		return sexStr;
	}
	
	/**
	 * 获得户型Str
	 * @return
	 */
	public String getLayoutStr() {
		String layoutStr = "";	
		Integer rooms = this.rooms;
		Integer office = this.office;
		Integer wc = this.wc;
		Integer balcony = this.balcony;
		if (rooms != null) {
			layoutStr += rooms.toString()+"室";
		}
		if (office != null) {
			layoutStr += office.toString()+"厅";
		}
		if (wc != null) {
			layoutStr += wc.toString()+"卫";
		}
		if (balcony != null) {
			layoutStr += balcony.toString()+"厨";
		}
		return layoutStr;
	}

	public Integer getIsProtected() {
		return isProtected;
	}

	public void setIsProtected(Integer isProtected) {
		this.isProtected = isProtected;
	}

	public Integer getCdType() {
		return cdType;
	}

	public void setCdType(Integer cdType) {
		this.cdType = cdType;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(Integer transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public Integer getTransferDemandId() {
		return transferDemandId;
	}

	public void setTransferDemandId(Integer transferDemandId) {
		this.transferDemandId = transferDemandId;
	}

	public Integer getTransferId() {
		return transferId;
	}

	public void setTransferId(Integer transferId) {
		this.transferId = transferId;
	}

	public String getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
