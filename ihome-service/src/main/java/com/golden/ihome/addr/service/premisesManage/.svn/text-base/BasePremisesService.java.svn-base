package com.golden.ihome.addr.service.premisesManage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.buildingGroup.BuildingGroupDao;
import com.golden.ihome.addr.dao.ctxdll.RoomAddrDao;
import com.golden.ihome.addr.dao.education.EduDao;
import com.golden.ihome.addr.dao.premisesManage.BasePremisesDao;
import com.golden.ihome.addr.dao.traffic.AroundSiteDao;
import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

@Service("basePremises/basePremisesService")
public class BasePremisesService implements IBaseHandler{

	@Autowired
	private BasePremisesDao basePremisesDao;
	@Autowired
	private BuildingGroupDao buildingGroupDao;
	@Autowired
	private AroundSiteDao aroundSiteDao;
	@Autowired
	private EduDao eduDao;
	@Autowired
	private RoomAddrDao roomAddrDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 楼盘列表分页
	 */
	public PagerResult<BasePremisesModel> getPremisesPage(Map<String, Object> map) {
		return basePremisesDao.getPremisesPage(map);
	}

	/**
	 * 隐藏/显示
	 */
	@TM
	public Integer updateHidden(Map<String, Object> map) {
		return basePremisesDao.updateHidden(map);
	}

	/**
	 * 买卖封盘/买卖解封
	 */
	@TM
	public Integer updateSaleSeal(Map<String, Object> map) {
		return basePremisesDao.updateSaleSeal(map);
	}

	/**
	 * 租赁封盘/租赁解封
	 */
	@TM
	public Integer updateLeaseSeal(Map<String, Object> map) {
		return basePremisesDao.updateLeaseSeal(map);
	}

	/**
	 * 新增楼盘
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer addPremises(Map<String, Object> map) {
		basePremisesDao.addPremises(map);
		if(map.get("buildingGroup") != null && !"".equals(map.get("buildingGroup"))) {
			String[] buildingGroups = map.get("buildingGroup").toString().split("、");
			map.put("createTime", new Date());
			map.put("updateTime", new Date());
			for(int i = 0; i < buildingGroups.length; i++) {
				map.put("groupName", buildingGroups[i]);
				buildingGroupDao.insertSelective(map);
			}
		}
		return Integer.parseInt(map.get("premisesId").toString());
	}

	/**
	 * 查看楼盘
	 */
	public BasePremisesModel queryPremises(Map<String, Object> map) {
		BasePremisesModel basePremisesModel = basePremisesDao.queryPremises(map);
		if(basePremisesModel.getBuildingGroup() != null) {
			basePremisesModel.setBuildingGroup(basePremisesModel.getBuildingGroup().replaceAll(",", "、"));
		}
		return basePremisesModel;
	}

	/**
	 * 修改楼盘
	 */
	@TM
	@Aop(name="syncHouseAop",type="around")
	public Integer updatePremises(Map<String, Object> map) {
		String uniteId = map.get("roadId").toString();
		String premisesId = map.get("premisesId").toString();
		String premisesName = map.get("name").toString();
		BasePremisesModel basePremisesModel = basePremisesDao.queryPremisesForUpdate(map);
		//如果变更了道路。并且楼盘下已有房间，则需要更新道路房间地址。
		if((!basePremisesModel.getName().equals(premisesName) || !basePremisesModel.getRoadId().equals(uniteId)) && basePremisesModel.getTotalHouseholds() > 0){
			Map<String,Object> par = new HashMap<String,Object>();
			par.put("uniteId", uniteId);
			par = roomAddrDao.getRoadNumDetail(par);
			par.put("premisesId", premisesId);
			par.put("premisesName", premisesName);
			roomAddrDao.updatePeremisesRoadNum(par);
			//标识更新过楼盘房间的全文检索库
			map.put("isUpdateHouseAddr", "111");
		}
		if(!basePremisesModel.getName().equals(premisesName)){
			
		}
		return basePremisesDao.updatePremises(map);
	}

	/**
	 * 删除楼盘
	 */
	@TM
	public Integer deletePremises(Map<String, Object> map) {
		if(basePremisesDao.getHousingResources(map) != 0) {
			return 0;
		}
		return basePremisesDao.deletePremises(map);
	}

	/**
	 * 模糊匹配详细地址
	 */
	public List<Map<String, Object>> getAddrDetail(Map<String, Object> map){
		return basePremisesDao.getAddrDetail(map);
	}

	/**
	 * 模糊匹配站点线路
	 */
	public List<Map<String, Object>> getSiteLineListByMatch(Map<String, Object> map){
		return basePremisesDao.getSiteLineListByMatch(map);
	}

	/**
	 * 模糊匹配教育设施
	 */
	public List<Map<String, Object>> getEduListByMatch(Map<String, Object> map){
		return basePremisesDao.getEduListByMatch(map);
	}

	/**
	 * 提交审核
	 */
	@TM
	public Integer auditingPremises(Map<String, Object> map) {
		return basePremisesDao.auditingPremises(map);
	}

	/**
	 * 楼盘管理-信息展示 dl
	 * @param map
	 * @return
	 */
	public BasePremisesModel getPemisesInfoById(Map<String, Object> map){
		BasePremisesModel premises = new BasePremisesModel();
		List<BasePremisesModel> list = basePremisesDao.getPemisesInfoById(map);
		Map<String, Object> busParamsMap = new HashMap<String, Object>();
		Map<String, Object> subwayParamsMap = new HashMap<String, Object>();
		if(!list.isEmpty() && list.get(0)!=null){
			//公交站点list
			String busSiteIds = list.get(0).getBusStation();
			if(busSiteIds!=null && !busSiteIds.equals("")){
				busParamsMap.put("siteIds", busSiteIds);
				busParamsMap.put("trafficType", 1);
				List<AroundSiteModel> busList = aroundSiteDao.getSiteLineBySiteIds(busParamsMap);
				//公交站点字符串拼接
				if(!busList.isEmpty() && busList.get(0)!=null){
					StringBuffer busResult = new StringBuffer();
					for (int i = 0; i < busList.size(); i++) {
						String lines = "";
						if(busList.get(i).getLines()!=null){
							lines = busList.get(i).getLines();
						}
						busResult.append("  ").append(busList.get(i).getSiteName()).append(":").append(lines);
					}
					if(busResult!=null){
						list.get(0).setBusStation(busResult.deleteCharAt(0).toString());
					}
				}
			}
			//地铁站点list
			String subwaySiteIds = list.get(0).getSubwayStation();
			if(subwaySiteIds!=null && !subwaySiteIds.equals("")){
				subwayParamsMap.put("siteIds", subwaySiteIds);
				subwayParamsMap.put("trafficType", 2);
				List<AroundSiteModel> subwayList = aroundSiteDao.getSiteLineBySiteIds(subwayParamsMap);
				//地铁站点字符串拼接
				StringBuffer subwayResult = new StringBuffer();
				for (int i = 0; i < subwayList.size(); i++) {
					String lines = "";
					if(subwayList.get(i).getLines()!=null){
						lines = subwayList.get(i).getLines();
					}
					subwayResult.append("  ").append(subwayList.get(i).getSiteName()).append(":").append(lines);
				}
				if(subwayResult != null){
					list.get(0).setSubwayStation(subwayResult.deleteCharAt(0).toString());
				}
			}
			//教育设施(待添加)
			String eduIds = list.get(0).getEduIds();
			if(eduIds!=null && !eduIds.equals("")){
				String str = (String) eduDao.getEduNameConcat(eduIds);
				list.get(0).setEduIds(str);
			}
			premises = list.get(0);
		}
		return premises;
	}
	/**
	 * 查询楼盘图片 dl
	 * @param map
	 * @return
	 */
	public List<String> getPemisesImages(Map<String, Object> map) {
		return basePremisesDao.getPemisesImages(map);
	}
	
}
