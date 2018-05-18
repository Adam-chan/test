package com.golden.ihome.crm.service.ownerSource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.ownerSource.OwnerSourceDao;
import com.golden.ihome.crm.model.OwnerSourceModel;
import com.golden.port.framework.handleable.IBaseHandler;

@Service("ownerSource/ownerSourceService")
public class OwnerSourceService implements IBaseHandler{

	@Autowired
	private OwnerSourceDao ownerSourceDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 业主“来源”的父数据
	 * @return 
	 */
	public List<OwnerSourceModel> getParentSources(){
		return ownerSourceDao.getParentSources();
	}
	/**
	 * 业主“来源”的子数据
	 * @param parentId 父id 
	 * @return
	 */
	public List<OwnerSourceModel> getSourcesByParentId(Map<String,Object> map){
		return ownerSourceDao.getSourcesByParentId(map);
	}

}
