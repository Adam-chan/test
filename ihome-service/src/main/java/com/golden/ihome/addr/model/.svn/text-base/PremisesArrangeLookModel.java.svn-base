package com.golden.ihome.addr.model;

import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.common.CommonConst;
import com.golden.ihome.utils.DateUtil;

/**
 * @author lb
 * 类名称：楼盘约带看
 * 类描述：楼盘实体
 * 时间：2016-10-24
 */
public class PremisesArrangeLookModel implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
    private Integer id;
    /**
	 * 客户ID
	 */
    private Integer clientId;
 
    /**
	 * 楼盘ID
	 */
    private Integer premisesId;
    /**
	 * 创建时间
	 */
    private Date creatTime;
    /**
	 * 创建时间str
	 */
    private String creatTimeStr;
    /**
	 * 约看时间
	 */
    private Date arrangeTime;
    /**
   	 * 约看时间str
   	 */
    private String arrangeTimeStr;
    /**
	 * 带看时间
	 */
    private Date ledTime;
    /**
   	 * 带看时间Str
   	 */
    private String ledTimeStr;
    /**
	 * 使用状态
	 */
    private Integer status;
    /**
	 * 带看状态 1 新建 2已带看
	 */
    private Integer ledStatus;
    /**
  	 * 带看状态 1 新建 2已带看
  	 */
    private String ledStatusStr;
    /**
  	 * 经纪人
  	 */
    private String broker;
    /**
  	 * 楼盘表   楼盘名称
  	 */
    private String premisesName;
  
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
		this.creatTimeStr=DateUtil.getStringByDate(creatTime, "yyyy/MM/dd HH:mm");
	}
	public String getCreatTimeStr() {
		return creatTimeStr;
	}
	public void setCreatTimeStr(String creatTimeStr) {
		this.creatTimeStr = creatTimeStr;
	}
	public Date getArrangeTime() {
		return arrangeTime;
	}
	public void setArrangeTime(Date arrangeTime) {
		this.arrangeTime = arrangeTime;
		this.arrangeTimeStr=DateUtil.getStringByDate(arrangeTime, "yyyy/MM/dd HH:mm");
	}
	public String getArrangeTimeStr() {
		return arrangeTimeStr;
	}
	public void setArrangeTimeStr(String arrangeTimeStr) {
		this.arrangeTimeStr = arrangeTimeStr;
	}
	public Date getLedTime() {
		return ledTime;
	}
	public void setLedTime(Date ledTime) {
		this.ledTime = ledTime;
		this.ledTimeStr=DateUtil.getStringByDate(ledTime, "yyyy/MM/dd HH:mm");
	}
	public String getLedTimeStr() {
		return ledTimeStr;
	}
	public void setLedTimeStr(String ledTimeStr) {
		this.ledTimeStr = ledTimeStr;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getLedStatus() {
		return ledStatus;
	}
	public void setLedStatus(Integer ledStatus) {
		this.ledStatus = ledStatus;
		this.ledStatusStr = CommonConst.getLookStatus(ledStatus);
	}
	public String getLedStatusStr() {
		return ledStatusStr;
	}
	public void setLedStatusStr(String ledStatusStr) {
		this.ledStatusStr = ledStatusStr;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
}