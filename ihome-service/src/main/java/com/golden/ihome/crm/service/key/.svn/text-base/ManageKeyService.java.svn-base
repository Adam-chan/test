package com.golden.ihome.crm.service.key;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.key.ManageKeyDao;
import com.golden.ihome.crm.model.ManageKeyModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

@Service("key/manageKey")
public class ManageKeyService implements IBaseHandler {

	@Autowired
	private ManageKeyDao manageKeyDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return null;
	}
	
	/**
	 * 钥匙管理初始化
	 * @param param
	 * @return PagerResult
	 * @throws Exception 
	 */
	public PagerResult<ManageKeyModel> getManageKeyJQPage(Map<String, Object> param) throws Exception{
		param.put("currentPage", 1);
		param.put("rowCount", 30);
		if(!"".equals(param.get("takeBackStart")) && param.get("takeBackStart")!= null){
			param.put("takeBackStart", DateUtil.getDate(param.get("takeBackStart").toString(),"yyyy-MM-dd"));
		}
		if(!"".equals(param.get("takeBackEnd")) && param.get("takeBackEnd")!=null){
			param.put("takeBackEnd", DateUtil.getDate(param.get("takeBackEnd").toString(),"yyyy-MM-dd"));
		}
		if(!"".equals(param.get("lendStart")) && param.get("lendStart")!=null){
			param.put("lendStart", DateUtil.getDate(param.get("lendStart").toString(),"yyyy-MM-dd"));
		}
		if(!"".equals(param.get("lendEnd")) && param.get("lendEnd")!=null){
			param.put("lendEnd", DateUtil.getDate(param.get("lendEnd").toString(),"yyyy-MM-dd"));
		}
		if(!"".equals(param.get("returnStart")) && param.get("returnStart")!=null){
			param.put("returnStart", DateUtil.getDate(param.get("returnStart").toString(),"yyyy-MM-dd"));
		}
		if(!"".equals(param.get("returnEnd")) && param.get("returnEnd")!=null){
			param.put("returnEnd", DateUtil.getDate(param.get("returnEnd").toString(),"yyyy-MM-dd"));
		}
		PagerResult<ManageKeyModel> result = manageKeyDao.getManageKeyJQPage(param);
		return result;
	}
	
	/**
	 * 钥匙确认
	 * @param param
	 * @return
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer keyConfirm(Map<String, Object> param){
		return manageKeyDao.keyConfirm(param);
	}
	
	/**
	 * 钥匙借出
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer lendKey(Map<String, Object> param) throws Exception{
		param.put("lendStart", DateUtil.getDate(param.get("lendStart").toString(),"yyyy-MM-dd"));
		param.put("lendEnd", DateUtil.getDate(param.get("lendEnd").toString(),"yyyy-MM-dd"));
		return manageKeyDao.lendKey(param);
	}
	
	/**
	 * 钥匙归还
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer returnKey(Map<String, Object> param) throws Exception{
		return manageKeyDao.returnKey(param);
	}
	
	/**
	 * 钥匙退还
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer backKey(Map<String, Object> param) throws Exception{
		param.put("backTime", DateUtil.getDate(param.get("backTime").toString(),"yyyy-MM-dd"));
		return manageKeyDao.backKey(param);
	}

}
