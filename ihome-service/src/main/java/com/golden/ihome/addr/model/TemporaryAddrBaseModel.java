package com.golden.ihome.addr.model;

import java.util.Date;

import com.golden.ihome.common.CommonConst;
import com.golden.ihome.utils.DateUtil;

/**
 * @author lb
 * 类名称：临时地址库
 * 时间：2016-11-6
 */
public class TemporaryAddrBaseModel {

	/**
	 * ID
	 */
  	private Integer id;
	/**
	 * houseInfoId
	 */
  	private Integer houseInfoId;
	/**
	 * 地址库地址
	 */
  	private String houseAddr;
  	/**
	 * 业务类型+临时地址
	 */
  	private String adllTemporaryAddtr;
	/**
	 * 业务类型
	 */
	private Integer bizType;
	/**
	 * 业务类型Str
	 */
	private String bizTypeStr;
	/**
	 * 临时地址
	 */
	private String temporaryAddtr;
	/**
	 * 提交人
	 */
	private String submitter;
	/**
	 * 提交时间
	 */
	private Date submitterTime;
	/**
	 * 提交时间Str
	 */
	private String submitterTimeStr;
	/**
	 * 审核状态
	 */
	private Integer checkStatus;
	/**
	 * 审核人
	 */
	private String checkMan;
	/**
	 * 审核时间
	 */
	private Date checkTime;
	/**
	 * 审核时间Str
	 */
	private String checkTimeStr;
	
	/**
	 * 拒绝理由
	 */
	private String refuseReson;
	/**
	 * 房间ID
	 */
	private Integer roomId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
		this.bizTypeStr=CommonConst.getBizType(bizType);
	}

	public String getTemporaryAddtr() {
		return temporaryAddtr;
	}

	public void setTemporaryAddtr(String temporaryAddtr) {
		this.temporaryAddtr = temporaryAddtr;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public Date getSubmitterTime() {
		return submitterTime;
	}

	public void setSubmitterTime(Date submitterTime) {
		this.submitterTime = submitterTime;
		this.submitterTimeStr=DateUtil.getStringByDate(submitterTime, "yyyy/MM/dd HH:mm");
		
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
		this.checkTimeStr=DateUtil.getStringByDate(checkTime, "yyyy/MM/dd HH:mm");
	}

	public String getRefuseReson() {
		return refuseReson;
	}

	public void setRefuseReson(String refuseReson) {
		this.refuseReson = refuseReson;
	}


	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getSubmitterTimeStr() {
		return submitterTimeStr;
	}

	public void setSubmitterTimeStr(String submitterTimeStr) {
		this.submitterTimeStr = submitterTimeStr;
	}

	public String getCheckTimeStr() {
		return checkTimeStr;
	}

	public void setCheckTimeStr(String checkTimeStr) {
		this.checkTimeStr = checkTimeStr;
	}

	public String getAdllTemporaryAddtr() {
		return adllTemporaryAddtr;
	}

	public void setAdllTemporaryAddtr(String adllTemporaryAddtr) {
		this.adllTemporaryAddtr = adllTemporaryAddtr;
	}

	public String getBizTypeStr() {
		return bizTypeStr;
	}

	public void setBizTypeStr(String bizTypeStr) {
		this.bizTypeStr = bizTypeStr;
	}

	public Integer getHouseInfoId() {
		return houseInfoId;
	}

	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}

	public String getHouseAddr() {
		return houseAddr;
	}

	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}
	
}
