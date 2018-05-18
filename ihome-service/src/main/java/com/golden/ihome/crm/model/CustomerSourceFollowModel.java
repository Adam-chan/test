package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * @author chenqian
 * 类描述：客源跟进
 * 时间：2016-11-25
 */
public class CustomerSourceFollowModel implements Serializable{
	

	private static final long serialVersionUID = -5055080197638471011L;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 客源表ID
	 */
	private Integer demandId;
	/**
	 * 客源编号
	 */
	private String demandCode;
	/**
	 * 需求类型2求租，1求购
	 */
	private Integer demandType;
	/**
	 * 物业类型1住宅，2商铺，3写字楼，4车位
	 */
	private Integer propertyType;
	/**
	 * 客户姓名
	 */
	private String customerName;
	/**
	 * 跟进类型1QQ,2电话，3邮件，4短信，5手机
	 */
	private Integer followWay;
	/**
	 * 跟进时间
	 */
	private Date followTime;
	/**
	 * 跟进内容
	 */
	private String content;
	/**
	 * 下次跟进时间
	 */
	private Date nextTime;
	/**
	 * 提醒内容
	 */
	private String nextContent;
	/**
	 * 跟进人
	 */
	private String operaterUser;
	/**
	 * 跟进人ID
	 */
	private String operaterUserId;
	/**
	 * 跟进部门
	 */
	private String operaterOrg;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
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
	public String getDemandCode() {
		return demandCode;
	}
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public Integer getFollowWay() {
		return followWay;
	}
	public void setFollowWay(Integer followWay) {
		this.followWay = followWay;
	}
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNextTime() {
		return nextTime;
	}
	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}
	public String getNextContent() {
		return nextContent;
	}
	public void setNextContent(String nextContent) {
		this.nextContent = nextContent;
	}
	public String getOperaterUser() {
		return operaterUser;
	}
	public void setOperaterUser(String operaterUser) {
		this.operaterUser = operaterUser;
	}
	public String getOperaterUserId() {
		return operaterUserId;
	}
	public void setOperaterUserId(String operaterUserId) {
		this.operaterUserId = operaterUserId;
	}
	public String getOperaterOrg() {
		return operaterOrg;
	}
	public void setOperaterOrg(String operaterOrg) {
		this.operaterOrg = operaterOrg;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	 * 获得回访时间
	 * 
	 * @return
	 */
	public String getFollowTimeStr() {
		String followTimeStr = "";
		if (this.followTime == null) {
			return null;
		} else {
			followTimeStr = DateUtil.getStringByDate(this.followTime, "yyyy-MM-dd");
			return followTimeStr;
		}
	}

}
