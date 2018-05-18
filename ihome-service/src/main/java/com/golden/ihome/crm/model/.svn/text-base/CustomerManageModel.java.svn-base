package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.sql.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * 联系人管理
 * 
 * @author weizhichao
 * 
 */
public class CustomerManageModel implements Serializable {

	private static final long serialVersionUID = -7505975331935553551L;
	/**
	 * id序列
	 */
	private Integer id;
	/**
	 * 联系电话
	 */
	private String tell;
	/**
	 * 联系人姓名
	 */
	private String userName;
	/**
	 * 联系人编号
	 */
	private String userCode;
	/**
	 * 是否是员工1不是，2是
	 */
	private String isStaff;
	/**
	 * 用户类型1个人,2企业
	 */
	private String userType;

	/**
	 * 备用电话
	 */
	private String spareTell;
	/**
	 * 性别1男2女
	 */
	private String sex;
	/**
	 * 证件类型1身份证
	 */
	private String idType;
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
	private String pubFundsBlance;
	/**
	 * 公积金月缴费
	 */
	private String pubFundsMonth;
	/**
	 * 购买经验1有，2无
	 */
	private String buyExperience;
	/**
	 * 贷款记录1有，2无
	 */
	private String loanRecord;
	/**
	 * 开收入证明1有，2无
	 */
	private String kaiShou;
	/**
	 * 看房经历1有，2无
	 */
	private String viewHome;
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
	 * 联系人状态1正常2删除
	 */
	private Integer status;
	/**
	 * 联系人等级
	 */
	private String customerLevel;
	/**
	 * 录入人
	 */
	private String entryPerson;
	/**
	 * 录入时间
	 */
	private Date entryDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

	private String updateDateStr;
	private String entryDateStr;

	/**
	 * 联系人年龄
	 */
	private Integer userAge;
	/**
	 * 未成交的需求数
	 */
	private Integer demandNum;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 黑名单id
	 */
	private Integer blackListId;

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

	public String getUpdateDateStr() {
		if (this.updateDate == null) {
			return null;
		} else {
			this.updateDateStr = DateUtil.getStringByDate(this.updateDate,
					"yyyy-MM-dd");
			return updateDateStr;
		}
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

	

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(String isStaff) {
		this.isStaff = isStaff;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getSpareTell() {
		return spareTell;
	}

	public void setSpareTell(String spareTell) {
		this.spareTell = spareTell;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
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

	public String getPubFundsBlance() {
		return pubFundsBlance;
	}

	public void setPubFundsBlance(String pubFundsBlance) {
		this.pubFundsBlance = pubFundsBlance;
	}

	public String getPubFundsMonth() {
		return pubFundsMonth;
	}

	public void setPubFundsMonth(String pubFundsMonth) {
		this.pubFundsMonth = pubFundsMonth;
	}

	public String getBuyExperience() {
		return buyExperience;
	}

	public void setBuyExperience(String buyExperience) {
		this.buyExperience = buyExperience;
	}

	public String getLoanRecord() {
		return loanRecord;
	}

	public void setLoanRecord(String loanRecord) {
		this.loanRecord = loanRecord;
	}

	public String getKaiShou() {
		return kaiShou;
	}

	public void setKaiShou(String kaiShou) {
		this.kaiShou = kaiShou;
	}

	public String getViewHome() {
		return viewHome;
	}

	public void setViewHome(String viewHome) {
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

	public String getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}

	public String getEntryPerson() {
		return entryPerson;
	}

	public void setEntryPerson(String entryPerson) {
		this.entryPerson = entryPerson;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取用户类型字符串
	 * 
	 * @return
	 */
	public String getUserTypeStr() {
		String userTypeStr = "";
		String userType = this.userType;
		if (userType != null) {
			if ("1".equals(userType)) {
				userTypeStr = "个人";
			} else if ("2".equals(userType)) {
				userTypeStr = "企业";
			} else {

			}
		}
		return userTypeStr;
	}

	/**
	 * 获取用户性别名称
	 * 
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
			} else {

			}
		}
		return sexStr;
	}

	/**
	 * 获取用户开收证明名称
	 * 
	 * @return
	 */
	public String getKaiShouStr() {
		String kaiShouStr = "";
		String kaiShou = this.kaiShou;
		if (sex != null) {
			if ("1".equals(kaiShou)) {
				kaiShouStr = "有";
			} else if ("2".equals(kaiShou)) {
				kaiShouStr = "无";
			} else {

			}
		}
		return kaiShouStr;
	}

	/**
	 * 获取用户购房经验名称
	 * 
	 * @return
	 */
	public String getBuyExperienceStr() {
		String buyExperienceStr = "";
		String buyExperience = this.buyExperience;
		if (sex != null) {
			if ("1".equals(buyExperience)) {
				buyExperienceStr = "有";
			} else if ("2".equals(buyExperience)) {
				buyExperienceStr = "无";
			} else {

			}
		}
		return buyExperienceStr;
	}

	/**
	 * 获取用户贷款记录名称
	 * 
	 * @return
	 */
	public String getLoanRecordStr() {
		String loanRecordStr = "";
		String loanRecord = this.loanRecord;
		if (sex != null) {
			if ("1".equals(loanRecord)) {
				loanRecordStr = "有";
			} else if ("2".equals(loanRecord)) {
				loanRecordStr = "无";
			} else {

			}
		}
		return loanRecordStr;
	}

	public String getEntryDateStr() {
		if (this.entryDate == null) {
			return null;
		} else {
			this.entryDateStr = DateUtil.getStringByDate(this.entryDate,
					"yyyy-MM-dd");
			return entryDateStr;
		}
	}

	public void setEntryDateStr(String entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public Integer getDemandNum() {
		return demandNum;
	}

	public void setDemandNum(Integer demandNum) {
		this.demandNum = demandNum;
	}

	public Integer getBlackListId() {
		return blackListId;
	}

	public void setBlackListId(Integer blackListId) {
		this.blackListId = blackListId;
	}

}
