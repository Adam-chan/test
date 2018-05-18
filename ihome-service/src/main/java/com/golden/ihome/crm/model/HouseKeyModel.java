package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 房源钥匙管理LB 11/28
 *  
 */
public class HouseKeyModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;//ID
	private Integer houseInfoId;//房源ID
	private String  houseCode;//房源编号
	private Integer type;//钥匙类型：1钥匙，2门禁卡，3密码
	private String  colelectUser;//收取人
	private String  colelectUserId;//收取人ID
	private String  colelectOrg;//收取组名
	private String  colelectOrgCode;//收取组编码
	private String  colelectZone;//收取区
	private String  colelectZoneCode;//收取区编码
	private String  colelectContact;//收取人联系电话
	private String  keyCode;//钥匙编号
	private String  password;//密码
	private String  deposit;//存放人
	private String  depositUserId;//存放人ID
	private String  depositStoreId;//存放实体店
	private String  depositContact;//存放人联系电话
	private String  remark;//备注
	private Date    createTime;//创建时间
	private String  createTimeStr;//创建时间Str
	private Integer status;//钥匙状态：1使用，2退还，3待确认，4无效
	private Integer backType;//退还原因1房源内部成交，2其它公司成交，3其它
	private Date    backTime;//退还时间
	private String  backTimeStr;//退还时间
	private String  backUser;//退还人
	private String  backUserId;//退还人ID
	private Integer borrowType;//借出类别1公司内部，2公司外部
	private String  borrowUser;//借用人
	private String  borrowUserId;//借用人ID
	private String  borrowUserContact;//联系方式
	private Date    borrowTime;//借出时间
	private String  borrowTimeStr;//借出时间
	private Date    borrowBackTime;//预计归还时间
	private String  borrowBackTimeStr;//预计归还时间
	private String  borrowOperateUser;//借出人
	private String  borrowOperateUserId;//借出人ID
	private Integer borrowStatus;//存放状态：1借出，2在库
	private Date    borrowCreateTime;//归还时间
	private String  borrowCreateTimeStr;//归还时间
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
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public String getColelectContact() {
		return colelectContact;
	}
	public void setColelectContact(String colelectContact) {
		this.colelectContact = colelectContact;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getDepositUserId() {
		return depositUserId;
	}
	public void setDepositUserId(String depositUserId) {
		this.depositUserId = depositUserId;
	}
	public String getDepositStoreId() {
		return depositStoreId;
	}
	public void setDepositStoreId(String depositStoreId) {
		this.depositStoreId = depositStoreId;
	}
	public String getDepositContact() {
		return depositContact;
	}
	public void setDepositContact(String depositContact) {
		this.depositContact = depositContact;
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
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getBackType() {
		return backType;
	}
	public void setBackType(Integer backType) {
		this.backType = backType;
	}
	public Date getBackTime() {
		return backTime;
	}
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}
	public String getBackTimeStr() {
		return backTimeStr;
	}
	public void setBackTimeStr(String backTimeStr) {
		this.backTimeStr = backTimeStr;
	}
	public String getBackUser() {
		return backUser;
	}
	public void setBackUser(String backUser) {
		this.backUser = backUser;
	}
	public String getBackUserId() {
		return backUserId;
	}
	public void setBackUserId(String backUserId) {
		this.backUserId = backUserId;
	}
	public Integer getBorrowType() {
		return borrowType;
	}
	public void setBorrowType(Integer borrowType) {
		this.borrowType = borrowType;
	}
	public String getBorrowUser() {
		return borrowUser;
	}
	public void setBorrowUser(String borrowUser) {
		this.borrowUser = borrowUser;
	}
	public String getBorrowUserId() {
		return borrowUserId;
	}
	public void setBorrowUserId(String borrowUserId) {
		this.borrowUserId = borrowUserId;
	}
	public String getBorrowUserContact() {
		return borrowUserContact;
	}
	public void setBorrowUserContact(String borrowUserContact) {
		this.borrowUserContact = borrowUserContact;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public String getBorrowTimeStr() {
		return borrowTimeStr;
	}
	public void setBorrowTimeStr(String borrowTimeStr) {
		this.borrowTimeStr = borrowTimeStr;
	}
	public Date getBorrowBackTime() {
		return borrowBackTime;
	}
	public void setBorrowBackTime(Date borrowBackTime) {
		this.borrowBackTime = borrowBackTime;
	}
	public String getBorrowBackTimeStr() {
		return borrowBackTimeStr;
	}
	public void setBorrowBackTimeStr(String borrowBackTimeStr) {
		this.borrowBackTimeStr = borrowBackTimeStr;
	}
	public String getBorrowOperateUser() {
		return borrowOperateUser;
	}
	public void setBorrowOperateUser(String borrowOperateUser) {
		this.borrowOperateUser = borrowOperateUser;
	}
	public String getBorrowOperateUserId() {
		return borrowOperateUserId;
	}
	public void setBorrowOperateUserId(String borrowOperateUserId) {
		this.borrowOperateUserId = borrowOperateUserId;
	}
	public Integer getBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	public Date getBorrowCreateTime() {
		return borrowCreateTime;
	}
	public void setBorrowCreateTime(Date borrowCreateTime) {
		this.borrowCreateTime = borrowCreateTime;
	}
	public String getBorrowCreateTimeStr() {
		return borrowCreateTimeStr;
	}
	public void setBorrowCreateTimeStr(String borrowCreateTimeStr) {
		this.borrowCreateTimeStr = borrowCreateTimeStr;
	}
	/**
	 * 钥匙类型：1电子钥匙，2普通钥匙 3密码
	 * @return
	 */
	public String getTypeStr(){
		String typeStr = "";
		Integer type = this.type;
		if(type!=null){
			if(type==1){
				typeStr = "电子钥匙";
			}else if(type==2){
				typeStr = "普通钥匙";
			}else if(type==3){
				typeStr = "密码";
			}
		}
		return typeStr;
	}
	/**
	 * 钥匙状态：1使用，2退还，3待确认，4无效
	 * @return
	 */
	public String getStatusStr(){
		String statusStr = "";
		Integer status = this.status;
		if(status!=null){
			if(status==1){
				statusStr = "使用";
			}else if(status==2){
				statusStr = "退还";
			}else if(status==3){
				statusStr = "待确认";
			}else if(status==4){
				statusStr = "无效";
			}
		}
		return statusStr;
	}
	/**
	 * 退还原因1房源内部成交，2其它公司成交，3其它
	 * @return
	 */
	public String getBackTypeStr(){
		String backTypeStr = "";
		Integer backType = this.backType;
		if(backType!=null){
			if(backType==1){
				backTypeStr = "房源内部成交";
			}else if(backType==2){
				backTypeStr = "其它公司成交";
			}else {
				backTypeStr = "其它";
			}
		}
		return backTypeStr;
	}
	/**
	 * 借出类别1公司内部，2公司外部
	 * @return
	 */
	public String getBorrowTypeStr(){
		String borrowTypeStr = "";
		Integer borrowType = this.borrowType;
		if(borrowType!=null){
			if(borrowType==1){
				borrowTypeStr = "公司内部";
			}else if(borrowType==2){
				borrowTypeStr = "公司外部";
			}
		}
		return borrowTypeStr;
	}
	/**
	 * 存放状态：1借出，2在库
	 * @return
	 */
	public String getBorrowStatusStr(){
		String borrowStatusStr = "";
		Integer borrowStatus = this.borrowStatus;
		if(borrowStatus!=null){
			if(borrowType==1){
				borrowStatusStr = "公司内部";
			}else if(borrowType==2){
				borrowStatusStr = "公司外部";
			}
		}
		return borrowStatusStr;
	}
}
