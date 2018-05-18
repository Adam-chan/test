package com.golden.ihome.crm.dao.matchCategory;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.MatchCategoryModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository("matchCategoryDao")
public class MatchCategoryDao extends IBaseDao {
	
	/**
	 * 获取赛事类别列表
	 */
	public PagerResult<MatchCategoryModel> getMatchCategoryPage(Map<String, Object> map){
		return this.excutor.queryListPage("matchCategory.getMatchCategoryPage", map);
	}
	
	/**
	 * 初始化修改数据
	 */
	public MatchCategoryModel initUpdateData(Map<String, Object> map){
		return this.excutor.queryForObject("matchCategory.selectById", map);
	}
	
	/**
	 * 新增赛事类别
	 */
	public Integer insertMatchCategory(Map<String, Object> map){
		return this.excutor.insert("matchCategory.insertMatchCategory", map);
	}
	
	/**
	 * 修改赛事类别
	 */
	public Integer updateMatchCategory(Map<String, Object> map){
		return this.excutor.update("matchCategory.updateMatchCategory", map);
	}
	
	/**
	 * 删除赛事类别
	 */
	public Integer deleteMatchCategory(Map<String, Object> map){
		return this.excutor.delete("matchCategory.deleteMatchCategory", map);
	}

}
