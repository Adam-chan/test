package com.golden.ihome.addr.dao.traffic;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.AroundLineModel;
import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * 公共交通线路
 * @author dl
 *
 */
@Repository(value="aroundLineDao")
public class AroundLineDao extends IBaseDao{

	public Integer insertLine(Map<String, Object> map) {
		return this.excutor.insert("aroundLine.insertLine", map);
	}

	public List<AroundLineModel> getLineById(Map<String, Object> map) {
		return this.excutor.queryForList("aroundLine.getLineById", map);
	}

	public Integer deleteLineById(Map<String, Object> map) {
		return this.excutor.delete("aroundLine.deleteLineById", map);
	}

	public Integer updateLineById(Map<String, Object> map) {
		return this.excutor.update("aroundLine.updateLineById", map);
	}

	public Integer deleteLines(Map<String, Object> map) {
		return this.excutor.delete("aroundLine.deleteLines", map);
	}

	public List<AroundLineModel> getLinesBySiteId(Map<String, Object> map) {
		return this.excutor.queryForList("aroundLine.getLinesBySiteId", map);
	}

	public List<AroundLineModel> getLineList(Map<String,Object> map) {
		return this.excutor.queryForList("aroundLine.getLineList",map);
	}

	public PagerResult<AroundLineModel> getLineListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("aroundLine.getLineListForPage",map);
	}

	public List<AroundLineModel> getLineListByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("aroundLine.getLineListByMatch", map);
	}

	public List<AroundSiteModel> getLineByNameIs(Map<String, Object> map) {
		return this.excutor.queryForList("aroundLine.getLineByNameIs", map);
	}
	
	public List<AroundLineModel> getLineByName(Map<String, Object> map) {
		return this.excutor.queryForList("aroundLine.getLineByName", map);
	}

	public List<AroundLineModel> getLineByLineName(Map<String, Object> map) {
		return this.excutor.queryForList("aroundLine.getLineByLineName", map);
	}

}
