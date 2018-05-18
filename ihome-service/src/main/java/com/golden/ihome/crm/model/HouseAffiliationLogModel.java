package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * @author lb
 * 类描述：房源管理-房源归属日志
 * 时间：2016-12-4
 */
public class HouseAffiliationLogModel implements Serializable{

	private static final long serialVersionUID = 4481012646487106474L;

	private Integer id;
	private String operator;//操作人
	private String operatorId;//操作人ID
	private String operatorCode;//操作人编号
	private Date operatorTime;//操作时间
	private String  operatorTimeStr;
	private String affiliationOld;//原归属人
	private String affiliationNow;//现归属人
	private String reason;//原因
	private String remark;//备注
	private Integer houseInfoId;
	private Integer type;//归属类型 1维护归属 2登记归属 3委托归属 4实勘归属 5独家归属 6钥匙归属 7成交归属
	
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public Date getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
		this.operatorTimeStr=DateUtil.getStringByDate(operatorTime, "yyyy/MM/dd HH:mm");
	}
	public String getOperatorTimeStr() {
		return operatorTimeStr;
	}
	public void setOperatorTimeStr(String operatorTimeStr) {
		this.operatorTimeStr = operatorTimeStr;
	}
	public String getAffiliationOld() {
		return affiliationOld;
	}
	public void setAffiliationOld(String affiliationOld) {
		this.affiliationOld = affiliationOld;
	}
	public String getAffiliationNow() {
		return affiliationNow;
	}
	public void setAffiliationNow(String affiliationNow) {
		this.affiliationNow = affiliationNow;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * type;//归属类型 1维护归属 2登记归属 3委托归属 4实勘归属 5独家归属 6钥匙归属 7成交归属
	 * @return
	 */
	public String getTypeStr(){
		String typeStr = "";
		Integer type = this.type;
		if(type!=null){
			if(type==1){
				typeStr = "维护归属";
			}else if(type==2){
				typeStr = "委托归属";
			}else if(type==3){
				typeStr = "实勘归属";
			}else if(type==4){
				typeStr = "独家归属";
			}else if(type==5){
				typeStr = "钥匙归属";
			}else if(type==6){
				typeStr = "成交归属";
			}
		}
		return typeStr;
	}

}
