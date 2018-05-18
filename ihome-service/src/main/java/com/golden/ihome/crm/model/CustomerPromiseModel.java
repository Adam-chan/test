package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.sql.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * 客源约带看
 * 
 * @author weizhichao
 * 
 */
public class CustomerPromiseModel implements Serializable{

	private static final long serialVersionUID = 131852705126740180L;
	
	/**
	 * id序列
	 */
	private Integer id;
	/**
	 * 客户需求表ID
	 */
	private Integer demandId;
	/**
	 * 客户表ID
	 */
	private Integer customerId;
	/**
	 * 约看时间
	 */
	private Date promiseDate;
	/**
	 * 带看时间
	 */
	private Date takeDate;
	/**
	 * 录入时间
	 */
	private Date createTime;
	/**
	 * 带看类型1房源，2一手楼盘
	 */
	private Integer takeType;
	/**
	 * 录入人
	 */
	private String operateUser;
	/**
	 * 陪看人
	 */
	private String accompany;
	/**
	 * 带看人
	 */
	private String takeUser;
	/**
	 * 状态：1新建，2已带看，3已取消
	 */
	private Integer promiseStatus;
	/**
	 * 房源ID
	 */
	private Integer houseInfoId;
	/**
	 * 楼盘ID
	 */
	private Integer premisesId;
	/**
	 * 需求类型2求租，1求购
	 */
	private Integer demandType;
	/**
	 * 物业类型1住宅，2商铺，3写字楼，4车位
	 */
	private Integer propertyType;
	/**
	 * 需求编号
	 */
	private String demandCode;
	/**
	 * 客户姓名
	 */
	private String customerName;
	/**
	 * 房源编号
	 */
	private String houseCode;
	/**
	 * 业主姓名
	 */
	private String ownerName;
	/**
	 * 总价
	 */
	private Double totalPrice;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 楼盘名称
	 */
	private String premisesName;
	/**
	 * 房源的楼盘名称
	 */
	private String premisesName2;
	/**
	 * 约带看状态：1新建，2已带看，3已取消
	 */
	private Integer promiseDone;
	/**
	 * 回访时间
	 */
	private Date visitTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDemandId() {
		return demandId;
	}
	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}
	public Date getPromiseDate() {
		return promiseDate;
	}
	public void setPromiseDate(Date promiseDate) {
		this.promiseDate = promiseDate;
	}
	public Date getTakeDate() {
		return takeDate;
	}
	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}
	public Integer getTakeType() {
		return takeType;
	}
	public void setTakeType(Integer takeType) {
		this.takeType = takeType;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getAccompany() {
		return accompany;
	}
	public void setAccompany(String accompany) {
		this.accompany = accompany;
	}
	public String getTakeUser() {
		return takeUser;
	}
	public void setTakeUser(String takeUser) {
		this.takeUser = takeUser;
	}
	public Integer getPromiseStatus() {
		return promiseStatus;
	}
	public void setPromiseStatus(Integer promiseStatus) {
		this.promiseStatus = promiseStatus;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获得约看时间
	 * 
	 * @return
	 */
	public String getPromiseDateStr() {
		String promiseDateStr = "";
		if (this.promiseDate == null) {
			return null;
		} else {
			promiseDateStr = DateUtil.getStringByDate(this.promiseDate, "yyyy-MM-dd");
			return promiseDateStr;
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
			createTimeStr = DateUtil.getStringByDate(this.createTime, "yyyy-MM-dd");
			return createTimeStr;
		}
	}
	public Integer getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}
	public Integer getDemandType() {
		return demandType;
	}
	public void setDemandType(Integer demandType) {
		this.demandType = demandType;
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
	 * 获得状态Str状态
	 * @return
	 */
	public String getPromiseStatusStr() {
		String promiseStatusStr = "";
		Integer promiseStatus = this.promiseStatus;
		if (promiseStatus != null) {
			if (promiseStatus == 1) {
				promiseStatusStr = "新建";
			} else if (promiseStatus == 2) {
				promiseStatusStr = "已带看";
			} else if (promiseStatus == 3) {
				promiseStatusStr = "已取消";
			}	
		}
		return promiseStatusStr;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDemandCode() {
		return demandCode;
	}
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	public String getPremisesName2() {
		return premisesName2;
	}
	public void setPremisesName2(String premisesName2) {
		this.premisesName2 = premisesName2;
	}
	public Integer getPromiseDone() {
		return promiseDone;
	}
	public void setPromiseDone(Integer promiseDone) {
		this.promiseDone = promiseDone;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	/**
	 * 获得回访时间
	 * 
	 * @return
	 */
	public String getVisitTimeStr() {
		String visitTimeStr = "";
		if (this.visitTime == null) {
			return null;
		} else {
			visitTimeStr = DateUtil.getStringByDate(this.visitTime, "yyyy-MM-dd");
			return visitTimeStr;
		}
	}

}
