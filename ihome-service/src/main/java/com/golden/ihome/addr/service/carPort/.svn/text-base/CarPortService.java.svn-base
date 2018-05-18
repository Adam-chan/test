package com.golden.ihome.addr.service.carPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.golden.ihome.addr.dao.carPort.CarPortDao;
import com.golden.ihome.addr.model.BaseBuildingModel;
import com.golden.ihome.addr.model.BuildingGroupModel;
import com.golden.ihome.addr.model.BuildingUnitsModel;
import com.golden.ihome.addr.model.CarPortModel;
import com.golden.ihome.addr.model.ParkContactRoomModel;
import com.golden.ihome.crm.model.HouseLinkManModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/**
 * 车位信息
 * @author dl
 *
 */
@Service("carPort/carPortService")
public class CarPortService implements IBaseHandler{
	
	@Autowired
	private CarPortDao carPortDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 单个添加车位信息
	 * @param map
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	public Integer insertCarPort(Map<String, Object> map){
		return carPortDao.insertCarPort(map);
	}
	/**
	 * 分页查询车位信息
	 * @param map
	 * @return
	 */
	public PagerResult<CarPortModel> getCarPortListForPage(Map<String,Object> map){
		return carPortDao.getCarPortListForPage(map);
	}
	/**
	 * 根据车位id查询车位
	 * @param map
	 * @return
	 */
	public CarPortModel getCarPortById(Map<String,Object> map){
		CarPortModel port = new CarPortModel();
		if(map.containsKey("id") && map.get("id")!=null && !map.get("id").equals("")){
			port = carPortDao.getCarPortById(map);
		}
		return port;
	}
	/**
	 * 车位关联房间
	 * @param map
	 * @return
	 */
	public Integer contactRoomByPortId(Map<String, Object> map){
		if(map.containsKey("carPortId") && map.get("carPortId")!=null && !map.get("carPortId").equals("")
				&& map.containsKey("roomId") && map.get("roomId")!=null && !map.get("roomId").equals("")){
			Integer result = carPortDao.contactRoomByPortId(map);
			if(result==1){
				//添加车位关联房间日志
				Map<String, Object> logMap = new HashMap<String,Object>();
				logMap.put("roomId", map.get("roomId"));
				logMap.put("carPortId", map.get("carPortId"));
				logMap.put("operater", map.get("userName"));//注：取当前登陆人姓名
				logMap.put("operateType", 1);
				carPortDao.insertCarPortLog(logMap);
				return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	/**
	 * 解除车位和房间的关联
	 * @param map
	 * @return
	 */
	public Integer removeRoom(Map<String, Object> map){
		if(map.get("carPortId")!=null && !map.get("carPortId").equals("")){
			carPortDao.removeRoom(map);
			//添加车位解除关联房间日志
			Map<String, Object> logMap = new HashMap<String,Object>();
			logMap.put("roomId", map.get("roomId"));
			logMap.put("carPortId", map.get("carPortId"));
			logMap.put("operaterId", map.get("userId").toString());
			logMap.put("operater", map.get("userName").toString());
			logMap.put("operateType", 2);
			carPortDao.insertCarPortLog(logMap);
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 * 根据id修改车位
	 * @param map
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	public Integer updateCarPortById(Map<String, Object> map){
		return carPortDao.updateCarPortById(map);
	}
	/**
	 * 车位唯一校验
	 * @param map
	 * @return
	 */
	public Integer getCarPortIs(Map<String, Object> map){
		Integer result = carPortDao.getCarPortIs(map).get(0);
		if(result>0){
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 * 批量删除车位信息(暂不用)
	 * @param map
	 * @return
	 */
	@TM
	public Object deleteCarPorts(Map<String, Object> map){
		String result = "";
		if(map.containsKey("premisesId") && map.containsKey("carPortIds") && map.get("carPortIds").toString().length()>0){
			Integer delResult = null;
			String[] carPortIdArray = map.get("carPortIds").toString().split(",");
			List<CarPortModel> list = carPortDao.getPortListContactedRoom(map);//获取已关联房间的车位
			StringBuffer delCarPort = new StringBuffer();
			StringBuffer unDelCarPort = new StringBuffer();
			//未关联房间的车位可以删除，已关联房间的车位返回页面提示
			for (int i = 0; i < carPortIdArray.length; i++) {
				boolean flag = false;
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).getId().toString().equals(carPortIdArray[i])){
						flag = true;
						unDelCarPort.append("、").append(list.get(j).getParkNum());
					}
				}
				if(flag == false){
					delCarPort.append(",").append(carPortIdArray[i]);
				}
			}
			//删除车位
			if(delCarPort.length()>0){
				Map<String,Object> delMap = new HashMap<String, Object>();
				delMap.put("carPortIds", delCarPort.deleteCharAt(0).toString());
				delResult = carPortDao.deleteCarPorts(map);
			}
			//设置返回值
			if(delResult == 0){
				result = "删除失败！";
			}else if(delResult == 1 && unDelCarPort.length()==0){
				result = "删除成功！";
			}else if(delResult == 1 && unDelCarPort.length()>0){
				result = "删除成功！车位"+unDelCarPort.deleteCharAt(0).toString()+"已关联房间，无法删除！";
			}else{
				
			}
		}
		return result;
	}
	/**
	 * 根据楼盘id查询楼栋
	 * @param map
	 * @return
	 */
	public List<BaseBuildingModel> getBuildingsByPremisesId(Map<String,Object> map){
		List<BaseBuildingModel> list = carPortDao.getBuildingsByPremisesId(map);
		return list;
	}
	/**
	 * 根据楼盘id查询栋座分组
	 * @param map
	 * @return
	 */
	public List<BuildingGroupModel> getGroupsByPremisesId(Map<String,Object> map){
		List<BuildingGroupModel> list = carPortDao.getGroupsByPremisesId(map);
		return list;
	}
	/**
	 * 根据了栋座分组id查询栋座
	 * @param map
	 * @return
	 */
	public List<BaseBuildingModel> getBuildingsByGroupId(Map<String,Object> map){
		List<BaseBuildingModel> list = carPortDao.getBuildingsByGroupId(map);
		return list;
	}
	/**
	 * 根据楼栋id查询单元
	 * @param map
	 * @return
	 */
	public List<BuildingUnitsModel> getUnitsByBuildingId(Map<String,Object> map){
		List<BuildingUnitsModel> list = carPortDao.getUnitsByBuildingId(map);
		return list;
	}
	/**
	 * 车位关联房间-房间查询
	 * @param map
	 * @return
	 */
	public List<ParkContactRoomModel> getRoomList(Map<String,Object> map){
		List<ParkContactRoomModel> list = carPortDao.getRoomList(map);
		return list;
	}
	/**
	 * 批量生成车位
	 * @param 	prefix 前缀    
	 * 			suffix 后缀  
	 *   	   	startNum 起始号
	 *   		endNum 结束号
	 *   		ignore 忽略号
	 *   		isNumberFill 号段0补位  0:不补位  1：补位
	 *   		type 类型 1车库   2车位
	 *   		floor 楼层 1地上 2地下
	 *   		premisesId 楼盘id
	 * @return  Integer 0 保存失败 1 保存成功 2该号段数据已存在
	 */
	@TM
	public Integer insertCarPorts(Map<String,Object> map){
		String prefix = map.get("prefix").toString();
		String suffix = map.get("suffix").toString();
		Integer startNum = Integer.parseInt(map.get("startNum").toString());
		Integer endNum = Integer.parseInt(map.get("endNum").toString());
		String ignore = map.get("ignore").toString();
		String isNumberFill = map.get("isNumberFill").toString();
		String ignoreNum[] = ignore.split(",");
		if(startNum!=null && endNum!=null && startNum<endNum){
			String allNum = "";//所有添加的号
			for (int i = startNum; i <= endNum; i++) {
				allNum+=i+",";
			}
			String portNum[] = allNum.split(",");
			List<String> portNumList = new ArrayList<String>(Arrays.asList(portNum));
			List<String> ignorePortNumList = new ArrayList<String>(Arrays.asList(ignoreNum));
			List<String> existPortNumList = carPortDao.getAllPortNumList(map);
			List<String> paramsPortNumList = new ArrayList<String>();
			//移除忽略号段
			if(portNumList.size()>0){
				portNumList.removeAll(ignorePortNumList);
			}
			//可添加车位号list
			for (int i = 0; i < portNumList.size(); i++) {
				StringBuffer parkNum = new StringBuffer();
				parkNum.append(prefix);
				String str = "";
				if(isNumberFill.equals("1")){
					str = String.format("%05d", Integer.parseInt(portNumList.get(i).toString()));//号段0补位
					parkNum.append(str);
				}else{
					parkNum.append(portNumList.get(i));
				}
				parkNum.append(suffix);
				paramsPortNumList.add(parkNum.toString());
			}
			//移除已存在车位号
			if(existPortNumList.size()>0){
				paramsPortNumList.removeAll(existPortNumList);
			}
			//批量生成车位
			if(portNumList.size()>0){
				Map<String,Object> paramsMap = new HashMap<String,Object>();
				paramsMap.put("premisesId", map.get("premisesId").toString());//楼盘id
				paramsMap.put("type", map.get("type").toString());//类型
				paramsMap.put("floor", map.get("floor").toString());//楼层
				paramsMap.put("portNumList", paramsPortNumList);//车位号list
				Integer result = carPortDao.insertCarPorts(paramsMap);
				if(result>0){
					return 1;
				}else{
					return 0;
				}
			}else{
				return 2;
			}
		}else{
			return 0;
		}
	}
	/**
	 * 车位转为出租生成房源信息
	 * @param carPortId 车位id
		      addressDetail 楼盘详细地址
		      zzdzDetail 证载地址
		      propertyRightType 产权性质 1.有产权 2.无产权
			  leasePrice 租价
              entrustPrice 底价
			  propertyFee 物业费(元/㎡/月)
			  useStatus 使用现状  1闲置2出租3自住
		      fckCode 房产证号
			  fckDate 房产证签发日期
		      ownerSourceId 业主来源
		      status 房源状态 1无效、2暂不租、3已租、4已成交、5待租
		      tags 房源标签 
		      tags2 房源标签(1,2,3)
		      remark 备注
	 * @return
	 */
	@TM
	public Integer insertHouseLeaseWithCarPort(Map<String, Object> map){
		map.put("demandType", 2);
		map.put("isProtected", 1);
		Integer i = carPortDao.insertHouseInfo(map);
		if(i==1){
			map.put("houseInfoId", Integer.parseInt(map.get("houseInfoId").toString())-1);
			Integer result = carPortDao.insertCarPortLease(map);
			if(result==1){
				//保存房源联系人
				Map<String,Object> linkManMap = new HashMap<String,Object>();
				String[] linkMan = map.get("linkManList").toString().split("-");
				List<HouseLinkManModel> linkManList = new ArrayList<HouseLinkManModel>();
				for (int j = 0; j < linkMan.length; j++) {
					JSONObject obj = JSON.parseObject(linkMan[j]);
					HouseLinkManModel man = new HouseLinkManModel();
					man.setType(Integer.parseInt(obj.get("type").toString()));
					man.setName(obj.get("name").toString());
					man.setContactType(obj.get("contactType").toString());
					linkManList.add(man);
				}
				linkManMap.put("linkManList", linkManList);
				linkManMap.put("houseInfoId", Integer.parseInt(map.get("houseInfoId").toString())-1);
				carPortDao.insertHouseLinkMans(linkManMap);
				//更新车位"委托"
				Map<String, Object> paramsMap = new HashMap<String,Object>();
				paramsMap.put("carPortId", map.get("carPortId"));
				Integer saledIs = (Integer) carPortSaledIs(paramsMap);
				Integer authorize = 1;
				if(saledIs>0){
					authorize = 3;
				}
				paramsMap.put("authorize", authorize);
				carPortDao.updateAuthorizeByPortId(paramsMap);
			}
			return result;
		}else{
			return 0;
		}
	}
	/**
	 * 车位转为出售生成房源信息
	 * @param carPortId 车位id
		      addressDetail 楼盘详细地址
		      zzdzDetail 证载地址
		      propertyRightType 产权性质 1.有产权 2.无产权
			  sellPrice 售价
              entrustPrice 底价
			  propertyFee 物业费(元/㎡/月)
			  useStatus 使用现状  1闲置2出租3自住
		      fckCode 房产证号
			  fckDate 房产证签发日期
		      ownerSourceId 业主来源
		      status 房源状态 1无效、2暂不租、3已租、4已成交、5待租
		      tags 房源标签 
		      tags2 房源标签(1,2,3)
		      remark 备注
	 * @return
	 */
	@TM
	public Integer insertHouseSaleWithCarPort(Map<String, Object> map){
		map.put("demandType", 2);
		map.put("isProtected", 1);
		Integer i = carPortDao.insertHouseInfo(map);
		if(i==1){
			map.put("houseInfoId", Integer.parseInt(map.get("houseInfoId").toString())-1);
			Integer result = carPortDao.insertCarPortSale(map);
			//更新车位的"委托"
			Map<String, Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("carPortId", map.get("carPortId"));
			if(result==1){
				//保存房源联系人
				Map<String,Object> linkManMap = new HashMap<String,Object>();
				String[] linkMan = map.get("linkManList").toString().split("-");
				List<HouseLinkManModel> linkManList = new ArrayList<HouseLinkManModel>();
				for (int j = 0; j < linkMan.length; j++) {
					JSONObject obj = JSON.parseObject(linkMan[j]);
					HouseLinkManModel man = new HouseLinkManModel();
					man.setType(Integer.parseInt(obj.get("type").toString()));
					man.setName(obj.get("name").toString());
					man.setContactType(obj.get("contactType").toString());
					linkManList.add(man);
				}
				linkManMap.put("linkManList", linkManList);
				linkManMap.put("houseInfoId", Integer.parseInt(map.get("houseInfoId").toString())-1);
				carPortDao.insertHouseLinkMans(linkManMap);
				//更新车位"委托"
				Integer saledIs = (Integer) carPortLeasedIs(paramsMap);
				Integer authorize = 2;
				if(saledIs>0){
					authorize = 3;
				}
				paramsMap.put("authorize", authorize);
				carPortDao.updateAuthorizeByPortId(paramsMap);
			}
			return result;
		}else{
			return 0;
		}
	}
	/**
	 * 查询车位是否已出租
	 * @param map
	 * @return
	 */
	public Object carPortLeasedIs(Map<String, Object> map){
		return carPortDao.carPortLeasedIs(map);
	}
	/**
	 * 查询车位是否已出售
	 * @param map
	 * @return
	 */
	public Object carPortSaledIs(Map<String, Object> map){
		return carPortDao.carPortSaledIs(map);
	}
	/**
	 * 批量删除车位
	 * @param map
	 * @return
	 */
	public Integer deleteCarPortByIds(Map<String, Object> map){
		return carPortDao.deleteCarPortByIds(map);
	}
	/**
	 * 模糊搜索车位
	 * @param map
	 * @return
	 */
	public List<CarPortModel> getCarPortByMatch(Map<String,Object> map){
		List<CarPortModel> list = carPortDao.getCarPortByMatch(map);
		return list;
	}
	
}






