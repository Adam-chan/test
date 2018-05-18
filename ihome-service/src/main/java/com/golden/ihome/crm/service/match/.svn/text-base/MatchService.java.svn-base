package com.golden.ihome.crm.service.match;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.match.MatchDao;
import com.golden.ihome.crm.model.MatchModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

@Service("match/matchService")
public class MatchService  implements IBaseHandler{
	
	@Autowired
	private MatchDao matchDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 赛事发布分页查询
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public PagerResult<MatchModel> getMatchJQPage(Map<String, Object> param){
		param.put("currentPage", 1);
		param.put("rowCount", 30);
		PagerResult<MatchModel> result = matchDao.getMatchJQPage(param);
		return result;
	}
	
	/**
	 * 赛事发布删除数据
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public Integer deleteMatch(Map<String, Object> param){
		Integer resultNum = matchDao.deleteMatch(param);
		return resultNum;
	}
	
	/**
	 * 赛事发布 获取赛区
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public List<Object> getMatchZone(Map<String, Object> param){
		List<MatchModel> result = matchDao.getMatchZone(param);
		List<MatchModel> result1 = matchDao.getTeamName(param);
		List<Object> list = new ArrayList<>();
		list.add(result);
		list.add(result1);
		return list;
	}
	
	
	/**
	 * 赛事发布 获取赛事
	 * 
	 * @param param
	 * @return PagerResult
	 */
	public List<MatchModel> selectByPrimaryKey(Map<String, Object> param){
		List<MatchModel> result = matchDao.selectByPrimaryKey(param);
		return result;
	}
	
	/**
	 * 赛事发布新增数据
	 * 
	 * @param param
	 * @return PagerResult
	 * @throws  Exception 
	 */
	public Integer addMatch(Map<String, Object> param) throws Exception{
		// 新增赛事数据 开始
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		param.put("startTime",  dateFormat.parse(param.get("startTime").toString()));
		param.put("endTime",  dateFormat.parse(param.get("endTime").toString()));
		Integer resultMatch = matchDao.addMatch(param);
		// 新增赛事数据 结束
		
		// 新增赛区目标 开始
		for (Entry<String, Object> entry : param.entrySet()) {
			String key = entry.getKey();
			String[] keySplit = key.split("_");
			if(keySplit.length == 3 && keySplit[1].equals("Deal")){
				Map<String, Object> params = new HashMap<>();
				params.put("matchId", param.get("matchId"));
				params.put("deal", param.get(key));
				params.put("rent", param.get("matchTarget_Rent_" + keySplit[2]));
				params.put("matchZoneId", keySplit[2]);
				matchDao.insertMatchTarget(params);
			}
		}
		// 新增赛区目标 结束
		return resultMatch;
	}
	
	/**
	 * 赛事发布修改数据
	 * 
	 * @param param
	 * @return PagerResult
	 * @throws  Exception 
	 */
	public Integer editMatch(Map<String, Object> param) throws Exception{
		// 修改赛事数据 开始
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		param.put("startTime",  dateFormat.parse(param.get("startTime").toString()));
		param.put("endTime",  dateFormat.parse(param.get("endTime").toString()));
		param.put("id",  Integer.parseInt(param.get("id").toString()));
		param.put("categoryId",  Integer.parseInt(param.get("categoryId").toString()));
		Integer resultMatch = matchDao.editMatch(param);
		// 修改赛事数据 结束
		
		// 修改赛区目标 开始
		for (Entry<String, Object> entry : param.entrySet()) {
			String key = entry.getKey();
			String[] keySplit = key.split("_");
			if(keySplit.length == 3 && keySplit[1].equals("Deal")){
				Map<String, Object> params = new HashMap<>();
				params.put("matchId", param.get("id"));
				params.put("deal", param.get(key));
				params.put("rent", param.get("matchTarget_Rent_" + keySplit[2]));
				params.put("matchZoneId", keySplit[2]);
				matchDao.editMatchTarget(params);
			}
		}
		// 修改赛区目标 结束
		return resultMatch;
	}
	
	/**
	 * 赛事 发布 
	 * 
	 * @return PagerResult
	 * @throws Exception 
	 */
	public Integer publishMatch(Map<String, Object> param) throws Exception{
		param.put("publishTime",  new Date());
		param.put("publisher",  "admin");
		Integer result = matchDao.publishMatch(param);
		return result;
	}
	
	/**
	 * 赛事发布 下拉列表
	 * 
	 * @return PagerResult
	 */
	public Map<String, Object> getSelectList(Map<String, Object> param){
		Map<String, Object> map = new HashMap<>();
		// 赛事发布 赛事类别下拉列表
		List<MatchModel> result = matchDao.getSelectCategory();
		map.put("categoryList", result);
		return map;
	}
}
