package com.golden.ihome.addr.service.premisesParrLook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.premisesManage.BasePremisesDao;
import com.golden.ihome.addr.dao.premisesParrLook.PremisesParrLookDao;
import com.golden.ihome.addr.dao.traffic.AroundSiteDao;
import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;

@Service("premisesParrLook/premisesParrLookService")
public class PremisesParrLookService implements IBaseHandler{

	@Autowired
	private BasePremisesDao basePremisesDao;
	@Autowired
	private AroundSiteDao aroundSiteDao;
	@Autowired
	private PremisesParrLookDao premisesParrLookDao;
	/**
	 * 约带看分页列表
	 * @param map
	 * @return
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return premisesParrLookDao.getParrLookPage(param);
	}
	/**
	 * 逻辑删除约带看记录
	 * @param map
	 * @return
	 */
	@TM
	public Integer updateParrLook(Map<String, Object> map){
		map.put("status", 2);
		return premisesParrLookDao.updateParrLook(map);
	}
	
	/**
	 * 模糊匹配 楼盘名字
	 * @param    matchStr 模糊教育设施名字
	 * @return List<EduFacilityModel>
	 */
	public List<BasePremisesModel> geteduNameByMatch(Map<String, Object> param){
		return basePremisesDao.getPemisesInfoList(param);
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
	public Integer addPremises(Map<String, Object> map) {
		return basePremisesDao.addPremises(map);
	}

	/**
	 * 查看楼盘
	 */
	public BasePremisesModel queryPremises(Map<String, Object> map) {
		return basePremisesDao.queryPremises(map);
	}

	/**
	 * 修改楼盘
	 */
	@TM
	public Integer updatePremises(Map<String, Object> map) {
		return basePremisesDao.addPremises(map);
	}

	/**
	 * 删除楼盘
	 */
	@TM
	public Integer deletePremises(Map<String, Object> map) {
		return basePremisesDao.deletePremises(map);
	}

	/**
	 * 模糊匹配详细地址
	 */
	public List<Map<String, Object>> getAddrDetail(Map<String, Object> map){
		return basePremisesDao.getAddrDetail(map);
	}

	/**
	 * 楼盘管理-信息展示
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
			if(!busSiteIds.equals("") && busSiteIds!=null){
				busParamsMap.put("siteIds", busSiteIds);
				busParamsMap.put("trafficType", 1);
				List<AroundSiteModel> busList = aroundSiteDao.getSiteLineBySiteIds(busParamsMap);
				//公交站点字符串拼接
				StringBuffer busResult = new StringBuffer();
				for (int i = 0; i < busList.size(); i++) {
					String lines = "";
					if(busList.get(i).getLines()!=null){
						lines = busList.get(i).getLines();
					}
					busResult.append("  ").append(busList.get(i).getSiteName()).append(":").append(lines);
				}
				list.get(0).setBusStation(busResult.deleteCharAt(0).toString());
			}
			//地铁站点list
			String subwaySiteIds = list.get(0).getSubwayStation();
			if(!subwaySiteIds.equals("") && subwaySiteIds!=null){
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
				list.get(0).setSubwayStation(subwayResult.deleteCharAt(0).toString());
			}
			//教育设施(待添加)
			
			premises = list.get(0);
		}
		return premises;
	}
	
}
