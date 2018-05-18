package com.golden.ihome.crm.service.house;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.common.CodeConst;
import com.golden.ihome.common.service.CommonCode;
import com.golden.ihome.crm.dao.house.ManageRentContractDao;
import com.golden.ihome.crm.model.ManageRentContractModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;
/**
 * @author lazy
 * 类名称：普租签约管理Service
 * 类描述：普租签约表的数据访问
 * 日          期：2016-11-24
 */
@Service("house/manageRentContractService")
public class ManageRentContractService implements IBaseHandler{
	@Autowired
	private ManageRentContractDao manageRentContractDao;
	
	@Resource(name="commonCode")
	private CommonCode commonCode;
	/**
	 * 
	 * @param map{houseInfoId：房源主表id}
	 * @return list<ManageRentContractModel>
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return  manageRentContractDao.getManageRentContract(param);
	}
	
	/**
	 * 插入限普租合同
	 * @param map{ManageRentContractModel：实体的所有字段有选择插入}
	 * @return Integer 大于0 成功  小于0失败
	 * @throws Exception 
	 */
	public Integer insertManageRentContract(Map<String, Object> map) throws Exception {
		map.put("hireStartTime", DateUtil.getDate(map.get("hireStartTime").toString(), "yyyy-MM-dd"));
		map.put("hireEndTime", DateUtil.getDate(map.get("hireEndTime").toString(), "yyyy-MM-dd"));
		return manageRentContractDao.insertManageRentContract(map);
	}
	
	/**
	 * 根据房源id获取房源所在的区县
	 * @param map{houseInfoId：房源主表id}
	 * @return list<ManageRentContractModel>
	 */
	public  ManageRentContractModel getCounty(Map<String, Object> map) {
		return manageRentContractDao.getCounty(map);
	}
	
	/**
	 * 根据普租合同id修改普租合同
	 * @param map{houseInfoId：房源主表id}
	 * @return list<ManageRentContractModel>
	 * @throws Exception 
	 */
	public Integer updateManageRentContract(Map<String, Object> map) throws Exception {
		map.put("hireStartTime", DateUtil.getDate(map.get("hireStartTime").toString(), "yyyy-MM-dd"));
		map.put("hireEndTime", DateUtil.getDate(map.get("hireEndTime").toString(), "yyyy-MM-dd"));
		return manageRentContractDao.updateManageRentContract(map);
	}
	
	/**
	 * 获取普租编码
	 * @throws Exception 
	 */
	@TM
	public String getCode() throws Exception{
		return commonCode.getCode(CodeConst.MANAGE_RENT_CONTRACT_CODE);
	}
}
