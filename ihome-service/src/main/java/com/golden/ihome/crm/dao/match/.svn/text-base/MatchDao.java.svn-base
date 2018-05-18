package com.golden.ihome.crm.dao.match;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.MatchModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author guoweichen 类名称：赛事发布Dao 类描述：赛事发布 时间：2016-11-01
 *
 */
@Repository(value = "matchDao")
public class MatchDao extends IBaseDao {
	
	/**
	 * 赛事发布分页查询
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public PagerResult<MatchModel> getMatchJQPage(Map<String, Object> param) {
		PagerResult<MatchModel> model = this.excutor.queryListPage("match.getMatchJQPage", param);
		return model;
	}
	
	/**
	 * 赛事发布删除
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public Integer deleteMatch(Map<String, Object> param) {
		Integer resultNum = this.excutor.delete("match.deleteMatch", param);
		return resultNum;
	}
	
	/**
	 * 赛事发布 获取赛区
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public List<MatchModel> getMatchZone(Map<String, Object> param) {
		List<MatchModel> result = this.excutor.queryForList("match.getMatchZone", param);
		return result;
	}
	
	/**
	 * 赛事发布 获取赛区
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public List<MatchModel> getTeamName(Map<String, Object> param) {
		List<MatchModel> result = this.excutor.queryForList("match.getTeamName", param);
		return result;
	}
	
	/**
	 * 赛事发布新增
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public Integer addMatch(Map<String, Object> param) {
		Integer resultNum = this.excutor.insert("match.insert", param);
		return resultNum;
	}
	
	/**
	 * 赛事发布  修改基本信息
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public Integer editMatch(Map<String, Object> param) {
		Integer resultNum = this.excutor.update("match.updateByPrimaryKey", param);
		return resultNum;
	}
	
	/**
	 * 赛事 查询一条赛事
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public List<MatchModel> selectByPrimaryKey(Map<String, Object> param) {
		List<MatchModel> result = this.excutor.queryForList("match.selectByPrimaryKey", param);
		return result;
	}
	
	/**
	 * 赛事发布新增 赛区目标
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public Integer insertMatchTarget(Map<String, Object> param) {
		Integer result = this.excutor.insert("match.insertMatchTarget", param);
		return result;
	}
	
	/**
	 * 赛事 发布
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public Integer publishMatch(Map<String, Object> param) {
		Integer result = this.excutor.update("match.publishMatch", param);
		return result;
	}
	
	/**
	 * 赛事发布修改 赛区目标
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public Integer editMatchTarget(Map<String, Object> param) {
		Integer result = this.excutor.update("match.editMatchTarget", param);
		return result;
	}
	
	/**
	 * 赛事发布 赛事类别下拉列表
	 * 
	 * @return Integer
	 */
	public List<MatchModel> getSelectCategory() {
		List<MatchModel> result =excutor.queryForList("match.getSelectCategory", null);
		return result;
	}
}
