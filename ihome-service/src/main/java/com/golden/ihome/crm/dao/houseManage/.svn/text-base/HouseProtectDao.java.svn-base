package com.golden.ihome.crm.dao.houseManage;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.CustomerManageModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * 房源保护管理
 * @author zhr
 */
@Repository(value = "houseProtectDao")
public class HouseProtectDao extends IBaseDao {

	/**
	 * 分页查询联系人
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerManageModel> getHouseProjectPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseProtect.getHouseProjectPage", map);
	}
	/**
	 * 
	 */
	public Integer cancel(String protectIds){
		return this.excutor.update("houseProtect.cancelProtect", protectIds);
	}
}
