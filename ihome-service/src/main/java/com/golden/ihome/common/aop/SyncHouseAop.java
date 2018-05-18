package com.golden.ihome.common.aop;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.ctxdll.RoomAddrDao;
import com.golden.port.framework.aop.BaseAop;
import com.golden.port.framework.aop.ProcessPoint;


@Service("syncHouseAop")
public class SyncHouseAop extends BaseAop{

	@Autowired
	private  RoomAddrDao roomAddrDao;

	@Override
	public Object around(ProcessPoint point, Map<String, Object> param)
			throws Exception {
		Object obj;
		for(String key :param.keySet()){
			obj = param.get(key);
			if(obj instanceof String){
				obj = obj.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
				param.put(key,obj.toString());
			}
		}
		obj = point.process();
		if(param.get("isUpdateHouseAddr")!=null){
			new Thread(){
				public void run() {
					roomAddrDao.syncIndex();
				};
			}.run();
		}
		
		return obj;
		
	}
}
