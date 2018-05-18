package com.golden.ihome.addr.service.baseBuilding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.baseBuilding.BaseBuildingDao;
import com.golden.ihome.addr.dao.baseHouse.BaseHouseDao;
import com.golden.ihome.addr.dao.buildingGroup.BuildingGroupDao;
import com.golden.ihome.addr.dao.buildingUnitsDao.BuildingUnitsDao;
import com.golden.ihome.addr.dao.ctxdll.RoomAddrDao;
import com.golden.ihome.addr.model.BaseBuildingModel;
import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.ihome.addr.model.BuildingGroupModel;
import com.golden.ihome.addr.model.PremisesMenuModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/**
 * @author zhr
 * 类描述：楼栋类
 */
@Service("baseBuilding/baseBuildingService")
public class BaseBuildingService implements IBaseHandler{

	public static Logger logger = LoggerFactory.getLogger(BaseBuildingService.class);
	
	@Autowired
	private BaseBuildingDao baseBuildingDao;
	
	@Autowired
	private BuildingGroupDao buildingGroupDao;
	
	@Autowired
	private BuildingUnitsDao buildingUnitsDao;
	
	@Autowired
	private BaseHouseDao basehousedao;
	@Autowired
	private RoomAddrDao roomAddrDao;

	/**
	 * 根据楼盘id获取楼栋数据
	 * @param param{BaseBuildingId：id}
	 * @return BaseBuildingModel
	 */
	@Override
	public BaseBuildingModel execute(Map<String, Object> param) throws Exception {
		 return	 baseBuildingDao.getBaseBuilding(param);
	}
	
	/**
	 * 可选择添加字段的新增一条楼栋数据
	 * @param param 实体的所有属性
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer insertSelective(Map<String, Object> param) throws Exception {
		Integer type = 0;
		
		List<BaseBuildingModel> list = new ArrayList<BaseBuildingModel>();
		// 更新时间
		param.put("updateTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		// 栋座数
		Integer blockSum = Integer.parseInt(param.get("houseNum").toString());
		// 楼栋前缀
		String blockPre = (String) param.get("housePre");
		if(blockPre==null){
			blockPre="";
		}
		// 楼栋后缀
		String blockSuf = (String) param.get("houseSuf");
		
		if(blockSuf==null){
			blockSuf="";
		}
		int indexOf = blockSuf.indexOf("栋");
		if(indexOf<0){
			blockSuf+="栋";
		}
		// 起始号段
		Object obj = param.get("numStart");
		String numStart =obj.toString();
		numStart = numStart.toUpperCase();
		// 栋座编号类型
		String houseCodeType= (String) param.get("houseCodeType");
		Integer generativeRule =2;
		if(houseCodeType!=null){
			generativeRule = Integer.parseInt(houseCodeType);
		}
		// 判断编号类型
		int newnumStart;
		if(generativeRule == 1){
			newnumStart = numStart.hashCode();
		}else{
			newnumStart = Integer.parseInt(numStart);
		}
		Map<String, Object> map = new HashMap<String,Object>();
		int i = 1;
		while(i <= blockSum){
			BaseBuildingModel model = new BaseBuildingModel();
			// 判断编号类型
			if(generativeRule == 1){
				// 楼栋名称
				model.setBuildingName(blockPre + (char)(newnumStart) + blockSuf);
				// 楼栋编号
				model.setBuildingCode((char)(newnumStart) + "");
				newnumStart++;
				
			}else{
				// 楼栋名称
				model.setBuildingName(blockPre + newnumStart + blockSuf);
				// 楼栋编号
				model.setBuildingCode(newnumStart + "");
				newnumStart++;
			}
			String buildingName = model.getBuildingName();
			map.put("buildingName", buildingName);
			map.put("premisesId", param.get("premisesId"));
			Integer buildingNum = baseBuildingDao.getBaseBuildingNum(map);
			if(buildingNum>0){
				type = -1;
				return type;
			}
			list.add(model);
			i++;
		}
		// 栋座数
		param.remove("houseNum");
		// 楼栋前缀
	/*	param.remove("housePre");*/
		// 楼栋后缀
		param.remove("houseSuf");
		// 起始号段
		param.remove("numStart");
		// 起始号段
		param.remove("endStart");
		// 编号类型
		param.remove("houseCodeType");
		
		if(!"0".equals(param.get("buildingGroupId"))){
			buildingGroupDao.updateSelective(param);
		}
		param.put("codes", list);
		// 创建时间
		param.put("sort", param.get("housePre")); 
		type = baseBuildingDao.insertBatch(param);
		return type;
	}

	/**
	 * 下拉列表 Ajax
	 * @param param 楼盘id
	 * @return map
	 */
	public Map<String, Object> getSelectList(Map<String, Object> param){
		Map<String, Object> map = new HashMap<>();
		
		List<Object> buildingGroupIdList = buildingGroupDao.getBuildingGroupList(param);
		map.put("buildingGroupIdList", buildingGroupIdList);
		
		return map;
	}
	
	/**
	 * 根据id获取分组导航及楼栋导航
	 * @param param {premisesId：id}
	 * @return List<PremisesMenuModel>
	 */
	public PagerResult<PremisesMenuModel> getPremisesMenuPage(Map<String,Object> param){
		PagerResult<PremisesMenuModel> premisesMenuPage = buildingGroupDao.getPremisesMenuPage(param);
		List<PremisesMenuModel> list = premisesMenuPage.getPagerResults();
		Map<String, Object> map = new HashMap<String,Object>();
		for (PremisesMenuModel premisesMenuModel : list) {
			map.put("groupId", premisesMenuModel.getGroupId());
			List<PremisesMenuModel> buildingMenu = baseBuildingDao.getBuildingMenu(map);
			premisesMenuModel.setListMenu(buildingMenu);
		}
		List<PremisesMenuModel> buildingMenu = baseBuildingDao.getBuildingMenu(param);
		if(buildingMenu != null && buildingMenu.size() > 0){
			PremisesMenuModel menu = new PremisesMenuModel();
			menu.setListMenu(buildingMenu);
			menu.setGroupName("未分组");
			list.add(menu);
			premisesMenuPage.setTotalCount(premisesMenuPage.getTotalCount()+1);
		}
		
		return premisesMenuPage;
	}

	/**
	 * 模糊查询分组
	 * @param param
	 * @return
	 */
	public List<BaseBuildingModel> getBuildingGroupList(Map<String, Object> param){
		
		return buildingGroupDao.getBuildingsGroupList(param);
	}
	
	/**
	 * 校验名字是否重复
	 * @param param{groupName：新增分组名}  or
	 * 		  param{updateGroupName:修改分组名,groupId:分组id}
	 * @return Integer
	 */
	public Integer getGroupNum(Map<String, Object> param){
		return buildingGroupDao.getGroupNum(param);
	}

	/**
	 * 新增单条栋座信息 dl
	 * @param   premisesId 楼盘id
		    	groupId 楼盘分组id
				purpose 房屋用途（1商用，2民用）
				buildingYear 建筑年代 （数值型）
				buildingConst 建筑结构（数值型）
				buildingType 建筑类型（数值型）
				buildingName 楼栋编号（字符型）
				propertyNature 产权性质（数值型）
				costType 缴费类型（1物业费2清洁费）
				propertyFee 物业费/清洁费
	 * @return  0保存失败 1保存成功 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer insertOneBaseBuilding(Map<String,Object> map){
		return baseBuildingDao.insertOneBaseBuilding(map);
	}
	/**
	 *删除楼栋信息
	 * @param   buildingId 栋座id
	 * @return	0删除失败 1删除成功 2该楼栋有关联数据
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer deleteBaseBuildingById(Map<String,Object> map){
		if(map.containsKey("buildingId") && map.get("buildingId")!=null && !map.get("buildingId").equals("")){
			Integer num = buildingUnitsDao.getBuildingUnitNum(map);
			if(num>0){
				return 2;
			}else{
				return baseBuildingDao.deleteBaseBuilding(map);
			}
		}else{
			return 0;
		}
	}
	
	/**
	 * 批量插入楼盘分组
	 * @param param {key:groupList}groupList为数组名称的数组
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer insertBatch(Map<String,Object> param){
		 String groupStr= (String) param.get("groupStr");
		 String[] groupList = groupStr.split(",");
		 param.put("groupList", groupList);
		return  buildingGroupDao.insertBatch(param);
	}
	
	/**
	 * 删除分组或楼栋
	 * @param param {key:groupList}groupList为数组名称的数组
	 * @return Integer(大于0成功，小于0不成功)
	 */
	@TM
	public Integer delGroupBuild(Map<String, Object> param){
		Integer type = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		String groupIds = (String) param.get("groupIds");
		String groupId = (String) param.get("groupId");
		String buildingId = (String) param.get("buildingId");
		if(buildingId==null){
			if(groupIds!=null){
				/*String[] groupIdArray = groupIds.split(",");
				for (int i = 0; i < groupIdArray.length; i++) {
					map.put("groupId", groupIdArray[i]);
					Integer num = baseBuildingDao.getBaseBuildingNum(map);
					if(num>0){
						return type;
					}
				}*/
				 map.put("groupId", groupIds);
			}else{
				map.put("groupId", groupId);
				/*Integer num = baseBuildingDao.getBaseBuildingNum(map);
				if(num>0){
					return type;
				}*/
			}
			baseBuildingDao.isGroupIdNull(map);
			Map<String, Object> GroupMap = new HashMap<String,Object>();
			GroupMap.put("groupIdIsNull", "null");
			GroupMap.put("groupId", map.get("groupId"));
			buildingUnitsDao.updateGroupid(GroupMap);
			basehousedao.updateGroupid(GroupMap);
			GroupMap.put("groupName","");
			roomAddrDao.updateHouseAddr(GroupMap);
			return	buildingGroupDao.delete(map);
		}else{
			map.put("buildingId", buildingId);
			Integer num = buildingUnitsDao.getBuildingUnitNum(map);
			Integer hNum = basehousedao.getByNum(param);
			if(num>0 || hNum>0){
				return type;
			}
			return baseBuildingDao.deleteBaseBuilding(map);
		}
	}
	
	/**
	 * 修改楼栋和分组名字
	 * @param param
	 * @return
	 */
	@TM
	@Aop(name = "syncHouseAop",type="around")
	public Integer updateGroupBuilding(Map<String, Object> param){
		Map<String, Object> groupMaps = new HashMap<String,Object>();
		Integer type = 0;
		Map<String, Object> map = new HashMap<>();
		String group = (String) param.get("group");
		String premisesId = (String) param.get("premisesId");
		if(group != null && !group.equals("")){
			String[] groupMap = group.split("#");
			for (int i = 0; i < groupMap.length; i++) {
				String groupStr = groupMap[i];
				String[] groupArr = groupStr.split(",");
				//校验重名、
				map.put("groupId", groupArr[0]);
				map.put("updateGroupName", groupArr[1]);
				map.put("premisesId", premisesId);
				Integer groupNum = buildingGroupDao.getGroupNum(map);
				if(groupNum>0){
					type=-1;
					return type;
				}
				map.clear();
				map.put("id", groupArr[0]);
				map.put("groupName", groupArr[1]);
				type = buildingGroupDao.updateSelective(map);
				if(type>0){
					groupMaps.put("groupId",groupArr[0]);
					groupMaps.put("groupName",groupArr[1]);
					roomAddrDao.updateHouseAddr(groupMaps);
				}
					
			}
		}
		map.clear();
		String building = (String) param.get("building");
		if(building!=null && !building.equals("")){
			String[] buildingMap = building.split("#");
			for (int i = 0; i < buildingMap.length; i++) {
				String[] buildingArr = buildingMap[i].split(",");
				map.put("baseBuildingId", buildingArr[0]);
				map.put("updateBuildingName", buildingArr[1]);
				map.put("premisesId", premisesId);
				Integer buildingNum = baseBuildingDao.getBaseBuildingNum(map);
				if(buildingNum>0){
					type=-2;
					return type;
				}
				map.clear();
				map.put("baseBuildingId", buildingArr[0]);
				map.put("buildingName", buildingArr[1]);
				type = baseBuildingDao.updateBaseBuilding(map);
				groupMaps.clear();
				
				if(type>0){
					groupMaps.put("buildingId",buildingArr[0]);
					groupMaps.put("building",buildingArr[1]);
					roomAddrDao.updateHouseAddr(groupMaps);
				}
			}
		}
		
		param.put("isUpdateHouseAddr", "111");
		return type;
	}
	
	/**
	 * 根据楼栋id获取一条数据
	 * @param param
	 * @return
	 */
	public BaseBuildingModel getBuilding(Map<String, Object> param){
		return baseBuildingDao.getBaseBuilding(param);
		
	}
	/**
	 * 修改楼栋
	 * @param param
	 * @return
	 */
	@TM
	@Aop(name = "syncHouseAop",type="around")
	public Integer updateBuilding(Map<String, Object> param){
		Map<String, Object>map =new  HashMap<String, Object>();
		Integer type = 0;
		map.put("baseBuildingId", param.get("baseBuildingId"));
		map.put("updateBuildingName", param.get("buildingName"));
		map.put("premisesId", param.get("premisesId"));
		Integer buildingNum = baseBuildingDao.getBaseBuildingNum(map);
		if(buildingNum>0){
			type=-2;
			return type;
		}
		type = baseBuildingDao.updateBaseBuilding(param);
		//更新单元i、房间、全地址里分组名称和id
		map.clear();
		map.put("groupId", param.get("buildingGroupId"));
		BuildingGroupModel buildingGroup = buildingGroupDao.getBuildingGroup(map);
		map.clear();
		if(buildingGroup!= null){
			map.put("groupName", buildingGroup.getGroupName());
			map.put("groupIdIsNull", param.get("buildingGroupId"));
			map.put("buildingId", param.get("baseBuildingId"));
			buildingUnitsDao.updateGroupid(map);
			basehousedao.updateGroupid(map);
			map.put("group_id", param.get("buildingGroupId"));
			roomAddrDao.updateHouseAddr(map);
		}
		return type;
	}
	/**
	 * 根据楼盘id获取楼盘数据
	 * @param param{premisesId：楼盘id}
	 * @return BasePremisesModel
	 */
	public BasePremisesModel getPremises(Map<String,Object> param){
		return baseBuildingDao.getpremises(param);
	}
}
