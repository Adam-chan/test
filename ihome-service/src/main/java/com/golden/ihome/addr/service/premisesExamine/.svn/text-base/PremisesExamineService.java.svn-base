package com.golden.ihome.addr.service.premisesExamine;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.premisesExamine.PremisesExamineDao;
import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

@Service("premisesExamine/premisesExamineService")
public class PremisesExamineService implements IBaseHandler{

	@Autowired
	private PremisesExamineDao premisesExamineDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 楼盘列表分页
	 */
	public PagerResult<BasePremisesModel> getPremisesExaminePage(Map<String, Object> map) {
		return premisesExamineDao.getPremisesExaminePage(map);
	}

	/**
	 * 模糊匹配楼盘
	 * @param  matchStr : 名称
	 * @return List<BasePremisesModel>
	 */
	public List<BasePremisesModel> getPremisesListByMatch(Map<String, Object> param){
		return premisesExamineDao.getPremisesListByMatch(param);
	}
	
	/**
	 * 审核
	 * @param map
	 * @return
	 */
	public Integer examine(Map<String, Object> map){
		return premisesExamineDao.examine(map);
	}
	
	
	/**
	 * 查询申请人List
	 * @param map
	 * @return
	 */
	public List<BasePremisesModel> getOperateUserList(Map<String, Object> map){
		return premisesExamineDao.getOperateUserList(map);
	}
	
	/**
	 * 查询审核人List
	 * @param map
	 * @return
	 */
	public List<BasePremisesModel> getExamineUserList(Map<String, Object> map){
		return premisesExamineDao.getExamineUserList(map);
	}

}
