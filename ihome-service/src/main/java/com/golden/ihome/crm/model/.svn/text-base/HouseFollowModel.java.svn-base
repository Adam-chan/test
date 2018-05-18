package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.sql.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * 跟进详情
 * 
 * @author weizhichao
 * 
 */
public class HouseFollowModel implements Serializable{

	private static final long serialVersionUID = -8432352547788115767L;
	
	/**
	 * id序列
	 */
	private Integer id;
	/**
	 * 跟进时间
	 */
	private Date followTime;
	/**
	 * 跟进内容
	 */
	private String followContent;
	/**
	 * 下一次跟进时间
	 */
	private Date nextFollowTime;
	/**
	 * 提醒内容
	 */
	private String remindContent;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 跟进人
	 */
	private String operateUser;
	/**
	 * 跟进人Id
	 */
	private String operateUserId;
	/**
	 * 跟进方式
	 */
	private Integer followWay;
	/**
	 * 跟进类型
	 */
	private Integer followType;
	
	/**
	 * 房源信息
	 */
	private Integer houseInfoId;//房源ID
	private String houseCode;//房源编号
	private Integer useType;//使用类别
	private String divideQu;//所属区
	private String divideQuCode;//所属区编号
	private String divideOrg;//所属组
	private String divideOrgCode;//所属组编号
	private String divideUser;//所属人
	private String divideUserId;//所属人Id
	private String demandType;//业务类型
	private String followWay2;//跟进方式
	
	public String getFollowWay2() {
		return followWay2;
	}
	public void setFollowWay2(String followWay2) {
		this.followWay2 = followWay2;
	}
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
	public String getDivideQu() {
		return divideQu;
	}
	public void setDivideQu(String divideQu) {
		this.divideQu = divideQu;
	}
	public String getDivideQuCode() {
		return divideQuCode;
	}
	public void setDivideQuCode(String divideQuCode) {
		this.divideQuCode = divideQuCode;
	}
	public String getDivideOrg() {
		return divideOrg;
	}
	public void setDivideOrg(String divideOrg) {
		this.divideOrg = divideOrg;
	}
	public String getDivideOrgCode() {
		return divideOrgCode;
	}
	public void setDivideOrgCode(String divideOrgCode) {
		this.divideOrgCode = divideOrgCode;
	}
	public String getDivideUser() {
		return divideUser;
	}
	public void setDivideUser(String divideUser) {
		this.divideUser = divideUser;
	}
	public String getDivideUserId() {
		return divideUserId;
	}
	public void setDivideUserId(String divideUserId) {
		this.divideUserId = divideUserId;
	}
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	public String getFollowContent() {
		return followContent;
	}
	public void setFollowContent(String followContent) {
		this.followContent = followContent;
	}
	public Date getNextFollowTime() {
		return nextFollowTime;
	}
	public void setNextFollowTime(Date nextFollowTime) {
		this.nextFollowTime = nextFollowTime;
	}
	public String getRemindContent() {
		return remindContent;
	}
	public void setRemindContent(String remindContent) {
		this.remindContent = remindContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getOperateUserId() {
		return operateUserId;
	}
	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}
	public Integer getFollowWay() {
		return followWay;
	}
	public void setFollowWay(Integer followWay) {
		this.followWay = followWay;
	}
	public String getDemandType() {
		return demandType;
	}
	public void setDemandType(String demandType) {
		this.demandType = demandType;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public Integer getFollowType() {
		return followType;
	}
	public void setFollowType(Integer followType) {
		this.followType = followType;
	}
	/**
	 * 获得跟进方式
	 * 
	 * @return
	 */
	public String getFollowWayStr() {
		String followWayStr = "";
		Integer followWay = this.followWay;
		if (followWay != null) {
			if (followWay == 1) {
				followWayStr = "手机";
			} else if (followWay == 2) {
				followWayStr = "QQ";
			} else if (followWay == 3) {
				followWayStr = "短信";
			} else if (followWay == 4) {
				followWayStr = "电话";
			} else if (followWay == 5) {
				followWayStr = "修改记录";
			} 
		}
		return followWayStr;
	}
	
	/**
	 * 获得跟进时间
	 * 
	 * @return
	 */
	public String getFollowTimeStr() {
		String followTimeStr = "";
		if (this.followTime == null) {
			return null;
		} else {
			followTimeStr = DateUtil.getStringByDate(this.followTime,
					"yyyy-MM-dd");
			return followTimeStr;
		}
	}
	
}
