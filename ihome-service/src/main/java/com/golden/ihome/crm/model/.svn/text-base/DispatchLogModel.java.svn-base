package com.golden.ihome.crm.model;



import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

public class DispatchLogModel implements Serializable{
	
	private static final long serialVersionUID = 8576814702511120056L;
	
	private Integer id;
	private Integer demandId;//客源ID
	private String demandCode;//客源编号
	private String chargeBefore;//前归属人
	private String chargeAfter;//变更后归属人
	private String operateUser;//操作人
	private Date operateTime;//操作时间
	
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
	public String getChargeBefore() {
		return chargeBefore;
	}
	public void setChargeBefore(String chargeBefore) {
		this.chargeBefore = chargeBefore;
	}
	public String getChargeAfter() {
		return chargeAfter;
	}
	public void setChargeAfter(String chargeAfter) {
		this.chargeAfter = chargeAfter;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	/**
	 * 获得回访时间
	 * 
	 * @return
	 */
	public String getOperateTimeStr() {
		String operateTimeStr = "";
		if (this.operateTime == null) {
			return null;
		} else {
			operateTimeStr = DateUtil.getStringByDate(this.operateTime, "yyyy-MM-dd");
			return operateTimeStr;
		}
	}

}
