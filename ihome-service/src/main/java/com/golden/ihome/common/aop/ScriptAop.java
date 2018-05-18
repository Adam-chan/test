package com.golden.ihome.common.aop;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golden.ihome.common.service.SysSetService;
import com.golden.port.framework.aop.BaseAop;
import com.golden.port.framework.aop.ProcessPoint;

@Service("scriptAop")
public class ScriptAop extends BaseAop {
	
	
	@Resource(name="sysSetService")
	private SysSetService sysSetService;
	
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
	/**
	 * 环绕横切，执行前js脚本过滤，执行后更新缓存
	 * 
	 */
	@Override
	public Object around(ProcessPoint point, Map<String, Object> param)
			throws Exception {
		//before(param);
		//adflaj///
		Object resultObj = point.process();
		//只要执行，则全部清空
		new Thread(){
	         public void run() {
	        	 try {
					sysSetService.updateSysConst();
				} catch (Exception e) {
					
				}
	         }
		}.start();
		
		return resultObj;
	}
}
