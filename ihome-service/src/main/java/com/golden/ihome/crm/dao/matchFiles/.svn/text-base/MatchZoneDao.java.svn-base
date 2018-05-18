package com.golden.ihome.crm.dao.matchFiles;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.MatchCategoryModel;
import com.golden.ihome.crm.model.MatchZoneModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository("matchZoneDao")
public class MatchZoneDao extends IBaseDao {
	
	/**
	 * 分页列表
	 */
	public PagerResult<MatchZoneModel> getMatchZonePage(Map<String, Object> map){
		return this.excutor.queryListPage("matchZone.getMatchZonePage", map);
	}
	
	/**
	 * 获取赛事类别下拉选项
	 */
	public List<MatchCategoryModel> getCategoryName(Map<String, Object> map){
		return this.excutor.queryForList("matchZone.getCategoryName", map);
	}
	
	/**
	 * 获取新增赛区树形菜单判断条件参赛层级字段
	 */
	public MatchCategoryModel getCategoryLayerByName(Map<String, Object> map){
		return this.excutor.queryForObject("matchZone.getCategoryLayerByName", map);
	}
	
	/**
	 * 新建赛区 插入match_zone
	 */
	public Integer insertIntoMatchZone(Map<String, Object> map){
		return this.excutor.insert("matchZone.insertIntoMatchZone", map);
	}
	
	/**
	 * 新建赛区 插入match_zone_team
	 */
	public Integer insertIntoMatchZoneTeam(Map<String, Object> map){
		return this.excutor.insert("matchZone.insertIntoMatchZoneTeam", map);
	}
	
	/**
	 * 查询新建赛区时插入到match_zone中的赛区id
	 */
	public List<String> selectMatchZoneId(){
		return this.excutor.queryForList("matchZone.selectMatchZoneId");
	}
	
	/**
	 * 获取修改页面数据
	 */
	public MatchZoneModel getUpdateMatchZone(Map<String, Object> map){
		return this.excutor.queryForObject("matchZone.getUpdateMatchZone", map);
	}
	
	/**
	 * 修改match_zone
	 */
	public Integer updateMatchZone(Map<String, Object> map){
		return this.excutor.update("matchZone.updateMatchZone", map);
	}
	
	/**
	 * 修改match_zone_team
	 */
	public Integer updateMatchZoneTeam(Map<String, Object> map){
		return this.excutor.update("matchZone.updateMatchZoneTeam", map);
	}
	
	/**
	 * 删除match_zone
	 */
	public Integer deleteMatchZone(Map<String, Object> map){
		return this.excutor.delete("matchZone.deleteMatchZone", map);
	}
	
	/**
	 * 删除match_zone_team
	 */
	public Integer deleteMatchZoneTeam(Map<String, Object> map){
		return this.excutor.delete("matchZone.deleteMatchZoneTeam", map);
	}

}
