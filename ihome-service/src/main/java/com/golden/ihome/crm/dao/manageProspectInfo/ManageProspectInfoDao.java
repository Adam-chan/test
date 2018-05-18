package com.golden.ihome.crm.dao.manageProspectInfo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.ManageProspectInfoModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author lza
 * 类名称：实勘审核dao
 * 类描述：实勘审核管理dao
 * 时间：2016-12-02
 */
@Repository(value="manageProspectInfoDao")
public class ManageProspectInfoDao extends IBaseDao{
	
	/**
	 * 分页列表查询
	 * @param map{}
	 * @return PagerResult<ManageProspectInfoModel>
	 */
	public  PagerResult<ManageProspectInfoModel> getManageProspectInfoPage(Map<String, Object> map) {
		return this.excutor.queryListPage("manageProspectInfo.getManageProspectInfoPage", map);
	}
	
	/**
	 * 模糊查询
	 * @param map{}
	 * @return PagerResult<ManageProspectInfoModel>
	 */
	public  List<ManageProspectInfoModel> getVagueSelect(Map<String, Object> map) {
		return this.excutor.queryForList("manageProspectInfo.getVagueSelect", map);
	}
	/**
	 * 获取一条审核数据
	 * @param map{}
	 * @return PagerResult<ManageProspectInfoModel>
	 */
	public ManageProspectInfoModel getManageProspectInfo(Map<String, Object> map){
		return this.excutor.queryForObject("manageProspectInfo.getVagueSelect", map);
	}
	/**
	 * 跟新
	 * @param map
	 * @return
	 */
	public Integer updateManageProspectInfo(Map<String, Object> map) {
		 return this.excutor.update("manageProspectInfo.updateSelective", map);
	}
}
