package com.golden.ihome.common.aop;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.road.RoadDao;
import com.golden.port.framework.aop.BaseAop;
import com.golden.port.framework.aop.ProcessPoint;

@Service("syncRoadAop")
public class SyncRoadAop extends BaseAop {
	
	@Autowired
	private  RoadDao roadDao;
	
	@Override
	public void after(Map<String, Object> param, Object reutrnValue) {
		new Thread(){
			public void run() {
				roadDao.syncIndex();
			};
		}.run();
		
	}
	@Override
	public Object around(ProcessPoint point, Map<String, Object> param)throws Exception {
		before(param);
		Object obj = point.process();
		after(param, obj);
		return obj;
	}
	@Override
	public void before(Map<String, Object> param) {
		// TODO Auto-generated method stub
		Object obj;
		for(String key :param.keySet()){
			obj = param.get(key);
			if(obj instanceof String){
				obj = obj.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
				param.put(key,obj.toString());
			}
		}
	}
	
	
}
