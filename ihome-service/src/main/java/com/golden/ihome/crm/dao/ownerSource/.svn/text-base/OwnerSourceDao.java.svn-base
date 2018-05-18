package com.golden.ihome.crm.dao.ownerSource;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.OwnerSourceModel;
import com.golden.port.framework.mybatis.IBaseDao;

@Repository(value="ownerSourceDao")
public class OwnerSourceDao extends IBaseDao{

	/**
	 * 业主“来源”的父数据
	 * @return list
	 */
	public List<OwnerSourceModel> getParentSources() {
		return this.excutor.queryForList("ownerSource.getParentSource");
	}
	/**
	 * 业主“来源”的子数据
	 * @return list
	 */
	public List<OwnerSourceModel> getSourcesByParentId(Map<String,Object> map) {
		return this.excutor.queryForList("ownerSource.getSourcesByParentId",map);
	}
	
}
