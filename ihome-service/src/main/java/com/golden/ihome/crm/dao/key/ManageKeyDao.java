package com.golden.ihome.crm.dao.key;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.ManageKeyModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="manageKeyDao")
public class ManageKeyDao extends IBaseDao{
	
	/**
	 * 钥匙管理初始化
	 * @param param
	 * @return PagerResult
	 */
	public PagerResult<ManageKeyModel> getManageKeyJQPage(Map<String, Object> param) {
		PagerResult<ManageKeyModel> model = this.excutor.queryListPage("manageKey.getManageKeyPage", param);
		return model;
	}
	
	/**
	 * 钥匙确认
	 * @param param
	 * @return
	 */
	public Integer keyConfirm(Map<String, Object> param){
		return this.excutor.update("manageKey.confirmKey", param);
	}
	
	/**
	 * 钥匙借出
	 * @param param
	 * @return
	 */
	public Integer lendKey(Map<String, Object> param){
		return this.excutor.update("manageKey.lendKey", param);
	}
	
	/**
	 * 钥匙归还
	 * @param param
	 * @return
	 */
	public Integer returnKey(Map<String, Object> param){
		return this.excutor.update("manageKey.returnKey", param);
	}
	
	/**
	 * 钥匙退还
	 * @param param
	 * @return
	 */
	public Integer backKey(Map<String, Object> param){
		return this.excutor.update("manageKey.backKey", param);
	}
	

}
