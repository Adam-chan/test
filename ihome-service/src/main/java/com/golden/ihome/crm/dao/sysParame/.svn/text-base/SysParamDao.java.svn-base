package com.golden.ihome.crm.dao.sysParame;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="sysParamDao")
public class SysParamDao  extends IBaseDao{

	/**
	 * 获取房源系统参数List
	 * 
	 */
	public List<SysParameterModel> getSysHouseAllList(){
		return this.excutor.queryForList("sysParam.getSysHouseAllList");
	}
	/**
	 * 获取房源系统参数List
	 * 
	 */
	public List<SysParameterModel> getSysHouseList(Map<String,Object> map){
		return this.excutor.queryForList("sysParam.getSysHouseList",map);
	}
	/**
	 * 查询数量
	 */
	public SysParameterModel getSysHouseCount(Map<String, Object> map){
		return this.excutor.queryForObject("sysParam.getSysHouseCount",map);
	}
	/**
	 * 获取房源系统参数
	 * 
	 */
	public SysParameterModel getSysHouseInfo(Map<String, Object> map){
		return this.excutor.queryForObject("sysParam.getSysHouseList",map);
	}
	/**
	 * 插入房源系统参数
	 * 
	 */
	public Integer insertSysHouse(Map<String, Object> map){
		return this.excutor.insert("sysParam.insertSysHouse",map);
	}
	/**
	 * 更新房源系统参数
	 * 
	 */
	public Integer updateSysHouse(Map<String, Object> map){
		return this.excutor.update("sysParam.updateSysHouse",map);
	}
	/**
	 * 删除房源系统参数
	 */
	public Integer deleteSysHouse(Map<String, Object> map){
		return this.excutor.delete("sysParam.deleteSysHouse",map);
	}
	/**
	 * 分页查询收益分成比例
	 * @param map
	 * @return
	 */
	public PagerResult<SysParameterModel> getGainSharingPage(Map<String, Object> map){
		return this.excutor.queryListPage("sysParam.getGainSharingPage", map);
	}
	/**
	 * 获取查询收益分成比例
	 * 
	 */
	public SysParameterModel getGainSharingInfo(Map<String, Object> map){
		return this.excutor.queryForObject("sysParam.getGainSharingInfo",map);
	}
	/**
	 * 新增收益分成比例参数
	 */
	public Integer insertGainSharing(Map<String, Object> map){
		return this.excutor.insert("sysParam.insertGainSharing",map);
	}
	/**
	 * 修改收益分成比例参数
	 */
	public Integer updateGainSharing(Map<String, Object> map){
		return this.excutor.update("sysParam.updateGainSharing",map);
	}
	/**
	 * 删除收益分成比例参数
	 */
	public Integer deleteGainSharing(Map<String, Object> map){
		return this.excutor.delete("sysParam.deleteGainSharing",map);
	}

	/**
	 * 获取客源系统参数List
	 * 
	 */
	public List<SysParameterModel> getSysCustomerAllList(){
		return this.excutor.queryForList("sysParam.getSysCustomerAllList");
	}
	/**
	 * 获取客源系统参数List
	 * 
	 */
	public List<SysParameterModel> getSysCustomerList(Map<String, Object> map){
		return this.excutor.queryForList("sysParam.getSysCustomerList",map);
	}
	/**
	 * 获取客源系统参数
	 * 
	 */
	public SysParameterModel getSysCustomerInfo(Map<String, Object> map){
		return this.excutor.queryForObject("sysParam.getSysCustomerList",map);
	}
	/**
	 * 插入客源系统参数
	 * 
	 */
	public Integer insertSysCustomer(Map<String, Object> map){
		return this.excutor.insert("sysParam.insertSysCustomer",map);
	}
	/**
	 * 更新客源系统参数
	 * 
	 */
	public Integer updateSysCustomer(Map<String, Object> map){
		return this.excutor.update("sysParam.updateSysCustomer",map);
	}
	/**
	 * 删除客源系统参数
	 */
	public Integer deleteSysCustomer(Map<String, Object> map){
		return this.excutor.delete("sysParam.deleteSysCustomer",map);
	}
	/**
	 * 查询数量
	 */
	public SysParameterModel getSysCustomerCount(Map<String, Object> map){
		return this.excutor.queryForObject("sysParam.getSysCustomerCount",map);
	}
	
	
	
	
	/**
	 * 获取其他系统参数List
	 * 
	 */
	public List<SysParameterModel> getSysOtherAllList(){
		return this.excutor.queryForList("sysParam.getSysOtherAllList");
	}
	/**
	 * 获取其他系统参数List
	 * 
	 */
	public List<SysParameterModel> getSysOtherList(Map<String,Object> map){
		return this.excutor.queryForList("sysParam.getSysOtherList",map);
	}
	/**
	 * 查询数量
	 */
	public SysParameterModel getSysOtherCount(Map<String, Object> map){
		return this.excutor.queryForObject("sysParam.getSysOtherCount",map);
	}
	/**
	 * 获取其他系统参数
	 * 
	 */
	public SysParameterModel getSysOtherInfo(Map<String, Object> map){
		return this.excutor.queryForObject("sysParam.getSysOtherList",map);
	}
	/**
	 * 插入其他系统参数
	 * 
	 */
	public Integer insertSysOther(Map<String, Object> map){
		return this.excutor.insert("sysParam.insertSysOther",map);
	}
	/**
	 * 更新其他系统参数
	 * 
	 */
	public Integer updateSysOther(Map<String, Object> map){
		return this.excutor.update("sysParam.updateSysOther",map);
	}
	/**
	 * 删除其他系统参数
	 */
	public Integer deleteSysOther(Map<String, Object> map){
		return this.excutor.delete("sysParam.deleteSysOther",map);
	}
}
