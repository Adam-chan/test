package com.golden.ihome.crm.service.users;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.common.HouseCommon;
import com.golden.ihome.common.SysParam;
import com.golden.ihome.crm.dao.sysParame.SysParamDao;
import com.golden.ihome.crm.dao.users.UserDao;
import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.ihome.crm.model.UserCheckModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;

@Service("users/userService")
public class UserService implements IBaseHandler{

	@Autowired
	private UserDao userDao;
	@Autowired
	private SysParamDao sysParamDao;
	/**
	 * 查看电话，地址
	 * 参数：
	 * 		seeType:查看类型。1电话，2地址,3证载地址
	 * 		demandType:需求类型，1买卖 2租赁，
	 * 		userId:用户ID
	 * 		userPosi:用户类型1经纪人，2组长，3区经理，4大区经理
	 */
	@TM
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		String userId = param.get("userId").toString();//用户ID
		String userType = param.get("userPosi").toString();//用户职位类型
		String orgCode = param.get("orgCode").toString();//组织编号
		String demandType = param.get("demandType").toString();//需求类型1租赁，2买卖
		String seeType = param.get("seeType").toString();//查看类型，1电话，2地址
		String houseId = param.get("houseId").toString();//查看的房源ID
		List<String> houseOrgMapList = userDao.checkHouseJyPerview(param);
		
		Map<String, Object> houseOrgMap = userDao.checkHouseZrPerview(param);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		String resultStr = "0";//正常
		if(houseOrgMap == null){
			resultStr =  "3";//非法操作
		}else {
			Boolean flag = false;
			String DIVIDE_ORG_CODE = (String)houseOrgMap.get("DIVIDE_ORG_CODE");
			String DIVIDE_USER_ID = (String)houseOrgMap.get("DIVIDE_USER_ID");
			//如果判断是否有责任权限
			if(DIVIDE_ORG_CODE !=null && (DIVIDE_ORG_CODE.startsWith(orgCode) || orgCode.startsWith(DIVIDE_ORG_CODE))){
				flag = true;
			}else if(DIVIDE_USER_ID!=null && DIVIDE_USER_ID.equals(userId)){
				flag = true;
			}else{
				String dataPowers =(String)param.get("dataPowers");
				flag = dataPowers== null || dataPowers.equals("") ?false :HouseCommon.checkOperatePerview(houseOrgMapList,dataPowers);
			}
			if(!flag){
				resultStr = "2";//没有权限
			}
			//首先查询出该用户是否记录过，如果没记录过，则返回为NULL，
			UserCheckModel userCheckInfo = userDao.getUserCheckInfo(userId);
			if(null == userCheckInfo){
				//如果是第一次保存用户，则直接插入数据
				userCheckInfo = new UserCheckModel();
				userCheckInfo.setUserId(userId);
				userCheckInfo.setUserType(Integer.valueOf(userType));
				userCheckInfo.setOrgCode(orgCode);
				//租赁
				if(demandType.equals("2")){
					//电话次数
					if(seeType.equals("1")){
						userCheckInfo.setHouseLeaseTellCount(1);
					}else{
						//地址次数
						userCheckInfo.setHouseLeaseAddrCount(1);
					}
				}else{//买卖
					//电话次数
					if(seeType.equals("1")){
						userCheckInfo.setHouseSaleTellCount(1);
					}else{//地址次数
						userCheckInfo.setHouseSaleAddrCount(1);
					}
				}
				userDao.insertUserCheck(userCheckInfo);
			}else {
				//如果是房源，则分为查看电话和查看地址
				String [] strList = getConfigListStr(SysParam.FYCKDH,userType);
				//如果最后操作时间和当前日期是同一天。则判断次数，否则计数重新开始
				if(DateUtil.getStringByDate(userCheckInfo.getOperateTime(),"yyyy-MM-dd").equals(DateUtil.getStringByDate(new Date(),"yyyy-MM-dd"))){
					flag = this.reckonHouse(userCheckInfo,seeType,demandType,strList);
					//1买卖房源地址查看次数，2买卖房源电话查看次数，3租赁房源地址查看次数，4租赁房源电话查看次数
					//用户类型1经纪人，2组长，3区经理，4大区经理
				}else{
					//不是同一天，重新计数
					userCheckInfo.setCustomerLeaseTellCount(0);
					userCheckInfo.setCustomerSaleTellCount(0);
					userCheckInfo.setHouseLeaseAddrCount(0);
					userCheckInfo.setHouseLeaseTellCount(0);
					userCheckInfo.setHouseSaleAddrCount(0);
					userCheckInfo.setHouseSaleTellCount(0);
					userCheckInfo.setOperateTime(new Date());
					flag = this.reckonHouse(userCheckInfo,seeType,demandType,strList);
				}
			}
			if(flag){
				userDao.updateUserCheck(userCheckInfo);
				if(seeType.equals("1")){
					List<Map<String, Object>> houseInfoContact = userDao.getHouseInfoContact(houseId);
					for(Map<String, Object> map : houseInfoContact){
						map.put("TYPE", HouseCommon.getLinkTypeStr(Integer.valueOf(map.get("TYPE").toString())));
					}
					resultMap.put("dataList", houseInfoContact);
					
				}else{
					//2房源详细地址ADDRESS_DETAIL,3是证载地址ZZDZ_DETAIL
					Map<String,Object> result = userDao.getHouseInfoAddress(param);
					if(seeType.equals("2")){
						//2房源详细地址
						resultMap.put("address",result.get("ADDRESS_DETAIL").toString());
					}else{
						//3是证载地址
						resultMap.put("address",result.get("ZZDZ_DETAIL").toString());
					}
				}
			}
		}
		resultMap.put("code", resultStr);
		//房源
		resultMap.put("CKLB", "house");
		return resultMap;//次数受限
	}
	private Boolean reckonHouse(UserCheckModel userCheckInfo,String seeType,String demandType,String [] strList){
		if(null == strList ||strList.length == 0 ){
			//如果系统未设置，则直接返回
			return true;
		}
		//如果1查看的是电话，否则2查看地址
		if(seeType.equals("1")){
			//如果查看的是租赁电话,否则买卖电话
			if(demandType.equals("2")){
				if(userCheckInfo.getHouseLeaseTellCount() >= Integer.valueOf(strList[3])){
					//租赁电话次数超限
					return false;
				}else{
					//增加一次
					userCheckInfo.setHouseLeaseTellCount(userCheckInfo.getHouseLeaseTellCount()+1);
				}
			}else{
				if(userCheckInfo.getHouseSaleTellCount() >= Integer.valueOf(strList[1])){
					//买卖电话次数超限
					return false;
				}else{
					//增加一次
					userCheckInfo.setHouseSaleTellCount(userCheckInfo.getHouseSaleTellCount()+1);
				}
			}
		}else{
			//如果查看的是租赁地址，否则买卖地址
			if(demandType.equals("2")){
				if(userCheckInfo.getHouseLeaseAddrCount() >= Integer.valueOf(strList[2])){
					//租赁地址次数超限
					return false;
				}else{
					//增加一次
					userCheckInfo.setHouseLeaseAddrCount(userCheckInfo.getHouseLeaseAddrCount()+1);
				}
			}else{
				if(userCheckInfo.getHouseSaleAddrCount() >= Integer.valueOf(strList[0])){
					//买卖地址次数超限
					return false;
				}else{
					//增加一次
					userCheckInfo.setHouseSaleAddrCount(userCheckInfo.getHouseSaleAddrCount()+1);
				}
			}
		}
		return true;
	}
	
	/**
	 * 客源查看电话
	 * demandId 查看的客源需求ID 
	 * demandCode 查看的客源需求编号
	 * userId
	 * userPosi 用户职位类型
	 * orgCode 组织编号
	 * demandType 擦看类型，1租赁2买卖
	 */
	@TM
	public Map<String, Object> customerTell(Map<String, Object> param){
		String userId = param.get("userId").toString();//用户ID
		String userType = param.get("userPosi").toString();//用户类型
		String orgCode = param.get("orgCode").toString();//组织编号
		String demandType = param.get("demandType").toString();//需求类型1租赁，2买卖
/*		String demandId = (String)param.get("demandId");//查看的客源需求ID 
		String demandCode = (String)param.get("demandCode");//查看的客源需求编号*/
		UserCheckModel userCheckInfo = userDao.getUserCheckInfo(userId);
		Boolean flag = false;
		Map<String, Object> cp = userDao.checkCustomerPriv(param);
		
		String ORG_CODE = cp.get("ORG_CODE").toString();
		String OPERATE_USER_ID = cp.get("OPERATE_USER_ID").toString();
		String CD_TYPE = cp.get("CD_TYPE").toString();
		String flagStr = "0";
		//如果是私客
		if(CD_TYPE.equals("1")){
			//如果是经纪人查看。则需要判断是否是自己私客
			if(userType.equals("1") && userId.equals(OPERATE_USER_ID)){
				flag = true;
			}else{
				//如果不是经纪人，匹配组织结构
				if(ORG_CODE.startsWith(orgCode)){
					flag = true;
				}
			}
		}else {
			//如果不是私客。是公客，则判断是组公客还是区公客
			String occ = null;
			if(CD_TYPE.equals("2")){//02.01.01.01.01
				occ = orgCode.substring(0, 12);
			}else if(CD_TYPE.equals("3")){
				occ = orgCode.substring(0, 9);
			}
			if(ORG_CODE.startsWith(occ)){
				flag = true;
			}
		}
		if(!flag){
			flagStr = "2";//没有权限看该用户电话
		}else if(null == userCheckInfo){
			//如果是第一次保存用户，则直接插入数据
			userCheckInfo = new UserCheckModel();
			userCheckInfo.setUserId(userId);
			userCheckInfo.setUserType(Integer.valueOf(userType));
			userCheckInfo.setOrgCode(orgCode);
			//租赁
			if(demandType.equals("2")){
				//电话次数
				userCheckInfo.setCustomerLeaseTellCount(1);
			}else{//买卖
				//电话次数
				userCheckInfo.setCustomerSaleTellCount(1);
			}
			userDao.insertUserCheck(userCheckInfo);
		}else {
			String [] strList = getConfigListStr(SysParam.KYCKDH,userType);
			//如果最后操作时间和当前日期是同一天。则判断次数，否则计数重新开始
			if(DateUtil.getStringByDate(userCheckInfo.getOperateTime(),"yyyy-MM-dd").equals(DateUtil.getStringByDate(new Date(),"yyyy-MM-dd"))){
				flag = reckonCustomer(userCheckInfo,demandType,strList);
				//1买卖房源地址查看次数，2买卖房源电话查看次数，3租赁房源地址查看次数，4租赁房源电话查看次数
				//用户类型1经纪人，2组长，3区经理，4大区经理
			}else{
				//不是同一天，重新计数
				userCheckInfo.setCustomerLeaseTellCount(0);
				userCheckInfo.setCustomerSaleTellCount(0);
				userCheckInfo.setHouseLeaseAddrCount(0);
				userCheckInfo.setHouseLeaseTellCount(0);
				userCheckInfo.setHouseSaleAddrCount(0);
				userCheckInfo.setHouseSaleTellCount(0);
				userCheckInfo.setOperateTime(new Date());
				flag = reckonCustomer(userCheckInfo,demandType,strList);
			}
			if(flag){
				userDao.updateUserCheck(userCheckInfo);
				Map<String,Object> cusMap = userDao.getCustomerInfoTell(param);
				cusMap.put("code",flagStr);
				cusMap.put("CKLB", "customer");
				return cusMap;
			}else{
				//数量达到上限
				flagStr = "1";
			}
		}
		param.clear();
		param.put("code", flagStr);
		//客源查看
		param.put("CKLB", "customer");
		return param;
	}
	private Boolean reckonCustomer(UserCheckModel userCheckInfo,String demandType,String [] strList){
		if(null == strList ||strList.length == 0 ){
			//如果系统未设置，则直接返回
			return true;
		}
		//如果查看的是1买卖电话,否则2租赁电话
		if(demandType.equals("2")){
			if(userCheckInfo.getCustomerLeaseTellCount() >= Integer.valueOf(strList[1])){
				//租赁电话次数超限
				return false;
			}else{
				//增加一次
				userCheckInfo.setCustomerLeaseTellCount(userCheckInfo.getCustomerLeaseTellCount()+1);
			}
		}else{
			if(userCheckInfo.getCustomerSaleTellCount() >= Integer.valueOf(strList[0])){
				//买卖电话次数超限
				return false;
			}else{
				//增加一次
				userCheckInfo.setCustomerSaleTellCount(userCheckInfo.getCustomerSaleTellCount()+1);
			}
		}
		return true;
	}
	private String [] getConfigListStr(String key,String userType){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sysCoustomerType", key);
		List<SysParameterModel> sysHouseList = sysParamDao.getSysCustomerList(map);
		String [] strList = null;
		//获取当前人职位的配置。
		for(SysParameterModel spm : sysHouseList){
			strList = spm.getSysCoustomerTDescribe().split(",");
			if(spm.getSysCoustomerDescribe().equals(userType)){
				break;
			}
		}
		return strList;
	}
}
