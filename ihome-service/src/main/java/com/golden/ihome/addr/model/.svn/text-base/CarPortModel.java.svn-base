package com.golden.ihome.addr.model;

import java.io.Serializable;
/**
 * @author dl
 * 类名称：车位管理
 * 类描述：车位管理
 * 时间 2016-10-18
 */
public class CarPortModel implements Serializable{

	private static final long serialVersionUID = 5928657677837709797L;
	
	private Integer id;
	private String parkNum;//车位编号
    private Integer status;//状态 1空置  2自用 
    private Integer type;//类型 1车库   2车位
    private Integer floor;//楼层 1地上 2地下
    private Integer authorize;//委托 1出租   2出售   3出租/出售
    private String ownerName;//业主
    private String telephone;//电话
    private String spareTelephone;//备用电话
    private String createTime;//车位创建时间
    private String remark;//备注
    private Integer roomId;//关联房间ID
    private String roomNum;//关联房间号
    private String roomTime;//关联房间时间
    
    //其他
    private String addressDetail;//详细地址
    private Integer premisesId;//楼盘id
    private String premisesName;//楼盘名称
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParkNum() {
		return parkNum;
	}
	public void setParkNum(String parkNum) {
		this.parkNum = parkNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getAuthorize() {
		return authorize;
	}
	public void setAuthorize(Integer authorize) {
		this.authorize = authorize;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSpareTelephone() {
		return spareTelephone;
	}
	public void setSpareTelephone(String spareTelephone) {
		this.spareTelephone = spareTelephone;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomTime() {
		return roomTime;
	}
	public void setRoomTime(String roomTime) {
		this.roomTime = roomTime;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Integer getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}
	public String getPremisesName() {
		return premisesName;
	}
	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
	/**
	 * 获取楼层字符串
	 * @return
	 */
	public String getFloorStr(){
		String floorStr = "";
		Integer floor = this.floor;
		if(floor!=null){
			if(floor==1){
				floorStr = "地上";
			}else if(floor==2){
				floorStr = "地下";
			}
		}
		return floorStr;
	}
	/**
	 * 获取楼层字符串
	 * @return
	 */
	public String getTypeStr(){
		String typeStr = "";
		Integer type = this.type;
		if(type!=null){
			if(type==1){
				typeStr = "车位";
			}else if(type==2){
				typeStr = "车库";
			}
		}
		return typeStr;
	}
	/**
	 * 获取车位状态字符串
	 * @return
	 */
	public String getStatusStr(){
		String statusStr = "";
		Integer status = this.status;
		if(status!=null){
			if(status==1){
				statusStr = "空置";
			}else if(status==2){
				statusStr = "自用";
			}
		}
		return statusStr;
	}
	/**
	 * 获取车位委托字符串
	 * @return
	 */
	public String getAuthorizeStr(){
		String authorizeStr = "";
		Integer authorize = this.authorize;
		if(authorize!=null){
			if(authorize==1){
				authorizeStr = "出租";
			}else if(authorize==2){
				authorizeStr = "出售";
			}else if(authorize==3){
				authorizeStr = "出租/出售";
			}
		}
		return authorizeStr;
	}
    
}
