package com.golden.ihome.crm.service.houseManage;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.houseManage.HouseProtectDao;
import com.golden.port.framework.handleable.IBaseHandler;

@Service("houseManage/protectService")
public class ProtectService implements IBaseHandler {
	@Autowired
	private HouseProtectDao houseProtectDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return houseProtectDao.getHouseProjectPage(param);
	}
	/**
	 * 取消保护
	 * 支持批量操作
	 * 参数:protectIds
	 * @return 
	 */
	public Integer cancel(Map<String, Object> param){
		return houseProtectDao.cancel(param.get("protectIds").toString());
	}
}
