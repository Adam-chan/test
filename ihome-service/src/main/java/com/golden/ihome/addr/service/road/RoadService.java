package com.golden.ihome.addr.service.road;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.basearea.BaseAreaDao;
import com.golden.ihome.addr.dao.premisesManage.BasePremisesDao;
import com.golden.ihome.addr.dao.road.RoadDao;
import com.golden.ihome.addr.model.BaseAreaModel;
import com.golden.ihome.addr.model.RoadLogModel;
import com.golden.ihome.addr.model.RoadModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

@Service("road/roadService")
public class RoadService implements IBaseHandler{

	public static Logger logger = LoggerFactory.getLogger(RoadService.class);
	
	@Autowired
	private RoadDao roadDao;
	
	@Autowired
	private BaseAreaDao baseAreaDao;

	@Autowired
	private BasePremisesDao basePremisesDao;
	
	/**
	 * 分页查询道路号
	 * @param params
	 * @return
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return roadDao.queryRoadNumListPage(param);
	}

	/**
	 * 分页查询道路
	 * @param params
	 * @return
	 */
	public PagerResult<RoadModel> getRoadListForPage(Map<String,Object> map){
		return roadDao.getRoadListForPage(map);
	}
	/**
	 * 分页查询日志
	 * @param params
	 * @return
	 */
	public PagerResult<RoadLogModel> queryRoadLogListPage(Map<String,Object> map){
		return roadDao.queryRoadLogListPage(map);
	}
	/**
	 * 查询所有道路信息
	 * @param 
	 * @return
	 */
	public List<RoadModel> getRoadList(){
		return roadDao.getRoadList();
	}
	/**
	 * 根据id查询道路
	 * @param map
	 * @return
	 */
	public RoadModel getRoadById(Map<String, Object> map){
		RoadModel roadInfo = roadDao.getRoadById(map);
		return  roadInfo;
	}
	/**
	 * 新增道路
	 * @param map
	 * @return
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer insertRoad(Map<String, Object> map){
		return roadDao.insertRoad(map);
	}
	/**
	 * 修改道路名字
	 * @param map
	 * @return
	 */
	@TM
	@Aop(name="syncRoadAop",type="around")
	public Integer updateRoad(Map<String, Object> map){
		//--更新sync 道路和楼盘详细地址
		map.put("road",map.get("roadName"));
		map.put("roadId",map.get("id"));
		roadDao.updateRoadAddr(map);
		roadDao.updateHouseAddr(map);
		//--
		return roadDao.updateRoad(map);
	}
	/**
	 * 批量删除道路
	 * @param map
	 * @return
	 */
	@TM
	@Aop(name="syncRoadAop",type="after")
	public Integer deleteRoads(Map<String, Object> map){
		int result = 1;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("roadId",map.get("rowIds").toString());
		RoadLogModel roadLogCount = roadDao.getRoadLogCount(param);
		if(roadLogCount.getCount()!=0){//----生成道路号了------
			if(basePremisesDao.getPemisesCount(param)!=0){
				return result = 2;//道路号址被楼盘引用无法删除 返回
			}
		}
		roadDao.deleteRoadNum(param);//删除之前存在道路号数据
		roadDao.deleteRoadAddr(param);//删除sync 删除全文索引道路数据
		roadDao.deleteRoads(map);
		param.put("roadLogStatus", 2);//删除之后更改道路日志状态
		param.put("operator", map.get("operator").toString());
		param.put("operatorId", map.get("operatorId").toString());
		param.put("operatorOrgCode", map.get("operatorOrgCode").toString());
		roadDao.updateRoadLog(param);
		return result;
	}
	/**
	 * 保存道路和区域关联关系
	 * @param map
	 * @return
	 */
	public Integer insertRoadAreaContact(Map<String, Object> map){
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String areaIdStr = map.get("areaIdStr").toString();
		String areaIds[] = areaIdStr.split(",");
		paramsMap.put("areaIds", areaIds);
		paramsMap.put("roadId", map.get("roadId"));
		return roadDao.insertRoadAreaContact(paramsMap);
	}
	/**
	 * 查询浙江省杭州市下所有区
	 * @return
	 */
	public List<BaseAreaModel> getAreasList(){
		return roadDao.getAreasList();
	}
	/**
	 * 模糊匹配 道路
	 * @param String roadId 道路ID   matchStr 模糊道路名字
	 * @return List<RoadModel>
	 */
	public List<RoadModel> getRoadNumByMatch(Map<String, Object> param){
		return roadDao.getRoadNumByMatch(param);
	}
	/**
	 * 更改道路号使用状态 道路号段
	 * @param String Id 道路号ID   roadNumStatus 使用状态 1：使用中 2：未使用
	 * @return List<RoadModel>
	 */
	@SuppressWarnings("unused")
	@TM
	@Aop(name="syncRoadAop",type="after")
	public Integer updateRoadNumStatus(Map<String, Object> map){
		int result = 0;
		String uniteId = map.get("id").toString();
		map.put("uniteId", uniteId);
		map.put("status", map.get("roadNumStatus").toString());
		String roadNumStatus = map.get("roadNumStatus").toString();
		if(roadNumStatus.equals("2")){
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("roadId", uniteId);
			Integer pemisesCount = basePremisesDao.getPemisesCount(param);//忽略道路号时，判断楼盘是否引用
			if(pemisesCount!=0){
				return result;//已有楼盘引用 无法忽略
			}
		}
		roadDao.updateRoadAddr(map);//更细SYNC表
		Integer updateRoadNum = roadDao.updateRoadNum(map); //更新道路号状态
		if(updateRoadNum!=0){//更新成功后 更新道路日志
			String ignoreNum ="";
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("roadId", uniteId.substring(0, uniteId.length()-5));//截取过去道路ID
			//截取道路号
			String roadNum = uniteId.substring(uniteId.length()-5, uniteId.length()).replaceAll("^(0+)","");
			param.put("roadNum",roadNum);
			//根据道路号和道路ID查询日志ID
			RoadLogModel roadLogInfo = roadDao.getRoadLogInfo(param);
			//获取这个忽略道路号范围日志ID
			String resultIgnoreNum = roadLogInfo.getIgnoreNum();
			String[] ignoreNumArray = resultIgnoreNum.split(",");
			int type = 1;
			if(roadLogInfo!=null){
				for(int i = 0; i < ignoreNumArray.length; i++){
					if (ignoreNumArray[i].equals(roadNum)){
						type = 2;//包含忽略号  反复忽略时 判断之前是否存在
						break;
				    }
				 }
				if(type==1){//原忽略号不包含
					ignoreNum = roadLogInfo.getIgnoreNum().toString()+","+roadNum;
				}else{
					ignoreNum = roadLogInfo.getIgnoreNum().toString();
				}
			}else{
				ignoreNum = roadNum;
			}
			param.put("ignoreNum", ignoreNum);
			param.put("operTime", DateUtil.getDateByLong(System.currentTimeMillis()));
			param.put("operator", map.get("operator").toString());
			param.put("operatorId", map.get("operatorId").toString());
			param.put("operatorOrgCode", map.get("operatorOrgCode").toString());
			param.put("id", roadLogInfo.getId());
			roadDao.updateRoadLogNew(param);
			result =  1;
		}
		return result;
	}
	/**
	 * 更改道路日志使用状态 
	 * @param String Id 日志ID   roadLogStatus 使用状态 1：使用中 2：未使用
	 * @return Integer
	 */
	public Integer updateRoadLogStatus(Map<String, Object> map){
		return roadDao.updateRoadLog(map);
	}
	/**
	 * 获得道路号数量 道路撒号验证
	 * @param String   startNum 起始号 
	 * @return RoadLogModel
	 */
	public Integer getRoadNumCount(Map<String, Object> param){
		int result = 1;
		if(param.get("startNum")!=null && param.get("endNum")!=null){
			String startNum = param.get("startNum").toString();
			String endNum = param.get("endNum").toString();
			int startNumInt = Integer.parseInt(startNum);
			int endNumInt = Integer.parseInt(endNum);
			RoadLogModel roadNumCount = roadDao.getRoadNumCount(param);//一次验证 验证起始号 和终止号是否在范围中
			if(roadNumCount.getNumbers()!=0){
				return result = 2; //该段号段存在 
			}else{
				List<RoadLogModel> startOrEndNumList = roadDao.getRoadNumInclude(param);
				for(RoadLogModel item:startOrEndNumList){
					if(startNumInt < item.getStartNum()&&endNumInt > item.getEndNum()){
						return result = 2;//该段号段存在 
					}
				}
				return result = 3;//验证成功    
			}
		}
		return result; //参数为空
	}
	/**
	 * 查询 判定是否有道路号在使用
	 * @param 	count（道路日志条数） 
	 *   	   	
	 */
	public Integer getRoadNumLogCount(Map<String, Object> param){
		int result = 1;
		RoadLogModel roadLogCount = roadDao.getRoadLogCount(param);
		if(roadLogCount!=null){
			Integer count = roadLogCount.getCount();
			if(count>0){
				result = 2;//日志中存在多条
			}
		}
		return  result;
	}
	/**
	 * 保存 撒号 重新撒号信息Btn
	 * @param 	String creatType 生成号段的规则  1：单号撒号   2：双号撒号   3：连续撒号 
	 *   	   	startNum 起始号
	 *   		endNum 结束号
	 *   		ignore 忽略号
	 *   		areaId 区域ID
	 * @return Integer
	 * @throws Exception 
	 */
	@TM
	@Aop(name="syncRoadAop",type="after")
	public Integer addRoadNum(Map<String, Object> param) throws Exception{
		String areaId = param.get("areaId").toString();//区域ID
		String roadId = param.get("roadId").toString();//道路ID
		String startNum = param.get("startNum").toString();//起始号
		String endNum = param.get("endNum").toString();//结束号
		String ignore = param.get("ignore").toString();//忽略号 字符串
		String creatNumType = param.get("creatNumType").toString();//规则 1：连续 2：单数 3：双数
		String operator = param.get("operator").toString();//操作员
		String operatorId = param.get("operatorId").toString();
		String operatorOrgCode = param.get("operatorOrgCode").toString();
		String[] ignoreAry = ignore.split(",");//忽略号的数组
		String allNum = "";//所有添加的号
		Integer result = 1 ;
		String type = param.get("type").toString();
		if(type.equals("2")){
			Integer pemisesCount = basePremisesDao.getPemisesCount(param);//重新撒号要判断是否引用
			if(pemisesCount!=0){
				return result = 3;
			}
			roadDao.deleteRoadNum(param);//删除之前存在道路数据
			roadDao.deleteRoadAddr(param);//删除sync 删除全文索引道路数据
			Map<String,Object> logParam = new HashMap<String,Object>();
			logParam.put("roadId", roadId);
			logParam.put("roadLogStatus", 2);
			logParam.put("operator", operator);
			logParam.put("operatorId", operatorId);
			logParam.put("operatorOrgCode", operatorOrgCode);
			logParam.put("operTime", DateUtil.getDateByLong(System.currentTimeMillis()));
			roadDao.updateRoadLog(logParam);
		}
		int startNumInt = Integer.parseInt(startNum);
		int endNumInt = Integer.parseInt(endNum);
		if(creatNumType.equals("3")){  //偶数
			for(int i=startNumInt;i<=endNumInt;i++){
				if(i%2==0){
					allNum+=i+",";
				}
			}
		}else if(creatNumType.equals("2")){       //奇数
			for(int i=startNumInt;i<=endNumInt;i++){
				if(i%2==1){   
					allNum+=i+",";
				}
			}
		}else{//连续
			for(int i=startNumInt;i<=endNumInt;i++){
					allNum+=i+",";
			}
		}
		String[] allNumAry = allNum.split(",");//所有号的数组
		List<String> allNumList = new ArrayList<String>(Arrays.asList(allNumAry));
		List<String> ignoreList = new ArrayList<String>(Arrays.asList(ignoreAry));
		allNumList.removeAll(ignoreList);
		Map<String,Object> validNummMap = new HashMap<String,Object>();//插入有效道路号
		if(allNumList.size()!=0){
			validNummMap.put("activate", allNumList);//移除忽略号的所有该添加的有效号段
			validNummMap.put("status", 1);
			validNummMap.put("areaId", areaId);
			validNummMap.put("roadId", roadId);
			Integer validResult = roadDao.insertRoadNum(validNummMap);
			if(validResult==0){
				throw new Exception();
			}
			validNummMap.put("baseAreaId", areaId);
			BaseAreaModel areaInfo = baseAreaDao.getAreaInfo(validNummMap);
			validNummMap.put("id", roadId);
			RoadModel roadInfo= roadDao.getRoadById(validNummMap);
			String roadName = roadInfo.getRoadName();
			String addrDetailName = areaInfo.getMergerName();
			String[] split = addrDetailName.split(" ");
			String province = split[0];
			String city = split[1];
			String areaName = areaInfo.getName();
			addrDetailName =addrDetailName+" "+roadName+" ";
			validNummMap.put("addrDetail", addrDetailName);
			validNummMap.put("province", province);
			validNummMap.put("city", city);
			validNummMap.put("areaName", areaName);
			validNummMap.put("roadName", roadName);
			roadDao.insertRoadAddr(validNummMap);
		}
/*		if(!ignore.equals("")){ -------------忽略号段不存到数据库中  12/2
			Map<String,Object> invalidityMap = new HashMap<String,Object>();//插入忽略道路号
			invalidityMap.put("activate", ignoreAry);//忽略的道路号
			invalidityMap.put("status", 2);
			invalidityMap.put("areaId", areaId);
			invalidityMap.put("roadId", roadId);
			Integer invalidityResult = roadDao.insertRoadNum(invalidityMap);
				if(invalidityResult==0){
					throw new Exception();
				}
			invalidityMap.put("baseAreaId", areaId);
			BaseAreaModel areaInfo = baseAreaDao.getAreaInfo(invalidityMap);
			invalidityMap.put("id", roadId);
			RoadModel roadInfo= roadDao.getRoadById(invalidityMap);
			String roadName = roadInfo.getRoadName();
			String addrDetailName = areaInfo.getMergerName();
			String[] split = addrDetailName.split(" ");
			String province = split[0];
			String city = split[1];
			String areaName = areaInfo.getName();
			addrDetailName =addrDetailName+" "+roadName+" ";
			invalidityMap.put("addrDetail", addrDetailName);
			invalidityMap.put("province", province);
			invalidityMap.put("city", city);
			invalidityMap.put("areaName", areaName);
			invalidityMap.put("roadName", roadName);
			roadDao.insertRoadAddr(invalidityMap);
		}*/
		Map<String,Object> roadLogMap = new HashMap<String,Object>();//插入道路日志
		roadLogMap.put("status", 1);
		roadLogMap.put("areaId", areaId);
		roadLogMap.put("roadId", roadId);
		roadLogMap.put("startNum", startNum);
		roadLogMap.put("endNum", endNum);
		roadLogMap.put("ignore", ignore);
		roadLogMap.put("creatNumType", creatNumType);
		roadLogMap.put("roadId", roadId);
		roadLogMap.put("operTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		roadLogMap.put("operator",operator);//插入道路日志操作人数据
		roadLogMap.put("operatorId",operatorId);
		roadLogMap.put("operatorOrgCode",operatorOrgCode);
		Integer roadLogResult = roadDao.insertRoadLog(roadLogMap);
			if(roadLogResult==0){
				throw new Exception();
			}
		return result; //成功为1;
	}
	/**
	 * 模糊匹配道路信息 dl
	 * @param 
	 * @return 
	 */
	public List<RoadModel> getRoadListByMatch(Map<String, Object> map){
		return roadDao.getRoadListByMatch(map);
	}
	/**
	 * 根据道路id查询道路-编辑 dl
	 * @param map
	 * @return
	 */
	public RoadModel getRoadManagerById(Map<String, Object> map){
		return roadDao.getRoadById(map);
	}
	/**
	 * 查询道路名称是否存在 dl
	 * @param map
	 * @return
	 */
	public Integer getRoadByNameIs(Map<String, Object> map){
		return roadDao.getRoadByNameIs(map);
	}
}
