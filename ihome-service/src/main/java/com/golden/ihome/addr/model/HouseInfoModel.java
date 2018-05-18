package com.golden.ihome.addr.model;

import java.io.Serializable;
/**
 * 房源主表
 * @author dl
 *
 */
public class HouseInfoModel implements Serializable{

	private static final long serialVersionUID = 8108915592718737229L;
	
	private Integer id;
	private Integer demandType;//需求类型1出售,2出租
	private Integer isProtected;//是否保护1未保护,2申请保护中,3已保护
	private String operateUser;//登记人
	private String divideUser;//收益人
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDemandType() {
		return demandType;
	}
	public void setDemandType(Integer demandType) {
		this.demandType = demandType;
	}
	public Integer getIsProtected() {
		return isProtected;
	}
	public void setIsProtected(Integer isProtected) {
		this.isProtected = isProtected;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getDivideUser() {
		return divideUser;
	}
	public void setDivideUser(String divideUser) {
		this.divideUser = divideUser;
	}
	
}
