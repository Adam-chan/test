package com.golden.ihome.crm.model;

import java.io.Serializable;
/**
 * 联系人黑名单管理
 * 
 * @author weizhichao
 * 
 */
public class BlackListModel implements Serializable{
	
	private static final long serialVersionUID = -5571368168560643392L;
	/**
	 * id序列
	 */
	private Integer id;
	/**
	 * 客户id
	 */
	private Integer customerId;
	/**
	 * 拉黑理由
	 */
	private String remark;
	/**
	 * 操作人
	 */
	private String operateUser;
	/**
	 * 操作人id
	 */
	private String operateUserId;
	/**
	 * 创建时间
	 */
	private String createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	

}
