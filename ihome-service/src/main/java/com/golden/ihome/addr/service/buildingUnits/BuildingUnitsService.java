package com.golden.ihome.addr.service.buildingUnits;

import java.util.HashMap;
import java.util.Iterator;
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
import com.golden.ihome.addr.model.BuildingUnitsModel;
import com.golden.ihome.addr.model.HouseAllAddressModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;

/**
 * 
 * @author lza
 * 类名称：单元管理service
 * 类描述：针对单元表业务
 * 日          期：2016-10-17
 */
@Service("buildingUnits/buildingUnitsService")
public class BuildingUnitsService implements IBaseHandler{
	
	@Autowired
	private BuildingUnitsDao buildingUnitsDao;
	@Autowired
	private BaseBuildingDao baseBuildingDao;
	@Autowired
	private BaseHouseDao baseHouseDao;
	@Autowired
	private RoomAddrDao roomAddrDao;
	/**
	 * 根据id获取一条单元数据
	 * @param param{BuildingUnitsId：id}
	 * @return buildingUnits
	 */
	public Object execute(Map<String, Object> param) throws Exception {
		return buildingUnitsDao.getbuildingUnits(param);
	}
	
	/**
	 * 根据id更新单元实体
	 * @param param{buildingUnitsId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer updatebuildingUnits(Map<String,Object> param){
		return buildingUnitsDao.updatebuildingUnits(param);
	}
	/**
	 * 根据id删除单元一条
	 * @param param{buildingUnitsIds：单元id字符串,unitId:单元id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	@Aop(name = "syncHouseAop",type="around")
	public Integer deletebuildingUnits(Map<String,Object> param){
		Integer type = 0;

		if(param.get("unitId")!=null&&!param.get("unitId").equals("")){
			Map<String, Object> map = new HashMap<String,Object>();
			Integer num = baseHouseDao.getbyUnitDelNum(param);
			if(num>0){
				type = -1;
				return type;
			}
			map.put("buildingUnitsIds", param.get("unitId"));
			type = buildingUnitsDao.deletebuildingUnits(map);
			Map<String, Object> deleteHouseMap = new HashMap<String,Object>();
			deleteHouseMap.put("unitsId",param.get("unitId"));
			roomAddrDao.deleteHouseAddr(deleteHouseMap);
			if(type>0){
				type = baseHouseDao.deletebaseHouse(param);
			}
		}
		return type;
	}
	
	/**
	 * 可选择添加字段的新增一条单元数据
	 * @param param 实体的所有属性均可
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer insertSelective(Map<String,Object> param){
		return buildingUnitsDao.insertSelective(param);
	}
	
	/**
	 * 批量添加单元编号和房间
	 * @param param {codes：单元编号数组}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	
	@Aop(name = "syncHouseAop",type="around")
	@TM(isolation=TransactionDefinition.ISOLATION_READ_COMMITTED)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer insertBatch(Map<String,Object> param){
		Integer type = 0;
		//更新单元的生成规则到楼栋
		Map <String,Object> buildingMap = new HashMap<String,Object>();
        for(Iterator it = param.keySet().iterator() ; it.hasNext();){
            String key = it.next().toString();
            buildingMap.put(key, param.get(key));
        }
        buildingMap.remove("list");
		if(buildingMap.get("unitSuf").toString().indexOf("单元")==-1){
			buildingMap.put("unitSuf", buildingMap.get("unitSuf").toString()+"单元");
		}
		type = baseBuildingDao.updateBaseBuilding(buildingMap);
		if(type == 0){
			return type;
		}
		//获取json格式单元对象List<map>list，并转换成json字符串
		String jsonUnitList = (String) param.get("list");
		//将json格式的单元数组对象转换成list集合
		List listunit = JSON.parseObject(jsonUnitList, List.class);
		//便利单元list集合元素
		Map <String,Object> buildingUnitmap = new HashMap<String,Object> ();
		Map <String,Object> Unitmap = new HashMap<String,Object> ();
		//便利房间list集合元素
		Map <String,Object> proom = new HashMap<String,Object> ();
		String houseIds = "";
		for (Object object : listunit) {
			//获取map对象
			buildingUnitmap = JSON.parseObject(JSON.toJSONString(object), Map.class);
			Unitmap = JSON.parseObject(JSON.toJSONString(object), Map.class);
			Unitmap.remove("roomList");
			//添加单元信息
			type = buildingUnitsDao.insertSelective(Unitmap);
			int BudingUnitId = (int) Unitmap.get("BudingUnitId");
			if(type>0){
				//获取map键为roomList(List <map> list 房间数组集合)
				Object roomList = buildingUnitmap.get("roomList");
				//将roomList转化为list
				List roomLists = JSON.parseObject(JSON.toJSONString(roomList), List.class);
				for (Object object2 : roomLists) {
					//将list的每个元素转化为map
					proom = JSON.parseObject(JSON.toJSONString(object2), Map.class);
					proom.put("unitId", BudingUnitId);
					//创建时间
					//proom.put("createTime", now);
					//添加房间
					type = baseHouseDao.insertSelective(proom);
					//添加失败,直接返回
					if(type==0){
						return type;
					}
					int houseId = (int) proom.get("houseId");
					houseIds += (houseId+",");
				}
			}
		}
		if(houseIds.equals("")){
			return type;
		}
		//添加全地址
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("houseIds", houseIds.substring(0, houseIds.length()-1));
		List<HouseAllAddressModel> list = baseHouseDao.getHouseAllAddress(map);
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
		return type;
	}
	
	public List<BuildingUnitsModel> geteditUnit(Map<String, Object> param){
		return buildingUnitsDao.geteditUnit(param);
	}
	
}
