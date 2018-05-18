package com.golden.ihome.addr.service.baseHous;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;

import com.alibaba.fastjson.JSON;
import com.golden.ihome.addr.dao.baseBuilding.BaseBuildingDao;
import com.golden.ihome.addr.dao.baseHouse.BaseHouseDao;
import com.golden.ihome.addr.dao.buildingUnitsDao.BuildingUnitsDao;
import com.golden.ihome.addr.dao.ctxdll.RoomAddrDao;
import com.golden.ihome.addr.model.BaseBuildingModel;
import com.golden.ihome.addr.model.BaseHouseModel;
import com.golden.ihome.addr.model.BuildingUnitsModel;
import com.golden.ihome.addr.model.HouseAllAddressModel;
import com.golden.ihome.common.CommonConst;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

/**
 * 
 * @author lza
 *类名：房间管理service
 *描述：针对房间表管理service
 *时间：2016年10月19日
 */
@Service("baseHouse/baseHouseService")
public class BaseHouseService implements IBaseHandler{
	@Autowired
	private  BaseHouseDao  baseHouseDao;
	@Autowired
	private  BuildingUnitsDao buildingUnitsDao;	
	@Autowired
	private  BaseBuildingDao baseBuildingDao;
	@Autowired
	private RoomAddrDao roomAddrDao;
	/**
	 * 根据id查询房间 
	 * @param param {}
	 * @return Object
	 * @throws Exception
	 */
	public Object execute(Map<String, Object> param) throws Exception {
		return baseHouseDao.getbaseHouse(param);
	}
	
	/**
	 * 根据id更新房间实体（逻辑批量删除和批量添加）
	 * @param param{baseHouseIds：id，status：1或2}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	
	
	@TM
	@Aop(name = "syncHouseAop",type="around")
	@SuppressWarnings("unchecked")
	public Integer updateHouseStatus(Map<String,Object> param){
		
		//获取json格式单元对象List<map>list，并转换成json字符串
		String jsonEchoedRoomsList = (String) param.get("list");
		//将json格式的单元数组对象转换成list集合
		List<Map<String, Object>> EchoedRooms = JSON.parseObject(jsonEchoedRoomsList, List.class);
		Map <String,Object> map = new HashMap<String,Object> ();
		Map <String,Object> roommap = new HashMap<String,Object> ();
		//便利单元list集合元素
		int type = 0;
		Map <String,Object> EchoedRoomsMap = new HashMap<String,Object> ();
 		for (Object object : EchoedRooms) {
			EchoedRoomsMap = JSON.parseObject(JSON.toJSONString(object), Map.class);
			map.put("baseHouseIds", Integer.parseInt(EchoedRoomsMap.get("baseHouseIds").toString()));
			//判断隐藏还是显示
			if(EchoedRoomsMap.get("status").toString().equals(CommonConst.HOUSE_STATUS_HIDDEN.toString())){
				map.put("status", CommonConst.HOUSE_STATUS_HIDDEN);
				//全地址：房间状态为隐藏
				roommap.put("roomId", Integer.parseInt(EchoedRoomsMap.get("baseHouseIds").toString()));
				roommap.put("status", CommonConst.HOUSE_STATUS_HIDDEN);
		        roomAddrDao.updateHouseAddr(roommap);
			}else{
				map.put("status", CommonConst.HOUSE_STATUS);
			}
			//批量或单个更改状态
			type = baseHouseDao.updatebaseHouse(map);
			if(type==0){
				return type;
			}
		}
		return type;
	}
	
	/**
	 * 根据楼栋id跟新房间属性
	 * @param param{baseHouseIds：id，status：1或2}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	@Aop(name = "syncHouseAop",type="around")
	public Integer updatebaseHouse(Map<String,Object> param){
		Integer type=0;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("updateHouse", param.get("houseName"));
		map.put("baseHouseIds", param.get("baseHouseId"));
		map.put("basebuildingId", param.get("buildingId"));
		map.put("purpose", param.get("purpose"));
		param.put("baseHouseIds",  param.get("baseHouseId"));
		Integer num = baseHouseDao.getByNum(map);
		if(num>0){
			type = -1;
			return type;
		}
		//oldHouseName 
		 type =baseHouseDao.updatebaseHouse(param);
		 String houseName = (String) param.get("houseName");
		 String oldHouseName = (String) param.get("oldHouseName");
		 Map<String, Object> roomMap = new HashMap<String,Object>();
		if(!houseName.equals(oldHouseName)){
			roomMap.put("roomName", param.get("houseName"));
			roomMap.put("roomId", param.get("baseHouseId"));
			type = roomAddrDao.updateHouseAddr(roomMap);
			param.put("isUpdateHouseAddr", "111");
		 }
		return type;
	}
	/**
	 * 批量天加房间
	 * @param param{baseHouseId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	@Aop(name = "syncHouseAop",type="around")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer insertBatch(Map<String,Object> param){
		
		Map<String, Object> map = new HashMap<String, Object>();
		//获取当前时间
		Date now = new Date(); 
		map.put("createTime", now);
		param.put("createTime", now);
		//方法返回值类型0为不成功
		Integer type = 0;
		//获取判断费否跟新房间生成规则1跟新2不跟新
		String isFlag = (String) param.get("isFlag");
		
		if(isFlag.equals("1")){
			type = buildingUnitsDao.updatebuildingUnits(param);//param ：要么放在param ,要没加key获取
			if(type== 0){
				return type;
			}
		}
		//获取单元id
		String  unitId = (String) param.get("unit");
		//获取房间集合list
		Object object = param.get("listRoom");
		
		List list = JSON.parseObject(JSON.toJSONString(object), List.class);
		for (Object obj : list) {
			map = JSON.parseObject(JSON.toJSONString(obj), Map.class);
			//单元id
			map.put("unitId", unitId);
			//添加房间
			type = baseHouseDao.insertSelective(map);
			if(type==0){
				return type;
			}
		}
		param.put("isUpdateHouseAddr", "111");
		return type;
	}
	/**
	 * 根据id物理删除房间一条或多条数据
	 * @param param{baseHouseId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	public Integer deletebaseHouse(Map<String,Object> param){
	return baseHouseDao.deletebaseHouse(param);
	}
	
	/**
	 * 增加一条房间数据数据可选填字段(商铺添加)
	 * @param param 实体的所有属性均可
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@Aop(name = "syncHouseAop",type="around")
	@TM(isolation=TransactionDefinition.ISOLATION_READ_COMMITTED)
	public Integer insertSelective(Map<String,Object> param){
		Integer type=0;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("houseName", param.get("houseName"));
		map.put("basebuildingId", param.get("buildingId"));
		map.put("purpose", param.get("purpose"));
		Integer num = baseHouseDao.getByNum(map);
		if(num>0){
			type = -1;
			return type;
		}
		type = baseHouseDao.insertSelective(param);
		if(type>0){
			map.clear();
			int houseId = (int) param.get("houseId");
			map.put("houseId",houseId+1);
			HouseAllAddressModel houseAllAddress = baseHouseDao.getOneHouseAllAddress(map);
			map.clear();
			if(houseAllAddress!=null){
				map.put("addrdetail", houseAllAddress.getAddrdetail());
				map.put("province", houseAllAddress.getProvince());
				map.put("city", houseAllAddress.getCity());
				map.put("area", houseAllAddress.getArea());
				map.put("road", houseAllAddress.getRoad());
				map.put("roadnum", houseAllAddress.getRoadNum());
				map.put("premisesName", houseAllAddress.getPremisesName());
				map.put("premisesId", houseAllAddress.getPremisesId());
				map.put("groupName", houseAllAddress.getGroupName());
				map.put("groupId", houseAllAddress.getGroupId());
				map.put("buildingName", houseAllAddress.getBuildingName());
				map.put("buildingId", houseAllAddress.getBuildingId());
				map.put("unitName", houseAllAddress.getUnitName());
				map.put("unitId", houseAllAddress.getUnitId());
				map.put("houseName", houseAllAddress.getHouseName());
				map.put("houseId", houseAllAddress.getHouseId());
				map.put("areaId", houseAllAddress.getAreaId());
				map.put("roadId", houseAllAddress.getRoadId());
				type = roomAddrDao.insertHouseAddr(map);
			}
			param.put("isUpdateHouseAddr", "111");
		}
		
		return type;
	}
	
	/**
	 * 根据buildingId获取房间信息
	 * @param param
	 * @return
	 */
	public List<BaseHouseModel> getRoomsInfo(Map<String,Object> param){
		return baseHouseDao.getRoomInfo(param);
	}
	
	/**
	 * 根据unitId 楼层获取房间信息
	 * @param param
	 * @return
	 */
	public List<BaseHouseModel> getRoomsMatchFloor(Map<String,Object> param){
		return baseHouseDao.getRoomsMatchFloor(param);
	}
	
	/**
	 * 获取楼栋单元信息
	 * @param param
	 * @return
	 */
	public List<BuildingUnitsModel> getUnitsInfo(Map<String,Object> param){
		return baseHouseDao.getUnitsInfo(param);
	}
	
	/**
	 * 获取房间分页数据
	 * @param param 
	 * @return 
	 */
	public PagerResult<BaseHouseModel> getStorePage(Map<String,Object> param){
		return baseHouseDao.getStorePage(param);
	}
	
	/**
	 * 单个新增房间
	 * @param param
	 * @return
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer singleRestoreRoom(Map<String, Object> param){
		baseHouseDao.updatebaseHouse(param);
		Map<String, Object> map = new HashMap<String,Object>();
		//全地址：修改房间状态为显示
		map.put("roomId", param.get("baseHouseIds"));
		map.put("status", param.get("status"));
		return  roomAddrDao.updateHouseAddr(map);
	}
	/**
	 * 单个更新房间
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer updateEditHouse(Map<String, Object> param) throws UnsupportedEncodingException{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("baseHouseIds", param.get("houseId"));
		if(!"".equals(param.get("OrientationsNm"))){
			map.put("orientation", URLDecoder.decode((String) param.get("OrientationsNm"), "UTF-8"));
		}
		if(!"".equals(param.get("BuildingAreaNm"))){
			map.put("coveredArea", Integer.parseInt((String) param.get("BuildingAreaNm")));
		}
		Object roomObj = param.get("BedroomNm");
		Object hallObj = param.get("LivingRoomNm");
		Object defendObj = param.get("ToiletNm");
		Object kitchenObj = param.get("KitchenNm");
		StringBuffer houseType= new StringBuffer("");
		if(roomObj != null && !roomObj.equals("")){
			houseType.append((roomObj.toString()+"室"));
		}else{
			houseType.append(("0室"));
		}
		if(hallObj != null && !hallObj.equals("")){
			houseType.append((hallObj.toString()+"厅"));
		}else{
			houseType.append(("0厅"));
		}
		if(defendObj != null && !defendObj.equals("")){
			houseType.append((defendObj.toString()+"卫"));
		}else{
			houseType.append(("0卫"));
		}
		if(kitchenObj != null && !kitchenObj.equals("")){
			houseType.append((kitchenObj.toString()+"厨"));
		}else{
			houseType.append(("0厨"));
		}
		map.put("houseType", houseType.toString());
		if(!"".equals(param.get("DecorationNm"))){
			map.put("decoration", (String) param.get("DecorationNm"));
		}
		if(!"".equals(param.get("UseAreaNm"))){
			map.put("useLand", (String) param.get("UseAreaNm"));
		}
		if(!"".equals(param.get("PurposeNm"))){
			map.put("purpose", (String) param.get("PurposeNm"));
		}
		if(!"".equals(param.get("NatureNm"))){
			map.put("houseNature", (String) param.get("NatureNm"));
		}
		if(!"".equals(param.get("YearsNm"))){
			map.put("landLimit", (String) param.get("YearsNm"));
		}
		if(!"".equals(param.get("OwnerPhoneNm"))){
			map.put("contactPhone", (String) param.get("OwnerPhoneNm"));
		}
		if(!"".equals(param.get("OwnersNameNm"))){
			map.put("proprietor", URLDecoder.decode((String) param.get("OwnersNameNm"), "UTF-8"));
		}
		if(param.get("propertyStatus")!=null && !"".equals(param.get("propertyStatus"))){
			map.put("propertyStatus",param.get("propertyStatus"));
		}
		return baseHouseDao.updatebaseHouse(map);
	}
	
	/**
	 * 批量新增房间
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@TM
	@Aop(name = "syncHouseAop",type="around")
	public Integer batchRestoreRoom(Map<String, Object> param){
		int type =0;
		int unitId =0;
		String houseIds = "";
		Map<String, Object> map = new HashMap<String,Object>();
		if("insert".equals(param.get("id"))){
			param.remove("id");
			type = buildingUnitsDao.insertSelective(param);
			unitId = (int) param.get("BudingUnitId");
		}else{
			Integer floors = Integer.parseInt(param.get("endFloor").toString())-Integer.parseInt(param.get("upFloors").toString())+1;
			map.put("id", param.get("id"));
			map.put("floors", floors);
			map.put("numEnd", param.get("numEnd"));
			type = buildingUnitsDao.updatebuildingUnits(map);
		}
		if(type != 0){
			List<Map<String, Object>> roomsList = JSON.parseObject(param.get("roomsList").toString(), List.class);
			for (Object object2 : roomsList) {
				Map <String,Object> proom = new HashMap<String,Object> ();
				//将list的每个元素转化为map
				proom = JSON.parseObject(JSON.toJSONString(object2), Map.class);
				if(proom.containsKey("unitId") == false){
					proom.put("unitId", unitId);
				}
				//添加房间
				type = baseHouseDao.insertSelective(proom);
				//添加失败,直接返回
				if(type==0){
					return type;
				}
				int houseId = (int) proom.get("houseId");
				houseIds += (houseId+",");
			}
			if(houseIds.equals("")){
				return type;
			}
			//批量填加全地址
			map.clear();
			map.put("houseIds", houseIds.substring(0, houseIds.length()-1));
			List<HouseAllAddressModel> list = baseHouseDao.getHouseAllAddress(map);
			map.clear();
			for (HouseAllAddressModel houseAllAddress : list) {
				map.put("addrDetail", houseAllAddress.getAddrdetail());
				map.put("province", houseAllAddress.getProvince());
				map.put("city", houseAllAddress.getCity());
				map.put("area", houseAllAddress.getArea());
				map.put("road", houseAllAddress.getRoad());
				map.put("roadNum", houseAllAddress.getRoadNum());
				map.put("premisesName", houseAllAddress.getPremisesName());
				map.put("premisesId", houseAllAddress.getPremisesId());
				map.put("groupName", houseAllAddress.getGroupName());
				map.put("groupId", houseAllAddress.getGroupId());
				map.put("buildingName", houseAllAddress.getBuildingName());
				map.put("buildingId", houseAllAddress.getBuildingId());
				map.put("areaId", houseAllAddress.getAreaId());
				map.put("roadId", houseAllAddress.getRoadId());
				map.put("list", houseAllAddress.getList());
				type = roomAddrDao.insertBatchHouseAddr(map);
				param.put("isUpdateHouseAddr", "111");
			}
		}
		return type;
	}
	
	public BaseBuildingModel getBuildingInfo(Map<String,Object> param){
		return baseBuildingDao.getBaseBuilding(param);
	}
	
	/**
	 * 批量更新房间
	 * @param param 
	 * @return Integer 0失败,大于0成功
	 */
	@SuppressWarnings("null")
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer batchUpdateHouse(Map<String,Object> param){
		Object roomObj = param.get("room");
		Object hallObj = param.get("hall");
		Object defendObj = param.get("defend");
		Object kitchenObj = param.get("kitchen");
		StringBuffer houseType= new StringBuffer("");
		if(roomObj == null && roomObj.equals("")){
			houseType.append(roomObj.toString()+"室");
		}else{
			houseType.append(0+"室");
		}
		if(hallObj == null && hallObj.equals("")){
			houseType.append(0+"厅");
		}else{
			houseType.append((hallObj.toString()+"厅"));
		}
		if(defendObj == null && defendObj.equals("")){
			houseType.append(0+"卫");
		}else{
			houseType.append((defendObj.toString()+"卫"));
		}
		if(kitchenObj == null && kitchenObj.equals("")){
			 houseType.append(0+"厨");
		}else{
			 houseType.append((kitchenObj.toString()+"厨"));
		}
		param.put("houseType", houseType.toString());
		return baseHouseDao.updatebaseHouse(param);
	}
	
	public Integer getHouseSource(Map<String, Object> param){
		return baseHouseDao.getHouseSource(param);
	}
	
}
