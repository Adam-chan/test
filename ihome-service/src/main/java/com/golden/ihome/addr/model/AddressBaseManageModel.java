package com.golden.ihome.addr.model;


/**
 * @author lb
 * 类名称：地址库管理
 * 时间：2016-11-1
 */
public class AddressBaseManageModel {
	/**
	 * 区名称
	 */
	private String areaName;
	/**
	 * 街道名称
	 */
	private String subName;
	/**
	 * 社区名称
	 */
	private String commName;
	/**
	 * 道路名+道路号
	 */
	private String roadDetail;
	/**
	 * 详细地址
	 */
  	private String addrDetail;
	/**
	 * 业主
	 */
	private String name;
	/**
	 * 业主电话
	 */
	private String contactType;
	/**
	 * 业主身份证
	 */
	private String idCard;
	/**
	 * 楼盘名称
	 */
	private String bpName;
	/**
	 * 楼栋分组名称
	 */
	private String bgGroupName;
	/**
	 * 栋座名称
	 */
	private String bbBuildingName;
	/**
	 * 单元名称
	 */
	private String buCode;
	/**
	 * 房间名称
	 */
	private String bhHouseName;
	/**
	 * 房间ID
	 */
	private String houseId;
	/**
	 * 证载地址
	 */
	private String zzdzDetail;
	/**
	 * 使用状态
	 */
	private Integer status;
	/**
	 * 楼栋Id
	 */
	private Integer Id;
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public String getRoadDetail() {
		return roadDetail;
	}
	public void setRoadDetail(String roadDetail) {
		this.roadDetail = roadDetail;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getBpName() {
		return bpName;
	}
	public void setBpName(String bpName) {
		this.bpName = bpName;
	}
	public String getBgGroupName() {
		return bgGroupName;
	}
	public void setBgGroupName(String bgGroupName) {
		this.bgGroupName = bgGroupName;
	}
	public String getBbBuildingName() {
		return bbBuildingName;
	}
	public void setBbBuildingName(String bbBuildingName) {
		this.bbBuildingName = bbBuildingName;
	}
	public String getBuCode() {
		return buCode;
	}
	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}
	public String getBhHouseName() {
		return bhHouseName;
	}
	public void setBhHouseName(String bhHouseName) {
		this.bhHouseName = bhHouseName;
	}
	public String getZzdzDetail() {
		return zzdzDetail;
	}
	public void setZzdzDetail(String zzdzDetail) {
		this.zzdzDetail = zzdzDetail;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
