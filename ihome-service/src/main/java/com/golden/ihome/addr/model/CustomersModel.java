package com.golden.ihome.addr.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lb
 * 类名称：客户管理
 * 类描述：客户表
 * 时间：2016-10-25
 */
public class CustomersModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
    private Integer id;
    /**
	 * 联系电话
	 */
    private String tell;
    /**
	 * 姓名
	 */
    private String groupName;
    /**
	 * 是否是员工1不是，2是
	 */
    private Integer isStaff;
    /**
	 * 用户类型1个人,2企业
	 */
    private Date userType;
    /**
	 * 备用电话
	 */
    private String spareTell;
    /**
	 * 性别1男2女
	 */
    private Integer sex;
    /**
	 * 证件类型1身份证
	 */
    private Integer idType;
    /**
	 * 证件号
	 */
    private String idCode;
    /**
	 * 国籍
	 */
    private String country;
    /**
	 * 户籍
	 */
    private String censusRegister;
    /**
	 * 公积金余额
	 */
    private Integer pubFundsBlance;
    /**
	 * 公积金月缴费
	 */
    private Integer pubFundsMonth;
    /**
	 * 购买经验1有，2无
	 */
    private Integer buyExperience;
    /**
	 * 贷款记录1有，2无
	 */
    private Integer loanRecord;
    /**
	 * 开收证明1有，2无
	 */
    private Integer kaiShou;
    /**
	 * 看房经历1有，2无
	 */
    private Integer viewHome;
    /**
	 * 现住址
	 */
    private String presentAddress;
    /**
	 * 户籍地址
	 */
    private String censusRegisterAddress;
    /**
	 * 工作单位
	 */
    private String company;
    /**
	 * 工作单位地址
	 */
    private String companyAddress;
    /**
	 * 是否有需求1有（有，就是客源），2无
	 */
    private Integer isDemand;
    /**
	 * 客户状态1正常2删除3
	 */
    private Integer status;
    /**
	 * 客户等级
	 */
    private String level;
    /**
	 * 客户年龄
	 */
	private Integer userAge;
	/**
	 * 备注
	 */
	private String remark;



	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(Integer isStaff) {
		this.isStaff = isStaff;
	}

	public Date getUserType() {
		return userType;
	}

	public void setUserType(Date userType) {
		this.userType = userType;
	}

	public String getSpareTell() {
		return spareTell;
	}

	public void setSpareTell(String spareTell) {
		this.spareTell = spareTell;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCensusRegister() {
		return censusRegister;
	}

	public void setCensusRegister(String censusRegister) {
		this.censusRegister = censusRegister;
	}

	public Integer getPubFundsBlance() {
		return pubFundsBlance;
	}

	public void setPubFundsBlance(Integer pubFundsBlance) {
		this.pubFundsBlance = pubFundsBlance;
	}

	public Integer getPubFundsMonth() {
		return pubFundsMonth;
	}

	public void setPubFundsMonth(Integer pubFundsMonth) {
		this.pubFundsMonth = pubFundsMonth;
	}

	public Integer getBuyExperience() {
		return buyExperience;
	}

	public void setBuyExperience(Integer buyExperience) {
		this.buyExperience = buyExperience;
	}

	public Integer getLoanRecord() {
		return loanRecord;
	}

	public void setLoanRecord(Integer loanRecord) {
		this.loanRecord = loanRecord;
	}

	public Integer getKaiShou() {
		return kaiShou;
	}

	public void setKaiShou(Integer kaiShou) {
		this.kaiShou = kaiShou;
	}

	public Integer getViewHome() {
		return viewHome;
	}

	public void setViewHome(Integer viewHome) {
		this.viewHome = viewHome;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getCensusRegisterAddress() {
		return censusRegisterAddress;
	}

	public void setCensusRegisterAddress(String censusRegisterAddress) {
		this.censusRegisterAddress = censusRegisterAddress;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Integer getIsDemand() {
		return isDemand;
	}

	public void setIsDemand(Integer isDemand) {
		this.isDemand = isDemand;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

  
}
