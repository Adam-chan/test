package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.golden.ihome.utils.DateUtil;

/**
 * @author LB
 * 类描述：系统参数管理
 * 时间：2016-11-8
 */
public class SysParameterModel implements Serializable{

	private static final long serialVersionUID = 4481012646487106474L;
	
	//SYS_HOUSE_PARAME 表
	/**
	 * "WT";//委托录入配置  描述 1：是 2：否
	 * "FYBH";//房源添加保护数量配置
	 * "SKIMG";//实勘上传图片时参数配置
	 * "MMFYMS";//买卖房源描述配置
	 * "ZLFYMS";//租赁房源描述配置
	 * "MMFWSS";//买卖房屋设施配置
	 * "ZLFWSS";//租赁房屋设施配置
	 * "MMSNJJ";//买卖室内家具配置
	 * "MMSNJJ";//买卖室内家具配置
	 * "MMFYBQ";//买卖房源标签配置
	 * "ZLFYBQ";//租赁房源标签配置
	 * "XZLDJ";//写字楼等级配置
	 */
	private Integer id;
	
	private String sysHouseType;
	
	private List<SysParameterModel> sysHouseList;
	/**
	 * 房源参数描述
	 */
	private String sysHouseDescribe;
	/**
	 * 排序
	 */
	private Integer sysHouseSort;
	/**
	 * 数量
	 */
	private Integer sysCount;
	
	
	public List<SysParameterModel> getSysHouseList() {
		return sysHouseList;
	}
	public void setSysHouseList(List<SysParameterModel> sysHouseList) {
		this.sysHouseList = sysHouseList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSysCount() {
		return sysCount;
	}
	public void setSysCount(Integer sysCount) {
		this.sysCount = sysCount;
	}
	public String getSysHouseType() {
		return sysHouseType;
	}
	public void setSysHouseType(String sysHouseType) {
		this.sysHouseType = sysHouseType;
	}
	public String getSysHouseDescribe() {
		return sysHouseDescribe;
	}
	public void setSysHouseDescribe(String sysHouseDescribe) {
		this.sysHouseDescribe = sysHouseDescribe;
	}
	public Integer getSysHouseSort() {
		return sysHouseSort;
	}
	public void setSysHouseSort(Integer sysHouseSort) {
		this.sysHouseSort = sysHouseSort;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	//SYS_GAIN_SHARING 表
	/**
	 * 收益表ID
	 */
	private Integer gainSharingId;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 开始时间Str
	 */
	private String startTimeStr;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 结束时间Str
	 */
	private String endTimeStr;
	/**
	 * 录房人比例
	 */
	private Integer houseEnter;
	/**
	 * 成交人比例
	 */
	private Integer dealMan;
	/**
	 * 收钥匙人比例
	 */
	private Integer collKeysMan;
	/**
	 * 收房人比例
	 */
	private Integer collRoomMan;
	/**
	 * 实勘人比例
	 */
	private Integer realProMan;

	public Integer getGainSharingId() {
		return gainSharingId;
	}
	public void setGainSharingId(Integer gainSharingId) {
		this.gainSharingId = gainSharingId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
		this.startTimeStr=DateUtil.getStringByDate(startTime, "yyyy/MM/dd ");
	}
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
		this.endTimeStr=DateUtil.getStringByDate(endTime, "yyyy/MM/dd ");
	}
	public String getEndTimeStr() {
		return endTimeStr;
	}
	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
	public Integer getHouseEnter() {
		return houseEnter;
	}
	public void setHouseEnter(Integer houseEnter) {
		this.houseEnter = houseEnter;
	}
	public Integer getDealMan() {
		return dealMan;
	}
	public void setDealMan(Integer dealMan) {
		this.dealMan = dealMan;
	}
	public Integer getCollKeysMan() {
		return collKeysMan;
	}
	public void setCollKeysMan(Integer collKeysMan) {
		this.collKeysMan = collKeysMan;
	}
	public Integer getCollRoomMan() {
		return collRoomMan;
	}
	public void setCollRoomMan(Integer collRoomMan) {
		this.collRoomMan = collRoomMan;
	}
	public Integer getRealProMan() {
		return realProMan;
	}
	public void setRealProMan(Integer realProMan) {
		this.realProMan = realProMan;
	}
	
	
	
	
	
	
	//SYS_CUSTOMER_PARAME 表
	/**
	 * 客源参数类型
	 */
	private String sysCoustomerType;
	
	/**
	 * 客源参数描述   买卖房源查看电话地址次数(职称也用它)
	 */ 
	private String sysCoustomerDescribe;
	private String sysCoustomerDescribeStr;//职位
	/**
	 * 客源参数个别描述  提醒天数  租赁房源查看电话地址次数
	 */
	private String sysCoustomerTDescribe;
	/**
	 * 排序
	 */
	private Integer sysCoustomerSort;
	
	private List<SysParameterModel> sysCoustomerList;
	
	
	public String getSysCoustomerDescribeStr() {
		return sysCoustomerDescribeStr;
	}
	public void setSysCoustomerDescribeStr(String sysCoustomerDescribeStr) {
		this.sysCoustomerDescribeStr = sysCoustomerDescribeStr;
	}
	public List<SysParameterModel> getSysCoustomerList() {
		return sysCoustomerList;
	}
	public void setSysCoustomerList(List<SysParameterModel> sysCoustomerList) {
		this.sysCoustomerList = sysCoustomerList;
	}
	public String getSysCoustomerType() {
		return sysCoustomerType;
	}
	public void setSysCoustomerType(String sysCoustomerType) {
		this.sysCoustomerType = sysCoustomerType;
	}
	public String getSysCoustomerDescribe() {
		return sysCoustomerDescribe;
	}
	public void setSysCoustomerDescribe(String sysCoustomerDescribe) {
		this.sysCoustomerDescribe = sysCoustomerDescribe;
	}
	public String getSysCoustomerTDescribe() {
		return sysCoustomerTDescribe;
	}
	public void setSysCoustomerTDescribe(String sysCoustomerTDescribe) {
		this.sysCoustomerTDescribe = sysCoustomerTDescribe;
	}
	public Integer getSysCoustomerSort() {
		return sysCoustomerSort;
	}
	public void setSysCoustomerSort(Integer sysCoustomerSort) {
		this.sysCoustomerSort = sysCoustomerSort;
	}
	
	
	
	//其他系统参数
	/**
	 * 其他参数类型
	 */
	private String sysOtherType;
	/**
	 * 其他参数描述
	 */ 
	private String sysOtherDescribe;
	/**
	 * 排序
	 */
	private Integer sysOtherSort;
	
	private List<SysParameterModel> sysOtherList;


	public String getSysOtherType() {
		return sysOtherType;
	}
	public void setSysOtherType(String sysOtherType) {
		this.sysOtherType = sysOtherType;
	}
	public String getSysOtherDescribe() {
		return sysOtherDescribe;
	}
	public void setSysOtherDescribe(String sysOtherDescribe) {
		this.sysOtherDescribe = sysOtherDescribe;
	}
	public Integer getSysOtherSort() {
		return sysOtherSort;
	}
	public void setSysOtherSort(Integer sysOtherSort){
		this.sysOtherSort = sysOtherSort;
	}
	public List<SysParameterModel> getSysOtherList(){
		return sysOtherList;
	}
	public void setSysOtherList(List<SysParameterModel> sysOtherList) {
		this.sysOtherList = sysOtherList;
	}
	
	
}
