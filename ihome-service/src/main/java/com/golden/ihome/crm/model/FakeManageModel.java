package com.golden.ihome.crm.model;
import java.io.Serializable;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

/**
 * 
 * @author lb
 * 类名称：打假管理
 * 类描述：打假管理
 * 时间：2016-11-22
 */
public class FakeManageModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 *-------------- MANAGE_FAKE 表--------------
	 */
	private Integer id;
	/**
	 * 房源Id
	 */
	private Integer houseInfoId;
	/**
	 * 房源编号
	 */
	private String  houseCode;
	/**
	 *  打假人名称
	 */
	private String  proposerUser;
	/**
	 *  打假人所属人ID
	 */
	private String proposerUserId;
	/**
	 *  打假人所属区名称
	 */
	private String  proposerOrgName;
	/**
	 *  打假人所属部门名称
	 */
	private String  proposerAreaName;
	/**
	 *  打假人所属部门编号
	 */
	private String  proposerOrgCode;
	/**
	 * 被打假人名称
	 */
	private String  passiveUser;
	/**
	 * 被打假所属人id
	 */
	private String passiveUserId;
	/**
	 * 被打假所属区名称
	 */
	private String  passiveAreaName;
	/**
	 * 被打假所属部门名称
	 */
	private String  passiveOrgName;
	/**
	 * 被打假所属部门编号
	 */
	private String  passiveOrgCode;
	/**
	 * 打假备注
	 */
	private String  reason;
	/**
	 * 处理意见（审核备注）
	 */
	private String  handingSuggestion;
	/**
	 * 审核人
	 */
	private String examineUser;
	/**
	 * 审核人ID
	 */
	private Integer examineUserId;
	/**
	 * 审核状态：1未处理，2通过，3驳回
	 */
	private Integer examineStatus;
	/**
	 * 审核时间
	 */
	private Date examineTime;
	private String examineTimeStr;
	/**
	 * 打假类型1房源打假，2实勘打假，3钥匙打假
	 */
	private Integer type;
	/**
	 * 交易类型1 买卖 2 租赁
	 */
	private Integer transType;
	/**
	 * 创建时间
	 */
	private Date createtime;
	private String createTimeStr;
	/**
	 * 使用类别 1:住宅 2:商铺3:写字楼4:车库
	 */
	private Integer useType;
	
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
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public String getProposerUser() {
		return proposerUser;
	}
	public void setProposerUser(String proposerUser) {
		this.proposerUser = proposerUser;
	}
	public String getProposerOrgName() {
		return proposerOrgName;
	}
	public void setProposerOrgName(String proposerOrgName) {
		this.proposerOrgName = proposerOrgName;
	}
	public String getProposerAreaName() {
		return proposerAreaName;
	}
	public void setProposerAreaName(String proposerAreaName) {
		this.proposerAreaName = proposerAreaName;
	}
	public String getProposerOrgCode() {
		return proposerOrgCode;
	}
	public void setProposerOrgCode(String proposerOrgCode) {
		this.proposerOrgCode = proposerOrgCode;
	}
	public String getPassiveUser() {
		return passiveUser;
	}
	public void setPassiveUser(String passiveUser) {
		this.passiveUser = passiveUser;
	}
	public String getProposerUserId() {
		return proposerUserId;
	}
	public void setProposerUserId(String proposerUserId) {
		this.proposerUserId = proposerUserId;
	}
	public String getPassiveUserId() {
		return passiveUserId;
	}
	public void setPassiveUserId(String passiveUserId) {
		this.passiveUserId = passiveUserId;
	}
	public String getPassiveAreaName() {
		return passiveAreaName;
	}
	public void setPassiveAreaName(String passiveAreaName) {
		this.passiveAreaName = passiveAreaName;
	}
	public String getPassiveOrgName() {
		return passiveOrgName;
	}
	public void setPassiveOrgName(String passiveOrgName) {
		this.passiveOrgName = passiveOrgName;
	}
	public String getPassiveOrgCode() {
		return passiveOrgCode;
	}
	public void setPassiveOrgCode(String passiveOrgCode) {
		this.passiveOrgCode = passiveOrgCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getHandingSuggestion() {
		return handingSuggestion;
	}
	public void setHandingSuggestion(String handingSuggestion) {
		this.handingSuggestion = handingSuggestion;
	}
	public String getExamineUser() {
		return examineUser;
	}
	public void setExamineUser(String examineUser) {
		this.examineUser = examineUser;
	}
	public Integer getExamineUserId() {
		return examineUserId;
	}
	public void setExamineUserId(Integer examineUserId) {
		this.examineUserId = examineUserId;
	}
	public Integer getExamineStatus() {
		return examineStatus;
	}
	public void setExamineStatus(Integer examineStatus) {
		this.examineStatus = examineStatus;
	}
	public Date getExamineTime() {
		return examineTime;
	}
	public void setExamineTime(Date examineTime) {
		this.examineTime = examineTime;
		this.examineTimeStr=DateUtil.getStringByDate(examineTime, "yyyy/MM/dd");
	}
	public String getExamineTimeStr() {
		return examineTimeStr;
	}
	public void setExamineTimeStr(String examineTimeStr) {
		this.examineTimeStr = examineTimeStr;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
		this.createTimeStr=DateUtil.getStringByDate(createtime, "yyyy/MM/dd HH:mm");
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getTransType() {
		return transType;
	}
	public void setTransType(Integer transType) {
		this.transType = transType;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	/**
	 * 审核状态：1未处理，2通过，3驳回
	 * @return
	 */
	public String getExamineStatusStr(){
		String examineStatusStr = "";
		Integer examineStatus = this.examineStatus;
		if(examineStatus!=null){
			if(examineStatus==1){
				examineStatusStr = "未处理";
			}else if(examineStatus==2){
				examineStatusStr = "通过";
			}else if(examineStatus==3){
				examineStatusStr = "驳回";
			}
		}
		return examineStatusStr;
	}
	/**
	 * 打假类型1房源打假，2实勘打假，3钥匙打假 4:委托书打假
	 * @return
	 */
	public String getTypeStr(){
		String typeStr = "";
		Integer type = this.type;
		if(typeStr!=null){
			if(type==1){
				typeStr = "房源打假";
			}else if(type==2){
				typeStr = "实勘打假";
			}else if(type==3){
				typeStr = "钥匙打假";
			}else if(type==4){
				typeStr = "委托书打假";
			}
		}
		return typeStr;
	}
	/**
	 *交易类型1 买卖 2 租赁
	 * @return
	 */
	public String getTransTypeStr(){
		String transTypeStr = "";
		Integer transType = this.transType;
		if(transType!=null){
			if(transType==1){
				transTypeStr = "买卖";
			}else if(transType==2){
				transTypeStr = "租赁";
			}
		}
		return transTypeStr;
	}
	/**
	 * 使用类别 1:住宅 2:商铺3:写字楼4:车库
	 * @return
	 */
	public String getUseTypeStr(){
		String useTypeStr = "";
		Integer useType = this.useType;
		if(useType!=null){
			if(useType==1){
				useTypeStr = "住宅";
			}else if(useType==2){
				useTypeStr = "商铺";
			}else if(useType==3){
				useTypeStr = "写字楼";
			}else if(useType==4){
				useTypeStr = "车库";
			}
		}
		return useTypeStr;
	}
	
	/**
	 * ----房源打假-----
	 * @return 房源打假地址
	 */
	private String houseFakeAddr;
	/**
	 * 房源打假业主
	 */
	private String fakeOwer;
	/**
	 * 房源打假业主联系方式
	 */
	private String fakeTell;

	public String getHouseFakeAddr() {
		return houseFakeAddr;
	}
	public void setHouseFakeAddr(String houseFakeAddr) {
		this.houseFakeAddr = houseFakeAddr;
	}
	public String getFakeOwer() {
		return fakeOwer;
	}
	public void setFakeOwer(String fakeOwer) {
		this.fakeOwer = fakeOwer;
	}
	public String getFakeTell() {
		return fakeTell;
	}
	public void setFakeTell(String fakeTell) {
		this.fakeTell = fakeTell;
	}
	
	
	/**
	 * ----钥匙打假-----
	 * @return 
	 */
	//存放部门实体店
	private String depositStore;
	/**
	 * 钥匙类型：1电子钥匙，2普通钥匙
	 */
	private Integer keyType;
	/**
	 * 钥匙实体店联系方式
	 */
	private String storeTell;

	public String getDepositStore() {
		return depositStore;
	}
	public void setDepositStore(String depositStore) {
		this.depositStore = depositStore;
	}
	public Integer getKeyType() {
		return keyType;
	}
	public void setKeyType(Integer keyType) {
		this.keyType = keyType;
	}
	public String getStoreTell() {
		return storeTell;
	}
	public void setStoreTell(String storeTell) {
		this.storeTell = storeTell;
	}
	/**
	 * 钥匙类型：1电子钥匙，2普通钥匙 3密码
	 * @return
	 */
	public String getKeyTypeStr(){
		String keyTypeStr = "";
		Integer keyType = this.keyType;
		if(keyType!=null){
			if(keyType==1){
				keyTypeStr = "电子钥匙";
			}else if(keyType==2){
				keyTypeStr = "普通钥匙";
			}else if(keyType==3){
				keyTypeStr = "密码";
			}
		}
		return keyTypeStr;
	}
	
	/**
	 * ----委托书打假-----
	 * @return 
	 */
	//签订时间
	private Date signTime;
	private String signTimeStr;
	/**
	 * 委托书编号
	 */
	private String proxyCode;
	/**
	 * 文件夹名
	 */
	private String folderName;
	/**
	 * 文件名
	 */
	private String fileName;

	
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
		this.signTimeStr=DateUtil.getStringByDate(signTime, "yyyy/MM/dd HH:mm");
	}
	public String getSignTimeStr() {
		return signTimeStr;
	}
	public void setSignTimeStr(String signTimeStr) {
		this.signTimeStr = signTimeStr;
	}
	public String getProxyCode() {
		return proxyCode;
	}
	public void setProxyCode(String proxyCode) {
		this.proxyCode = proxyCode;
	}
}