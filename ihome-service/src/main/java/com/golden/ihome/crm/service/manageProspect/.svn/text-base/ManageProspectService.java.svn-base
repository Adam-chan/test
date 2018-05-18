package com.golden.ihome.crm.service.manageProspect;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.manageProspect.ManageProspectDao;
import com.golden.ihome.crm.model.ManageProspectModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

@Service("prospect/manageProspect")
public class ManageProspectService implements IBaseHandler{
	@Autowired
	private ManageProspectDao manageProspectDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 我的实勘列表
	 * @param param
	 * @return PagerResult
	 * @throws Exception 
	 */
	public PagerResult<ManageProspectModel> getManageKeyJQPage(Map<String, Object> param) throws Exception{
		param.put("currentPage", 1);
		param.put("rowCount", 30);
		if(!"".equals(param.get("subTimeStart")) && param.get("subTimeStart")!= null){
			param.put("subTimeStart", DateUtil.getDate(param.get("subTimeStart").toString(),"yyyy-MM-dd"));
		}
		if(!"".equals(param.get("subTimeEnd")) && param.get("subTimeEnd")!= null){
			param.put("subTimeEnd", DateUtil.getDate(param.get("subTimeEnd").toString(),"yyyy-MM-dd"));
		}
		PagerResult<ManageProspectModel> result = manageProspectDao.getManageProspectJQPage(param);
		return result;
	}
	/**
	 * 打假实勘列表
	 * @param param
	 * @return PagerResult
	 * @throws Exception 
	 */
	public PagerResult<ManageProspectModel> getFakeProspectJQPage(Map<String, Object> param) throws Exception{
		param.put("currentPage", 1);
		param.put("rowCount", 30);
		if(!"".equals(param.get("fakeTimeStart")) && param.get("fakeTimeStart")!= null){
			param.put("fakeTimeStart", DateUtil.getDate(param.get("fakeTimeStart").toString(),"yyyy-MM-dd"));
		}
		if(!"".equals(param.get("fakeTimeEnd")) && param.get("fakeTimeEnd")!= null){
			param.put("fakeTimeEnd", DateUtil.getDate(param.get("fakeTimeEnd").toString(),"yyyy-MM-dd"));
		}
		PagerResult<ManageProspectModel> result = manageProspectDao.getFakeProspectJQPage(param);
		return result;
	}
}
