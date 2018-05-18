package com.golden.ihome.crm.service.sysParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.sysParame.SysParamDao;
import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/***
 * 系统参数
 * @author lb
 * 
 */
@Service("sysParam/sysParamService")
public class SysParamService implements IBaseHandler{

	@Autowired
	private SysParamDao sysParamDao;
	/**
	 * 房源系统参数查询 
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception{
		Map<String,List<SysParameterModel>> map = new HashMap<String,List<SysParameterModel>>();
		List<SysParameterModel> sysHouseList = sysParamDao.getSysHouseAllList();
		for(SysParameterModel item :sysHouseList){
			map.put(item.getSysHouseType(),item.getSysHouseList());
		}
		return map;
	}
	/**
	 * 保存房源系统参数
	 * @return 1成功，2模板已存在
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer saveSysHouseInfo(Map<String, Object> param){
		String sysHouseSort="";
		String operationType="";
		String updateSort="";
		String updateDescribe="";
		String sysHouseId="";
		String sysHouseDescribe = param.get("sysHouseDescribe").toString();
		if(param.get("sysHouseSort")!=null){
			sysHouseSort = param.get("sysHouseSort").toString();
		}
		String sysHouseType = param.get("sysHouseType").toString();
		if(param.get("operationType")!=null){
			operationType = param.get("operationType").toString();
		}
		if(param.get("updateSort")!=null){
			updateSort = param.get("updateSort").toString();
		}
		if(param.get("updateDescribe")!=null){
			updateDescribe = param.get("updateDescribe").toString();
		}
		if(param.get("sysHouseId")!=null){
			sysHouseId = param.get("sysHouseId").toString();
		}
		SysParameterModel resultHouseSort = null;
		SysParameterModel resultHouseDescribe = null;
		int  result = 1;
		if(!sysHouseDescribe.equals(updateDescribe)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("sysHouseType",sysHouseType);
			map.put("sysHouseDescribe",sysHouseDescribe);
			resultHouseDescribe = sysParamDao.getSysHouseInfo(map);
			if(resultHouseDescribe!=null){
				if(resultHouseDescribe.getSysHouseDescribe().equals(sysHouseDescribe)){
				  return result = 2;//描述相同
				}
			}
		}
		if(!sysHouseSort.equals(updateSort)){
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("sysHouseType",sysHouseType);
			map2.put("sysHouseSort",sysHouseSort);
			resultHouseSort = sysParamDao.getSysHouseInfo(map2);	
			if(resultHouseSort!=null){
				if(resultHouseSort.getSysHouseSort().toString().equals(sysHouseSort)){
					return result = 3;//排序相同
				}
			}
		}
		if(resultHouseDescribe==null&&resultHouseSort==null){
			if(operationType.equals("1")){
				sysParamDao.insertSysHouse(param);
			}else{
				if(sysHouseSort.equals("")){
					 SysParameterModel getgetSysHouseCount = sysParamDao.getSysHouseCount(param);
					if(getgetSysHouseCount!=null){
						if(getgetSysHouseCount.getSysCount()==0){
							sysParamDao.insertSysHouse(param);
							return result;//新增保存 一个input
						}
					}
				}
				param.clear();
 				param.put("sysHouseId", sysHouseId);
 				param.put("sysHouseDescribe", sysHouseDescribe);
 				param.put("sysHouseSort", sysHouseSort);
				sysParamDao.updateSysHouse(param);
			}
		}
		return result;
	}
	/**
	 * 获取房源系统参数数据
	 * @param String 
	 * @return  List<SysParameterModel>
	 */
	public List<SysParameterModel> getSysHouseList(Map<String, Object> map){
		return sysParamDao.getSysHouseList(map);
	}
	
	/**
	 * 删除房源系统参数
	 * @param map
	 * @return Integer
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer deleteSysHouse(Map<String, Object> map){
		return sysParamDao.deleteSysHouse(map);
	}
	/**
	 * 分页查询收益分成比例列表
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<SysParameterModel> getGainSharingPage(Map<String, Object> map){
		return sysParamDao.getGainSharingPage(map);
	}
	/**
	 * 分页查询收益分成比例
	 * @param map
	 * @return SysParameterModel
	 */
	public SysParameterModel getGainSharingInfo(Map<String, Object> map){
		return sysParamDao.getGainSharingInfo(map);
	}
	/**
	 * 收益分成比例保存或新增
	 * @param map
	 * @return Integer
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer editGainSharing(Map<String, Object> map){
		String num = map.get("num").toString();
		int result = 1;
		if(num.equals("1")){
			Integer insertGainSharing = sysParamDao.insertGainSharing(map);
			if(insertGainSharing==1){
				result = 2;//保存成功
			}
		}else{
			Integer updateGainSharing = sysParamDao.updateGainSharing(map);
			if(updateGainSharing==1){
				result = 3;//更新成功
			}
		}
		return result;
	}
	/**
	 * 删除收益分成比例
	 * @param map
	 * @return Integer
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer deleteGainSharing(Map<String, Object> map){
		return sysParamDao.deleteGainSharing(map);
	}
	

	/**
	 * 房源客统参数查询 
	 */
	public Map<String,List<SysParameterModel>> getSysCustomerInfo(Map<String, Object> param) throws Exception{
		Map<String,List<SysParameterModel>> map = new HashMap<String,List<SysParameterModel>>();
		List<SysParameterModel> sysCoustomerList = sysParamDao.getSysCustomerAllList();
		for(SysParameterModel item :sysCoustomerList){
			map.put(item.getSysCoustomerType(),item.getSysCoustomerList());
		}
		return map;
	}
	/**
	 * 保存客源系统参数
	 * @return 1成功，2模板已存在
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer saveSysCustomerInfo(Map<String, Object> param){
		String sysCoustomerDescribe = param.get("sysCoustomerDescribe").toString();
		String sysCoustomerSort="";
		String operationType="";
		String updateSort="";
		String updateDescribe="";
		String sysCoustomId="";
		if(param.get("sysCoustomerSort")!=null){
			sysCoustomerSort = param.get("sysCoustomerSort").toString();
		}
		String sysCoustomerType = param.get("sysCoustomerType").toString();
		if(param.get("operationType")!=null){
			operationType = param.get("operationType").toString();
		}
		if(param.get("updateSort")!=null){
			updateSort = param.get("updateSort").toString();
		}
		if(param.get("updateDescribe")!=null){
			updateDescribe = param.get("updateDescribe").toString();
		}
		if(param.get("sysCoustomId")!=null){
			sysCoustomId = param.get("sysCoustomId").toString();
		}
		SysParameterModel resultCoustomerSort = null;
		SysParameterModel resultCoustomerDescribe = null;
		int  result = 1;
		if(!sysCoustomerDescribe.equals(updateDescribe)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("sysCoustomerType",sysCoustomerType);
			map.put("sysCoustomerDescribe",sysCoustomerDescribe);
			resultCoustomerDescribe = sysParamDao.getSysCustomerInfo(map);
			if(resultCoustomerDescribe!=null){
				if(resultCoustomerDescribe.getSysCoustomerDescribe().equals(sysCoustomerDescribe)){
				  return result = 2;//描述相同
				}
			}
		}
		if(!sysCoustomerSort.equals(updateSort)){
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("sysCoustomerType",sysCoustomerType);
			map2.put("sysCoustomerSort",sysCoustomerSort);
			resultCoustomerSort = sysParamDao.getSysCustomerInfo(map2);	
			if(resultCoustomerSort!=null){
				if(resultCoustomerSort.getSysCoustomerSort().toString().equals(sysCoustomerSort)){
					return result = 3;//排序相同
				}
			}
		}
		if(resultCoustomerDescribe==null&&resultCoustomerSort==null){
			if(operationType.equals("1")){
				sysParamDao.insertSysCustomer(param);
			}else{
				if(sysCoustomerSort.equals("")){
					 SysParameterModel getSysCustomerCount = sysParamDao.getSysCustomerCount(param);
					if(getSysCustomerCount!=null){
						if(getSysCustomerCount.getSysCount()==0){
							sysParamDao.insertSysCustomer(param);
							return result;//新增保存 一个input
						}
					}
				}
				param.clear();
				param.put("sysCoustomerSort", sysCoustomerSort);
				param.put("sysCoustomerDescribe", sysCoustomerDescribe);
				param.put("sysCoustomId", sysCoustomId);
				sysParamDao.updateSysCustomer(param);
			}
		}
		return result;
	}
	/**
	 * 经济人跟进提醒
	 * @param map
	 * @return Integer
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer saveSysCustomer(Map<String, Object> param){
		String operationType = param.get("operationType").toString();
		String sysCoustomerSort ="";
		String updateSort ="";
		String sysCoustomerType ="";
		if(param.get("sysCoustomerSort")!=null){
			sysCoustomerSort = param.get("sysCoustomerSort").toString();
		}
		if(param.get("updateSort")!=null){
			updateSort = param.get("updateSort").toString();
		}
		if(param.get("sysCoustomerType")!=null){
			sysCoustomerType = param.get("sysCoustomerType").toString();
		}
		int result = 1;
		if(!sysCoustomerSort.equals(updateSort)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("sysCoustomerType", sysCoustomerType);
			map.put("sysCoustomerSort", sysCoustomerSort);
			SysParameterModel sysCustomerInfo = sysParamDao.getSysCustomerInfo(map);	
			if(sysCustomerInfo!=null){
				if(sysCustomerInfo.getSysCoustomerSort().toString().equals(sysCoustomerSort)){
					return result = 3;//排序相同
				}
			}
		}
		if(operationType.equals("1")){
			sysParamDao.insertSysCustomer(param);
		}else{
			sysParamDao.updateSysCustomer(param);
		}
		return result;
	}
	/**
	 * 新增修改 查看房源电话次数
	 * @param params 
	 *  	sysUpdateDescribe	  修改时职位描述
	 *   	sysCoustomerDescribe  职位描述	
	 *     	sysCoustomerTDescribe 修改次数字符串
	 *      sysCoustomerType  系统参数类型
	 *  	operationType  1 新增 2修改
	 *@return
	*/
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer saveSysCustomerTell(Map<String, Object> param){
		String operationType = param.get("operationType").toString();
		String sysCoustomerDescribe = param.get("sysCoustomerDescribe").toString();
		String sysCoustomerType = param.get("sysCoustomerType").toString();
		String sysUpdateDescribe ="";
		if(param.get("sysUpdateDescribe")!=null){
			sysUpdateDescribe = param.get("sysUpdateDescribe").toString();
		}
		int result = 1;
		if(!sysCoustomerDescribe.equals(sysUpdateDescribe)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("sysCoustomerType", sysCoustomerType);
			map.put("sysCoustomerDescribe", sysCoustomerDescribe);
			SysParameterModel sysCustomerInfo = sysParamDao.getSysCustomerInfo(map);	
			if(sysCustomerInfo!=null){
				if(sysCustomerInfo.getSysCoustomerDescribe().toString().equals(sysCoustomerDescribe)){
					return result = 4;//职位相同
				}
			}
		}
		if(operationType.equals("1")){
			if(sysCoustomerDescribe.equals("3")){
				param.put("sysCoustomerSort", 1);
			}else if(sysCoustomerDescribe.equals("2")){
				param.put("sysCoustomerSort", 2);
			}else if(sysCoustomerDescribe.equals("1")){
				param.put("sysCoustomerSort", 3);
			}
			sysParamDao.insertSysCustomer(param);
		}else{
			sysParamDao.updateSysCustomer(param);
		}
		return result;
	}
	/**
	 * 获取客源系统参数数据
	 * @param String 
	 * @return  List<SysParameterModel>
	 */
	public List<SysParameterModel> getSysCustomerList(Map<String, Object> map){
		return sysParamDao.getSysCustomerList(map);
	}
	/**
	 * 删除客源系统参数
	 * @param map
	 * @return Integer 1成功
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer deleteSysCustomer(Map<String, Object> map){
		return sysParamDao.deleteSysCustomer(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 房源其他参数查询 
	 */
	public Map<String,List<SysParameterModel>> getSysOtherAllList(Map<String, Object> param) throws Exception{
		Map<String,List<SysParameterModel>> map = new HashMap<String,List<SysParameterModel>>();
		List<SysParameterModel> sysOtherList = sysParamDao.getSysOtherAllList();
		for(SysParameterModel item :sysOtherList){
			map.put(item.getSysOtherType(),item.getSysOtherList());
		}
		return map;
	}
	/**
	 * 编辑其他系统参数
	 * @return 1成功，2已存在
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer saveSysOtherInfo(Map<String, Object> param){
		String operationType="";
		String updateSort="";
		String updateDescribe="";
		String sysOtherId="";
		String sysOtherSort="";
		String sysOtherType = param.get("sysOtherType").toString();
		String sysOtherDescribe = param.get("sysOtherDescribe").toString();
		if(param.get("sysOtherSort")!=null){
			sysOtherSort = param.get("sysOtherSort").toString();
		}
		if(param.get("operationType")!=null){
			operationType = param.get("operationType").toString();
		}
		if(param.get("updateSort")!=null){
			updateSort = param.get("updateSort").toString();
		}
		if(param.get("updateDescribe")!=null){
			updateDescribe = param.get("updateDescribe").toString();
		}
		if(param.get("sysOtherId")!=null){
			sysOtherId = param.get("sysOtherId").toString();
		}
		SysParameterModel resultOtherSort = null;
		SysParameterModel resultOtherDescribe = null;
		int  result = 1;
		if(!sysOtherDescribe.equals(updateDescribe)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("sysOtherType",sysOtherType);
			map.put("sysOtherDescribe",sysOtherDescribe);
			resultOtherDescribe = sysParamDao.getSysOtherInfo(map);
			if(resultOtherDescribe!=null){
				if(resultOtherDescribe.getSysOtherDescribe().equals(sysOtherDescribe)){
				  return result = 2;//描述相同
				}
			}
		}
		if(!sysOtherSort.equals(updateSort)){
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("sysOtherType",sysOtherType);
			map2.put("sysOtherSort",sysOtherSort);
			resultOtherSort = sysParamDao.getSysOtherInfo(map2);	
			if(resultOtherSort!=null){
				if(resultOtherSort.getSysOtherSort().toString().equals(sysOtherSort)){
					return result = 3;//排序相同
				}
			}
		}
		if(resultOtherDescribe==null&&resultOtherSort==null){
			if(operationType.equals("1")){
				sysParamDao.insertSysOther(param);
			}else{
				if(sysOtherSort.equals("")){
					 SysParameterModel getSysOtherCount = sysParamDao.getSysOtherInfo(param);
					if(getSysOtherCount!=null){
						if(getSysOtherCount.getSysCount()==0){
							sysParamDao.insertSysOther(param);
							return result;//新增保存 一个input
						}
					}
				}
				param.clear();
				param.put("sysOtherSort", sysOtherSort);
				param.put("sysOtherDescribe", sysOtherDescribe);
				param.put("sysOtherId", sysOtherId);
				sysParamDao.updateSysOther(param);
			}
		}
		return result;
	}
	/**
	 * 获取其他系统参数数据
	 * @param String 
	 * @return  List<SysParameterModel>
	 */
	public List<SysParameterModel> getSysOtherList(Map<String, Object> map){
		return sysParamDao.getSysOtherList(map);
	}
	/**
	 * 删除其他系统参数
	 * @param map
	 * @return Integer 1成功
	 */
	@TM
	@Aop(name="scriptAop",type="around")
	public Integer deleteSysOther(Map<String, Object> map){
		return sysParamDao.deleteSysOther(map);
	}
}
