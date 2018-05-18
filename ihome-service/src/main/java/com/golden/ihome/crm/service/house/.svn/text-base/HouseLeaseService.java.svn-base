package com.golden.ihome.crm.service.house;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.golden.ihome.addr.dao.carPort.CarPortDao;
import com.golden.ihome.addr.dao.premisesManage.BasePremisesDao;
import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.addr.model.CarPortModel;
import com.golden.ihome.addr.model.EduFacilityModel;
import com.golden.ihome.common.CodeConst;
import com.golden.ihome.common.service.CommonCode;
import com.golden.ihome.crm.dao.house.CommonSearchDao;
import com.golden.ihome.crm.dao.house.HouseLeaseDao;
import com.golden.ihome.crm.dao.house.HouseSaleDao;
import com.golden.ihome.crm.dao.sysParame.SysParamDao;
import com.golden.ihome.crm.dao.users.UserDao;
import com.golden.ihome.crm.model.AddrDetailModel;
import com.golden.ihome.crm.model.HouseLeaseModel;
import com.golden.ihome.crm.model.HouseLinkManModel;
import com.golden.ihome.crm.model.HouseSaleModel;
import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

/**
 * @author dl
 * 类名称：租赁房源service
 * 时间：2016-11-1
 */
@Service("house/houseLeaseService")
public class HouseLeaseService implements IBaseHandler{

	@Autowired
	private HouseLeaseDao houseLeaseDao;
	@Autowired
	private HouseSaleDao houseSaleDao;
	@Autowired
	private CarPortDao carPortDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SysParamDao sysParamDao;
	
	@Resource(name="commonCode")
	private CommonCode commonCode;
	@Autowired
	private BasePremisesDao basePremisesDao;
	@Autowired
	private CommonSearchDao commonSearchDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 模糊查询详细地址 dl
	 * @param map 参数:matchStr
	 * @return
	 */
	public List<AddrDetailModel> getAddrDetail(Map<String,Object> map){
		return houseLeaseDao.getAddrDetail(map);
	}
	/**
	 * 模糊查询详细地址B(用于：房源-车位) dl
	 * @param map 参数:matchStr
	 * @return
	 */
	public List<AddrDetailModel> getAddrDetailB(Map<String,Object> map){
		return houseLeaseDao.getAddrDetailB(map);
	}
	/**
	 * 新增租赁房源 dl
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@TM
	public Integer insertHouseLease(Map<String,Object> map) throws Exception{
		map.put("code", commonCode.getCode(CodeConst.ZL_CODE));
		map.put("demandType", 2);
		Map<String, Object> result = userDao.getZrByRoomId(map);
		if(null != result){
			//ORG_CODE, USER_ID,USER_NAME,AREA_NAME,ZONE_NAME,GROUP_NAME
			map.put("divideId", result.get("USER_ID").toString());
			map.put("divideUser", result.get("USER_NAME").toString());
			map.put("divideOrg", result.get("GROUP_NAME").toString());
			map.put("divideOrgCode", result.get("ORG_CODE").toString());
			map.put("divideQu", result.get("ZONE_NAME").toString());
			map.put("divideDaQu", result.get("AREA_NAME").toString());
		}
		houseLeaseDao.insertHourseInfo(map);
		map.put("houseInfoId", (Integer.parseInt(map.get("houseInfoId").toString())+1));
		String useType = map.get("useType").toString();//使用类别
		if(useType.equals("4")){//车位
			houseLeaseDao.insertCarPortLease(map);
		}else{//住宅、商铺、写字楼
			houseLeaseDao.insertHouseLease(map);
		}
		//保存房源联系人
		Map<String,Object> linkManMap = new HashMap<String,Object>();
		String[] linkMan = map.get("linkManList").toString().split("-");
		List<HouseLinkManModel> linkManList = new ArrayList<HouseLinkManModel>();
		for (int m = 0; m < linkMan.length; m++) {
			JSONObject obj = JSON.parseObject(linkMan[m]);
			HouseLinkManModel man = new HouseLinkManModel();
			man.setType(Integer.parseInt(obj.get("type").toString()));
			man.setName(obj.get("name").toString());
			man.setContactType(obj.get("contactType").toString());
			linkManList.add(man);
		}
		linkManMap.put("linkManList", linkManList);
		linkManMap.put("houseInfoId", Integer.parseInt(map.get("houseInfoId").toString()));
		carPortDao.insertHouseLinkMans(linkManMap);
		if(useType.equals("4")){
			//回写车位状态
			Map<String, Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("carPortId", map.get("carPortId"));
			Integer saledIs = (Integer) carPortDao.carPortSaledIs(paramsMap);
			Integer authorize = 1;
			if(saledIs>0){
				authorize = 3;
			}
			paramsMap.put("authorize", authorize);
			carPortDao.updateAuthorizeByPortId(paramsMap);
		}
		return 1;
	}
	/**
	 * 修改房源 dl
	 * @param map
	 * @return
	 */
	@TM
	public Integer updateHouseLeaseById(Map<String,Object> map){
		if(!map.get("useType").toString().equals("4")){
			map.put("demandType", 2);
			Map<String, Object> result = userDao.getZrByRoomId(map);
			if(null != result){
				//ORG_CODE, USER_ID,USER_NAME,AREA_NAME,ZONE_NAME,GROUP_NAME
				map.put("divideId", result.get("USER_ID").toString());
				map.put("divideUser", result.get("USER_NAME").toString());
				map.put("divideOrg", result.get("GROUP_NAME").toString());
				map.put("divideOrgCode", result.get("ORG_CODE").toString());
				map.put("divideQu", result.get("ZONE_NAME").toString());
				map.put("divideDaQu", result.get("AREA_NAME").toString());
			}
			map.put("nowTime", new Date());
			houseLeaseDao.updateHouseInfoById(map);
		}
		//更新houseLease
		houseLeaseDao.updateHouseLeaseById(map);
		//查询已存在联系人
		List<HouseLinkManModel> lmList = houseLeaseDao.getHouseLinkManList(map);
		String lmStr = new String();
		if(!lmList.isEmpty()){
			for (int k = 0; k < lmList.size(); k++) {
				lmStr+=lmList.get(k).getId()+",";
			}
			//删除已存在联系人
			houseLeaseDao.deleteHouseLinkMans(lmStr.substring(0, lmStr.length()-1));
		}
		//保存联系人
		Map<String,Object> linkManMap = new HashMap<String,Object>();
		String[] linkMan = map.get("linkManList").toString().split("-");
		List<HouseLinkManModel> linkManList = new ArrayList<HouseLinkManModel>();
		for (int n = 0; n < linkMan.length; n++) {
			JSONObject obj = JSON.parseObject(linkMan[n]);
			HouseLinkManModel man = new HouseLinkManModel();
			man.setType(Integer.parseInt(obj.get("type").toString()));
			man.setName(obj.get("name").toString());
			man.setContactType(obj.get("contactType").toString());
			linkManList.add(man);
		}
		linkManMap.put("linkManList", linkManList);
		linkManMap.put("houseInfoId", Integer.parseInt(map.get("houseInfoId").toString()));
		carPortDao.insertHouseLinkMans(linkManMap);
		//判断价格是否发生改动
		Double newLeasePrice = null;
		Double oldLeasePrice = null;
		Integer type = null;
		if(map.get("leasePrice")==null || map.get("leasePrice")==""){
			newLeasePrice = 0.0;
		}else{
			newLeasePrice = Double.parseDouble(map.get("leasePrice").toString());
		}
		if(map.get("oldLeasePrice")==null || map.get("oldLeasePrice")==""){
			oldLeasePrice = 0.0;
		}else{
			oldLeasePrice = Double.parseDouble(map.get("oldLeasePrice").toString());
		}
		if(!newLeasePrice.equals(oldLeasePrice)){
			//生成价格变化记录
			if((newLeasePrice-oldLeasePrice)>0.0001){
				type = 1;
			}else{
				type = 2;
			}
			Map<String,Object> pcMap = new HashMap<String,Object>();
			pcMap.put("houseInfoId", map.get("houseInfoId").toString());
			pcMap.put("lastPrice", oldLeasePrice);
			pcMap.put("nowPrice", newLeasePrice);
			pcMap.put("type", type);
			pcMap.put("userId", map.get("userId").toString());
			pcMap.put("userName", map.get("userName").toString());
			houseLeaseDao.insertHousePriceChange(pcMap);
			//生成跟进记录
			pcMap.put("followContent", "价格变为"+newLeasePrice+"元");
		    houseLeaseDao.insertHouseFollow(pcMap);
		}
		return 1;		
	}
	/**
	 * 分页查询租赁房源  dl
	 * @param map
	 * @return
	 */
	public PagerResult<HouseLeaseModel> getHouseLeaseListForPage(Map<String,Object> map){
		//搜索条件：意向租金
		String leasePriceFlag = (String)map.get("leasePriceFlag");
		if(null != leasePriceFlag && !"".equals(leasePriceFlag)){
			map.put("priceMapList", getPriceMapList(leasePriceFlag));
		}
		//搜索条件：建面
		String coveredAreaFlag = (String)map.get("coveredAreaFlag");
		if(null != coveredAreaFlag && !"".equals(coveredAreaFlag)){
			map.put("coveredMapList", getCoveredMapList(coveredAreaFlag));
		}
		//搜索条件：房源标签
		String tagsFlag = (String)map.get("tagsFlag");
		if(null != tagsFlag && !"".equals(tagsFlag)){
			String[] tagArray = tagsFlag.split(",");
			map.put("tagsFlag", tagArray);
		}
		//搜索条件：商铺-适合经营
		if(map.get("useType").toString().equals("2")){
			String fitmanagementFlag = (String)map.get("fitmanagementFlag");
			if(null != fitmanagementFlag && !"".equals(fitmanagementFlag)){
				String[] fitsArray = fitmanagementFlag.split(",");
				map.put("fitmanagementFlag", fitsArray);
			}
		}
		PagerResult<HouseLeaseModel> result = new PagerResult<HouseLeaseModel>();
		String useType = map.get("useType").toString();
		if(useType.equals("4")){								 //车位
			result = houseLeaseDao.getCarPortLeaseListForPage(map);
		}else{
			result = houseLeaseDao.getHouseLeaseListForPage(map);//住宅、商铺、写字楼
		}
		return result;
	}
	/**
	 * 搜索条件：意向租金 dl
	 * @param string
	 * @return
	 */
	public List<Map<String,Object>> getPriceMapList(String leasePriceFlag){
		List<Map<String,Object>> priceMapList = new ArrayList<Map<String,Object>>();
		String price=null;
		String[] priceArray = leasePriceFlag.split(",");
		for(int i=0 ;i< priceArray.length;i++){
			Map<String,Object> priceMap = new HashMap<String,Object>();
			price = priceArray[i];
			if(price.endsWith("-")){
				priceMap.put("startPrice", price.replace("-", ""));
			}else{
				String[] prices = price.split("-");
				priceMap.put("startPrice", prices[0]);
				priceMap.put("endPrice", prices[1]);
			}
			priceMapList.add(priceMap);
		}
		return priceMapList;
	}
	/**
	 * 搜索条件：建面 dl
	 * @param string
	 * @return
	 */
	public List<Map<String,Object>> getCoveredMapList(String coveredAreaFlag){
		List<Map<String,Object>> coveredMapList = new ArrayList<Map<String,Object>>();
		String covered = null;
		String[] coveredArray = coveredAreaFlag.split(",");
		for (int i = 0; i < coveredArray.length; i++) {
			Map<String,Object> coveredMap = new HashMap<String,Object>();
			covered = coveredArray[i];
			if(covered.endsWith("-")){
				coveredMap.put("startCovered", covered.replace("-", ""));
			}else{
				String[] covereds = covered.split("-");
				coveredMap.put("startCovered", covereds[0]);
				coveredMap.put("endCovered", covereds[1]);
			}
			coveredMapList.add(coveredMap);
		}
		return coveredMapList;
	}
	/**
	 * 根据houseInfoId查询房源信息 dl
	 * @param map
	 * @return
	 */
	public HouseLeaseModel getHouseLeaseById(Map<String,Object> map){
		HouseLeaseModel houseLeaseModel = new HouseLeaseModel();
		if(map.containsKey("houseInfoId") && map.get("houseInfoId").toString()!=null && !map.get("houseInfoId").toString().equals("")){
			String useType = map.get("useType").toString();
			if(useType.equals("4")){
				houseLeaseModel =  houseLeaseDao.getHouseCarPortById(map);
			}else{
				houseLeaseModel =  houseLeaseDao.getHouseLeaseById(map);
			}
			List<HouseLinkManModel> linkManList =  houseLeaseDao.getHouseLinkManList(map);
			houseLeaseModel.setLinkManList(linkManList);
		}
		return houseLeaseModel;
	}
	/**
	 * 判断车位是否关联房源 dl
	 * @param map 
	 * @return
	 */
	public List<HouseLeaseModel> isContactHouseLease(Map<String,Object> map){
		return houseLeaseDao.isContactHouseLease(map);
	}
	/**
	 * 模糊搜索楼盘名称 dl
	 * @param map 参数:matchStr
	 * @return
	 */
	public List<BasePremisesModel> getPremisesByMatch(Map<String,Object> map){
		return houseLeaseDao.getPremisesByMatch(map);
	}
	/**
	 * 查询大商圈 dl
	 * @param map 
	 * @return
	 */
	public List<BusiAreaModel> getBa1List(){
		return houseLeaseDao.getBa1List();
	}
	/**
	 * 根据大商圈查询小商圈 dl
	 * @param map 
	 * @return
	 */
	public List<BusiAreaModel> getBa2List(Map<String,Object> map){
		return houseLeaseDao.getBa2List(map);
	}
	/**
	 * 模糊搜索教育设施 dl
	 * @param map 参数:matchStr
	 * @return
	 */
	public List<EduFacilityModel> getEdusByMatch(Map<String,Object> map){
		return houseLeaseDao.getEdusByMatch(map);
	}
	/**
	 * 校验房源是否已存在 dl
	 * @param map 
	 * @return
	 */
	public Integer isExistWithHouseLease(Map<String,Object> map){
		return houseLeaseDao.isExistWithHouseLease(map);
	}
	/**
	 * 校验具体地址是否属于地址库 dl
	 * @param map 
	 * @return
	 */
	public Integer isExistWithAddrDetail(Map<String,Object> map){
		return houseLeaseDao.isExistWithAddrDetail(map);
	}
	/**
	 *  租赁房源详情
	 * @param map 
	 * @return
	 */
	public Map<String,Object> getDetail(Map<String, Object> map){
		Map<String,Object> param = new HashMap<String,Object>();
		HouseLeaseModel leasedetailInfo = houseLeaseDao.getDetail(map);
		if(leasedetailInfo.getLookWay()!=null){
			map.put("sysHouseId",  leasedetailInfo.getLookWay());
			String lookWayStr = "";
			List<SysParameterModel> syslookWayList = sysParamDao.getSysHouseList(map);
			if(syslookWayList.size()!=0){
				for(SysParameterModel item:syslookWayList){
					lookWayStr+=item.getSysHouseDescribe()+",";
				}
				leasedetailInfo.setLookWayStr(lookWayStr.substring(0, lookWayStr.length()-1));
			}
		}
		if(leasedetailInfo.getTags()!=null){
			map.put("sysHouseId", leasedetailInfo.getTags());
			String tagsStr = "";
			List<SysParameterModel> sysTagsList = sysParamDao.getSysHouseList(map);
			if(sysTagsList.size()!=0){
				for(SysParameterModel item:sysTagsList){
					tagsStr+=item.getSysHouseDescribe()+",";
				}
				leasedetailInfo.setTagsStr(tagsStr.substring(0, tagsStr.length()-1));
			}
		}
		if(leasedetailInfo.getSpecial()!=null){
			map.put("sysHouseId", leasedetailInfo.getSpecial());
			String specialStr = "";
			List<SysParameterModel> sysSpecialList = sysParamDao.getSysHouseList(map);
			if(sysSpecialList.size()!=0){
				for(SysParameterModel item:sysSpecialList){
					specialStr+=item.getSysHouseDescribe()+",";
				}
				leasedetailInfo.setSpecialStr(specialStr.substring(0, specialStr.length()-1));
			}
		}
		if(leasedetailInfo.getFurniture()!=null){
			map.put("sysHouseId", leasedetailInfo.getFurniture());
			String furnitureStr = "";
			List<SysParameterModel> sysFurnitureList = sysParamDao.getSysHouseList(map);
			if(sysFurnitureList.size()!=0){
				for(SysParameterModel item:sysFurnitureList){
					furnitureStr+=item.getSysHouseDescribe()+",";
				}
				leasedetailInfo.setFurnitureStr(furnitureStr.substring(0, furnitureStr.length()-1));
			}
		}
		if(leasedetailInfo.getFwsh()!=null){
			map.put("sysHouseId", leasedetailInfo.getFwsh());
			String fwshStr = "";
			List<SysParameterModel> sysFwshStrList = sysParamDao.getSysHouseList(map);
			if(sysFwshStrList.size()!=0){
				for(SysParameterModel item:sysFwshStrList){
					fwshStr+=item.getSysHouseDescribe()+",";
				}
				leasedetailInfo.setFwshStr(fwshStr.substring(0, fwshStr.length()-1));
			}
		}
		param.put("houseLeaseInfo", leasedetailInfo);//买卖房源详细
		Integer collectResult = commonSearchDao.queryCollect(map);//查询收藏数据
		param.put("collectResult", collectResult);
		Integer querySpaceSee = commonSearchDao.querySpaceSee(map);//查询空看数据
		param.put("querySpaceSee", querySpaceSee);
		Integer queryReceiveKey = commonSearchDao.queryReceiveKey(map);//查询钥匙数据
		param.put("queryReceiveKey", queryReceiveKey);
		if(leasedetailInfo.getRoomId()!=null){
			map.put("roomId", leasedetailInfo.getRoomId());
			List<CarPortModel> carPortList = houseSaleDao.getCarPortList(map);//车位
			param.put("carPortList", carPortList);
		}
		List<HouseSaleModel> linkManList = houseSaleDao.getLinkManList(map);//联系人
		param.put("linkManList", linkManList);
		map.put("premisesId",leasedetailInfo.getPremisesId());
		map.put("inIds",leasedetailInfo.getPremisesEduIds());
		List<Map<String, Object>> eduListByMatch = basePremisesDao.getEduListByMatch(map);//教育设施
		param.put("eduListByMatch", eduListByMatch);
		map.put("trafficType", 1);
		map.put("inIds", leasedetailInfo.getBusStation());
		List<Map<String, Object>> busStationList = basePremisesDao.getSiteLineListByMatch(map);//公交线路
		param.put("busStationList", busStationList);
		map.put("trafficType", 2);
		map.put("inIds", leasedetailInfo.getSubwayStation());
		List<Map<String, Object>> subwayStationList = basePremisesDao.getSiteLineListByMatch(map);//地铁线路
		param.put("subwayStationList", subwayStationList);
		return param;
	}
}
