package com.golden.ihome.addr.dao.premisesExamine;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="premisesExamineDao")
public class PremisesExamineDao extends IBaseDao{

	/**
	 * 楼盘列表分页
	 */
	public PagerResult<BasePremisesModel> getPremisesExaminePage(Map<String, Object> map) {
		return this.excutor.queryListPage("premisesExamine.getPremisesExaminePage", map);
	}
	
	/**
	 * 模糊匹配楼盘
	 * @param  matchStr : 名称
	 * @return List<BasePremisesModel>
	 */
	public List<BasePremisesModel> getPremisesListByMatch(Map<String, Object> map){
		return this.excutor.queryForList("premisesExamine.getPremisesByMatch", map);
	}
	
	/**
	 * 审核
	 * @param map
	 * @return
	 */
	public Integer examine(Map<String, Object> map){
		return this.excutor.update("premisesExamine.examine", map);
	}	
	
	/**
	 * 查询申请人List
	 * @param map
	 * @return
	 */
	public List<BasePremisesModel> getOperateUserList(Map<String, Object> map){
		return this.excutor.queryForList("premisesExamine.getOperateUserList", map);
	}
	
	/**
	 * 查询审核人List
	 * @param map
	 * @return
	 */
	public List<BasePremisesModel> getExamineUserList(Map<String, Object> map){
		return this.excutor.queryForList("premisesExamine.getExamineUserList", map);
	}

}
 