package com.golden.ihome.crm.model;

import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * @author lb
 * 类描述：房源房产证
 * 时间：2016-11-1
 */
public class HouseDeedModel implements Serializable{

	private static final long serialVersionUID = 4481012646487106474L;

	private Integer  id;
	private Integer houseInfoId;//房屋信息ID
	private String  operateUser;//录入人
	private String  operateUserId;//录入人ID
	private String  operateOrg;//录入部门
	private String  operateOrgCode;//录入部门编号
	private String  colelectZone;//录入区
	private String  colelectZoneCode;//录入区编码
	private String  code;//委托书编号
	private String  remark;//备注
	private Date  createTime;//创建时间
	private String  createTimeStr;//创建时间Str
	private String  fileName;//文件名称
	private String  floderName;//服务器上的文件夹名称
	private String  fileNameLong;//服务器上的文件名称
	private Integer  status;//协议状态 1有效 2无效

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Integer getHouseInfoId() {
		return houseInfoId;
	}

	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
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

	public void setOperateUserId(String operateUserId){
		this.operateUserId = operateUserId;
	}

	public String getOperateOrg(){
		return operateOrg;
	}

	public void setOperateOrg(String operateOrg){
		this.operateOrg = operateOrg;
	}

	public String getOperateOrgCode(){
		return operateOrgCode;
	}

	public void setOperateOrgCode(String operateOrgCode){
		this.operateOrgCode = operateOrgCode;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		this.createTimeStr=DateUtil.getStringByDate(createTime, "yyyy/MM/dd HH:mm");
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFloderName() {
		return floderName;
	}

	public void setFloderName(String floderName) {
		this.floderName = floderName;
	}

	public String getFileNameLong() {
		return fileNameLong;
	}

	public void setFileNameLong(String fileNameLong) {
		this.fileNameLong = fileNameLong;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 协议状态 1有效 2无效
	 * @return
	 */
	public String getStatusStr(){
		String statusStr = "";
		Integer status = this.status;
		if(status!=null){
			if(status==1){
				statusStr = "有效";
			}else if(status==2){
				statusStr = "无效";
			}
		}
		return statusStr;
	}
}
