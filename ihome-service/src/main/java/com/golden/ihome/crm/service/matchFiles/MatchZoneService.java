package com.golden.ihome.crm.service.matchFiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.matchFiles.MatchZoneDao;
import com.golden.ihome.crm.model.MatchCategoryModel;
import com.golden.ihome.crm.model.MatchZoneModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
@SuppressWarnings("unchecked")
@Service("matchZone/MatchZoneService")
public class MatchZoneService implements IBaseHandler{
	
	@Autowired
	private MatchZoneDao matchZoneDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 分页列表
	 */
	public PagerResult<MatchZoneModel> getMatchZonePage(Map<String, Object> map){
		return matchZoneDao.getMatchZonePage(map);
	}
	
	/**
	 * 类别名称下拉选项
	 */
	public List<MatchCategoryModel> getCategoryName(Map<String, Object> map){
		return matchZoneDao.getCategoryName(map);
	}
	
	/**
	 * 获取新增赛区树形菜单判断条件参赛层级字段
	 */
	public MatchCategoryModel getCategoryLayerByName(Map<String, Object> map){
		return matchZoneDao.getCategoryLayerByName(map);
	}
	
	/**
	 * 新增赛区(同时插入 match_zone match_zone_team 两个表)
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer insertMatchZone(Map<String, Object> map){
		Map<String, Object> insertMap = new HashMap<String, Object>();
		Integer type;
		String insertZoneName = map.get("matchZoneName").toString();
		String businessTeams = map.get("businessTeams").toString();
		String leaseTeams = map.get("leaseTeams").toString();
		String[] businessTeamsList = null;
		String[] leaseTeamsList = null;
		if(businessTeams!= "" && businessTeams != null && businessTeams.length() !=0){
			businessTeamsList = businessTeams.split(","); //买卖战队数组
		}
		if(leaseTeams!= "" && leaseTeams != null && leaseTeams.length() !=0){
			leaseTeamsList = leaseTeams.split(",");//租赁站队数组
		}
		//teamMap.put("1", businessTeamsList); //买卖战队
		//teamMap.put("2", leaseTeamsList); //租赁战队
		insertMap.put("name", insertZoneName);
		insertMap.put("categoryId", map.get("categoryId"));
		insertMap.put("grade", map.get("grade"));
		insertMap.put("bussunessType", map.get("bussunessType"));
		insertMap.put("remark", map.get("remarks"));
		//插入match_zone
		type = matchZoneDao.insertIntoMatchZone(insertMap);
		if(type != 0){
			String latestId = matchZoneDao.selectMatchZoneId().get(0).toString();
			insertMap.clear();
			//赛区档案ID  业务类型(1-买卖 2-租赁) 战队ID 战队名称
			if(businessTeams!= "" && businessTeams != null && businessTeams.length() !=0){
				for (int i = 0; i < businessTeamsList.length; i++) {
					insertMap.put("matchZoneId", latestId);
					insertMap.put("bussinessType", 1);
					insertMap.put("id",i);
					insertMap.put("name", businessTeamsList[i]);
					//插入match_zone_team
					type = matchZoneDao.insertIntoMatchZoneTeam(insertMap);
					if(type == 0){
						return type;
					}
					insertMap.clear();
				}
			}
			if(leaseTeams!= "" && leaseTeams != null && leaseTeams.length() !=0){
				for (int j = 0; j < leaseTeamsList.length; j++) {
					insertMap.put("matchZoneId", latestId);
					insertMap.put("bussinessType", 2);
					insertMap.put("id",j);
					insertMap.put("name", leaseTeamsList[j]);
					//插入match_zone_team
					type = matchZoneDao.insertIntoMatchZoneTeam(insertMap);
					if(type == 0){
						return type;
					}
					insertMap.clear();
				}
			}
		}
		return type;
	}
	
	public MatchZoneModel getUpdateMatchZone(Map<String, Object> map){
		return matchZoneDao.getUpdateMatchZone(map);
	}
	
	/**
	 * 修改赛区(同时修改 match_zone match_zone_team 两个表)
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer updateMatchZone(Map<String, Object> map){
		Map<String, Object> insertMap = new HashMap<String, Object>();
		Integer type;
		String insertZoneName = map.get("matchZoneName").toString();
		String businessTeams = map.get("businessTeams").toString();
		String leaseTeams = map.get("leaseTeams").toString();
		String[] businessTeamsList = null;
		String[] leaseTeamsList = null;
		if(businessTeams!= "" && businessTeams != null && businessTeams.length() !=0){
			businessTeamsList = businessTeams.split(","); //买卖战队数组
		}
		if(leaseTeams!= "" && leaseTeams != null && leaseTeams.length() !=0){
			leaseTeamsList = leaseTeams.split(",");//租赁站队数组
		}
		insertMap.put("name", insertZoneName);
		insertMap.put("categoryId", map.get("categoryId"));
		insertMap.put("grade", map.get("grade"));
		insertMap.put("bussunessType", map.get("bussunessType"));
		insertMap.put("remark", map.get("remarks"));
		insertMap.put("id", map.get("id"));
		//插入match_zone
		type = matchZoneDao.updateMatchZone(insertMap);
		if(type != 0){
			insertMap.clear();
			insertMap.put("id", map.get("id"));
			type = matchZoneDao.deleteMatchZoneTeam(insertMap);
			if(type != 0){
				insertMap.clear();
				//赛区档案ID  业务类型(1-买卖 2-租赁) 战队ID 战队名称
				if(businessTeams!= "" && businessTeams != null && businessTeams.length() !=0){
					for (int i = 0; i < businessTeamsList.length; i++) {
						insertMap.put("matchZoneId", map.get("id"));
						insertMap.put("bussinessType", 1);
						insertMap.put("id",i);
						insertMap.put("name", businessTeamsList[i]);
						//插入match_zone_team
						type = matchZoneDao.insertIntoMatchZoneTeam(insertMap);
						if(type == 0){
							return type;
						}
						insertMap.clear();
					}
				}
				if(leaseTeams!= "" && leaseTeams != null && leaseTeams.length() !=0){
					for (int j = 0; j < leaseTeamsList.length; j++) {
						insertMap.put("matchZoneId", map.get("id"));
						insertMap.put("bussinessType", 2);
						insertMap.put("id",j);
						insertMap.put("name", leaseTeamsList[j]);
						//插入match_zone_team
						type = matchZoneDao.insertIntoMatchZoneTeam(insertMap);
						if(type == 0){
							return type;
						}
						insertMap.clear();
					}
				}
			}
		}
		return type;
	}
	
	/**
	 * 删除赛区
	 */
	public Integer deleteMatchZone(Map<String, Object> map){
		int type = 0;
		type = matchZoneDao.deleteMatchZone(map);
		if(type != 0){
			type = matchZoneDao.deleteMatchZoneTeam(map);
		}
		return type;
	}
	
	/**
	 * 获取组织结构
	 */
	public List<Map<String, Object>> getBusinessTeam(Map<String, Object> map){
		return (List<Map<String, Object>>) map.get("key");
	}
}
