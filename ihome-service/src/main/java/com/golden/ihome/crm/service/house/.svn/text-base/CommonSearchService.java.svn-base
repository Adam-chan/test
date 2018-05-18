package com.golden.ihome.crm.service.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.golden.ihome.common.HouseCommon;
import com.golden.ihome.crm.dao.fake.FakeDao;
import com.golden.ihome.crm.dao.house.CommonSearchDao;
import com.golden.ihome.crm.dao.house.HouseLeaseDao;
import com.golden.ihome.crm.dao.house.HouseSaleDao;
import com.golden.ihome.crm.dao.house.ManageTimeLimitExpressDao;
import com.golden.ihome.crm.dao.users.UserDao;
import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.ihome.crm.model.HouseAffiliationLogModel;
import com.golden.ihome.crm.model.HouseDeedModel;
import com.golden.ihome.crm.model.HouseLeaseModel;
import com.golden.ihome.crm.model.HousePorxyModel;
import com.golden.ihome.crm.model.HouseSaleModel;
import com.golden.ihome.crm.model.ManageProspectImageModel;
import com.golden.ihome.crm.model.ManageProspectInfoModel;
import com.golden.ihome.crm.model.ManageTimeLimitExpressModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

@Service("house/commonSearchService")
public class CommonSearchService implements IBaseHandler {

	@Autowired
	private CommonSearchDao commonSearchDao;
	
	@Autowired
	private FakeDao fakeDao;
	
	@Autowired
	private HouseLeaseDao houseLeaseDao;
	@Autowired
	private HouseSaleDao houseSaleDao;
	@Autowired
	private ManageTimeLimitExpressDao manageTimeLimitExpressDao;
	@Autowired
	private UserDao userDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询收藏数据
	 */
	public Integer queryCollect(Map<String, Object> param) throws Exception {
		// 测试-收藏人
		param.put("userName", 210702);
		return commonSearchDao.queryCollect(param);
	}

	/**
	 * 收藏
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer addCollect(Map<String, Object> param) throws Exception {
		param.put("careteTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		commonSearchDao.addCollect(param);
		return Integer.parseInt(param.get("collectId").toString());
	}

	/**
	 * 取消收藏
	 */
	@TM
	public Integer deleteCollect(Map<String, Object> param) throws Exception {
		return commonSearchDao.deleteCollect(param);
	}
	
	/**
	 * 查询实勘信息
	 */
	public ManageProspectInfoModel getManageProspectInfo(Map<String,Object> map){
		return commonSearchDao.getManageProspectInfo(map);
	}
	
	/**
	 * 查询实勘图片
	 */
	public PagerResult<ManageProspectImageModel> getManageProspectImagePage(Map<String, Object> map){
		return commonSearchDao.getManageProspectImagePage(map);
	}

	/**
	 * 保存实勘信息
	 */
	@TM
	public Integer saveProspectInfo(Map<String, Object> param) {
		return commonSearchDao.saveProspectInfo(param);
	}
	
	/**
	 * 查询插入的实勘ID
	 */
	public Integer getLastInsertProspectId(Map<String, Object> map) {
		return commonSearchDao.getLastInsertProspectId(map);
	}
	
	/**
	 * 保存上传的实勘图片
	 */
	@TM
	public int saveProspectPicture(Map<String, Object> param) {
		String dataStr = (String) param.get("dataStr");
		JSONArray parseArray = JSON.parseArray(dataStr);
		param.put("dataStr", parseArray);
		int result = commonSearchDao.saveProspectPicture(param);
		return result;
	}

	/**
	 * 删除实勘图片
	 */
	@TM
	public int deletePicture(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		ArrayList<String> idList = (ArrayList<String>) param.get("idList");
		String rowIdsStr = "";
		for (String id : idList) {
			rowIdsStr = rowIdsStr + id + ",";
		}
		rowIdsStr = rowIdsStr.substring(0, rowIdsStr.length() - 1);
		param.put("rowIdsStr", rowIdsStr);
		int result = commonSearchDao.deletePicture(param);
		return result;
	}

	/**
	 * 提交实勘
	 */
	@TM
	public Integer submitProspect(@RequestParam Map<String,Object> param) {
		return commonSearchDao.submitProspect(param);
	}
	
	/**
	 * 添加跟进
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer addFollow(Map<String, Object> param) throws Exception {
		param.put("createTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		commonSearchDao.addFollow(param);
		return Integer.parseInt(param.get("followId").toString());
	}

	/**
	 * 查询空看数据
	 */
	public Integer querySpaceSee(Map<String, Object> param) throws Exception {
		// 测试-空看人
		param.put("operateUserId", "0003fe98-80cd-40a1-a4e4-59c195d9e087");
		return commonSearchDao.querySpaceSee(param);
	}

	/**
	 * 添加空看
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer addSpaceSee(Map<String, Object> param) throws Exception {
		String orgCodelist = (String) param.get("orgCodelist");
		param.put("houseId", param.get("houseInfoId"));
		List<String> houseOrgMapList = userDao.checkHouseJyPerview(param);
		Boolean flag = HouseCommon.checkOperatePerview(houseOrgMapList,orgCodelist);
		if(flag) {
			param.put("ifOperate", 0);
		} else {
			param.put("ifOperate", 1);
		}
		param.put("createTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		commonSearchDao.addSpaceSee(param);
		return Integer.parseInt(param.get("spaceSeeId").toString());
	}

	/**
	 * 配客列表
	 */
	public PagerResult<CustomerSourceModel> getMatchCustomerListForPage(Map<String, Object> param) throws Exception {
		return commonSearchDao.getMatchCustomerListForPage(param);
	}

	/**
	 * 查询钥匙数据
	 */
	public Integer queryReceiveKey(Map<String, Object> param) throws Exception {
		return commonSearchDao.queryReceiveKey(param);
	}

	/**
	 * 添加钥匙
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer addKey(Map<String, Object> param) throws Exception {
		param.put("createTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		commonSearchDao.addKey(param);
		return Integer.parseInt(param.get("keyId").toString());
	}

	/**
	 * 查询保护数据
	 */
	public Integer queryProtect(Map<String, Object> param) throws Exception {
		return commonSearchDao.queryProtect(param);
	}

	/**
	 * 保护列表
	 */
	public PagerResult<Map<String, Object>> getProtectListForPage(Map<String, Object> param) throws Exception {
		return commonSearchDao.getProtectListForPage(param);
	}

	/**
	 * 添加保护
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer addProtect(Map<String, Object> param) throws Exception {
		if(commonSearchDao.queryProtect(param) != 0) {
			return -1;
		}
		if(commonSearchDao.queryProtectCount(param) == 0) {
			return -2;
		}
		commonSearchDao.addProtect(param);
		return Integer.parseInt(param.get("protectId").toString());
	}

	/**
	 * 查询委托书数据
	 */
	public Map<String, Object> queryProxyInput(Map<String, Object> param) throws Exception {
		return commonSearchDao.queryProxyInput(param);
	}
	
	/**
	 * 查询委托书数据 LB
	 */
	public HousePorxyModel queryProxyInfo(Map<String, Object> param) throws Exception {
		return commonSearchDao.queryProxyInfo(param);
	}
	/**
	 * 添加委托书
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer addProxyInput(@RequestParam Map<String,Object> param) {
		return 	commonSearchDao.addProxyInput(param);
	}

	/**
	 * 撤销委托书
	 */
	@TM
	public Integer deleteProxyInput(@RequestParam Map<String,Object> param) {
		return commonSearchDao.deleteProxyInput(param);
	}
	/**
	 * 查看打假open
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Map<String,Object> queryFakeInfo(@RequestParam Map<String,Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(param.get("transType").toString().equals("1")){
			map.put("houseSaleInfo", houseSaleDao.getDetail(param));
		}else{
			map.put("houseLeaseInfo", houseLeaseDao.getDetail(param));//房源和钥匙
		}
		HousePorxyModel houseProxyInfo = commonSearchDao.queryProxyInfo(param);
		map.put("houseProxyInfo", houseProxyInfo);//查询房源委托
		ManageProspectInfoModel houseSKInfo = commonSearchDao.getManageProspectInfo(param);
		map.put("houseSKInfo", houseSKInfo);//实勘
		return map;
	}
	/**
	 * 添加打假
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer insertFake(@RequestParam Map<String,Object> param) {
		// 测试-打假
		int result = 1;
		String fakeType = param.get("type").toString();
		Integer fakeCheckCount = fakeDao.getFakeCheck(param);
			if(fakeCheckCount==1){
				return result = 2;//审核时 是单线程
			}
		param.put("proposerOrgName", "打假申请人所在组织名称(操作打假的经纪人)");//当前登录人
		param.put("proposerAreaName", "打假申请人所在区名称(操作打假的经纪人)");//test
		param.put("createTime",  DateUtil.getDateByLong(System.currentTimeMillis()));//打假时间
		param.put("examineStatus",1);//审核状态
		fakeDao.insertFake(param);
		param.put("fakeId",Integer.parseInt(param.get("fakeId").toString())+1);
		if(fakeType.equals("1")){
			fakeDao.insertHouseFake(param);//房源打假
		}else if(fakeType.equals("2")){
			//实勘打假
		}else if(fakeType.equals("3")){
			fakeDao.insertKeyFake(param);//钥匙打假
		}else{
			fakeDao.insertProxyFake(param);//委托书打假
		}
		return result;
	}
	/**
	 * 房源归属open
	 */
	public Map<String,Object> queryHouseOwnerInfo(@RequestParam Map<String,Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(param.get("transType").toString().equals("1")){
			HouseSaleModel houseSaleInfo = houseSaleDao.getDetail(param);
			map.put("houseSaleInfo", houseSaleInfo);
		}else{
			HouseLeaseModel houseLeaseInfo = houseLeaseDao.getDetail(param);
			map.put("houseLeaseInfo", houseLeaseInfo);
		}//登记 维护
		List<HouseAffiliationLogModel> houseGsLogList = commonSearchDao.queryHouseGsLogList(param);
		map.put("houseGsLogList", houseGsLogList);//查询房源归属记录
		HousePorxyModel houseProxyInfo = commonSearchDao.queryProxyInfo(param);
		map.put("houseProxyInfo", houseProxyInfo);//查询房源委托
		ManageTimeLimitExpressModel houseDJInfo = manageTimeLimitExpressDao.getTimeLimitInfo(param);
		map.put("houseDJInfo", houseDJInfo);//查询限时速递
		ManageProspectInfoModel houseSKInfo = commonSearchDao.getManageProspectInfo(param);
		map.put("houseSKInfo", houseSKInfo);//实勘
		return map;
	}
	
	
	/**
	 * 查询房源归属记录
	 */
	public List<HouseAffiliationLogModel> queryHouseGsLogList(@RequestParam Map<String,Object> param) {
		return commonSearchDao.queryHouseGsLogList(param);
	}
	/**
	 * 更改房源归属人
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer updateOwner(@RequestParam Map<String,Object> param) {
		int result = 1;
		String affiliationType = param.get("affiliationType").toString();
		param.put("id", param.get("id").toString());
		param.put("houseInfoId", param.get("houseInfoId").toString());
		param.put("operateTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		if(affiliationType.equals("1")){//维护归属
			houseSaleDao.updateHouseInfoById(param);//更新维护归属人数据 houseInfo表//参数houseInfoId
		}else if(affiliationType.equals("2")){//委托归属
			commonSearchDao.updateProxyInfo(param);
		}else if(affiliationType.equals("3")){//实勘归属
			commonSearchDao.updateProspectInfo(param);
		}else if(affiliationType.equals("4")){//独家归属
			manageTimeLimitExpressDao.updataStuts(param);//参数Id 当前表主键
		}else if(affiliationType.equals("5")){//钥匙归属
			commonSearchDao.updateKeyInfo(param);
		}else if(affiliationType.equals("6")){
			//成交归属
		}else{
			result = 0;
		}
		param.put("affiliationOld", param.get("affiliationOld").toString());
		param.put("affiliationNow", param.get("divideOrg").toString()+param.get("divideUser").toString());
		commonSearchDao.insertHouseGsLog(param);//新增操作日志记录
		return result;
	}
	/**
	 * 查询房产证数据 LB
	 */
	public HouseDeedModel queryHouseDeed(Map<String, Object> param) throws Exception {
		return commonSearchDao.queryDeedInfo(param);
	}
	/**
	 * 添加房产证
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer insertHouseDeed(@RequestParam Map<String,Object> param) {
		return 	commonSearchDao.insertDeedInput(param);
	}
	/**
	 * 撤销房产证
	 */
	@TM
	public Integer deleteHouseDeed(@RequestParam Map<String,Object> param) {
		return commonSearchDao.deleteDeedInput(param);
	}
}