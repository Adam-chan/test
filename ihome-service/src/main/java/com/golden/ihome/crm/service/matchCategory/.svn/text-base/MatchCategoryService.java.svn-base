package com.golden.ihome.crm.service.matchCategory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.matchCategory.MatchCategoryDao;
import com.golden.ihome.crm.model.MatchCategoryModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

@Service("matchCategory/matchCategoryService")
public class MatchCategoryService implements IBaseHandler{
	
	@Autowired
	private MatchCategoryDao matchCategoryDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 获取赛区类别列表
	 */
	public PagerResult<MatchCategoryModel> getMatchCategoryPage(Map<String, Object> map){
		return matchCategoryDao.getMatchCategoryPage(map);
	}
	
	/**
	 * 初始化修改数据
	 */
	public MatchCategoryModel initUpdateData(Map<String, Object> map){
		return matchCategoryDao.initUpdateData(map);
	}
	
	/**
	 * 插入赛事类别
	 */
	public Integer addMatchCategory(Map<String, Object> map){
		int result = 2;
		if(map.get("name") == "" || map.get("name") == null){
			return result;
		}else if(map.get("status") == "" || map.get("status") == null){
			return result;
		}
		return matchCategoryDao.insertMatchCategory(map);
	}
	
	/**
	 * 修改赛事类别
	 */
	public Integer updateMatchCategory(Map<String, Object> map){
		return matchCategoryDao.updateMatchCategory(map);
	}
	
	/**
	 * 删除赛事类别
	 */
	public Integer deleteMatchCategory(Map<String, Object> map){
		return matchCategoryDao.deleteMatchCategory(map);
	}
}