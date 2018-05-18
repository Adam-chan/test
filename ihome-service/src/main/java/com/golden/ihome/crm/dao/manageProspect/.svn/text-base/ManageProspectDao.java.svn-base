package com.golden.ihome.crm.dao.manageProspect;

import java.util.Map;

import org.springframework.stereotype.Repository;
import com.golden.ihome.crm.model.ManageProspectModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository("manageProspectDao")
public class ManageProspectDao extends IBaseDao {
	/**
	 * 我的实勘列表初始化
	 * @param param
	 * @return PagerResult
	 */
	public PagerResult<ManageProspectModel> getManageProspectJQPage(Map<String, Object> param) {
		PagerResult<ManageProspectModel> model = this.excutor.queryListPage("manageProspect.getProspectPage", param);
		return model;
	}
	
	/**
	 * 被打假实勘列表初始化
	 * @param param
	 * @return PagerResult
	 */
	public PagerResult<ManageProspectModel> getFakeProspectJQPage(Map<String, Object> param) {
		PagerResult<ManageProspectModel> model = this.excutor.queryListPage("manageProspect.getFakeProspectPage", param);
		return model;
	}
}
