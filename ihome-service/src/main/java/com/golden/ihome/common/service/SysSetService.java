package com.golden.ihome.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golden.ihome.common.SysParam;
import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.ihome.crm.service.sysParam.SysParamService;

@Service(value = "sysSetService")
public class SysSetService {
	
	@Resource(name="sysParam/sysParamService")
	private SysParamService sysParamService;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void updateSysConst() throws Exception{
		Map<String, Object> param = new HashMap<String,Object>();
		//客源系统设置
		Map<String, List<SysParameterModel>> sysCustomerInfo = sysParamService.getSysCustomerInfo(param);
		for(String key : sysCustomerInfo.keySet()){
			List<SysParameterModel> list = sysCustomerInfo.get(key);
			if(list == null){
				continue;
			}
			for(SysParameterModel spm : list){
				SysParam.constMap.put(spm.getSysCoustomerType()+spm.getId(), spm.getSysCoustomerDescribe());
			}
		}
		//房源系统设置
		Map<String, List<SysParameterModel>> sysHouseMap = (Map<String, List<SysParameterModel>>)sysParamService.execute(param);
		for(String key : sysHouseMap.keySet()){
			List<SysParameterModel> list = sysHouseMap.get(key);
			if(list == null){
				continue;
			}
			for(SysParameterModel spm : list){
				SysParam.constMap.put(spm.getSysHouseType()+spm.getId(), spm.getSysHouseDescribe());
			}
		}
		//其它系统设置
		List<SysParameterModel> spmList= sysParamService.getSysOtherList(param);
		for(SysParameterModel spm : spmList){
			SysParam.constMap.put(spm.getSysHouseType()+spm.getId(), spm.getSysHouseDescribe());
		}
	}
}
