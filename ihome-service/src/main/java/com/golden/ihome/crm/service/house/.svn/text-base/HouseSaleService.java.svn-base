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
import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.addr.model.CarPortModel;
import com.golden.ihome.addr.model.EduFacilityModel;
import com.golden.ihome.common.CodeConst;
import com.golden.ihome.common.service.CommonCode;
import com.golden.ihome.crm.dao.house.CommonSearchDao;
import com.golden.ihome.crm.dao.house.HouseSaleDao;
import com.golden.ihome.crm.dao.sysParame.SysParamDao;
import com.golden.ihome.crm.dao.users.UserDao;
import com.golden.ihome.crm.model.AddrDetailModel;
import com.golden.ihome.crm.model.CommentModel;
import com.golden.ihome.crm.model.HouseLinkManModel;
import com.golden.ihome.crm.model.HouseSaleModel;
import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

/**
 * @author sy
 * 类名称：买卖房源service
 * 时间：2016-11-2
 * 
 */
@Service("house/houseSaleService")
public class HouseSaleService implements IBaseHandler{
	@Autowired
	private HouseSaleDao houseSaleDao;
	
	@Autowired
	private CarPortDao carPortDao;
	
	@Autowired
	private SysParamDao sysParamDao;
	
	@Autowired
	private CommonSearchDao commonSearchDao;
	@Resource(name="commonCode")
	private CommonCode commonCode;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BasePremisesDao basePremisesDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 模糊查询详细地址  sy
	 * @param map 参数:matchStr
	 * @return
	 */
	public List<AddrDetailModel> getAddrDetail(Map<String,Object> map){
		return houseSaleDao.getAddrDetail(map);
	}
	/**
	 * 模糊查询详细地址B(用于：房源-车位) sy
	 * @param map 参数:matchStr
	 * @return
	 */
	public List<AddrDetailModel> getAddrDetailB(Map<String,Object> map){
		return houseSaleDao.getAddrDetailB(map);
	}
	
	/**
	 * 新增买卖房源  sy
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@TM
	public Integer insertHouseSale(Map<String,Object> map) throws Exception{
		map.put("code", commonCode.getCode(CodeConst.MM_CODE));
		map.put("demandType", 1);
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
		Integer i= houseSaleDao.insertHourseInfo(map);
		//更新房间表的证载地址
		String useType = map.get("useType").toString();
		if(!useType.equals("4")){
			//更新房间表的证载地址
			houseSaleDao.updateHouseZzdz(map);
		}
		if(i==1){
			map.put("houseInfoId", (Integer.parseInt(map.get("houseInfoId").toString())+1));
			useType = map.get("useType").toString();//使用类别
			Integer j = null;
			if(useType.equals("1")){//住宅
				j = houseSaleDao.insertResidenceSale(map);
			}else if(useType.equals("2")){//商铺
				j = houseSaleDao.insertShopsSale(map);
			}else if(useType.equals("3")){//写字楼
				j = houseSaleDao.insertOfficeSale(map);
			}else{//车位
				j = houseSaleDao.insertCarPortSale(map);
			}
				if(j==1){
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
						//回写车位委托状态
						Map<String, Object> paramsMap = new HashMap<String,Object>();
						paramsMap.put("carPortId", map.get("carPortId"));
						Integer saledIs = (Integer) carPortDao.carPortLeasedIs(paramsMap);
						Integer authorize = 2;
						if(saledIs>0){
							authorize = 3;
						}
						paramsMap.put("authorize", authorize);
						carPortDao.updateAuthorizeByPortId(paramsMap);
					}
					return 1;
				}else{
					return 0;
				}
		}else{
			return 0;
		}
	}
	
	/**
	 * 修改房源 sy
	 * @param map
	 * @return
	 */
	@TM
	public Integer updateHouseSaleById(Map<String,Object> map){
		//更新houseInfo主表信息
		if(!map.get("useType").toString().equals("4")){
			map.put("demandType", 1);
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
			houseSaleDao.updateHouseInfoById(map);
		}
		//更新房间表的证载地址
		houseSaleDao.updateHouseZzdz(map);
		//更新houseSale
		houseSaleDao.updateHouseSaleById(map);
		//查询已存在联系人
		List<HouseLinkManModel> lmList = houseSaleDao.getHouseLinkManList(map);
		String lmStr = new String();
		if(!lmList.isEmpty()){
			for (int k = 0; k < lmList.size(); k++) {
				lmStr+=lmList.get(k).getId()+",";
			}
			//删除已存在联系人
			houseSaleDao.deleteHouseLinkMans(lmStr.substring(0, lmStr.length()-1));
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
		Integer newUnitPrice = null;
		Integer oldUnitPrice = null;
		Integer type = null;
		if(map.get("unitPrice")==null || map.get("unitPrice")==""){
			newUnitPrice = 0;
		}else{
			newUnitPrice = Integer.parseInt(map.get("unitPrice").toString());
		}
		if(map.get("oldUnitPrice")==null || map.get("oldUnitPrice")==""){
			oldUnitPrice = 0;
		}else{
			oldUnitPrice = Integer.parseInt(map.get("oldUnitPrice").toString());
		}
		if(!newUnitPrice.equals(oldUnitPrice)){
			//生成价格变化记录
			if((newUnitPrice-oldUnitPrice)>0.0001){
				type = 1;
			}else{
				type = 2;
			}
			Map<String,Object> pcMap = new HashMap<String,Object>();
			pcMap.put("houseInfoId", map.get("houseInfoId").toString());
			pcMap.put("lastPrice", oldUnitPrice);
			pcMap.put("nowPrice", newUnitPrice);
			pcMap.put("type", type);
			pcMap.put("userId", map.get("userId").toString());
			pcMap.put("userName", map.get("userName").toString());
			houseSaleDao.insertHousePriceChange(pcMap);
			//生成跟进记录
			pcMap.put("followContent", "价格变为"+newUnitPrice+"元");
			houseSaleDao.insertHouseFollow(pcMap);
		}
		return 1;
	}
	
	/**
	 * 搜索条件：房屋售价 sy
	 * @param string
	 * @return
	 */
	public List<Map<String,Object>> getPriceMapList(String salePriceFlag){
		List<Map<String,Object>> priceMapList = new ArrayList<Map<String,Object>>();
		String price=null;
		String[] priceArray = salePriceFlag.split(",");
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
	 * 搜索条件：车位售价 sy
	 * @param string
	 * @return
	 */
	public List<Map<String,Object>> getCarPortPriceMapList(String carPortSalePriceFlag){
		List<Map<String,Object>> carPortPriceMapList = new ArrayList<Map<String,Object>>();
		String price=null;
		String[] priceArray = carPortSalePriceFlag.split(",");
		for(int i=0 ;i< priceArray.length;i++){
			Map<String,Object> priceMap = new HashMap<String,Object>();
			price = priceArray[i];
			if(price.endsWith("-")){
				priceMap.put("startCarPrice", price.replace("-", ""));
			}else{
				String[] prices = price.split("-");
				priceMap.put("startCarPrice", prices[0]);
				priceMap.put("endCarPrice", prices[1]);
			}
			carPortPriceMapList.add(priceMap);
		}
		return carPortPriceMapList;
	}
	
	/**
	 * 搜索条件：建面 sy
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
	 * 分页查询买卖房源(住宅) sy  
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSaleModel> getHouseSaleListForPage(Map<String,Object> map){
		//搜索条件：房屋售价
		String salePriceFlag = (String)map.get("salePriceFlag");
		if(null != salePriceFlag && !"".equals(salePriceFlag)){
			map.put("priceMapList", getPriceMapList(salePriceFlag));
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
		//搜索条件：车位-车位售价
		if(map.get("useType").toString().equals("4")){
			String carPortSalePriceFlag = (String)map.get("carPortSalePriceFlag");
			if(null != carPortSalePriceFlag && !"".equals(carPortSalePriceFlag)){
				map.put("carPortPriceMapList", getCarPortPriceMapList(carPortSalePriceFlag));
			}
		}
		
		PagerResult<HouseSaleModel> result = new PagerResult<HouseSaleModel>();
		String useType = map.get("useType").toString();
		if(useType.equals("4")){								
			result = houseSaleDao.getCarPortSaleListForPage(map); //车位
		}else{
			result = houseSaleDao.getHouseSaleListForPage(map); //住宅、商铺、写字楼
		}
		return result;
	}
	
	/**
	 * 根据houseInfoId查询房源信息 sy
	 * @param map
	 * @return
	 */
	public HouseSaleModel getHouseSaleById(Map<String,Object> map){
		HouseSaleModel houseSaleModel = new HouseSaleModel();
		if(map.containsKey("houseInfoId") && map.get("houseInfoId").toString()!=null && !map.get("houseInfoId").toString().equals("")){
			String useType = map.get("useType").toString();
			if(useType.equals("4")){
				houseSaleModel = houseSaleDao.getHouseCarPortById(map);//车位
			}else{
				houseSaleModel = houseSaleDao.getHouseSaleById(map);//住宅、商铺、写字楼
			}
			List<HouseLinkManModel> listLinkMan = houseSaleDao.getHouseLinkManList(map);
			houseSaleModel.setLinkManList(listLinkMan);
		}
		return houseSaleModel;
	}
	
	/**
	 * 判断车位是否关联房源 sy
	 * @param map 
	 * @return
	 */
	public List<HouseSaleModel> isContactHouseSale(Map<String,Object> map){
		return houseSaleDao.isContactHouseSale(map);
	}
	/**
	 * 查询大商圈 sy
	 * @param map 
	 * @return
	 */
	public List<BusiAreaModel> getBa1List(){
		return houseSaleDao.getBa1List();
	}
	/**
	 * 根据大商圈查询小商圈 sy
	 * @param map 
	 * @return
	 */
	public List<BusiAreaModel> getBa2List(Map<String,Object> map){
		return houseSaleDao.getBa2List(map);
	}
	/**
	 * 模糊搜索教育设施 sy
	 * @param map 参数:matchStr
	 * @return
	 */
	public List<EduFacilityModel> getEdusByMatch(Map<String,Object> map){
		return houseSaleDao.getEdusByMatch(map);
	}
	
	/**
	 * 校验房源是否已存在 sy
	 * @param map 
	 * @return
	 */
	public Integer isExistWithHouseSale(Map<String,Object> map){
		return houseSaleDao.isExistWithHouseSale(map);
	}
	// 保存评论
	public Integer saveComment(Map<String, Object> map){
		map.put("createTime", new Date());
		return houseSaleDao.saveComment(map);
	}
	
	// 获取评论
	public List<CommentModel> getCommemnt(Map<String, Object> map){
		return houseSaleDao.getCommemnt(map);
	}
	/**
	 *  买卖房源详情
	 * @param 房源Id 
	 * @return
	 */
	public Map<String,Object> getDetail(Map<String, Object> map){
		Map<String,Object> param = new HashMap<String,Object>();
		HouseSaleModel houseSaledetail = houseSaleDao.getDetail(map);
		if( houseSaledetail.getLookWay()!=null){
			map.put("sysHouseId",  houseSaledetail.getLookWay());
			String lookWayStr = "";
			List<SysParameterModel> syslookWayList = sysParamDao.getSysHouseList(map);
			if(syslookWayList.size()!=0){
				for(SysParameterModel item:syslookWayList){
					lookWayStr+=item.getSysHouseDescribe()+",";
				}
				houseSaledetail.setLookWayStr(lookWayStr.substring(0,lookWayStr.length()-1));
			}
		}
		if(houseSaledetail.getTags()!=null){
			map.put("sysHouseId", houseSaledetail.getTags());
			String tagsStr = "";
			List<SysParameterModel> sysTagsList = sysParamDao.getSysHouseList(map);
			if(sysTagsList.size()!=0){
				for(SysParameterModel item:sysTagsList){
					tagsStr+=item.getSysHouseDescribe()+",";
				}
				houseSaledetail.setTagsStr(tagsStr.substring(0, tagsStr.length()-1));
			}
		}
		if(houseSaledetail.getSpecial()!=null){
			map.put("sysHouseId", houseSaledetail.getSpecial());
			String specialStr = "";
			List<SysParameterModel> sysSpecialList = sysParamDao.getSysHouseList(map);
			if(sysSpecialList.size()!=0){
				for(SysParameterModel item:sysSpecialList){
					specialStr+=item.getSysHouseDescribe()+",";
				}
				houseSaledetail.setSpecialStr(specialStr.substring(0, specialStr.length()-1));
			}
		}
 		param.put("houseSaledetail", houseSaledetail);//买卖房源详细
		Integer collectResult = commonSearchDao.queryCollect(map);//查询收藏数据
		param.put("collectResult", collectResult);
		Integer querySpaceSee = commonSearchDao.querySpaceSee(map);//查询空看数据
		param.put("querySpaceSee", querySpaceSee);
		Integer queryReceiveKey = commonSearchDao.queryReceiveKey(map);//查询钥匙数据
		param.put("queryReceiveKey", queryReceiveKey);
		map.put("roomId", houseSaledetail.getRoomId());
		List<CarPortModel> carPortList = houseSaleDao.getCarPortList(map);//车位
		param.put("carPortList", carPortList);
		List<HouseSaleModel> linkManList = houseSaleDao.getLinkManList(map);//联系人
		param.put("linkManList", linkManList);
		map.put("premisesId",houseSaledetail.getPremisesId());
		map.put("inIds",houseSaledetail.getPremisesEduIds());
		List<Map<String, Object>> eduListByMatch = basePremisesDao.getEduListByMatch(map);//教育设施
		param.put("eduListByMatch", eduListByMatch);
		map.put("trafficType", 1);
		map.put("inIds", houseSaledetail.getBusStation());
		List<Map<String, Object>> busStationList = basePremisesDao.getSiteLineListByMatch(map);//公交线路
		param.put("busStationList", busStationList);
		map.put("trafficType", 2);
		map.put("inIds", houseSaledetail.getSubwayStation());
		List<Map<String, Object>> subwayStationList = basePremisesDao.getSiteLineListByMatch(map);//地铁线路
		param.put("subwayStationList", subwayStationList);
		return param;
	}
	/**
	 *  房源联系人
	 * @param 房源Id 
	 * @return
	 */
	public List<HouseSaleModel> getLinkManList(Map<String, Object> map){
		return houseSaleDao.getLinkManList(map);
	}
	/**
	 *  房源车位List
	 * @param 房源Id 
	 * @return
	 */
	public List<CarPortModel> getCarPortList(Map<String, Object> map){
		return houseSaleDao.getCarPortList(map);
	}

}
