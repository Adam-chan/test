package com.golden.ihome.addr.dao.operate;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.OperateModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="operateDao")
public class OperateDao extends IBaseDao{

	/**
	 * 楼盘列表  
	 * @param map
	 * @return
	 */
	public PagerResult<OperateModel> getPremisesAddrForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("operate.getPremisesAddrForPage", map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//***********************************************************************************
	/**
	 * 分页查询楼盘的经营范围分配(买卖) 列表 sy  
	 * @param map
	 * @return
	 */
	public PagerResult<OperateModel> getOperateSaleListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("operate.getOperateSaleListForPage", map);
	}

}
