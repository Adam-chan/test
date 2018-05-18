package com.golden.ihome.addr.dao.traffic;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.AroundSiteLineModel;
import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * 公共交通站点
 * @author dl
 *
 */
@Repository(value="aroundSiteDao")
public class AroundSiteDao extends IBaseDao{

	public PagerResult<AroundSiteModel> getSiteListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("aroundSite.getSiteListForPage", map);
	}

	public List<AroundSiteModel> getSiteListByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("aroundSite.getSiteListByMatch", map);
	}

	public Integer insertSite(AroundSiteModel site) {
		return this.excutor.insert("aroundSite.insertSite", site);
	}
	
	public Integer updateSite(Map<String, Object> map) {
		return this.excutor.update("aroundSite.updateSiteById", map);
	}

	public Integer deleteSiteById(Map<String, Object> map) {
		return this.excutor.delete("aroundSite.deleteSiteById", map);
	}

	public Object getSiteByNameIs(Map<String,Object> map) {
		return this.excutor.queryForObject("aroundSite.getSiteByNameIs", map);
	}

	public List<AroundSiteModel> getSiteById(Map<String, Object> map) {
		return this.excutor.queryForList("aroundSite.getSiteById", map);
	}

	public Integer deleteSites(Map<String, Object> map) {
		return this.excutor.delete("aroundSite.deleteSites", map);
	}

	public Integer insertSiteLineContact(Map<String, Object> map) {
		return this.excutor.insert("aroundSite.insertSiteLineContact", map);
	}

	public List<AroundSiteModel> getSiteList() {
		return this.excutor.queryForList("aroundSite.getSiteList");
	}
	
	public List<AroundSiteLineModel> getSiteLineListBySiteId(Map<String,Object> map) {
		return this.excutor.queryForList("aroundSite.getSiteLineListBySiteId", map);
	}
	
	public Integer deleteSiteLines(Map<String, Object> map) {
		return this.excutor.delete("aroundSite.deleteSiteLines", map);
	}
	
	public List<AroundSiteModel> getSiteLineBySiteIds(Map<String,Object> map) {
		return this.excutor.queryForList("aroundSite.getSiteLineBySiteIds", map);
	}
}

